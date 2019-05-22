package com.lftechnology.raas.sdk.service;

import com.lftechnology.raas.sdk.dto.CompanyCountry;
import com.lftechnology.raas.sdk.pojo.ListResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public interface CompanyCountryApiService {

    @GET("company-countries")
    Call<ListResponse<CompanyCountry>> list();
}

