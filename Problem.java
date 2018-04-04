package mathbuddy;

/**
 * @author Paul John Nguyen
 * @since 03-15-2018
 * @version 0.0.1
 */

import java.util.ArrayList;

public class Problem 
{
    /**
     * The type of mathematical problem.
     */
    private ProblemType problemType;
    
    /**
     * String representation of the problem.
     */
    private String problem;
    
    /**
     * The correct answer to the problem.
     */
    private Double correctAnswer;
    
    /**
     * constructor for problem
     * @param p problem type
     * @param ops ArrayList of operations in form of Character
     * @param nums ArrayList of numbers in form of Double
     */
    public Problem(ProblemType p, ArrayList<Character> ops, ArrayList<Double> nums)
    {
        problemType = p;
        problem = problemType.generateProblem(ops, nums);
        correctAnswer = problemType.generateCorrectAnswer();
    }
    
    public String getProblem()
    {
        return problem;
    }
    
    public Double getCorrectAnswer()
    {
        return correctAnswer;
    }
    
    /**
     * Prints the correct answer.
     */
    public void displayCorrectAnswer()
    {
        System.out.println(correctAnswer);
    }
    
    /**
     * Prints the problem.
     */
    public void displayProblem()
    {
        System.out.print(problem);
    }
}
