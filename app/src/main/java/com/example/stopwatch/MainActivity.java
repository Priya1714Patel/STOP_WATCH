package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView t1;
    int second=0;
    boolean isRunning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void onStop(View view){
        isRunning=false;
    }
    public void onPlay(View view){
        isRunning=true;
        runTime();
    }
    public void onRestart(View view){
        isRunning=false;
        second=0;
    }
    public void runTime(){
        t1=(TextView)findViewById(R.id.text2);
        Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {

                int s=second%60;
                int m=second/60;
                int h=m/60;
                if(isRunning){
                    second++;
                }
                String formateString=String.format(Locale.getDefault(),"%02d:%02d:%02d",h,m,s);
                t1.setText(formateString);
                handler.postDelayed(this,1000);
            }
        });

    }
}