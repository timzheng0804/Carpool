package github.io.carpool;

import android.os.CountDownTimer;
import android.widget.Button;

import github.io.carpool.ForgetPhoneVerifyActivity;
/**
 * Created by leo2swag on 2018-02-26.
 */

class timecountActivity extends CountDownTimer {


    public timecountActivity(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
    }

    @Override
    public void onTick(long millisUntilFinished) {
        //btnGetcode.setBackgroundColor(Color.parseColor("#B6B6D8"));
        //btnGetcode.setClickable(false);
        //btnGetcode.setText("("+millisUntilFinished / 1000 +") 秒后可重新发送");
    }

    @Override
    public void onFinish() {

        //btnGetcode.setText("重新获取验证码");
        //btnGetcode.setClickable(true);
        //btnGetcode.setBackgroundColor(Color.parseColor("#4EB84A"));

    }

    public void passButton(Button button) {

    }
}