package github.io.carpool;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by leo2swag on 2018-02-07.
 */


public class RegistrationSection extends AppCompatActivity {

    Button section_login;
    RadioButton radioButton1;
    ProgressBar car_regis_progress;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis_section);
        section_login = findViewById(R.id.section_login);
        radioButton1 = findViewById(R.id.radioButton1);
        car_regis_progress = findViewById(R.id.car_regis_progress);

        section_regis_car();

    }


    private void section_regis_car() {
        section_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                if (radioButton1.isChecked()) {
                    intent = new Intent(getApplicationContext(), GetCarInfoActivity.class);
                    startActivity(intent);
                } else {
                    section_login.setVisibility(View.GONE);
                    car_regis_progress.setVisibility(View.VISIBLE);
                    //intent = new Intent(getApplicationContext(), indexActivity.class);
                }

            }
        });
    }

}
