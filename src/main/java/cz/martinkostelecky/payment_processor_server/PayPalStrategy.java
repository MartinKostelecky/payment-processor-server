package cz.martinkostelecky.payment_processor_server;

import cz.martinkostelecky.payment_processor_server.service.AccountService;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class PayPalStrategy implements PaymentStrategy {

    private final AccountService accountService;

    @Override
    public void pay(BigDecimal amount) {
        accountService.credit(amount);
    }

    @Override
    public PaymentMethod getMethod() {
        return PaymentMethod.PAYPAL;
    }
}
