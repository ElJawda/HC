package com.shc.SHC_SS.utilies;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by jawdah on 3/26/2017.
 */

public class SaveDataInSharedPrefrances {


    public  void save_data_int(String shard_name,String item_name,int item_value  ){
        SharedPreferences.Editor editor = HCApplication.newInstance().context.getSharedPreferences(shard_name,Context.MODE_PRIVATE).edit();
        editor.putInt(item_name, item_value);
        editor.apply();

    }

    public  void save_data_String(String shard_name,String item_name,String item_value  ){
        SharedPreferences.Editor editor = HCApplication.newInstance().context.getSharedPreferences(shard_name,Context.MODE_PRIVATE).edit();
        editor.putString(item_name, item_value);
        editor.apply();

    }
    public int   getFRomShard(String shard_name,String item_name){
        SharedPreferences prefs = HCApplication.newInstance().context.getSharedPreferences(shard_name,Context.MODE_PRIVATE);
        int  restoredText = prefs.getInt(item_name, 0);
        return  restoredText;
    }

    public String getStringFRomShard(String shard_name,String item_name){
        SharedPreferences prefs = HCApplication.newInstance().context.getSharedPreferences(shard_name,Context.MODE_PRIVATE);
        String restoredText = prefs.getString(item_name, "");
        return  restoredText;
    }

    public void delete(String shard_name){
        SharedPreferences.Editor editor = HCApplication.newInstance().context.getSharedPreferences(shard_name,Context.MODE_PRIVATE).edit();
        editor.clear();
        editor.commit();
//        SharedPreferences settings = HCApplication.context.getSharedPreferences(shard_name, Context.MODE_PRIVATE);
//        settings.edit().clear().commit();
    }
}
