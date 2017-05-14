package com.shc.SHC_SS.utilies;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by A.Elsayed on 4/12/2017.
 */

public class MyIntent {
    public  void move_activity_to_anhter(Context context, Activity activity){
        Intent intent=new Intent(context,activity.getClass());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
