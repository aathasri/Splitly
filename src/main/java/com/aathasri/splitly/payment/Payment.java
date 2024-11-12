package com.aathasri.splitly.payment;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Payment {

    private long id;
    private long payerId;
    private long recipientId;
    private long planId;
    private BigDecimal amount;
    private LocalDate date;
    private String method;
    private PaymentStatus status;
    private Boolean toPlan;

    public Payment() {
    }

    public Payment(long id, long payerId, long recipientId, long planId, BigDecimal amount, LocalDate date, String method, PaymentStatus status, Boolean toPlan) {
        this.id = id;
        this.payerId = payerId;
        this.recipientId = recipientId;
        this.planId = planId;
        this.amount = amount;
        this.date = date;
        this.method = method;
        this.status = status;
        this.toPlan = toPlan;
    }

    public Payment(long payerId, long recipientId, long planId, BigDecimal amount, LocalDate date, String method, PaymentStatus status, Boolean toPlan) {
        this.payerId = payerId;
        this.recipientId = recipientId;
        this.planId = planId;
        this.amount = amount;
        this.date = date;
        this.method = method;
        this.status = status;
        this.toPlan = toPlan;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPayerId() {
        return payerId;
    }

    public void setPayerId(long payerId) {
        this.payerId = payerId;
    }

    public long getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(long recipientId) {
        this.recipientId = recipientId;
    }

    public long getPlanId() {
        return planId;
    }

    public void setPlanId(long planId) {
        this.planId = planId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public Boolean getToPlan() {
        return toPlan;
    }

    public void setToPlan(Boolean toPlan) {
        this.toPlan = toPlan;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", payerId=" + payerId +
                ", recipientId=" + recipientId +
                ", planId=" + planId +
                ", amount=" + amount +
                ", date=" + date +
                ", method='" + method + '\'' +
                ", status=" + status +
                ", toPlan=" + toPlan +
                '}';
    }
}
