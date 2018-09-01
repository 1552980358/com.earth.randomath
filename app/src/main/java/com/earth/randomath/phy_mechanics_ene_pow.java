package com.earth.randomath;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.*;
import android.widget.*;

public class phy_mechanics_ene_pow extends Fragment{

    // Kinetic energy
    private EditText ke_ke;
    private EditText ke_m;
    private EditText ke_v;

    private EditText pe_pe;
    private EditText pe_m;
    private EditText pe_g;
    private EditText pe_h;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fra_phy_mechanics_ene_pow,container,false);
    }

    @Override
    public void onViewCreated(View view , Bundle savedInstanceState){
        super.onViewCreated(view , savedInstanceState);

        ke_ke = view.findViewById(R.id.energy_ke);
        ke_m = view.findViewById(R.id.energy_ke_m);
        ke_v = view.findViewById(R.id.energy_ke_sqv);
        Button ke = view.findViewById(R.id.mech_ene_ke);
        ke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(ke_ke.getText())
                        && !TextUtils.isEmpty(ke_m.getText())
                        && !TextUtils.isEmpty(ke_v.getText())){
                    Toast.makeText(getActivity(), "数据给多了，我不知道该算哪个~",
                            Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(ke_ke.getText())
                        && TextUtils.isEmpty(ke_m.getText())
                        && TextUtils.isEmpty(ke_v.getText())){
                    Toast.makeText(getActivity(), "你木有输入数据哦~",
                            Toast.LENGTH_SHORT).show();
                } else if ((TextUtils.isEmpty(ke_ke.getText()) && TextUtils.isEmpty(ke_m.getText()))
                        || (TextUtils.isEmpty(ke_ke.getText()) && TextUtils.isEmpty(ke_v.getText()))
                        || (TextUtils.isEmpty(ke_m.getText()) && TextUtils.isEmpty(ke_v.getText()))){
                    Toast.makeText(getActivity(), "你输入的数据不够哦~",
                            Toast.LENGTH_SHORT).show();
                } else {
                    String ans;
                    if (TextUtils.isEmpty(ke_ke.getText())){
                        double m = Double.parseDouble(ke_m.getText().toString());
                        double v = Double.parseDouble(ke_v.getText().toString());
                        ans = "" + ( ( m * square(v)) / 2);
                        ke_ke.setText(ans);
                    } else if (TextUtils.isEmpty(ke_m.getText())){
                        double ke = Double.parseDouble(ke_ke.getText().toString());
                        double v = Double.parseDouble(ke_v.getText().toString());
                        if (v == 0){
                            Toast.makeText(getActivity(), "速率值(v)不能为“0”哦~", Toast.LENGTH_SHORT).show();
                        } else {
                            ans = "" + ((ke * 2) / square(v));
                            ke_ke.setText(ans);
                        }
                    } else if (TextUtils.isEmpty(ke_v.getText())){
                        double ke = Double.parseDouble(ke_ke.getText().toString());
                        double m = Double.parseDouble(ke_m.getText().toString());
                        if (m == 0){
                            Toast.makeText(getActivity(), "质量值(m)不能为“0”哦",
                                    Toast.LENGTH_SHORT).show();
                        } else if ( ( ( 2 * ke ) / m ) < 0) {
                            Toast.makeText(getActivity(), "((2 * ke) / m) 不能低于“0”哦~",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            ans = "" + Math.sqrt(2 * ke / m);
                            ke_v.setText(ans);
                        }
                    }
                }
            }
        });



        pe_pe = view.findViewById(R.id.energy_pe_pe);
        pe_m = view.findViewById(R.id.energy_pe_m);
        pe_h = view.findViewById(R.id.energy_pe_h);
        pe_g = view.findViewById(R.id.energy_pe_g);
        Button pe = view.findViewById(R.id.mech_ene_pe);
        pe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double g;
                if (TextUtils.isEmpty(pe_g.getText())){
                    g = 9.81;
                } else {
                    g = Double.parseDouble(pe_g.getText().toString());
                }

                if (!TextUtils.isEmpty(pe_pe.getText())
                        && !TextUtils.isEmpty(pe_m.getText())
                        && !TextUtils.isEmpty(pe_h.getText())){
                    Toast.makeText(getActivity(), "数据给多了，我不知道该算哪一个~", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(pe_pe.getText())
                        && TextUtils.isEmpty(pe_m.getText())
                        && TextUtils.isEmpty(pe_h.getText())){
                    Toast.makeText(getActivity(), "你木有输入数据哦~", Toast.LENGTH_SHORT).show();
                } else if ((TextUtils.isEmpty(pe_pe.getText()) && TextUtils.isEmpty(pe_m.getText()))
                        || (TextUtils.isEmpty(pe_pe.getText()) && TextUtils.isEmpty(pe_h.getText()))
                        || (TextUtils.isEmpty(pe_m.getText()) && TextUtils.isEmpty(pe_h.getText()))){
                    Toast.makeText(getActivity(), "你输入的数据不够哦~",
                            Toast.LENGTH_SHORT).show();
                } else {
                    String ans;
                    if (TextUtils.isEmpty(pe_pe.getText())){
                        double m = Double.parseDouble(pe_m.getText().toString());
                        double h = Double.parseDouble(pe_h.getText().toString());
                        ans = "" + ( m * g * h );
                        pe_pe.setText(ans);
                    } else if (TextUtils.isEmpty(pe_m.getText())){
                        double pe = Double.parseDouble(pe_pe.getText().toString());
                        double h = Double.parseDouble(pe_h.getText().toString());
                        if (h == 0){
                            Toast.makeText(getActivity(), "质量值(m)不能为“0”哦~",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            ans = "" + ( pe / ( g * h ) );
                            pe_m.setText(ans);
                        }
                    } else {
                        double pe = Double.parseDouble(pe_pe.getText().toString());
                        double m = Double.parseDouble(pe_m.getText().toString());
                        if (m == 0){
                            Toast.makeText(getActivity(), "高度值(h)不能为“0”哦~",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            ans = "" + ( pe / ( g * m ) );
                            pe_h.setText(ans);
                        }
                    }
                }
            }
        });
    }

    public double square(double no){
        return no * no;
    }
}
