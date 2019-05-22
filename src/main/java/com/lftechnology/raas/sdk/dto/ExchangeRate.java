package com.lftechnology.raas.sdk.dto;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class ExchangeRate {

    @SerializedName("id")
    private String referenceId;
    private String sourceCurrency;
    private String destinationCurrency;
    private BigDecimal rate;
    private String activeFrom;
    private String expiredAt;

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public void setSourceCurrency(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public String getDestinationCurrency() {
        return destinationCurrency;
    }

    public void setDestinationCurrency(String destinationCurrency) {
        this.destinationCurrency = destinationCurrency;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getActiveFrom() {
        return activeFrom;
    }

    public void setActiveFrom(String activeFrom) {
        this.activeFrom = activeFrom;
    }

    public String getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(String expiredAt) {
        this.expiredAt = expiredAt;
    }

    @Override
    public String toString() {
        return "ExchangeRate{" + "referenceId=" + referenceId + ", sourceCurrency='" + sourceCurrency + '\'' + ", destinationCurrency='"
                + destinationCurrency + '\'' + ", rate=" + rate + ", activeFrom='" + activeFrom + '\'' + ", expiredAt='" + expiredAt + '\''
                + '}';
    }
}
