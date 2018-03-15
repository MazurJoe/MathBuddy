/**
 * created by Joseph Mazur
 * @since 03-12-2018
*/
package mathbuddy;

import java.util.Random;
public class NumberGenerator
{
    //this method takes two parameters as a range from which to generate numbers from, and returns an integer thats within the specified range
    public static int intNumGen(int numLow, int numHigh)
    {        
        Random generator = new Random(System.currentTimeMillis());
        return generator.nextInt(numHigh-numLow+1)+numLow;
    }
    
    //this method returns a double from a given range up to a desired number of decimal places. 
    public static double doubleNumGen(int numLow, int numHigh, int numOfDecimalPlaces)
    {
        Random generator = new Random(System.currentTimeMillis());
        return (generator.nextInt((numHigh-numLow)*10^numOfDecimalPlaces +1)+numLow*10^numOfDecimalPlaces)/(10^numOfDecimalPlaces);
    }
}
