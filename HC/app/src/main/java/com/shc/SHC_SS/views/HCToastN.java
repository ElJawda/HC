package com.shc.SHC_SS.views;

import android.content.Context;
import android.widget.Toast;


/**
 * Created by E-Jawdaa on 1/30/2017.
 */

public class HCToastN extends Toast {
    Context mContext;

    public HCToastN(Context mContext) {
        super(mContext);
        this.mContext = mContext;

    }
//
//    public void Show(int toastMSG, int toastDuration) {
//
//        final LayoutInflater inflater = (LayoutInflater) mContext.getSystemService
//                (Context.LAYOUT_INFLATER_SERVICE);
//        View toastView = inflater.inflate(R.home_layout.layout_ewatoast, null);
//        Toast toast = new Toast(mContext);
//        toast.setView(toastView);
//
//        /**(just a fake number) 1 is Long period & 0 is Short Period. **/
//        if (toastDuration == 0) {
//            toast.setDuration(Toast.LENGTH_SHORT);
//        } else {
//            toast.setDuration(Toast.LENGTH_LONG);
//        }
//
//        TextView toastText = (TextView) toastView.findViewById(R.id.textView_toast_text);
//        toastText.setText(mContext.getString(toastMSG));
//
//        toast.show();
//    }
//
//    public void Show(String toastMSG, int toastDuration) {
//
//        final LayoutInflater inflater = (LayoutInflater) mContext.getSystemService
//                (Context.LAYOUT_INFLATER_SERVICE);
//        View toastView = inflater.inflate(R.home_layout.layout_ewatoast, null);
//        Toast toast = new Toast(mContext);
//        toast.setView(toastView);
//
//        /**(just a fake number) 1 is Long period & 0 is Short Period. **/
//        if (toastDuration == 0) {
//            toast.setDuration(Toast.LENGTH_SHORT);
//        } else {
//            toast.setDuration(Toast.LENGTH_LONG);
//        }
//
//        TextView toastText = (TextView) toastView.findViewById(R.id.textView_toast_text);
//        toastText.setText(toastMSG);
//
//        toast.show();
//    }
}
