package com.lftechnology.raas.sdk.dto;

import com.google.gson.annotations.SerializedName;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class RecipientBank {

    @SerializedName("id")
    private String referenceId;
    private String accountNumber;
    private String accountType;
    private Long bankId;
    private String bankName;
    private Long branchId;
    private String branchName;
    private String address;
    private String city;
    private String state;
    private String branchLocation;

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getBranchLocation() {
        return branchLocation;
    }

    public void setBranchLocation(String branchLocation) {
        this.branchLocation = branchLocation;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("RecipientBank{");
        sb.append("referenceId='").append(referenceId).append('\'');
        sb.append(", accountNumber='").append(accountNumber).append('\'');
        sb.append(", accountType='").append(accountType).append('\'');
        sb.append(", bankId=").append(bankId);
        sb.append(", bankName='").append(bankName).append('\'');
        sb.append(", branchId=").append(branchId);
        sb.append(", branchName='").append(branchName).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", state='").append(state).append('\'');
        sb.append(", branchLocation='").append(branchLocation).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
