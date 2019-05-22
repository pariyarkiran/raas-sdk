package com.lftechnology.raas.sdk.dto;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class CompanyCountry {

    private Country sourceCountry;
    private Country destinationCountry;

    public Country getSourceCountry() {
        return sourceCountry;
    }

    public void setSourceCountry(Country sourceCountry) {
        this.sourceCountry = sourceCountry;
    }

    public Country getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(Country destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    @Override
    public String toString() {
        return "CompanyCountry{" + "sourceCountry=" + sourceCountry + ", destinationCountry=" + destinationCountry + '}';
    }
}
