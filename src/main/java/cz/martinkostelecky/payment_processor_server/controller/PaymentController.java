package cz.martinkostelecky.payment_processor_server.controller;

import cz.martinkostelecky.payment_processor_server.PaymentRequest;
import cz.martinkostelecky.payment_processor_server.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping("/send-payment-page")
    public ResponseEntity<Void> getPaymentPage() {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/process-payment")
    public ResponseEntity<Void> processPayment(@RequestBody PaymentRequest request) {
        paymentService.processPayment(request.getAmount(), request.getPaymentMethod());
        return ResponseEntity.ok().build();
    }
}
