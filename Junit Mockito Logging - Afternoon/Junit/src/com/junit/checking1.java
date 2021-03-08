package com.junit;
import static org.junit.Assert.*;
import org.junit.Test;
import com.junit.PrimeChecker;
public class checking1 {

	@Test
	public void check1(){
		System.out.println("1 is Prime"+PrimeChecker.isPrime(1));
		assertEquals(true,PrimeChecker.isPrime(1));
	}
	@Test
	public void checks2(){
	System.out.println("2 is Prime"+PrimeChecker.isPrime(2));
	assertEquals(true,PrimeChecker.isPrime(2));
	}
		

}
