package com.parking.lot.model;

import com.parking.lot.util.ResponseUtil;

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.ToString
@lombok.AllArgsConstructor

public class Car {
	private String regNo;
	private String colour;
	
	public String carStatus() {		
		return String.format(ResponseUtil.STATUS_BODY_CAR, regNo, colour);
	}
	
	public boolean matchColor(String color) {
		return color.equals(this.colour)?true:false;
	}
	
	public boolean matchRegNo(String regNo) {
		return regNo.equals(this.regNo)?true:false;
	}
	
}
