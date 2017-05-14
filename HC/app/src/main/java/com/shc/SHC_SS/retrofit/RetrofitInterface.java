package com.shc.SHC_SS.retrofit;

import com.shc.SHC_SS.entities.AllITemes;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by ejwadah on 9/6/2016.
 */
public interface RetrofitInterface {

    @GET() // I use a simple json file to get the JSON Array as yours
    Call<JsonArray> readJsonArray(@Url String url);

    @GET
    Call<JsonArray> getData(@Url String url);

    @POST
    Call<JsonPrimitive> login(@Url String url);

    @POST
    Call<JsonPrimitive> uploadQuestion(@Url String url, @Body AllITemes allITemes);


    @POST
    Call<JsonObject> getLogin(@Url String url);

    @Headers({
            "cache-control: no-cache",
            "content-type: application/json"})
    @POST
    Call<JsonArray> getData(@Url String url, @Body JsonObject jsonObject);

    @POST
    Call<JsonObject> getData2(@Url String url, @Body String jsonObject);

}

// remark  this url  
// http://www.jsonschema2pojo.org/   to  convert json  to  classes

/*
request.AddHeader("cache-control", "no-cache");
request.AddHeader("content-type", "application/json");
*/

/*
* how to  use retrovit in  apps
* 1- add get and post methods in  retrofit interface
* --  intialize retrofit object in application
* 2- add call  back  function  from  callback  interface
* 3- parse function  json parser
* 4- call  get or post function  where you  want
* */