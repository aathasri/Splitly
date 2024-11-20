package com.aathasri.splitly.membership;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table
public class Membership {
    @Id
    @SequenceGenerator(
            name = "membership_sequence",
            sequenceName = "membership_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "membership_sequence"
    )
    private Long id;
    private Long planId;
    private Long memberId;
    private Boolean isAdmin;
    private BigDecimal amountDue;
    private double share;

    public Membership() {
    }

    public Membership(Long id, Long planId, Long memberId, Boolean isAdmin, double share) {
        this.id = id;
        this.planId = planId;
        this.memberId = memberId;
        this.isAdmin = isAdmin;
        this.share = share;
    }

    public Membership(Long planId, Long memberId, Boolean isAdmin, double share) {
        this.planId = planId;
        this.memberId = memberId;
        this.isAdmin = isAdmin;
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

//    public void setAmountDue(BigDecimal amountDue) {
//        this.amountDue = amountDue;
//    }

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
