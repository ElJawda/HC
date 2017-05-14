package com.shc.SHC_SS.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.EditText;


public class HCEditTextN extends EditText {


    public HCEditTextN(Context context) {
        super(context);

//        Typeface typeFace = Typeface.createFromAsset(context.getAssets(),
//                context.getString(R.string.font_name));
//        this.setTypeface(typeFace);
    }

    public HCEditTextN(Context context, AttributeSet attrs) {
        super(context, attrs);
//        Typeface typeFace = Typeface.createFromAsset(context.getAssets(),
//                context.getString(R.string.font_name));
//        this.setTypeface(typeFace);
    }

    public HCEditTextN(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        Typeface typeFace = Typeface.createFromAsset(context.getAssets(),
//                context.getString(R.string.font_name));
//        this.setTypeface(typeFace);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
