package cz.martinkostelecky.payment_processor_server;

import cz.martinkostelecky.payment_processor_server.service.AccountService;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class A2ApaymentStrategy implements PaymentStrategy {

    private final A2ApaymentAdapter a2ApaymentAdapter;
    private final AccountService accountService;

    @Override
    public void pay(BigDecimal amount) {
        a2ApaymentAdapter.processPayment(amount);
        accountService.credit(amount);
    }

    @Override
    public PaymentMethod getMethod() {
        return PaymentMethod.A2A;
    }
}
