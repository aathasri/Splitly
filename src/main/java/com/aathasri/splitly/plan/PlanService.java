package com.aathasri.splitly.plan;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.Currency;
import java.util.Objects;

@Service
public class PlanService {

private final PlanRepository planRepository;

    @Autowired
    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public List<Plan> getPlans() {
        return planRepository.findAll();
    }

    public void addNewPlan(Plan plan) {
        planRepository.save(plan);
    }

    public void deletePlan(Long planId) {
        boolean exists = planRepository.existsById(planId);
        if (!exists) {
            throw new IllegalStateException("plan with id " + planId + " does not exists");
        }
        planRepository.deleteById(planId);
    }

    @Transactional
    public void updatePlan(Long planId, String name, BigDecimal monthlyPrice, Currency currency, LocalDate paymentDate, Period paymentInterval) {
        Plan plan = planRepository.findById(planId).orElseThrow(() -> new IllegalStateException(
                "plan with id " + planId + " does not exist"
        ));

        if (name != null && !name.isEmpty() && !Objects.equals(plan.getName(), name)) {
            plan.setName(name);
        }

        if (monthlyPrice != null && monthlyPrice.compareTo(BigDecimal.ZERO) < 0) {
            plan.setMonthlyPrice(monthlyPrice);
        }

        if (currency != null) {
            plan.setCurrency(currency);
        }

        if (paymentDate != null) {
            plan.setPaymentDate(paymentDate);
        }

        if (paymentInterval != null) {
            plan.setPaymentInterval(paymentInterval);
        }
    }
}
