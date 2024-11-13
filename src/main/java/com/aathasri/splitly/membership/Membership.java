package com.aathasri.splitly.membership;

import java.math.BigDecimal;

public class Membership {

    private Long id;
    private Long planId;
    private Long memberId;
    private Boolean isAdmin;
    private BigDecimal amountDue;
    private double share;

    public Membership() {
    }

    public Membership(Long id, Long planId, Long memberId, Boolean isAdmin, BigDecimal amountDue, double share) {
        this.id = id;
        this.planId = planId;
        this.memberId = memberId;
        this.isAdmin = isAdmin;
        this.amountDue = amountDue;
        this.share = share;
    }

    public Membership(Long planId, Long memberId, Boolean isAdmin, BigDecimal amountDue, double share) {
        this.planId = planId;
        this.memberId = memberId;
        this.isAdmin = isAdmin;
        this.amountDue = amountDue;
        this.share = share;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "Membership{" +
                "id=" + id +
                ", planId=" + planId +
                ", memberId=" + memberId +
                ", isAdmin=" + isAdmin +
                ", amountDue=" + amountDue +
                ", share=" + share +
                '}';
    }
}
