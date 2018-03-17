package github.io.carpool;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.view.View.OnFocusChangeListener;

public class TitleActivity extends AppCompatActivity {

    Button bt_register;
    Button bt_forget_pass;
    Button bt_login;
    EditText text_phone;
    EditText text_pass;
    LinearLayout bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        init();
    }

    private void init() {
        bt_register = findViewById(R.id.bt_register);
        bt_forget_pass = findViewById(R.id.bt_forget_pass);
        bt_login = findViewById(R.id.bt_login);
        text_phone = findViewById(R.id.edit_phone_num);
        text_pass = findViewById(R.id.edit_password);
        bg = findViewById(R.id.title_page_bg);
        OtherEvent();
        clickEvent();

    }

    private void clickEvent() {
        backgroundOnClick();
        setRegisterOnClick();
        forgetPassOnClick();
        loginClick();
    }

    private void OtherEvent() {
      //text_phone.setOnFocusChangeListener(onFocusChangeListener);
      //text_pass.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void backgroundOnClick() {
        final InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        bg.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                bg.setFocusable(true);
                bg.setFocusableInTouchMode(true);
                bg.requestFocus();
                im.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                return false;
            }
        });

    }

    private void setRegisterOnClick() {
        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PhoneVerifyActivity.class);
                startActivity(intent);
            }
        });
    }

    private void forgetPassOnClick() {
        bt_forget_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent forget_intent = new Intent(getApplicationContext(), ForgetPhoneVerifyActivity.class);
                startActivity(forget_intent);
            }
        });
    }

    private void loginClick() {
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent forget_intent = new Intent(getApplicationContext(), indexActivity.class);
                startActivity(forget_intent);
            }

        });
    }


    private OnFocusChangeListener onFocusChangeListener = new OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            switch (v.getId()) {
                case R.id.edit_phone_num:
                    setHint(text_phone,hasFocus);
                    break;
                case R.id.edit_password:
                    setHint(text_pass,hasFocus);
                    break;
                default:
                    break;
            }
        }
    };

    private void setHint(EditText et, boolean hasFocus) {
        String hint;
        if(hasFocus) {
            hint = et.getHint().toString();
            et.setTag(hint);
            et.setHint("");
        } else {
            hint = et.getTag().toString();
            et.setHint(hint);
        }
    }

}
