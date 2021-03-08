package com.mockito.MockitoPrime;

public class Primedetermine {
	PrimeChecker pc;
	public boolean Prime(int n) {
		return pc.isPrime(n);
	}
	public PrimeChecker getObj() {
		return pc;
	}
	public void setObj(PrimeChecker pc) {
		this.pc = pc;
	}
}
