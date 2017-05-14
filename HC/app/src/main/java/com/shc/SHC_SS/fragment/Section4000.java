package com.shc.SHC_SS.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shc.SHC_SS.R;
import com.shc.SHC_SS.adapter.RtlGridLayoutManager;
import com.shc.SHC_SS.adapter.Section4000Adapter;
import com.shc.SHC_SS.entities.Language;
import com.shc.SHC_SS.parser.data.JsonArrayParser;
import com.shc.SHC_SS.retrofit.CallBackJSONArray;
import com.shc.SHC_SS.utilies.HCApplication;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Response;

/**
 * Created by Ahmed Mahmoud on 4/8/2017.
 */

public class Section4000 extends BaseFragment {
    public static View view;
    JSONArray section4000question = new JSONArray();
    JSONArray section4000response = new JSONArray();

    JSONArray section4011question = new JSONArray();
    JSONArray section4011response = new JSONArray();

    JSONArray section4014response = new JSONArray();
    JSONArray section4014question = new JSONArray();
    public static Section4000Adapter customAdapter;
    RtlGridLayoutManager gridLayoutManager;
    RecyclerView mRecyclerView;
    List<Language> all_laguage_list;
    ArrayList<Integer> lan_id = new ArrayList<Integer>();
    String select;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        HCApplication.view = inflater.inflate(R.layout.testgrid, container, false);
        HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "open_screen", 1);
        HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "Value_Name", 2);
        HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "Value_Back", 0);
        return HCApplication.view;

    }

    void getLanguage(final ArrayList selectitems) {
        JsonArrayParser jsonArrayParser = new JsonArrayParser(HCApplication.context.getString(R.string.base_url), new CallBackJSONArray() {
            @Override
            public void onSuccess(Response<JsonArray> o) {

                String jsonString = o.body().toString();
                Log.i("onResponse", jsonString);
                readData(jsonString, selectitems);

            }

            @Override
            public void OnFail(Throwable o) {

            }
        });
        jsonArrayParser.getLanguage(HCApplication.newInstance().newRetrofitRequest());
    }


    public void readData(String jsonString, ArrayList select_items) {
        Type listType = new TypeToken<List<Language>>() {
        }.getType();
        all_laguage_list = new Gson().fromJson(jsonString, listType);
        lan_id.clear();
        JsonArray lan_name = new JsonArray();

        for (int i = 0; i < all_laguage_list.size(); i++) {
            int a = i;
            lan_name.add(all_laguage_list.get(i).getName());
        }
        try {
            HCApplication.addQuestionOrTitle.addQuestionValueSpinner("q4001", lan_name.toString());
            HCApplication.addQuestionOrTitle.addQuestion("q4002", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestion("q4003", "gender");
            HCApplication.addQuestionOrTitle.addQuestion("q4004", "age_stage");
            HCApplication.show_q4005= HCApplication.saveDataInSharedPrefrances.getFRomShard("hide_item","show_q4005");

            if (HCApplication.show_q4005==0)
            {
                HCApplication.addQuestionOrTitle.addQuestion("q4005", "r4005");

            }

            HCApplication.addQuestionOrTitle.addQuestion("q4006", "r4006");
            HCApplication.addQuestionOrTitle.addQuestion("q4007", "Countries");
            HCApplication.addQuestionOrTitle.addQuestion("q4008", "r4008");
            HCApplication.addQuestionOrTitle.addTitle("title", getString(R.string.section_4009));
            section4000question = HCApplication.readQuestionFromJsonFile.getArrayFromJson("q4009all");
            section4000response = HCApplication.readQuestionFromJsonFile.getArrayFromJson("r4009all");
            HCApplication.addQuestionOrTitle.addQuestionValue(section4000response.get(0).toString().toString().trim(), section4000question.get(0) + "", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestionValue(section4000response.get(1).toString().trim(), section4000question.get(1) + "", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestionValue(section4000response.get(2).toString().trim(), section4000question.get(2) + "", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestionValue(section4000response.get(3).toString().trim(), section4000question.get(3) + "", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestionValue(section4000response.get(4).toString().trim(), section4000question.get(4) + "", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestionValue(section4000response.get(5).toString().trim(), section4000question.get(5) + "", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestionValue(section4000response.get(6).toString().trim(), section4000question.get(6) + "", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestionValue(section4000response.get(7).toString().trim(), section4000question.get(7) + "", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestionValue(section4000response.get(8).toString().trim(), section4000question.get(8) + "", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestionValue(section4000response.get(9).toString().trim(), section4000question.get(9) + "", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestionValue(section4000response.get(10).toString().trim(), section4000question.get(10) + "", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestionValue(section4000response.get(11).toString().trim(), section4000question.get(11) + "", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestionValue(section4000response.get(12).toString().trim(), section4000question.get(12) + "", "r4009m");

            HCApplication.addQuestionOrTitle.addQuestion("q4010", "yesorno");
            section4011question = HCApplication.readQuestionFromJsonFile.getArrayFromJson("q4011all");
            HCApplication.addQuestionOrTitle.addTitle("title", getString(R.string.section_4011));
            section4011response = HCApplication.readQuestionFromJsonFile.getArrayFromJson("r4011all");
            HCApplication.addQuestionOrTitle.addQuestionValue(section4011response.get(0).toString(), section4011question.get(0) + "", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestionValue(section4011response.get(1).toString(), section4011question.get(1) + "", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestionValue(section4011response.get(2).toString(), section4011question.get(2) + "", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestionValue(section4011response.get(3).toString(), section4011question.get(3) + "", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestionValue(section4011response.get(4).toString(), section4011question.get(4) + "", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestionValue(section4011response.get(5).toString(), section4011question.get(5) + "", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestionValue(section4011response.get(6).toString(), section4011question.get(6) + "", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestion("q4012", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestion("q4013", "r4013");
            HCApplication.addQuestionOrTitle.addTitle("title", getString(R.string.section4014));
            section4014response = HCApplication.readQuestionFromJsonFile.getArrayFromJson("r4014all");
            section4014question = HCApplication.readQuestionFromJsonFile.getArrayFromJson("q4014all");
            HCApplication.addQuestionOrTitle.addQuestionValue(section4014response.get(0).toString(), section4014question.get(0) + "", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestionValue(section4014response.get(1).toString(), section4014question.get(1) + "", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestionValue(section4014response.get(2).toString(), section4014question.get(2) + "", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestion("q4015", "r4015all");
            ///move ment
            String move  = HCApplication.saveDataInSharedPrefrances.getStringFRomShard("test", "move4000").replace("[", "").replace("]", "");
            Log.d("movetes",move);
            if (move.length() != 0) {
                HCApplication.move_ment.clear();
                ArrayList<String> se = new ArrayList<String>(Arrays.asList(move.split(",")));
               for(String a:se){
                  HCApplication.move_ment.add(a.trim());
               }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        customAdapter = new Section4000Adapter(HCApplication.newInstance().context, HCApplication.question, HCApplication.stringArrayList, HCApplication.question_name, 0, select_items);
        mRecyclerView = HCApplication.newInstance().assingRecycler(HCApplication.view, 3, "Section4000");
        mRecyclerView.setAdapter(customAdapter);
        // Creating adapter for spinner
        //  region.setAdapter(dataAdapter);
        Log.i("onResponse", all_laguage_list.toString());

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
      //  HCApplication.move_ment.clear();
        if (savedInstanceState != null) {
            // Restore last state for checked position.
            ArrayList<Integer> select_items = savedInstanceState.getIntegerArrayList("section400");

            try {
                HCApplication.question_name.clear();
                HCApplication.question.clear();
                HCApplication.stringArrayList.clear();
                HCApplication.check_remove = 0;
                HCApplication.addQuestionOrTitle.addTitle("title", getString(R.string.section_4000));
                    String va = HCApplication.newInstance().loadJSONFromAsset("language.json");
                    readData(va, select_items);
            } catch (Exception e) {

                Log.d("exeption", e.getMessage());
            }


        } else {

        }
    }

    @Override
    public void onResume() {
        super.onResume();
        try {
            HCApplication.question_name.clear();
            HCApplication.question.clear();
            HCApplication.stringArrayList.clear();
            HCApplication.move_ment.clear();

            HCApplication.check_remove = 0;
            HCApplication.addQuestionOrTitle.addTitle("title", getString(R.string.section_4000));
            select = HCApplication.saveDataInSharedPrefrances.getStringFRomShard("test", "section").replace("[", "").replace("]", "");
            if (select.length() != 0) {
                ArrayList<String> se = new ArrayList<String>(Arrays.asList(select.split(",")));
                HCApplication.check.clear();
                HCApplication.check = se;
                addarray(se);

            } else {
                addarray(HCApplication.check);

            }


            ////////

        } catch (Exception e) {

            Log.d("exeption", e.getMessage());
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        HCApplication.saveDataInSharedPrefrances.save_data_String("test", "section", HCApplication.check.toString());
        Log.d("movetes",HCApplication.move_ment.size()+"");
        HCApplication.saveDataInSharedPrefrances.save_data_String("test", "move4000", HCApplication.move_ment.toString());

        HCApplication.check.clear();

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("test", HCApplication.check.toString());
       // outState.putIntegerArrayList("section400", HCApplication.check);
    }


    public void addarray(ArrayList<String> arrr) {
            String va = HCApplication.newInstance().loadJSONFromAsset("language.json");
            readData(va, arrr);


    }
}
