package com.shc.SHC_SS.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shc.SHC_SS.R;
import com.shc.SHC_SS.adapter.Section6140Adapter;
import com.shc.SHC_SS.utilies.HCApplication;
import com.shc.SHC_SS.utilies.ReadQuestionFromJsonFile;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jawdah on 3/26/2017.
 */

public class Section6140 extends BaseFragment {
    ReadQuestionFromJsonFile readQuestionFromJsonFile = new ReadQuestionFromJsonFile();
    RecyclerView  mRecyclerView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        HCApplication.view = inflater.inflate(R.layout.testgrid, container, false);
        readQuestionFromJsonFile = new ReadQuestionFromJsonFile();
//        RecyclerView mRecyclerView = (RecyclerView) HCApplication.view.findViewById(R.id.recycler_view);
//        RtlGridLayoutManager gridLayoutManager = new RtlGridLayoutManager(HCApplication.newInstance().context, 3);
//        mRecyclerView.setLayoutManager(gridLayoutManager);
        HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "open_screen", 4);
        HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "Value_Name", 5);
        HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "Value_Back", 3);
        HCApplication.check.clear();
        return HCApplication.view;

    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        HCApplication.move_ment.clear();
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore last state for checked position.
            addQ();
            ArrayList<Integer> select_items= savedInstanceState.getIntegerArrayList("section6122");
            addValue(select_items);
        }
        else {

        }
    }

    @Override
    public void onResume() {
        HCApplication.move_ment.clear();
        super.onResume();
        addQ();
        String  select = HCApplication.saveDataInSharedPrefrances.getStringFRomShard("test", "section6122").replace("[", "").replace("]", "");
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
    public void onPause() {
        super.onPause();
        HCApplication.saveDataInSharedPrefrances.save_data_String("test", "section6122", HCApplication.check.toString());
        HCApplication.saveDataInSharedPrefrances.save_data_String("test", "move6122", HCApplication.move_ment.toString());

        HCApplication.check.clear();

    }

    void addValue(ArrayList select_items){
        Section6140Adapter customAdapter = new Section6140Adapter(HCApplication.newInstance().context, HCApplication.question, HCApplication.stringArrayList, HCApplication.question_name,0,select_items);
        mRecyclerView=HCApplication.newInstance().assingRecycler(HCApplication.view,3,"Section6140");
        mRecyclerView.setAdapter(customAdapter);
    }


    void addQ(){


        try {
            HCApplication.question_name.clear();
            HCApplication.question.clear();
            HCApplication.stringArrayList.clear();
            HCApplication.addQuestionOrTitle.addTitle("title", getString(R.string.section6140));
            HCApplication.addQuestionOrTitle.addQuestion("Q6140", "status_iteration");
            HCApplication.addQuestionOrTitle.addQuestion("q6141", "status_iteration");
            HCApplication.addQuestionOrTitle.addQuestion("q6142", "status_range");
            HCApplication.addQuestionOrTitle.addTitle("title", getString(R.string.section6122hh));
            HCApplication.addQuestionOrTitle.addQuestion("q6150", "r6150");
            HCApplication.addQuestionOrTitle.addQuestion("q6151", "r6151");
            HCApplication.addQuestionOrTitle.addQuestion("q6152", "probability");

            HCApplication.addQuestionOrTitle.addTitle("title", getString(R.string.section6122hh3));
            HCApplication.addQuestionOrTitle.addQuestion("q6160", "status_range");
            HCApplication.addQuestionOrTitle.addQuestion("q6161", "status_range");
            HCApplication.addQuestionOrTitle.addQuestion("q6162", "status_range");
            String  move = HCApplication.saveDataInSharedPrefrances.getStringFRomShard("test", "move6122").replace("[", "").replace("]", "");

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