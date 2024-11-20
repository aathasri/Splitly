package com.aathasri.splitly.membership;

import com.aathasri.splitly.plan.PlanService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MembershipService {

    private final MembershipRepository membershipRepository;
    private final PlanService planService;

    @Autowired
    public MembershipService(MembershipRepository membershipRepository, PlanService planService) {
        this.membershipRepository = membershipRepository;
        this.planService = planService;
    }

    public List<Membership> getMemberships() {
        return membershipRepository.findAll();
    }

    public void addNewMembership(Membership membership) {
        boolean exists = membershipRepository.existsById(membership.getId());
        if (exists) {
            throw new IllegalStateException("membership already exists");
        }
        membershipRepository.save(membership);

        // TODO: when there is a new membership, adjust all the shares of everyone in the plan

    }

    public void deleteMembership(Long membershipId) {
        boolean exists = membershipRepository.existsById(membershipId);
        if (!exists) {
            throw new IllegalStateException("membership with id " + membershipId + " does not exist");
        }
        membershipRepository.deleteById(membershipId);
    }

    public void updateAllMemberShares() {
    // this class needs to update the shares of all the members in the plan so
    }

    public void calculateMemberAmountDue(){

    }

    @Transactional
    public void updateMembership(Long membershipId, Long planId, Long memberId, Boolean isAdmin, double share) {
        Membership membership = membershipRepository.findById(membershipId)
                .orElseThrow(() -> new IllegalStateException(
                        "membership with id " + membershipId + " does not exist"
                ));


        if (planId != null && planId > 0 && !Objects.equals(membership.getPlanId(), planId)) {
            membership.setPlanId(planId);
            // TODO: adjust the shares of everyone in the new plan and fix the ones in the old plan
        }

        if (memberId != null && memberId > 0 && !Objects.equals(membership.getMemberId(), memberId)) {
            membership.setMemberId(memberId);
        }

        if (isAdmin != null) {
            membership.setAdmin(isAdmin);
        }

        if (share >= 0.0 && share <= 1.0) {
            membership.setShare(share);
            // TODO: adjust the shares of everyone in the plan
        }
    }

}
