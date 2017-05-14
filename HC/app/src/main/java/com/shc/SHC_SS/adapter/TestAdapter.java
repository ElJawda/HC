package com.shc.SHC_SS.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.shc.SHC_SS.R;
import com.shc.SHC_SS.utilies.HCApplication;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by A.Elsayed on 5/8/2017.
 */

public class TestAdapter extends MainAdapter {
    ArrayList<String> checked_item = new ArrayList<>();
    String selected_item;
    JSONArray jsonArray;
    MainHolder holder;

    public TestAdapter(Context con, ArrayList<String> prgmNameList, ArrayList<String> arrayLists, ArrayList<String> question_name, int check_color, ArrayList checked_item) {
        result = prgmNameList;
        this.arrayLists = arrayLists;
        this.question_name = question_name;
        this.checked_item = checked_item;
        setHasStableIds(true);

    }
    @Override
    public void onBindViewHolder(MainHolder holder, int position) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        this.holder=holder;
        LinearLayout ll = new LinearLayout(HCApplication.context);
        ll.setLayoutParams(params);
        ll.setOrientation(LinearLayout.VERTICAL);

        holder.editText.setVisibility(View.GONE);
        holder.crd1.setChecked(false);
        holder.crd2.setChecked(false);
        holder.crd3.setChecked(false);
        holder.crd4.setChecked(false);
        holder.crd5.setChecked(false);
        holder.crd6.setChecked(false);
        holder.crd7.setChecked(false);
        holder.crd8.setChecked(false);
        holder.crd8.setChecked(false);
        Log.d("section400test",result.toString()+""+arrayLists.toString()+""+question_name.toString());

