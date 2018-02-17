package github.io.carpool;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;
import github.io.carpool.GetCarInfoActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

public class GetCarInfoActivity extends Activity implements OnItemSelectedListener {

    Spinner spinner1, spinner2;
    EditText other_car_info;
    Button finalBtnSubmit;
    ProgressBar car_regis_progress;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_car_info);
        finalBtnSubmit = findViewById(R.id.car_regis_next_final);
        other_car_info = findViewById(R.id.other_car_info);
        car_regis_progress = findViewById(R.id.car_regis_progress);

        addListenerOnSpinnerItemSelection();
        submitFinal();
    }


    public void addListenerOnSpinnerItemSelection() {
        spinner1 = findViewById(R.id.car_type_spinner);
        spinner1.setOnItemSelectedListener(this);
        spinner2 = findViewById(R.id.car_color_spinner);
        spinner2.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    public void submitFinal() {
        finalBtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finalBtnSubmit.setVisibility(View.GONE);
                car_regis_progress.setVisibility(View.VISIBLE);
                //Intent intent = new Intent(getApplicationContext(), indexActivity.class);
                //startActivity(intent);
            }
        });
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {

        if (pos == 7) {
            other_car_info.setVisibility(View.VISIBLE);
        } else {
            other_car_info.setVisibility(View.GONE);
        }

        Toast.makeText(parent.getContext(),
                "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}

