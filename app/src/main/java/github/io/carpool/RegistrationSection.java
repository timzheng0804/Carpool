package github.io.carpool;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by leo2swag on 2018-02-07.
 */


public class RegistrationSection extends AppCompatActivity {

    Button section_login;
    RadioButton radioButton1;
    RadioButton radioButton2;
    ProgressBar car_regis_progress;
    TextView select_result;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis_section);
        init();

    }

    private void init() {
        section_login = findViewById(R.id.section_login);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        car_regis_progress = findViewById(R.id.car_regis_progress);
        select_result = findViewById(R.id.select_result);
        otherEvent();
        clickEvent();
    }

    private void otherEvent() {

    }

    private void clickEvent() {
        click_show_result();
        click_show_result2();
        section_regis_car();
    }

    private void click_show_result() {
        radioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select_result.setText(getResources().getText(R.string.select_1));
                select_result.setTextSize(18);
                select_result.setTextColor(getResources().getColor(R.color.colorFont));
            }
        });
    }

    private void click_show_result2() {
        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select_result.setText(getResources().getText(R.string.select_2));
                select_result.setTextSize(18);
                select_result.setTextColor(getResources().getColor(R.color.colorFont));
            }
        });
    }

    private void section_regis_car() {
        section_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                if (select_result.getText() == "") {
                    select_result.setText("请选择日常使用状态！");
                    select_result.setTextSize(20);
                    select_result.setTextColor(getResources().getColor(R.color.colorredD));
                } else {

                    if (radioButton1.isChecked()) {
                        intent = new Intent(getApplicationContext(), GetCarInfoActivityV2.class);
                        startActivity(intent);
                    } else {
                        section_login.setVisibility(View.GONE);
                        car_regis_progress.setVisibility(View.VISIBLE);
                        //intent = new Intent(getApplicationContext(), indexActivity.class);
                    }
                }

            }
        });
    }

}
