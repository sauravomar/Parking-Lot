package com.parking.lot.entities;

import com.parking.lot.constant.ResponseUtil;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
	private String regNo;
	private String colour;

	public String status() {
		return String.format(ResponseUtil.VEHICLE_STATUS, regNo, colour);
	}
}
