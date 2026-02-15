package cz.martinkostelecky.payment_processor_server.controller;

import cz.martinkostelecky.payment_processor_server.PaymentRequest;
import cz.martinkostelecky.payment_processor_server.dto.BalanceResponse;
import cz.martinkostelecky.payment_processor_server.dto.PaymentResponse;
import cz.martinkostelecky.payment_processor_server.service.AccountService;
import cz.martinkostelecky.payment_processor_server.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
@CrossOrigin(origins = "*")
public class PaymentController {

    private final PaymentService paymentService;
    private final AccountService accountService;

    @PostMapping("/process-payment")
    public ResponseEntity<PaymentResponse> processPayment(@RequestBody PaymentRequest request) {
        paymentService.processPayment(request.getAmount(), request.getPaymentMethod());

        BigDecimal newBalance = accountService.getBalance();

        PaymentResponse response =PaymentResponse.builder()
                .amount(request.getAmount())
                .paymentMethod(request.getPaymentMethod())
                .newBalance(newBalance)
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/balance")
    public ResponseEntity<BalanceResponse> getBalance() {

        BalanceResponse response = BalanceResponse.builder()
                .balance(accountService.getBalance())
                .build();

        return ResponseEntity.ok(response);
    }
}
