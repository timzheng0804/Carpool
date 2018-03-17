package github.io.carpool;

import android.content.Context;
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
import android.widget.TextView;

public class PhoneVerifyActivity extends AppCompatActivity {

    EditText edit_verify_phone_num;
    EditText edit_verify_code;
    Button bt_send_vcode;
    Button bt_next;
    LinearLayout bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_verify);

        init();

    }

    private void init() {
        edit_verify_code = findViewById(R.id.edit_verify_code);
        edit_verify_phone_num = findViewById(R.id.edit_verify_phone_num);

        bt_send_vcode = findViewById(R.id.bt_send_vcode);
        bt_next = findViewById(R.id.bt_verify_next);
        bg = findViewById(R.id.wrapper_verify_pass);

        otherEvent();
        clickRvent();
    }

    private void otherEvent() {
        edit_texts_move_up();
    }

    private void clickRvent() {
        backgroundOnClick();
        send_verification_code();
        next_button_onClick();
    }

    private void edit_texts_move_up() {
        move_up(edit_verify_phone_num);
        move_up(edit_verify_code);
    }

    private void move_up(EditText et) {
        et.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                    bg.setGravity(Gravity.TOP);
                }
            }
        });
    }

    public void backgroundOnClick() {
        final InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        bg.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                bg.setFocusable(true);
                bg.setFocusableInTouchMode(true);
                bg.requestFocus();
                bg.setGravity(Gravity.CENTER);
                im.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                return false;
            }
        });
    }

    private void next_button_onClick() {
        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }

    void send_verification_code() {
        bt_send_vcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit_verify_code.setEnabled(true);
            }
        });
    }
}