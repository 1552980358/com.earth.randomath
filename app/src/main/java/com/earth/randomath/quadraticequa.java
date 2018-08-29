package com.earth.randomath;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.*;
import android.widget.*;

public class quadraticequa extends AppCompatActivity {
    private EditText et_a;
    private EditText et_b;
    private EditText et_c;
    private TextView ans_a;
    private TextView ans_b;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,WindowManager.
                LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_quaequa);

        // call out toolbar
        Toolbar toolbar = super.findViewById(R.id.toolbar);
        toolbar.setTitle("二次方程计算");
        setSupportActionBar(toolbar);
        // call out back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        et_a = findViewById(R.id.quaequa_a);
        et_b= findViewById(R.id.quaequa_b);
        et_c = findViewById(R.id.quaequa_c);
        ans_a = findViewById(R.id.quaequa_alpha);
        ans_b = findViewById(R.id.quaequa_beta);

        Button btn=super.findViewById(R.id.quaequa_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(et_a.getText()) && TextUtils.isEmpty(et_b.getText()) && TextUtils.isEmpty(et_c.getText())) {
                    Toast.makeText(quadraticequa.this, "你输入的数据不够哦~",
                            Toast.LENGTH_SHORT).show();
                } else if ((TextUtils.isEmpty(et_a.getText()) && TextUtils.isEmpty(et_b.getText()))
                        || (TextUtils.isEmpty(et_a.getText()) && TextUtils.isEmpty(et_c.getText()))
                        || TextUtils.isEmpty(et_b.getText()) && TextUtils.isEmpty(et_c.getText())){
                    Toast.makeText(quadraticequa.this, "你输入的数据不够哦~",
                            Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(et_a.getText())
                        || TextUtils.isEmpty(et_b.getText())
                        || TextUtils.isEmpty(et_c.getText())){
                    Toast.makeText(quadraticequa.this, "你输入的数据不够哦~",
                            Toast.LENGTH_SHORT).show();
                } else {
                    double a = Double.parseDouble(et_a.getText().toString());
                    double b = Double.parseDouble(et_b.getText().toString());
                    double c = Double.parseDouble(et_c.getText().toString());

                    Double delta = b * b - ( 4 * a * c);

                    if (delta < 0){
                        ans_a.setText(R.string.delta_lt_0);
                        ans_b.setText(R.string.delta_lt_0);
                    } else if (delta == 0) {
                        String result = "α = β =" + ((-b) - Math.sqrt(((b*b)-(4*a*c))))/(4*a) + "";
                        ans_a.setText(result);
                        ans_b.setText(result);
                    } else {
                        String result = "α = " + ((-b) - Math.sqrt(((b*b)-(4*a*c))))/(4*a)+"";
                        ans_a.setText(result);
                        result = "β = "+((-b) + Math.sqrt(((b*b)-(4*a*c))))/(4*a)+"";
                        ans_b.setText(result);
                    }
                }
            }
        });

    }
}
