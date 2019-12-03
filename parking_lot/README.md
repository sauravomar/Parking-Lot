# Welcome to Parking Lot!


# SETUP
* Navigate to parking-lot-1.4.2/parking_lot directory
* Run bin/setup 

# RUN
Two ways to run project 

* Console Commands:  
	* Run  bin/parking_lot and write command on the console
* File:
	* Run bin/parking_lot filename_location



# Assumptions: 

1. This application does not contain any database every operation is inmemory
2. Using Vehicle and VehicleSlots as well VehicleType enum so that any type of vehicle parking can added with small changes.
3. Making ParkingLotSvc(handles all the Parking related operations) and CommandSvc(handles all the Commands related operations) as Singleton
4. Now Creation of Parking Slot is handling only VehicleType Car which is hardcoded in CreateParkingLot class (because input is only for CarType)


