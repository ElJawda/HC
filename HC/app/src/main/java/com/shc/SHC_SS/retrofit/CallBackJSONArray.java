package com.shc.SHC_SS.retrofit;

import com.google.gson.JsonArray;

import retrofit2.Response;

/**
 *  Created by ejwadah on 9/6/2016.
 */
public interface CallBackJSONArray {
    void onSuccess(Response<JsonArray> o);

    void OnFail(Throwable o);
}
