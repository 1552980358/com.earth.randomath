package com.earth.randomath;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.*;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.*;
import android.support.v4.app.NotificationCompatSideChannelService;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.*;
import android.support.v7.widget.Toolbar;
import android.view.*;
import android.widget.*;

public class main extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{
    private int count=0;
    SharedPreferences sp;

    int no_count = 1;

    Button btn_11;
    Button btn_12;
    Button btn_13;
    Button btn_21;
    Button btn_22;
    Button btn_23;
    Button btn_31;
    Button btn_32;
    Button btn_33;

    TextView main_text;

    String winer = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar =super.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        main_text = findViewById(R.id.main_txt);
        // x y
        btn_11 = findViewById(R.id.main_11);
        btn_12 = findViewById(R.id.main_12);
        btn_13 = findViewById(R.id.main_13);
        btn_21 = findViewById(R.id.main_21);
        btn_22 = findViewById(R.id.main_22);
        btn_23 = findViewById(R.id.main_23);
        btn_31 = findViewById(R.id.main_31);
        btn_32 = findViewById(R.id.main_32);
        btn_33 = findViewById(R.id.main_33);

        Button main_clean = findViewById(R.id.main_clear);
        main_clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_11.setText(" ");
                btn_12.setText(" ");
                btn_13.setText(" ");
                btn_21.setText(" ");
                btn_22.setText(" ");
                btn_23.setText(" ");
                btn_31.setText(" ");
                btn_32.setText(" ");
                btn_33.setText(" ");
                main_text.setText("现在是玩家\"O\"时间哦~");
                count = 1;
                winer = " ";
            }
        });

        final View.OnClickListener listen = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (no_count % 2 ==1){
                    main_text.setText("现在是玩家\"X\"时间哦~ \n" );
                    switch (v.getId()){
                        case R.id.main_11:
                            btn_11.setText("O");
                            break;
                        case R.id.main_12:
                            btn_12.setText("O");
                            break;
                        case R.id.main_13:
                            btn_13.setText("O");
                            break;
                        case R.id.main_21:
                            btn_21.setText("O");
                            break;
                        case R.id.main_22:
                            btn_22.setText("O");
                            break;
                        case R.id.main_23:
                            btn_23.setText("O");
                            break;
                        case R.id.main_31:
                            btn_31.setText("O");
                            break;
                        case R.id.main_32:
                            btn_32.setText("O");
                            break;
                        case R.id.main_33:
                            btn_33.setText("O");
                            break;
                    }
                } else {
                    main_text.setText("现在是玩家\"O\"时间哦~ \n" );
                    switch (v.getId()){
                        case R.id.main_11:
                            btn_11.setText("X");
                            break;
                        case R.id.main_12:
                            btn_12.setText("X");
                            break;
                        case R.id.main_13:
                            btn_13.setText("X");
                            break;
                        case R.id.main_21:
                            btn_21.setText("X");
                            break;
                        case R.id.main_22:
                            btn_22.setText("X");
                            break;
                        case R.id.main_23:
                            btn_23.setText("X");
                            break;
                        case R.id.main_31:
                            btn_31.setText("X");
                            break;
                        case R.id.main_32:
                            btn_32.setText("X");
                            break;
                        case R.id.main_33:
                            btn_33.setText("X");
                            break;
                    }
                }
                no_count++;
                if ((btn_11.getText().toString().equals("O") && btn_12.getText().toString().equals("O")
                        && btn_13.getText().toString().equals("O"))
                        || (btn_11.getText().toString().equals("O") && btn_21.getText().toString().equals("O")
                        && btn_31.getText().toString().equals("O"))
                        || (btn_11.getText().toString().equals("O") && btn_22.getText().toString().equals("O")
                        && btn_33.getText().toString().equals("O"))
                        || (btn_12.getText().toString().equals("O") && btn_22.getText().toString().equals("O")
                        && btn_32.getText().toString().equals("O"))
                        || (btn_13.getText().toString().equals("O") && btn_23.getText().toString().equals("O")
                        && btn_33.getText().toString().equals("O"))
                        || (btn_31.getText().toString().equals("O") && btn_22.getText().toString().equals("O")
                        && btn_31.getText().toString().equals("O"))){
                    winer = "o";
                } else if ((btn_11.getText().toString().equals("X") && btn_12.getText().toString().equals("X")
                        && btn_13.getText().toString().equals("X"))
                        || (btn_11.getText().toString().equals("X") && btn_21.getText().toString().equals("X")
                        && btn_31.getText().toString().equals("X"))
                        || (btn_11.getText().toString().equals("X") && btn_22.getText().toString().equals("X")
                        && btn_33.getText().toString().equals("X"))
                        || (btn_12.getText().toString().equals("X") && btn_22.getText().toString().equals("X")
                        && btn_32.getText().toString().equals("X"))
                        || (btn_13.getText().toString().equals("X") && btn_23.getText().toString().equals("X")
                        && btn_33.getText().toString().equals("X"))
                        || (btn_31.getText().toString().equals("X") && btn_22.getText().toString().equals("X")
                        && btn_31.getText().toString().equals("X"))){
                    winer = "X";
                }
                if (winer == "O" || winer == "X"){
                    AlertDialog.Builder dialog = new AlertDialog.Builder(main.this);
                    dialog.setTitle("胜利！");
                    dialog.setMessage("胜利者为\""+winer+"\"! \n 记得选清除后开始哦~\n不然发生了什么BUG，我才不会管呢~");
                    dialog.setPositiveButton("清除后继续", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            btn_11.setText(" ");
                            btn_12.setText(" ");
                            btn_13.setText(" ");
                            btn_21.setText(" ");
                            btn_22.setText(" ");
                            btn_23.setText(" ");
                            btn_31.setText(" ");
                            btn_32.setText(" ");
                            btn_33.setText(" ");
                            main_text.setText("现在是玩家\"O\"时间哦~");
                            count = 1;
                            winer = " ";
                        }
                    });
                    dialog.setNegativeButton("哦~", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(main.this, "记得要点清除才继续游戏哦~", Toast.LENGTH_SHORT).show();
                        }
                    });
                    dialog.show();
                }

            }
        };

        btn_11.setOnClickListener(listen);
        btn_12.setOnClickListener(listen);
        btn_13.setOnClickListener(listen);
        btn_21.setOnClickListener(listen);
        btn_22.setOnClickListener(listen);
        btn_23.setOnClickListener(listen);
        btn_31.setOnClickListener(listen);
        btn_32.setOnClickListener(listen);
        btn_33.setOnClickListener(listen);


        sp=getSharedPreferences("save",MODE_PRIVATE);
        String show_dialog = sp.getString("sd_str","");

        if (show_dialog.equals("") || show_dialog.equals("2") ){
            AlertDialog.Builder dialog = new AlertDialog.Builder(main.this);
            dialog.setTitle("科学随缘——简介");
            dialog.setIcon(R.drawable.ic_launcher_round);
            dialog.setView(R.layout.dialog_main_about);
            dialog.setNegativeButton(R.string.radio_btn_not_show,new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    sp.edit().putString("sd_str","1").apply();
                }
            });
            dialog.setPositiveButton(R.string.radio_btn_show, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    sp.edit().putString("sd_str","2").apply();
                }
            });
            dialog.show();
        }
        ;

        FloatingActionButton fab =super.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                switch (count) {
                    case 1:
                        Snackbar.make(view, "别乱搓哦~", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                        break;
                    case 2:
                        Snackbar.make(view,"不行哦~",Snackbar.LENGTH_LONG)
                                .setAction("Action",null).show();
                        break;
                    case 3:
                        Snackbar.make(view,"要乖，不能再搓了哦~",Snackbar.LENGTH_LONG)
                                .setAction("Action",null).show();
                        break;
                    case 4:
                        Snackbar.make(view,"再搓我可是要生气的哦~",Snackbar.LENGTH_LONG)
                                .setAction("Action",null).show();
                        break;
                    case 5:
                        Toast.makeText(main.this,"哼，奏凯啦，讨厌死了",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(main.this,secret.class);
                        startActivity(intent);
                        break;
                    default:
                        Snackbar.make(view,"你们可不要太过分了哦~",Snackbar.LENGTH_LONG)
                                .setAction("Action",null).show();
                        break;
                }
            }
        });

        DrawerLayout drawer = super.findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = super.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = super.findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        // nav_bar items
        Intent intent = new Intent();
        AlertDialog.Builder Dialog=new AlertDialog.Builder(main.this);
        switch (id) {
            case R.id.nav_dise :
                intent.setClass(main.this,dise.class);
                startActivity(intent);
                break;
            case R.id.nav_randomnum :
                intent.setClass(main.this,randomnum.class);
                startActivity(intent);
                break;
            case R.id.nav_quaequa :
                intent.setClass(main.this,quadraticequa.class);
                startActivity(intent);
                break;
            case R.id.nav_heat :
                intent.setClass(main.this,phy_heat.class);
                startActivity(intent);
                break;
            case R.id.nav_optical:
                intent .setClass(main.this,phy_optical.class);
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
                        Toast.makeText(main.this, "支付宝直链暂时木有哦~还请用我电邮转给我",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                Dialog.setNegativeButton("微信", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(main.this, "微信直链暂时木有哦~还请用我支付宝电邮转给我",
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
