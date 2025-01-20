package com.aathasri.splitly.service;

import com.aathasri.splitly.exception.ValidationException;
import com.aathasri.splitly.model.Payment;
import com.aathasri.splitly.repository.PaymentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final UserService userService;
    private final PlanService planService;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository, UserService userService, PlanService planService) {
        this.paymentRepository = paymentRepository;
        this.userService = userService;
        this.planService = planService;
    }

    public List<Payment> getPayments() {
        return paymentRepository.findAll();
    }

    public void addNewPayment(Payment newPayment) {

        validatePayment(newPayment);

        paymentRepository.save(newPayment);
    }

    public void deletePayment(Long paymentId) {
        paymentRepository.deleteById(paymentId);
    }

    @Transactional
    public void updatePayment(Long paymentId,
                              Payment updatedPayment) {
        Payment originalPayment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new IllegalStateException(
                        "payment with id " + " does not exist"
                ));

        validatePayment(updatedPayment);

        originalPayment.copyFrom(updatedPayment);
    }

    private void validatePayment(Payment payment) {
        ValidationException ve = new ValidationException();

        if (!userService.existUserById(payment.getPayerId())) {
            ve.addErrors("payer with user id " + payment.getPayerId() + " does not exist");
        }

        if (!userService.existUserById(payment.getRecipientId())) {
            ve.addErrors("recipient with user id " +  payment.getRecipientId() + " does not exist");
        }

        if (!planService.existsByPlanId(payment.getPlanId())) {
            ve.addErrors("plan with id " + payment.getPlanId() + " does not exist");
        }

        if (ve.hasErrors()) {
            throw ve;
        }
    }
}
