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
		LocalDateTime timeRightNow = LocalDateTime.of(2020, 07, 27, 04, 00, 00);  
		LocalDateTime checkIn = LocalDateTime.of(2020, 07, 26, 17, 00, 00);  
		LocalDateTime bedTime = LocalDateTime.of(2020, 07, 26, 22, 00, 00);  
		LocalDateTime midNighTime = LocalDateTime.of(2020, 07, 27, 00, 00, 00); 
		LocalDateTime checkOut = LocalDateTime.of(2020, 07, 27, 04, 01, 00);
		if((timeRightNow.compareTo(checkIn)<0)||(timeRightNow.compareTo(checkOut)>0)) { 
			System.out.println("It is not your schedule.");
		}  
		    //to check if the time is between start time and end time
		else {
			
			if(timeRightNow.isAfter(checkIn) ||(timeRightNow.isBefore(checkOut))) {

				if(timeRightNow.isAfter(checkIn) &&(timeRightNow.isBefore(bedTime)) ) {
					totalPayment=totalPayment +((ChronoUnit.HOURS.between(checkIn, timeRightNow))*12);

				}
				else if(timeRightNow.isAfter(bedTime) &&(timeRightNow.isBefore(midNighTime)) ) {
					totalPayment=totalPayment +((ChronoUnit.HOURS.between(checkIn, bedTime))*12)+
							((ChronoUnit.HOURS.between(bedTime, timeRightNow))*8);

				}
				else if(timeRightNow.isAfter(midNighTime) &&(timeRightNow.isBefore(checkOut)) ) {

					totalPayment=totalPayment +((ChronoUnit.HOURS.between(checkIn, bedTime))*12)+
							((ChronoUnit.HOURS.between(bedTime, midNighTime))*8)+
							((ChronoUnit.HOURS.between(midNighTime, timeRightNow))*16);

				}
			} }
		return totalPayment;

	}

}
