package com.shc.SHC_SS.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.DialogFragment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.shc.SHC_SS.R;

/**
 * Created by A.Elsayed on 5/7/2017.
 */

public class NoGpsDialog extends DialogFragment {

    private static final String KEY_TITLE = "TITLE";
    private RetryCallback mRetryCallback;
    private String mTitle = "";

    public void setRetryCallback(RetryCallback mRetryCallback) {
        this.mRetryCallback = mRetryCallback;
    }

    public static NoGpsDialog newInstance(String title) {
        Bundle args = new Bundle();
        args.putString(KEY_TITLE, title);
        NoGpsDialog fragment = new NoGpsDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) mTitle = getArguments().getString(KEY_TITLE);
    }

    public interface RetryCallback {
        void onRetry();

        void onCancel();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new Dialog(getActivity());
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_no_gps);
        TextView textView = (TextView) dialog.findViewById(R.id.tv_gps_dialog_title);
        if (mTitle!=null&&mTitle.length() > 0) textView.setText(mTitle);
        Button retry = (Button) dialog.findViewById(R.id.btn_retry);
        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mRetryCallback != null)
                    mRetryCallback.onRetry();
            }
        });

        Button cancel = (Button) dialog.findViewById(R.id.btn_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (mRetryCallback != null)
                    mRetryCallback.onCancel();
            }
        });
        return dialog;
    }


}
