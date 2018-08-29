package com.earth.randomath;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.*;
import android.widget.*;

public class phy_heat extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    // heat capacity
    private EditText hc_c;
    private EditText hc_q;
    private EditText hc_t;

    // specific heat capacity
    private EditText shc_c;
    private EditText shc_q;
    private EditText shc_m;
    private EditText shc_t;

    // heat capacity <--> specific heat capacity
    private EditText hc_shc_hc;
    private EditText hc_shc_shc;
    private EditText hc_shc_m;

    // specific latent heat
    private EditText slh_l;
    private EditText slh_q;
    private EditText slh_m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phy_heat);

        Toolbar toolbar =super.findViewById(R.id.toolbar);
        toolbar.setTitle("物理 - 热学");
        setSupportActionBar(toolbar);
        // call out back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = super.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // heat capacity
        hc_c = findViewById(R.id.heat_hc_c);
        hc_q = findViewById(R.id.heat_hc_q);
        hc_t = findViewById(R.id.heat_hc_t);
        Button hc=findViewById(R.id.phy_heat_hp);
        hc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (!TextUtils.isEmpty(hc_c.getText())
                        && !TextUtils.isEmpty(hc_q.getText())
                        && !TextUtils.isEmpty(hc_t.getText())){
                    Toast.makeText(phy_heat.this, "数据给多了，我不知道该算哪个哦~",
                            Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(hc_c.getText())
                        && TextUtils.isEmpty(hc_q.getText())
                        && TextUtils.isEmpty(hc_t.getText())){
                    Toast.makeText(phy_heat.this, "你输入的数据不够哦~",
                            Toast.LENGTH_SHORT).show(); // 3 EditText null
                } else if ((TextUtils.isEmpty(hc_c.getText()) && TextUtils.isEmpty(hc_q.getText()))
                        || (TextUtils.isEmpty(hc_c.getText()) && TextUtils.isEmpty(hc_t.getText()))
                        || (TextUtils.isEmpty(hc_q.getText()) && TextUtils.isEmpty(hc_t.getText()))){
                    Toast.makeText(phy_heat.this, "你输入的数据不够哦~",
                            Toast.LENGTH_SHORT).show();  // 2 EditText null
                } else {
                    String ans;
                    if (hc_c.getText().toString().length() == 0){
                        double q = Double.parseDouble(hc_q.getText().toString());
                        double t = Double.parseDouble(hc_t.getText().toString());
                        if (t == 0){
                            Toast.makeText(phy_heat.this, "温度值(ΔT)不能为“0”哦~", Toast.LENGTH_SHORT).show();
                        } else {
                            ans = "" + q / t;
                            hc_c.setText(ans);
                        }
                    } else if (hc_q.getText().toString().length() == 0){
                        double c = Double.parseDouble(hc_c.getText().toString());
                        double t = Double.parseDouble(hc_t.getText().toString());
                        ans = "" + c * t;
                        hc_q.setText(ans);
                    } else {
                        double c = Double.parseDouble(hc_c.getText().toString());
                        double q = Double.parseDouble(hc_q.getText().toString());
                        if (c == 0){
                            Toast.makeText(phy_heat.this, "热容值(C)不能为“0”哦~", Toast.LENGTH_SHORT).show();
                        } else {
                            ans = "" + q / c;
                            hc_t.setText(ans);
                        }
                    }
                }
            }
        });

        // specific heat capacity
        shc_c = findViewById(R.id.heat_shc_c);
        shc_q = findViewById(R.id.heat_shc_q);
        shc_m = findViewById(R.id.heat_shc_m);
        shc_t = findViewById(R.id.heat_shc_t);
        Button shc = findViewById(R.id.phy_heat_shc);
        shc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(shc_c.getText())
                        && !TextUtils.isEmpty(shc_q.getText())
                        && !TextUtils.isEmpty(shc_m.getText())
                        && !TextUtils.isEmpty(shc_t.getText())){
                    Toast.makeText(phy_heat.this, "数据给多了，我不知道该算哪个哦~",
                            Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(shc_c.getText())
                        && TextUtils.isEmpty(shc_q.getText())
                        && TextUtils.isEmpty(shc_m.getText())
                        && TextUtils.isEmpty(shc_t.getText())){
                    Toast.makeText(phy_heat.this, "你输入的数据不够哦~",
                            Toast.LENGTH_SHORT).show();  // 4 EditText null
                } else if ((TextUtils.isEmpty(shc_c.getText())
                        && TextUtils.isEmpty(shc_q.getText()) && TextUtils.isEmpty(shc_m.getText()))
                        || (TextUtils.isEmpty(shc_c.getText())
                        && TextUtils.isEmpty(shc_q.getText()) && TextUtils.isEmpty(shc_t.getText()))
                        || (TextUtils.isEmpty(shc_c.getText())
                        && TextUtils.isEmpty(shc_m.getText()) && TextUtils.isEmpty(shc_t.getText()))
                        || (TextUtils.isEmpty(shc_q.getText())
                        && TextUtils.isEmpty(shc_m.getText()) && TextUtils.isEmpty(shc_t.getText()))){
                    Toast.makeText(phy_heat.this, "你输入的数据不够哦~",
                            Toast.LENGTH_SHORT).show();  // 3 EditText null
                } else if ((TextUtils.isEmpty(shc_c.getText()) && TextUtils.isEmpty(shc_q.getText()))
                        || (TextUtils.isEmpty(shc_c.getText()) && TextUtils.isEmpty(shc_m.getText()))
                        || (TextUtils.isEmpty(shc_c.getText()) && TextUtils.isEmpty(shc_t.getText()))
                        || (TextUtils.isEmpty(shc_q.getText()) && TextUtils.isEmpty(shc_m.getText()))
                        || (TextUtils.isEmpty(shc_q.getText()) && TextUtils.isEmpty(shc_t.getText()))
                        || (TextUtils.isEmpty(shc_m.getText()) && TextUtils.isEmpty(shc_t.getText()))){
                    Toast.makeText(phy_heat.this, "你输入的数据不够哦~",
                            Toast.LENGTH_SHORT).show();  // 2 EditText null
                } else {
                    String ans;
                    if (TextUtils.isEmpty(shc_c.getText())){
                        double q = Double.parseDouble(shc_q.getText().toString());
                        double m = Double.parseDouble(shc_m.getText().toString());
                        double t = Double.parseDouble(shc_t.getText().toString());
                        if (m == 0){
                            Toast.makeText(phy_heat.this, "质量值(m)不能为“0”哦~", Toast.LENGTH_SHORT).show();
                        } else if (t == 0){
                            Toast.makeText(phy_heat.this, "温度值(ΔT)不能为“0”哦~", Toast.LENGTH_SHORT).show();
                        } else {
                            ans = "" + (q / (m * t));
                            shc_c.setText(ans);
                        }
                    } else if (TextUtils.isEmpty(shc_q.getText())){
                        double c = Double.parseDouble(shc_c.getText().toString());
                        double m = Double.parseDouble(shc_m.getText().toString());
                        double t = Double.parseDouble(shc_t.getText().toString());
                        ans = ""+ (c * m * t);
                        shc_q.setText(ans);
                    } else if (TextUtils.isEmpty(shc_m.getText())){
                        double c = Double.parseDouble(shc_c.getText().toString());
                        double q = Double.parseDouble(shc_q.getText().toString());
                        double t = Double.parseDouble(shc_t.getText().toString());
                        if (c == 0){
                            Toast.makeText(phy_heat.this, "比热容(c)不能为“0”哦~", Toast.LENGTH_SHORT).show();
                        } else if (t == 0){
                            Toast.makeText(phy_heat.this, "温度值(ΔT)不能为“0”哦~", Toast.LENGTH_SHORT).show();
                        } else {
                            ans = "" + (q / (c * t));
                            shc_m.setText(ans);
                        }
                    } else {
                        double c = Double.parseDouble(shc_c.getText().toString());
                        double q = Double.parseDouble(shc_q.getText().toString());
                        double m = Double.parseDouble(shc_m.getText().toString());
                        if (c == 0){
                            Toast.makeText(phy_heat.this, "比热容值(c)不能为“0”哦~", Toast.LENGTH_SHORT).show();
                        } else if (m == 0){
                            Toast.makeText(phy_heat.this, "质量值(m)不能为“0”哦~", Toast.LENGTH_SHORT).show();
                        } else {
                            ans = "" + (q / (c * m));
                            shc_t.setText(ans);
                        }
                    }
                }
            }
        });

        // heat capacity <==> specific heat capacity
        hc_shc_hc = findViewById(R.id.heat_hc_shc_hc);
        hc_shc_shc = findViewById(R.id.heat_hc_shc_shc);
        hc_shc_m = findViewById(R.id.heat_hc_shc_m);
        Button hc_shc = findViewById(R.id.phy_heat_hc_shc);
        hc_shc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(hc_shc_hc.getText())
                        && !TextUtils.isEmpty(hc_shc_shc.getText())
                        && !TextUtils.isEmpty(hc_shc_m.getText())){
                    Toast.makeText(phy_heat.this, "数据给多了，我不知道该算哪个~",
                            Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(hc_shc_hc.getText())
                        && TextUtils.isEmpty(hc_shc_shc.getText())
                        && TextUtils.isEmpty(hc_shc_m.getText())){
                    Toast.makeText(phy_heat.this, "你输入的数据不够哦~",
                            Toast.LENGTH_SHORT).show();  // 3 EditText null
                } else if ((TextUtils.isEmpty(hc_shc_hc.getText()) && TextUtils.isEmpty(hc_shc_shc.getText()))
                        || (TextUtils.isEmpty(hc_shc_hc.getText()) && TextUtils.isEmpty(hc_shc_m.getText()))
                        || (TextUtils.isEmpty(hc_shc_shc.getText()) && TextUtils.isEmpty(hc_shc_m.getText()))){
                    Toast.makeText(phy_heat.this, "你输入的数据不够哦~",
                            Toast.LENGTH_SHORT).show();  // 2 EditText null
                } else {
                    String ans;
                    if (TextUtils.isEmpty(hc_shc_hc.getText())){
                        double shc = Double.parseDouble(hc_shc_shc.getText().toString());
                        double m = Double.parseDouble(hc_shc_m.getText().toString());
                        ans =""+ ( shc * m );
                        hc_shc_hc.setText(ans);
                    } else if (TextUtils.isEmpty(hc_shc_shc.getText())){
                        double hc = Double.parseDouble(hc_shc_hc.getText().toString());
                        double m = Double.parseDouble(hc_shc_m.getText().toString());
                        if ( m == 0){
                            Toast.makeText(phy_heat.this, "质量值(m)不能为“0”哦", Toast.LENGTH_SHORT).show();
                        } else {
                            ans = "" + (hc / m);
                            hc_shc_shc.setText(ans);
                        }
                    } else {
                        double hc = Double.parseDouble(hc_shc_hc.getText().toString());
                        double shc = Double.parseDouble(hc_shc_shc.getText().toString());
                        if (shc == 0) {
                            Toast.makeText(phy_heat.this, "比潜热值(shc)不能为“0”哦~", Toast.LENGTH_SHORT).show();
                        } else {
                            ans = "" + (hc / shc);
                            hc_shc_m.setText(ans);
                        }
                    }
                }
            }
        });

        // specific latent heat
        slh_l = findViewById(R.id.heat_slh_l);
        slh_q = findViewById(R.id.heat_slh_q);
        slh_m = findViewById(R.id.heat_slh_m);
        Button slh = findViewById(R.id.phy_heat_slh);
        slh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(slh_l.getText())
                        && !TextUtils.isEmpty(slh_m.getText())
                        && !TextUtils.isEmpty(slh_q.getText())){
                    Toast.makeText(phy_heat.this, "数据给多了，我不知道该算哪个~",
                            Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(slh_l.getText())
                        && TextUtils.isEmpty(slh_m.getText())
                        && TextUtils.isEmpty(slh_q.getText())) {
                    Toast.makeText(phy_heat.this, "你输入的数据不够哦~",
                            Toast.LENGTH_SHORT).show();  // 3 EditText null
                } else if ((TextUtils.isEmpty(slh_l.getText()) && TextUtils.isEmpty(slh_m.getText()))
                        || (TextUtils.isEmpty(slh_l.getText()) && TextUtils.isEmpty(slh_q.getText()))
                        || (TextUtils.isEmpty(slh_m.getText()) && TextUtils.isEmpty(slh_q.getText()))) {
                    Toast.makeText(phy_heat.this, "你输入的数据不够哦~",
                            Toast.LENGTH_SHORT).show();  // 2 EditText null
                }else {
                    String ans;
                    if (slh_l.getText().toString().length() == 0) {
                        double q = Double.parseDouble(slh_q.getText().toString());
                        double m = Double.parseDouble(slh_m.getText().toString());
                        if (m == 0){
                            Toast.makeText(phy_heat.this, "质量值不能为“0”哦~", Toast.LENGTH_SHORT).show();
                        } else {
                            ans = "" + ( q / m );
                            slh_l.setText(ans);
                        }
                    } else if (slh_m.getText().toString().length() == 0) {
                        double l = Double.parseDouble(slh_l.getText().toString());
                        double q = Double.parseDouble(slh_q.getText().toString());
                        if ( l == 0){
                            Toast.makeText(phy_heat.this, "比潜热值(l)不能为“0”哦~", Toast.LENGTH_SHORT).show();
                        } else {
                            ans = "" + ( q / l );
                            slh_m.setText(ans);
                        }
                    } else {
                        double l = Double.parseDouble(slh_l.getText().toString());
                        double m = Double.parseDouble(slh_m.getText().toString());
                        ans = ""+ m * l;
                        slh_q.setText(ans);
                    }
                }
            }
        });
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        // nav_bar items
        Intent intent = new Intent();
        AlertDialog.Builder Dialog=new AlertDialog.Builder(phy_heat.this);
        switch (id) {
            case R.id.nav_dise :
                intent.setClass(phy_heat.this,dise.class);
                startActivity(intent);
                finish();
                break;
            case R.id.nav_randomnum :
                intent.setClass(phy_heat.this,randomnum.class);
                startActivity(intent);
                finish();
                break;
            case R.id.nav_quaequa :
                intent.setClass(phy_heat.this,quadraticequa.class);
                startActivity(intent);
                finish();
                break;
            case R.id.nav_heat :
                intent.setClass(phy_heat.this,phy_heat.class);
                startActivity(intent);
                finish();
                break;
            case R.id.nav_optical:
                intent .setClass(phy_heat.this,phy_optical.class);
                startActivity(intent);
                finish();
                break;
            case R.id.nav_about :
                Dialog.setTitle("关于");
                Dialog.setMessage("作者：住在地球真累 \n 本应用开发一切随缘——想更新就更新");
                Dialog.setPositiveButton("联系作者", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String url = "mqqwpa://im/chat?chat_type=wpa?uin=1552980358&version=1";
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                    }
                });
                Dialog.setNegativeButton("分享", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent().setAction(Intent.ACTION_SEND)
                                .putExtra(Intent.EXTRA_TEXT,"酷安搜索“数学随缘”")
                                .setType("text/plain");
                        startActivity(Intent.createChooser(intent,"分享..."));
                    }
                });
                Dialog.show();
                break;
            case R.id.nav_donate :
                Dialog.setTitle("请喝廓落/血必/昏达");
                Dialog.setMessage("支付宝：qq1552980358@gmail.com \n QQ：1552980358");
                Dialog.setPositiveButton("支付宝", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(phy_heat.this, "支付宝直链暂时木有哦~还请用我电邮转给我",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                Dialog.setNegativeButton("微信", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(phy_heat.this, "微信直链暂时木有哦~还请用我支付宝电邮转给我",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                Dialog.show();
                break;
        }

        DrawerLayout drawer = super.findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}