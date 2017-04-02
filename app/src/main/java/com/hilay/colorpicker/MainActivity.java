package com.hilay.colorpicker;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, TextWatcher, View.OnFocusChangeListener {

    private SeekBar sbRed, sbGreen, sbBlue;
    private int r = 0, g = 0, b = 0;
    private boolean isChanging = false;
    private EditText etRed, etGreen, etBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sbRed = (SeekBar) findViewById(R.id.sbRed);
        sbGreen = (SeekBar) findViewById(R.id.sbGreen);
        sbBlue = (SeekBar) findViewById(R.id.sbBlue);

        sbRed.setOnSeekBarChangeListener(this);
        sbGreen.setOnSeekBarChangeListener(this);
        sbBlue.setOnSeekBarChangeListener(this);

        etRed = (EditText) findViewById(R.id.etRed);
        etGreen = (EditText) findViewById(R.id.etGreen);
        etBlue = (EditText) findViewById(R.id.etBlue);

        etRed.addTextChangedListener(this);
        etGreen.addTextChangedListener(this);
        etBlue.addTextChangedListener(this);

        etRed.setOnFocusChangeListener(this);
        etGreen.setOnFocusChangeListener(this);
        etBlue.setOnFocusChangeListener(this);

    }

    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        try {
            if (isChanging) {
                TextView tvColor = (TextView) findViewById(R.id.tvColor);
                r = sbRed.getProgress();
                etRed.setText(String.valueOf(r));
                g = sbGreen.getProgress();
                etGreen.setText(String.valueOf(g));
                b = sbBlue.getProgress();
                etBlue.setText(String.valueOf(b));
                tvColor.setText("#" + (Integer.toHexString(Color.rgb(r, g, b))));
                tvColor.setBackgroundColor(Color.rgb(r, g, b));
            }
        } catch (Exception e) {

        }
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        isChanging = true;
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        isChanging = false;
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        try {
            if (!isChanging) {
                sbRed.setProgress(Integer.parseInt(etRed.getText().toString()));
                sbGreen.setProgress(Integer.parseInt(etGreen.getText().toString()));
                sbBlue.setProgress(Integer.parseInt(etBlue.getText().toString()));
                TextView tvColor = (TextView) findViewById(R.id.tvColor);
                r = sbRed.getProgress();
                g = sbGreen.getProgress();
                b = sbBlue.getProgress();
                tvColor.setText("#" + (Integer.toHexString(Color.rgb(r, g, b))));
                tvColor.setBackgroundColor(Color.rgb(r, g, b));
            }
        } catch (NumberFormatException e) {

        }
    }


    @Override
    public void onFocusChange(View v, boolean hasFocus) {
//        try {
//            if (!isChanging) {
//                sbRed.setProgress(Integer.parseInt(etRed.getText().toString()));
//                sbGreen.setProgress(Integer.parseInt(etGreen.getText().toString()));
//                sbBlue.setProgress(Integer.parseInt(etBlue.getText().toString()));
//                TextView tvColor = (TextView) findViewById(R.id.tvColor);
//                r = sbRed.getProgress();
//                g = sbGreen.getProgress();
//                b = sbBlue.getProgress();
//                tvColor.setText("#" + (Integer.toHexString(Color.rgb(r, g, b))));
//                tvColor.setBackgroundColor(Color.rgb(r, g, b));
//            }
//        } catch (NumberFormatException e) {
//
//        }
    }
}