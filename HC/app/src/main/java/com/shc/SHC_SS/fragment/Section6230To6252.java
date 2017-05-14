package com.shc.SHC_SS.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.shc.SHC_SS.R;
import com.shc.SHC_SS.adapter.Section6230Adapter;
import com.shc.SHC_SS.utilies.HCApplication;
import com.shc.SHC_SS.utilies.ReadQuestionFromJsonFile;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jawdah on 3/27/2017.
 */

public class Section6230To6252 extends BaseFragment {
    ReadQuestionFromJsonFile readQuestionFromJsonFile = new ReadQuestionFromJsonFile();
    RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        HCApplication.move_ment.clear();
        HCApplication.view = inflater.inflate(R.layout.testgrid, container, false);
        readQuestionFromJsonFile = new ReadQuestionFromJsonFile();
        HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "Value_Name", 7);
        HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "Value_Back", 5);
        HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "open_screen", 6);
        HCApplication.check.clear();
        return HCApplication.view;

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            addQ();
            ArrayList<Integer> select_items = savedInstanceState.getIntegerArrayList("Section6230To6252");
            addValue(select_items);
        } else {


        }
    }

    @Override
    public void onResume() {
        super.onResume();
        HCApplication.move_ment.clear();
        addQ();
        String select = HCApplication.saveDataInSharedPrefrances.getStringFRomShard("test", "Section6230To6252").replace("[", "").replace("]", "");
        if (select.length() != 0) {
            ArrayList<String> se = new ArrayList<String>(Arrays.asList(select.split(",")));
            HCApplication.check.clear();
            HCApplication.check = se;
            addValue(se);

        } else {
            addValue(HCApplication.check);

        }


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // outState.putIntegerArrayList("Section6230To6252", HCApplication.check);
    }


    @Override
    public void onPause() {
        super.onPause();
        HCApplication.saveDataInSharedPrefrances.save_data_String("test", "Section6230To6252", HCApplication.check.toString());
        HCApplication.check.clear();
        HCApplication.saveDataInSharedPrefrances.save_data_String("test", "move6230", HCApplication.move_ment.toString());


    }

    void addValue(ArrayList select_items) {
        Section6230Adapter customAdapter = new Section6230Adapter(HCApplication.newInstance().context, HCApplication.question, HCApplication.stringArrayList, HCApplication.question_name, 0, select_items);
        mRecyclerView = HCApplication.newInstance().assingRecycler(HCApplication.view, 3, "Section6230To6252");
        mRecyclerView.setAdapter(customAdapter);


    }


    void addQ() {
        try {

            HCApplication.question_name.clear();
            HCApplication.question.clear();
            HCApplication.stringArrayList.clear();
            HCApplication.move_ment.clear();
            HCApplication.show_6260 = HCApplication.saveDataInSharedPrefrances.getFRomShard("hide_item", "show_6260");
            if (HCApplication.show_6260 == 0) {
                HCApplication.addQuestionOrTitle.addTitle("title", getString(R.string.sec630));
                HCApplication.addQuestionOrTitle.addQuestion("q6230", "yesorno");
                HCApplication.show_6231 = HCApplication.saveDataInSharedPrefrances.getFRomShard("hide_item", "show_6231");
                if (HCApplication.show_6231 == 0) {
                    HCApplication.addQuestionOrTitle.addQuestion("q6231", "status_iteration");
                }
                HCApplication.addQuestionOrTitle.addQuestion("q6232", "status_iteration");
                HCApplication.addQuestionOrTitle.addQuestion("q6233", "probability");
                HCApplication.addQuestionOrTitle.addTitle("title", getString(R.string.section6230h));
                HCApplication.addQuestionOrTitle.addQuestion("q6240", "status_iteration");
                HCApplication.addQuestionOrTitle.addQuestion("q6241", "status_iteration");
                HCApplication.addQuestionOrTitle.addQuestion("q6242", "status_range");
                HCApplication.addQuestionOrTitle.addTitle("title", getString(R.string.section6230hh));
                HCApplication.addQuestionOrTitle.addQuestion("q6250", "r6150");
                HCApplication.addQuestionOrTitle.addQuestion("q6251", "r6251");
                HCApplication.addQuestionOrTitle.addQuestion("q6252", "probability");
            }
            HCApplication.addQuestionOrTitle.addQuestion("q6260", "r6260");

            String move = HCApplication.saveDataInSharedPrefrances.getStringFRomShard("test", "move6230").replace("[", "").replace("]", "");
            if (move.length() != 0) {
                ArrayList<String> se = new ArrayList<String>(Arrays.asList(move.split(",")));
                HCApplication.move_ment.clear();
                for (String a : se) {
                    HCApplication.move_ment.add(a.trim());
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
