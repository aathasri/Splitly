package com.aathasri.splitly.membership;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;


public class MembershipDTO {

    @NotNull
    @Positive
    private Long planId;
    @NotNull
    @Positive
    private Long memberId;
    @NotNull
    private Boolean isAdmin;
    @NotNull
    @Positive
    private BigDecimal amountDue;
    @NotNull
    @Positive
    private double share;

    public MembershipDTO(Long planId, Long memberId, Boolean isAdmin, BigDecimal amountDue, double share) {
        this.planId = planId;
        this.memberId = memberId;
        this.isAdmin = isAdmin;
        this.amountDue = amountDue;
        this.share = share;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public BigDecimal getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(BigDecimal amountDue) {
        this.amountDue = amountDue;
    }

    public double getShare() {
        return share;
    }

    public void setShare(double share) {
        this.share = share;
    }

    @Override
    public String toString() {
        return "MembershipDTO{" +
                "planId=" + planId +
                ", memberId=" + memberId +
                ", isAdmin=" + isAdmin +
                ", amountDue=" + amountDue +
                ", share=" + share +
                '}';
    }
}