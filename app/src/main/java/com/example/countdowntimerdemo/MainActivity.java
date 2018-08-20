package com.example.countdowntimerdemo;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        CountDownTimer countDownTimer = new CountDownTimer(1000 * 10,1000) {
            @Override
            public void onTick(long l) {
                button.setText(l / 1000 + "秒");
                button.setClickable(false);
            }

            @Override
            public void onFinish() {
                button.setText("点击跳转");
                button.setClickable(true);
            }
        }.start();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,NextActivity.class);
                startActivity(i);
            }
        });
    }
}
