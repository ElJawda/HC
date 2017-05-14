package com.shc.SHC_SS.utilies;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by jawdah on 3/23/2017.
 */

public class ReadQuestionFromJsonFile {

    // read data from  json  file
    // read json  file which  contain  question
   private String loadJSONFromAsset() {
        String json = null;
        try {
             // use the general  context
            InputStream is = HCApplication.newInstance().context.getAssets().open("allquestion.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }


    public JSONArray getArrayFromJson(String question_name) throws JSONException {
        JSONObject jsonObject=new JSONObject(loadJSONFromAsset());
        JSONArray all =jsonObject.getJSONArray(question_name);

        return all;

    }
    public String getStringFromJson(String question_name) throws JSONException {
        JSONObject jsonObject=new JSONObject(loadJSONFromAsset());
         String value  =jsonObject.getString(question_name);
        return value;

    }
    public ArrayList getArrayListJson(String question_name) throws JSONException {
        JSONObject jsonObject=new JSONObject(loadJSONFromAsset());
        JSONArray all =jsonObject.getJSONArray(question_name);
        ArrayList arrayList=new ArrayList();
        for (int i= 0;i<all.length();i++){
            arrayList.add(all.get(i));
        }

        return arrayList;

    }
}
