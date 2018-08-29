package com.earth.randomath;

import android.os.*;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.*;
import android.widget.*;

import java.util.Random;

public class randomnum extends AppCompatActivity{
    private EditText txt_x;
    private EditText txt_y;
    private TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,WindowManager.
                LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_randomnum);

        // call out toolbar
        Toolbar toolbar = super.findViewById(R.id.toolbar);
        toolbar.setTitle("X 到 Y 随机整型数");
        setSupportActionBar(toolbar);
        // call out back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        this.txt_x=super.findViewById(R.id.randno_x);
        this.txt_y=super.findViewById(R.id.randno_y);
        this.res=super.findViewById(R.id.randno_res);

        Button btn=super.findViewById(R.id.randno_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((TextUtils.isEmpty(txt_x.getText()) && TextUtils.isEmpty(txt_y.getText()))
                        || TextUtils.isEmpty(txt_x.getText())
                        || TextUtils.isEmpty(txt_y.getText())){
                    Toast.makeText(randomnum.this, "你输入的数据不够哦~",
                            Toast.LENGTH_SHORT).show();
                }else {
                    String result;
                    int x = Integer.parseInt(txt_x.getText().toString());
                    int y = Integer.parseInt(txt_y.getText().toString());
                    if (x == y) {
                        result = x + "";
                    } else if (x > y) {
                        result = "x > y，无法随机数字！";
                    } else {
                        Random random = new Random();
                        result = (random.nextInt(y - x + 1) + x) + "";
                    }
                    res.setText(result);
                }

            }
        });
    }
}
