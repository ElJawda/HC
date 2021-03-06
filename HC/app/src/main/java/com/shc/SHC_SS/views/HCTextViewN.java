package com.shc.SHC_SS.views;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.shc.SHC_SS.R;


public class HCTextViewN extends TextView {


    public HCTextViewN(Context context) {
        super(context);

//        Typeface typeFace = Typeface.createFromAsset(context.getAssets(),
//                context.getString(R.string.font_name));
//        // if (isTablet(context)) {
//        this.setTypeface(typeFace);
        //this.setTextSize(TypedValue.COMPLEX_UNIT_SP,20); // Test it
//        } else
//            this.setTypeface(typeFace, android.R.style.TextAppearance_Medium);
    }

    public HCTextViewN(Context context, AttributeSet attrs) {
        super(context, attrs);
//        Typeface typeFace = Typeface.createFromAsset(context.getAssets(),
//                context.getString(R.string.font_name));
////        if (isTablet(context)) {
//        this.setTypeface(typeFace);
        //this.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20); // Test it
//        } else
//            this.setTypeface(typeFace, android.R.style.TextAppearance_Medium);
    }

    public HCTextViewN(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Typeface typeFace = Typeface.createFromAsset(context.getAssets(),
                context.getString(R.string.font_name));
        //if (isTablet(context)) {
        this.setTypeface(typeFace);
        //this.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20); // Test it
        //} else
        //  this.setTypeface(typeFace, android.R.style.TextAppearance_Medium);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    private boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.
                SCREENLAYOUT_SIZE_LARGE;
    }
}


