package com.shc.SHC_SS.fragment;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;

import com.shc.SHC_SS.R;
import com.shc.SHC_SS.views.HCBoldTextViewN;

/**
 * Created by Mohamed Hassan on 4/27/2017.
 */

public class ConfirmationDialog extends DialogFragment {

    HCBoldTextViewN text ;


    private static final String KEY_SHOULD_REMOVE_FAMILY = "SHOULD_REMOVE_FAMILY";
    private static final String KEY_TITLE = "TITLE";

    private ConfirmationDialogCallback mConfirmationDialogCallback;
    private boolean mShouldRemoveFamily = false;
     static String mTitle = "";

    public void setConfirmationDialogCallback(ConfirmationDialogCallback mConfirmationDialogCallback) {
        this.mConfirmationDialogCallback = mConfirmationDialogCallback;
    }

    public interface ConfirmationDialogCallback {
        void ok(boolean shouldRemoveFamily);
    }

    public static ConfirmationDialog newInstance(boolean shouldRemoveFamily) {
        Bundle args = new Bundle();
        args.putBoolean(KEY_SHOULD_REMOVE_FAMILY, shouldRemoveFamily);
        ConfirmationDialog fragment = new ConfirmationDialog();
        fragment.setArguments(args);
        return fragment;
    }

    public static ConfirmationDialog newInstance(String title) {
        Bundle args = new Bundle();
        mTitle=title;
        args.putString(KEY_TITLE, title);
        ConfirmationDialog fragment = new ConfirmationDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mShouldRemoveFamily = getArguments().getBoolean(KEY_SHOULD_REMOVE_FAMILY);
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_fragment_confirmation);

        Button ok = (Button) dialog.findViewById(R.id.btn_ok);
        text=(HCBoldTextViewN)dialog.findViewById(R.id.tv_confirmation_dialog_title);
        if (mTitle.length()>0) {
            text.setText(mTitle);
        }
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mConfirmationDialogCallback != null)
                    mConfirmationDialogCallback.ok(mShouldRemoveFamily);
            }
        });

        Button cancel = (Button) dialog.findViewById(R.id.btn_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return dialog;
    }

}
