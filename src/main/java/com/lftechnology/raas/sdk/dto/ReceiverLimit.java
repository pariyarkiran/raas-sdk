package com.lftechnology.raas.sdk.dto;

import java.math.BigDecimal;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class ReceiverLimit {

    private String country;

    private String paymentType;

    private BigDecimal limit;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    @Override public String toString() {
        return "ReceiverLimit{" + "country='" + country + '\'' + ", paymentType='" + paymentType + '\'' + ", limit=" + limit + '}';
    }
}