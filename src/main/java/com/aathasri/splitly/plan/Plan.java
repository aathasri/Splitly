package com.aathasri.splitly.plan;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Currency;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Plan {
    @Id
    @SequenceGenerator(
            name = "plan_sequence",
            sequenceName = "plan_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "plan_sequence"
    )
    private long id;
    private String name;
    private BigDecimal monthlyPrice;
    private Currency currency;
    private LocalDate paymentDate;
    private Period paymentInterval;

    public Plan() {
    }

    public Plan(long id, String name, BigDecimal monthlyPrice, Currency currency, LocalDate paymentDate, Period paymentInterval) {
        this.id = id;
        this.name = name;
        this.monthlyPrice = monthlyPrice;
        this.currency = currency;
        this.paymentDate = paymentDate;
        this.paymentInterval = paymentInterval;
    }

    public Plan(String name, BigDecimal monthlyPrice, Currency currency, LocalDate paymentDate, Period paymentInterval) {
        this.name = name;
        this.monthlyPrice = monthlyPrice;
        this.currency = currency;
        this.paymentDate = paymentDate;
        this.paymentInterval = paymentInterval;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMonthlyPrice() {
        return monthlyPrice;
    }

    public void setMonthlyPrice(BigDecimal monthlyPrice) {
        this.monthlyPrice = monthlyPrice;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Period getPaymentInterval() {
        return paymentInterval;
    }

    public void setPaymentInterval(Period paymentInterval) {
        this.paymentInterval = paymentInterval;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", monthlyPrice=" + monthlyPrice +
                ", currency=" + currency +
                ", paymentDate=" + paymentDate +
                ", paymentInterval=" + paymentInterval +
                '}';
    }
}
