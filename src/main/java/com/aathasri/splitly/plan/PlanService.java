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
import java.util.Optional;

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

    public Boolean existsByPlanId(Long planId){
        return planRepository.existsById(planId);
    }

    public Plan getPlan(Long planId) {
        Optional<Plan> plan = planRepository.findById(planId);
        if (plan.isEmpty()) {
            throw new PlanNotFoundException("Plan does not exist");
        }
        return plan.get();
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
    public void updatePlan(Long planId, Plan updatedPlan) {
        Plan originaPlan = planRepository.findById(planId).orElseThrow(() -> new IllegalStateException(
                "plan with id " + planId + " does not exist"
        ));

        originaPlan.copyFrom(updatedPlan);
    }
}
