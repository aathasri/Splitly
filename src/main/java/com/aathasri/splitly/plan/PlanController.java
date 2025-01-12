package com.aathasri.splitly.plan;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.Currency;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/plan")
public class PlanController {

    private final PlanService planService;

    @Autowired
    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @GetMapping
    public List<Plan> getPlans() {
        return planService.getPlans();
    }

    @PostMapping
    public void registerNewPlan(@Valid @RequestBody Plan plan) {
        planService.addNewPlan(plan);
    }

    @DeleteMapping(path = "{planId}")
    public void deletePlan(@PathVariable("planId") Long planId) {
        //enforce not null etc
        planService.deletePlan(planId);
    }

    @PutMapping(path = "{planId}")
    public void updatePlan(
            @PathVariable("planId") Long planId,
            @Valid @RequestBody Plan plan) {
        planService.updatePlan(planId, plan);
    }
}
