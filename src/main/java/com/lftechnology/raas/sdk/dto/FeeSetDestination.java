package com.lftechnology.raas.sdk.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class FeeSetDestination {

    private String destinationCountry;

    @SerializedName("fee_set_dtos")
    private List<FeeSet> feeSets;

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public List<FeeSet> getFeeSets() {
        return feeSets;
    }

    public void setFeeSets(List<FeeSet> feeSets) {
        this.feeSets = feeSets;
    }

    @Override public String toString() {
        return "FeeSetDestination{" + "destinationCountry='" + destinationCountry + '\'' + ", feeSets=" + feeSets + '}';
    }
}
