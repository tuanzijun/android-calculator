package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btu_clear, btu_delete,btu_divide,btu_multiply,btu_add,btu_subtract;
    Button btu_result,btu_nine,btu_eight,btu_seven,btu_six,btu_five,btu_four;
    Button btu_three,btu_two, btu_one,btu_zero,btu_point,btu_sin,btu_cos,btu_right,btu_left;
    private TextView et_input;
    private StringBuilder pending = new StringBuilder();
    private StringBuilder showing = new StringBuilder();

    private void initView(){
        btu_clear = (Button) findViewById(R.id.clear);
        btu_delete = (Button) findViewById(R.id.delete);
        btu_divide = (Button) findViewById(R.id.chu);
        btu_multiply = (Button) findViewById(R.id.cheng);
        btu_add = (Button) findViewById(R.id.add);
        btu_subtract = (Button) findViewById(R.id.jian);
        btu_result = (Button) findViewById(R.id.result);
        btu_nine = (Button) findViewById(R.id.nine);
        btu_eight = (Button) findViewById(R.id.eight);
        btu_seven = (Button) findViewById(R.id.seven);
        btu_six = (Button) findViewById(R.id.six);
        btu_five = (Button) findViewById(R.id.five);
        btu_four = (Button) findViewById(R.id.four);
        btu_three = (Button) findViewById(R.id.three);
        btu_two = (Button) findViewById(R.id.two);
        btu_one = (Button) findViewById(R.id.one);
        btu_zero = (Button) findViewById(R.id.zore);
        btu_point = (Button) findViewById(R.id.point);
        btu_sin = (Button)findViewById(R.id.ss);
        btu_cos = (Button)findViewById(R.id.cc);
        btu_left = (Button)findViewById(R.id.a);
        btu_right = (Button)findViewById(R.id.b);
        et_input = (TextView)findViewById(R.id.ex_input) ;


        btu_add.setOnClickListener(this);
        btu_clear.setOnClickListener(this);
        btu_delete.setOnClickListener(this);
        btu_divide.setOnClickListener(this);
        btu_eight.setOnClickListener(this);
        btu_five.setOnClickListener(this);
        btu_four.setOnClickListener(this);
        btu_multiply.setOnClickListener(this);
        btu_nine.setOnClickListener(this);
        btu_one.setOnClickListener(this);
        btu_point.setOnClickListener(this);
        btu_result.setOnClickListener(this);
        btu_seven.setOnClickListener(this);
        btu_six.setOnClickListener(this);
        btu_subtract.setOnClickListener(this);
        btu_three.setOnClickListener(this);
        btu_two.setOnClickListener(this);
        btu_zero.setOnClickListener(this);
        btu_sin.setOnClickListener(this);
        btu_cos.setOnClickListener(this);
        btu_left.setOnClickListener(this);
        btu_right.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        int orientation = getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_LANDSCAPE)
            setContentView(R.layout.test);
        else if(orientation == Configuration.ORIENTATION_PORTRAIT)
            setContentView(R.layout.test);
        initView();
    }

    @Override
    public void onClick(View view) {
        int last = 0;

        if(pending.length()!=0){
            last = pending.codePointAt(pending.length()-1);
        }
        switch (view.getId()){
            case R.id.nine:
                pending.append("9");
                showing.append("9");
                et_input.setText(showing);
                break;
            case R.id.eight:
                pending.append("8");
                showing.append("8");
                et_input.setText(showing);
                break;
            case R.id.seven:
                pending.append("7");
                showing.append("7");
                et_input.setText(showing);
                break;
            case R.id.six:
                pending.append("6");
                showing.append("6");
                et_input.setText(showing);
                break;
            case R.id.five:
                pending.append("5");
                showing.append("5");
                et_input.setText(showing);
                break;
            case R.id.four:
                pending.append("4");
                showing.append("4");
                et_input.setText(showing);
                break;
            case R.id.three:
                pending.append("3");
                showing.append("3");
                et_input.setText(showing);
                break;
            case R.id.two:
                pending.append("2");
                showing.append("2");
                et_input.setText(showing);
                break;
            case R.id.one:
                pending.append("1");
                showing.append("1");
                et_input.setText(showing);
                break;
            case R.id.zore:
                pending.append("0");
                showing.append("0");
                et_input.setText(showing);
                break;
            case R.id.ss:
                pending.append("s");
                showing.append("sin");
                et_input.setText(showing);
                break;
            case R.id.cc:
                pending.append("c");
                showing.append("cos");
                et_input.setText(showing);
                break;
            case R.id.a:
                pending.append("(");
                showing.append("(");
                et_input.setText(showing);
                break;
            case R.id.b:
                pending.append(")");
                showing.append(")");
                et_input.setText(showing);
                break;
            case R.id.point:
                pending.append(".");
                showing.append(".");
                et_input.setText(showing);
                break;
            case R.id.delete:
                if(pending.length()==0)
                    break;
                pending.delete(pending.length()-1,pending.length());
                if(showing.charAt((showing.length()-1))=='n'||showing.charAt((showing.length()-1))=='s')
                    showing.delete(showing.length()-3,showing.length());
                else
                    showing.delete(showing.length()-1,showing.length());
                et_input.setText(showing);
                break;
            case R.id.clear:
                pending.delete(0,pending.length());
                showing.delete(0,showing.length());
                et_input.setText(showing);
                break;
            case R.id.add:
                if(last >= '0' && last <='9'||last == ')') {
                    pending.append("+");
                    showing.append("+");
                }
                et_input.setText(showing);
                break;
            case R.id.jian:
                if(last >= '0' && last <='9'||pending.length()==0||last == ')'){
                    showing.append("-");
                    pending.append("-");
                }
                et_input.setText(showing);
                break;
            case R.id.cheng:
                if(last >= '0' && last <='9'||last == ')'){
                    showing.append("*");
                    pending.append("*");}
                et_input.setText(showing);
                break;
            case R.id.chu:
                if(last >= '0' && last <='9'||last == ')'){
                    showing.append("/");
                    pending.append("/");}
                et_input.setText(showing);
                break;
            case R.id.result:
                if((pending.length()>1)) {
                    InfixInToDuffix fix = new InfixInToDuffix();
                    String jieguo;
                    try{
                        ArrayList a = fix.jisuan(pending);
                        jieguo = fix.dealEquation(a);
                    }catch (Exception ex){
                        jieguo="出错";
                    }
                    et_input.setText(showing+"="+jieguo);
                    pending = pending.delete(0,pending.length());
                    showing = showing.delete(0,showing.length());
                    if(Character.isDigit(jieguo.charAt(0))){
                        pending = pending.append(jieguo);
                        showing = showing.append(jieguo);
                    }

                }
                break;

            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.lever_up:
                Intent intent = new Intent(MainActivity.this, help.class);
                startActivity(intent);
                break;
            case R.id.exit:
                break;
            case R.id.change:
                Intent intent1 = new Intent(MainActivity.this,change_activity.class);
                startActivity(intent1);
                break;
            default:
        }
        return true;
    }
}
