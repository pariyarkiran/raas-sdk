package com.lftechnology.raas.sdk.dto;

import com.google.gson.annotations.SerializedName;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class Country {

    @SerializedName("id")
    private String referenceId;
    private String name;
    private String threeCharCode;
    private String twoCharCode;
    private String phoneCode;
    private Currency currency;

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThreeCharCode() {
        return threeCharCode;
    }

    public void setThreeCharCode(String threeCharCode) {
        this.threeCharCode = threeCharCode;
    }

    public String getTwoCharCode() {
        return twoCharCode;
    }

    public void setTwoCharCode(String twoCharCode) {
        this.twoCharCode = twoCharCode;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override public String toString() {
        return "Country{" + "referenceId='" + referenceId + '\'' + ", name='" + name + '\'' + ", threeCharCode='" + threeCharCode + '\''
                + ", twoCharCode='" + twoCharCode + '\'' + ", phoneCode='" + phoneCode + '\'' + ", currency=" + currency + '}';
    }
}
