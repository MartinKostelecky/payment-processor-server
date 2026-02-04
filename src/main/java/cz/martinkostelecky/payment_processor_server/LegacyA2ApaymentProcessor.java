package cz.martinkostelecky.payment_processor_server;

import cz.martinkostelecky.payment_processor_server.service.LegacyA2ApaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class LegacyA2ApaymentProcessor implements A2ApaymentAdapter {

    private final LegacyA2ApaymentService service;

    @Override
    public void processPayment(BigDecimal amount) {
        service.makePayment(amount.doubleValue());
    }
}
