package com.earth.randomath;

import android.app.AlertDialog;
import android.content.*;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.*;
import android.support.v4.view.*;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.*;
import android.widget.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class phy_mechanics extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener , TabLayout.OnTabSelectedListener{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MyViewPagerAdapter viewPagerAdapter;
    //TabLayout标签
    private String[] titles=new String[]{"运动","能量&力量"};
    private List<Fragment> fragments=new ArrayList<>();

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phy_mechanics);

        Toolbar toolbar = super.findViewById(R.id.toolbar);
        toolbar.setTitle("物理 - 力学");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        settablayout();


        NavigationView navigationView = super.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void settablayout(){
        tabLayout=(TabLayout)findViewById(R.id.mechanics_tab);
        viewPager=(ViewPager)findViewById(R.id.mechanics_viewpager);
        //设置TabLayout标签的显示方式
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        tabLayout.addTab(tabLayout.newTab().setText(titles[0]));
        tabLayout.addTab(tabLayout.newTab().setText(titles[1]));

        tabLayout.addOnTabSelectedListener(this);
        fragments.add(new phy_mechanics_motion());
        fragments.add(new phy_mechanics_ene_pow());
        viewPagerAdapter=new MyViewPagerAdapter(getSupportFragmentManager(),titles,fragments);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }



    public class MyViewPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragments;
        private String[] titles;

        public MyViewPagerAdapter(FragmentManager fm, String[] titles, List<Fragment> fragments) {
            super(fm);
            this.titles = titles;
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int arg0) {
            return fragments.get(arg0);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        // nav_bar items
        Intent intent = new Intent();
        AlertDialog.Builder Dialog=new AlertDialog.Builder(phy_mechanics.this);
        switch (id) {
            case R.id.nav_dise :
                intent.setClass(phy_mechanics.this,dise.class);
                startActivity(intent);
                finish();
                break;
            case R.id.nav_randomnum :
                intent.setClass(phy_mechanics.this,randomnum.class);
                startActivity(intent);
                finish();
                break;
            case R.id.nav_quaequa :
                intent.setClass(phy_mechanics.this,quadraticequa.class);
                startActivity(intent);
                finish();
                break;
            case R.id.nav_heat :
                intent.setClass(phy_mechanics.this,phy_heat.class);
                startActivity(intent);
                finish();
                break;
            case R.id.nav_mechanics:
                intent.setClass(phy_mechanics.this,phy_mechanics.class);
                startActivity(intent);
                break;
            case R.id.nav_optical:
                intent.setClass(phy_mechanics.this,phy_optical.class);
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
                        Toast.makeText(phy_mechanics.this, "支付宝直链暂时木有哦~还请用我电邮转给我",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                Dialog.setNegativeButton("微信", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(phy_mechanics.this, "微信直链暂时木有哦~还请用我支付宝电邮转给我",
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
