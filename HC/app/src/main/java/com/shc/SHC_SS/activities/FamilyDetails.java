package com.shc.SHC_SS.activities;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStates;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.shc.SHC_SS.R;
import com.shc.SHC_SS.database.DBHelper;
import com.shc.SHC_SS.entities.AllITemes;
import com.shc.SHC_SS.entities.AllfamilyFromDataBase;
import com.shc.SHC_SS.entities.DataFromDataBase;
import com.shc.SHC_SS.entities.FamilyByNumericalRegionId;
import com.shc.SHC_SS.fragment.NoGpsDialog;
import com.shc.SHC_SS.parser.data.JSONStringParser;
import com.shc.SHC_SS.parser.data.JsonArrayParser;
import com.shc.SHC_SS.retrofit.CallBackJSONArray;
import com.shc.SHC_SS.retrofit.CallBackJSONString;
import com.shc.SHC_SS.utilies.HCApplication;
import com.shc.SHC_SS.utilies.NetworkUtil;
import com.shc.SHC_SS.views.HCBoldTextViewN;
import com.shc.SHC_SS.views.HCButtonN;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import retrofit2.Response;

import static com.shc.SHC_SS.utilies.HCApplication.context;

/**
 * Created by A.Elsayed on 4/11/2017.
 */

public class FamilyDetails extends Activity implements
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    private static final int REQUEST_CHECK_SETTINGS = 152;
    Spinner num_region, family;
    HCBoldTextViewN region, goverment, center, mashmol, hara, district, block, building, home, location,upload_,not_upload,all_item;
    List<FamilyByNumericalRegionId> allFamilies;
    ArrayList<String> family_name = new ArrayList<>();
    ArrayList<String> region_number = new ArrayList<>();
    LinearLayout section1, section2, include1, include2;
    HCButtonN accept, from_data, update_app;
    public static final String TABLE_Region = "numerical_region";
    public static final String COLUMN_Region_code = "region_code";
    ArrayAdapter dataAdapter;
    String n = "", f = "";
    ArrayList<FamilyByNumericalRegionId> familyByNumericalRegionIds;
    FamilyByNumericalRegionId familyByNumericalRegionId;
    DataFromDataBase dataFromDataBase;
    AllITemes allITemes;
    public static final String TABLE_NAME = "evolution";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_CHeck = "check_uploaded";
    LinearLayout Lin_f;
    Geocoder geocoder;
    String bestProvider;
    List<Address> user = null;
    double lat;
    double lng;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HCApplication.newInstance().preventLocalization();
        setContentView(R.layout.family_details);


        if (isPlayServicesAvailable()) buildLocationApi();
        if (!isGpsEnabled()) {
            Log.e(TAG, "Gps is not enabled");
//            onNoLocation(getString(R.string.enable_gps));
//            showGpsDialog();
        } else {
//            LocationManager mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

//            mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000,
//                    30.0f, this);
//            requestLocation();
        }

        region = (HCBoldTextViewN) findViewById(R.id.c_region);
        region.setText(HCApplication.saveDataInSharedPrefrances.getStringFRomShard("User_Data", "user_region"));
        goverment = (HCBoldTextViewN) findViewById(R.id.goverment);
        goverment.setText(HCApplication.saveDataInSharedPrefrances.getStringFRomShard("User_Data", "user_city"));
        center = (HCBoldTextViewN) findViewById(R.id.center);
        mashmol = (HCBoldTextViewN) findViewById(R.id.mashmol);
        hara = (HCBoldTextViewN) findViewById(R.id.hara);
        district = (HCBoldTextViewN) findViewById(R.id.district);
        block = (HCBoldTextViewN) findViewById(R.id.block);
        building = (HCBoldTextViewN) findViewById(R.id.building);
        home = (HCBoldTextViewN) findViewById(R.id.home);
        upload_ = (HCBoldTextViewN) findViewById(R.id.upload);
        not_upload = (HCBoldTextViewN) findViewById(R.id.not_upload);
        all_item = (HCBoldTextViewN) findViewById(R.id.all_item);

        location = (HCBoldTextViewN) findViewById(R.id.location);
        section1 = (LinearLayout) findViewById(R.id.section1);
        section2 = (LinearLayout) findViewById(R.id.section2);
        include1 = (LinearLayout) findViewById(R.id.include1);
        include2 = (LinearLayout) findViewById(R.id.include2);
        from_data = (HCButtonN) findViewById(R.id.upload_data_base);
        Lin_f = (LinearLayout) findViewById(R.id.li_family);

        if (HCApplication.mydb.getAllCotacts("family", "NumericalAreaCode").size()!=0){

            HCApplication.saveDataInSharedPrefrances.save_data_int("allfamily","check_family",1);
        }
        update_app = (HCButtonN) findViewById(R.id.update_app);
        update_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + appPackageName)));
                }

