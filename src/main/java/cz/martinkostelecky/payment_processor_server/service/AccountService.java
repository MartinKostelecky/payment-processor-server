package cz.martinkostelecky.payment_processor_server.service;

import cz.martinkostelecky.payment_processor_server.Account;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountService {

    Account account = new Account();

    public void credit(BigDecimal amount) {
        account.credit(amount);
    }

    public BigDecimal getBalance() {
        return account.getBalance();
    }
}
