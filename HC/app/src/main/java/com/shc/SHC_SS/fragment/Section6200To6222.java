package com.shc.SHC_SS.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shc.SHC_SS.R;
import com.shc.SHC_SS.adapter.Section6200To6222Adapter;
import com.shc.SHC_SS.utilies.HCApplication;
import com.shc.SHC_SS.utilies.ReadQuestionFromJsonFile;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jawdah on 3/27/2017.
 */

public class Section6200To6222 extends BaseFragment {

    ReadQuestionFromJsonFile readQuestionFromJsonFile = new ReadQuestionFromJsonFile();
    RecyclerView  mRecyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        HCApplication.move_ment.clear();
        HCApplication.view = inflater.inflate(R.layout.testgrid, container, false);
        readQuestionFromJsonFile = new ReadQuestionFromJsonFile();
        HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "open_screen", 5);
        HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "Value_Name", 6);
        HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "Value_Back", 4);

        HCApplication.check.clear();
        Log.d("ttttttttttttttttt","ewrwerwer");


        return HCApplication.view;

    }




    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore last state for checked position.
            addQ();
            ArrayList<Integer> select_items= savedInstanceState.getIntegerArrayList("Section6200To6222Adapter");
            addValue(select_items);
        }
        else {


        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
       // outState.putIntegerArrayList("Section6200To6222Adapter", HCApplication.check);
    }


    @Override
    public void onResume() {
        HCApplication.move_ment.clear();
        super.onResume();
        addQ();
        String  select = HCApplication.saveDataInSharedPrefrances.getStringFRomShard("test", "Section6200To6222Adapter").replace("[", "").replace("]", "");
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
        HCApplication.saveDataInSharedPrefrances.save_data_String("test", "Section6200To6222Adapter", HCApplication.check.toString());
        HCApplication.check.clear();
        HCApplication.saveDataInSharedPrefrances.save_data_String("test", "move6200", HCApplication.move_ment.toString());


    }

    void addValue(ArrayList select_items){
        Section6200To6222Adapter customAdapter = new Section6200To6222Adapter(HCApplication.newInstance().context, HCApplication.question, HCApplication.stringArrayList, HCApplication.question_name,0,select_items);
        mRecyclerView=HCApplication.newInstance().assingRecycler(HCApplication.view,3,"Section6200To6222Adapter");
        mRecyclerView.setAdapter(customAdapter);
    }


    void addQ(){


        try {
            HCApplication.question_name.clear();
            HCApplication.question.clear();
            HCApplication.stringArrayList.clear();
            HCApplication.addQuestionOrTitle.addTitle("title", getString(R.string.section6200t));
            HCApplication.addQuestionOrTitle.addTitle("title", getString(R.string.section6200h1));
            HCApplication.addQuestionOrTitle.addQuestion("q6200", "r6200");
            HCApplication.addQuestionOrTitle.addQuestion("q6201", "r6100");
            HCApplication.addQuestionOrTitle.addQuestion("Q6202", "status_iteration");
            HCApplication.addQuestionOrTitle.addQuestion("Q6203", "yesorno");
            HCApplication.show_q6205= HCApplication.saveDataInSharedPrefrances.getFRomShard("hide_item","show_q6205");

            if(HCApplication.show_q6205==0) {
                HCApplication.addQuestionOrTitle.addQuestion("q6204", "r6103");
            }
            HCApplication.addQuestionOrTitle.addQuestion("q6205", "status_range");
            HCApplication.addQuestionOrTitle.addTitle("title", getString(R.string.section6200));
            HCApplication.addQuestionOrTitle.addQuestion("q6210", "status_iteration");
            HCApplication.addQuestionOrTitle.addQuestion("q6211", "status_iteration");
            HCApplication.addQuestionOrTitle.addQuestion("q6212", "status_range");
            HCApplication.addQuestionOrTitle.addTitle("title", getString(R.string.section6200hh));
            HCApplication.addQuestionOrTitle.addQuestion("q6220", "status_iteration");
            HCApplication.addQuestionOrTitle.addQuestion("q6221", "status_iteration");
            HCApplication.addQuestionOrTitle.addQuestion("q6222", "status_iteration");
            HCApplication.addQuestionOrTitle.addQuestion("q6223", "status_range");

            String  move = HCApplication.saveDataInSharedPrefrances.getStringFRomShard("test", "move6200").replace("[", "").replace("]", "");
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
