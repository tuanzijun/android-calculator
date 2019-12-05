package com.example.calculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.calculator.converter.*;

public class change_activity extends AppCompatActivity {

    private AlertDialog alertDialog_change;
    private AlertDialog alertDialog_danwei;
    private AlertDialog alertDialog_result;
    private int flag = 0; //0：不选择 1：长度换算； 2：面积换算；3: 体积转换 4：进制转换
    private EditText number;
    private TextView result;
    private String str_dw1 = "",str_dw2 = "";

    private Button btu_1;
    private Button btu_2;
    private Button btu_3;
    private Button btu_result;

    final  String[] items1 = {"km","m","dm","cm","mm"};
    final String[] items2 = {"km2","m2","dm2","cm2"};
    final String[] items3 = {"十六进制","八进制","二进制"};
    final String[] items4 = {"L","m3","dm3","cm3","mL"};
    final String[] items5 = {"十进制"};
    private static final String ACTIVITY_TAG="LogDemo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change);
        init();
        btu_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change();
            }

        });
    }

    public void init(){
        btu_1 = (Button)findViewById(R.id.title1);
        btu_2 = (Button)findViewById(R.id.danwei);
        btu_3 = (Button)findViewById(R.id.dw);
        number = (EditText)findViewById(R.id.change_1);
        result = (TextView)findViewById(R.id.change_result);
        btu_result = (Button)findViewById(R.id.choose_result);
    }

    public void showList(View view){
        final  String[] items = {"长度","面积","进制转换","体积转换"};
        AlertDialog.Builder alert_builder = new AlertDialog.Builder(this);
        alert_builder.setTitle("请选择换算单位");
        alert_builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                flag = i+1;
                btu_1.setText(items[i]);
            }
        });

        alertDialog_change = alert_builder.create();
        alertDialog_change.show();
    }

    public void show_danwei(View view){
        AlertDialog.Builder alert_builder = new AlertDialog.Builder(this);
        alert_builder.setTitle("请选择换算单位");
        switch (flag){
            case 1:
                alert_builder.setItems(items1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        str_dw1 = items1[i];
                        btu_2.setText(items1[i]);
                    }
                });
                break;
            case 2:
                alert_builder.setItems(items2, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        str_dw1 = items2[i];
                        btu_2.setText(items2[i]);
                    }
                });
                break;
            case 3:
                alert_builder.setItems(items5, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        str_dw1 = items5[i];
                        btu_2.setText(items5[i]);
                    }
                });
                break;
            case 4:
                alert_builder.setItems(items4, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        str_dw1 = items4[i];
                        btu_2.setText(items4[i]);
                    }
                });
                break;
            default:
                break;
        }

        alertDialog_danwei = alert_builder.create();
        alertDialog_danwei.show();
    }
    public void show_result(View view){
        AlertDialog.Builder alert_builder = new AlertDialog.Builder(this);
        alert_builder.setTitle("请选择换算单位");
        switch (flag){
            case 1:
                alert_builder.setItems(items1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        str_dw2 = items1[i];
                        btu_3.setText(items1[i]);
                    }
                });
                break;
            case 2:
                alert_builder.setItems(items2, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        str_dw2 = items2[i];
                        btu_3.setText(items2[i]);
                    }
                });
                break;
            case 3:
                alert_builder.setItems(items3, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        str_dw2 = items3[i];
                        btu_3.setText(items3[i]);
                    }
                });
                break;
            case 4:
                alert_builder.setItems(items4, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        str_dw2 = items4[i];
                        btu_3.setText(items4[i]);
                    }
                });
                break;
            default:
                break;
        }
        alertDialog_danwei = alert_builder.create();
        alertDialog_danwei.show();
    }

    public void change(){
        String x = String.valueOf(number.getText());
        Log.d(ACTIVITY_TAG,x);
try{
            double num = Double.valueOf(x);
            switch (flag){
                case 1:
                    Log.d(ACTIVITY_TAG,str_dw1+str_dw2);
                    UnitValue unitValue1 = UnitConverter.convert("a",str_dw1,str_dw2,num);
                    result.setText(unitValue1.toString());
//                    result.setText(x);
                    break;
                case 2:
                    UnitValue unitValue2 = UnitConverter.convert("b",str_dw1,str_dw2,num);
                    result.setText(unitValue2.toString());
                    break;
                case 3:
                    int n = Integer.parseInt(x);
                    if (str_dw2 == "二进制")
                        x = Integer.toBinaryString(n);
                    else if(str_dw2 == "八进制")
                        x = Integer.toOctalString(n);
                    else if(str_dw2 == "十六进制")
                        x = Integer.toHexString(n);
                    result.setText(x+"("+str_dw2+")");
                    break;
                case 4:
                    UnitValue unitValue3 = UnitConverter.convert("c",str_dw1,str_dw2,num);
                    result.setText(unitValue3.toString());
                    break;
                default:
                    break;
            }
        }catch (Exception e){
            result.setText("我不知道你在输什么");
        }
    }
    public static boolean isNumeric(String str){
        for (int i = str.length();--i>=0;){
            if ((!Character.isDigit(str.charAt(i)))||str.charAt(i) != '.'){
                return false;
            }
        }
        return true;
    }

}
