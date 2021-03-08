package com.logging.LoggingPrime;
import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class PrimeChecker {

	static Logger log = LogManager.getLogger(PrimeChecker.class);

	public static void main(String[] args) {
		log.info("This is a function which checks if number is Prime or Not for 1 to 100");
		
		for(int i = -1 ; i <=101 ; i++){
			if(i<0)
				log.fatal("you cant give negative");
			else if (i==0)
				log.warn("0 is neither prime nor composite");
			else if(i>100)
				log.error("Number is greater than 100");
			else
				log.debug(i+" is Prime - "+isPrime(i));
		}
	}
	//fastest way for determining number is prime
	boolean isPrime(long n) {
		if(n < 2) return false;
		if(n == 2 || n == 3) return true;
		if(n%2 == 0 || n%3 == 0) return false;
		long sqrtN = (long)Math.sqrt(n)+1;
		for(long i = 6L; i <= sqrtN; i += 6) {
			if(n%(i-1) == 0 || n%(i+1) == 0) return false;
		}
		return true;
	}
}
