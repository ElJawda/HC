package com.shc.SHC_SS.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shc.SHC_SS.R;
import com.shc.SHC_SS.adapter.Section6000To6122Adapter;
import com.shc.SHC_SS.utilies.HCApplication;
import com.shc.SHC_SS.utilies.ReadQuestionFromJsonFile;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jawdah on 3/22/2017.
 */

public class Section6000To6122 extends BaseFragment {
    ReadQuestionFromJsonFile readQuestionFromJsonFile = new ReadQuestionFromJsonFile();
    RecyclerView  mRecyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        HCApplication.view = inflater.inflate(R.layout.testgrid, container, false);
        readQuestionFromJsonFile = new ReadQuestionFromJsonFile();
        HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "open_screen", 3);
        HCApplication.check.clear();
        HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "Value_Name", 4);
        HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "Value_Back", 2);
        HCApplication.move_ment.clear();
        return HCApplication.view;

    }

    @Override
    public void onResume() {
        super.onResume();
        HCApplication.move_ment.clear();
        addQ();
        String  select = HCApplication.saveDataInSharedPrefrances.getStringFRomShard("test", "Section6000To6122").replace("[", "").replace("]", "");
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
        HCApplication.saveDataInSharedPrefrances.save_data_String("test", "Section6000To6122", HCApplication.check.toString());
        HCApplication.check.clear();
        HCApplication.saveDataInSharedPrefrances.save_data_String("test", "move6000", HCApplication.move_ment.toString());

    }

    void addValue(ArrayList select_items){
        Section6000To6122Adapter customAdapter = new Section6000To6122Adapter(HCApplication.newInstance().context, HCApplication.question, HCApplication.stringArrayList, HCApplication.question_name,0,select_items);
        mRecyclerView=HCApplication.newInstance().assingRecycler(HCApplication.view,3,"Section6000To6122");
        mRecyclerView.setAdapter(customAdapter);
    }


    void addQ(){


        try {
            HCApplication.question_name.clear();
            HCApplication.question.clear();
            HCApplication.stringArrayList.clear();
            HCApplication.addQuestionOrTitle.addTitle("title", getString(R.string.section6000h1));
            HCApplication.addQuestionOrTitle.addTitle("title", getString(R.string.section6000));
            HCApplication.addQuestionOrTitle.addQuestion("q6000", "r6000");
            // 6001a and 6001b
            HCApplication.show_6001a= HCApplication.saveDataInSharedPrefrances.getFRomShard("hide_item","show_6001a");

            if (HCApplication.show_6001a==1) {
                HCApplication.addQuestionOrTitle.addQuestion("q6001a", "r6001a");
            }
            HCApplication.show_6001b= HCApplication.saveDataInSharedPrefrances.getFRomShard("hide_item","show_6001b");

            if (HCApplication.show_6001b==1) {
                HCApplication.addQuestionOrTitle.addQuestion("q6001b", "r6001b");
            }


            HCApplication.addQuestionOrTitle.addQuestion("q6002", "ministry");
            HCApplication.addQuestionOrTitle.addTitle("title", getString(R.string.section6000ht));
            HCApplication.addQuestionOrTitle.addQuestion("q6100", "r6100");
            HCApplication.addQuestionOrTitle.addQuestion("q6101", "status_iteration");
            HCApplication.addQuestionOrTitle.addQuestion("q6102", "yesorno");
            HCApplication.show_q6104= HCApplication.saveDataInSharedPrefrances.getFRomShard("hide_item","show_q6104");
            if (HCApplication.show_q6104==0) {
                HCApplication.addQuestionOrTitle.addQuestion("q6103", "r6103");
            }
            HCApplication.addQuestionOrTitle.addQuestion("q6104", "status_range");
            HCApplication.addQuestionOrTitle.addTitle("title",getString(R.string.section6110));
            HCApplication.addQuestionOrTitle.addQuestion("q6110", "status_iteration");
            HCApplication.addQuestionOrTitle.addQuestion("q6111", "status_iteration");
            HCApplication.addQuestionOrTitle.addQuestion("q6112", "status_iteration");
            HCApplication.addQuestionOrTitle.addQuestion("q6113", "status_range");

            HCApplication.addQuestionOrTitle.addTitle("title",getString(R.string.section6120));
            HCApplication.addQuestionOrTitle.addQuestion("q6120", "status_iteration");
            HCApplication.addQuestionOrTitle.addQuestion("q6121", "status_iteration");
            HCApplication.addQuestionOrTitle.addQuestion("q6122", "status_iteration");
            HCApplication.addQuestionOrTitle.addQuestion("q6123", "status_range");
            HCApplication.addQuestionOrTitle.addTitle("title", getString(R.string.section6122h));
            HCApplication.addQuestionOrTitle.addQuestion("q6130", "yesorno");
            HCApplication.show_q6130= HCApplication.saveDataInSharedPrefrances.getFRomShard("hide_item","show_q6130");

            if (HCApplication.show_q6130==0) {
                HCApplication.addQuestionOrTitle.addQuestion("q6131", "status_iteration");
            }
            HCApplication.addQuestionOrTitle.addQuestion("q6132", "status_iteration");
            HCApplication.addQuestionOrTitle.addQuestion("q6133", "probability");

            String  move = HCApplication.saveDataInSharedPrefrances.getStringFRomShard("test", "move6000").replace("[", "").replace("]", "");
            if (move.length()!=0) {
                ArrayList<String> se = new ArrayList<String>(Arrays.asList(move.split(",")));
                HCApplication.move_ment.clear();
                for(String a:se){
                    HCApplication.move_ment.add(a.trim());
                }



            }
        } catch (Exception e) {
            e.printStackTrace();
        }}


}
