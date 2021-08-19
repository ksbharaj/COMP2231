//******************************************************************************
// Question1DriverBackPainAnalyzer.java
// 
// Karan Bharaj T00693289
// COMP2231 Assignment 4: Question 1
// Implementation of DecisionTree.java for analysing Back Pain. Test cases used to 
// answer the requirements of Question 1 using the decision tree "input.txt".
//******************************************************************************

import java.io.*;

/**
 * BackPainAnaylyzer demonstrates the use of a binary decision tree to 
 * diagnose back pain.
 */

public class Question1DriverBackPainAnalyzer
{
	/**
	 *  Asks questions of the user to diagnose a medical problem.
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
            System.out.println("         ======== QUESTION 1 ========\n");
            System.out.println("--- CASE 1- Test case as per Listing 19.6 ---");
            System.out.println("So, you're having back pain.");

            DecisionTree case1 = new DecisionTree("input.txt");
            case1.evaluate();
            System.out.println("------- End of CASE 1 -------\n\n\n");
            
            System.out.println("-------- CASE 2 --------");
            System.out.println("So, you're having back pain.");
            
            DecisionTree case2 = new DecisionTree("input.txt");
            case2.evaluate();
            System.out.println("------- End of CASE 2 -------\n\n\n");
            
            System.out.println("-------- CASE 3 --------");
            System.out.println("So, you're having back pain.");
            
            DecisionTree case3 = new DecisionTree("input.txt");
            case3.evaluate();
            System.out.println("------- End of CASE 3 -------\n\n\n");
            
	}
}
