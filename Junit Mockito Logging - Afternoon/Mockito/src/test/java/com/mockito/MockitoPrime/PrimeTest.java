package com.mockito.MockitoPrime;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito.*;


public class PrimeTest {
	PrimeController pc;
	@Before
	public void setup() {
		PrimeChecker pc1 = mock(PrimeChecker.class);
		when(pc1.isPrime(1)).thenReturn(false);
		when(pc1.isPrime(2)).thenReturn(true);
		pc = new PrimeController();
		pc.setObj(pc1);
	}
	
	@Test
	public void test1() {
		Assert.assertEquals(true, pc.Prime(1));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(true, pc.Prime(2));
	}
	
	

}
