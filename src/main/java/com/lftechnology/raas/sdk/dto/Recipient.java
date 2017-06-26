package com.lftechnology.raas.sdk.dto;

import com.google.gson.annotations.SerializedName;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class Recipient {

    @SerializedName("id")
    private String referenceId;
    private String senderId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String country;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String postalCode;
    private String province;
    private String email;
    private String homePhone;
    private String mobilePhone;
    private String workPhone;
    private String dateOfBirth;
    private String occupation;
    private String senderRelationship;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getSenderRelationship() {
        return senderRelationship;
    }

    public void setSenderRelationship(String senderRelationship) {
        this.senderRelationship = senderRelationship;
    }

    @Override public String toString() {
        return "Recipient{" + "referenceId='" + referenceId + '\'' + ", senderId='" + senderId + '\'' + ", firstName='" + firstName + '\''
                + ", middleName='" + middleName + '\'' + ", lastName='" + lastName + '\'' + ", country='" + country + '\''
                + ", addressLine1='" + addressLine1 + '\'' + ", addressLine2='" + addressLine2 + '\'' + ", city='" + city + '\''
                + ", postalCode='" + postalCode + '\'' + ", province='" + province + '\'' + ", email='" + email + '\'' + ", homePhone='"
                + homePhone + '\'' + ", mobilePhone='" + mobilePhone + '\'' + ", workPhone='" + workPhone + '\'' + ", dateOfBirth='"
                + dateOfBirth + '\'' + ", occupation='" + occupation + '\'' + ", senderRelationship='" + senderRelationship + '\'' + '}';
    }
}
