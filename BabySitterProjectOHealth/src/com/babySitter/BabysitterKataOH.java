package com.babySitter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
public class BabysitterKataOH {
	static double totalPayment=0.0;

	public static void main(String[] args) {

		extractedLocalTime(); 
	}

	public static double extractedLocalTime() {
		  //hard coded code time from checkin to checkOut
		LocalDateTime startTimeNow = LocalDateTime.of(2020, 07, 27, 04, 00, 00);  
		LocalDateTime checkIn = LocalDateTime.of(2020, 07, 26, 17, 00, 00);  
		LocalDateTime bedTime = LocalDateTime.of(2020, 07, 26, 22, 00, 00);  
		LocalDateTime midNighTime = LocalDateTime.of(2020, 07, 27, 00, 00, 00); 
		LocalDateTime checkOut = LocalDateTime.of(2020, 07, 27, 04, 00, 00);  
		 //to check if the time is between start time and end time
		if(startTimeNow.isAfter(checkIn) ||(startTimeNow.isBefore(checkOut))) {

			if(startTimeNow.isAfter(checkIn) ||(startTimeNow.isBefore(bedTime)) ) {
				totalPayment=totalPayment +((ChronoUnit.HOURS.between(checkIn, bedTime))*8); 

			}
			if(startTimeNow.isAfter(bedTime) ||(startTimeNow.isBefore(midNighTime)) ) {
				totalPayment=totalPayment +((ChronoUnit.HOURS.between(bedTime, midNighTime))*12);

			}
			if(startTimeNow.isAfter(midNighTime) ||(startTimeNow.isBefore(checkOut)) ) {

				totalPayment=totalPayment +((ChronoUnit.HOURS.between(midNighTime, checkOut))*16);

			}
		} else { System.out.
			println("Starts no earlier than 5:00 PM or leaves no later than 4:00 AM");

		}
		return totalPayment;

	}

}
