package com.aathasri.splitly.plan;

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
    public void registerNewPlan(@RequestBody Plan plan) {
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
            @RequestParam(required = false) String name,
            @RequestParam(required = false) BigDecimal monthlyPrice,
            @RequestParam(required = false) Currency currency,
            @RequestParam(required = false) LocalDate paymentDate,
            @RequestParam(required = false) Period paymentInterval) {
        planService.updatePlan(planId, name, monthlyPrice, currency, paymentDate, paymentInterval);
    }
}
