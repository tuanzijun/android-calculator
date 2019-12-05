# 简易计算器
**页面简约的传统计算器，功能包括**
* **加减乘除**
* **带有括号运算，连续运算**
* **三角函数运算（sin，cos）**
* **单位转换（长度，面积，体积）**
* **进制转换（十进制->二进制，八进制，十六进制**

#### 界面设计（横屏 & 竖屏 ）

- 计算器页面

![竖屏](D:/picture/android/calc1.jpg)

![横屏](D:/picture/android/calc2.jpg)

按钮布局——GridLayout

```
    <GridLayout
        android:orientation="horizontal"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:rowCount="6"
        android:columnCount="4">
```
>  **常用到的属性:**
> 1. 设置排列对齐
    <br>orientation=""(vertical,horizontal)
> 2. 设置几行几列
    <br>行数 rowCount
    <br>列数 columnCount
> 3. 设置组件所在的行列
    <br>几行 layout_row
    <br>几列 layout_column
> 4. 设置组件横跨几行几列
    <br>横跨几行 layout_rowSpan
    <br>横跨几列 columnSpan

- 单位转换

![单位转换](D:/picture/android/calc3.jpg)
> 采取AlertDialog.Builder的方式来选择转换的单位<br>
> 用一个变量flag表示 选择的转换单位
（0：不选择 1：长度换算； 2：面积换算；3: 体积转换 4：进制转换）

#### 功能的实现

- 运算

无论是简单的四则运算还是带有三角函数的运算采取的都是后缀表达式的方式进行运算。

> 将输入结果链表根据优先级法则转换成后缀表达式<br>
> 再进行后缀运算，得到结果


优先级顺序:

sin/cos | ( | * / | + - | ) 
---|---|---|---|---|

加减乘除以及三角函数运算

```
 //加法
 BigDecimal a = new BigDecimal(list.remove(size-2)).add(new BigDecimal(list.remove(size-2)));
 //sin函数
 Double e = new Double(list.remove(size-1));
 e = Math.sin(e);
```

- 单位转换

包括长度、面积、体积单位的转换。
> 建立一张表(HashMap) 存长度、面积、体积单位<br>
> 二级表下存各个单位详细转换

```
lengthUnitMap.put("mm", 0.001);
lengthUnitMap.put("cm", 0.01);
lengthUnitMap.put("dm", 0.1);
lengthUnitMap.put("m", 1.0);
lengthUnitMap.put("km", 1000.0);
		
areaUnitMap.put("km2", 1000000.0);
areaUnitMap.put("m2", 1.0);
areaUnitMap.put("dm2", 0.01);
areaUnitMap.put("cm2", 0.0001);
		
volumeUnitMap.put("cm3", 0.000001);
volumeUnitMap.put("dm3", 0.001);
volumeUnitMap.put("m3", 1.0);
volumeUnitMap.put("立方米", 1.0);
volumeUnitMap.put("L", 0.001);
volumeUnitMap.put("mL", 0.000001);
```
> 一个结构体（单位，数值）<br>
> 通过获取

- 进制转换

实现十进制向二进制，八进制，十六进制的转换


```
int n = Integer.parseInt(x);
if (str_dw2 == "二进制")
    x = Integer.toBinaryString(n);
else if(str_dw2 == "八进制")
    x = Integer.toOctalString(n);
else if(str_dw2 == "十六进制")
    x = Integer.toHexString(n);
```