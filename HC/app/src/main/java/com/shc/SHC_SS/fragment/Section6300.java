package com.shc.SHC_SS.fragment;

/**
 * Created by jawdah on 3/27/2017.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shc.SHC_SS.R;
import com.shc.SHC_SS.adapter.Section6300Adapter;
import com.shc.SHC_SS.utilies.HCApplication;
import com.shc.SHC_SS.utilies.ReadQuestionFromJsonFile;

import java.util.ArrayList;
import java.util.Arrays;

public class Section6300 extends BaseFragment {
    ReadQuestionFromJsonFile readQuestionFromJsonFile = new ReadQuestionFromJsonFile();

    RecyclerView  mRecyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        HCApplication.view = inflater.inflate(R.layout.testgrid, container, false);
        readQuestionFromJsonFile = new ReadQuestionFromJsonFile();
        HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "Value_Name", 8);
        HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "Value_Back",6);
        HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "open_screen", 7);
        HCApplication.check.clear();
        HCApplication.move_ment.clear();
        return HCApplication.view;

    }
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        if (savedInstanceState != null) {
//            // Restore last state for checked position.
//            addQ();
//            ArrayList<Integer> select_items= savedInstanceState.getIntegerArrayList("Section6300");
//            addValue(select_items);
//        }
//        else {
//
//
//        }
//    }

    @Override
    public void onResume() {
        super.onResume();
        HCApplication.move_ment.clear();
        addQ();
        String  select = HCApplication.saveDataInSharedPrefrances.getStringFRomShard("test", "Section6300").replace("[", "").replace("]", "");
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
      //  outState.putIntegerArrayList("Section6300", HCApplication.check);
    }


    @Override
    public void onPause() {
        super.onPause();
        HCApplication.saveDataInSharedPrefrances.save_data_String("test", "Section6300", HCApplication.check.toString());
        HCApplication.saveDataInSharedPrefrances.save_data_String("test", "move6300", HCApplication.move_ment.toString());
        HCApplication.check.clear();

    }

    void addValue(ArrayList select_items){
        Section6300Adapter customAdapter = new Section6300Adapter(HCApplication.newInstance().context, HCApplication.question, HCApplication.stringArrayList, HCApplication.question_name,0,select_items);
        mRecyclerView=HCApplication.newInstance().assingRecycler(HCApplication.view,3,"Section6300");
        mRecyclerView.setAdapter(customAdapter);
    }


    void addQ(){

        try {
            HCApplication.question_name.clear();
            HCApplication.question.clear();
            HCApplication.stringArrayList.clear();
            HCApplication.move_ment.clear();
            HCApplication.addQuestionOrTitle.addTitle("title", getString(R.string.section6300h));
            HCApplication.addQuestionOrTitle.addQuestion("q6300", "r6300");
            HCApplication.addQuestionOrTitle.addQuestion("q6301", "ministry");
            HCApplication.addQuestionOrTitle.addQuestion("q6302", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestion("q6303", "status_iteration");
            HCApplication.addQuestionOrTitle.addQuestion("q6304", "status_range");
            HCApplication.addQuestionOrTitle.addQuestion("q6305", "status_range");
            HCApplication.addQuestionOrTitle.addQuestion("q6306", "status_range");
            HCApplication.addQuestionOrTitle.addQuestion("q6307", "probability");
            HCApplication.addQuestionOrTitle.addQuestion("q6308", "r6308");
            HCApplication.addQuestionOrTitle.addQuestion("q6309", "probability");
            HCApplication.addQuestionOrTitle.addQuestion("q6310", "status_range");
            HCApplication.addQuestionOrTitle.addQuestion("q6311", "r6150");
            HCApplication.addQuestionOrTitle.addQuestion("q6312", "r6150");
            HCApplication.addQuestionOrTitle.addQuestion("q6313", "probability");
            String  move = HCApplication.saveDataInSharedPrefrances.getStringFRomShard("test", "move6300").replace("[", "").replace("]", "");
            if (move.length()!=0) {
                ArrayList<String> se = new ArrayList<String>(Arrays.asList(move.split(",")));
                HCApplication.move_ment.clear();
                for(String a:se){
                    HCApplication.move_ment.add(a.trim());
                }


            }
            HCApplication.back_section =0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
