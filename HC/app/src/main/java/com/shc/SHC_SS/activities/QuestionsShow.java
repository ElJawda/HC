package com.shc.SHC_SS.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.shc.SHC_SS.R;
import com.shc.SHC_SS.database.DBHelper;
import com.shc.SHC_SS.entities.AllITemes;
import com.shc.SHC_SS.entities.DataFromDataBase;
import com.shc.SHC_SS.fragment.ConfirmationDialog;
import com.shc.SHC_SS.fragment.Section4000;
import com.shc.SHC_SS.fragment.Section5000;
import com.shc.SHC_SS.fragment.Section6140;
import com.shc.SHC_SS.fragment.Section6200To6222;
import com.shc.SHC_SS.fragment.Section6230To6252;
import com.shc.SHC_SS.fragment.Section6300;
import com.shc.SHC_SS.fragment.Section6400;
import com.shc.SHC_SS.fragment.Section6000To6122;
import com.shc.SHC_SS.fragment.Section6500;
import com.shc.SHC_SS.fragment.Section6604;
import com.shc.SHC_SS.parser.data.JSONStringParser;
import com.shc.SHC_SS.retrofit.CallBackJSONString;
import com.shc.SHC_SS.utilies.HCApplication;
import com.shc.SHC_SS.utilies.NetworkUtil;
import com.shc.SHC_SS.utilies.ReplaceFragment;
import com.shc.SHC_SS.views.HCButtonN;
import com.google.gson.Gson;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Response;

/**
 * Created by jawdah on 3/21/2017.
 */

public class QuestionsShow extends FragmentActivity implements View.OnClickListener {
    FrameLayout frameLayout;
    HCButtonN continu, back,cancel,cancel_save;
    public FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction();
    ReplaceFragment replaceFragment = new ReplaceFragment();
    DataFromDataBase dataFromDataBase;
    AllITemes allITemes;
    public static final String TABLE_NAME = "evolution";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_CHeck = "check_uploaded";

    @Override
    public void onBackPressed() { }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HCApplication.newInstance().preventLocalization();
        setContentView(R.layout.questation_show);
        HCApplication.mydb = new DBHelper();
        frameLayout = (FrameLayout) findViewById(R.id.mainframe);
        continu = (HCButtonN) findViewById(R.id.btn_continue);
        back = (HCButtonN) findViewById(R.id.back);
        back.setOnClickListener(this);
        cancel = (HCButtonN) findViewById(R.id.cancel);
        cancel.setOnClickListener(this);
        continu.setOnClickListener(this);
        cancel_save = (HCButtonN) findViewById(R.id.cancel_save);
        cancel_save.setOnClickListener(this);
        HCApplication.saveDataInSharedPrefrances.save_data_int("ActivityMove","activity_value",4);



        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String dateStr = dateFormat.format(date);
            ;
            HCApplication.all_item.put("CreateDate", dateStr);
            HCApplication.all_item.put("UserID", HCApplication.saveDataInSharedPrefrances.getFRomShard("User_Data", "user_id"));

