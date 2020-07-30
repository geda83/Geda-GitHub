package com.babySitter;
import java.util.Scanner;  // Import the Scanner class

import com.babySitter.model.CurrencyCalculation;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
public class BabysitterKataOH {
	static double totalPayment=0.0;
	public static void main(String[] args) {
		extractedLocalTime(); 
	}
	public static double extractedLocalTime() {
		CurrencyCalculation c=new CurrencyCalculation();
		  HashMap<Integer,Integer>hashMap=new HashMap<>();
		   hashMap.put(0, c.setAmount(12));
		   hashMap.put(1, c.setAmount(8));
		   hashMap.put(2, c.setAmount(16));
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
					totalPayment=totalPayment +((ChronoUnit.HOURS.between(checkIn, timeRightNow))*hashMap.get(0));

				}
				else if(timeRightNow.isAfter(bedTime) &&(timeRightNow.isBefore(midNighTime)) ) {
					totalPayment=totalPayment +((ChronoUnit.HOURS.between(checkIn, bedTime))*hashMap.get(0))+
							((ChronoUnit.HOURS.between(bedTime, timeRightNow))*hashMap.get(1));

				}
				else if(timeRightNow.isAfter(midNighTime) &&(timeRightNow.isBefore(checkOut)) ) {

					totalPayment=totalPayment +((ChronoUnit.HOURS.between(checkIn, bedTime))*hashMap.get(0))+
							((ChronoUnit.HOURS.between(bedTime, midNighTime))*hashMap.get(1))+
							((ChronoUnit.HOURS.between(midNighTime, timeRightNow))*hashMap.get(2));

				}
			} }
		return totalPayment;

	}

}