        String check = result.get(position);
        Log.d("tesat",position+"  "+checked_item.size());
        if (position<checked_item.size()) {
            selected_item = checked_item.get(position).toString().trim();
        }
        if (!check.equals("title") && !check.equals("q")) {
            holder.tv.setText(question_name.get(position).replace("q", "س ").replace("Q", "س ") + "  \t" + result.get(position));
            String as = arrayLists.get(position);
            try {
                jsonArray = new JSONArray(as);
                set_Selected(selected_item);
                if (check.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q4007"))) {
                    holder.hideradio.setVisibility(View.GONE);
                    holder.title_l.setVisibility(View.INVISIBLE);
                    holder.editText_string.setVisibility(View.GONE);

                    holder.spinner.setVisibility(View.VISIBLE);


                    ArrayList<String> item = new ArrayList<>();
                    item.clear();
                    for (int k = 0; k < jsonArray.length(); k++) {
                        item.add(jsonArray.getString(k));
                    }
                    ArrayAdapter dataAdapter = new ArrayAdapter<String>(HCApplication.context, R.layout.spinner_item, item);
                    holder.spinner.setAdapter(dataAdapter);
                    if (!selected_item.equals("")) {
                        holder.spinner.setSelection(Integer.parseInt(selected_item));
                    }

                }

                else  if (check.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q4001"))) {
                    holder.hideradio.setVisibility(View.GONE);
                    holder.title_l.setVisibility(View.INVISIBLE);
                    holder.editText_string.setVisibility(View.GONE);

                    holder.spinner.setVisibility(View.VISIBLE);


                    ArrayList<String> item = new ArrayList<>();
                    item.clear();
                    for (int k = 0; k < jsonArray.length(); k++) {
                        item.add(jsonArray.getString(k));
                    }
                    ArrayAdapter dataAdapter = new ArrayAdapter<String>(HCApplication.context, R.layout.spinner_item, item);
                    holder.spinner.setAdapter(dataAdapter);
                    if (!selected_item.equals("")) {
                        holder.spinner.setSelection(Integer.parseInt(selected_item));
                    }

                }
                else if (check.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q4010"))) {
                    holder.spinner.setVisibility(View.INVISIBLE);
                    holder.hideradio.setVisibility(View.GONE);
                    holder.editText.setVisibility(View.VISIBLE);
                    holder.editText.setText(HCApplication.all_selected.getString("q4010"));
                    holder.title_l.setVisibility(View.GONE);

                } else if (check.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q4005"))) {
                    holder.spinner.setVisibility(View.GONE);
                    holder.hideradio.setVisibility(View.GONE);
                    String asas = HCApplication.saveDataInSharedPrefrances.getStringFRomShard("edittext", "q4005");
                    holder.editText.setText(HCApplication.all_selected.getString("q4005"));
                    holder.editText.setVisibility(View.VISIBLE);

                }
//                else if (check.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5017"))) {
//                    holder.spinner.setVisibility(View.GONE);
//                    holder.hideradio.setVisibility(View.VISIBLE);
//                    holder.editText_string.setVisibility(View.VISIBLE);
//                    int arr_lenght = jsonArray.length();
//                    show(arr_lenght);
//
//                }
                else if (check.equals("أخرى حدد ")) {
                    holder.spinner.setVisibility(View.GONE);
                    holder.hideradio.setVisibility(View.VISIBLE);
                    holder.editText_string.setVisibility(View.VISIBLE);
                    int arr_lenght = jsonArray.length();
                    show(arr_lenght);

                }
                else if (check.equals("أخرى حدد ")) {
                    holder.spinner.setVisibility(View.GONE);
                    holder.hideradio.setVisibility(View.VISIBLE);
                    holder.editText_string.setVisibility(View.VISIBLE);
                    int arr_lenght = jsonArray.length();
                    show(arr_lenght);

                } else if (check.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q4004"))) {
                    holder.spinner.setVisibility(View.GONE);
                    holder.select.setVisibility(View.VISIBLE);
                    holder.hideradio.setVisibility(View.VISIBLE);
                    holder.title_l.setVisibility(View.INVISIBLE);
                    holder.editText_string.setVisibility(View.GONE);
                    HCApplication.show_q4005= HCApplication.saveDataInSharedPrefrances.getFRomShard("hide_item","show_q4005");
                    if (HCApplication.show_q4005 == 1) {
                        holder.editText.setVisibility(View.VISIBLE);
                        holder.editText.setText(HCApplication.all_selected.getString("q4004"));
                    }
                    int arr_lenght = jsonArray.length();
                    show(arr_lenght);

                }
                else if (check.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q4013"))) {
                    holder.spinner.setVisibility(View.GONE);
                    holder.select.setVisibility(View.VISIBLE);
                    holder.hideradio.setVisibility(View.VISIBLE);
                    holder.title_l.setVisibility(View.INVISIBLE);
                    holder.editText_string.setVisibility(View.GONE);
                    holder.editText.setVisibility(View.GONE);
                    String asas=HCApplication.all_selected.getString("q4013");
                    if (asas.length()>0) {
                        holder.editText_string.setVisibility(View.VISIBLE);
                        holder.editText_string.setText(HCApplication.all_selected.getString("q4013"));
                    }
                    int arr_lenght = jsonArray.length();
                    show(arr_lenght);

                }

                else {
                    holder.spinner.setVisibility(View.GONE);
                    holder.select.setVisibility(View.VISIBLE);
                    holder.hideradio.setVisibility(View.VISIBLE);
                    holder.title_l.setVisibility(View.INVISIBLE);
                    holder.editText_string.setVisibility(View.GONE);
                    int arr_lenght = jsonArray.length();
                    show(arr_lenght);

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } else if (check.equals("q")) {
            holder.select.setVisibility(View.GONE);
            holder.title_l.setVisibility(View.GONE);
            holder.editText_string.setVisibility(View.GONE);
            holder.title_l.setVisibility(View.GONE);

//            holder.ver_sp.setVisibility(View.GONE);
//            holder.hor_sp.setVisibility(View.GONE);
            holder.select.setMinimumWidth(R.dimen.mini__width);
            holder.title_l.setMinimumWidth(R.dimen.mini__width);


        } else {
            holder.editText_string.setVisibility(View.GONE);
            holder.select.setVisibility(View.GONE);
            holder.title_l.setVisibility(View.VISIBLE);
            HCApplication.move_ment.set(position,"a");
            // HCApplication.move_ment.add("a");
//            holder.ver_sp.setVisibility(View.GONE);
//            holder.hor_sp.setVisibility(View.GONE);
            holder.text.setText(question_name.get(position));


        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }


    // use this method to control  in number of radio button  which  show in  each question
    private void show(int array_length) throws JSONException {
        if (array_length == 2) {
            holder.crd1.setText(jsonArray.get(0).toString());
            holder.crd2.setText(jsonArray.get(1).toString());
            holder.crd3.setVisibility(View.GONE);
            holder.crd4.setVisibility(View.GONE);
            holder.crd5.setVisibility(View.GONE);
            holder.crd6.setVisibility(View.GONE);
            holder.crd7.setVisibility(View.GONE);
            holder.crd8.setVisibility(View.GONE);
            holder.crd9.setVisibility(View.GONE);

        } else if (array_length == 3) {
            holder.crd1.setText(jsonArray.get(0).toString());
            holder.crd2.setText(jsonArray.get(1).toString());
            holder.crd3.setVisibility(View.VISIBLE);
            holder.crd3.setText(jsonArray.get(2).toString());
            holder.crd4.setVisibility(View.GONE);
            holder.crd5.setVisibility(View.GONE);
            holder.crd6.setVisibility(View.GONE);
            holder.crd7.setVisibility(View.GONE);
            holder.crd8.setVisibility(View.GONE);
            holder.crd9.setVisibility(View.GONE);

        } else if (array_length == 4) {
            holder.crd1.setText(jsonArray.get(0).toString());
            holder.crd2.setText(jsonArray.get(1).toString());
            holder.crd3.setVisibility(View.VISIBLE);
            holder.crd3.setText(jsonArray.get(2).toString());
            holder.crd4.setVisibility(View.VISIBLE);
            holder.crd4.setText(jsonArray.get(3).toString());
            holder.crd5.setVisibility(View.GONE);
            holder.crd6.setVisibility(View.GONE);
            holder.crd7.setVisibility(View.GONE);
            holder.crd8.setVisibility(View.GONE);
            holder.crd9.setVisibility(View.GONE);

        } else if (array_length == 5) {
            holder.crd1.setText(jsonArray.get(0).toString());
            holder.crd2.setText(jsonArray.get(1).toString());
            holder.crd3.setVisibility(View.VISIBLE);
            holder.crd3.setText(jsonArray.get(2).toString());
            holder.crd4.setVisibility(View.VISIBLE);
            holder.crd4.setText(jsonArray.get(3).toString());
            holder.crd5.setVisibility(View.VISIBLE);
            holder.crd5.setText(jsonArray.get(4).toString());
            holder.crd6.setVisibility(View.GONE);
            holder.crd7.setVisibility(View.GONE);
            holder.crd8.setVisibility(View.GONE);
            holder.crd9.setVisibility(View.GONE);

        } else if (array_length == 6) {
            holder.crd1.setText(jsonArray.get(0).toString());
            holder.crd2.setText(jsonArray.get(1).toString());
            holder.crd3.setVisibility(View.VISIBLE);
            holder.crd3.setText(jsonArray.get(2).toString());
            holder.crd4.setVisibility(View.VISIBLE);
            holder.crd4.setText(jsonArray.get(3).toString());
            holder.crd5.setVisibility(View.VISIBLE);
            holder.crd5.setText(jsonArray.get(4).toString());
            holder.crd6.setVisibility(View.VISIBLE);
            holder.crd6.setText(jsonArray.get(5).toString());
            holder.crd7.setVisibility(View.GONE);
            holder.crd8.setVisibility(View.GONE);
            holder.crd9.setVisibility(View.GONE);

        } else if (array_length == 7) {
            holder.crd1.setText(jsonArray.get(0).toString());
            holder.crd2.setText(jsonArray.get(1).toString());
            holder.crd3.setVisibility(View.VISIBLE);
            holder.crd3.setText(jsonArray.get(2).toString());
            holder.crd4.setVisibility(View.VISIBLE);
            holder.crd4.setText(jsonArray.get(3).toString());
            holder.crd5.setVisibility(View.VISIBLE);
            holder.crd5.setText(jsonArray.get(4).toString());
            holder.crd6.setVisibility(View.VISIBLE);
            holder.crd6.setText(jsonArray.get(5).toString());
            holder.crd7.setVisibility(View.VISIBLE);
            holder.crd7.setText(jsonArray.get(6).toString());
            holder.crd8.setVisibility(View.GONE);
            holder.crd9.setVisibility(View.GONE);

        } else if (array_length == 8) {

            holder.crd1.setText(jsonArray.get(0).toString());
            holder.crd2.setText(jsonArray.get(1).toString());
            holder.crd3.setVisibility(View.VISIBLE);
            holder.crd3.setText(jsonArray.get(2).toString());
            holder.crd4.setVisibility(View.VISIBLE);
            holder.crd4.setText(jsonArray.get(3).toString());
            holder.crd5.setVisibility(View.VISIBLE);
            holder.crd5.setText(jsonArray.get(4).toString());
            holder.crd6.setVisibility(View.VISIBLE);
            holder.crd6.setText(jsonArray.get(5).toString());
            holder.crd7.setVisibility(View.VISIBLE);
            holder.crd7.setText(jsonArray.get(6).toString());
            holder.crd8.setVisibility(View.VISIBLE);
            holder.crd8.setText(jsonArray.get(7).toString());
            holder.crd9.setVisibility(View.GONE);


        } else {

            holder.crd1.setText(jsonArray.get(0).toString());
            holder.crd2.setText(jsonArray.get(1).toString());
            holder.crd3.setVisibility(View.VISIBLE);
            holder.crd3.setText(jsonArray.get(2).toString());
            holder.crd4.setVisibility(View.VISIBLE);
            holder.crd4.setText(jsonArray.get(3).toString());
            holder.crd5.setVisibility(View.VISIBLE);
            holder.crd5.setText(jsonArray.get(4).toString());
            holder.crd6.setVisibility(View.VISIBLE);
            holder.crd6.setText(jsonArray.get(5).toString());
            holder.crd7.setVisibility(View.VISIBLE);
            holder.crd7.setText(jsonArray.get(6).toString());
            holder.crd8.setVisibility(View.VISIBLE);
            holder.crd8.setText(jsonArray.get(7).toString());
            holder.crd9.setVisibility(View.VISIBLE);
            holder.crd9.setText(jsonArray.get(8).toString());

        }

    }

    //  use this fuction  to   add select item  when  app is closed nad re-open
    private void set_Selected(String value) {

        switch (value) {
            case "1":
                holder.crd1.setChecked(true);
                break;
            case "2":
                holder.crd2.setChecked(true);
                break;
            case "3":
                holder.crd3.setChecked(true);
                break;
            case "4":
                holder.crd4.setChecked(true);
                break;
            case "5":
                holder.crd5.setChecked(true);
                break;
            case "6":
                holder.crd6.setChecked(true);
                break;
            case "7":
                holder.crd7.setChecked(true);
                break;
            case "8":
                holder.crd8.setChecked(true);
                break;
            case "9":
                holder.crd9.setChecked(true);
                break;
            default:
                break;

        }
    }
}
