package com.shc.SHC_SS.parser.data;

import com.shc.SHC_SS.retrofit.CallBackJSONObject;
import com.shc.SHC_SS.retrofit.RetrofitInterface;
import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by abdullah.ayman on 9/4/2016.
 */
public class JSONObjectParser implements Callback<JsonObject> {

    private final String baseURL;
    CallBackJSONObject callBackJSONObject;

    public JSONObjectParser(String baseUrl, CallBackJSONObject call) {
        this.callBackJSONObject = call;
        this.baseURL = baseUrl;
    }


    public void  login(RetrofitInterface retrofitInterface,String number ,String password){
        Call<JsonObject> jsonCall = retrofitInterface.getLogin(baseURL+"Users/Authinticate?IdNum="+number+"&Passw="+password);
        jsonCall.enqueue(this);
    }



    @Override
    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
        callBackJSONObject.onSuccess(response);
    }

    @Override
    public void onFailure(Call<JsonObject> call, Throwable t) {
        callBackJSONObject.OnFail(t);
    }
}
