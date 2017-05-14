package com.shc.SHC_SS.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shc.SHC_SS.R;
import com.shc.SHC_SS.utilies.HCApplication;

/**
 * Created by jawdah on 4/5/2017.
 */

public class BaseFragment extends android.support.v4.app.Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        HCApplication.view = inflater.inflate(R.layout.testgrid, container, false);
        return HCApplication.view;
    }

    @Override
    public void onPause() {
        super.onPause();
        HCApplication.saveDataInSharedPrefrances.save_data_String("Check_Value", "selecteditems", HCApplication.check.toString());
        HCApplication.saveDataInSharedPrefrances.save_data_String("Allitem", "selectjson", HCApplication.all_item.toString());
        HCApplication.saveDataInSharedPrefrances.save_data_String("Allitem", "question", HCApplication.all_selected.toString());

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
