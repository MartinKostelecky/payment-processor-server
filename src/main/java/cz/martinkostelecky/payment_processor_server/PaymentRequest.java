package cz.martinkostelecky.payment_processor_server;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class PaymentRequest {

    private BigDecimal amount;
    private PaymentMethod paymentMethod;
}
