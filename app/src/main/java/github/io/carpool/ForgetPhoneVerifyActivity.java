package github.io.carpool;

import android.content.Context;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import github.io.carpool.timecountActivity;
import android.widget.TextView;

import java.sql.Time;

/**
 * Created by leo2swag on 2018-02-05.
 */

public class ForgetPhoneVerifyActivity extends AppCompatActivity {
    EditText forget_edit_verify_phone_num;
    EditText forget_edit_verify_code;
    Button forget_bt_send_vcode;
    Button forget_bt_verify_next;
    LinearLayout wrapper;
    private timecountActivity time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_pass_verify);

        init();
    }

    public void init() {
        forget_edit_verify_code = findViewById(R.id.forget_edit_verify_code);
        forget_edit_verify_phone_num = findViewById(R.id.forget_edit_verify_phone_num);
        wrapper = findViewById(R.id.wrapper_forget_pass);

        forget_bt_send_vcode = findViewById(R.id.forget_bt_send_vcode);
        forget_bt_verify_next = findViewById(R.id.forget_bt_verify_next);

        OtherEvent();
        clickEvent();
    }

    private void OtherEvent() {
        backgroundOnClick();
        edit_texts_move_up();
    }

    private void clickEvent() {
        forget_send_verification_code();
        forget_next_button_onClick();
    }

    private void edit_texts_move_up() {
       move_up(forget_edit_verify_phone_num);
       move_up(forget_edit_verify_code);
    }

    private void backgroundOnClick() {
        final InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        wrapper.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                wrapper.setFocusable(true);
                wrapper.setFocusableInTouchMode(true);
                wrapper.requestFocus();
                wrapper.setGravity(Gravity.CENTER_VERTICAL);
                im.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                return false;
            }
        });
    }

    private void move_up(EditText et) {
        et.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                    wrapper.setGravity(Gravity.TOP);
                }
            }
        });
    }

    private void forget_next_button_onClick() {
        forget_bt_verify_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextIntent = new Intent(getApplicationContext(), ChangePassActivity.class);
                startActivity(nextIntent);
            }
        });
    }

    void forget_send_verification_code() {
        forget_bt_send_vcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                forget_edit_verify_code.setEnabled(true);
                //int countdown = 60;
                //while (countdown > 0) {
                //    forget_bt_send_vcode.setText("( " + countdown + " s)");
                //    SystemClock.sleep(100);
                //    countdown--;
                //}
            }
        });
    }
}
