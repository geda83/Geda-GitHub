package com.babySitter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
public class BabysitterKataOH {
	static double total=0;

	public static void main(String[] args) {

		extractedLocalTime(); 
	}

	public static double extractedLocalTime() {
         LocalDateTime startTimeNow = LocalDateTime.of(2020, 07, 26, 18, 00, 00);  
         LocalDateTime checkIn = LocalDateTime.of(2020, 07, 26, 17, 00, 00);  
         LocalDateTime bedTime = LocalDateTime.of(2020, 07, 26, 22, 00, 00);  
         LocalDateTime midNighTime = LocalDateTime.of(2020, 07, 27, 00, 00, 00); 
         LocalDateTime checkOut = LocalDateTime.of(2020, 07, 27, 04, 00, 00);  


      

		if(startTimeNow.isAfter(checkIn) ||(startTimeNow.isBefore(checkOut))) {
			
		if(startTimeNow.isAfter(checkIn) ||(startTimeNow.isBefore(bedTime)) ) {
			total=total +((ChronoUnit.HOURS.between(checkIn, bedTime))*8); 
			
		  }
		
		if(startTimeNow.isAfter(bedTime) ||(startTimeNow.isBefore(midNighTime)) ) {
			total=total +((ChronoUnit.HOURS.between(checkIn, bedTime))*12); 
			
		  }
		if(startTimeNow.isAfter(midNighTime) ||(startTimeNow.isBefore(checkOut)) ) {
			total=total +((ChronoUnit.HOURS.between(checkIn, bedTime))*16); 
		}
		 
			
			 } else { System.out.
			  println("Starts no earlier than 5:00 PM or leaves no later than 4:00 AM");
			  
			  }
			

		
		return total;

	}

}
