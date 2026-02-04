package cz.martinkostelecky.payment_processor_server;

import cz.martinkostelecky.payment_processor_server.service.AccountService;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

@Component
public class PaymentStrategyFactory {

    private final Map<PaymentMethod, PaymentStrategy> strategyMap;

    public PaymentStrategyFactory(A2ApaymentAdapter a2aPaymentAdapter,
                                  AccountService accountService) {
        strategyMap = new EnumMap<>(PaymentMethod.class);

        strategyMap.put(PaymentMethod.A2A, new A2ApaymentStrategy(a2aPaymentAdapter, accountService));
        strategyMap.put(PaymentMethod.CREDIT_CARD, new CreditCardStrategy(accountService));
        strategyMap.put(PaymentMethod.PAYPAL, new PayPalStrategy(accountService));
    }

    public PaymentStrategy getStrategy(PaymentMethod paymentMethod) {
        return strategyMap.get(paymentMethod);
    }
}
