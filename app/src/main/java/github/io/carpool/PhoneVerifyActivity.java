package github.io.carpool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PhoneVerifyActivity extends AppCompatActivity {

    EditText edit_verify_phone_num;
    EditText edit_verify_code;
    Button bt_send_vcode;
    Button bt_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_verify);

        edit_verify_code = findViewById(R.id.edit_verify_code);
        edit_verify_phone_num = findViewById(R.id.edit_verify_phone_num);

        bt_send_vcode = findViewById(R.id.bt_send_vcode);
        bt_next = findViewById(R.id.bt_verify_next);


        send_verification_code();

    }

    void send_verification_code() {
        bt_send_vcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
    }


}
