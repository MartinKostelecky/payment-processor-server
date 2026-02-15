package cz.martinkostelecky.payment_processor_server.service;

import cz.martinkostelecky.payment_processor_server.PaymentMethod;
import cz.martinkostelecky.payment_processor_server.PaymentStrategyFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
public class PaymentService {

    private final PaymentStrategyFactory paymentStrategyFactory;

    public void processPayment(BigDecimal amount, PaymentMethod paymentMethod) {
        paymentStrategyFactory.getStrategy(paymentMethod).pay(amount);
        log.info("Payment {} CZK via {} processed.", amount, paymentMethod);
    }
}
