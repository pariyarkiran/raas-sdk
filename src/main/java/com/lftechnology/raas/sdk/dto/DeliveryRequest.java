package com.lftechnology.raas.sdk.dto;


/**
 * @author pragya <pragyashrestha@lftechnology.com>
 */
public class DeliveryRequest {

    private String status;
    private String comment;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DeliveryRequest{");
        sb.append("status='").append(status).append('\'');
        sb.append(", comment=").append(comment);
        sb.append('}');
        return sb.toString();
    }
}