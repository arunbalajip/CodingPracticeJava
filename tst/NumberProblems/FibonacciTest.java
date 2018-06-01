package NumberProblems;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;

public class FibonacciTest {

	Fibonacci fibonacci; 
	
	@Before
	public void setUp() throws Exception {
		fibonacci = new Fibonacci();
	}

	@Test
	public void testHappyCase() {
		BigInteger output = fibonacci.getNthFibonacciNumber(new BigInteger("12"));
		assertNotNull(output);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNullPointerException() {
		fibonacci.getNthFibonacciNumber(null);
	}
}

