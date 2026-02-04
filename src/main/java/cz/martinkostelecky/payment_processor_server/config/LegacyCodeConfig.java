package cz.martinkostelecky.payment_processor_server.config;

import cz.martinkostelecky.payment_processor_server.service.LegacyA2ApaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LegacyCodeConfig {

    @Bean
    public LegacyA2ApaymentService getLegacyA2ApaymentService() {
        return new LegacyA2ApaymentService();
    }
}
