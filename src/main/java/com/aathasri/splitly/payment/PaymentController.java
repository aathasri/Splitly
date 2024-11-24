package com.aathasri.splitly.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
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
    public void registerNewPayment(@RequestBody Payment payment) {
        paymentService.addNewPayment(payment);
    }

    @DeleteMapping(path = "{paymentId}")
    public void deletePayment(@PathVariable("paymentId") Long paymentId) {
        paymentService.deletePayment(paymentId);
    }

    @PutMapping(path = "{paymentId")
    public void updatePayment(@PathVariable("paymentId") Long paymentId,
                              @RequestParam(required = false) Long payerId,
                              @RequestParam(required = false) Long recipientId,
                              @RequestParam(required = false) Long planId,
                              @RequestParam(required = false) BigDecimal amount,
                              @RequestParam(required = false) LocalDate date,
                              @RequestParam(required = false) String method,
                              @RequestParam(required = false) PaymentStatus status,
                              @RequestParam(required = false) Boolean toPlan
                              ) {
        paymentService.updatePayment(paymentId, payerId, recipientId, planId, amount, date, method, status, toPlan);
    }

}
