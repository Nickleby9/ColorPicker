package com.hilay.colorpicker;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ColorFragment extends Fragment {

    private static final java.lang.String ARG_COLOR_TEXT_R = "colorTextR";
    private static final java.lang.String ARG_COLOR_TEXT_G = "colorTextG";
    private static final java.lang.String ARG_COLOR_TEXT_B = "colorTextB";
    TextView tvColor;
    String colorTextR, colorTextG, colorTextB;

    public ColorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_color, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        colorTextR = getArguments().getString(ARG_COLOR_TEXT_R);
        colorTextG = getArguments().getString(ARG_COLOR_TEXT_G);
        colorTextB = getArguments().getString(ARG_COLOR_TEXT_B);
        int color = Color.rgb(Integer.valueOf(colorTextR),Integer.valueOf(colorTextG),Integer.valueOf(colorTextB));

        tvColor = (TextView) view.findViewById(R.id.tvColor);
        tvColor.setBackgroundColor(color);


    }

    public static ColorFragment newInstance(String colorTextR, String colorTextG, String colorTextB) {

        Bundle args = new Bundle();
        args.getString(ARG_COLOR_TEXT_R, colorTextR);
        args.getString(ARG_COLOR_TEXT_G, colorTextG);
        args.getString(ARG_COLOR_TEXT_B, colorTextB);
        ColorFragment fragment = new ColorFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
