package cz.martinkostelecky.payment_processor_server;

import java.math.BigDecimal;

public interface A2ApaymentAdapter {

    void processPayment(BigDecimal amount);
}
