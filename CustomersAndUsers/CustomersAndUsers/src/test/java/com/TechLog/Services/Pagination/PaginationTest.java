package com.TechLog.Services.Pagination;

import org.junit.jupiter.api.Test;

class PaginationTest {

	@Test
	void test() {
		Pagination p = new Pagination(11, 3, 12L);
		
		System.out.println("First is: " + p.getFirst());
		System.out.println("Max is: " + p.getMax());
		System.out.println("Total is: " + p.getTotal());
		System.out.println("---");
		System.out.println("First Button Condition: " + p.getFirstButtonCondition());
		System.out.println("First Button Number: " + p.getFirstButtonNumber());
		System.out.println("First Button Value: " + p.getFirstButtonValue());
		System.out.println("---");
		System.out.println("Second Button Condition: " + p.getSecondButtonCondition());
		System.out.println("Second Button Number: " + p.getSecondButtonNumber());
		System.out.println("Second Button Value: " + p.getSecondButtonValue());
		System.out.println("---");
		System.out.println("Third Button Condition: " + p.getThirdButtonCondition());
		System.out.println("Third Button Number: " + p.getThirdButtonNumber());
		System.out.println("Third Button Value: " + p.getThirdButtonValue());
		System.out.println("---");
		System.out.println("Prev. Button Condition: " + p.getPrevButtonCondition());
		System.out.println("Prev Button Value: " + p.getPrevButtonValue());
		System.out.println("---");
		System.out.println("Next Button Condition: " + p.getNextButtonCondition());
		System.out.println("Next Button Value: " + p.getNextButtonValue());
		
	}

}
