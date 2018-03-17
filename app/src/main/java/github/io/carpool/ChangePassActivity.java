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
import android.widget.ProgressBar;
import android.widget.TextView;
import github.io.carpool.TitleActivity.*;

/**
 * Created by leo2swag on 2018-02-05.
 */

public class ChangePassActivity extends AppCompatActivity {
    EditText new_edit_phone_num;
    EditText confirm_edit_phone_num;
    Button change_pass_next;
    ProgressBar change_pass_progress;
    LinearLayout bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password);

        init();
    }

    private void init() {
        new_edit_phone_num = findViewById(R.id.new_edit_phone_num);
        confirm_edit_phone_num = findViewById(R.id.confirm_edit_phone_num);

        change_pass_next = findViewById(R.id.change_pass_next);
        change_pass_progress = findViewById(R.id.change_pass_progress);
        bg = findViewById(R.id.wrapper_change_pass);
        OtherEvent();
        clickEvent();
    }

    private void OtherEvent() {
        backgroundOnClick();
        edit_texts_move_up();
    }

    private void clickEvent() {
        next_button_onClick();
    }

    public void backgroundOnClick() {
        final InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        bg.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                bg.setFocusable(true);
                bg.setFocusableInTouchMode(true);
                bg.requestFocus();
                bg.setGravity(Gravity.CENTER_VERTICAL);
                im.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                return false;
            }
        });

    }

    private void edit_texts_move_up() {
        move_up(new_edit_phone_num);
        move_up(confirm_edit_phone_num);
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

    private void next_button_onClick() {
        change_pass_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change_pass_next.setVisibility(View.GONE);
                change_pass_progress.setVisibility(View.VISIBLE);

                new_edit_phone_num.setEnabled(false);
                confirm_edit_phone_num.setEnabled(false);
                bg.setGravity(Gravity.CENTER_VERTICAL);
            }
        });
    }


}
