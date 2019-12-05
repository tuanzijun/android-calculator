package com.example.calculator;
import android.util.Log;

import java.lang.*;
import java.math.*;
import java.util.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InfixInToDuffix {

    private static final Map<Character,Integer> basic =new HashMap<Character, Integer>();
    private static final String TAG = "RightFragment";
    static {
        basic.put('-',1);
        basic.put('+', 1);
        basic.put('*', 2);
        basic.put('/', 2);
        basic.put('s',3);
        basic.put('c',3);
        basic.put('(', 0);//在运算中  （）的优先级最高，但是此处因程序中需要 故设置为0
    }
    public ArrayList jisuan(StringBuilder pending){

        ArrayList<String> number = new ArrayList<>();   //存储后缀运算
        List<Character> ysf = new ArrayList<>();    //存储运算符
        char[] charArr = pending.substring(0,pending.length()).trim().toCharArray();

        char ch = '^';
        String stack = "+-*/()sc";    //存储运算符字符串
        int len = 0;    //记录字符串长度

        for(int i = 0;i < charArr.length;i++){

            ch = charArr[i];

            if(Character.isDigit(ch))   //如果字符为数字，运算数长度++
                len++;

            else if(ch == '.')      //如果是小数点，算在运算数长度内
                len++;

            else if(stack.indexOf(ch)!=-1){     //如果匹配运算符

                if(len>0){
                    number.add(String.valueOf(Arrays.copyOfRange(charArr,i-len,i)));
                    len = 0;
                }

                if(ch == '('){  //如果运算符为（ 直接压入栈内
                    ysf.add(ch);
                    continue;
                }

                if(!ysf.isEmpty()){     //如果运算符栈不为空
                    int size= ysf.size()-1;
                    boolean flag = false;
                    while (size > 0 && ch ==')'&& ysf.get(size)!='('){
                        number.add(String.valueOf(ysf.remove(size)));
                        size--;
                        flag =true;
                    }

                    if(ch==')'&&ysf.get(size)=='(')
                        flag = true;

                    while(size >= 0&&!flag&&basic.get(ysf.get(size))>=basic.get(ch)){
                        number.add(String.valueOf(ysf.remove(size)));
                        size--;
                    }
                }
                if(ch!=')')
                    ysf.add(ch);
                else ysf.remove(ysf.size()-1);
            }

            if (i == charArr.length-1){
                if(len>0)
                    number.add(String.valueOf(Arrays.copyOfRange(charArr,i-len+1,i+1)));
                int size = ysf.size()-1;
                while(size >= 0){
                    number.add(String.valueOf(ysf.remove(size)));
                    size--;
                }
            }
        }
        //String a = number.toString();
        //Log.d(TAG,number.toString());
        return number;
    }
    // 进行运算
    public String dealEquation(ArrayList equation){
        int length = equation.size();
        String [] arr = new String[length];
        List<String> list = new ArrayList<String>();
        for(int i = 0;i < equation.size();i++){
            arr[i] = (String)equation.get(i);
        }
        for(String anArr:arr){
            int size = list.size();

            switch (anArr){
                case "+":
                    BigDecimal a = new BigDecimal(list.remove(size-2)).add(new BigDecimal(list.remove(size-2)));
                    list.add(a.stripTrailingZeros().toString());
                    break;
                case "-":
                    BigDecimal b = new BigDecimal(list.remove(size-2)).subtract(new BigDecimal(list.remove(size-2)));
                    list.add(b.stripTrailingZeros().toString());
                    break;
                case "*":
                    BigDecimal c = new BigDecimal(list.remove(size-2)).multiply(new BigDecimal(list.remove(size-2)));
                    list.add(c.stripTrailingZeros().toString());
                    break;
                case "/":
                    BigDecimal d = new BigDecimal(list.remove(size-2)).divide(new BigDecimal(list.remove(size-2)));
                    list.add(d.stripTrailingZeros().toString());
                    break;
                case "s":
                    Double e = new Double(list.remove(size-1));
                    e = Math.sin(e);
                    list.add(e.toString());
                    break;
                case "c":
                    Double f = new Double(list.remove(size-1));
                    f = Math.cos(f);
                    list.add(f.toString());
                    break;

                    default:list.add(anArr);
                    break;
            }
        }
        if (list.size() == 1){
            if (list.get(0).length() < 30){
                BigDecimal bd = new BigDecimal(list.get(0));
                return bd.toPlainString();
            }
            else {
                double d = Double.valueOf(list.get(0));
                return String.valueOf(d);
            }
        }else {
            return "运算失败";
        }
    }


}
