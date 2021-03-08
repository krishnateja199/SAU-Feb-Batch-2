package com.junit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class checking2 {
	@BeforeClass
	public static void useBeforeClass() throws Exception {
		System.out.println("Befor Running Class");
	}
	@Before
	public void useBefore() throws Exception {
		System.out.println("Before");
	}
	
	@Test
	public void check1(){
		System.out.println("1 is Prime-------->"+PrimeChecker.isPrime(1));
		assertEquals(false,PrimeChecker.isPrime(1));
	}
	@Test
	public void check2(){
		System.out.println("2 is Prime-------->"+PrimeChecker.isPrime(2));
		assertEquals(true,PrimeChecker.isPrime(2));
	}
	
	@After
	public void useAfter() throws Exception {
		System.out.println("After");
	}

	@AfterClass
	public static void useAfterClass() throws Exception {
		System.out.println("After Running Class");
	}
}
