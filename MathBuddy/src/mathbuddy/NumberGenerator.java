/**
 * @author Joseph Mazur
 * @author Paul John Nguyen
 * @since 03-15-2018
 * @version
 */
package mathbuddy;

import java.util.Random;

public class NumberGenerator
{
    final static Random GENERATOR = new Random(System.currentTimeMillis());
    
    /**
     * this method takes two parameters as a range from which to generate numbers from, and returns an integer thats within the specified range
     * @param numLow lowest number of range
     * @param numHigh highest number of range
     * @return integer within range
     */
    public static int intNumGen(int numLow, int numHigh)
    {
        return GENERATOR.nextInt(numHigh-numLow+1)+numLow;
    }
    
    /**
     * this method returns a double from a given range up to a desired number of decimal places. 
     * @param numLow lowest number of range
     * @param numHigh highest number of range
     * @param numOfDecimalPlaces number of decimal places
     * @return double within range
     */
    public static double doubleNumGen(int numLow, int numHigh, int numOfDecimalPlaces)
    {
        return (GENERATOR.nextInt((int) ((numHigh-numLow)*Math.pow(10,numOfDecimalPlaces) + Math.pow(10,numOfDecimalPlaces)))+numLow*Math.pow(10,numOfDecimalPlaces))/Math.pow(10,numOfDecimalPlaces);
    }
}
