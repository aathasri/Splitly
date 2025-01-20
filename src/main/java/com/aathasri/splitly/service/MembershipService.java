package com.aathasri.splitly.service;

import com.aathasri.splitly.exception.ValidationException;
import com.aathasri.splitly.model.Membership;
import com.aathasri.splitly.model.Plan;
import com.aathasri.splitly.repository.MembershipRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class MembershipService {

    private final MembershipRepository membershipRepository;
    private final UserService userService;
    private final PlanService planService;

    @Autowired
    public MembershipService(MembershipRepository membershipRepository, UserService userService, PlanService planService) {
        this.membershipRepository = membershipRepository;
        this.userService = userService;
        this.planService = planService;
    }

    public List<Membership> getMemberships() {
        return membershipRepository.findAll();
    }

    public void addNewMembership(Membership membership) {

        validateMembership(membership);

        updatePlanOfMembership(membership, true);

        membershipRepository.save(membership);

        updateAllMembersOfPlan(membership);

    }

    public void deleteMembership(Long membershipId) {
        boolean exists = membershipRepository.existsById(membershipId);
        if (!exists) {
            throw new IllegalStateException("membership with id " + membershipId + " does not exist");
        }
        membershipRepository.deleteById(membershipId);
    }

    public List<Membership> getAllPlanMemberships(Long planId) {
        return membershipRepository.findMembershipsForPlan(planId);
    }

    private void updatePlanOfMembership(Membership membership, boolean isAddition) {
        Plan membershipPlan = planService.getPlan(membership.getPlanId());

        Double updatedShares = isAddition
                ? membershipPlan.getTotalShares() + membership.getShare()
                : membershipPlan.getTotalShares() - membership.getShare();

        membershipPlan.setTotalShares(updatedShares);
    }

    private void updateAllMembersOfPlan(Membership membership) {
        List<Membership> planMemberships = getAllPlanMemberships(membership.getPlanId());

        Plan membershipPlan = planService.getPlan(membership.getPlanId());

        BigDecimal price = membershipPlan.getPrice();

        Double totalShares = membershipPlan.getTotalShares();

        planMemberships.forEach( m -> {
            BigDecimal div = BigDecimal.valueOf(m.getShare() / totalShares);
            m.setAmountDue(price.multiply(div));
        });
    }

    @Transactional
    public void updateMembership(Long membershipId, Membership updatedMembership) {
        Membership originalMembership = membershipRepository.findById(membershipId)
                .orElseThrow(() -> new IllegalStateException(
                        "membership with id " + membershipId + " does not exist"
                ));

        originalMembership.copyFrom(updatedMembership);

        if (updatedMembership.getShare() != originalMembership.getShare()) {
            updatePlanOfMembership(originalMembership, false);
            updatePlanOfMembership(updatedMembership, true);
            updateAllMembersOfPlan(updatedMembership);
        }
    }

    private void validateMembership(Membership membership) {
        ValidationException ve = new ValidationException();

        if(!planService.existsByPlanId(membership.getPlanId())) {
            ve.addErrors("plan with plan id " + membership.getPlanId() + " does not exist");
        }

        if(!userService.existUserById(membership.getMemberId())) {
            ve.addErrors("member with user id " + membership.getMemberId() + "does not exist");
        }

        if (ve.hasErrors()) {
            throw ve;
        }
    }
}






