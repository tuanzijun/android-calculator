package com.example.calculator.converter;

import android.content.Intent;
import android.util.Log;

import java.util.Map;

public class UnitConverter {
	private static final String ACTIVITY_TAG="LogDemo";
	/**
	 * 单位是否存在
	 * @param physicalName
	 * @param unitname
	 * @return
	 */
	public static boolean exist(String physicalName,String unitname) {
		Map<String, Double> unitTable = UnitTable.getUnitTable(physicalName);
		return unitTable.containsKey(unitname);
	}
	
	/**
	 * 单位转换
	 * @param physicalName
	 * @param from
	 * @param to
	 * @param value
	 * @return
	 */
	public static UnitValue convert(String physicalName,String from, String to, Double value) {
		Map<String, Double> unitTable = UnitTable.getUnitTable(physicalName);

		Double fromValue = unitTable.get(from);
		Double toValue = unitTable.get(to);
		UnitValue unitValue = new UnitValue();
		if(fromValue!=null || fromValue!=null) {
			if(physicalName == "d"){
				int values = Integer.parseInt(value.toString());
				switch (toValue.toString()){
					case "2.0":
//						values = Integer.toBinaryString(values);
						break;
				}
			}
			else {
				value = value * fromValue;
				value = value / toValue;
				Log.d(ACTIVITY_TAG, value.toString());
				unitValue.setValue(value);
				unitValue.setUnit(to);
			}
		}
		else{
			return null;
		}
//		UnitValue unitValue = new UnitValue(value,to);

		return unitValue;
	}
}
