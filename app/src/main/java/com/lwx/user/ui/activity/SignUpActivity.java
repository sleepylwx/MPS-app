package com.lwx.user.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kelin.scrollablepanel.library.ScrollablePanel;
import com.lwx.user.R;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends AppCompatActivity{


    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.one) EditText one;
    @BindView(R.id.two) EditText two;
    @BindView(R.id.three) EditText three;
    @BindView(R.id.four) EditText four;
    @BindView(R.id.five) EditText five;

    @BindView(R.id.six) EditText six;

    @BindView(R.id.seven) EditText seven;

    @BindView(R.id.eight) EditText eight;

    @BindView(R.id.nine) EditText nine;

    @BindView(R.id.ten) EditText ten;
    @BindView(R.id.eleven) EditText eleven;

    @BindView(R.id.twelve) EditText twelve;

    @BindView(R.id.thirteen)EditText thirteen;

    @BindView(R.id.submit) Button submit;



    @OnClick(R.id.submit)
    public void onClick(){

        String oneS = one.getText().toString();
        String twoS = two.getText().toString();
        String threeS = three.getText().toString();
        String fourS = four.getText().toString();
        String fiveS = five.getText().toString();
        String sixS = six.getText().toString();
        String sevenS = seven.getText().toString();
        String eightS = eight.getText().toString();
        String nineS = nine.getText().toString();
        String tenS = ten.getText().toString();
        String elevenS = eleven.getText().toString();
        String twelveS = twelve.getText().toString();
        String thirteenS = thirteen.getText().toString();

        if(oneS.isEmpty() || twoS.isEmpty() || threeS.isEmpty()
                || fourS.isEmpty() || fiveS.isEmpty() || sixS.isEmpty()
                || sevenS.isEmpty() || eightS.isEmpty() ||
                nineS.isEmpty() || tenS.isEmpty() || elevenS.isEmpty()
                || twelveS.isEmpty() || thirteenS.isEmpty()){

            Toast.makeText(this,"存在空字段！",Toast.LENGTH_SHORT).show();
            return;
        }

        if(elevenS.length() != 8){

            Toast.makeText(this,"日期格式有误！",Toast.LENGTH_SHORT).show();
            return;
        }
        try{

            double temp = Double.parseDouble(eightS);
            if(temp > 1){

                Toast.makeText(this,"成品率须为不大于1的数!",Toast.LENGTH_SHORT).show();
                return;
            }
        }
        catch (Exception e){

            Toast.makeText(this,"成品率须为不大于1的数!",Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this,MPSAcitvity.class);
        intent.putExtra("first",oneS);
        intent.putExtra("second",twoS);
        intent.putExtra("third",threeS);
        intent.putExtra("fourth",fourS);
        intent.putExtra("fifth",fiveS);
        intent.putExtra("sixth",sixS);
        intent.putExtra("seventh",sevenS);
        intent.putExtra("eighth",eightS);
        intent.putExtra("nineth",nineS);
        intent.putExtra("tenth",tenS);
        intent.putExtra("eleventh",elevenS);
        intent.putExtra("twelveh",twelveS);
        intent.putExtra("thirteen",thirteenS);
        startActivity(intent);
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);


        init();




    }

    @Override
    protected void onDestroy(){

        super.onDestroy();

    }

    private void init(){

        initToolbar();

    }

    private void initToolbar(){

        toolbar.setTitle("MPS");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v->finish());

    }




}
