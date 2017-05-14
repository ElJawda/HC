package com.shc.SHC_SS.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;


public class HCButtonN extends Button {


    public HCButtonN(Context context) {
        super(context);

//        Typeface typeFace = Typeface.createFromAsset(context.getAssets(),
//                context.getString(R.string.font_name));
//        this.setTypeface(typeFace);
        this.setTextScaleX(2);
    }

    public HCButtonN(Context context, AttributeSet attrs) {
        super(context, attrs);
//        Typeface typeFace = Typeface.createFromAsset(context.getAssets(),
//                context.getString(R.string.font_name));
//        this.setTypeface(typeFace);
        this.setTextScaleX(2);
    }

    public HCButtonN(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        Typeface typeFace = Typeface.createFromAsset(context.getAssets(),
//                context.getString(R.string.font_name));
//        this.setTypeface(typeFace);
        this.setTextScaleX(2);
    }
}


