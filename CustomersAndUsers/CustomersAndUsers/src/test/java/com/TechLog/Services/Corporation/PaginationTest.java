package com.TechLog.Services.Corporation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PaginationTest {

	@Test
	@DisplayName("When corporation database table has 6 rows")
	void test() {
		Long rowNumber = new CorporationPostService().getNumberOfCorporation();
		assertEquals(6, rowNumber);
	}

}
