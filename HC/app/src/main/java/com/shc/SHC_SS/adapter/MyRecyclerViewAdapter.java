package com.shc.SHC_SS.adapter;
import com.shc.SHC_SS.R;
import com.shc.SHC_SS.utilies.HCApplication;
import com.shc.SHC_SS.views.CustomRaidoButtonN;
import com.shc.SHC_SS.views.HCEditTextN;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.shc.SHC_SS.activities.QuestionsShow;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by jawdah on 3/29/2017.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.CustomViewHolder> {
    Context context;
    CustomViewHolder holder;
    JSONArray jsonArray;
    ArrayList<String> arrayLists = new ArrayList<String>();
    public static ArrayList<String> result = new ArrayList<String>();
    ArrayList<String> question_name = new ArrayList<String>();
    ArrayList<Integer> question_hide = new ArrayList<Integer>();
    String selected_item;
    View view;
    static String question;
    static int postion;
    // ViewGroup viewGroup;
    RecyclerView mRecyclerView;
    HCEditTextN editText;
    FrameLayout frameLayout;
    ArrayList question_value_from_json = new ArrayList(), question_name_from_json = new ArrayList();
    ArrayList<String> answer = new ArrayList<>();
    int check_color;
    ArrayList<String> checked_item = new ArrayList<>();


    public MyRecyclerViewAdapter(Context con, ArrayList<String> prgmNameList, ArrayList<String> arrayLists, ArrayList<String> question_name, int check_color, ArrayList checked_item) {
        result = prgmNameList;
        this.arrayLists = arrayLists;
        this.question_name = question_name;
        this.context = con;
        mRecyclerView = (RecyclerView) HCApplication.view.findViewById(R.id.child_question);
        frameLayout = (FrameLayout) HCApplication.view.findViewById(R.id.frame_child);
        editText = (HCEditTextN) HCApplication.view.findViewById(R.id.child_edittext);
        RtlGridLayoutManager gridLayoutManager = new RtlGridLayoutManager(HCApplication.newInstance().context, 1);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        this.check_color = check_color;
        this.checked_item = checked_item;
        setHasStableIds(true);

    }

    @Override
    public int getItemViewType(int position) {
        return position;

    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_grid_layout, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        postion = i;
        // this.viewGroup = viewGroup;
        return viewHolder;
    }

    public View getViewForCard(Context context, int pos) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        Context ctx = context;
        LinearLayout ll = new LinearLayout(ctx);
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

        String check = result.get(pos);
        Log.d("tesat",pos+"  "+checked_item.size());
        if (pos<checked_item.size()) {
            selected_item = checked_item.get(pos).toString().trim();
        }
        if (!check.equals("title") && !check.equals("q")) {
            holder.tv.setText(question_name.get(pos).replace("q", "س ").replace("Q", "س ") + "  \t" + result.get(pos));
            String as = arrayLists.get(pos);
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

                if (check.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q4001"))) {
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
               else  if (check.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q4007"))) {
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
                    holder.editText.setText(selected_item);

                    holder.title_l.setVisibility(View.GONE);

                } else if (check.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q4005"))) {
                    holder.spinner.setVisibility(View.GONE);
                    holder.hideradio.setVisibility(View.GONE);
                    String asas = HCApplication.saveDataInSharedPrefrances.getStringFRomShard("edittext", "q4005");
                    holder.editText.setText(selected_item);
                    holder.editText.setVisibility(View.VISIBLE);

                } else if (check.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6501"))) {
                    holder.spinner.setVisibility(View.GONE);
                    holder.hideradio.setVisibility(View.GONE);
                    holder.editText.setVisibility(View.VISIBLE);
                    holder.editText.setText(selected_item);

                } else if (check.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6501"))) {
                    holder.spinner.setVisibility(View.GONE);
                    holder.hideradio.setVisibility(View.GONE);
                    holder.editText.setVisibility(View.VISIBLE);
                    holder.editText.setText(selected_item);

                } else if (check.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6502"))) {
                    holder.spinner.setVisibility(View.GONE);
                    holder.hideradio.setVisibility(View.GONE);
                    holder.editText.setVisibility(View.VISIBLE);
                    holder.editText.setText(selected_item);

                } else if (check.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6503"))) {
                    holder.spinner.setVisibility(View.GONE);
                    holder.hideradio.setVisibility(View.GONE);
                    holder.editText.setVisibility(View.VISIBLE);
                    holder.editText.setText(selected_item);

                } else if (check.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6504"))) {
                    holder.spinner.setVisibility(View.GONE);
                    holder.hideradio.setVisibility(View.GONE);
                    holder.editText.setVisibility(View.VISIBLE);
                    holder.editText.setText(selected_item);

                } else if (check.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6505"))) {
                    holder.spinner.setVisibility(View.GONE);
                    holder.hideradio.setVisibility(View.GONE);
                    holder.editText.setVisibility(View.VISIBLE);
                    holder.editText.setText(selected_item);

                } else if (check.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6506"))) {
                    holder.spinner.setVisibility(View.GONE);
                    holder.hideradio.setVisibility(View.GONE);
                    holder.editText.setVisibility(View.VISIBLE);
                    holder.editText.setText(selected_item);

                } else if (check.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6507"))) {
                    holder.spinner.setVisibility(View.GONE);
                    holder.hideradio.setVisibility(View.GONE);
                    holder.editText.setVisibility(View.VISIBLE);
                    holder.editText.setText(selected_item);

                } else if (check.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6508"))) {
                    holder.spinner.setVisibility(View.GONE);
                    holder.hideradio.setVisibility(View.GONE);
                    holder.editText.setVisibility(View.VISIBLE);
                    holder.editText.setText(selected_item);
                    holder.editText_string.setVisibility(View.GONE);


                } else if (check.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6509"))) {
                    holder.spinner.setVisibility(View.GONE);
                    holder.hideradio.setVisibility(View.GONE);
                    holder.editText.setVisibility(View.VISIBLE);
                    holder.editText.setText(selected_item+"");
                    holder.editText_string.setVisibility(View.GONE);


                } else if (check.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6510"))) {
                    holder.spinner.setVisibility(View.GONE);
                    holder.hideradio.setVisibility(View.GONE);
                    holder.editText.setVisibility(View.VISIBLE);
                    holder.editText.setText(selected_item);
                    holder.editText_string.setVisibility(View.GONE);


                } else if (check.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6604"))) {
                    holder.spinner.setVisibility(View.GONE);
                    holder.hideradio.setVisibility(View.GONE);
                    holder.editText.setVisibility(View.GONE);
                    holder.editText_string.setVisibility(View.GONE);

                    holder.seek_li.setVisibility(View.VISIBLE);
                    if (!selected_item.equals("")) {
                        int a = Integer.parseInt(selected_item);
                        if (a != 0) {
                            holder.seekBar.setProgress(a);
                        }
                    }

                } else if (check.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6605"))) {
                    holder.spinner.setVisibility(View.GONE);
                    holder.hideradio.setVisibility(View.GONE);
                    holder.editText.setVisibility(View.GONE);
                    holder.seek_li.setVisibility(View.VISIBLE);
                    if (!selected_item.equals("")) {
                        int a = Integer.parseInt(selected_item);
                        if (a != 0) {
                            holder.seekBar.setProgress(a);
                        }
                    }

                    holder.editText_string.setVisibility(View.GONE);


                } else if (check.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6606"))) {
                    holder.spinner.setVisibility(View.GONE);
                    holder.hideradio.setVisibility(View.GONE);
                    holder.editText.setVisibility(View.GONE);
                    holder.seek_li.setVisibility(View.VISIBLE);
                    holder.editText_string.setVisibility(View.GONE);
                    if (!selected_item.equals("")) {
                        int a = Integer.parseInt(selected_item);
                        if (a != 0) {
                            holder.seekBar.setProgress(a);
                        }
                    }


                } else if (check.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6607"))) {
                    holder.spinner.setVisibility(View.GONE);
                    holder.hideradio.setVisibility(View.GONE);
                    holder.editText.setVisibility(View.GONE);
                    holder.seek_li.setVisibility(View.VISIBLE);
                    holder.editText_string.setVisibility(View.GONE);
                    if (!selected_item.equals("")) {
                        int a = Integer.parseInt(selected_item);
                        if (a != 0) {
                            holder.seekBar.setProgress(a);
                        }
                    }


                } else if (check.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6608"))) {
                    holder.spinner.setVisibility(View.GONE);
                    holder.hideradio.setVisibility(View.GONE);
                    holder.editText.setVisibility(View.GONE);
                    holder.seek_li.setVisibility(View.VISIBLE);
                    holder.editText_string.setVisibility(View.GONE);
                    if (!selected_item.equals("")) {
                        int a = Integer.parseInt(selected_item);
                        if (a != 0) {
                            holder.seekBar.setProgress(a);
                        }
                    }


                } else if (check.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6609"))) {
                    holder.spinner.setVisibility(View.GONE);
                    holder.hideradio.setVisibility(View.GONE);
                    holder.editText.setVisibility(View.GONE);
                    holder.seek_li.setVisibility(View.VISIBLE);
                    holder.editText_string.setVisibility(View.GONE);
                    if (!selected_item.equals("")) {
                        int a = Integer.parseInt(selected_item);
                        if (a != 0) {
                            holder.seekBar.setProgress(a);
                        }
                    }


                } else if (check.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6610"))) {
                    holder.spinner.setVisibility(View.GONE);
                    holder.hideradio.setVisibility(View.GONE);
                    holder.editText.setVisibility(View.GONE);
                    holder.seek_li.setVisibility(View.VISIBLE);
                    holder.editText_string.setVisibility(View.GONE);
                    if (!selected_item.equals("")) {
                        int a = Integer.parseInt(selected_item);
                        if (a != 0) {
                            holder.seekBar.setProgress(a);
                        }
                    }


                } else if (check.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6611"))) {
                    holder.spinner.setVisibility(View.GONE);
                    holder.hideradio.setVisibility(View.GONE);
                    holder.editText.setVisibility(View.GONE);
                    holder.seek_li.setVisibility(View.VISIBLE);
                    holder.editText_string.setVisibility(View.GONE);
                    if (!selected_item.equals("")) {
                        int a = Integer.parseInt(selected_item);
                        if (a != 0) {
                            holder.seekBar.setProgress(a);
                        }
                    }


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

                } else if (check.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6001b"))) {
                    holder.spinner.setVisibility(View.GONE);
                    holder.hideradio.setVisibility(View.GONE);
                    holder.editText.setVisibility(View.VISIBLE);
                    holder.editText.setText(selected_item);
                    holder.editText_string.setVisibility(View.GONE);

                } else if (check.equals("أخرى حدد ")) {
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
                    if (HCApplication.show_q4005 == 1) {
                        holder.editText.setVisibility(View.VISIBLE);
                        holder.editText.setText(selected_item);
                    }
                    int arr_lenght = jsonArray.length();
                    show(arr_lenght);

                } else {
                    holder.spinner.setVisibility(View.GONE);
                    holder.select.setVisibility(View.VISIBLE);
                    holder.hideradio.setVisibility(View.VISIBLE);
                    holder.title_l.setVisibility(View.INVISIBLE);
                    holder.editText_string.setVisibility(View.GONE);
                    editText.setVisibility(View.INVISIBLE);
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
            HCApplication.move_ment.set(pos,"a");
           // HCApplication.move_ment.add("a");
//            holder.ver_sp.setVisibility(View.GONE);
//            holder.hor_sp.setVisibility(View.GONE);
            holder.text.setText(question_name.get(pos));


        }
        return ll;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int i) {
        this.holder = holder;
        View view = getViewForCard(HCApplication.context, i);
        holder.viewGroup.childDrawableStateChanged(view);
        //   holder.viewGroup.addView(view);


    }

    @Override
    public int getItemCount() {
        return (null != arrayLists ? arrayLists.size() : 0);
    }


    class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv, text;
        LinearLayout select, title_l, hideradio, seek_li;
        CustomRaidoButtonN crd1, crd2, crd3, crd4, crd5, crd6, crd7, crd8, crd9;
        View ver_sp, hor_sp;
        FrameLayout allItems;
        HCEditTextN editText, editText_string;
        Spinner spinner;
        ViewGroup viewGroup;
        SeekBar seekBar;

        public CustomViewHolder(final View view) {
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
                        HCApplication.all_item.put(question_name.get(getLayoutPosition()).replace("q", "Q"), progress);
                        HCApplication.check.set(getLayoutPosition(),progress+"");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    HCApplication.move_ment.set(getLayoutPosition(),"a");

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
                        HCApplication.all_item.put(question_name.get(getLayoutPosition()).replace("q", "Q"), positn);
                        HCApplication.move_ment.set(getLayoutPosition(),"a");
                        HCApplication.check.set(getLayoutPosition(),positn+"");
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
                            HCApplication.all_item.put(question_name.get(getLayoutPosition()).replace("q", "Q"), editText_string.getText().toString());
                            HCApplication.check.set(getLayoutPosition(), editText_string.getText().toString());

                        }
                        if (editText.getText().length() == 1) {
                            HCApplication.move_ment.set(getLayoutPosition(),"a");
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

                @Override
                public void afterTextChanged(Editable s) {
                    String as = question_name.get(getLayoutPosition());
                    HCApplication.saveDataInSharedPrefrances.save_data_String("edittext", as, editText_string.getText().toString());

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
                            HCApplication.all_item.put(question_name.get(getLayoutPosition()).replace("q", "Q"), Integer.parseInt(editText.getText().toString()));
                            HCApplication.check.set(getLayoutPosition(), editText.getText().toString());

                        }
                        if (editText.getText().length() == 1) {
                            HCApplication.move_ment.set(getLayoutPosition(),"a");
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

                @Override
                public void afterTextChanged(Editable s) {
                    String as = question_name.get(getLayoutPosition());
                    HCApplication.saveDataInSharedPrefrances.save_data_String("edittext", as, editText_string.getText().toString());

                }
            });


        }


        @Override
        public void onClick(View v) {
            switch (v.getId()) {

                case R.id.txt_rd7_1:

//                    if (HCApplication.check_select_child.size()>=3) {
//                        HCApplication.check_select_child.clear();

                    HCApplication.move_ment.set(this.getAdapterPosition(),"a");
                    HCApplication.check.set(this.getAdapterPosition(), "1");
                    question = result.get(getAdapterPosition());
                    if (HCApplication.check_select_child.size() == 3) {
                        checkValueToAppearRecyler(this.getAdapterPosition());
                    } else {
                        crd1.setChecked(false);
                        Toast.makeText(context, " الرجاء اختيار جميع الأسئلة الظاهرة يسار الشاشة   ", Toast.LENGTH_LONG).show();

                    }
                    try {

                        if (!crd1.getText().equals("نعم")) {
                            HCApplication.all_item.put(question_name.get(this.getAdapterPosition()).replace("q", "Q"), 0);
                        } else {
                            HCApplication.all_item.put(question_name.get(this.getAdapterPosition()).replace("q", "Q"), 1);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    crd1.setChecked(true);
                    crd2.setChecked(false);
                    crd3.setChecked(false);
                    crd4.setChecked(false);
                    crd5.setChecked(false);
                    crd6.setChecked(false);
                    crd7.setChecked(false);
                    crd8.setChecked(false);
                    crd9.setChecked(false);
                    // use this part to  show child question

                    try {
                        if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q4004"))) {
                            question = question_name.get(this.getAdapterPosition() + 1);
                            if (question.equals("q4005")) {
                                HCApplication.show_q4005 = 1;
                                delete(this.getAdapterPosition());
                                editText.setText(checked_item.get(this.getAdapterPosition() + 1));
                                editText.setVisibility(View.VISIBLE);
                                if (!checked_item.get(this.getAdapterPosition() + 1).equals("")) {
                                    holder.editText.setText(checked_item.get(this.getAdapterPosition() + 1));
                                }
                                HCApplication.check_remove = 1;
                            }
                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5001"))) {
                            question = question_name.get(this.getAdapterPosition() + 1);
                            if (question.equals("q5001a")) {
                                HCApplication.show_5001 = 1;
                                deleteAll(this.getAdapterPosition());
                            }
                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6200"))) {
                            HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "Value_Name", 7);
                            HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "Value_Back", 5);
                            HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "open_screen", 6);
                            HCApplication.back_section = 5;
                            HCApplication.show_6260 = 1;
                            HCApplication.myIntent.move_activity_to_anhter(HCApplication.context, new QuestionsShow());

                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6102"))) {
                            if (HCApplication.show_q6104 == 1) {
                                HCApplication.show_q6104 = 0;
                                HCApplication.span_6102back = 1;
                                AddItem(this.getAdapterPosition(), "q6103", "r6103");


                            }
                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6230"))) {
                            if (HCApplication.check_section6230 == 1) {
                                HCApplication.check_section6230 = 0;
                                AddItem(this.getAdapterPosition(), "q6231", "status_iteration");


                            }
                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5002"))) {
                            question = question_name.get(this.getAdapterPosition() + 1);
                            if (question.equals("q5002a")) {
                                HCApplication.show_5002 = 1;
                                deleteAll(this.getAdapterPosition());
                            }
                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5003"))) {
                            question = question_name.get(this.getAdapterPosition() + 1);
                            if (question.equals("q5003a")) {
                                HCApplication.show_5003 = 1;
                                deleteAll(this.getAdapterPosition());
                            }
                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5004"))) {
                            question = question_name.get(this.getAdapterPosition() + 1);
                            if (question.equals("q5004a")) {
                                HCApplication.show_5004 = 1;
                                deleteAll(this.getAdapterPosition());
                            }
                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5005"))) {
                            question = question_name.get(this.getAdapterPosition() + 1);
                            if (question.equals("q5005a")) {
                                HCApplication.show_5005 = 1;
                                deleteAll(this.getAdapterPosition());
                            }
                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5006"))) {
                            question = question_name.get(this.getAdapterPosition() + 1);
                            if (question.equals("q5006a")) {
                                HCApplication.show_5006 = 1;
                                deleteAll(this.getAdapterPosition());
                            }
                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5007"))) {
                            question = question_name.get(this.getAdapterPosition() + 1);
                            if (question.equals("q5007a")) {
                                HCApplication.show_5007 = 1;
                                deleteAll(this.getAdapterPosition());
                            }
                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5008"))) {
                            question = question_name.get(this.getAdapterPosition() + 1);
                            if (question.equals("q5008a")) {
                                HCApplication.show_5008 = 1;
                                deleteAll(this.getAdapterPosition());
                            }
                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5009"))) {
                            question = question_name.get(this.getAdapterPosition() + 1);
                            if (question.equals("q5009a")) {
                                HCApplication.show_5009 = 1;
                                deleteAll(this.getAdapterPosition());
                            }
                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5010"))) {
                            question = question_name.get(this.getAdapterPosition() + 1);
                            if (question.equals("q5010a")) {
                                HCApplication.show_5010 = 1;
                                deleteAll(this.getAdapterPosition());
                            }
                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5011"))) {
                            question = question_name.get(this.getAdapterPosition() + 1);
                            if (question.equals("q5011a")) {
                                HCApplication.show_5011 = 1;
                                deleteAll(this.getAdapterPosition());
                            }
                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5011"))) {
                            question = question_name.get(this.getAdapterPosition() + 1);
                            if (question.equals("q5011a")) {
                                HCApplication.show_5011 = 1;
                                deleteAll(this.getAdapterPosition());
                            }
                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5012"))) {
                            question = question_name.get(this.getAdapterPosition() + 1);
                            if (question.equals("q5012a")) {
                                HCApplication.show_5012 = 1;
                                deleteAll(this.getAdapterPosition());
                            }
                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5013"))) {
                            question = question_name.get(this.getAdapterPosition() + 1);
                            if (question.equals("q5013a")) {
                                HCApplication.show_5013 = 1;
                                deleteAll(this.getAdapterPosition());
                            }
                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5014"))) {
                            question = question_name.get(this.getAdapterPosition() + 1);
                            if (question.equals("q5014a")) {
                                HCApplication.show_5014 = 1;
                                deleteAll(this.getAdapterPosition());
                            }
                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5014"))) {
                            question = question_name.get(this.getAdapterPosition() + 1);
                            if (question.equals("q5014a")) {
                                HCApplication.show_5014 = 1;
                                deleteAll(this.getAdapterPosition());
                            }
                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5015"))) {
                            question = question_name.get(this.getAdapterPosition() + 1);
                            if (question.equals("q5015a")) {
                                HCApplication.show_5015 = 1;
                                deleteAll(this.getAdapterPosition());
                            }
                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5016"))) {
                            question = question_name.get(this.getAdapterPosition() + 1);
                            if (question.equals("q5016a")) {
                                HCApplication.show_5016 = 1;
                                deleteAll(this.getAdapterPosition());
                            }
                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5017"))) {
                            question = question_name.get(this.getAdapterPosition() + 1);
                            if (question.equals("q5017a")) {
                                HCApplication.show_5017 = 1;
                                deleteAll(this.getAdapterPosition());
                                editText.setVisibility(View.GONE);
                                editText_string.setVisibility(View.GONE);
                            }
                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6130"))) {
                            if (HCApplication.show_q6130 == 1) {
                                HCApplication.show_q6130 = 0;
                                AddItem(this.getAdapterPosition(), "q6131", "status_iteration");

                            }
                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("Q6203"))) {
                            if (HCApplication.show_q6205 == 1) {
                                HCApplication.show_q6205 = 0;
                                HCApplication.span_q6200 = 0;
                                AddItem(this.getAdapterPosition(), "q6204", "r6103");

                            }
                        }


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    break;
                case R.id.txt_rd7_2:
                    HCApplication.check.set(this.getAdapterPosition(), "2");
                    HCApplication.move_ment.set(this.getAdapterPosition(),"a");
                    crd2.setChecked(true);
                    crd1.setChecked(false);
                    crd3.setChecked(false);
                    crd4.setChecked(false);
                    crd5.setChecked(false);
                    crd6.setChecked(false);
                    crd7.setChecked(false);
                    crd8.setChecked(false);
                    crd9.setChecked(false);
                    try {
                        question = result.get(getAdapterPosition());
                        if (!crd2.getText().equals("لا")) {
                            HCApplication.all_item.put(question_name.get(this.getAdapterPosition()).replace("q", "Q"), 1);
                            editText.setVisibility(View.GONE);
                            checkValueToDisappearRecyler(this.getAdapterPosition(), question);

                        } else {
                            editText.setVisibility(View.GONE);
                            HCApplication.all_item.put(question_name.get(this.getAdapterPosition()).replace("q", "Q"), 0);
                            checkValueToDisappearRecyler(this.getAdapterPosition(), question);

                        }

                        // transportation
                        if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q4004"))) {
                            try {
                                if (HCApplication.show_q4005 == 1) {
                                    HCApplication.show_q4005 = 0;
                                    AddItem(this.getAdapterPosition(), "q4005", "r4005");
                                    HCApplication.check_remove = 0;
                                    editText.setVisibility(View.INVISIBLE);

                                }


                            } catch (Exception e) {
                                Log.e("saa", e.getMessage());
                            }

                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5001"))) {
                            try {
                                if (HCApplication.show_5001 == 1) {
                                    HCApplication.show_5001 = 0;
                                    addQuestionAfterRemove(this.getAdapterPosition(), "q5001a", "q5001b", "q5001c");
                                }


                            } catch (Exception e) {
                                Log.e("saa", e.getMessage());
                            }

                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5002"))) {
                            try {
                                if (HCApplication.show_5002 == 1) {
                                    HCApplication.show_5002 = 0;
                                    addQuestionAfterRemove(this.getAdapterPosition(), "q5002a", "q5002b", "q5002c");
                                }


                            } catch (Exception e) {
                                Log.e("saa", e.getMessage());
                            }

                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5003"))) {
                            try {
                                if (HCApplication.show_5003 == 1) {
                                    HCApplication.show_5003 = 0;
                                    addQuestionAfterRemove(this.getAdapterPosition(), "q5003a", "q5003b", "q5003c");
                                }


                            } catch (Exception e) {
                                Log.e("saa", e.getMessage());
                            }

                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6200"))) {
                            HCApplication.show_6260 = 0;
                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5004"))) {
                            try {
                                if (HCApplication.show_5004 == 1) {
                                    HCApplication.show_5004 = 0;
                                    addQuestionAfterRemove(this.getAdapterPosition(), "q5004a", "q5004b", "q5004c");
                                }


                            } catch (Exception e) {
                                Log.e("saa", e.getMessage());
                            }

                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6000"))) {
                            try {

                                question=question_name.get(this.getAdapterPosition()+1);
                                if (question.equals("q6002")){

                                    AddItem(this.getAdapterPosition(), "q6001a", "r6001a");
                                }
                                else
                                {
                                    SetItem(this.getAdapterPosition(), "q6001a", "r6001a");
                                }


                            } catch (Exception e) {
                                Log.e("saa", e.getMessage());
                            }

                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5005"))) {
                            try {
                                if (HCApplication.show_5005 == 1) {
                                    HCApplication.show_5005 = 0;
                                    addQuestionAfterRemove(this.getAdapterPosition(), "q5005a", "q5005b", "q5005c");

                                }


                            } catch (Exception e) {
                                Log.e("saa", e.getMessage());
                            }

                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5006"))) {
                            try {
                                if (HCApplication.show_5006 == 1) {
                                    HCApplication.show_5006 = 0;
                                    addQuestionAfterRemove(this.getAdapterPosition(), "q5006a", "q5006b", "q5006c");

                                }


                            } catch (Exception e) {
                                Log.e("saa", e.getMessage());
                            }

                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5007"))) {
                            try {
                                if (HCApplication.show_5007 == 1) {
                                    HCApplication.show_5007 = 0;
                                    addQuestionAfterRemove(this.getAdapterPosition(), "q5007a", "q5007b", "q5007c");

                                }
                            } catch (Exception e) {
                                Log.e("saa", e.getMessage());
                            }

                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5008"))) {
                            try {
                                if (HCApplication.show_5008 == 1) {
                                    HCApplication.show_5008 = 0;
                                    addQuestionAfterRemove(this.getAdapterPosition(), "q5008a", "q5008b", "q5008c");

                                }
                            } catch (Exception e) {
                                Log.e("saa", e.getMessage());
                            }

                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5009"))) {
                            try {
                                if (HCApplication.show_5009 == 1) {
                                    HCApplication.show_5009 = 0;
                                    addQuestionAfterRemove(this.getAdapterPosition(), "q5009a", "q5009b", "q5009c");

                                }
                            } catch (Exception e) {
                                Log.e("saa", e.getMessage());
                            }

                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5010"))) {
                            try {
                                if (HCApplication.show_5010 == 1) {
                                    HCApplication.show_5010 = 0;
                                    ArrayList allq = new ArrayList();
                                    ArrayList allr = new ArrayList();
                                    addQuestionAfterRemove(this.getAdapterPosition(), "q5010a", "q5010b", "q5010c");

                                }
                            } catch (Exception e) {
                                Log.e("saa", e.getMessage());
                            }

                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5011"))) {
                            try {
                                if (HCApplication.show_5011 == 1) {
                                    HCApplication.show_5011 = 0;
                                    addQuestionAfterRemove(this.getAdapterPosition(), "q5011a", "q5011b", "q5011c");

                                }
                            } catch (Exception e) {
                                Log.e("saa", e.getMessage());
                            }

                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5012"))) {
                            try {
                                if (HCApplication.show_5012 == 1) {
                                    HCApplication.show_5012 = 0;
                                    addQuestionAfterRemove(this.getAdapterPosition(), "q5012a", "q5012b", "q5012c");

                                }
                            } catch (Exception e) {
                                Log.e("saa", e.getMessage());
                            }

                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5013"))) {
                            try {
                                if (HCApplication.show_5013 == 1) {
                                    HCApplication.show_5013 = 0;
                                    addQuestionAfterRemove(this.getAdapterPosition(), "q5013a", "q5013b", "q5013c");

                                }
                            } catch (Exception e) {
                                Log.e("saa", e.getMessage());
                            }

                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5014"))) {
                            try {
                                if (HCApplication.show_5014 == 1) {
                                    HCApplication.show_5014 = 0;
                                    addQuestionAfterRemove(this.getAdapterPosition(), "q5014a", "q5014b", "q5014c");

                                }
                            } catch (Exception e) {
                                Log.e("saa", e.getMessage());
                            }

                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5015"))) {
                            try {
                                if (HCApplication.show_5015 == 1) {
                                    HCApplication.show_5015 = 0;
                                    addQuestionAfterRemove(this.getAdapterPosition(), "q5015a", "q5015b", "q5015c");

                                }
                            } catch (Exception e) {
                                Log.e("saa", e.getMessage());
                            }

                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5016"))) {
                            try {
                                if (HCApplication.show_5016 == 1) {
                                    HCApplication.show_5016 = 0;
                                    addQuestionAfterRemove(this.getAdapterPosition(), "q5016a", "q5016b", "q5016c");
                                    editText_string.setVisibility(View.GONE);

                                }
                            } catch (Exception e) {
                                Log.e("saa", e.getMessage());
                            }

                        }

                        else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5017"))) {
                            try {
                                editText_string.setVisibility(View.VISIBLE);
                                if (HCApplication.show_5017 == 1) {
                                    HCApplication.show_5017 = 0;
                                    addQuestionAfterRemove(this.getAdapterPosition(), "q5017a", "q5017b", "q5017c");
                                }
                            } catch (Exception e) {
                                Log.e("saa", e.getMessage());
                            }

                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q4012"))) {
                            HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "open_screen", 2);
                            HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "Value_Name", 3);
                            HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "Value_Back", 1);
                            HCApplication.myIntent.move_activity_to_anhter(HCApplication.context, new QuestionsShow());
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    break;
                case R.id.txt_rd7_3:
                    HCApplication.check.set(this.getAdapterPosition(), "3");
                    HCApplication.move_ment.set(this.getAdapterPosition(),"a");
                    try {
                        question = result.get(getAdapterPosition());
                        HCApplication.all_item.put(question_name.get(this.getAdapterPosition()).replace("q", "Q"), 2);
                        editText_string.setVisibility(View.INVISIBLE);
                        addForSecoondAndThirdRadio(this.getAdapterPosition());

                        if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5017"))) {
                                editText_string.setVisibility(View.VISIBLE);
                                if (HCApplication.show_5017 == 1) {
                                    HCApplication.show_5017 = 0;
                                    addQuestionAfterRemove(this.getAdapterPosition(), "q5017a", "q5017b", "q5017c");
                                }
                            }

                    } catch (Exception e) {
                    }

                    crd3.setChecked(true);
                    crd1.setChecked(false);
                    crd2.setChecked(false);
                    crd4.setChecked(false);
                    crd5.setChecked(false);
                    crd6.setChecked(false);
                    crd7.setChecked(false);
                    crd8.setChecked(false);
                    crd9.setChecked(false);

                    break;
                case R.id.txt_rd7_4:
                    HCApplication.check.set(this.getAdapterPosition(), "4");
                    HCApplication.move_ment.set(this.getAdapterPosition(),"a");
                    try {
                        HCApplication.all_item.put(question_name.get(this.getAdapterPosition()).replace("q", "Q"), 3);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    try {
                        question = result.get(getAdapterPosition());
                        if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6000"))) {

                            question=question_name.get(this.getAdapterPosition()+1);
                            if (question.equals("q6002")){
                                AddItem(this.getAdapterPosition(), "q6001b", "r6001b");
                            }
                            else
                            {
                                SetItem(this.getAdapterPosition(), "q6001b", "r6001b");
                            }

                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6200"))) {
                            HCApplication.show_6260 = 0;
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    crd4.setChecked(true);
                    crd1.setChecked(false);
                    crd3.setChecked(false);
                    crd2.setChecked(false);
                    crd5.setChecked(false);
                    crd6.setChecked(false);
                    crd7.setChecked(false);
                    crd8.setChecked(false);
                    crd9.setChecked(false);

                    break;
                case R.id.txt_rd7_5:
                    HCApplication.move_ment.set(this.getAdapterPosition(),"a");
                    try {
                        HCApplication.all_item.put(question_name.get(this.getAdapterPosition()).replace("q", "Q"), 4);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    HCApplication.check.set(this.getAdapterPosition(), "5");
                    question = result.get(getAdapterPosition());
                    try {
                        if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q4013"))) {
                            editText_string.setVisibility(View.VISIBLE);
                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6103"))) {
                            editText.setVisibility(View.VISIBLE);
                            editText.setText(checked_item.get(getAdapterPosition()));

                        } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6204"))) {
                            editText.setVisibility(View.VISIBLE);
                            editText.setText(checked_item.get(getAdapterPosition()));


                        }

                    } catch (Exception e) {
                        Log.d("error", e.getMessage());
                    }

                    crd5.setChecked(true);
                    crd1.setChecked(false);
                    crd3.setChecked(false);
                    crd4.setChecked(false);
                    crd2.setChecked(false);
                    crd6.setChecked(false);
                    crd7.setChecked(false);
                    crd8.setChecked(false);
                    crd9.setChecked(false);
                    break;
                case R.id.txt_rd7_6:
                    HCApplication.move_ment.set(this.getAdapterPosition(),"a");
                    HCApplication.check.set(this.getAdapterPosition(), "6");
                    try {
                        HCApplication.all_item.put(question_name.get(this.getAdapterPosition()).replace("q", "Q"), 5);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    crd6.setChecked(true);
                    crd1.setChecked(false);
                    crd3.setChecked(false);
                    crd4.setChecked(false);
                    crd5.setChecked(false);
                    crd2.setChecked(false);
                    crd7.setChecked(false);
                    crd8.setChecked(false);
                    crd9.setChecked(false);

                    break;
                case R.id.txt_rd7_7:
                    HCApplication.move_ment.set(this.getAdapterPosition(),"a");
                    HCApplication.check.set(this.getAdapterPosition(), "7");
                    try {
                        HCApplication.all_item.put(question_name.get(this.getAdapterPosition()).replace("q", "Q"), 6);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    crd7.setChecked(true);
                    crd1.setChecked(false);
                    crd3.setChecked(false);
                    crd4.setChecked(false);
                    crd5.setChecked(false);
                    crd6.setChecked(false);
                    crd2.setChecked(false);
                    crd8.setChecked(false);
                    crd9.setChecked(false);

                    break;
                case R.id.txt_rd7_8:
                    HCApplication.check.set(this.getAdapterPosition(), "8");
                    HCApplication.move_ment.set(this.getAdapterPosition(),"a");
                    try {
                        HCApplication.all_item.put(question_name.get(this.getAdapterPosition()).replace("q", "Q"), 7);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    crd8.setChecked(true);
                    crd1.setChecked(false);
                    crd3.setChecked(false);
                    crd4.setChecked(false);
                    crd5.setChecked(false);
                    crd6.setChecked(false);
                    crd2.setChecked(false);
                    crd7.setChecked(false);
                    crd9.setChecked(false);

                    break;
                case R.id.txt_rd7_9:
                    HCApplication.check.set(this.getAdapterPosition(), "9");
                    HCApplication.move_ment.set(this.getAdapterPosition(),"a");
                    try {
                        HCApplication.all_item.put(question_name.get(this.getAdapterPosition()).replace("q", "Q"), 8);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    crd9.setChecked(true);
                    crd1.setChecked(false);
                    crd3.setChecked(false);
                    crd4.setChecked(false);
                    crd5.setChecked(false);
                    crd6.setChecked(false);
                    crd2.setChecked(false);
                    crd7.setChecked(false);
                    crd8.setChecked(false);

                    break;
            }
        }
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


    //  use this method to  add question  which  appear and disappear in  section  like section  5000
    private void addChildQuestion(String question_name, String question_response) throws Exception {


        if (childVales(question_name, question_response)) {
            ChildAdapter myRecyclerViewAdapter = new ChildAdapter(question_name_from_json, answer, question_value_from_json, 1);
            mRecyclerView.setAdapter(myRecyclerViewAdapter);
            notifyDataSetChanged();
        }


    }

    // get value of question  for appear and disappear  section
    private boolean childVales(String question_values, String question_answer) throws Exception {

        mRecyclerView.setVisibility(View.VISIBLE);
        frameLayout.setVisibility(View.VISIBLE);
        // add items to  array  fron  json
        question_name_from_json.clear();
        question_value_from_json.clear();
        answer.clear();
        question_value_from_json = HCApplication.readQuestionFromJsonFile.getArrayListJson(question_values);
        question_name_from_json = HCApplication.readQuestionFromJsonFile.getArrayListJson(question_answer);
        for (int i = 0; i < question_value_from_json.size(); i++) {
            answer.add(HCApplication.readQuestionFromJsonFile.getArrayFromJson("yesorno").toString());
        }

        return true;
    }


    private void disappearEditText() {
        disappearRecycler();
        frameLayout.setVisibility(View.GONE);
        editText.setVisibility(View.GONE);
    }

    private void disappearRecycler() {
        mRecyclerView.setVisibility(View.GONE);
        frameLayout.setVisibility(View.GONE);

    }

    private void checkValueToAppearRecyler(int pos) {
        disappearEditText();
        try {
            check_color = 1;
            if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q4010"))) {
                holder.spinner.setVisibility(View.GONE);
                holder.hideradio.setVisibility(View.GONE);
                holder.editText.setVisibility(View.VISIBLE);

                //  showEditText();
            }
//            else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6102"))) {
//                if (HCApplication.show_q6104 == 1) {
//                    HCApplication.show_q6104 = 02;
//                    HCApplication.span_6102back = 1;
//                    AddItem(pos, "q6103", "r6103");
//                    HCApplication.span_q6104 = 0;
//                    HCApplication.span_6001a = 12;
//
//                }
//            }
            else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6000"))) {
                HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "open_screen", 5);
                HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "Value_Name", 6);
                HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "Value_Back", 4);
                HCApplication.show_q6200 = 1;
                HCApplication.span_q6200 = 1;
                HCApplication.myIntent.move_activity_to_anhter(HCApplication.context, new QuestionsShow());

            } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6300"))) {
                HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "Value_Name", 9);
                HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "Value_Back", 7);
                HCApplication.saveDataInSharedPrefrances.save_data_int("Move_Shared", "open_screen", 8);
                HCApplication.myIntent.move_activity_to_anhter(HCApplication.context, new QuestionsShow());

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void checkValueToDisappearRecyler(int pos, String question) {
        try {

            HCApplication.check_select_child.clear();
            HCApplication.check_select_child.add("aas");
            HCApplication.check_select_child.add("aas");
            HCApplication.check_select_child.add("aas");

            if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5005"))) {
                disappearRecycler();

            } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5006"))) {
                disappearRecycler();

            } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5007"))) {
                disappearRecycler();

            } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5008"))) {
                mRecyclerView.setVisibility(View.GONE);
                frameLayout.setVisibility(View.GONE);

            } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5009"))) {
                disappearRecycler();

            } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5010"))) {
                disappearRecycler();

            } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5011"))) {
                disappearRecycler();

            } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5012"))) {
                disappearRecycler();

            } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5013"))) {
                disappearRecycler();

            } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5014"))) {
                disappearRecycler();

            } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5015"))) {
                disappearRecycler();

            } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6130"))) {
                if (HCApplication.show_q6130 == 0) {
                    HCApplication.show_q6130 = 1;
                    delete(pos);

                }
            } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("Q6203"))) {
                if (HCApplication.show_q6205 == 0) {
                    HCApplication.show_q6205 = 1;
                    HCApplication.span_q6200 = 2;
                    delete(pos);

                }
            } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6102"))) {
                if (HCApplication.show_q6104 == 0) {
                    HCApplication.show_q6104 = 1;
                    delete(pos);
                    HCApplication.span_q6104 = 1;
                }

            } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6230"))) {
                question = question_name.get(pos + 1);
                if (question.equals("q6231")) {
                    notifyItemRemoved(pos + 1);
                    notifyItemRangeChanged(pos, result.size());
                    result.remove(pos + 1);
                    arrayLists.remove(pos + 1);
                    question_name.remove(pos + 1);
                    HCApplication.check.remove(postion + 1);
                    HCApplication.move_ment.remove(postion + 1);
                    notifyDataSetChanged();
                    HCApplication.check_section6230 = 1;
                }

            } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q4010"))) {
                disappearEditText();

            }
