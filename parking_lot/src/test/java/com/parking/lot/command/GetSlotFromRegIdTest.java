package com.parking.lot.command;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.parking.lot.constant.ResponseUtil;
import com.parking.lot.exception.ParkingLotException;
import com.parking.lot.service.ParkingLotSvc;

public class GetSlotFromRegIdTest {
	private GetSlotFromRegId getSlotFromRegId;
	private CreateParkingLot createParkingLot;
	private Park park;

	@Before
	public void setup() {
		ParkingLotSvc svc = new ParkingLotSvc();
		getSlotFromRegId = new GetSlotFromRegId(svc);
		park = new Park(svc);
		createParkingLot = new CreateParkingLot(svc);
	}

	@Test
	public void testFailureSlotNotCreated() {
		List<String> params = new ArrayList<>();
		params.add("White");
		try {
			getSlotFromRegId.execute(params);
		} catch (ParkingLotException e) {
			assertEquals(ResponseUtil.SLOTS_UNDEFINED, e.getMessage());
		}
	}

	@Test
	public void testFailure() throws ParkingLotException {
		List<String> params = new ArrayList<>();
		params.add("1");
		createParkingLot.execute(params);
		params = new ArrayList<>();
		params.add("KA-01-HH-1234");
		String response = getSlotFromRegId.execute(params);
		assertEquals(response, ResponseUtil.NOT_FOUND);
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
		params.add("KA-01-HH-1234");
		String response = getSlotFromRegId.execute(params);
		assertEquals(response, "1");
	}
}
