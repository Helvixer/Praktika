package com.example.medic;

import android.os.CountDownTimer;

public class CodeTimer extends CountDownTimer {


    public CodeTimer(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
    }

    @Override
    public void onFinish() {
        // Do something...
    }

    public void onTick(long millisUntilFinished) {

    }

}
