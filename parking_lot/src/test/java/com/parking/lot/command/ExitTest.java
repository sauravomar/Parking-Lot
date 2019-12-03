package com.parking.lot.command;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.parking.lot.constant.ResponseUtil;
import com.parking.lot.exception.ParkingLotException;

public class ExitTest {

	private Exit exit;

	@Before
	public void setup() {
		exit = new Exit();
	}

	@Test
	public void testSuccess() throws ParkingLotException {
		assertEquals(ResponseUtil.EXIT, exit.execute(new ArrayList<String>()));

	}
}
