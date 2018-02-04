
import java.math.BigInteger;

/**
 *
 * @author Jeezy
 */
public class ProjectEuler {
  /*
  If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
  The sum of these multiples is 23. Find the sum of all the multiples of 3 or 5 below 1000.
  */
  public static int multiplesOf3And5(int max) {
    int sum = 0;
    for(int i = 1; i < max; i++)
      if(i % 3 == 0 || i % 5 == 0) sum += i;
    return sum;
  }
  
  /*
  Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting
  with 1 and 2, the first 10 terms will be: 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
  By considering the terms in the Fibonacci sequence whose values do not exceed four million, find
  the sum of the even-valued terms.
  */
  public static long evenFibonacci(long max) {
    long sum = 0;
    for(int last = 1, first = 2, i = first; i < max; i = last + i, last = first) {
      first = i;
      if(i % 2 == 0) sum += i;
    }
    return sum;
  }
  
  /**
   * The prime factors of 13195 are 5, 7, 13 and 29.
   * What is the largest prime factor of the number 600851475143 ?
   * @param number
   * @return the largest prime factor
   */
  public static long largestPrimeFactor(BigInteger number) {
    long largestPrime = 1;
    BigInteger x = new BigInteger("1");
    
    while(x.nextProbablePrime().compareTo(number) < 1) {
      x = x.nextProbablePrime();
      if(number.remainder(x).compareTo(BigInteger.ZERO) == 0) {
        largestPrime = x.longValue();
        number = number.divide(x);
      }
    }
    
    return largestPrime;
  }
  
  public static void main(String[] args) {
    System.out.println("Answer: " + largestPrimeFactor(new BigInteger("600851475143")));
  }
}
