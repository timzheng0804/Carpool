package github.io.carpool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by leo2swag on 2018-02-05.
 */

public class ChangePassActivity extends AppCompatActivity {
    EditText new_edit_phone_num;
    EditText confirm_edit_phone_num;
    Button change_pass_next;
    ProgressBar change_pass_progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password);

        new_edit_phone_num = findViewById(R.id.new_edit_phone_num);
        confirm_edit_phone_num = findViewById(R.id.confirm_edit_phone_num);

        change_pass_next = findViewById(R.id.change_pass_next);
        change_pass_progress = findViewById(R.id.change_pass_progress);

        next_button_onClick();
    }

    private void next_button_onClick() {
        change_pass_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change_pass_next.setVisibility(View.GONE);
                change_pass_progress.setVisibility(View.VISIBLE);

                new_edit_phone_num.setEnabled(false);
                confirm_edit_phone_num.setEnabled(false);
            }
        });
    }


}
