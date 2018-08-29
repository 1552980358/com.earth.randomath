package com.earth.randomath;

import android.os.*;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.*;
import android.widget.*;
import java.util.Random;

public class dise extends AppCompatActivity {
    // define items
    private ImageView imgview;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,WindowManager.
                LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_dise);

        // call out toolbar
        Toolbar toolbar = super.findViewById(R.id.toolbar);
        toolbar.setTitle("骰子");
        setSupportActionBar(toolbar);
        // call out back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imgview=findViewById(R.id.dise_img);

        Button btn=super.findViewById(R.id.dise_btn);
        imgview.setImageResource(R.drawable.dise);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                String resu= (random.nextInt(6)+1)+"";
                switch (resu) {
                    case "1":
                        imgview.setImageResource(R.drawable.dise_1);
                        break;
                    case "2":
                        imgview.setImageResource(R.drawable.dise_2);
                        break;
                    case "3":
                        imgview.setImageResource(R.drawable.dise_3);
                        break;
                    case "4":
                        imgview.setImageResource(R.drawable.dise_4);
                        break;
                    case "5":
                        imgview.setImageResource(R.drawable.dise_5);
                        break;
                    case "6":
                        imgview.setImageResource(R.drawable.dise_6);
                        break;
                }
            }
        });
    }
}

