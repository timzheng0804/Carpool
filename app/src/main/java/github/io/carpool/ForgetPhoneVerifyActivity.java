package github.io.carpool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by leo2swag on 2018-02-05.
 */

public class ForgetPhoneVerifyActivity extends AppCompatActivity {
    EditText forget_edit_verify_phone_num;
    EditText forget_edit_verify_code;
    Button forget_bt_send_vcode;
    Button forget_bt_verify_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_pass_verify);

        forget_edit_verify_code = findViewById(R.id.forget_edit_verify_code);
        forget_edit_verify_phone_num = findViewById(R.id.forget_edit_verify_phone_num);

        forget_bt_send_vcode = findViewById(R.id.forget_bt_send_vcode);
        forget_bt_verify_next = findViewById(R.id.forget_bt_verify_next);

        forget_send_verification_code();
        forget_next_button_onClick();
    }

    private void forget_next_button_onClick() {
        forget_bt_verify_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextIntent = new Intent(getApplicationContext(), ChangePassActivity.class);
                startActivity(nextIntent);
            }
        });
    }

    void forget_send_verification_code() {
        forget_bt_send_vcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