            Log.d("TestDate", dateStr);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //
        int move_value = HCApplication.saveDataInSharedPrefrances.getFRomShard("Move_Shared", "open_screen");
        if (move_value != 0) {
            checkReplace(move_value);
        } else {
            Section4000 section = new Section4000();
            replaceFragment.replace(ft, section);
        }


    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onClick(View v) {
        int move_value = HCApplication.saveDataInSharedPrefrances.getFRomShard("Move_Shared", "Value_Name");
        int move_value_back = HCApplication.saveDataInSharedPrefrances.getFRomShard("Move_Shared", "Value_Back");
        switch (v.getId()) {

            case R.id.btn_continue:
                Log.d("allitems",HCApplication.all_item.toString());

                if (HCApplication.move_ment.contains("        e")) {
                    Toast.makeText(this, "لا يمكن مغادرة الشاشة قبل اجابة كافة الأسئلة المعروضة" , Toast.LENGTH_SHORT).show();
                }
                else  if (HCApplication.move_ment.contains("  e")) {
                    Toast.makeText(this, "لا يمكن مغادرة الشاشة قبل اجابة كافة الأسئلة المعروضة" , Toast.LENGTH_SHORT).show();
                }
                else  if (HCApplication.move_ment.contains("   e")) {
                    Toast.makeText(this, "لا يمكن مغادرة الشاشة قبل اجابة كافة الأسئلة المعروضة" , Toast.LENGTH_SHORT).show();
                }
                else  if (HCApplication.move_ment.contains("    e")) {
                    Toast.makeText(this, "لا يمكن مغادرة الشاشة قبل اجابة كافة الأسئلة المعروضة", Toast.LENGTH_SHORT).show();
                }
                else  if (HCApplication.move_ment.contains("e")) {
                    Toast.makeText(this, "لا يمكن مغادرة الشاشة قبل اجابة كافة الأسئلة المعروضة" , Toast.LENGTH_SHORT).show();
                }
                else  if (HCApplication.move_ment.contains("       e")) {
                    Toast.makeText(this,"لا يمكن مغادرة الشاشة قبل اجابة كافة الأسئلة المعروضة" , Toast.LENGTH_SHORT).show();
                }
               else  if (HCApplication.move_ment.contains("               e")) {
                    Toast.makeText(this, "لا يمكن مغادرة الشاشة قبل اجابة كافة الأسئلة المعروضة" , Toast.LENGTH_SHORT).show();
                }
                else {

                    HCApplication.check_section6230 = 0;
                    checkReplace(move_value);
               }
                break;
            case R.id.back:
                HCApplication.check_section6230 = 0;
                if (HCApplication.back_section == 0) {
                    checkReplace(move_value_back);
                } else if (HCApplication.back_section == 5) {
                    checkReplace(5);
                    HCApplication.back_section = 0;
                } else {
                    checkReplace(3);
                    HCApplication.back_section = 0;


                }
                break;

            case R.id.cancel:

                showConfirmationDialog();
                break;
            case R.id.cancel_save:

                showConfirmationDialogCancelandSave();
                break;
//            case R.id.upload_data_base:
//                ProgressDialog progressDialog = new ProgressDialog(QuestionsShow.this);
//                progressDialog.setMessage("please wait");
//                progressDialog.show();
//                if (!NetworkUtil.getConnectivityStatusString(HCApplication.context).equals("Not connected to Internet")) {
//                    JSONArray jsonElements = null;
//                    try {
//                        jsonElements = HCApplication.mydb.getColumnNameandValue(TABLE_NAME, 1);
//                        if (jsonElements.length() > 0) {
//                            for (int i = 0; i < jsonElements.length(); i++) {
//                                Gson gson = new Gson();
//                                Type listType = new TypeToken<DataFromDataBase>() {
//                                }.getType();
//                                dataFromDataBase = gson.fromJson(jsonElements.get(i).toString(), listType);
//                                Type listType1 = new TypeToken<AllITemes>() {
//                                }.getType();
//                                allITemes = gson.fromJson(dataFromDataBase.getName(), listType1);
//                                if (upload(allITemes, dataFromDataBase.getId()) != 0) {
//                                    HCApplication.mydb.updateContact(TABLE_NAME, dataFromDataBase.getId(), COLUMN_NAME, dataFromDataBase.getName(), COLUMN_CHeck, 0);
//                                }
//                            }
//                            progressDialog.dismiss();
//
//                        } else {
//                            Toast.makeText(HCApplication.context, "No Data ", Toast.LENGTH_LONG).show();
//                            progressDialog.dismiss();
//
//                        }
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//
//
//                } else {
//                    Toast.makeText(HCApplication.context, "Not connected to Internet ", Toast.LENGTH_LONG).show();
//                }
//                break;


        }
    }

    private void showConfirmationDialog() {
        ConfirmationDialog confirmationDialog = new ConfirmationDialog();
        ConfirmationDialog.newInstance("تحذير: سيتم فقد إجابات هذا الاستبيان .. هل تريد الاستمرار؟");
        confirmationDialog.setConfirmationDialogCallback(new ConfirmationDialog.ConfirmationDialogCallback() {
            @Override
            public void ok(boolean shouldRemoveFamily) {
                startActivity(new Intent(QuestionsShow.this,FamilyDetails.class));
                finish();
            }
        });
        confirmationDialog.show(getFragmentManager(),"Cancel");
    }
    private void showConfirmationDialogCancelandSave() {
        ConfirmationDialog confirmationDialog = new ConfirmationDialog();
        ConfirmationDialog.newInstance("تحذير: سيتم حفظ إجابات هذا الاستبيان وحذف الاسرة .. هل تريد الاستمرار؟");
        confirmationDialog.setConfirmationDialogCallback(new ConfirmationDialog.ConfirmationDialogCallback() {
            @Override
            public void ok(boolean shouldRemoveFamily) {
                startActivity(new Intent(QuestionsShow.this,SaveOnServer.class));
                finish();
            }
        });
        confirmationDialog.show(getFragmentManager(),"Cancel");
    }


    public void checkReplace(int move_value) {
        FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction();
        frameLayout.setVisibility(View.VISIBLE);

        if (move_value == 1) {
            Section4000 section6122 = new Section4000();
            replaceFragment.replace(ft, section6122);
        }
        if (move_value == 2) {
            Section5000 section6122 = new Section5000();
            replaceFragment.replace(ft, section6122);
        } else if (move_value == 3) {
            Section6000To6122 section6122 = new Section6000To6122();
            replaceFragment.replace(ft, section6122);
        } else if (move_value == 4) {
            Section6140 section6122 = new Section6140();
            replaceFragment.replace(ft, section6122);
        } else if (move_value == 5) {
            Section6200To6222 section6200 = new Section6200To6222();
            replaceFragment.replace(ft, section6200);
        } else if (move_value == 6) {
            Section6230To6252 section6233 = new Section6230To6252();
            replaceFragment.replace(ft, section6233);
        } else if (move_value == 7) {
            Section6300 section6300 = new Section6300();
            replaceFragment.replace(ft, section6300);
        } else if (move_value == 8) {
            Section6400 section6400 = new Section6400();
            replaceFragment.replace(ft, section6400);
        } else if (move_value == 9) {
            Section6500 section6500 = new Section6500();
            replaceFragment.replace(ft, section6500);
        } else if (move_value == 10) {
            Section6604 section6604 = new Section6604();
            replaceFragment.replace(ft, section6604);
        } else if (move_value == 11) {
            startActivity(new Intent(QuestionsShow.this, SaveOnServer.class));
        }

    }


}
