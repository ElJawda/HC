package com.shc.SHC_SS.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.shc.SHC_SS.R;
import com.shc.SHC_SS.utilies.HCApplication;
import com.shc.SHC_SS.views.CustomRaidoButtonN;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by jawdah on 4/10/2017.
 */

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.CustomViewHolder> {
    //  Context context;
    CustomViewHolder holder;
    JSONArray jsonArray;
    ArrayList<String> arrayLists = new ArrayList<String>();
    ArrayList<String> result = new ArrayList<String>();
    ArrayList<String> question_name = new ArrayList<String>();
    View view;
    static String question;
    static int postion;

    public ChildAdapter(ArrayList<String> prgmNameList, ArrayList<String> arrayLists, ArrayList<String> question_name, int check_color) {
        result = prgmNameList;
        this.arrayLists = arrayLists;
        this.question_name = question_name;
    }

    @Override
    public int getItemViewType(int position) {
        return position;

    }


    @Override
    public ChildAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_grid_layout, null);
        ChildAdapter.CustomViewHolder viewHolder = new ChildAdapter.CustomViewHolder(view);
        postion = i;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ChildAdapter.CustomViewHolder holder, int i) {
        this.holder = holder;

        holder.allItems.setBackgroundResource(R.color.end_color);
        holder.tv.setText(question_name.get(i).replace("q", "س ").replace("Q", "س ") + "  \t" + result.get(i));
        holder.tv.setTextColor(Color.parseColor("#FFFFFF"));
        String as = arrayLists.get(i);
        try {
            holder.select.setVisibility(View.VISIBLE);
            jsonArray = new JSONArray(as);
            int arr_lenght = jsonArray.length();
            show(arr_lenght);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return (null != arrayLists ? arrayLists.size() : 0);
    }


    class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv, text;
        LinearLayout select, title_l;
        CustomRaidoButtonN crd1, crd2;
        View ver_sp, hor_sp;
        FrameLayout allItems;

        public CustomViewHolder(final View view) {
            super(view);
            this.tv = (TextView) view.findViewById(R.id.textView1);
            this.text = (TextView) view.findViewById(R.id.title);
            this.select = (LinearLayout) view.findViewById(R.id.select);
            this.title_l = (LinearLayout) view.findViewById(R.id.title_l);
            this.ver_sp = (LinearLayout) view.findViewById(R.id.vertical_se);
            this.hor_sp = (LinearLayout) view.findViewById(R.id.horizental_sp);
            this.allItems = (FrameLayout) view.findViewById(R.id.all_item);
            this.crd1 = (CustomRaidoButtonN) view.findViewById(R.id.txt_rd7_1);
            this.crd2 = (CustomRaidoButtonN) view.findViewById(R.id.txt_rd7_2);

            this.tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(HCApplication.context, tv.getText() + "", Toast.LENGTH_LONG).show();
                }
            });


            this.crd2.setOnClickListener(this);
            this.crd1.setOnClickListener(this);


        }


        @Override
        public void onClick(View v) {
            switch (v.getId()) {

                case R.id.txt_rd7_1:

                    HCApplication.check.set(this.getAdapterPosition(), "1");
                    crd1.setChecked(true);
                    crd2.setChecked(false);
                    HCApplication.check_select_child.add("a");

                    // use this part to  show child question
                    question = result.get(getAdapterPosition());
                    try {
                        HCApplication.all_item.put(question_name.get(this.getAdapterPosition()).replace("q","Q"),1);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(HCApplication.context, crd1.getText() + " " + this.getAdapterPosition(), Toast.LENGTH_LONG).show();

                    break;
                case R.id.txt_rd7_2:
                    HCApplication.check.set(this.getAdapterPosition(), "2");
                    try {
                        HCApplication.all_item.put(question_name.get(this.getAdapterPosition()).replace("q","Q"),0);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    HCApplication.check_select_child.add("a");
                    crd2.setChecked(true);
                    crd1.setChecked(false);
                    question = result.get(getAdapterPosition());
                    Toast.makeText(HCApplication.context, crd2.getText() + " " + this.getAdapterPosition(), Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }

    // use this method to control  in number of radio button  which  show in  each question
    private void show(int array_length) throws JSONException {
        if (array_length == 2) {
            holder.crd1.setText(jsonArray.get(0).toString());
            holder.crd2.setText(jsonArray.get(1).toString());
        }

    }

}