package cz.martinkostelecky.payment_processor_server.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class BalanceResponse {

    private BigDecimal balance;
}
