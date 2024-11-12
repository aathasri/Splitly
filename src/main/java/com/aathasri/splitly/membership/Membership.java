package com.aathasri.splitly.membership;

import java.math.BigDecimal;

public class Membership {

    private long id;
    private long planId;
    private long memberId;
    private Boolean isAdmin;
    private BigDecimal amountDue;
    private double share;

    public Membership() {
    }

    public Membership(long id, long planId, long memberId, Boolean isAdmin, BigDecimal amountDue, double share) {
        this.id = id;
        this.planId = planId;
        this.memberId = memberId;
        this.isAdmin = isAdmin;
        this.amountDue = amountDue;
        this.share = share;
    }

    public Membership(long planId, long memberId, Boolean isAdmin, BigDecimal amountDue, double share) {
        this.planId = planId;
        this.memberId = memberId;
        this.isAdmin = isAdmin;
        this.amountDue = amountDue;
        this.share = share;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPlanId() {
        return planId;
    }

    public void setPlanId(long planId) {
        this.planId = planId;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
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
