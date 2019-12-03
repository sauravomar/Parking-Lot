package com.parking.lot.command;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.parking.lot.constant.ResponseUtil;
import com.parking.lot.exception.ParkingLotException;
import com.parking.lot.service.ParkingLotSvc;

public class StatusTest {

	private Status status;
	private CreateParkingLot createParkingLot;
	private Park park;

	@Before
	public void setup() {
		ParkingLotSvc svc = new ParkingLotSvc();
		status = new Status(svc);
		park = new Park(svc);
		createParkingLot = new CreateParkingLot(svc);
	}

	@Test
	public void testFailureSlotNotCreated() {
		List<String> params = new ArrayList<>();
		try {
			status.execute(params);
		} catch (ParkingLotException e) {
			assertEquals(ResponseUtil.SLOTS_UNDEFINED, e.getMessage());
		}
	}

	@Test
	public void testSuccess() throws ParkingLotException {
		List<String> params = new ArrayList<>();
		params.add("1");
		createParkingLot.execute(params);
		params = new ArrayList<>();
		params.add("KA-01-HH-1234");
		params.add("White");
		park.execute(params);
		params = new ArrayList<>();
		
		System.out.println(status.execute(params));
		assertEquals("Slot No.    Registration No    Colour\n"+
				"1           KA-01-HH-1234      White", status.execute(params));

	}
}
