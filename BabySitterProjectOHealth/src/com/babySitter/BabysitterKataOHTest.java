package com.babySitter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BabysitterKataOHTest {

	@Test
	void testExtractedLocalTime() {
		BabysitterKataOH b=new BabysitterKataOH();
		assertEquals(180, b.extractedLocalTime());
		
		}

}
