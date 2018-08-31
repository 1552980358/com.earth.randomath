package com.earth.randomath;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.DocumentsProvider;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.*;
import android.widget.*;

import org.w3c.dom.Text;

import java.util.function.DoubleUnaryOperator;

public class phy_optical extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    // refractive angle
    private EditText ri_c;
    private EditText ri_v;
    private EditText ri_n;

    // critical angle
    private EditText ca_c;
    private EditText ca_n;

    // lens formula
    private EditText lf_u;
    private EditText lf_v;
    private EditText lf_f;

    // magnification
    private EditText mg_m;
    private EditText mg_f1;
    private EditText mg_u;
    private EditText mg_f2;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phy_optical);

        Toolbar toolbar = super.findViewById(R.id.toolbar);
        toolbar.setTitle("光学");
        setSupportActionBar(toolbar);
        // call out back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = super.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ri_n = findViewById(R.id.op_ri_n);
        ri_c = findViewById(R.id.op_ri_c);
        ri_v = findViewById(R.id.op_ri_v);
        Button ri=super.findViewById(R.id.op_ri);
        ri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(ri_n.getText())
                        && !TextUtils.isEmpty(ri_c.getText())
                        && !TextUtils.isEmpty(ri_v.getText())){
                    Toast.makeText(phy_optical.this, "数据给多了，我不知道该算哪个~",
                            Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(ri_n.getText())
                        && TextUtils.isEmpty(ri_c.getText())
                        && TextUtils.isEmpty(ri_v.getText())){
                    Toast.makeText(phy_optical.this, "你木有输入数据哦~",
                            Toast.LENGTH_SHORT).show();
                } else if ((TextUtils.isEmpty(ri_n.getText()) && TextUtils.isEmpty(ri_c.getText()))
                        || (TextUtils.isEmpty(ri_n.getText()) && TextUtils.isEmpty(ri_v.getText()))
                        || (TextUtils.isEmpty(ri_c.getText()) && TextUtils.isEmpty(ri_v.getText()))){
                    Toast.makeText(phy_optical.this, "你输入的数据不够哦~",
                            Toast.LENGTH_SHORT).show();
                } else {
                    String ans;
                    if (TextUtils.isEmpty(ri_n.getText())){
                        double c=Double.parseDouble(ri_c.getText().toString());
                        double v=Double.parseDouble(ri_v.getText().toString());
                        if (v == 0){
                            Toast.makeText(phy_optical.this, "介质1值(θc)不能“0”哦~",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            ans=""+ ( bsin(c) / bsin(v) );
                            ri_n.setText(ans);
                        }
                    } else if (TextUtils.isEmpty(ri_c.getText())){
                        double n=Double.parseDouble(ri_n.getText().toString());
                        double v=Double.parseDouble(ri_v.getText().toString());
                        ans=""+ ( n * bsin(v) );
                        ri_c.setText(ans);
                    } else {
                        double n=Double.parseDouble(ri_n.getText().toString());
                        double c=Double.parseDouble(ri_c.getText().toString());
                        if (n == 0){
                            Toast.makeText(phy_optical.this, "折射率值(n)不能“0”哦~",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            ans=""+ Math.asin( c / bsin(n) );
                            ri_v.setText(ans);
                        }
                    }
                }
            }
        });

        ca_c = findViewById(R.id.op_ca_c);
        ca_n = findViewById(R.id.op_ca_n);
        Button ca = findViewById(R.id.op_ca);
        ca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(ca_c.getText())
                        && !TextUtils.isEmpty(ca_n.getText())){
                    Toast.makeText(phy_optical.this, "数据给多了，我不知道该算哪个~",
                            Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(ca_c.getText())
                        && TextUtils.isEmpty(ca_n.getText())){
                    Toast.makeText(phy_optical.this, "你木有输入数据哦~",
                            Toast.LENGTH_SHORT).show();
                } else {
                    String ans;
                    if (TextUtils.isEmpty(ca_c.getText())){
                        double n=Double.parseDouble(ca_n.getText().toString());
                        if (n == 0){
                            Toast.makeText(phy_optical.this, "折射率值(n)不能“0”哦~",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            ans = ""+ (Math.asin(1 / n));
                            ca_n.setText(ans);
                        }
                    } else {
                        double c=Double.parseDouble(ca_c.getText().toString());
                        if (c == 0 || c % 180 == 0) {
                            Toast.makeText(phy_optical.this, "sinθc不能为“0”哦~",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            ans = ""+ (1 / bsin(c));
                            ca_n.setText(ans);
                        }
                    }
                }
            }
        });

        lf_u = findViewById(R.id.op_lf_u);
        lf_v = findViewById(R.id.op_lf_v);
        lf_f = findViewById(R.id.op_lf_f);
        Button lf = findViewById(R.id.op_lf);
        lf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(lf_u.getText())
                        && !TextUtils.isEmpty(lf_v.getText())
                        && !TextUtils.isEmpty(lf_f.getText())){
                    Toast.makeText(phy_optical.this, "数据给多了，我不知道该算哪个~",
                            Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(lf_u.getText())
                        && TextUtils.isEmpty(lf_v.getText())
                        && TextUtils.isEmpty(lf_f.getText())){
                    Toast.makeText(phy_optical.this, "你木有输入数据哦~",
                            Toast.LENGTH_SHORT).show();
                }else if ((TextUtils.isEmpty(lf_u.getText()) && TextUtils.isEmpty(lf_v.getText()))
                        || (TextUtils.isEmpty(lf_u.getText()) && TextUtils.isEmpty(lf_f.getText()))
                        || (TextUtils.isEmpty(lf_v.getText()) && TextUtils.isEmpty(lf_f.getText()))){
                    Toast.makeText(phy_optical.this, "你输入的数据不够哦~",
                            Toast.LENGTH_SHORT).show();
                } else {
                    String ans;
                    if (TextUtils.isEmpty(lf_u.getText())){
                        double v = Double.parseDouble(lf_v.getText().toString());
                        double f = Double.parseDouble(lf_f.getText().toString());
                        if (v - f== 0){
                            Toast.makeText(phy_optical.this, "v - f 不能为“0”哦~",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            ans = ""+ ((v * f) / (v - f));
                            lf_u.setText(ans);
                        }
                    } else if (TextUtils.isEmpty(lf_v.getText())){
                        double u = Double.parseDouble(lf_u.getText().toString());
                        double f = Double.parseDouble(lf_f.getText().toString());
                        if (u - f == 0){
                            Toast.makeText(phy_optical.this, "u - f 不能为“0”哦~",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            ans = ""+ ((u * f) / (u - f));
                            lf_v.setText(ans);
                        }
                    } else {

                        double u = Double.parseDouble(lf_u.getText().toString());
                        double v = Double.parseDouble(lf_v.getText().toString());
                        if (u + v == 0){
                            Toast.makeText(phy_optical.this, "u + v 不能为“0”哦~",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            ans = ""+ ((u * v) / (u + v));
                            lf_f.setText(ans);
                        }
                    }
                }
            }
        });

        mg_m = findViewById(R.id.op_mg_m);
        mg_f1 = findViewById(R.id.op_mg_f1);
        mg_u = findViewById(R.id.op_mg_u);
        mg_f2 = findViewById(R.id.op_mg_f2);
        Button mg = findViewById(R.id.op_mg);
        mg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(mg_m.getText())
                        && !TextUtils.isEmpty(mg_f1.getText())
                        && !TextUtils.isEmpty(mg_u.getText())
                        && !TextUtils.isEmpty(mg_f2.getText())){
                    Toast.makeText(phy_optical.this, "数据给多了，我不知道该算哪个~",
                            Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(mg_m.getText())
                        && TextUtils.isEmpty(mg_f1.getText())
                        && TextUtils.isEmpty(mg_u.getText())
                        && TextUtils.isEmpty(mg_f2.getText())){
                    Toast.makeText(phy_optical.this, "你木有输入数据哦~",
                            Toast.LENGTH_SHORT).show();
                } else if (((TextUtils.isEmpty(mg_f1.getText() )|| TextUtils.isEmpty(mg_f2.getText()))
                        && TextUtils.isEmpty(mg_m.getText()) &&TextUtils.isEmpty(mg_u.getText()))
                        || (TextUtils.isEmpty(mg_m.getText()) && TextUtils.isEmpty(mg_u.getText()))
                        || ((TextUtils.isEmpty(mg_f1.getText())|| TextUtils.isEmpty(mg_f2.getText()))
                        && TextUtils.isEmpty(mg_m.getText()))
                        || ((TextUtils.isEmpty(mg_f1.getText())|| TextUtils.isEmpty(mg_f2.getText()))
                        && TextUtils.isEmpty(mg_u.getText()))){
                    Toast.makeText(phy_optical.this, "你输入的数据不够哦~",
                            Toast.LENGTH_SHORT).show();
                } else {
                    String ans;
                    // check value of f1 and f2
                    if (!TextUtils.isEmpty(mg_f1.getText()) && !TextUtils.isEmpty(mg_f2.getText())) {
                        if (!mg_f1.getText().toString().equals(mg_f2.getText().toString())) {
                            Toast.makeText(phy_optical.this, "两个f的数值不一样哦~\n你可以在随意一个输入框填入一个正确的f数值就行了哦！",
                                    Toast.LENGTH_SHORT).show();
                        }   // merge f1 and f2 when one of them is empty
                    } else if (TextUtils.isEmpty(mg_f1.getText()) && !TextUtils.isEmpty(mg_f2.getText())) {
                        mg_f1.setText(mg_f2.getText());
                    } else if (TextUtils.isEmpty(mg_f2.getText()) && !TextUtils.isEmpty(mg_f1.getText())) {
                        mg_f2.setText(mg_f1.getText());
                    }

                    // calculation
                    if (TextUtils.isEmpty(mg_m.getText())){
                        double f = Double.parseDouble(mg_f1.getText().toString());
                        double u = Double.parseDouble(mg_u.getText().toString());
                        if (u - f == 0){
                            Toast.makeText(phy_optical.this, "u - f 不能为“0”哦~",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            ans = "" + (f / (u - f));
                            mg_m.setText(ans);
                        }
                    } else if (TextUtils.isEmpty(mg_u.getText())){
                        double m = Double.parseDouble(mg_m.getText().toString());
                        double f = Double.parseDouble(mg_f1.getText().toString());
                        ans = "" + ((f * (m + 1)) / m);
                        mg_u.setText(ans);
                    } else {
                        double m = Double.parseDouble(mg_m.getText().toString());
                        double u = Double.parseDouble(mg_u.getText().toString());
                        if (m + 1 == 0){
                            Toast.makeText(phy_optical.this, "m + 1 不能为“0”哦~",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            ans = "" + ((m * u) / (m + 1));
                            mg_f1.setText(ans);
                            mg_f2.setText(ans);
                        }
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
        AlertDialog.Builder Dialog=new AlertDialog.Builder(phy_optical.this);
        switch (id) {
            case R.id.nav_dise :
                intent.setClass(phy_optical.this,dise.class);
                startActivity(intent);
                finish();
                break;
            case R.id.nav_randomnum :
                intent.setClass(phy_optical.this,randomnum.class);
                startActivity(intent);
                finish();
                break;
            case R.id.nav_quaequa :
                intent.setClass(phy_optical.this,quadraticequa.class);
                startActivity(intent);
                finish();
                break;
            case R.id.nav_heat :
                intent.setClass(phy_optical.this,phy_heat.class);
                startActivity(intent);
                finish();
                break;
            case R.id.nav_optical:
                intent .setClass(phy_optical.this,phy_optical.class);
                startActivity(intent);
                finish();
                break;
            case R.id.nav_mechanics:
                intent.setClass(phy_optical.this,phy_mechanics.class);
                startActivity(intent);
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
                        Toast.makeText(phy_optical.this, "支付宝直链暂时木有哦~还请用我电邮转给我",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                Dialog.setNegativeButton("微信", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(phy_optical.this, "微信直链暂时木有哦~还请用我支付宝电邮转给我",
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

    public double bsin(double degree){
        double dg = Math.toRadians(degree);
        return Math.sin(dg);
    }
}
