package github.io.carpool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class RegistrationActivity extends AppCompatActivity {

    EditText regis_edit_phone_num;
    EditText new_edit_account_name;
    EditText new_edit_password;
    EditText school_edit_name;
    Button regis_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        regis_edit_phone_num = findViewById(R.id.regis_edit_phone_num);
        regis_edit_phone_num.setEnabled(false);
        new_edit_account_name = findViewById(R.id.new_edit_account_name);
        new_edit_password = findViewById(R.id.new_edit_password);
        school_edit_name = findViewById(R.id.school_edit_name);
        regis_next = findViewById(R.id.regis_next);

        regis_next_press();
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
