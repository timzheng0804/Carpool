package github.io.carpool;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Button;

/**
 * Created by leo2swag on 2018-02-19.
 */

public class ProfileActivity extends Activity {
    private RatingBar ratingBar;
    private TextView textview;
    private EditText profile_phone_num;
    private EditText profile_user_name;
    private EditText profile_car_type;
    private EditText profile_car_color;
    private EditText profile_plate_number;
    private Button button_user_name;
    private Button button_car_type;
    private Button button_car_color;
    private Button button_plate_number;
    private Button profile_save_next;
    private ProgressBar profile_save_progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_info);

        init();
    }

    private void init() {
        ratingBar = findViewById(R.id.profile_ratingBar);
        textview = findViewById(R.id.textView1);
        profile_phone_num = findViewById(R.id.profile_phone_num);
        profile_phone_num.setEnabled(false);
        profile_user_name = findViewById(R.id.profile_user_name);
        profile_user_name.setEnabled(false);
        profile_car_type = findViewById(R.id.profile_car_type);
        profile_car_type.setEnabled(false);
        profile_car_color = findViewById(R.id.profile_car_color);
        profile_car_color.setEnabled(false);
        profile_plate_number = findViewById(R.id.profile_plate_number);
        profile_plate_number.setEnabled(false);
        button_user_name = findViewById(R.id.button_user_name);
        button_car_type = findViewById(R.id.button_car_type);
        button_car_color = findViewById(R.id.button_car_color);
        button_plate_number = findViewById(R.id.button_plate_number);
        profile_save_next = findViewById(R.id.profile_save_next);
        profile_save_progress = findViewById(R.id.profile_save_progress);

        otherEvent();
        clickEvent();
    }

    private void otherEvent() {
        buttonActivity();
        updateRateBar();
    }

    private void clickEvent() {

    }

    protected void buttonActivity() {
        button_user_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profile_user_name.setEnabled(true);
            }
        });

        button_car_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profile_car_type.setEnabled(true);
            }
        });

        button_car_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profile_car_color.setEnabled(true);
            }
        });

        button_plate_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profile_plate_number.setEnabled(true);
            }
        });

        profile_save_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profile_save_next.setVisibility(View.GONE);
                profile_save_progress.setVisibility(View.VISIBLE);
                profile_phone_num.setEnabled(false);
                profile_user_name.setEnabled(false);
                profile_car_type.setEnabled(false);
                profile_car_color.setEnabled(false);
                profile_plate_number.setEnabled(false);
            }
        });
    }

    protected void updateRateBar() {
        textview.setText("您当前的用户评分：" + ratingBar.getRating());

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                textview.setText("当前的用户评分: " + rating);
            }
        });
    }
}
