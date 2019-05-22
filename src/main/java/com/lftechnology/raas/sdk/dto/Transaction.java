package com.lftechnology.raas.sdk.dto;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class Transaction {

    @SerializedName("id")
    private String referenceId;
    private BigDecimal senderAmount;
    private BigDecimal exchangeRate;
    private BigDecimal recipientAmount;
    private BigDecimal feeAmount;
    private String senderBankId;
    private String recipientId;
    private String recipientBankId;
    private String recipientCurrency;
    private String note;
    private String remittancePurpose;
    private String ipAddress;
    private String status;
    private String referenceNumber;

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public BigDecimal getSenderAmount() {
        return senderAmount;
    }

    public void setSenderAmount(BigDecimal senderAmount) {
        this.senderAmount = senderAmount;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public BigDecimal getRecipientAmount() {
        return recipientAmount;
    }

    public void setRecipientAmount(BigDecimal recipientAmount) {
        this.recipientAmount = recipientAmount;
    }

    public BigDecimal getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(BigDecimal feeAmount) {
        this.feeAmount = feeAmount;
    }

    public String getSenderBankId() {
        return senderBankId;
    }

    public void setSenderBankId(String senderBankId) {
        this.senderBankId = senderBankId;
    }

    public String getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }

    public String getRecipientBankId() {
        return recipientBankId;
    }

    public void setRecipientBankId(String recipientBankId) {
        this.recipientBankId = recipientBankId;
    }

    public String getRecipientCurrency() {
        return recipientCurrency;
    }

    public void setRecipientCurrency(String recipientCurrency) {
        this.recipientCurrency = recipientCurrency;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getRemittancePurpose() {
        return remittancePurpose;
    }

    public void setRemittancePurpose(String remittancePurpose) {
        this.remittancePurpose = remittancePurpose;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Transaction{");
        sb.append("referenceId='").append(referenceId).append('\'');
        sb.append(", senderAmount=").append(senderAmount);
        sb.append(", exchangeRate=").append(exchangeRate);
        sb.append(", recipientAmount=").append(recipientAmount);
        sb.append(", feeAmount=").append(feeAmount);
        sb.append(", senderBankId='").append(senderBankId).append('\'');
        sb.append(", recipientId='").append(recipientId).append('\'');
        sb.append(", recipientBankId='").append(recipientBankId).append('\'');
        sb.append(", recipientCurrency='").append(recipientCurrency).append('\'');
        sb.append(", note='").append(note).append('\'');
        sb.append(", remittancePurpose='").append(remittancePurpose).append('\'');
        sb.append(", ipAddress='").append(ipAddress).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append(", referenceNumber='").append(referenceNumber).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
