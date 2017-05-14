package com.shc.SHC_SS.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shc.SHC_SS.R;
import com.shc.SHC_SS.adapter.Section6400Adapter;
import com.shc.SHC_SS.utilies.HCApplication;
import com.shc.SHC_SS.utilies.ReadQuestionFromJsonFile;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jawdah on 3/28/2017.
 */

public class Section6400 extends BaseFragment {

    ReadQuestionFromJsonFile readQuestionFromJsonFile = new ReadQuestionFromJsonFile();
    JSONArray section6400_items = new JSONArray();
    RecyclerView  mRecyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        HCApplication.view = inflater.inflate(R.layout.testgrid, container, false);
        HCApplication.move_ment.clear();
        readQuestionFromJsonFile = new ReadQuestionFromJsonFile();
//        RecyclerView mRecyclerView = (RecyclerView) HCApplication.view.findViewById(R.id.recycler_view);
//        RtlGridLayoutManager gridLayoutManager = new RtlGridLayoutManager(HCApplication.newInstance().context, 3);
//        mRecyclerView.setLayoutManager(gridLayoutManager);

        HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "Value_Name", 9);
        HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "Value_Back", 7);
        HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "open_screen", 8);
        HCApplication.check.clear();
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
            ArrayList<Integer> select_items= savedInstanceState.getIntegerArrayList("Section6400Adapter");
            addValue(select_items);
        }
        else {


        }
    }

    @Override
    public void onResume() {
        super.onResume();
        addQ();
        String  select = HCApplication.saveDataInSharedPrefrances.getStringFRomShard("test", "Section6400Adapter").replace("[", "").replace("]", "");
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
       // outState.putIntegerArrayList("Section6400Adapter", HCApplication.check);
    }


    @Override
    public void onPause() {
        super.onPause();
        HCApplication.saveDataInSharedPrefrances.save_data_String("test", "Section6400Adapter", HCApplication.check.toString());
        HCApplication.check.clear();
        HCApplication.saveDataInSharedPrefrances.save_data_String("test", "move6400", HCApplication.move_ment.toString());


    }

    void addValue(ArrayList select_items){
        Section6400Adapter customAdapter = new Section6400Adapter(HCApplication.newInstance().context, HCApplication.question, HCApplication.stringArrayList, HCApplication.question_name,0,select_items);
        mRecyclerView=HCApplication.newInstance().assingRecycler(HCApplication.view,3,"Section6400Adapter");
        mRecyclerView.setAdapter(customAdapter);

    }


    void addQ(){
        try {
            HCApplication.question_name.clear();
            HCApplication.question.clear();
            HCApplication.stringArrayList.clear();
            HCApplication.move_ment.clear();
            HCApplication.addQuestionOrTitle.addTitle("title", getString(R.string.section6400b));
            section6400_items = readQuestionFromJsonFile.getArrayFromJson("q6400");
            JSONArray q_name_section =new JSONArray();
            q_name_section=HCApplication.readQuestionFromJsonFile.getArrayFromJson("allq6400");
            HCApplication.addQuestionOrTitle.addQuestionValue(section6400_items.get(0).toString(),q_name_section.get(0).toString(), "yesorno");
            HCApplication.addQuestionOrTitle.addQuestionValue(section6400_items.get(1).toString(),q_name_section.get(1).toString(), "yesorno");
            HCApplication.addQuestionOrTitle.addQuestionValue(section6400_items.get(2).toString(),q_name_section.get(2).toString(), "yesorno");
            HCApplication.addQuestionOrTitle.addQuestionValue(section6400_items.get(3).toString(),q_name_section.get(3).toString(), "yesorno");
            HCApplication.addQuestionOrTitle.addQuestionValue(section6400_items.get(4).toString(),q_name_section.get(4).toString(), "yesorno");
            HCApplication.addQuestionOrTitle.addQuestionValue(section6400_items.get(5).toString(),q_name_section.get(5).toString(), "yesorno");
            HCApplication.addQuestionOrTitle.addQuestionValue(section6400_items.get(6).toString(),q_name_section.get(6).toString(), "yesorno");
            HCApplication.addQuestionOrTitle.addQuestionValue(section6400_items.get(7).toString(),q_name_section.get(7).toString(), "yesorno");
            HCApplication.addQuestionOrTitle.addQuestionValue(section6400_items.get(8).toString(),q_name_section.get(8).toString(), "yesorno");
            HCApplication.addQuestionOrTitle.addQuestionValue(section6400_items.get(9).toString(),q_name_section.get(9).toString(), "yesorno");
            HCApplication.addQuestionOrTitle.addQuestion("q6401", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestion("q6600", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestion("q6601a", "yesorno");
            HCApplication.addQuestionOrTitle.addQuestion("q6601b", "r6601b");
            HCApplication.addQuestionOrTitle.addQuestion("q6601c", "r6601b");
            String  move = HCApplication.saveDataInSharedPrefrances.getStringFRomShard("test", "move6400").replace("[", "").replace("]", "");

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