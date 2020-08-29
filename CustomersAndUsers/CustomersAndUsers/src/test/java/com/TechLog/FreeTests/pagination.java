package com.TechLog.FreeTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class pagination {

	@Test
	void test() {

		int totalRows = 45;
		int firstItem = 0;
		int maxItem = 10;
		boolean next = true;
		
		int pageNumber = (int)Math.ceil((double)totalRows/maxItem);
		
		System.out.println("Next..");
		
		for(int i = 0 ; i < pageNumber ; i++) {
	
			if(firstItem <= totalRows) {
					System.out.println("First item is: " + firstItem);
					firstItem = firstItem + maxItem;
					System.out.println("First item is: " + firstItem);
			}
			
		}
		
		System.out.println("Prev..");
		
		for(int i = 0 ; i < pageNumber ; i++) {
			
			if(firstItem <= totalRows) {
					System.out.println("First item is: " + firstItem);
					firstItem = firstItem - maxItem;
					System.out.println("First item is: " + firstItem);
			}
			
		}
		
	}

}
