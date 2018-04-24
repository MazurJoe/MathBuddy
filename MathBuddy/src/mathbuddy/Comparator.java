/**
 * created by Joseph Mazur
 * @since 03-12-2018
 */
package mathbuddy;
public class Comparator 
{ 
    //this method compares the diference of two doubles, and if the result is <= 1/1000, it returns true. 
    public static boolean numComparator(double userAnswer, double correctAnswer)
    {
        if(Math.abs(userAnswer-correctAnswer)<= .001)
            return true;
        return false;
    }    
    
}
