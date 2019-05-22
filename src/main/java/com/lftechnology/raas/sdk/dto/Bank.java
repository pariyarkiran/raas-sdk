package com.lftechnology.raas.sdk.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class Bank {

    @SerializedName("id")
    private String referenceId;
    private String name;
    private String country;

    private List<Branch> branches;

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }

    @Override public String toString() {
        return "Bank{" + "referenceId='" + referenceId + '\'' + ", name='" + name + '\'' + ", country='" + country + '\'' + ", branches="
                + branches + '}';
    }
}
