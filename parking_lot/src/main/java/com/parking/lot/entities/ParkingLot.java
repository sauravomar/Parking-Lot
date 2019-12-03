package com.parking.lot.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingLot {
    
	private String name;
	private VehicleSlot slots[];
	private int occupied;
	
	public int getOccupiedPercent() {
		return ((occupied/slots.length) * 100);
	}
}
