package com.lftechnology.raas.sdk.dto;

import java.math.BigDecimal;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class SenderLimit {

    private BigDecimal limit;

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    @Override public String toString() {
        return "SenderLimit{" + "limit=" + limit + '}';
    }
}
