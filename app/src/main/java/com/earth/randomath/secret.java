package com.earth.randomath;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.*;
import android.widget.Button;

public class secret extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,WindowManager.
                LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_secret);
        Toolbar toolbar = super.findViewById(R.id.toolbar);
        toolbar.setTitle("神秘领域");
        setSupportActionBar(toolbar);
        // call out back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button btn = super.findViewById(R.id.secr_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://mega.nz/#!6WQTAIrA!gScVdj1ewmbF_tWFFO5V8V17nySCBt52ZgoH1DTSbVk";
                Intent intent = new Intent().setData(Uri.parse(url));
                intent.setAction(Intent.ACTION_VIEW);
                startActivity(intent);
            }
        });
    }
}
