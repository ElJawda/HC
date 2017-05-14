package com.shc.SHC_SS.parser.data;

import com.shc.SHC_SS.retrofit.CallBackJSONArray;
import com.shc.SHC_SS.retrofit.RetrofitInterface;
import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *  Created by ejwadah on 9/6/2016.
 */
public class JsonArrayParser implements Callback<JsonArray> {

    private final String baseURL;
    CallBackJSONArray callBackJSONObject;

    public JsonArrayParser(String baseUrl, CallBackJSONArray call) {
        this.callBackJSONObject = call;
        this.baseURL = baseUrl;
    }

    public void getCities(RetrofitInterface retrofitInterface,int region_id){
        Call<JsonArray> jsonCall = retrofitInterface.readJsonArray(baseURL+"Cities/GetCities?RegionId="+region_id);
        jsonCall.enqueue(this);
    }
    public void getNumericalCities(RetrofitInterface retrofitInterface,int city_id){
        Call<JsonArray> jsonCall = retrofitInterface.readJsonArray(baseURL+"NumericalAreas/GetNumericalAreas?CityId="+city_id);
        jsonCall.enqueue(this);
    }
    public void getRegion(RetrofitInterface retrofitInterface){
        Call<JsonArray> jsonCall = retrofitInterface.readJsonArray(baseURL+"Regions/GetRegions");
        jsonCall.enqueue(this);
    }

    public void getLanguage(RetrofitInterface retrofitInterface){
        Call<JsonArray> jsonCall = retrofitInterface.readJsonArray(baseURL+"Languages/GetLanguages");
        jsonCall.enqueue(this);
    }
    public  void GetNumRegion(RetrofitInterface retrofitInterface,int user_id){
        Call<JsonArray> jsonCall = retrofitInterface.readJsonArray(baseURL+"NumericalAreas/GetNumericalAreasByUserID?UserID="+user_id);
        jsonCall.enqueue(this);
    }
    public  void GetFamilyNumRegionID(RetrofitInterface retrofitInterface,String  region_number){
        Call<JsonArray> jsonCall = retrofitInterface.readJsonArray(baseURL+"Families/GetFamiliesByNumericalAreaCode?NumericalAreaCode="+region_number);
        jsonCall.enqueue(this);
    }
    public  void GetAllFamilyNumRegionID(RetrofitInterface retrofitInterface,int  user_id){
        Call<JsonArray> jsonCall = retrofitInterface.readJsonArray(baseURL+"Families/GetFamiliesByUserID?UserID="+user_id);
        jsonCall.enqueue(this);
    }


    @Override
    public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
        callBackJSONObject.onSuccess(response);

    }

    @Override
    public void onFailure(Call<JsonArray> call, Throwable t) {
        callBackJSONObject.OnFail(t);

    }
}
