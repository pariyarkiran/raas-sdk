package com.lftechnology.raas.sdk.dto;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class FeeSet {

    @SerializedName("id")
    private String referenceId;

    private BigDecimal minAmount;

    private BigDecimal maxAmount;

    private BigDecimal feeAmount;

    private String activeFrom;

    private String expiredAt;

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
    }

    public BigDecimal getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(BigDecimal feeAmount) {
        this.feeAmount = feeAmount;
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

    @Override public String toString() {
        return "FeeSet{" + "referenceId='" + referenceId + '\'' + ", minAmount=" + minAmount + ", maxAmount=" + maxAmount + ", feeAmount="
                + feeAmount + ", activeFrom='" + activeFrom + '\'' + ", expiredAt='" + expiredAt + '\'' + '}';
    }
}
