package cz.martinkostelecky.payment_processor_server;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Account {

    private BigDecimal balance = BigDecimal.ZERO;

    public synchronized void credit(BigDecimal amount) {
        balance = balance.add(amount);
    }

}
