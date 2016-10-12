package com.example.student.ss101201;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    int i = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.textView2);
        tv.setText(String.valueOf(i));
        //倒數計時
        new Thread(){
            @Override
            public void run() {
                super.run();
                do {
                    try {
                        Thread.sleep(900);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i--;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tv.setText(String.valueOf(i));
                        }
                    });
                }while (i > 0);
            }
        }.start();
    }
}
