package com.lftechnology.raas.sdk.dto;

import com.google.gson.annotations.SerializedName;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class State {

    @SerializedName("id")
    private String referenceId;
    private String name;
    private String code;
    private String countryId;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    @Override
    public String toString() {
        return "State{" + "referenceId='" + referenceId + '\'' + ", name='" + name + '\'' + ", code='" + code + '\'' + ", countryId='"
                + countryId + '\'' + '}';
    }
}
