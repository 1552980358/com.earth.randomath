package com.earth.randomath;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.*;
import android.widget.*;


public class phy_mechanics_motion extends Fragment{

    // s = (1/2) * (u + v) * (t)
    private EditText for1_s;
    private EditText for1_u;
    private EditText for1_v;
    private EditText for1_t;

    // v = u + (a * t)
    private EditText for2_v;
    private EditText for2_u;
    private EditText for2_a;
    private EditText for2_t;

    // v² - u² = 2(a)(s)
    private EditText for3_v;
    private EditText for3_u;
    private EditText for3_a;
    private EditText for3_s;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fra_phy_mechanics_motion,container,false);
    }
    public void onViewCreated(View view , Bundle savedInstanceState){
        super.onViewCreated(view , savedInstanceState);

        for1_s = view.findViewById(R.id.motion_for1_s);
        for1_u = view.findViewById(R.id.motion_for1_u);
        for1_v = view.findViewById(R.id.motion_for1_v);
        for1_t = view.findViewById(R.id.motion_for1_t);
        Button for1 = view.findViewById(R.id.mech_motion_for1);
        for1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(for1_s.getText())
                        && !TextUtils.isEmpty(for1_u.getText())
                        && !TextUtils.isEmpty(for1_v.getText())
                        && !TextUtils.isEmpty(for1_t.getText())){
                    Toast.makeText(getActivity(), "数据给多了，我不知道该算哪个~", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(for1_s.getText())
                        && TextUtils.isEmpty(for1_u.getText())
                        && TextUtils.isEmpty(for1_v.getText())
                        && TextUtils.isEmpty(for1_t.getText())){
                    Toast.makeText(getActivity(), "你木有输入数据哦~", Toast.LENGTH_SHORT).show();
                } else if ((TextUtils.isEmpty(for1_s.getText()) && TextUtils.isEmpty(for1_u.getText())
                        && TextUtils.isEmpty(for1_v.getText()))
                        || (TextUtils.isEmpty(for1_s.getText())&& TextUtils.isEmpty(for1_u.getText())
                        && TextUtils.isEmpty(for1_t.getText()))
                        || (TextUtils.isEmpty(for1_s.getText()) && TextUtils.isEmpty(for1_v.getText())
                        && TextUtils.isEmpty(for1_t.getText()))
                        || (TextUtils.isEmpty(for1_u.getText()) && TextUtils.isEmpty(for1_v.getText())
                        && TextUtils.isEmpty(for1_t.getText()))){
                    Toast.makeText(getActivity(), "你输入的数据不够哦~",
                            Toast.LENGTH_SHORT).show();
                } else if ((TextUtils.isEmpty(for1_s.getText()) && TextUtils.isEmpty(for1_u.getText()))
                        || (TextUtils.isEmpty(for1_s.getText()) && TextUtils.isEmpty(for1_v.getText()))
                        || (TextUtils.isEmpty(for1_s.getText()) && TextUtils.isEmpty(for1_t.getText()))
                        || (TextUtils.isEmpty(for1_u.getText()) && TextUtils.isEmpty(for1_v.getText()))
                        || (TextUtils.isEmpty(for1_u.getText()) && TextUtils.isEmpty(for1_t.getText()))
                        || (TextUtils.isEmpty(for1_v.getText()) && TextUtils.isEmpty(for1_t.getText()))){
                    Toast.makeText(getActivity(), "你输入的数据不够哦~",
                            Toast.LENGTH_SHORT).show();
                } else {
                    String ans;
                    if (TextUtils.isEmpty(for1_s.getText())){
                        double u = Double.parseDouble(for1_u.getText().toString());
                        double v = Double.parseDouble(for1_v.getText().toString());
                        double t = Double.parseDouble(for1_t.getText().toString());
                        ans = "" +( ( ( u + v ) * t ) / 2 );
                        for1_s.setText(ans);
                    } else if (TextUtils.isEmpty(for1_u.getText())){
                        double s = Double.parseDouble(for1_s.getText().toString());
                        double v = Double.parseDouble(for1_v.getText().toString());
                        double t = Double.parseDouble(for1_t.getText().toString());
                        if (t == 0){
                            Toast.makeText(getActivity(), "时间值(t)不能为“0”哦~",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            ans = "" + ( ( ( 2 * s ) / t ) - v);
                            for1_u.setText(ans);
                        }
                    } else if (TextUtils.isEmpty(for1_v.getText())){
                        double s = Double.parseDouble(for1_s.getText().toString());
                        double u = Double.parseDouble(for1_u.getText().toString());
                        double t = Double.parseDouble(for1_t.getText().toString());
                        if (t == 0){
                            Toast.makeText(getActivity(), "时间值(t)不能为“0”哦~",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            ans = "" + ( ( ( 2 * s ) / t ) - u);
                            for1_u.setText(ans);
                        }
                    } else if (TextUtils.isEmpty(for1_t.getText())){
                        double s = Double.parseDouble(for1_s.getText().toString());
                        double u = Double.parseDouble(for1_u.getText().toString());
                        double v = Double.parseDouble(for1_v.getText().toString());
                        if (u + v == 0){
                            Toast.makeText(getActivity(), "(u + v) 不能低于“0”哦~",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            ans = "" + ( ( 2 * s ) / ( u + v ) );
                            for1_t.setText(ans);
                        }
                    }
                }
            }
        });

        for2_v = view.findViewById(R.id.motion_for2_v);
        for2_u = view.findViewById(R.id.motion_for2_u);
        for2_a = view.findViewById(R.id.motion_for2_a);
        for2_t = view.findViewById(R.id.motion_for2_t);
        Button for2 = view.findViewById(R.id.mech_motion_for2);
        for2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(for2_v.getText()) && !TextUtils.isEmpty(for2_u.getText())
                        && !TextUtils.isEmpty(for2_a.getText()) && !TextUtils.isEmpty(for2_t.getText())){
                    Toast.makeText(getActivity(), "数据给多了，我不知道该算哪个~",
                            Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(for2_v.getText()) && TextUtils.isEmpty(for2_u.getText())
                        && TextUtils.isEmpty(for2_a.getText()) && TextUtils.isEmpty(for2_t.getText())){
                    Toast.makeText(getActivity(), "你木有输入数据哦~", Toast.LENGTH_SHORT).show();
                } else if ((TextUtils.isEmpty(for2_v.getText()) && TextUtils.isEmpty(for2_u.getText())
                        && TextUtils.isEmpty(for2_a.getText()))
                        || (TextUtils.isEmpty(for2_v.getText())&& TextUtils.isEmpty(for2_u.getText())
                        && TextUtils.isEmpty(for2_t.getText()))
                        || (TextUtils.isEmpty(for2_v.getText()) && TextUtils.isEmpty(for2_a.getText())
                        && TextUtils.isEmpty(for2_t.getText()))
                        || (TextUtils.isEmpty(for2_u.getText()) && TextUtils.isEmpty(for2_a.getText())
                        && TextUtils.isEmpty(for2_t.getText()))){
                    Toast.makeText(getActivity(), "你输入的数据不够哦~",
                            Toast.LENGTH_SHORT).show();
                } else if ((TextUtils.isEmpty(for2_v.getText()) && TextUtils.isEmpty(for2_u.getText()))
                        || (TextUtils.isEmpty(for2_v.getText()) && TextUtils.isEmpty(for2_a.getText()))
                        || (TextUtils.isEmpty(for2_v.getText()) && TextUtils.isEmpty(for2_t.getText()))
                        || (TextUtils.isEmpty(for2_u.getText()) && TextUtils.isEmpty(for2_a.getText()))
                        || (TextUtils.isEmpty(for2_u.getText()) && TextUtils.isEmpty(for2_t.getText()))
                        || (TextUtils.isEmpty(for2_a.getText()) && TextUtils.isEmpty(for2_t.getText()))){
                    Toast.makeText(getActivity(), "你输入的数据不够哦~",
                            Toast.LENGTH_SHORT).show();
                } else {
                    String ans;
                    if (TextUtils.isEmpty(for2_v.getText())){
                        double u = Double.parseDouble(for2_u.getText().toString());
                        double a = Double.parseDouble(for2_a.getText().toString());
                        double t = Double.parseDouble(for2_t.getText().toString());
                        ans = "" + (u + (a * t));
                        for2_v.setText(ans);
                    } else if (TextUtils.isEmpty(for2_u.getText())){
                        double v = Double.parseDouble(for2_v.getText().toString());
                        double a = Double.parseDouble(for2_a.getText().toString());
                        double t = Double.parseDouble(for2_t.getText().toString());
                        ans = "" + (v - (a * t));
                    } else if (TextUtils.isEmpty(for2_a.getText())){
                        double v = Double.parseDouble(for2_v.getText().toString());
                        double u = Double.parseDouble(for2_u.getText().toString());
                        double t = Double.parseDouble(for2_t.getText().toString());
                        if (t == 0){
                            Toast.makeText(getActivity(), "时间值(t)不能为“0”哦~",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            ans = "" + ((v - u) / t);
                            for2_a.setText(ans);
                        }
                    } else if (TextUtils.isEmpty(for2_t.getText())) {
                        double v = Double.parseDouble(for2_v.getText().toString());
                        double u = Double.parseDouble(for2_u.getText().toString());
                        double a = Double.parseDouble(for2_a.getText().toString());
                        if (a == 0) {
                            Toast.makeText(getActivity(), "加速值(a)不能为“0”哦~", Toast.LENGTH_SHORT).show();
                        } else {
                            ans = "" + ((v - u) / a);
                            for2_t.setText(ans);
                        }
                    }
                }
            }
        });

        for3_v = view.findViewById(R.id.motion_for3_v);
        for3_u = view.findViewById(R.id.motion_for3_u);
        for3_a = view.findViewById(R.id.motion_for3_a);
        for3_s = view.findViewById(R.id.motion_for3_s);
        Button for3 = view.findViewById(R.id.mech_motion_for3);
        for3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(for3_v.getText()) && !TextUtils.isEmpty(for3_u.getText())
                        && !TextUtils.isEmpty(for3_a.getText()) && !TextUtils.isEmpty(for3_s.getText())){
                    Toast.makeText(getActivity(), "数据给多了，我不知道该算哪个~",
                            Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(for3_v.getText()) && TextUtils.isEmpty(for3_u.getText())
                        && TextUtils.isEmpty(for3_a.getText()) && TextUtils.isEmpty(for3_s.getText())){
                    Toast.makeText(getActivity(), "你木有输入数据哦~", Toast.LENGTH_SHORT).show();
                } else if ((TextUtils.isEmpty(for3_v.getText()) && TextUtils.isEmpty(for2_u.getText())
                        && TextUtils.isEmpty(for3_a.getText()))
                        || (TextUtils.isEmpty(for3_v.getText())&& TextUtils.isEmpty(for3_u.getText())
                        && TextUtils.isEmpty(for3_s.getText()))
                        || (TextUtils.isEmpty(for3_v.getText()) && TextUtils.isEmpty(for3_a.getText())
                        && TextUtils.isEmpty(for3_s.getText()))
                        || (TextUtils.isEmpty(for3_u.getText()) && TextUtils.isEmpty(for3_a.getText())
                        && TextUtils.isEmpty(for3_s.getText()))){
                    Toast.makeText(getActivity(), "你输入的数据不够哦~",
                            Toast.LENGTH_SHORT).show();
                } else if ((TextUtils.isEmpty(for3_v.getText()) && TextUtils.isEmpty(for3_u.getText()))
                        || (TextUtils.isEmpty(for3_v.getText()) && TextUtils.isEmpty(for3_a.getText()))
                        || (TextUtils.isEmpty(for3_v.getText()) && TextUtils.isEmpty(for3_s.getText()))
                        || (TextUtils.isEmpty(for3_u.getText()) && TextUtils.isEmpty(for3_a.getText()))
                        || (TextUtils.isEmpty(for3_u.getText()) && TextUtils.isEmpty(for3_s.getText()))
                        || (TextUtils.isEmpty(for3_a.getText()) && TextUtils.isEmpty(for3_s.getText()))){
                    Toast.makeText(getActivity(), "你输入的数据不够哦~",
                            Toast.LENGTH_SHORT).show();
                } else {
                    String ans;
                    if (TextUtils.isEmpty(for3_v.getText())){
                        double u = Double.parseDouble(for3_u.getText().toString());
                        double a = Double.parseDouble(for3_a.getText().toString());
                        double s = Double.parseDouble(for3_s.getText().toString());
                        if ((2 * a * s) + square(u) < 0){
                            Toast.makeText(getActivity(), "(2 * a * s) + u²不能为负数哦~",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            ans = "" + (Math.sqrt((2 * a * s) + square(u)));
                            for3_v.setText(ans);
                        }
                    } else if (TextUtils.isEmpty(for3_u.getText())){
                        double v = Double.parseDouble(for3_v.getText().toString());
                        double a = Double.parseDouble(for3_a.getText().toString());
                        double s = Double.parseDouble(for3_s.getText().toString());
                        if (square(v) - (2 * a * s) < 0){
                            Toast.makeText(getActivity(), "v² - (2 * a * s)不能为负数哦~",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            ans = "" + (Math.sqrt(square(v) - (2 * a * s)));
                            for3_u.setText(ans);
                        }
                    } else if (TextUtils.isEmpty(for3_a.getText())){
                        double v = Double.parseDouble(for3_v.getText().toString());
                        double u = Double.parseDouble(for3_u.getText().toString());
                        double s = Double.parseDouble(for3_s.getText().toString());
                        if (s == 0){
                            Toast.makeText(getActivity(), "距离值(s)不能为“0”哦~",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            ans = "" + ((square(v) - square(u)) / (2 * s));
                            for3_a.setText(ans);
                        }
                    } else {
                        double v = Double.parseDouble(for3_v.getText().toString());
                        double u = Double.parseDouble(for3_u.getText().toString());
                        double a = Double.parseDouble(for3_a.getText().toString());
                        if (a == 0){
                            Toast.makeText(getActivity(), "加速值(a)不能为“0”哦~",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            ans = "" + ((square(v) - square(u)) / (2 * a));
                            for3_s.setText(ans);
                        }

                    }
                }
            }
        });
    }

    public double square(double no){
        return (no * no);
    }
}
