package com.aathasri.splitly.payment;

import com.aathasri.splitly.common.ValidationException;
import com.aathasri.splitly.plan.PlanService;
import com.aathasri.splitly.user.UserService;
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

    public void addNewPayment(PaymentDTO paymentDTO) {

        validatePayment(paymentDTO.getPayerId(), paymentDTO.getRecipientId(), paymentDTO.getPlanId());

        Payment payment = new Payment();

        payment = new Payment(paymentDTO);

        paymentRepository.save(payment);
    }

    public void deletePayment(Long paymentId) {
        paymentRepository.deleteById(paymentId);
    }

    @Transactional
    public void updatePayment(Long paymentId,
                              PaymentDTO updatedPayment) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new IllegalStateException(
                        "payment with id " + " does not exist"
                ));

        validatePayment(updatedPayment.getPayerId(),
                updatedPayment.getRecipientId(),
                updatedPayment.getPlanId());

        // TODO: make validation so that date is not in the future

        payment = new Payment(updatedPayment);

        paymentRepository.save(payment);
    }

    private void validatePayment(Long payerId,
                                 Long recipientId,
                                 Long planId) {
        ValidationException ve = new ValidationException();

        if (!userService.existUserById(payerId)) {
            ve.addErrors("payer with user id " + payerId + " does not exist");
        }

        if (!userService.existUserById(recipientId)) {
            ve.addErrors("recipient with user id " +  recipientId + " does not exist");
        }

        if (!planService.existsByPlanId(planId)) {
            ve.addErrors("plan with id " + planId + " does not exist");
        }

        if (ve.hasErrors()) {
            throw ve;
        }
    }
}
