package com.shc.SHC_SS.utilies;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.shc.SHC_SS.adapter.RtlGridLayoutManager;
import com.shc.SHC_SS.database.DBHelper;
import com.shc.SHC_SS.entities.AllQuestionValues;
import com.shc.SHC_SS.R;
import com.shc.SHC_SS.retrofit.RetrofitInterface;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jawdah on 3/19/2017.
 */

//  use this class to  make shard object and function  in  all  app
public class HCApplication extends Application {
    private static String BASE_URL = "http://www.eservices.shc.gov.sa/HealthSystemResponseApi/api/";
    public static Context context;
    public static ArrayList<String> check = new ArrayList<String>();
    public static ArrayList<String> stringArrayList = new ArrayList<String>();
    public static ArrayList<String> question = new ArrayList<String>();
    public static ArrayList<String> question_name = new ArrayList<String>();
    public static SaveDataInSharedPrefrances saveDataInSharedPrefrances;
    public static ReadQuestionFromJsonFile readQuestionFromJsonFile;
    public static AddQuestionOrTitle addQuestionOrTitle;
    public static View view;
    public static RecyclerView mRecyclerView;
    public static ArrayList<String> check_select_child = new ArrayList<>();
    public static AllQuestionValues AllQuestionValues;
    public static int check_remove;
    public static MyIntent myIntent;
    public static int check_section6230;
    public static ArrayList<String> move_ment = new ArrayList<String>();


    public static JSONObject all_item = new JSONObject();
    public static JSONObject all_selected = new JSONObject();
    public static String fragment_name;
    public static DBHelper mydb;
    public static ArrayList section4000_selected_items = new ArrayList();
    public static int chech_Back;
    public static int section200_check = 0;
    public static int show_q4005 = 0;
    public static int show_q6200 = 0;
    public static int span_q6200 = 0;
    public static int show_q6104 = 0;
    public static int span_q6104 = 0;
    public static int show_q6130 = 0;
    public static int show_q6205 = 0;
    public static int back_section = 0;
    public static int show_5001 = 0;
    public static int show_5002 = 0;
    public static int show_5003 = 0;
    public static int show_5004 = 0;
    public static int show_5005 = 0;
    public static int show_5006 = 0;
    public static int show_5007 = 0;
    public static int show_5008 = 0;
    public static int show_5009 = 0;
    public static int show_5010 = 0;
    public static int show_5011 = 0;
    public static int show_5012 = 0;
    public static int show_5013 = 0;
    public static int show_5014 = 0;
    public static int show_5015 = 0;
    public static int show_5016 = 0;
    public static int show_5017 = 0;
    public static int show_6001a = 0;
    public static int show_6001b = 0;
    public static int span_6102back = 0;
    public static int show_6260 = 0;
    public static int  show_6231=0;