//
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void AddItem(int pos, String question, String response) {
        try {
            result.add(pos + 1, HCApplication.readQuestionFromJsonFile.getStringFromJson(question));
            arrayLists.add(pos + 1, HCApplication.readQuestionFromJsonFile.getArrayFromJson(response).toString());
            question_name.add(pos + 1, question);
            HCApplication.check.add(pos + 1, "");
            HCApplication.move_ment.add(postion + 1,"e");
            notifyItemInserted(pos + 1);
            notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void SetItem(int pos, String question, String response) {
        try {
            result.set(pos + 1, HCApplication.readQuestionFromJsonFile.getStringFromJson(question));
            arrayLists.set(pos + 1, HCApplication.readQuestionFromJsonFile.getArrayFromJson(response).toString());
            question_name.set(pos + 1, question);
            HCApplication.check.set(postion + 1, "");
            HCApplication.move_ment.set(postion + 1,"e");
            notifyItemInserted(pos + 1);
            notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void AddItemAll(int pos, ArrayList question, ArrayList response) {
        try {
            Log.d("tesatb",checked_item.toString()+"");

            for (int i = 2; i < question.size(); i--) {
                result.add(pos + 1, HCApplication.readQuestionFromJsonFile.getStringFromJson(question.get(i).toString()));
                arrayLists.add(pos + 1, HCApplication.readQuestionFromJsonFile.getArrayFromJson(response.get(i).toString()).toString());
                question_name.add(pos + 1, question.get(i).toString());
                HCApplication.check.add(pos + 1, "");
                HCApplication.move_ment.add(pos + 1, "e");
                notifyItemInserted(pos + 1);
                notifyDataSetChanged();
                holder.editText_string.setVisibility(View.GONE);

                Log.d("tesatf",checked_item.toString()+"");

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void delete(int postion) {
        result.remove(postion + 1);
        arrayLists.remove(postion + 1);
        question_name.remove(postion + 1);
        HCApplication.move_ment.remove(postion + 1);
        HCApplication.check.remove(postion + 1);
        notifyItemRemoved(postion + 1);
        notifyDataSetChanged();
        editText.setVisibility(View.VISIBLE);
        editText.setText(checked_item.get(postion + 1));


    }

    public void deleteAll(int postion) {

        Log.d("tesatb",checked_item.toString()+"");
        result.remove(postion + 1);
        arrayLists.remove(postion + 1);
        question_name.remove(postion + 1);
        HCApplication.move_ment.remove(postion + 1);
       // checked_item.remove(postion + 1);
        HCApplication.check.remove(postion + 1);

        result.remove(postion + 1);
        arrayLists.remove(postion + 1);
        question_name.remove(postion + 1);
        HCApplication.move_ment.remove(postion + 1);
       // checked_item.remove(postion + 1);
        HCApplication.check.remove(postion + 1);

        result.remove(postion + 1);
        arrayLists.remove(postion + 1);
        question_name.remove(postion + 1);
        HCApplication.move_ment.remove(postion + 1);
        //checked_item.remove(postion + 1);
        HCApplication.check.remove(postion + 1);
        Log.d("tesatf",checked_item.toString()+"");



        notifyDataSetChanged();

    }


    private void addQuestionAfterRemove(int a, String q1, String q2, String q3) {
        ArrayList allq = new ArrayList();
        ArrayList allr = new ArrayList();
        allq.add(q1);
        allr.add("yesorno");
        allq.add(q2);
        allr.add("yesorno");
        allq.add(q3);
        allr.add("yesorno");
        AddItemAll(a, allq, allr);
    }

    void addForSecoondAndThirdRadio(int p) {
        try {
            if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5001"))) {

                if (HCApplication.show_5001 == 1) {
                    HCApplication.show_5001 = 0;
                    addQuestionAfterRemove(p, "q5001a", "q5001b", "q5001c");
                }


            } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6200"))) {
                HCApplication.show_6260 = 0;
            } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5002"))) {

                if (HCApplication.show_5002 == 1) {
                    HCApplication.show_5002 = 0;
                    addQuestionAfterRemove(p, "q5002a", "q5002b", "q5002c");
                }


            } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q6000"))) {

                question=question_name.get(p +1);
                if (question.equals("q6002")){

                    AddItem(p, "q6001b", "r6001b");
                }
                else
                {
                    SetItem(p, "q6001b", "r6001b");
                }

            } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5003"))) {

                if (HCApplication.show_5003 == 1) {
                    HCApplication.show_5003 = 0;
                    addQuestionAfterRemove(p, "q5003a", "q5003b", "q5003c");
                }


            } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5004"))) {

                if (HCApplication.show_5004 == 1) {
                    HCApplication.show_5004 = 0;
                    addQuestionAfterRemove(p, "q5004a", "q5004b", "q5004c");

                }


            } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5005"))) {

                if (HCApplication.show_5005 == 1) {
                    HCApplication.show_5005 = 0;
                    addQuestionAfterRemove(p, "q5005a", "q5005b", "q5005c");

                }


            } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5006"))) {

                if (HCApplication.show_5006 == 1) {
                    HCApplication.show_5006 = 0;
                    addQuestionAfterRemove(p, "q5006a", "q5006b", "q5006c");
                }


            } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5007"))) {

                if (HCApplication.show_5007 == 1) {
                    HCApplication.show_5007 = 0;
                    addQuestionAfterRemove(p, "q5007a", "q5007b", "q5007c");

                }


            } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5008"))) {

                if (HCApplication.show_5008 == 1) {
                    HCApplication.show_5008 = 0;
                    addQuestionAfterRemove(p, "q5008a", "q5008b", "q5008c");

                }


            } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5009"))) {

                if (HCApplication.show_5009 == 1) {
                    HCApplication.show_5009 = 0;
                    addQuestionAfterRemove(p, "q5009a", "q5009b", "q5009c");

                }


            } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5010"))) {

                if (HCApplication.show_5010 == 1) {
                    HCApplication.show_5010 = 0;
                    addQuestionAfterRemove(p, "q5010a", "q5010b", "q5010c");
                }


            } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5011"))) {
                if (HCApplication.show_5011 == 1) {
                    HCApplication.show_5011 = 0;
                    addQuestionAfterRemove(p, "q5011a", "q5011b", "q5011c");

                }


            } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5012"))) {

                if (HCApplication.show_5012 == 1) {
                    HCApplication.show_5012 = 0;
                    addQuestionAfterRemove(p, "q5012a", "q5012b", "q5012c");

                }


            } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5013"))) {

                if (HCApplication.show_5013 == 1) {
                    HCApplication.show_5013 = 0;
                    addQuestionAfterRemove(p, "q5013a", "q5013b", "q5013c");
                }


            } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5014"))) {

                if (HCApplication.show_5014 == 1) {
                    HCApplication.show_5014 = 0;
                    addQuestionAfterRemove(p, "q5015a", "q5015b", "q5015c");

                }


            } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5015"))) {

                if (HCApplication.show_5015 == 1) {
                    HCApplication.show_5015 = 0;
                    addQuestionAfterRemove(p, "q5015a", "q5015b", "q5015c");

                }


            } else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5016"))) {
                try {
                    if (HCApplication.show_5016 == 1) {
                        HCApplication.show_5016 = 0;
                        ;
                        addQuestionAfterRemove(p, "q5016a", "q5016b", "q5016c");
                        holder.editText_string.setVisibility(View.GONE);


                    }
                } catch (Exception e) {
                    Log.e("saa", e.getMessage());
                }

            }
//            else if (question.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5017"))) {
//                if (HCApplication.show_5017 == 1) {
//                    HCApplication.show_5017 = 0;
//                    addQuestionAfterRemove(p, "q5017a", "q5017b", "q5017c");
//
//                }
//
//
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}