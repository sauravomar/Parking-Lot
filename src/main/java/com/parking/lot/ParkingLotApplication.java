package com.parking.lot;

import java.util.Scanner;

import com.parking.lot.controller.ParkingLotController;
import com.parking.lot.util.ResponseUtil;

public class ParkingLotApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);;

		String str = null;
		String result = null;

		while (sc.hasNextLine()) {
			str = sc.nextLine();
			result = ParkingLotController.executeCommandFromString(str);
			if (result == ResponseUtil.EXIT)
				break;
			System.out.println(result);
		}
		sc.close();
	}
}