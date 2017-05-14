package com.shc.SHC_SS.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shc.SHC_SS.R;
import com.shc.SHC_SS.adapter.Section6600Adapter;
import com.shc.SHC_SS.utilies.HCApplication;
import com.shc.SHC_SS.utilies.ReadQuestionFromJsonFile;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by A.Elsayed on 4/22/2017.
 */

public class Section6604 extends BaseFragment {

    ReadQuestionFromJsonFile readQuestionFromJsonFile = new ReadQuestionFromJsonFile();
    JSONArray section6400_items = new JSONArray();
    RecyclerView mRecyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        HCApplication.view = inflater.inflate(R.layout.testgrid, container, false);
        readQuestionFromJsonFile = new ReadQuestionFromJsonFile();
        HCApplication.move_ment.clear();
//        RecyclerView mRecyclerView = (RecyclerView) HCApplication.view.findViewById(R.id.recycler_view);
//        RtlGridLayoutManager gridLayoutManager = new RtlGridLayoutManager(HCApplication.newInstance().context, 3);
//        mRecyclerView.setLayoutManager(gridLayoutManager);

        HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "Value_Name", 11);
        HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "Value_Back", 9);
        HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "open_screen", 10);
        HCApplication.check.clear();
        //replaceHeader.addHeader(view, R.id.sec6400h, getString(R.string.section6400b), getString(R.string.section6400h));
        // addValueto_item_Two_radio("Q6300", "yesorno", customRadioGroup, customRaidoButton, R.id.q1);

        return HCApplication.view;

    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        HCApplication.move_ment.clear();
        if (savedInstanceState != null) {
            // Restore last state for checked position.
            addQ();
            ArrayList<Integer> select_items= savedInstanceState.getIntegerArrayList("Section6600");
            addValue(select_items);
        }
        else {



        }
    }

    @Override
    public void onResume() {
        super.onResume();
        addQ();
        String  select = HCApplication.saveDataInSharedPrefrances.getStringFRomShard("test", "Section6600").replace("[", "").replace("]", "");
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
      //  outState.putIntegerArrayList("Section6600", HCApplication.check);
    }


    @Override
    public void onPause() {
        super.onPause();
        HCApplication.saveDataInSharedPrefrances.save_data_String("test", "Section6600", HCApplication.check.toString());
        HCApplication.saveDataInSharedPrefrances.save_data_String("test", "move6600", HCApplication.move_ment.toString());

        HCApplication.check.clear();

    }

    void addValue(ArrayList select_items){
        Section6600Adapter customAdapter = new Section6600Adapter(
                HCApplication.newInstance().context, HCApplication.question, HCApplication.stringArrayList, HCApplication.question_name,0,select_items);
        mRecyclerView=HCApplication.newInstance().assingRecycler(HCApplication.view,3,"Section6600");
        mRecyclerView.setAdapter(customAdapter);

    }


    void addQ(){
        try {
            HCApplication.question_name.clear();
            HCApplication.question.clear();
            HCApplication.stringArrayList.clear();
            HCApplication.move_ment.clear();
            HCApplication.addQuestionOrTitle.addTitle("title", getString(R.string.sectio_6600));
            HCApplication.addQuestionOrTitle.addQuestion("q6604", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestion("q6605", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestion("q6606", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestion("q6607", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestion("q6608", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestion("q6609", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestion("q6610", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestion("q6611", "yesorno");
            String  move = HCApplication.saveDataInSharedPrefrances.getStringFRomShard("test", "move6600").replace("[", "").replace("]", "");
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