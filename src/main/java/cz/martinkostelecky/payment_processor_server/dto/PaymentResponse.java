package cz.martinkostelecky.payment_processor_server.dto;

import cz.martinkostelecky.payment_processor_server.PaymentMethod;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public class PaymentResponse {

    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    private BigDecimal newBalance;
}
