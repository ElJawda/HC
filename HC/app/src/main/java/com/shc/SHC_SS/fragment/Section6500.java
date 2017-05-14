package com.shc.SHC_SS.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shc.SHC_SS.R;
import com.shc.SHC_SS.adapter.Section6500Adapter;
import com.shc.SHC_SS.utilies.HCApplication;
import com.shc.SHC_SS.utilies.ReadQuestionFromJsonFile;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by A.Elsayed on 4/22/2017.
 */

public class Section6500  extends BaseFragment {

    ReadQuestionFromJsonFile readQuestionFromJsonFile = new ReadQuestionFromJsonFile();
    JSONArray section6400_items = new JSONArray();
    RecyclerView mRecyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        HCApplication.move_ment.clear();
        HCApplication.view = inflater.inflate(R.layout.testgrid, container, false);
        readQuestionFromJsonFile = new ReadQuestionFromJsonFile();
        HCApplication.check.clear();
//        RecyclerView mRecyclerView = (RecyclerView) HCApplication.view.findViewById(R.id.recycler_view);
//        RtlGridLayoutManager gridLayoutManager = new RtlGridLayoutManager(HCApplication.newInstance().context, 3);
//        mRecyclerView.setLayoutManager(gridLayoutManager);

        HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "Value_Name", 10);
        HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "Value_Back", 8);
        HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "open_screen", 9);

        //replaceHeader.addHeader(view, R.id.sec6400h, getString(R.string.section6400b), getString(R.string.section6400h));
        // addValueto_item_Two_radio("Q6300", "yesorno", customRadioGroup, customRaidoButton, R.id.q1);

        return HCApplication.view;

    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore last state for checked position.
            addQ();
            ArrayList<Integer> select_items= savedInstanceState.getIntegerArrayList("Section6500");
            addValue(select_items);
        }
        else {

        }
    }

    @Override
    public void onResume() {
        super.onResume();
        addQ();
        String  select = HCApplication.saveDataInSharedPrefrances.getStringFRomShard("test", "Section6500").replace("[", "").replace("]", "");
        if (select.length()!=0) {
            ArrayList<String> se = new ArrayList<String>(Arrays.asList(select.split(",")));
            HCApplication.check.clear();
            HCApplication.check=se;
            addValue(se);

        } else {
            addValue(HCApplication.check);

        }


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
       // outState.putIntegerArrayList("Section6500", HCApplication.check);
    }


    @Override
    public void onPause() {
        super.onPause();
        HCApplication.saveDataInSharedPrefrances.save_data_String("test", "Section6500", HCApplication.check.toString());
        HCApplication.saveDataInSharedPrefrances.save_data_String("test", "move6500", HCApplication.move_ment.toString());

        HCApplication.check.clear();

    }

    void addValue(ArrayList select_items){
        Section6500Adapter customAdapter = new Section6500Adapter(HCApplication.newInstance().context, HCApplication.question, HCApplication.stringArrayList, HCApplication.question_name,0,select_items);
        mRecyclerView=HCApplication.newInstance().assingRecycler(HCApplication.view,3,"Section6500");
        mRecyclerView.setAdapter(customAdapter);

    }


    void addQ(){
        try {
            HCApplication.question_name.clear();
            HCApplication.question.clear();
            HCApplication.stringArrayList.clear();
            HCApplication.move_ment.clear();
            HCApplication.addQuestionOrTitle.addTitle("title", getString(R.string.section_6500));
            HCApplication.addQuestionOrTitle.addQuestion("q6501", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestion("q6502", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestion("q6503", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestion("q6504", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestion("q6505", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestion("q6506", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestion("q6507", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestion("q6508", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestion("q6509", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestion("q6510", "yesorno");

            String  move = HCApplication.saveDataInSharedPrefrances.getStringFRomShard("test", "move6500").replace("[", "").replace("]", "");
            if (move.length()!=0) {
                ArrayList<String> se = new ArrayList<String>(Arrays.asList(move.split(",")));
                HCApplication.move_ment.clear();
                for(String a:se){
                    HCApplication.move_ment.add(a.trim());
                }


            }








        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}