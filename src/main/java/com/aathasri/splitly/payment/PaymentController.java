package com.aathasri.splitly.payment;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/payment")
public class PaymentController {

    @GetMapping
    public List<Payment> getPayments() {

    }

    @PostMapping
    public void registerNewPayment() {

    }

    @DeleteMapping(path = "{paymentId}")
    public void deletePayment() {

    }

    @PutMapping(path = "{paymentId")
    public void updatePayment() {

    }

}
