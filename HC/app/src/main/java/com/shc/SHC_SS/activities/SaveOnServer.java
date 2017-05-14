package com.shc.SHC_SS.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.shc.SHC_SS.R;
import com.shc.SHC_SS.entities.AllITemes;
import com.shc.SHC_SS.parser.data.JSONStringParser;
import com.shc.SHC_SS.retrofit.CallBackJSONString;
import com.shc.SHC_SS.utilies.HCApplication;
import com.shc.SHC_SS.utilies.NetworkUtil;
import com.shc.SHC_SS.views.HCButtonN;
import com.shc.SHC_SS.views.HCEditTextN;
import com.google.gson.Gson;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Response;

/**
 * Created by A.Elsayed on 4/25/2017.
 */

public class SaveOnServer extends Activity {
    HCButtonN upload;
    public static final String TABLE_NAME = "evolution";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_CHeck = "check_uploaded";
HCEditTextN coment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HCApplication.newInstance().preventLocalization();

        setContentView(R.layout.saver_to_server);
        upload = (HCButtonN) findViewById(R.id.upload);
        coment=(HCEditTextN)findViewById(R.id.comment);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upload.setEnabled(false);


                try {
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    Date date = new Date();
                    String dateStr = dateFormat.format(date);
                    HCApplication.all_item.put("Q0999b",dateStr);
                    if(coment.getText().toString().length()>0){
                    HCApplication.all_item.put("comment",coment.getText().toString());
                    }
                    else {
                        HCApplication.all_item.put("comment","no comment");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (!NetworkUtil.getConnectivityStatusString(HCApplication.context).equals("Not connected to Internet")) {
                    AllITemes allITemes;
                    Gson gson = new Gson();
                    Type listType = new TypeToken<AllITemes>() {
                    }.getType();
                    allITemes = gson.fromJson(HCApplication.all_item.toString(), listType);
                    upload(allITemes, 0);
                    Log.d("allitemsid",allITemes.getUserLong());
                    HCApplication.mydb.deleteRow("family","ID",HCApplication.saveDataInSharedPrefrances.getFRomShard("family","family_id"));

                } else {
                   // Toast.makeText(HCApplication.context, "data will add to  data base ", Toast.LENGTH_LONG).show();
                    if (HCApplication.mydb.insertContact(TABLE_NAME, COLUMN_NAME, HCApplication.all_item.toString(), COLUMN_CHeck, 1)) {
                        Toast.makeText(getApplicationContext(),"   تم حفظ الإستبيان محليا",
                                Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SaveOnServer.this,FamilyDetails.class));
                        HCApplication.mydb.deleteRow("family","ID",HCApplication.saveDataInSharedPrefrances.getFRomShard("family","family_id"));
                        finish();

                    }
                }
            }
        });
    }

    public synchronized Integer upload(final AllITemes allITemes, final int id) {
        JSONStringParser jsonStringParser = new JSONStringParser(getString(R.string.base_url), new CallBackJSONString() {
            @Override
            public void onSuccess(Response<JsonPrimitive> o) {
               // String check_value=o.body().toString();
                if (o.body()!=null){
                    if (o.body().toString().equals("true")) {
                        Toast.makeText(SaveOnServer.this, "  تم حفظ الإستبيان على الخادم", Toast.LENGTH_SHORT).show();
                        Log.d("sadasdsa", HCApplication.all_item.toString());
                        HCApplication.mydb.insertContact(TABLE_NAME, COLUMN_NAME, HCApplication.all_item.toString(), COLUMN_CHeck, 0);
                        startActivity(new Intent(SaveOnServer.this, FamilyDetails.class));
                        finish();
                    }
                    else {
                        Toast.makeText(SaveOnServer.this, "   تم حفظ الإستبيان محليا" , Toast.LENGTH_SHORT).show();
                        HCApplication.mydb.insertContact(TABLE_NAME, COLUMN_NAME, HCApplication.all_item.toString(), COLUMN_CHeck, 1);
                        startActivity(new Intent(SaveOnServer.this, FamilyDetails.class));
                        finish();
                    }
                }
                else {
                    Toast.makeText(SaveOnServer.this, "  تم حفظ الإستبيان محليا" , Toast.LENGTH_SHORT).show();
                    HCApplication.mydb.insertContact(TABLE_NAME, COLUMN_NAME, HCApplication.all_item.toString(), COLUMN_CHeck, 1);
                    startActivity(new Intent(SaveOnServer.this, FamilyDetails.class));
                    finish();
                }
            }

            @Override
            public void OnFail(Throwable o) {
                 Toast.makeText(SaveOnServer.this, "لم تتم  الحفظ  على  السيرفر  سوف يتم  الحفظ  لوكال  " , Toast.LENGTH_SHORT).show();
                HCApplication.mydb.insertContact(TABLE_NAME, COLUMN_NAME, HCApplication.all_item.toString(), COLUMN_CHeck, 1);
                startActivity(new Intent(SaveOnServer.this, FamilyDetails.class));
                finish();
            }
        });

        jsonStringParser.upload(HCApplication.newInstance().newRetrofitRequest(), allITemes);
        return id;
    }

}
