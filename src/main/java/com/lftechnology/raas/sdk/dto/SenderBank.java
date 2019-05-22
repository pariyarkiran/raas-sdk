package com.lftechnology.raas.sdk.dto;

import com.google.gson.annotations.SerializedName;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class SenderBank {

    @SerializedName("id")
    private String referenceId;
    private String senderId;
    private String bankName;
    private String accountType;
    private String accountNumber;
    private String routingNumber;

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }

    @Override public String toString() {
        return "SenderBank{" + "referenceId='" + referenceId + '\'' + ", senderId='" + senderId + '\'' + ", bankName='" + bankName + '\''
                + ", accountType='" + accountType + '\'' + ", accountNumber='" + accountNumber + '\'' + ", routingNumber='" + routingNumber
                + '\'' + '}';
    }
}