    // general  object of application
    public static HCApplication newInstance() {
        return new HCApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        check_select_child.add("assa");
        check_select_child.add("assa");
        check_select_child.add("assa");

        BASE_URL = getResources().getString(R.string.base_url);
        context = getApplicationContext();
        saveDataInSharedPrefrances = new SaveDataInSharedPrefrances();
        readQuestionFromJsonFile = new ReadQuestionFromJsonFile();
        addQuestionOrTitle = new AddQuestionOrTitle();
        parsjson(loadJSONFromAsset("allquestion.json"));
        myIntent = new MyIntent();
        mydb=new DBHelper();
        try {
            String selected = HCApplication.saveDataInSharedPrefrances.getStringFRomShard("Allitem", "selectjson");
            String question = HCApplication.saveDataInSharedPrefrances.getStringFRomShard("Allitem", "question");

            if (selected.length() != 0) {
                all_item = new JSONObject(selected);
            } else {
                all_item = new JSONObject("{\"ID\":133,\"SupervisorStatus\":1,\"UserID\":0,\"PublishStatus\":2,\"Favorite\":1,\"Priority\":1,\"CreateDate\":\"2017\\/05\\/03 03:44:01\",\"FamilyID\":7777,\"Q0991\":7777,\"Q0992\":7777,\"Q0994\":7777,\"Q0995\":7777,\"Q0996\":7777,\"Q0997\":7777,\"Q0999a\":7777,\"Q0999b\":7777,\"Q1000x\":7777,\"Q1000y\":7777,\"Q4001\":7777,\"Q4002\":7777,\"Q4003\":7777,\"Q4004\":888,\"Q4005\":7777,\"Q4006\":7777,\"Q4007\":7777,\"Q4008\":7777,\"Q4009a\":7777,\"Q4009b\":7777,\"Q4009c\":7777,\"Q4009d\":7777,\"Q4009e\":7777,\"Q4009f\":7777,\"Q4009g\":7777,\"Q4009h\":7777,\"Q4009i\":7777,\"Q4009j\":7777,\"Q4009k\":7777,\"Q4009l\":7777,\"Q4009m\":7777,\"Q4010\":7777,\"Q4011a\":7777,\"Q4011b\":7777,\"Q4011c\":7777,\"Q4011d\":7777,\"Q4011e\":7777,\"Q4011f\":7777,\"Q4011g\":7777,\"Q4012\":7777,\"Q4013\":7777,\"Q4013a\":7777,\"Q4014a\":7777,\"Q4014b\":7777,\"Q4014c\":7777,\"Q4015\":7777,\"Q5901\":7777,\"Q5902\":7777,\"Q5001\":7777,\"Q5001a\":7777,\"Q5001b\":7777,\"Q5001c\":7777,\"Q5002\":7777,\"Q5002a\":7777,\"Q5002b\":7777,\"Q5002c\":7777,\"Q5003\":7777,\"Q5003a\":7777,\"Q5003b\":7777,\"Q5003c\":7777,\"Q5004\":7777,\"Q5004a\":7777,\"Q5004b\":7777,\"Q5004c\":7777,\"Q5005\":7777,\"Q5005a\":7777,\"Q5005b\":7777,\"Q5005c\":7777,\"Q5006\":7777,\"Q5006a\":7777,\"Q5006b\":7777,\"Q5006c\":7777,\"Q5007\":7777,\"Q5007a\":7777,\"Q5007b\":7777,\"Q5007c\":7777,\"Q5008\":7777,\"Q5008a\":7777,\"Q5008b\":7777,\"Q5008c\":7777,\"Q5009\":7777,\"Q5009a\":7777,\"Q5009b\":7777,\"Q5009c\":7777,\"Q5010\":7777,\"Q5010a\":7777,\"Q5010b\":7777,\"Q5010c\":7777,\"Q5011\":7777,\"Q5011a\":7777,\"Q5011b\":7777,\"Q5011c\":7777,\"Q5012\":7777,\"Q5012a\":7777,\"Q5012b\":7777,\"Q5012c\":7777,\"Q5013\":7777,\"Q5013a\":7777,\"Q5013b\":7777,\"Q5013c\":7777,\"Q5014\":7777,\"Q5014a\":7777,\"Q5014b\":7777,\"Q5014c\":7777,\"Q5015\":7777,\"Q5015a\":7777,\"Q5015b\":7777,\"Q5015c\":7777,\"Q5016\":7777,\"Q5016a\":7777,\"Q5016b\":7777,\"Q5016c\":7777,\"Q5017\":7777,\"Q5017a\":7777,\"Q5017b\":7777,\"Q5017c\":7777,\"Q5017d\":7777,\"Q6000\":7777,\"Q6002\":7777,\"Q6100\":7777,\"Q6101\":7777,\"Q6102\":7777,\"Q6103\":7777,\"Q6103a\":7777,\"Q6104\":7777,\"Q6110\":7777,\"Q6111\":7777,\"Q6112\":7777,\"Q6113\":7777,\"Q6120\":7777,\"Q6121\":7777,\"Q6122\":7777,\"Q6123\":7777,\"Q6130\":7777,\"Q6131\":7777,\"Q6132\":7777,\"Q6133\":7777,\"Q6140\":7777,\"Q6141\":7777,\"Q6142\":7777,\"Q6150\":7777,\"Q6151\":7777,\"Q6152\":7777,\"Q6160\":7777,\"Q6161\":7777,\"Q6162\":7777,\"Q6200\":7777,\"Q6201\":7777,\"Q6202\":7777,\"Q6203\":7777,\"Q6204\":7777,\"Q6204a\":7777,\"Q6205\":7777,\"Q6210\":7777,\"Q6211\":7777,\"Q6212\":7777,\"Q6220\":7777,\"Q6221\":7777,\"Q6222\":7777,\"Q6223\":7777,\"Q6230\":7777,\"Q6231\":7777,\"Q6232\":7777,\"Q6233\":7777,\"Q6240\":7777,\"Q6241\":7777,\"Q6242\":7777,\"Q6250\":7777,\"Q6251\":7777,\"Q6252\":7777,\"Q6300\":7777,\"Q6301\":7777,\"Q6302\":7777,\"Q6303\":7777,\"Q6304\":7777,\"Q6305\":7777,\"Q6306\":7777,\"Q6307\":7777,\"Q6308\":7777,\"Q6309\":7777,\"Q6310\":7777,\"Q6311\":7777,\"Q6312\":7777,\"Q6313\":7777,\"Q6400a\":7777,\"Q6400b\":7777,\"Q6400c\":7777,\"Q6400d\":7777,\"Q6400e\":7777,\"Q6400f\":7777,\"Q6400g\":7777,\"Q6400h\":7777,\"Q6400i\":7777,\"Q6400j\":7777,\"Q6401\":7777,\"Q6600\":7777,\"Q6001a\":7777,\"Q6001b\":7777,\"Q6260\":7777,\"Q6601a\":7777,\"Q6601b\":7777,\"Q6601c\":7777,\"Q6501\":7777,\"Q6502\":7777,\"Q6503\":7777,\"Q6504\":7777,\"Q6505\":7777,\"Q6506\":7777,\"Q6507\":7777,\"Q6508\":7777,\"Q6509\":7777,\"Q6510\":7777,\"Q6604\":7777,\"Q6605\":7777,\"Q6606\":7777,\"Q6607\":7777,\"Q6608\":7777,\"Q6609\":7777,\"Q6610\":7777,\"Q6611\":7777,\"startDate\":\"\",\"endDate\":\"2017\\/05\\/02 16:42:23\",\"comment\":\"\",\"family_lat\":\"\",\"family_long\":\"\",\"user_lat\":\"\",\"user_long\":\"\",\"Q0993\":[]}");
            }
            if (question.length() != 0) {
                all_selected = new JSONObject(question);

            } else {
                all_selected = new JSONObject("{\"q4004\":\"\",\"q4005\":\"\",\"q4010\":\"\",\"q4013\":\"\",\"q5017\":\"\",\"q6001b\":\"\",\"q6103\":\"\",\"q6204\":\"\",\"Q6400j\":\"\"}");
                Log.d("testtttt",all_selected.toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    // make object for retrofit
    public RetrofitInterface newRetrofitRequest() {
        Retrofit retrofit = null;
        RetrofitInterface retrofitInterface = null;
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getRequestHeader())
                .build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);
        return retrofitInterface;
    }

    public RecyclerView assingRecycler(View view, int grid_column_number, final String fragment_name) {
        this.fragment_name = fragment_name;
        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        RtlGridLayoutManager gridLayoutManager = new RtlGridLayoutManager(HCApplication.newInstance().context, grid_column_number);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (HCApplication.stringArrayList.get(position).equals("")) {
                    return 3;
                } else return 1;

            }
        });
        mRecyclerView.setLayoutManager(gridLayoutManager);
        return mRecyclerView;
    }

    public String loadJSONFromAsset(String name) {
        String json = null;
        try {
            // use the general  context
            InputStream is = HCApplication.newInstance().context.getAssets().open(name);

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

    public AllQuestionValues parsjson(String json) {
        Gson gson = new Gson();
        Type listType = new TypeToken<AllQuestionValues>() {
        }.getType();
        AllQuestionValues = gson.fromJson(json, listType);
        return AllQuestionValues;
    }


    public void preventLocalization() {
        Resources res = HCApplication.context.getResources();
        Locale locale = new Locale("en");
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        res.updateConfiguration(config, res.getDisplayMetrics());
    }

    private OkHttpClient getRequestHeader() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();

        return client;
    }
    @Override
    public void onTerminate() {
        super.onTerminate();
    }

}
