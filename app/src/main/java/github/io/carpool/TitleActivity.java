package github.io.carpool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TitleActivity extends AppCompatActivity {

    Button bt_register;
    Button bt_forget_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        bt_register = findViewById(R.id.bt_register);
        bt_forget_pass = findViewById(R.id.bt_forget_pass);

        setRegisterOnClick();
        forgetPassOnClick();
    }

    private void setRegisterOnClick() {
        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegistrationActivity.class);
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
}
