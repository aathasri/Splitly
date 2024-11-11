package com.aathasri.splitly.payment;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Payment {

    private int id;
    private int payerId;
    private int recipientId;
    private int planId;
    private BigDecimal amount;
    private LocalDate date;
    private String method;
    private PaymentStatus status;
    private Boolean toPlan;

    public Payment(int id, int payerId, int recipientId, int planId, BigDecimal amount, LocalDate date, String method, PaymentStatus status, Boolean toPlan) {
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

    public Payment(int payerId, int recipientId, int planId, BigDecimal amount, LocalDate date, String method, PaymentStatus status, Boolean toPlan) {
        this.payerId = payerId;
        this.recipientId = recipientId;
        this.planId = planId;
        this.amount = amount;
        this.date = date;
        this.method = method;
        this.status = status;
        this.toPlan = toPlan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPayerId() {
        return payerId;
    }

    public void setPayerId(int payerId) {
        this.payerId = payerId;
    }

    public int getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(int recipientId) {
        this.recipientId = recipientId;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
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
