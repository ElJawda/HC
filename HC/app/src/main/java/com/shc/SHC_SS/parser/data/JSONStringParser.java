package com.shc.SHC_SS.parser.data;

import com.shc.SHC_SS.entities.AllITemes;
import com.shc.SHC_SS.retrofit.CallBackJSONString;
import com.shc.SHC_SS.retrofit.RetrofitInterface;
import com.google.gson.JsonPrimitive;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ejwadah on 9/6/2016.
 */
public class JSONStringParser implements Callback<JsonPrimitive> {

    private final String baseURL;
    CallBackJSONString callBackJSONString;

    public JSONStringParser(String baseUrl, CallBackJSONString call) {
        this.callBackJSONString = call;
        this.baseURL = baseUrl;
    }

    public void  upload(RetrofitInterface retrofitInterface,AllITemes allITemes){
        try {
            Call<JsonPrimitive> jsonCall = retrofitInterface.uploadQuestion(baseURL+"Respons/PostRespons?parameters", allITemes);
            jsonCall.enqueue(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void getLogin(RetrofitInterface inter,String number ,String password) {
        Call<JsonPrimitive> resString = inter.login(baseURL + "Users/Authinticate?IdNum="+number+"&Passw="+password);
        resString.enqueue(this);
    }

    @Override
    public void onResponse(Call<JsonPrimitive> call, Response<JsonPrimitive> response) {
        callBackJSONString.onSuccess(response);
    }

    @Override
    public void onFailure(Call<JsonPrimitive> call, Throwable t) {
        callBackJSONString.OnFail(t);
    }
}
