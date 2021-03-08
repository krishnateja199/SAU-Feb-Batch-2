package com.mockito.MockitoPrime;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;



public class PrimeTest 
{
	PrimeController pc;
	@Before
	public void setup() {
		pc = new PrimeController();
		PrimeChecker pc1 = mock(PrimeChecker.class);
		when(pc1.isPrime(1)).thenReturn(false);
		when(pc1.isPrime(2)).thenReturn(true);
		pc.setObj(pc1);
	}
	
	@Test
	public void test1() {
		Assert.assertEquals(false, pc.Prime(1));
	}
	@Test
	public void test2() {
		Assert.assertEquals(true, pc.Prime(2));
	}
	
	
}
