package com.parking.lot.command;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.parking.lot.constant.ResponseUtil;
import com.parking.lot.exception.ParkingLotException;
import com.parking.lot.service.ParkingLotSvc;

public class ParkTest {

	private Park park;
	private CreateParkingLot createParkingLot;

	@Before
	public void setup() {
		ParkingLotSvc svc = new ParkingLotSvc();
		park = new Park(svc);
		createParkingLot = new CreateParkingLot(svc);
	}

	@Test
	public void testFailure() {
		List<String> params = new ArrayList<>();
		params.add("KA-01-HH-1234");
		params.add("White");
		try {
			park.execute(params);
		} catch (ParkingLotException e) {
			assertEquals(ResponseUtil.SLOTS_UNDEFINED, e.getMessage());
		}
	}
	
	@Test
	public void testFailureSlotFull() throws ParkingLotException {
		List<String> params = new ArrayList<>();
		params.add("1");
		
		createParkingLot.execute(params);
		
		params = new ArrayList<>();
		params.add("KA-01-HH-1234");
		params.add("White");
		park.execute(params);
		
		params = new ArrayList<>();
		params.add("KA-01-HH-1235");
		params.add("White");
		
		try {
			park.execute(params);
		} catch (ParkingLotException e) {
			assertEquals(ResponseUtil.SLOT_FULL, e.getMessage());
		}
	}

	@Test
	public void testSuccess() throws ParkingLotException {
		List<String> params = new ArrayList<>();
		params.add("6");
		createParkingLot.execute(params);
		params = new ArrayList<>();
		params.add("KA-01-HH-1234");
		params.add("White");
		String response = park.execute(params);
		assertEquals(String.format(ResponseUtil.SLOT_ALLOCATION_SUCCESS, 1), response);
	}

}
