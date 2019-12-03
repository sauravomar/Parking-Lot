package com.parking.lot.command;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.parking.lot.exception.ParkingLotException;
import com.parking.lot.service.ParkingLotSvc;

public class CreateParkingLotTest {

	private CreateParkingLot createParkingLot;

	@Before
	public void setup() {
		createParkingLot = new CreateParkingLot(new ParkingLotSvc());
	}

	@Test
	public void testSuccess() throws ParkingLotException {
		List<String> params = new ArrayList<>();
		int parkingLotSize = 6;
		params.add(Integer.toString(parkingLotSize));
		String respone = createParkingLot.execute(params);
		assertEquals("Created a parking lot with " + parkingLotSize + " slots", respone);
	}

	@Test
	public void testFailure(){
		List<String> params = new ArrayList<>();
		int parkingLotSize = 6;
		params.add(Integer.toString(parkingLotSize));
		try {
			createParkingLot.execute(params);
			createParkingLot.execute(params);
		} catch (ParkingLotException e) {
			assertEquals("Parking lot already exists!", e.getMessage());
		}
		
		
	}

}
