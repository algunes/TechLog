package com.TechLog.FreeTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

class PasswordResetTest {

	@Test
	void test() {
		
		
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890.?-,!";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        System.out.println(salt.toString());
		
	}

}
