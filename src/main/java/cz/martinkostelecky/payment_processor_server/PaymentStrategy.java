package cz.martinkostelecky.payment_processor_server;

import java.math.BigDecimal;

public interface PaymentStrategy {

    void pay(BigDecimal amount);
    PaymentMethod getMethod();
}
