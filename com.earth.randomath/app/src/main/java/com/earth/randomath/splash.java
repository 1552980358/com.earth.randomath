package com.earth.randomath;

import android.app.Activity;
import android.content.Intent;
import android.os.*;
import android.view.*;


public class splash extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,WindowManager.
                LayoutParams.FLAG_TRANSLUCENT_STATUS);
        Handler handler = new Handler();
        // 当计时结束时，跳转至主界面
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(splash.this, main.class));
                finish();
            }
        }, 2000); // 2秒延迟
    }
}

