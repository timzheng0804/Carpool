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
import android.widget.ProgressBar;

public class RegistrationActivity extends AppCompatActivity {

    EditText regis_edit_phone_num;
    EditText new_edit_account_name;
    EditText new_edit_password;
    EditText school_edit_name;
    LinearLayout bg;
    Button regis_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        init();
    }

    private void init() {
        regis_edit_phone_num = findViewById(R.id.regis_edit_phone_num);
        regis_edit_phone_num.setEnabled(false);
        new_edit_account_name = findViewById(R.id.new_edit_account_name);
        new_edit_password = findViewById(R.id.new_edit_password);
        school_edit_name = findViewById(R.id.school_edit_name);
        regis_next = findViewById(R.id.regis_next);
        bg = findViewById(R.id.wrapper_bg_regis);

        otherEvent();
        clickEvent();

    }

    private void otherEvent() {

    }

    private void clickEvent() {
        regis_next_press();
        backgroundOnClick();
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

    private void regis_next_press() {
        regis_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegistrationSection.class);
                startActivity(intent);
                //regis_next.setVisibility(View.GONE);
                //in_progress.setVisibility(View.VISIBLE);
                //new_edit_account_name.setEnabled(false);
                //new_edit_password.setEnabled(false);
                //school_edit_name.setEnabled(false);

            }
        });
    }
}
