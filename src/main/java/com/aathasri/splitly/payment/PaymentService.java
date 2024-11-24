package com.aathasri.splitly.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class PaymentService {

    private PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> getPayments() {
        return paymentRepository.findAll();
    }

    public void addNewPayment(Payment payment) {
        paymentRepository.save(payment);
    }

    public void deletePayment(Long paymentId) {
        paymentRepository.deleteById(paymentId);
    }

    public void updatePayment(Long paymentId, Long payerId, Long recipientId, Long planId, BigDecimal amount, LocalDate date, String method, PaymentStatus status, Boolean toPlan) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new IllegalStateException(
                        "payment with id " + " does not exist"
                ));

        if (payerId != null && payerId > 0 && !Objects.equals(payment.getPayerId(), payerId)) {
            //TODO check that user with this id exists
            payment.setPayerId(payerId);
        }

        if (recipientId != null && recipientId > 0 && !Objects.equals(payment.getRecipientId(), recipientId)) {
            //TODO check that user with this id exists
            payment.setRecipientId(recipientId);
        }

        if (planId != null && planId > 0 && !Objects.equals(payment.getPlanId(), planId)) {
            //TODO check that this plan exists
            payment.setPlanId(planId);
        }

        if (amount != null && amount.compareTo(BigDecimal.ZERO) < 0) {
            payment.setAmount(amount);
        }

        if (date != null && !date.equals(payment.getDate())) {
            if (date.isAfter(LocalDate.now())) {
                throw new IllegalStateException("payment date cannot be in the future");
            }
            payment.setDate(date);
        }

        if (method != null && !method.isEmpty() && !Objects.equals(payment.getMethod(), method)) {
            //TODO Set limit to length
            payment.setMethod(method);
        }

        if (status != null && !status.equals(payment.getStatus())) {
            payment.setStatus(status);
        }

        if(toPlan != null && !toPlan.equals(payment.getToPlan())) {
            payment.setToPlan(toPlan);
        }

    }

}
