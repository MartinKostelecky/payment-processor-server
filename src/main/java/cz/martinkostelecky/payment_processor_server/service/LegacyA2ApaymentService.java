package cz.martinkostelecky.payment_processor_server.service;

import lombok.extern.slf4j.Slf4j;


/**
 * simulation of legacy code
 */
@Slf4j
public class LegacyA2ApaymentService {

    public void makePayment(Double amount) {
        log.info("Sending CZK {} to e-shop account", amount);

    }
}
