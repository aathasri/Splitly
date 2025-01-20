package com.aathasri.splitly.controller;

import com.aathasri.splitly.model.Payment;
import com.aathasri.splitly.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public List<Payment> getPayments() {
        return paymentService.getPayments();
    }

    @PostMapping
    public void registerNewPayment(@Valid @RequestBody Payment payment) {
        paymentService.addNewPayment(payment);
    }

    @DeleteMapping(path = "{paymentId}")
    public void deletePayment(@PathVariable("paymentId") Long paymentId) {
        paymentService.deletePayment(paymentId);
    }

    @PutMapping(path = "{paymentId}")
    public void updatePayment(@PathVariable("paymentId") Long paymentId,
                              @Valid @RequestBody Payment payment) {
        paymentService.updatePayment(paymentId, payment);
    }

}
