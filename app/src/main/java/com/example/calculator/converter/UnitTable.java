package com.example.calculator.converter;
import java.util.HashMap;
import java.util.Map;

public class UnitTable {
	private UnitTable(){}
	private static Map<String,Map<String,Double>> unitTable = new HashMap<>();
	
	/**
	 * 长度单位，以m为基准单位，指定单位换算表
	 */
	private static Map<String, Double> lengthUnitMap = new HashMap<>();
	/**
	 * 面积单位，以m2为基准单位，指定单位换算表
	 */
	private static Map<String, Double> areaUnitMap = new HashMap<>();
	/**
	 * 体积单位，容积单位，以 m3（立方米）为基准单位，指定单位换算表
	 */
	private static Map<String, Double> volumeUnitMap = new HashMap<>();

	private static Map<String,Double>  stringUnitMap = new HashMap<>();
	
	static {
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

		stringUnitMap.put("二进制",2.0);
		stringUnitMap.put("八进制",8.0);
		stringUnitMap.put("十进制",10.0);
		stringUnitMap.put("十六进制",16.0);
		
		unitTable.put("a", lengthUnitMap);
		unitTable.put("b", areaUnitMap);
		unitTable.put("c", volumeUnitMap);
		unitTable.put("d",stringUnitMap);
	}
	
	public static Map<String,Double> getUnitTable(String unitname){
		return unitTable.get(unitname);
	}
}
