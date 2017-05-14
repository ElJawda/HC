package com.shc.SHC_SS.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shc.SHC_SS.R;
import com.shc.SHC_SS.adapter.Section5000Adapter;
import com.shc.SHC_SS.utilies.HCApplication;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jawdah on 3/28/2017.
 */

public class Section5000 extends BaseFragment {
    //public static View view;
    RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        HCApplication.view = inflater.inflate(R.layout.testgrid, container, false);
        HCApplication.check.clear();

        HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "open_screen", 2);
        HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "Value_Name", 3);
        HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "Value_Back", 1);
        return HCApplication.view;

    }


    @Override
    public void onResume() {
        super.onResume();
        assignValues();


    }

    public  void assignValues(){
        addQ();
        String select = HCApplication.saveDataInSharedPrefrances.getStringFRomShard("test", "section5000").replace("[", "").replace("]", "");
        if (select.length() != 0) {
            ArrayList<String> se = new ArrayList<String>(Arrays.asList(select.split(",")));
            HCApplication.check.clear();
            HCApplication.check = se;
            addValue(se);

        } else {
            addValue(HCApplication.check);

        }

        Log.d("DataLoaded","done");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
       // outState.putIntegerArrayList("section500", HCApplication.check);
    }


    @Override
    public void onPause() {
        super.onPause();
        HCApplication.saveDataInSharedPrefrances.save_data_String("test", "section5000", HCApplication.check.toString());
        HCApplication.saveDataInSharedPrefrances.save_data_String("test", "move5000", HCApplication.move_ment.toString());

        HCApplication.check.clear();
        HCApplication.move_ment.clear();


    }

    void addValue(ArrayList select_items) {
        Section5000Adapter customAdapter = new Section5000Adapter(HCApplication.newInstance().context, HCApplication.question, HCApplication.stringArrayList, HCApplication.question_name, 0, select_items);
        mRecyclerView = HCApplication.newInstance().assingRecycler(HCApplication.view, 3, "Section5000Adapter");
        mRecyclerView.setAdapter(customAdapter);
    }



    void addQ() {

        try {
            HCApplication.question_name.clear();
            HCApplication.question.clear();
            HCApplication.stringArrayList.clear();
            HCApplication.move_ment.clear();

            HCApplication.addQuestionOrTitle.addTitle("title", getString(R.string.section5000h));
            //  HCApplication.addQuestionOrTitle.addTitle("q","");
            //  HCApplication.addQuestionOrTitle. addQuestion(HCApplication.AllQuestionValues.getQ5901(), HCApplication.AllQuestionValues.getStatusIteration());
            HCApplication.addQuestionOrTitle.addQuestion("q5901", "status_range1");
            HCApplication.addQuestionOrTitle.addQuestion("q5902", "r5902");
            HCApplication.addQuestionOrTitle.addTitle("title", getString(R.string.section5000));
            HCApplication.addQuestionOrTitle.addQuestion("q5001", "r5001");
            HCApplication.show_5001= HCApplication.saveDataInSharedPrefrances.getFRomShard("hide_item","show_5001");

            if (HCApplication.show_5001 == 0) {
                HCApplication.addQuestionOrTitle.addQuestion("q5001a", "yesorno");
                HCApplication.addQuestionOrTitle.addQuestion("q5001b", "yesorno");
                HCApplication.addQuestionOrTitle.addQuestion("q5001c", "yesorno");
            }
            HCApplication.show_5002= HCApplication.saveDataInSharedPrefrances.getFRomShard("hide_item","show_5002");

            HCApplication.addQuestionOrTitle.addQuestion("q5002", "r5002");
            if (HCApplication.show_5002 == 0) {
                HCApplication.addQuestionOrTitle.addQuestion("q5002a", "yesorno");
                HCApplication.addQuestionOrTitle.addQuestion("q5002b", "yesorno");
                HCApplication.addQuestionOrTitle.addQuestion("q5002c", "yesorno");
            }
            HCApplication.show_5003= HCApplication.saveDataInSharedPrefrances.getFRomShard("hide_item","show_5003");

            HCApplication.addQuestionOrTitle.addQuestion("q5003", "r5003");
            if (HCApplication.show_5003 == 0) {
                HCApplication.addQuestionOrTitle.addQuestion("q5003a", "yesorno");
                HCApplication.addQuestionOrTitle.addQuestion("q5003b", "yesorno");
                HCApplication.addQuestionOrTitle.addQuestion("q5003c", "yesorno");
            }
            HCApplication.show_5004= HCApplication.saveDataInSharedPrefrances.getFRomShard("hide_item","show_5004");

            HCApplication.addQuestionOrTitle.addQuestion("q5004", "r5004");
            if (HCApplication.show_5004 == 0) {
                HCApplication.addQuestionOrTitle.addQuestion("q5004a", "yesorno");
                HCApplication.addQuestionOrTitle.addQuestion("q5004b", "yesorno");
                HCApplication.addQuestionOrTitle.addQuestion("q5004c", "yesorno");
            }
            HCApplication.show_5005= HCApplication.saveDataInSharedPrefrances.getFRomShard("hide_item","show_5005");

            HCApplication.addQuestionOrTitle.addQuestion("q5005", "r5005");
            if (HCApplication.show_5005 == 0) {
                HCApplication.addQuestionOrTitle.addQuestion("q5005a", "yesorno");
                HCApplication.addQuestionOrTitle.addQuestion("q5005b", "yesorno");
                HCApplication.addQuestionOrTitle.addQuestion("q5005c", "yesorno");
            }
            HCApplication.show_5006= HCApplication.saveDataInSharedPrefrances.getFRomShard("hide_item","show_5006");

            HCApplication.addQuestionOrTitle.addQuestion("q5006", "r5006");
            if (HCApplication.show_5006 == 0) {
                HCApplication.addQuestionOrTitle.addQuestion("q5006a", "yesorno");
                HCApplication.addQuestionOrTitle.addQuestion("q5006b", "yesorno");
                HCApplication.addQuestionOrTitle.addQuestion("q5006c", "yesorno");
            }
            HCApplication.show_5007= HCApplication.saveDataInSharedPrefrances.getFRomShard("hide_item","show_5007");

            HCApplication.addQuestionOrTitle.addQuestion("q5007", "r5007");
            if (HCApplication.show_5007 == 0) {
                HCApplication.addQuestionOrTitle.addQuestion("q5007a", "yesorno");
                HCApplication.addQuestionOrTitle.addQuestion("q5007b", "yesorno");
                HCApplication.addQuestionOrTitle.addQuestion("q5007c", "yesorno");
            }
            HCApplication.show_5008= HCApplication.saveDataInSharedPrefrances.getFRomShard("hide_item","show_5008");

            HCApplication.addQuestionOrTitle.addQuestion("q5008", "r5008");
            if (HCApplication.show_5008 == 0) {
                HCApplication.addQuestionOrTitle.addQuestion("q5008a", "yesorno");
                HCApplication.addQuestionOrTitle.addQuestion("q5008b", "yesorno");
                HCApplication.addQuestionOrTitle.addQuestion("q5008c", "yesorno");
            }
            HCApplication.show_5009= HCApplication.saveDataInSharedPrefrances.getFRomShard("hide_item","show_5009");

            HCApplication.addQuestionOrTitle.addQuestion("q5009", "r5009");
            if (HCApplication.show_5009 == 0) {
                HCApplication.addQuestionOrTitle.addQuestion("q5009a", "yesorno");
                HCApplication.addQuestionOrTitle.addQuestion("q5009b", "yesorno");
                HCApplication.addQuestionOrTitle.addQuestion("q5009c", "yesorno");
            }
            HCApplication.show_5010= HCApplication.saveDataInSharedPrefrances.getFRomShard("hide_item","show_5010");

            HCApplication.addQuestionOrTitle.addQuestion("q5010", "r5010");
            if (HCApplication.show_5010 == 0) {
                HCApplication.addQuestionOrTitle.addQuestion("q5010a", "yesorno");
                HCApplication.addQuestionOrTitle.addQuestion("q5010b", "yesorno");
                HCApplication.addQuestionOrTitle.addQuestion("q5010c", "yesorno");
            }
            HCApplication.show_5011= HCApplication.saveDataInSharedPrefrances.getFRomShard("hide_item","show_5011");

            HCApplication.addQuestionOrTitle.addQuestion("q5011", "r5011");
            if (HCApplication.show_5011 == 0) {
                HCApplication.addQuestionOrTitle.addQuestion("q5011a", "yesorno");
                HCApplication.addQuestionOrTitle.addQuestion("q5011b", "yesorno");
                HCApplication.addQuestionOrTitle.addQuestion("q5011c", "yesorno");
            }
            HCApplication.show_5012= HCApplication.saveDataInSharedPrefrances.getFRomShard("hide_item","show_5012");

            HCApplication.addQuestionOrTitle.addQuestion("q5012", "r5012");
            if (HCApplication.show_5012 == 0) {
                HCApplication.addQuestionOrTitle.addQuestion("q5012a", "yesorno");
                HCApplication.addQuestionOrTitle.addQuestion("q5012b", "yesorno");
                HCApplication.addQuestionOrTitle.addQuestion("q5012c", "yesorno");
            }
            HCApplication.show_5013= HCApplication.saveDataInSharedPrefrances.getFRomShard("hide_item","show_5013");

            HCApplication.addQuestionOrTitle.addQuestion("q5013", "r5013");
            if (HCApplication.show_5013 == 0) {
                HCApplication.addQuestionOrTitle.addQuestion("q5013a", "yesorno");
                HCApplication.addQuestionOrTitle.addQuestion("q5013b", "yesorno");
                HCApplication.addQuestionOrTitle.addQuestion("q5013c", "yesorno");
            }
            HCApplication.show_5014= HCApplication.saveDataInSharedPrefrances.getFRomShard("hide_item","show_5014");

            HCApplication.addQuestionOrTitle.addQuestion("q5014", "r5014");
            if (HCApplication.show_5014 == 0) {
                HCApplication.addQuestionOrTitle.addQuestion("q5014a", "yesorno");
                HCApplication.addQuestionOrTitle.addQuestion("q5014b", "yesorno");
                HCApplication.addQuestionOrTitle.addQuestion("q5014c", "yesorno");
            }
            HCApplication.show_5015= HCApplication.saveDataInSharedPrefrances.getFRomShard("hide_item","show_5015");

            HCApplication.addQuestionOrTitle.addQuestion("q5015", "r5015");
            if (HCApplication.show_5015 == 0) {
                HCApplication.addQuestionOrTitle.addQuestion("q5015a", "yesorno");
                HCApplication.addQuestionOrTitle.addQuestion("q5015b", "yesorno");
                HCApplication.addQuestionOrTitle.addQuestion("q5015c", "yesorno");
            }
            HCApplication.show_5016= HCApplication.saveDataInSharedPrefrances.getFRomShard("hide_item","show_5016");

            HCApplication.addQuestionOrTitle.addQuestion("q5016", "r5016");
            if (HCApplication.show_5016 == 0) {
                HCApplication.addQuestionOrTitle.addQuestion("q5016a", "yesorno");
                HCApplication.addQuestionOrTitle.addQuestion("q5016b", "yesorno");
                HCApplication.addQuestionOrTitle.addQuestion("q5016c", "yesorno");
            }
            HCApplication.show_5017= HCApplication.saveDataInSharedPrefrances.getFRomShard("hide_item","show_5017");

            HCApplication.addQuestionOrTitle.addQuestion("q5017", "r5017");
            if (HCApplication.show_5017 == 0) {
                HCApplication.addQuestionOrTitle.addQuestion("q5017a", "yesorno");
                HCApplication.addQuestionOrTitle.addQuestion("q5017b", "yesorno");
                HCApplication.addQuestionOrTitle.addQuestion("q5017c", "yesorno");
            }

            String move= HCApplication.saveDataInSharedPrefrances.getStringFRomShard("test", "move5000").replace("[", "").replace("]", "");
            if (move.length() != 0) {
                ArrayList<String> se = new ArrayList<String>(Arrays.asList(move.split(",")));
                HCApplication.move_ment.clear();
                for(String a:se){
                    HCApplication.move_ment.add(a.trim());
                }


            }




        } catch (Exception e) {
            Log.d("exeption", e.getMessage());
        }
    }

}