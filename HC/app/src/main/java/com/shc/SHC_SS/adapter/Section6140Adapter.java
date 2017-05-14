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
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by A.Elsayed on 5/2/2017.
 */

public class Section6140Adapter extends RecyclerView.Adapter<Section6140Adapter.CustomViewHolder> {
    Context context;
    Section6140Adapter.CustomViewHolder holder;
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


    public Section6140Adapter(Context con, ArrayList<String> prgmNameList, ArrayList<String> arrayLists, ArrayList<String> question_name, int check_color, ArrayList checked_item) {
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
    public Section6140Adapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_grid_layout, null);
        Section6140Adapter.CustomViewHolder viewHolder = new Section6140Adapter.CustomViewHolder(view);
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

//                else if (check.equals(HCApplication.readQuestionFromJsonFile.getStringFromJson("q5017"))) {
//                    holder.spinner.setVisibility(View.GONE);
//                    holder.hideradio.setVisibility(View.VISIBLE);
//                    holder.editText_string.setVisibility(View.VISIBLE);
//                    int arr_lenght = jsonArray.length();
//                    show(arr_lenght);
//
//                }
                if (check.equals("أخرى حدد ")) {
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
    public void onBindViewHolder(Section6140Adapter.CustomViewHolder holder, int i) {
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
                    HCApplication.saveDataInSharedPrefrances.save_data_String("edittext", "q4005", editText_string.getText().toString());

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

                        } else {
                            editText.setVisibility(View.GONE);
                            HCApplication.all_item.put(question_name.get(this.getAdapterPosition()).replace("q", "Q"), 0);

                        }

                        // transportation

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


}


