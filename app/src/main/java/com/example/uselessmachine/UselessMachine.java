package com.example.uselessmachine;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class UselessMachine extends AppCompatActivity {
    private Button buttonSelfDestruct;
    private Switch switchUseless;

    public static final String TAG = UselessMachine.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_useless_machine);

        wireWidgets();
        setListeners();
    }



    private void setListeners() {
        // TODO self destruct button

        switchUseless.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(UselessMachine.this, "", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(UselessMachine.this, "Off", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void startSwitchOffTimer() {
        CountDownTimer countDownTimer = new CountDownTimer(5000, 5000) {
            public void onTick(long l) {
                if (!switchUseless.isChecked()) {
                    Log.d(TAG, "OnTick: canceling");
                }
            }

            @Override
            public void onFinish() {
                switchUseless.setChecked(false);
                Log.d(TAG, "onFinish: switch set to false");
                cancel();
            }

        }.start();


    }

    private void wireWidgets() {
        buttonSelfDestruct = findViewById(R.id.button_main_selfDestrct);
        switchUseless = findViewById(R.id.switch_main_useless);
    }
}