//                final String url = "https://play.google.com/store/apps/details?id=com.care.health.jawdah.hc";
//                Uri uri = Uri.parse(url);
//                Intent intent = new Intent();
//                intent.setData(uri);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent);
            }
        });
        from_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ProgressDialog progressDialog = new ProgressDialog(FamilyDetails.this);
                progressDialog.setMessage("please wait");
                // progressDialog.show();
                if (!NetworkUtil.getConnectivityStatusString(context).equals("Not connected to Internet")) {
                    JSONArray jsonElements = null;
                    try {
                        // jsonElements = HCApplication.mydb.getColumnNameandValue(TABLE_NAME, 1);
                        jsonElements = HCApplication.mydb.getColumnNameandValue(TABLE_NAME, 1);
                        if (jsonElements.length() > 0) {
                            for (int i = 0; i < jsonElements.length(); i++) {
                                Gson gson = new Gson();
                                Type listType = new TypeToken<DataFromDataBase>() {
                                }.getType();
                                dataFromDataBase = gson.fromJson(jsonElements.get(i).toString(), listType);
                                Type listType1 = new TypeToken<AllITemes>() {
                                }.getType();
                                allITemes = gson.fromJson(dataFromDataBase.getName(), listType1);
                                upload(allITemes, dataFromDataBase.getId());
//                                if (upload(allITemes, dataFromDataBase.getId()) != 0) {
//                                    HCApplication.mydb.updateContact(TABLE_NAME, dataFromDataBase.getId(), COLUMN_NAME, dataFromDataBase.getName(), COLUMN_CHeck, 0);
//                                }
                            }
                            progressDialog.dismiss();

                        } else {
                            Toast.makeText(context, "No Data ", Toast.LENGTH_LONG).show();
                            progressDialog.dismiss();

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                } else {
                    Toast.makeText(context, " تعذر حفظ الإستبيان على الخادم (لا يوجد انترنت)", Toast.LENGTH_LONG).show();
                }

            }
        });


        ///  creaye local  data base
        HCApplication.mydb = new DBHelper();
        accept = (HCButtonN) findViewById(R.id.accept);
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("allitems", HCApplication.all_item.toString());

                if (f.equals("f") && n.equals("n")) {
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    Date date = new Date();
                    String dateStr = dateFormat.format(date);
                    try {
                        HCApplication.all_item.put("Q0999a", dateStr);

                        String uniqueID = UUID.randomUUID().toString();
                        HCApplication.all_item.put("deviceId",uniqueID);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    Intent intent = new Intent(FamilyDetails.this, AgreementActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(context, "الرجاء اختيار البيانات ", Toast.LENGTH_LONG).show();
                }
            }
        });

        num_region = (Spinner) findViewById(R.id.num_region);
        num_region.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    String region_num = region_number.get(position).trim();
                    Lin_f.setVisibility(View.VISIBLE);
                    family_name.clear();
                    family_name.add(" الرجاء اختيار العائلة");
                    familyByNumericalRegionIds = HCApplication.mydb.getData("family", "NumericalAreaCode", region_num.trim());
                    //  family_name.add(" الرجاء اختيار العائلة");
                    for (int i = 0; i < familyByNumericalRegionIds.size(); i++) {
                        family_name.add(familyByNumericalRegionIds.get(i).getName());

                    }
                    dataAdapter = new ArrayAdapter<String>(context, R.layout.spinner_item, family_name);
                    family.setAdapter(dataAdapter);


                    // GetFamilyByNumericalId(region_num);
                    n = "n";
                } else {
                    Toast.makeText(context, getString(R.string.select_region_1), Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        family = (Spinner) findViewById(R.id.sp_family);
        dataAdapter = new ArrayAdapter<String>(context, R.layout.spinner_item, family_name);
        family.setAdapter(dataAdapter);

        if (!NetworkUtil.getConnectivityStatusString(context).equals("Not connected to Internet")) {
            int user_id = HCApplication.saveDataInSharedPrefrances.getFRomShard("User_Data", "user_id");
            if (HCApplication.mydb.getAllCotacts(TABLE_Region, COLUMN_Region_code).size() == 0) {
                getNumericalRegion(user_id);
                Log.d("loadfamily", "allRegion");
            } else {
                loadRegionAdapter();
            }
            if (HCApplication.mydb.getAllCotacts("family", "NumericalAreaCode").size() == 0) {
                if(HCApplication.saveDataInSharedPrefrances.getFRomShard("allfamily","check_family")!=1) {
                    GetAllFamilyByUserId(user_id);
                    Log.d("loadfamily", "Family");
                }
            }

        } else {
            loadRegionAdapter();
        }


        family.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    section1.setVisibility(View.VISIBLE);
                    section2.setVisibility(View.VISIBLE);
                    include1.setVisibility(View.VISIBLE);
                    include2.setVisibility(View.VISIBLE);
                    f = "f";
                    familyByNumericalRegionId = familyByNumericalRegionIds.get(position - 1);
                    center.setText(familyByNumericalRegionId.getCenterName());
                    try {
                        HCApplication.all_item.put("FamilyID", familyByNumericalRegionId.getID());
                        HCApplication.all_item.put("family_lat", familyByNumericalRegionId.getGPSX());
                        HCApplication.all_item.put("family_long", familyByNumericalRegionId.getGPSY());
                        HCApplication.saveDataInSharedPrefrances.save_data_int("family", "family_id", familyByNumericalRegionId.getID());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    mashmol.setText(familyByNumericalRegionId.getSubCity() + " " + familyByNumericalRegionId.getSubCityNo());
                    hara.setText(familyByNumericalRegionId.getHaraNo() + "  " + familyByNumericalRegionId.getHaraName());
                    district.setText(familyByNumericalRegionId.getSection() + "");
                    block.setText(familyByNumericalRegionId.getBlockNo() + "");
                    building.setText(familyByNumericalRegionId.getBuildNo() + "");
                    home.setText(familyByNumericalRegionId.getUnitNo() + " ");
                } else {
                    Toast.makeText(context, getString(R.string.select_family), Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGoogleMapsActivity(Double.parseDouble(familyByNumericalRegionId.getGPSY()), Double.parseDouble(familyByNumericalRegionId.getGPSX()));
            }
        });

        resetvalues();
        AllDataNumber();


    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void enableGps() {
        startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
    }

    private void startGoogleMapsActivity(double lat, double lang) {
        String s = "geo:" + lat + "," + lang;
        Uri gmmIntentUri = Uri.parse(s);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    public void getNumericalRegion(int user_id) {
        JsonArrayParser jsonArrayParser = new JsonArrayParser(getString(R.string.base_url), new CallBackJSONArray() {
            @Override
            public void onSuccess(retrofit2.Response<JsonArray> o) {
                String jsonString = o.body().toString();
                try {
                    JSONArray jsonArray = new JSONArray(jsonString);
                    region_number.clear();

                    Log.d("tttttttt", HCApplication.all_item.toString());
                    region_number.add("الرجاء اختيار منطقة  العد  ");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        region_number.add(jsonObject.getString("Code"));
                    }
                    if (region_number.size() > 1) {
                        HCApplication.mydb.insertContact(TABLE_Region, COLUMN_Region_code, region_number.toString());

                    }
                    dataAdapter = new ArrayAdapter<String>(context, R.layout.spinner_item, region_number);
                    num_region.setAdapter(dataAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void OnFail(Throwable o) {

            }
        });

        jsonArrayParser.GetNumRegion(HCApplication.newInstance().newRetrofitRequest(), user_id);

    }

    public void GetFamilyByNumericalId(String region_id) {
        JsonArrayParser jsonArrayParser = new JsonArrayParser(getString(R.string.base_url), new CallBackJSONArray() {
            @Override
            public void onSuccess(retrofit2.Response<JsonArray> o) {
                String jsonString = o.body().toString();
                addFamily(jsonString);
            }

            @Override
            public void OnFail(Throwable o) {

            }
        });
        jsonArrayParser.GetFamilyNumRegionID(HCApplication.newInstance().newRetrofitRequest(), region_id);
    }

    public void GetAllFamilyByUserId(int user_id) {
        JsonArrayParser jsonArrayParser = new JsonArrayParser(getString(R.string.base_url), new CallBackJSONArray() {
            @Override
            public void onSuccess(retrofit2.Response<JsonArray> o) {
                String jsonString = o.body().toString();
                Type listType = new TypeToken<List<AllfamilyFromDataBase>>() {
                }.getType();
                List<AllfamilyFromDataBase> allFamilies_fromdata = new Gson().fromJson(jsonString, listType);
                for (int i = 0; i < allFamilies_fromdata.size(); i++) {
                    AllfamilyFromDataBase allfamilyFromDataBase = allFamilies_fromdata.get(i);

                    Log.d("allitemsFromdata", allFamilies_fromdata.toString());

                    HCApplication.mydb.insertFamily("family", allfamilyFromDataBase.getID(), allfamilyFromDataBase.getNumericalAreaCode()
                            , allfamilyFromDataBase.getFamilyNo(), allfamilyFromDataBase.getName(), allfamilyFromDataBase.getCenter(),
                            allfamilyFromDataBase.getCenterName(), allfamilyFromDataBase.getSubCity(), allfamilyFromDataBase.getSubCityNo(), allfamilyFromDataBase.getCityName()
                            , allfamilyFromDataBase.getHaraName(), allfamilyFromDataBase.getHaraNo(), allfamilyFromDataBase.getSection(),
                            allfamilyFromDataBase.getBlockNo(), allfamilyFromDataBase.getBuildNo(), allfamilyFromDataBase.getUnitNo(),
                            allfamilyFromDataBase.getGPSX(), allfamilyFromDataBase.getGPSY(), allfamilyFromDataBase.getCreateDate());


                }
                HCApplication.saveDataInSharedPrefrances.save_data_int("allfamily","check_family",1);


            }

            @Override
            public void OnFail(Throwable o) {

            }
        });
        jsonArrayParser.GetAllFamilyNumRegionID(HCApplication.newInstance().newRetrofitRequest(), user_id);
    }


    void addFamily(String jsonString) {
        Type listType = new TypeToken<List<FamilyByNumericalRegionId>>() {
        }.getType();
        allFamilies = new Gson().fromJson(jsonString, listType);
        family_name.clear();
        family_name.add(" الرجاء اختيار العائلة");
        for (int i = 0; i < allFamilies.size(); i++) {
            family_name.add(allFamilies.get(i).getName());
        }
        dataAdapter.clear();
        dataAdapter = new ArrayAdapter<String>(context, R.layout.spinner_item, family_name);
        family.setAdapter(dataAdapter);
    }

    void loadRegionAdapter() {
        region_number.clear();
        dataAdapter.clear();
        region_number = new ArrayList<String>(Arrays.asList(HCApplication.mydb.getAllCotacts(TABLE_Region, COLUMN_Region_code).toString().replace("[[", "").replace("]]", "").split(",")));


        dataAdapter = new ArrayAdapter<String>(context, R.layout.spinner_item, region_number);
        num_region.setAdapter(dataAdapter);
    }

    public synchronized Integer upload(final AllITemes allITemes, final int id) {
        JSONStringParser jsonStringParser = new JSONStringParser(getString(R.string.base_url), new CallBackJSONString() {
            @Override
            public void onSuccess(Response<JsonPrimitive> o) {
                if (o.body() != null) {
                    if (o.body().toString().equals("true")) {
                        Toast.makeText(FamilyDetails.this, "تم حفظ كافة الإستبيانات المكتملة للخادم" + id, Toast.LENGTH_SHORT).show();
                        HCApplication.mydb.updateContact(TABLE_NAME, id, COLUMN_NAME, dataFromDataBase.getName(), COLUMN_CHeck, 0);
                        AllDataNumber();
                    } else {
                        Toast.makeText(FamilyDetails.this, "تعذر حفظ كافة الإستبيانات المكتملة للخادم", Toast.LENGTH_SHORT).show();
                        AllDataNumber();
                    }
                } else {
                    Toast.makeText(FamilyDetails.this, "تعذر حفظ كافة الإستبيانات المكتملة للخادم", Toast.LENGTH_SHORT).show();

                    AllDataNumber();
                }
            }

            @Override
            public void OnFail(Throwable o) {
                Toast.makeText(FamilyDetails.this, "تعذر حفظ كافة الإستبيانات المكتملة للخادم", Toast.LENGTH_SHORT).show();


            }
        });

        jsonStringParser.upload(HCApplication.newInstance().newRetrofitRequest(), allITemes);
        return id;
    }


    void resetvalues() {
        HCApplication.saveDataInSharedPrefrances.delete("Move_Shared");
        HCApplication.saveDataInSharedPrefrances.delete("family");
        HCApplication.saveDataInSharedPrefrances.delete("ActivityMove");
        HCApplication.saveDataInSharedPrefrances.delete("test");
        HCApplication.saveDataInSharedPrefrances.delete("Allitem");
        HCApplication.saveDataInSharedPrefrances.delete("hide_item");
        HCApplication.section200_check = 0;
        HCApplication.show_q4005 = 0;
        HCApplication.show_q6200 = 0;
        HCApplication.span_q6200 = 0;
        HCApplication.show_q6104 = 0;
        HCApplication.span_q6104 = 0;
        HCApplication.show_q6130 = 0;
        HCApplication.show_q6205 = 0;
        HCApplication.back_section = 0;
        HCApplication.show_5001 = 0;
        HCApplication.show_5002 = 0;
        HCApplication.show_5003 = 0;
        HCApplication.show_5004 = 0;
        HCApplication.show_5005 = 0;
        HCApplication.show_5006 = 0;
        HCApplication.show_5007 = 0;
        HCApplication.show_5008 = 0;
        HCApplication.show_5009 = 0;
        HCApplication.show_5010 = 0;
        HCApplication.show_5011 = 0;
        HCApplication.show_5012 = 0;
        HCApplication.show_5013 = 0;
        HCApplication.show_5014 = 0;
        HCApplication.show_5015 = 0;
        HCApplication.show_5016 = 0;
        HCApplication.show_5017 = 0;
        HCApplication.show_6001a = 0;
        HCApplication.show_6001b = 0;
        HCApplication.span_6102back = 0;
        HCApplication.show_6260 = 0;
        try {
            HCApplication.all_item = new JSONObject("{\"ID\":133,\"SupervisorStatus\":1,\"UserID\":0,\"PublishStatus\":2,\"Favorite\":1,\"Priority\":1,\"CreateDate\":\"2017\\/05\\/03 03:44:01\",\"FamilyID\":7777,\"Q0991\":7777,\"Q0992\":7777,\"Q0994\":7777,\"Q0995\":7777,\"Q0996\":7777,\"Q0997\":7777,\"Q0999a\":7777,\"Q0999b\":7777,\"Q1000x\":7777,\"Q1000y\":7777,\"Q4001\":7777,\"Q4002\":7777,\"Q4003\":7777,\"Q4004\":888,\"Q4005\":7777,\"Q4006\":7777,\"Q4007\":7777,\"Q4008\":7777,\"Q4009a\":7777,\"Q4009b\":7777,\"Q4009c\":7777,\"Q4009d\":7777,\"Q4009e\":7777,\"Q4009f\":7777,\"Q4009g\":7777,\"Q4009h\":7777,\"Q4009i\":7777,\"Q4009j\":7777,\"Q4009k\":7777,\"Q4009l\":7777,\"Q4009m\":7777,\"Q4010\":7777,\"Q4011a\":7777,\"Q4011b\":7777,\"Q4011c\":7777,\"Q4011d\":7777,\"Q4011e\":7777,\"Q4011f\":7777,\"Q4011g\":7777,\"Q4012\":7777,\"Q4013\":7777,\"Q4013a\":7777,\"Q4014a\":7777,\"Q4014b\":7777,\"Q4014c\":7777,\"Q4015\":7777,\"Q5901\":7777,\"Q5902\":7777,\"Q5001\":7777,\"Q5001a\":7777,\"Q5001b\":7777,\"Q5001c\":7777,\"Q5002\":7777,\"Q5002a\":7777,\"Q5002b\":7777,\"Q5002c\":7777,\"Q5003\":7777,\"Q5003a\":7777,\"Q5003b\":7777,\"Q5003c\":7777,\"Q5004\":7777,\"Q5004a\":7777,\"Q5004b\":7777,\"Q5004c\":7777,\"Q5005\":7777,\"Q5005a\":7777,\"Q5005b\":7777,\"Q5005c\":7777,\"Q5006\":7777,\"Q5006a\":7777,\"Q5006b\":7777,\"Q5006c\":7777,\"Q5007\":7777,\"Q5007a\":7777,\"Q5007b\":7777,\"Q5007c\":7777,\"Q5008\":7777,\"Q5008a\":7777,\"Q5008b\":7777,\"Q5008c\":7777,\"Q5009\":7777,\"Q5009a\":7777,\"Q5009b\":7777,\"Q5009c\":7777,\"Q5010\":7777,\"Q5010a\":7777,\"Q5010b\":7777,\"Q5010c\":7777,\"Q5011\":7777,\"Q5011a\":7777,\"Q5011b\":7777,\"Q5011c\":7777,\"Q5012\":7777,\"Q5012a\":7777,\"Q5012b\":7777,\"Q5012c\":7777,\"Q5013\":7777,\"Q5013a\":7777,\"Q5013b\":7777,\"Q5013c\":7777,\"Q5014\":7777,\"Q5014a\":7777,\"Q5014b\":7777,\"Q5014c\":7777,\"Q5015\":7777,\"Q5015a\":7777,\"Q5015b\":7777,\"Q5015c\":7777,\"Q5016\":7777,\"Q5016a\":7777,\"Q5016b\":7777,\"Q5016c\":7777,\"Q5017\":7777,\"Q5017a\":7777,\"Q5017b\":7777,\"Q5017c\":7777,\"Q5017d\":7777,\"Q6000\":7777,\"Q6002\":7777,\"Q6100\":7777,\"Q6101\":7777,\"Q6102\":7777,\"Q6103\":7777,\"Q6103a\":7777,\"Q6104\":7777,\"Q6110\":7777,\"Q6111\":7777,\"Q6112\":7777,\"Q6113\":7777,\"Q6120\":7777,\"Q6121\":7777,\"Q6122\":7777,\"Q6123\":7777,\"Q6130\":7777,\"Q6131\":7777,\"Q6132\":7777,\"Q6133\":7777,\"Q6140\":7777,\"Q6141\":7777,\"Q6142\":7777,\"Q6150\":7777,\"Q6151\":7777,\"Q6152\":7777,\"Q6160\":7777,\"Q6161\":7777,\"Q6162\":7777,\"Q6200\":7777,\"Q6201\":7777,\"Q6202\":7777,\"Q6203\":7777,\"Q6204\":7777,\"Q6204a\":7777,\"Q6205\":7777,\"Q6210\":7777,\"Q6211\":7777,\"Q6212\":7777,\"Q6220\":7777,\"Q6221\":7777,\"Q6222\":7777,\"Q6223\":7777,\"Q6230\":7777,\"Q6231\":7777,\"Q6232\":7777,\"Q6233\":7777,\"Q6240\":7777,\"Q6241\":7777,\"Q6242\":7777,\"Q6250\":7777,\"Q6251\":7777,\"Q6252\":7777,\"Q6300\":7777,\"Q6301\":7777,\"Q6302\":7777,\"Q6303\":7777,\"Q6304\":7777,\"Q6305\":7777,\"Q6306\":7777,\"Q6307\":7777,\"Q6308\":7777,\"Q6309\":7777,\"Q6310\":7777,\"Q6311\":7777,\"Q6312\":7777,\"Q6313\":7777,\"Q6400a\":7777,\"Q6400b\":7777,\"Q6400c\":7777,\"Q6400d\":7777,\"Q6400e\":7777,\"Q6400f\":7777,\"Q6400g\":7777,\"Q6400h\":7777,\"Q6400i\":7777,\"Q6400j\":7777,\"Q6401\":7777,\"Q6600\":7777,\"Q6001a\":7777,\"Q6001b\":7777,\"Q6260\":7777,\"Q6601a\":7777,\"Q6601b\":7777,\"Q6601c\":7777,\"Q6501\":7777,\"Q6502\":7777,\"Q6503\":7777,\"Q6504\":7777,\"Q6505\":7777,\"Q6506\":7777,\"Q6507\":7777,\"Q6508\":7777,\"Q6509\":7777,\"Q6510\":7777,\"Q6604\":7777,\"Q6605\":7777,\"Q6606\":7777,\"Q6607\":7777,\"Q6608\":7777,\"Q6609\":7777,\"Q6610\":7777,\"Q6611\":7777,\"startDate\":\"\",\"endDate\":\"2017\\/05\\/02 16:42:23\",\"comment\":\"\",\"family_lat\":\"\",\"family_long\":\"\",\"user_lat\":\"\",\"user_long\":\"\",\"Q0993\":[]}");
            HCApplication.all_selected = new JSONObject("{\"q4004\":\"\",\"q4005\":\"\",\"q4010\":\"\",\"q4013\":\"\",\"q5017\":\"\",\"q6001b\":\"\",\"q6103\":\"\",\"q6204\":\"\",\"Q6400j\":\"\"}");

        } catch (Exception e) {
        }

    }


    protected GoogleApiClient mGoogleApiClient;
    protected Location mLocation;
    private LocationRequest mLocationReq;
    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 1000;
    private static final int LOCATION_PERMISSION_REQUEST = 123;
    private final String TAG = "FamilyDetails";

    @Override
    protected void onStart() {
        super.onStart();
        {
            mGoogleApiClient.connect();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mGoogleApiClient != null && mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }
    }

    private boolean isPlayServicesAvailable() {
        int resultCode = GooglePlayServicesUtil
                .isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                GooglePlayServicesUtil.getErrorDialog(resultCode, this,
                        PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {

                finish();
            }
            Toast.makeText(getApplicationContext(),
                    "This device is not supported.", Toast.LENGTH_LONG)
                    .show();
            return false;
        }
        return true;
    }

    LocationSettingsRequest.Builder builder = null;
    PendingResult<LocationSettingsResult> result;

    private void createLocationRequest() {
//        LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
        mLocationReq = LocationRequest.create();
        mLocationReq.setInterval(5000);
        mLocationReq.setFastestInterval(1000);
        mLocationReq.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationReq, this);

        if (builder == null)
            builder = new LocationSettingsRequest.Builder()
                    .addLocationRequest(mLocationReq);
        if (result != null) return;

        result =
                LocationServices.SettingsApi.checkLocationSettings(mGoogleApiClient,
                        builder.build());
        result.setResultCallback(new ResultCallback<LocationSettingsResult>() {
            @Override
            public void onResult(@NonNull LocationSettingsResult locationSettingsResult) {
                final Status status = locationSettingsResult.getStatus();
                final LocationSettingsStates locationSettingsStates = locationSettingsResult.getLocationSettingsStates();
                String message = "";
                switch (status.getStatusCode()) {
                    case LocationSettingsStatusCodes.SUCCESS:
                        // All location settings are satisfied. The client can
                        // initialize location requests here.
                        message += "Success";
                        break;
                    case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                        message += "Required";

                        // Location settings are not satisfied, but this can be fixed
                        // by showing the user a dialog.
                        try {
//                         Show the dialog by calling startResolutionForResult(),
//                         and check the result in onActivityResult().
                            status.startResolutionForResult(
                                    FamilyDetails.this,
                                    REQUEST_CHECK_SETTINGS);
//
                        } catch (IntentSender.SendIntentException e) {
//                         Ignore the error.
                        }
                        break;
                    case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                        // Location settings are not satisfied. However, we have no way
                        // to fix the settings so we won't show the dialog.
                        message += "Failure";
                        onNoLocation(null);
                        break;
                }
                Log.e(TAG, "M " + message);
            }
        });
    }

    private void buildLocationApi() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();
    }

    private void requestLocationPermissions() {
        String[] permissions = new String[2];
        permissions[0] = Manifest.permission.ACCESS_FINE_LOCATION;
        permissions[1] = Manifest.permission.ACCESS_COARSE_LOCATION;
        ActivityCompat.requestPermissions(this, permissions, LOCATION_PERMISSION_REQUEST);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATION_PERMISSION_REQUEST
                && grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            onPermissionGranted();
        } else {
            onPermissionDenied();
        }
    }

    private boolean isLocationPermissionGranted(Context context) {
        return !(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED);
    }

    private void onPermissionGranted() {
        Log.e(TAG, "Granted");
        createLocationRequest();
        mLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        if (mLocation != null) {
            try {
                saveLocationToJson(mLocation);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        Log.i(TAG, " The Location: " + mLocation);
    }

    private boolean isGpsEnabled() {
        final LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        return (manager.isProviderEnabled(LocationManager.GPS_PROVIDER));
    }

    private void onPermissionDenied() {
        Log.e(TAG, "Denied");
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if (!isLocationPermissionGranted(this)) {
            Log.e(TAG, "Connected");
            requestLocationPermissions();
            return;
        }
        onPermissionGranted();
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.e(TAG, "Connection suspended");
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.e(TAG, "Connection Failed");
        onNoLocation(null);
    }

//    @Override
//    public void onLocationChanged(Location location) {
//        onLocationReceived(location);
//    }

    private void onLocationReceived(Location location) {
        String locationString = " ";
        Log.e(TAG, "Location " + locationString.toString());
        mLocation = location;
        if (mLocation != null) {
            locationString += " Last known location" + mLocation.toString();
            Log.e(TAG, locationString);
            try {
                saveLocationToJson(location);
            } catch (JSONException e) {
                Log.e(TAG, e.getMessage());
            }
        } else {
            locationString += "Couldn't get your location";
            onNoLocation(null);
        }
        Log.e(TAG, locationString);
    }

    private void saveLocationToJson(Location location) throws JSONException {
        HCApplication.all_item.put("Q1000x", location.getLatitude());
        HCApplication.all_item.put("Q1000y", location.getLongitude());
    }

    private void onNoLocation(@Nullable final String title) {
        //show dialog with the following text
//        if (isFinishing()) return;
        NoGpsDialog noGpsDialog = NoGpsDialog.newInstance(title);
        noGpsDialog.setRetryCallback(new NoGpsDialog.RetryCallback() {
            @Override
            public void onRetry() {
                if (!isGpsEnabled()) enableGps();
                createLocationRequest();
            }

            @Override
            public void onCancel() {
                if (!isGpsEnabled()) onNoLocation(title);
                mLocation = null;
            }
        });
        noGpsDialog.show(getFragmentManager(), TAG);
    }

    AlertDialog.Builder dialog;

    private void showGpsDialog() {
        // notify user
        dialog = new AlertDialog.Builder(this);
        dialog.setCancelable(false);
        dialog.setMessage(getString(R.string.enable_gps));
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                enableGps();
            }
        });
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showGpsDialog();
            }
        });
        dialog.create().show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        HCApplication.saveDataInSharedPrefrances.save_data_String("Allitem", "selectjson", HCApplication.all_item.toString());
        HCApplication.saveDataInSharedPrefrances.save_data_String("Allitem", "question", HCApplication.all_selected.toString());
    }

    @Override
    public void onLocationChanged(Location location) {
        onLocationReceived(location);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_CHECK_SETTINGS:
                if (resultCode == Activity.RESULT_OK) {
                    createLocationRequest();
                } else {
                    showGpsDialog();
                    Log.e(TAG, "User Canceled");
                }
                break;
            default:
                super.onActivityResult(requestCode, resultCode, data);
                break;
        }
    }

void AllDataNumber() {
    try {

        not_upload.setText( HCApplication.mydb.getColumnNameandValue(TABLE_NAME, 1).length()+"");
        upload_.setText(HCApplication.mydb.getColumnNameandValue(TABLE_NAME, 0).length()+"");
        all_item.setText(HCApplication.mydb.getAllCotacts(TABLE_NAME,COLUMN_NAME).size()+"");

    } catch (JSONException e) {
        e.printStackTrace();
    }
}
}
