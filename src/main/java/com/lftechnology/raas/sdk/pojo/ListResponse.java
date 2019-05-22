package com.lftechnology.raas.sdk.pojo;

import java.util.List;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class ListResponse<T> {

    private List<T> results;
    private Paging paging;

    public ListResponse() {
    }

    public ListResponse(List<T> results, Paging paging) {
        this.results = results;
        this.paging = paging;
    }

    public List<T> getResults() {
        return this.results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public Paging getPaging() {
        return this.paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }
}
