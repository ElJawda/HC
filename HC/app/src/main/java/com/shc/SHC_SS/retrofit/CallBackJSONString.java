package com.shc.SHC_SS.retrofit;

import com.google.gson.JsonPrimitive;

import retrofit2.Response;

/**
 *  Created by ejwadah on 9/6/2016.
 */
public interface CallBackJSONString {
    void onSuccess(Response<JsonPrimitive> o);

    void OnFail(Throwable o);
}