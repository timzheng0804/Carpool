package github.io.carpool;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by leo2swag on 2018-02-06.
 */

public class indexActivity extends AppCompatActivity {
    Button buttonIndex;
    TextView index_rate_word;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);
        init();

    }


    private void init() {
        //buttonIndex = findViewById(R.id.buttonIndex);
        index_rate_word = findViewById(R.id.index_rate_word);
        otherEvent();
        clickEvent();
    }

    private void otherEvent() {
        index_rate_word.setText(getResources().getText(R.string.rateword) + " " + getResources().getText(R.string.profile_rate));
    }

    private void clickEvent() {
        //gotoProfile();
    }
    //public void addListenerOnButton() {

 //       spinner1 = findViewById(R.id.car_type_spinner);
  //      spinner2 = findViewById(R.id.car_color_spinner);

    //    String selectedValue = String.valueOf(spinner1.getSelectedItem());

//        other_car_info = findViewById(R.id.other_car_info);
  //      if (selectedValue == "OTHERS") {
    //        finalBtnSubmit.setText("hhhhhh");
      //      other_car_info.setVisibility(View.VISIBLE);
      //  } else {
      //      finalBtnSubmit.setText("aaaaaa");
      //      other_car_info.setVisibility(View.GONE);
       // }


    //}

    public void gotoProfile() {
        buttonIndex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}



