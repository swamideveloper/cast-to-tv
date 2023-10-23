package kapil.cast.video.screenmirroring.smarttv.kapil_developer_dlg;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

import kapil.cast.video.screenmirroring.smarttv.kapil_developer_if.kapil_developer_if_pass;
import kapil.cast.video.screenmirroring.smarttv.R;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_ut.kapil_developer_ut_num;

public class kapil_developer_pass_code extends Dialog {
    TextView cancle, done;
    Activity activity;
    EditText password;
    kapil_developer_if_pass kapildeveloperifpass;
    public kapil_developer_pass_code(@NonNull Activity context, kapil_developer_if_pass kapildeveloperifpass1) {
        super(context);
        activity = context;
        kapildeveloperifpass = kapildeveloperifpass1;
    }
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.cast_tv_screen_pss);
//        getWindow().setBackgroundDrawable(new ColorDrawable(0));
//        getWindow().getAttributes().windowAnimations = R.style.DialogeThemeAnimation;
//        getWindow().setLayout(-1, -2);
//        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
//        layoutParams.copyFrom(getWindow().getAttributes());
//        getWindow().setAttributes(layoutParams);
        cancle = findViewById(R.id.cancle);
        done = findViewById(R.id.done);
        password = findViewById(R.id.password);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kapildeveloperifpass.onCompelete(password.getText().toString().trim());
                dismiss();
            }
        });
        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                kapildeveloperifpass.onCancel();
            }
        });
        password.setInputType(18);
        password.setTransformationMethod(new kapil_developer_ut_num());
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (password.getText().toString().isEmpty()) {
                    done.setTextColor(activity.getResources().getColor(R.color.dark_half));
                } else {
                    done.setTextColor(activity.getResources().getColor(R.color.theme));
                }

            }
        });
        KeyBoardOn(password);
    }


    public static void KeyBoardOn(EditText editText) {
        editText.post(new Runnable() {
            @Override
            public void run() {
                editText.requestFocus();
                ((InputMethodManager)editText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(editText,1);
            }
        });
    }

}
