package com.shc.SHC_SS.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TableLayout;

import com.shc.SHC_SS.R;
import com.shc.SHC_SS.entities.BQuestions;
import com.shc.SHC_SS.entities.Q0993;
import com.shc.SHC_SS.fragment.ConfirmationDialog;
import com.shc.SHC_SS.utilies.HCApplication;
import com.shc.SHC_SS.views.HCBoldTextViewN;
import com.shc.SHC_SS.views.HCEditTextN;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Section0991 extends Activity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, ConfirmationDialog.ConfirmationDialogCallback {

    private final String TAG = getClass().getSimpleName();
    private static final String KEY_ANSWERS = "ANSWERS";
    private final int STATE_LENGTH = 9;
    HCEditTextN phoneET, nameET, otherET, selectedPersonET;
    Button submit;
    RadioGroup rg0991, rg0992, rg0995;
    RadioButton rb0991_1, rb0991_2, rb0991_3, rb0991_4, rb0991_5;

    RadioButton rb0992_1, rb0992_2;
    RadioButton rb0995_1, rb0995_2, rb0995_3, rb0995_4, rb0995_5, rb0995_6, rb0995_7, rb0995_8, rb0995_9, rb0995_10;
    HCBoldTextViewN tv0993, tv0992;
    TableLayout tableLayout;
    LinearLayout linearLayout0994, linearLayout0995;
    HCEditTextN[] namesEditTextArray = new HCEditTextN[STATE_LENGTH];
    Spinner[] personTypeSpinnerArray = new Spinner[STATE_LENGTH];
    String[] typesArray;
    HCEditTextN other0995Et;
    BQuestions bQuestionsAnswer;
    Q0993[] q0993Array = new Q0993[STATE_LENGTH];
    private boolean hasStates = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HCApplication.newInstance().preventLocalization();

        setContentView(R.layout.activity_section_0991);
        typesArray = getResources().getStringArray(R.array.person_type_array);
        bQuestionsAnswer = new BQuestions();
        HCApplication.saveDataInSharedPrefrances.save_data_int("ActivityMove", "activity_value", 3);
        initViews();
        attachListeners();
        initSpinnerAdapter();
        showHideSection2(false);
        showHideSection5(false);
        enableDisableOtherEditText(false);
    }

    private void initViews() {
        rg0991 = (RadioGroup) findViewById(R.id.radioGroup_houseHold);
        rb0991_1 = (RadioButton) findViewById(R.id.household_0);
        rb0991_2 = (RadioButton) findViewById(R.id.household_1);
        rb0991_3 = (RadioButton) findViewById(R.id.household_2);
        rb0991_4 = (RadioButton) findViewById(R.id.household_3);
        rb0991_5 = (RadioButton) findViewById(R.id.household_4);
        rg0992 = (RadioGroup) findViewById(R.id.radioGroup_0992);
        rb0992_1 = (RadioButton) findViewById(R.id.radio_button_0992_0);
        rb0992_2 = (RadioButton) findViewById(R.id.radio_button_0992_1);
        rg0995 = (RadioGroup) findViewById(R.id.radioGroup_0995);
        rb0995_1 = (RadioButton) findViewById(R.id.radio_button_0995_1);
        rb0995_2 = (RadioButton) findViewById(R.id.radio_button_0995_2);
        rb0995_3 = (RadioButton) findViewById(R.id.radio_button_0995_3);
        rb0995_4 = (RadioButton) findViewById(R.id.radio_button_0995_4);
        rb0995_5 = (RadioButton) findViewById(R.id.radio_button_0995_5);
        rb0995_6 = (RadioButton) findViewById(R.id.radio_button_0995_6);
        rb0995_7 = (RadioButton) findViewById(R.id.radio_button_0995_7);
        rb0995_8 = (RadioButton) findViewById(R.id.radio_button_0995_8);
        rb0995_9 = (RadioButton) findViewById(R.id.radio_button_0995_9);
        rb0995_10 = (RadioButton) findViewById(R.id.radio_button_0995_10);
        nameET = (HCEditTextN) findViewById(R.id.edt_0996);
        phoneET = (HCEditTextN) findViewById(R.id.edt_0997);
        otherET = (HCEditTextN) findViewById(R.id.edt_0995a);
        selectedPersonET = (HCEditTextN) findViewById(R.id.edt_0994);
        submit = (Button) findViewById(R.id.btn_submit);

        tableLayout = (TableLayout) findViewById(R.id.table_0993);
        tv0993 = (HCBoldTextViewN) findViewById(R.id.tv_0993);
        tv0992 = (HCBoldTextViewN) findViewById(R.id.tv_0992);
        linearLayout0994 = (LinearLayout) findViewById(R.id.linear_layout_0994);

        namesEditTextArray[0] = (HCEditTextN) findViewById(R.id.edit_1);
        namesEditTextArray[1] = (HCEditTextN) findViewById(R.id.edit_2);
        namesEditTextArray[2] = (HCEditTextN) findViewById(R.id.edit_3);
        namesEditTextArray[3] = (HCEditTextN) findViewById(R.id.edit_4);
        namesEditTextArray[4] = (HCEditTextN) findViewById(R.id.edit_5);
        namesEditTextArray[5] = (HCEditTextN) findViewById(R.id.edit_6);
        namesEditTextArray[6] = (HCEditTextN) findViewById(R.id.edit_7);
        namesEditTextArray[7] = (HCEditTextN) findViewById(R.id.edit_8);
        namesEditTextArray[8] = (HCEditTextN) findViewById(R.id.edit_9);
        personTypeSpinnerArray[0] = (Spinner) findViewById(R.id.spinner_1);
        personTypeSpinnerArray[1] = (Spinner) findViewById(R.id.spinner_2);
        personTypeSpinnerArray[2] = (Spinner) findViewById(R.id.spinner_3);
        personTypeSpinnerArray[3] = (Spinner) findViewById(R.id.spinner_4);
        personTypeSpinnerArray[4] = (Spinner) findViewById(R.id.spinner_5);
        personTypeSpinnerArray[5] = (Spinner) findViewById(R.id.spinner_6);
        personTypeSpinnerArray[6] = (Spinner) findViewById(R.id.spinner_7);
        personTypeSpinnerArray[7] = (Spinner) findViewById(R.id.spinner_8);
        personTypeSpinnerArray[8] = (Spinner) findViewById(R.id.spinner_9);
        linearLayout0995 = (LinearLayout) findViewById(R.id.linear_layout_0995a);
        other0995Et = (HCEditTextN) findViewById(R.id.edit_0995);
    }

    private void attachListeners() {
        submit.setOnClickListener(this);
        rb0991_1.setOnCheckedChangeListener(this);
        rb0991_2.setOnCheckedChangeListener(this);
        rb0991_3.setOnCheckedChangeListener(this);
        rb0991_4.setOnCheckedChangeListener(this);
        rb0991_5.setOnCheckedChangeListener(this);
        rb0992_1.setOnCheckedChangeListener(this);
        rb0992_2.setOnCheckedChangeListener(this);
        rb0995_1.setOnCheckedChangeListener(this);
        rb0995_2.setOnCheckedChangeListener(this);
        rb0995_3.setOnCheckedChangeListener(this);
        rb0995_4.setOnCheckedChangeListener(this);
        rb0995_5.setOnCheckedChangeListener(this);
        rb0995_6.setOnCheckedChangeListener(this);
        rb0995_7.setOnCheckedChangeListener(this);
        rb0995_8.setOnCheckedChangeListener(this);
        rb0995_9.setOnCheckedChangeListener(this);
        rb0995_10.setOnCheckedChangeListener(this);
    }

    private void initSpinnerAdapter() {
        for (int i = 0; i < STATE_LENGTH; i++) {
            Spinner spinner = personTypeSpinnerArray[i];
            if (spinner != null) {
                spinner.setAdapter(new ArrayAdapter<String>
                        (this, R.layout.spinner_item, typesArray));
                final int index = i;
                q0993Array[index] = new Q0993();
                q0993Array[index].no = i + 1;

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        q0993Array[index].state = position;
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        }
    }

    private void onRadioButtonSelected(CompoundButton compoundButton, boolean isChecked) {
        int viewId = compoundButton.getId();
        String text = (String) compoundButton.getText();
        switch (viewId) {
            case R.id.household_0:
                if (!isChecked) break;
                showHideSection2(true);
                showHideSection5(false);
                bQuestionsAnswer.q0991 = 0;
                break;
            case R.id.household_1:
                if (!isChecked) break;
                showHideSection5(false);
                showHideSection2(false);
                bQuestionsAnswer.q0991 = 1;
                break;
            case R.id.household_2:
                if (!isChecked) break;
                showHideSection5(false);
                showHideSection2(false);
                bQuestionsAnswer.q0991 = 2;
                break;
            case R.id.household_3:
                if (!isChecked) break;
                showHideSection2(false);
                showHideSection5(true);
                bQuestionsAnswer.q0991 = 3;
                break;
            case R.id.household_4:
                if (!isChecked) break;
                showHideSection2(false);
                showHideSection5(true);
                bQuestionsAnswer.q0991 = 4;
                break;
            case R.id.radio_button_0992_0:
            case R.id.radio_button_0992_1:
                if (!isChecked) break;
                showHideSection5(false);
                bQuestionsAnswer.q0992 = (viewId == R.id.radio_button_0992_0) ? 0 : 1;
                break;
            case R.id.radio_button_0995_1:
                if (isChecked) {
                    showHideViewGroup(linearLayout0995, false);
                    enableDisableOtherEditText(false);
                    bQuestionsAnswer.q0995 = 0;
                }
                break;
            case R.id.radio_button_0995_2:
                if (isChecked) {
                    showHideViewGroup(linearLayout0995, true);
                    enableDisableOtherEditText(false);
                    bQuestionsAnswer.q0995 = 1;
                }
                break;
            case R.id.radio_button_0995_3:
                if (isChecked) {
                    showHideViewGroup(linearLayout0995, false);
                    enableDisableOtherEditText(false);
                    bQuestionsAnswer.q0995 = 2;
                }
                break;
            case R.id.radio_button_0995_4:
                if (isChecked) {
                    showHideViewGroup(linearLayout0995, false);
                    enableDisableOtherEditText(false);
                    showConfirmationDialog(false);
                    bQuestionsAnswer.q0995 = 3;
                }
                break;
            case R.id.radio_button_0995_5:
                if (isChecked) {
                    showHideViewGroup(linearLayout0995, false);
                    enableDisableOtherEditText(false);
//                    showConfirmationDialog();
                    bQuestionsAnswer.q0995 = 4;
                }
                break;
            case R.id.radio_button_0995_6:
                if (isChecked) {
                    showHideViewGroup(linearLayout0995, false);
                    enableDisableOtherEditText(false);
//                    showConfirmationDialog();
                    bQuestionsAnswer.q0995 = 5;
                }
                break;
            case R.id.radio_button_0995_7:
                if (isChecked) {
                    showHideViewGroup(linearLayout0995, false);
                    enableDisableOtherEditText(false);
//                    showConfirmationDialog();
                    bQuestionsAnswer.q0995 = 6;
                }
                break;
            case R.id.radio_button_0995_8:
                if (isChecked) {
                    showHideViewGroup(linearLayout0995, false);
                    enableDisableOtherEditText(false);
//                    showConfirmationDialog();
                    bQuestionsAnswer.q0995 = 7;
                }
                break;
            case R.id.radio_button_0995_9:
                if (isChecked) {
                    showHideViewGroup(linearLayout0995, false);
                    enableDisableOtherEditText(true);
                    showConfirmationDialog(true);
                    bQuestionsAnswer.q0995 = 8;
                }
                break;
            case R.id.radio_button_0995_10:
                if (isChecked) {
                    showHideViewGroup(linearLayout0995, false);
                    enableDisableOtherEditText(true);
//                    showConfirmationDialog();
                    bQuestionsAnswer.q0995 = 9;
                }
                break;
            default:
                break;
        }
    }

    private void showConfirmationDialog(boolean shouldRemoveFamily) {
        ConfirmationDialog confirmationDialog = ConfirmationDialog.newInstance(shouldRemoveFamily);
        confirmationDialog.setConfirmationDialogCallback(this);
        confirmationDialog.show(getFragmentManager(), TAG);
    }

    private void enableDisableOtherEditText(boolean enableDisable) {
//        other0995Et.setVisibility(enableDisable ? View.VISIBLE : View.GONE);
        other0995Et.setEnabled(enableDisable);
    }

    private void showHideSection5(boolean showHide) {
        showHideViewGroup(linearLayout0994, showHide);
        showHideViewGroup(tableLayout, showHide);
        showHideViewGroup(tv0993, showHide);
        hasStates = showHide;
    }

    private void showHideSection2(boolean showHide) {
        showHideViewGroup(rg0992, showHide);
        showHideViewGroup(tv0992, showHide);
    }

    private void showHideViewGroup(ViewGroup viewGroup, boolean showHide) {
        if (viewGroup != null) viewGroup.setVisibility(showHide ? View.VISIBLE : View.GONE);
    }

    private void showHideViewGroup(View view, boolean showHide) {
        if (view != null) view.setVisibility(showHide ? View.VISIBLE : View.GONE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_submit:
                submit();
                break;
            default:
                break;
        }
    }

    private void submit() {
        bQuestionsAnswer.q0993List = new ArrayList<Q0993>();
        for (int i = 0; i < STATE_LENGTH; i++) {
            EditText editText = namesEditTextArray[i];
            if (editText != null && editText.getText() != null && !editText.getText().toString().isEmpty()) {
                q0993Array[i].name = editText.getText().toString().trim();
                if (hasStates) {
                    bQuestionsAnswer.q0993List.add(q0993Array[i]);
                }
            }
        }
        if (nameET.getText() != null && !nameET.getText().toString().isEmpty()) {
            bQuestionsAnswer.q0996 = nameET.getText().toString().trim();
        } else {
            nameET.setError(getString(R.string.invalid_input));
            return;
        }

        if (phoneET.getText() != null && !phoneET.getText().toString().isEmpty()) {
            if (phoneET.getText().toString().trim().length() == 10) {
                bQuestionsAnswer.q0997 = phoneET.getText().toString().trim();
                phoneET.setError(null);
            } else {
                phoneET.setError(getString(R.string.invalid_input));
                return;
            }
        } else {
            phoneET.setError(getString(R.string.invalid_input));
            return;
        }

        if (linearLayout0995.getVisibility() == View.VISIBLE) {
            if (otherET.getText() != null && !otherET.getText().toString().isEmpty()) {
                bQuestionsAnswer.q0995a = otherET.getText().toString().trim();
                otherET.setError(null);
            } else {
                otherET.setError(getString(R.string.invalid_input));
                return;
            }
        }
        if (hasStates) {
            if (selectedPersonET.getText() != null && !selectedPersonET.getText().toString().isEmpty()
                    && TextUtils.isDigitsOnly(selectedPersonET.getText().toString())) {
                int selectedPerson = Integer.parseInt(selectedPersonET.getText().toString().trim());
                int aa = bQuestionsAnswer.q0993List.size();
                if (selectedPerson <= aa) {
                    selectedPersonET.setError(null);
                    bQuestionsAnswer.q0994 = selectedPerson;
                } else {
                    selectedPersonET.setError(getString(R.string.invalid_input));
                    return;
                }
            } else {
                selectedPersonET.setError(getString(R.string.invalid_input));
                return;
            }
        }


        String jsonString = new Gson().toJson(bQuestionsAnswer, BQuestions.class);

        try {
            HCApplication.all_item.put("Q0991", bQuestionsAnswer.q0991);
            HCApplication.all_item.put("Q0992", bQuestionsAnswer.q0992);

//            JSONObject q3 = new Gson().toJson(bQuestionsAnswer.q0993List);
            if (bQuestionsAnswer.q0993List != null && !bQuestionsAnswer.q0993List.isEmpty()) {
                JSONArray jsonArray = new JSONArray();
                JSONObject jsonObject;
                for (Q0993 q0993 : bQuestionsAnswer.q0993List) {
                    jsonObject = new JSONObject();
                    jsonObject.put("id", q0993.no);
                    jsonObject.put("name", q0993.name);
                    jsonObject.put("status", q0993.state);
                    jsonArray.put(jsonObject);
                }
                HCApplication.all_item.put("Q0993", jsonArray);
                Log.d("tttttttttttttttt", jsonArray.toString());
            }
            HCApplication.all_item.put("Q0994", bQuestionsAnswer.q0994);
            HCApplication.all_item.put("Q0995", bQuestionsAnswer.q0995);
            HCApplication.all_item.put("Q0996", bQuestionsAnswer.q0996);
            HCApplication.all_item.put("Q0997", bQuestionsAnswer.q0997);

            Log.d("allItems", HCApplication.all_item.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        startActivity(new Intent(Section0991.this, QuestionsShow.class));
        Log.e(TAG, jsonString);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null)
            bQuestionsAnswer = savedInstanceState.getParcelable(KEY_ANSWERS);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (outState != null && bQuestionsAnswer != null)
            outState.putParcelable(KEY_ANSWERS, bQuestionsAnswer);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        try {
            onRadioButtonSelected(buttonView, isChecked);
        } catch (NullPointerException e) {
            Log.e(TAG, e.getMessage());
        }
    }

    @Override
    public void ok(boolean shouldRemoveFamily) {
        finishQuestionnaire(shouldRemoveFamily);
    }

    private void finishQuestionnaire(boolean shouldRemoveFamily) {
        Log.d(TAG, "Finish Questions");
        if (shouldRemoveFamily)
            startActivity(new Intent(this, SaveOnServer.class));
        else
            startActivity(new Intent(this, FamilyDetails.class));
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        HCApplication.saveDataInSharedPrefrances.save_data_String("Allitem", "selectjson", HCApplication.all_item.toString());
        HCApplication.saveDataInSharedPrefrances.save_data_String("Allitem", "question", HCApplication.all_selected.toString());
    }
}
