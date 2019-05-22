package com.lftechnology.raas.sdk.dto;

import java.util.List;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class Fee {

    private String sourceCountry;
    private List<FeeSetDestination> feeSetDestinations;

    public String getSourceCountry() {
        return sourceCountry;
    }

    public void setSourceCountry(String sourceCountry) {
        this.sourceCountry = sourceCountry;
    }

    public List<FeeSetDestination> getFeeSetDestinations() {
        return feeSetDestinations;
    }

    public void setFeeSetDestinations(List<FeeSetDestination> feeSetDestinations) {
        this.feeSetDestinations = feeSetDestinations;
    }

    @Override public String toString() {
        return "Fee{" + "sourceCountry='" + sourceCountry + '\'' + ", feeSetDestinations=" + feeSetDestinations + '}';
    }
}
