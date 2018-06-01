package NumberProblems;

import java.util.HashMap;
import java.math.BigInteger;

/**
 * This class gets Nth fibonacci number from the series
 * @author arunbalajip
 *
 */
public class Fibonacci {
    private static HashMap<BigInteger, BigInteger> cache = new HashMap<BigInteger, BigInteger>();
    private static BigInteger ONE  = BigInteger.ONE;
    private static BigInteger ZERO = BigInteger.ZERO;

    /*
     * Get the Nth fibonacci number.  
     * @param n 
     * 	input n to get fibonacci number
     * @return Nth fibonacci number
     * @throws IllegalArguementException
     */
    public BigInteger getNthFibonacciNumber(BigInteger n) throws IllegalArgumentException{
    	if(n == null) throw new IllegalArgumentException("Input is invalid");
        if (n.equals(ZERO)) return ZERO;
        if (n.equals(ONE))  return ONE;
        if (cache.containsKey(n)) return cache.get(n);

        BigInteger inputBit = n.shiftRight(1);
        // odd
        if (n.testBit(0)) {
            BigInteger addOne = inputBit.add(ONE);
            BigInteger result = getNthFibonacciNumber(inputBit).multiply(getNthFibonacciNumber(inputBit)).add(getNthFibonacciNumber(addOne).multiply(getNthFibonacciNumber(addOne)));
            cache.put(n, result);
            return result;
        }
        // even
        else {
            BigInteger subOne = inputBit.subtract(ONE);
            BigInteger result = getNthFibonacciNumber(inputBit).multiply(getNthFibonacciNumber(inputBit).add(getNthFibonacciNumber(subOne).add(getNthFibonacciNumber(subOne))));
            cache.put(n, result);
            return result;
        }
    }
}
