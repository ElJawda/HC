package com.shc.SHC_SS.adapter;
import com.shc.SHC_SS.R;
import com.shc.SHC_SS.utilies.HCApplication;
import com.shc.SHC_SS.views.CustomRaidoButtonN;
import com.shc.SHC_SS.views.HCEditTextN;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import org.json.JSONException;

/**
 * Created by A.Elsayed on 4/25/2017.
 */

public class MainHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView tv, text;
    LinearLayout select, title_l, hideradio, seek_li;
    CustomRaidoButtonN crd1, crd2, crd3, crd4, crd5, crd6, crd7, crd8, crd9;
    View ver_sp, hor_sp;
    FrameLayout allItems;
    HCEditTextN editText, editText_string;
    Spinner spinner;
    ViewGroup viewGroup;
    SeekBar seekBar;

    public MainHolder(final View view) {
        super(view);
        viewGroup = (ViewGroup) itemView;
        this.tv = (TextView) view.findViewById(R.id.textView1);
        this.text = (TextView) view.findViewById(R.id.title);
        this.select = (LinearLayout) view.findViewById(R.id.select);
        this.hideradio = (LinearLayout) view.findViewById(R.id.hideradio);
        this.title_l = (LinearLayout) view.findViewById(R.id.title_l);
        this.ver_sp = (LinearLayout) view.findViewById(R.id.vertical_se);
        this.hor_sp = (LinearLayout) view.findViewById(R.id.horizental_sp);
        this.allItems = (FrameLayout) view.findViewById(R.id.all_item);
        this.crd1 = (CustomRaidoButtonN) view.findViewById(R.id.txt_rd7_1);
        this.crd2 = (CustomRaidoButtonN) view.findViewById(R.id.txt_rd7_2);
        this.crd3 = (CustomRaidoButtonN) view.findViewById(R.id.txt_rd7_3);
        this.crd4 = (CustomRaidoButtonN) view.findViewById(R.id.txt_rd7_4);
        this.crd5 = (CustomRaidoButtonN) view.findViewById(R.id.txt_rd7_5);
        this.crd6 = (CustomRaidoButtonN) view.findViewById(R.id.txt_rd7_6);
        this.crd7 = (CustomRaidoButtonN) view.findViewById(R.id.txt_rd7_7);
        this.crd8 = (CustomRaidoButtonN) view.findViewById(R.id.txt_rd7_8);
        this.crd9 = (CustomRaidoButtonN) view.findViewById(R.id.txt_rd7_9);
        this.spinner = (Spinner) view.findViewById(R.id.grid_sppiner);
        this.editText = (HCEditTextN) view.findViewById(R.id.enter_value);
        this.editText_string = (HCEditTextN) view.findViewById(R.id.enter_string);
        this.seek_li = (LinearLayout) view.findViewById(R.id.seek_l);

        this.seekBar = (SeekBar) view.findViewById(R.id.seek);
        seekBar.setMax(10);
        this.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        this.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Toast.makeText(HCApplication.context, String.valueOf(progress), Toast.LENGTH_LONG).show();
                try {
                    HCApplication.all_item.put("", progress);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        this.crd2.setOnClickListener(this);
        this.crd1.setOnClickListener(this);
        this.crd3.setOnClickListener(this);
        this.crd4.setOnClickListener(this);
        this.crd5.setOnClickListener(this);
        this.crd6.setOnClickListener(this);
        this.crd7.setOnClickListener(this);
        this.crd8.setOnClickListener(this);
        this.crd9.setOnClickListener(this);

        this.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int positn, long id) {
                try {
                    HCApplication.all_item.put("", positn);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        this.editText_string.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    if (editText_string.getText().length() != 0) {
                        HCApplication.all_item.put("", editText_string.getText().toString());

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        this.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    if (editText.getText().length() != 0) {
                        HCApplication.all_item.put("", Integer.parseInt(editText.getText().toString()));

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {}
    }
}

//            case R.id.txt_rd7_1:
//
////                    if (HCApplication.check_select_child.size()>=3) {
////                        HCApplication.check_select_child.clear();
//
//                HCApplication.check.set(this.getAdapterPosition(), 1);
//                question = result.get(getAdapterPosition());
//                if (HCApplication.check_select_child.size() == 3) {
//                    checkValueToAppearRecyler(this.getAdapterPosition());
//                } else {
//                    crd1.setChecked(false);
//                    Toast.makeText(context, " الرجاء اختيار جميع الأسئلة الظاهرة يسار الشاشة   ", Toast.LENGTH_LONG).show();
//
//                }
//                try {
//
//                    if (!crd1.getText().equals("نعم")) {
//                        HCApplication.all_item.put(question_name.get(this.getAdapterPosition()).replace("q", "Q"), 0);
//                    } else {
//                        HCApplication.all_item.put(question_name.get(this.getAdapterPosition()).replace("q", "Q"), 1);
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                crd1.setChecked(true);
//                crd2.setChecked(false);
//                crd3.setChecked(false);
//                crd4.setChecked(false);
//                crd5.setChecked(false);
//                crd6.setChecked(false);
//                crd7.setChecked(false);
//                crd8.setChecked(false);
//                crd9.setChecked(false);
//                // use this part to  show child question
//
//                try {
//                    if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q4004"))) {
//                        question = question_name.get(this.getAdapterPosition() + 1);
//                        if (question.equals("q4005")) {
//                            HCApplication.show_q4005 = 1;
//                            delete(this.getAdapterPosition());
//                            editText.setVisibility(View.VISIBLE);
//                            HCApplication.check_remove = 1;
//                        }
//                    } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6000"))) {
//                        try {
//                            if (HCApplication.show_6001a == 1) {
//                                HCApplication.show_6001a = 0;
//                                AddItem(this.getAdapterPosition(), "q6001a", "r6001a");
//                                HCApplication.check_remove = 0;
//                                editText.setVisibility(View.INVISIBLE);
//
//                            }
//
//
//                        } catch (Exception e) {
//                            Log.e("saa", e.getMessage());
//                        }
//
//                    } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5001"))) {
//                        question = question_name.get(this.getAdapterPosition() + 1);
//                        if (question.equals("q5001a")) {
//                            HCApplication.show_5001 = 1;
//                            deleteAll(this.getAdapterPosition());
//                        }
//                    }
//
//                    else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6200"))) {
//                        HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "Value_Name", 7);
//                        HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "Value_Back", 5);
//                        HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "open_screen", 6);;
//                        HCApplication.back_section = 5;
//                        HCApplication.myIntent.move_activity_to_anhter(HCApplication.context, new QuestionsShow());
//
//                    }
//                    else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6102"))) {
//                        if (HCApplication.show_q6104 == 1) {
//                            HCApplication.show_q6104 = 0;
//                            HCApplication.span_6102back = 1;
//                            AddItem(this.getAdapterPosition(), "q6103", "r6103");
//
//
//                        }
//                    }
//                    else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6230"))) {
//                        if (HCApplication.check_section6230 == 1) {
//                            HCApplication.check_section6230 = 0;
//                            AddItem(this.getAdapterPosition(), "q6231", "status_iteration");
//
//
//                        }
//                    }
//                    else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5002"))) {
//                        question = question_name.get(this.getAdapterPosition() + 1);
//                        if (question.equals("q5002a")) {
//                            HCApplication.show_5002 = 1;
//                            deleteAll(this.getAdapterPosition());
//                        }
//                    } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5003"))) {
//                        question = question_name.get(this.getAdapterPosition() + 1);
//                        if (question.equals("q5003a")) {
//                            HCApplication.show_5003 = 1;
//                            deleteAll(this.getAdapterPosition());
//                        }
//                    } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5004"))) {
//                        question = question_name.get(this.getAdapterPosition() + 1);
//                        if (question.equals("q5004a")) {
//                            HCApplication.show_5004 = 1;
//                            deleteAll(this.getAdapterPosition());
//                        }
//                    } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5005"))) {
//                        question = question_name.get(this.getAdapterPosition() + 1);
//                        if (question.equals("q5005a")) {
//                            HCApplication.show_5005 = 1;
//                            deleteAll(this.getAdapterPosition());
//                        }
//                    } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5006"))) {
//                        question = question_name.get(this.getAdapterPosition() + 1);
//                        if (question.equals("q5006a")) {
//                            HCApplication.show_5006 = 1;
//                            deleteAll(this.getAdapterPosition());
//                        }
//                    } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5007"))) {
//                        question = question_name.get(this.getAdapterPosition() + 1);
//                        if (question.equals("q5007a")) {
//                            HCApplication.show_5007 = 1;
//                            deleteAll(this.getAdapterPosition());
//                        }
//                    } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5008"))) {
//                        question = question_name.get(this.getAdapterPosition() + 1);
//                        if (question.equals("q5008a")) {
//                            HCApplication.show_5008 = 1;
//                            deleteAll(this.getAdapterPosition());
//                        }
//                    } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5009"))) {
//                        question = question_name.get(this.getAdapterPosition() + 1);
//                        if (question.equals("q5009a")) {
//                            HCApplication.show_5009 = 1;
//                            deleteAll(this.getAdapterPosition());
//                        }
//                    } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5010"))) {
//                        question = question_name.get(this.getAdapterPosition() + 1);
//                        if (question.equals("q5010a")) {
//                            HCApplication.show_5010 = 1;
//                            deleteAll(this.getAdapterPosition());
//                        }
//                    } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5011"))) {
//                        question = question_name.get(this.getAdapterPosition() + 1);
//                        if (question.equals("q5011a")) {
//                            HCApplication.show_5011 = 1;
//                            deleteAll(this.getAdapterPosition());
//                        }
//                    } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5011"))) {
//                        question = question_name.get(this.getAdapterPosition() + 1);
//                        if (question.equals("q5011a")) {
//                            HCApplication.show_5011 = 1;
//                            deleteAll(this.getAdapterPosition());
//                        }
//                    } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5012"))) {
//                        question = question_name.get(this.getAdapterPosition() + 1);
//                        if (question.equals("q5012a")) {
//                            HCApplication.show_5012 = 1;
//                            deleteAll(this.getAdapterPosition());
//                        }
//                    } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5013"))) {
//                        question = question_name.get(this.getAdapterPosition() + 1);
//                        if (question.equals("q5013a")) {
//                            HCApplication.show_5013 = 1;
//                            deleteAll(this.getAdapterPosition());
//                        }
//                    } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5014"))) {
//                        question = question_name.get(this.getAdapterPosition() + 1);
//                        if (question.equals("q5014a")) {
//                            HCApplication.show_5014 = 1;
//                            deleteAll(this.getAdapterPosition());
//                        }
//                    } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5014"))) {
//                        question = question_name.get(this.getAdapterPosition() + 1);
//                        if (question.equals("q5014a")) {
//                            HCApplication.show_5014 = 1;
//                            deleteAll(this.getAdapterPosition());
//                        }
//                    } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5015"))) {
//                        question = question_name.get(this.getAdapterPosition() + 1);
//                        if (question.equals("q5015a")) {
//                            HCApplication.show_5015 = 1;
//                            deleteAll(this.getAdapterPosition());
//                        }
//                    } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5016"))) {
//                        question = question_name.get(this.getAdapterPosition() + 1);
//                        if (question.equals("q5016a")) {
//                            HCApplication.show_5016 = 1;
//                            deleteAll(this.getAdapterPosition());
//                        }
//                    } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5017"))) {
//                        question = question_name.get(this.getAdapterPosition() + 1);
//                        if (question.equals("q5017a")) {
//                            HCApplication.show_5017 = 1;
//                            deleteAll(this.getAdapterPosition());
//                            editText.setVisibility(View.GONE);
//                        }
//                    } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6130"))) {
//                        if (HCApplication.show_q6130 == 1) {
//                            HCApplication.show_q6130 = 0;
//                            AddItem(this.getAdapterPosition(), "q6131", "status_iteration");
//
//                        }
//                    }
//                    else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("Q6203"))) {
//                        if (HCApplication.show_q6205 == 1) {
//                            HCApplication.show_q6205 = 0;
//                            HCApplication.span_q6200 = 0;
//                            AddItem(this.getAdapterPosition(), "q6204", "r6103");
//
//                        }
//                    }
//
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                break;
//            case R.id.txt_rd7_2:
//                HCApplication.check.set(this.getAdapterPosition(), 2);
//                crd2.setChecked(true);
//                crd1.setChecked(false);
//                crd3.setChecked(false);
//                crd4.setChecked(false);
//                crd5.setChecked(false);
//                crd6.setChecked(false);
//                crd7.setChecked(false);
//                crd8.setChecked(false);
//                crd9.setChecked(false);
//                try {
//                    question = result.get(getAdapterPosition());
//                    if (!crd2.getText().equals("لا")) {
//                        HCApplication.all_item.put(question_name.get(this.getAdapterPosition()).replace("q", "Q"), 1);
//                        editText.setVisibility(View.GONE);
//                        checkValueToDisappearRecyler(this.getAdapterPosition(), question);
//
//                    } else {
//                        editText.setVisibility(View.GONE);
//                        HCApplication.all_item.put(question_name.get(this.getAdapterPosition()).replace("q", "Q"), 0);
//                        checkValueToDisappearRecyler(this.getAdapterPosition(), question);
//
//                    }
//
//                    // transportation
//                    if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q4004"))) {
//                        try {
//                            if (HCApplication.show_q4005 == 1) {
//                                HCApplication.show_q4005 = 0;
//                                AddItem(this.getAdapterPosition(), "q4005", "r4005");
//                                HCApplication.check_remove = 0;
//                                editText.setVisibility(View.INVISIBLE);
//
//                            }
//
//
//                        } catch (Exception e) {
//                            Log.e("saa", e.getMessage());
//                        }
//
//                    } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5001"))) {
//                        try {
//                            if (HCApplication.show_5001 == 1) {
//                                HCApplication.show_5001 = 0;
//                                addQuestionAfterRemove(this.getAdapterPosition(),"q5001a","q5001b","q5001c");
//                            }
//
//
//                        } catch (Exception e) {
//                            Log.e("saa", e.getMessage());
//                        }
//
//                    } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5002"))) {
//                        try {
//                            if (HCApplication.show_5002 == 1) {
//                                HCApplication.show_5002 = 0;
//                                addQuestionAfterRemove(this.getAdapterPosition(),"q5002a","q5002b","q5002c");
//                            }
//
//
//                        } catch (Exception e) {
//                            Log.e("saa", e.getMessage());
//                        }
//
//                    } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5003"))) {
//                        try {
//                            if (HCApplication.show_5003 == 1) {
//                                HCApplication.show_5003 = 0;
//                                addQuestionAfterRemove(this.getAdapterPosition(),"q5003a","q5003b","q5003c");
//                            }
//
//
//                        } catch (Exception e) {
//                            Log.e("saa", e.getMessage());
//                        }
//
//                    } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5004"))) {
//                        try {
//                            if (HCApplication.show_5004 == 1) {
//                                HCApplication.show_5004 = 0;
//                                addQuestionAfterRemove(this.getAdapterPosition(),"q5004a","q5004b","q5004c");
//                            }
//
//
//                        } catch (Exception e) {
//                            Log.e("saa", e.getMessage());
//                        }
//
//                    } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5005"))) {
//                        try {
//                            if (HCApplication.show_5005 == 1) {
//                                HCApplication.show_5005 = 0;
//                                addQuestionAfterRemove(this.getAdapterPosition(),"q5005a","q5005b","q5005c");
//
//                            }
//
//
//                        } catch (Exception e) {
//                            Log.e("saa", e.getMessage());
//                        }
//
//                    } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5006"))) {
//                        try {
//                            if (HCApplication.show_5006 == 1) {
//                                HCApplication.show_5006 = 0;
//                                addQuestionAfterRemove(this.getAdapterPosition(),"q5006a","q5006b","q5006c");
//
//                            }
//
//
//                        } catch (Exception e) {
//                            Log.e("saa", e.getMessage());
//                        }
//
//                    } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5007"))) {
//                        try {
//                            if (HCApplication.show_5007 == 1) {
//                                HCApplication.show_5007 = 0;
//                                addQuestionAfterRemove(this.getAdapterPosition(),"q5007a","q5007b","q5007c");
//
//                            }
//                        } catch (Exception e) {
//                            Log.e("saa", e.getMessage());
//                        }
//
//                    } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5008"))) {
//                        try {
//                            if (HCApplication.show_5008 == 1) {
//                                HCApplication.show_5008 = 0;
//                                addQuestionAfterRemove(this.getAdapterPosition(),"q5008a","q5008b","q5008c");
//
//                            }
//                        } catch (Exception e) {
//                            Log.e("saa", e.getMessage());
//                        }
//
//                    } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5009"))) {
//                        try {
//                            if (HCApplication.show_5009 == 1) {
//                                HCApplication.show_5009 = 0;
//                                addQuestionAfterRemove(this.getAdapterPosition(),"q5009a","q5009b","q5009c");
//
//                            }
//                        } catch (Exception e) {
//                            Log.e("saa", e.getMessage());
//                        }
//
//                    } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5010"))) {
//                        try {
//                            if (HCApplication.show_5010 == 1) {
//                                HCApplication.show_5010 = 0;
//                                ArrayList allq = new ArrayList();
//                                ArrayList allr = new ArrayList();
//                                addQuestionAfterRemove(this.getAdapterPosition(),"q5010a","q5010b","q5010c");
//
//                            }
//                        } catch (Exception e) {
//                            Log.e("saa", e.getMessage());
//                        }
//
//                    } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5011"))) {
//                        try {
//                            if (HCApplication.show_5011 == 1) {
//                                HCApplication.show_5011 = 0;
//                                addQuestionAfterRemove(this.getAdapterPosition(),"q5011a","q5011b","q5011c");
//
//                            }
//                        } catch (Exception e) {
//                            Log.e("saa", e.getMessage());
//                        }
//
//                    } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5012"))) {
//                        try {
//                            if (HCApplication.show_5012 == 1) {
//                                HCApplication.show_5012 = 0;
//                                addQuestionAfterRemove(this.getAdapterPosition(),"q5012a","q5012b","q5012c");
//
//                            }
//                        } catch (Exception e) {
//                            Log.e("saa", e.getMessage());
//                        }
//
//                    } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5013"))) {
//                        try {
//                            if (HCApplication.show_5013 == 1) {
//                                HCApplication.show_5013 = 0;
//                                addQuestionAfterRemove(this.getAdapterPosition(),"q5013a","q5013b","q5013c");
//
//                            }
//                        } catch (Exception e) {
//                            Log.e("saa", e.getMessage());
//                        }
//
//                    } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5014"))) {
//                        try {
//                            if (HCApplication.show_5014 == 1) {
//                                HCApplication.show_5014 = 0;
//                                addQuestionAfterRemove(this.getAdapterPosition(),"q5014a","q5014b","q5014c");
//
//                            }
//                        } catch (Exception e) {
//                            Log.e("saa", e.getMessage());
//                        }
//
//                    } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5015"))) {
//                        try {
//                            if (HCApplication.show_5015 == 1) {
//                                HCApplication.show_5015 = 0;
//                                addQuestionAfterRemove(this.getAdapterPosition(),"q5015a","q5015b","q5015c");
//
//                            }
//                        } catch (Exception e) {
//                            Log.e("saa", e.getMessage());
//                        }
//
//                    } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5016"))) {
//                        try {
//                            if (HCApplication.show_5016 == 1) {
//                                HCApplication.show_5016 = 0;
//                                addQuestionAfterRemove(this.getAdapterPosition(),"q5016a","q5016b","q5016c");
//                                editText_string.setVisibility(View.GONE);
//
//                            }
//                        } catch (Exception e) {
//                            Log.e("saa", e.getMessage());
//                        }
//
//                    } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5017"))) {
//                        try {
//                            if (HCApplication.show_5017 == 1) {
//                                HCApplication.show_5017 = 0;
//                                addQuestionAfterRemove(this.getAdapterPosition(),"q5017a","q5017b","q5017c");
//
//                            }
//                        } catch (Exception e) {
//                            Log.e("saa", e.getMessage());
//                        }
//
//                    } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q4012"))) {
//                        HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "open_screen", 2);
//                        HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "Value_Name", 3);
//                        HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "Value_Back", 1);
//                        HCApplication.myIntent.move_activity_to_anhter(HCApplication.context, new QuestionsShow());
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//                break;
//            case R.id.txt_rd7_3:
//                HCApplication.check.set(this.getAdapterPosition(), 3);
//                try {
//                    question = result.get(getAdapterPosition());
//                    HCApplication.all_item.put(question_name.get(this.getAdapterPosition()).replace("q", "Q"), 2);
//                    editText_string.setVisibility(View.INVISIBLE);
//                    addForSecoondAndThirdRadio(this.getAdapterPosition());
//                }catch (Exception e){}
//
//                crd3.setChecked(true);
//                crd1.setChecked(false);
//                crd2.setChecked(false);
//                crd4.setChecked(false);
//                crd5.setChecked(false);
//                crd6.setChecked(false);
//                crd7.setChecked(false);
//                crd8.setChecked(false);
//                crd9.setChecked(false);
//
//                break;
//            case R.id.txt_rd7_4:
//                HCApplication.check.set(this.getAdapterPosition(), 4);
//                try {
//                    HCApplication.all_item.put(question_name.get(this.getAdapterPosition()).replace("q", "Q"), 3);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                try {
//                    question = result.get(getAdapterPosition());
//                    if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6000"))) {
//                        question = question_name.get(this.getAdapterPosition() + 1);
//                        if (question.equals("q6001a")) {
//                            HCApplication.show_6001a = 1;
//                            delete(this.getAdapterPosition());
//                            HCApplication.span_6001a = 1;
//                            HCApplication.span_q6104 = 23;
//                        }
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                crd4.setChecked(true);
//                crd1.setChecked(false);
//                crd3.setChecked(false);
//                crd2.setChecked(false);
//                crd5.setChecked(false);
//                crd6.setChecked(false);
//                crd7.setChecked(false);
//                crd8.setChecked(false);
//                crd9.setChecked(false);
//
//                break;
//            case R.id.txt_rd7_5:
//                try {
//                    HCApplication.all_item.put(question_name.get(this.getAdapterPosition()).replace("q", "Q"), 4);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                HCApplication.check.set(this.getAdapterPosition(), 5);
//                question = result.get(getAdapterPosition());
//                try {
//                    if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q4013"))) {
//                        editText_string.setVisibility(View.VISIBLE);
//                    } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6103"))) {
//                        editText.setVisibility(View.VISIBLE);
//
//                    } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6204"))) {
//                        editText.setVisibility(View.VISIBLE);
//
//                    }
//
//                } catch (Exception e) {
//                    Log.d("error", e.getMessage());
//                }
//
//                crd5.setChecked(true);
//                crd1.setChecked(false);
//                crd3.setChecked(false);
//                crd4.setChecked(false);
//                crd2.setChecked(false);
//                crd6.setChecked(false);
//                crd7.setChecked(false);
//                crd8.setChecked(false);
//                crd9.setChecked(false);
//                break;
//            case R.id.txt_rd7_6:
//                HCApplication.check.set(this.getAdapterPosition(), 6);
//                try {
//                    HCApplication.all_item.put(question_name.get(this.getAdapterPosition()).replace("q", "Q"), 5);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                crd6.setChecked(true);
//                crd1.setChecked(false);
//                crd3.setChecked(false);
//                crd4.setChecked(false);
//                crd5.setChecked(false);
//                crd2.setChecked(false);
//                crd7.setChecked(false);
//                crd8.setChecked(false);
//                crd9.setChecked(false);
//
//                break;
//            case R.id.txt_rd7_7:
//                HCApplication.check.set(this.getAdapterPosition(), 7);
//                try {
//                    HCApplication.all_item.put(question_name.get(this.getAdapterPosition()).replace("q", "Q"), 6);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//                crd7.setChecked(true);
//                crd1.setChecked(false);
//                crd3.setChecked(false);
//                crd4.setChecked(false);
//                crd5.setChecked(false);
//                crd6.setChecked(false);
//                crd2.setChecked(false);
//                crd8.setChecked(false);
//                crd9.setChecked(false);
//
//                break;
//            case R.id.txt_rd7_8:
//                HCApplication.check.set(this.getAdapterPosition(), 8);
//                try {
//                    HCApplication.all_item.put(question_name.get(this.getAdapterPosition()).replace("q", "Q"), 7);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//                crd8.setChecked(true);
//                crd1.setChecked(false);
//                crd3.setChecked(false);
//                crd4.setChecked(false);
//                crd5.setChecked(false);
//                crd6.setChecked(false);
//                crd2.setChecked(false);
//                crd7.setChecked(false);
//                crd9.setChecked(false);
//
//                break;
//            case R.id.txt_rd7_9:
//                HCApplication.check.set(this.getAdapterPosition(), 9);
//                try {
//                    HCApplication.all_item.put(question_name.get(this.getAdapterPosition()).replace("q", "Q"), 8);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//                crd9.setChecked(true);
//                crd1.setChecked(false);
//                crd3.setChecked(false);
//                crd4.setChecked(false);
//                crd5.setChecked(false);
//                crd6.setChecked(false);
//                crd2.setChecked(false);
//                crd7.setChecked(false);
//                crd8.setChecked(false);
//
//                break;
//        }
//    }
