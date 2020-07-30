package com.babySitter;
import java.util.Scanner;  // Import the Scanner class
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
		LocalDateTime checkOut = LocalDateTime.of(2020, 07, 27, 04, 01, 00);
		if((startTimeNow.compareTo(checkIn)<0)||(startTimeNow.compareTo(checkOut)>0)) { 
			System.out.println("It is not your schedule.");
		}  
		    //to check if the time is between start time and end time
		else {
			
			if(startTimeNow.isAfter(checkIn) ||(startTimeNow.isBefore(checkOut))) {

				if(startTimeNow.isAfter(checkIn) &&(startTimeNow.isBefore(bedTime)) ) {
					totalPayment=totalPayment +((ChronoUnit.HOURS.between(checkIn, startTimeNow))*12);

				}
				else if(startTimeNow.isAfter(bedTime) &&(startTimeNow.isBefore(midNighTime)) ) {
					totalPayment=totalPayment +((ChronoUnit.HOURS.between(checkIn, bedTime))*12)+
							((ChronoUnit.HOURS.between(bedTime, startTimeNow))*8);

				}
				else if(startTimeNow.isAfter(midNighTime) &&(startTimeNow.isBefore(checkOut)) ) {

					totalPayment=totalPayment +((ChronoUnit.HOURS.between(checkIn, bedTime))*12)+
							((ChronoUnit.HOURS.between(bedTime, midNighTime))*8)+
							((ChronoUnit.HOURS.between(midNighTime, startTimeNow))*16);

				}
			} }

		return totalPayment;

	}

}
