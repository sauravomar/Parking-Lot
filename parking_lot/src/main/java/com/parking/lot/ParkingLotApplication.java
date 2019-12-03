package com.parking.lot;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.parking.lot.constant.ResponseUtil;
import com.parking.lot.controller.ConsoleController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class ParkingLotApplication implements CommandLineRunner {

	@Autowired
	private ConsoleController consoleController;

	public static void main(String[] args) {
		log.info("STARTING THE APPLICATION");
		SpringApplication.run(ParkingLotApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner sc = null;

		if (args != null && args.length > 0) {
			try {
				File file = new File(args[0]);
				sc = new Scanner(file);
			} catch (FileNotFoundException e) {
				System.out.println(String.format(ResponseUtil.FILE_NOT_FOUND, args));
				System.exit(1);
			}
		} else {
			sc = new Scanner(System.in);
		}

		String str = null;
		String result = null;

		// iterate till exit command
		while (sc.hasNextLine()) {
			str = sc.nextLine();
			result = consoleController.execute(str);
			if (result == ResponseUtil.EXIT)
				break;
			System.out.println(result);
		}
		sc.close();
	}

}
