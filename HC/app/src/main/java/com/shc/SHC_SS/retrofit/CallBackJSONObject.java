package com.shc.SHC_SS.retrofit;

import com.google.gson.JsonObject;

import retrofit2.Response;

/**
 * Created by abdullah.ayman on 9/4/2016.
 */
public interface CallBackJSONObject {
    void onSuccess(Response<JsonObject> o);

    void OnFail(Throwable o);
}
