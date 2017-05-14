package com.shc.SHC_SS.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.shc.SHC_SS.R;
import com.shc.SHC_SS.entities.Login;
import com.shc.SHC_SS.parser.data.JSONObjectParser;
import com.shc.SHC_SS.retrofit.CallBackJSONObject;
import com.shc.SHC_SS.utilies.HCApplication;
import com.shc.SHC_SS.views.HCButtonN;
import com.shc.SHC_SS.views.HCCheckBoxN;
import com.shc.SHC_SS.views.HCEditTextN;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import retrofit2.Response;

/**
 * Created by jawdah on 4/3/2017.
 */

public class LoginPage extends Activity {
    HCEditTextN number, password;
    HCButtonN login;
    HCCheckBoxN remeber_me;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HCApplication.newInstance().preventLocalization();

        setContentView(R.layout.login);
        number = (HCEditTextN) findViewById(R.id.counter_number);
        password = (HCEditTextN) findViewById(R.id.counter_password);
        remeber_me = (HCCheckBoxN) findViewById(R.id.remember_me);

        String n = HCApplication.saveDataInSharedPrefrances.getStringFRomShard("User_Data", "user_number");
        String p = HCApplication.saveDataInSharedPrefrances.getStringFRomShard("User_Data", "user_password");

        if (!n.equals("")) {
            number.setText(n);
            password.setText(p);
            remeber_me.setChecked(true);

        }

        login = (HCButtonN) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!number.getText().toString().equals("") && !password.getText().toString().equals("")) {
                    login(number.getText().toString(), password.getText().toString());
                } else {

                    Toast.makeText(HCApplication.context, getString(R.string.add_field), Toast.LENGTH_LONG).show();
                }
            }
        });
        remeber_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (remeber_me.isChecked()) {
                    if (!number.getText().toString().equals("") && !password.getText().toString().equals("")) {
                        HCApplication.saveDataInSharedPrefrances.save_data_String("User_Data", "user_number", number.getText().toString());
                        HCApplication.saveDataInSharedPrefrances.save_data_String("User_Data", "user_password", password.getText().toString());

                    } else {
                        Toast.makeText(HCApplication.context, getString(R.string.add_field), Toast.LENGTH_LONG).show();
                    }

                } else {
                    HCApplication.saveDataInSharedPrefrances.delete("User_Data");

                }
            }
        });

    }



    public  void login(String number, String password){
        JSONObjectParser jsonObjectParser=new JSONObjectParser(getResources().getString(R.string.base_url), new CallBackJSONObject() {
            @Override
            public void onSuccess(Response<JsonObject> o) {
                Gson gson = new Gson();
                Type listType = new TypeToken<Login>() {
                }.getType();
                Login login = gson.fromJson(o.body().toString(), listType);
                Toast.makeText(HCApplication.context,login.getFullName()+"",Toast.LENGTH_LONG).show();
                if (!login.getFullName().equals(null)){
                HCApplication.saveDataInSharedPrefrances.save_data_String("User_Data", "user_login","login");

                HCApplication.saveDataInSharedPrefrances.save_data_int("User_Data", "user_id",login.getID());
                HCApplication.saveDataInSharedPrefrances.save_data_String("User_Data", "user_name",login.getFullName());
                HCApplication.saveDataInSharedPrefrances.save_data_String("User_Data", "user_region",login.getRegionName()+"");
                HCApplication.saveDataInSharedPrefrances.save_data_String("User_Data", "user_city",login.getCityName()+"");

                Intent mainIntent = new Intent(LoginPage.this, FamilyDetails.class);
                    startActivity(mainIntent);
                    finish();

                } else {
                    Toast.makeText(HCApplication.context, getString(R.string.false_data), Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void OnFail(Throwable o) {

            }
        });
        jsonObjectParser.login(HCApplication.newInstance().newRetrofitRequest(), number, password);
    }
}
