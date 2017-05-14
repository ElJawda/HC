package com.shc.SHC_SS.adapter;
import com.shc.SHC_SS.R;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;

/**
 * Created by A.Elsayed on 4/25/2017.
 */

public abstract class MainAdapter extends RecyclerView.Adapter<MainHolder>  {
    ArrayList<String> arrayLists = new ArrayList<String>();
    ArrayList<String> result = new ArrayList<String>();
    ArrayList<String> question_name = new ArrayList<String>();
    void MainAdapter(ArrayList<String> arrayLists,ArrayList<String> result,ArrayList<String> question_name ){
        this.arrayLists=arrayLists;
        this.result=result;
        this.question_name=question_name;


    }
    @Override
    public  MainHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_grid_layout, null);
        MainHolder viewHolder = new MainHolder(view);
        return viewHolder;
    }

    @Override
    public abstract void onBindViewHolder(MainHolder holder, int position);

    @Override
    public abstract int getItemCount() ;

    @Override
    public int getItemViewType(int position) {
        return position;

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}
