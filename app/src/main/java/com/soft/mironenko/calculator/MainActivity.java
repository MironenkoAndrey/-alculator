package com.soft.mironenko.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by romanmarshchakin on 21.04.17.
 */

public class MainActivity extends Activity {
    private TextView txtScreen;
    private Button btnFirst;
    private Button btnSecond;
    private Button btnThird;
    private Button btnFourth;
    private Button btnFifth;
    private Button btnSix;
    private Button btnSeven;
    private Button btnEight;
    private Button btnNinth;
    private Button btnZero;
    private Button btnRemove;
    private Button btnPlus;
    private Button btnMinus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtScreen = (TextView) findViewById(R.id.txt_screen);
        btnFirst = (Button) findViewById(R.id.button1);
        btnSecond = (Button) findViewById(R.id.button2);
        btnThird = (Button) findViewById(R.id.button3);
        btnFourth = (Button) findViewById(R.id.button4);
        btnFifth = (Button) findViewById(R.id.button5);
        btnSix = (Button) findViewById(R.id.button6);
        btnSeven = (Button) findViewById(R.id.button7);
        btnEight = (Button) findViewById(R.id.button8);
        btnNinth = (Button) findViewById(R.id.button9);
        btnZero = (Button) findViewById(R.id.button0);
        btnRemove = (Button) findViewById(R.id.buttonRemove);
        btnPlus = (Button) findViewById(R.id.buttonPlus);
        btnMinus = (Button) findViewById(R.id.buttonMinus);

        initButtonClickListener(btnFirst, "1");
        initButtonClickListener(btnSecond, "2");
        initButtonClickListener(btnThird, "3");
        initButtonClickListener(btnFourth, "4");
        initButtonClickListener(btnFifth, "5");
        initButtonClickListener(btnSix, "6");
        initButtonClickListener(btnSeven, "7");
        initButtonClickListener(btnEight, "8");
        initButtonClickListener(btnNinth, "9");
        initButtonClickListener(btnZero, "0");
        initButtonClickListener(btnPlus, "+");
        initButtonClickListener(btnMinus, "-");


        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String removedText = (String) txtScreen.getText();
                if(removedText.length() > 0) {
                    removedText = removedText.substring(0, removedText.length() - 1);
                }
                txtScreen.setText(removedText);
            }
        });
    }

    private void initButtonClickListener(Button btn, final String txt) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtScreen.setText(txtScreen.getText() + txt);
            }
        });
    }
}
