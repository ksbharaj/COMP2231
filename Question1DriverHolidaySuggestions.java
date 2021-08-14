//******************************************************************************
// Question1DriverHolidaySuggestions.java
// 
// Karan Bharaj T00693289
// COMP2231 Assignment 4: Question 1
// Implementation of DecisionTree.java for recommending you a Holiday destination.
// Test cases used to answer the requirements of Question 1 using the decision tree
// "holidays.txt".
//******************************************************************************

import java.io.*;

/**
 * HolidayRecommender demonstrates the use of a binary decision tree to 
 * recommend your next holiday destination.
 */
public class Question1DriverHolidaySuggestions
{
    /**
     *  Asks questions of the user to suggest/recommend a holiday destination.
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        System.out.println("         ======== QUESTION 1 ========\n");
        System.out.println("-------- CASE 1 --------");
        System.out.println("Looking for a Holiday Destination? Try this out!");

        DecisionTree case1 = new DecisionTree("holidays.txt");
        case1.evaluate();
        System.out.println("------- End of CASE 1 -------\n\n\n");
        
        System.out.println("-------- CASE 2 --------");
        System.out.println("Looking for a Holiday Destination? Try this out!");

        DecisionTree case2 = new DecisionTree("holidays.txt");
        case2.evaluate();
        System.out.println("------- End of CASE 2 -------\n\n\n");
        
        System.out.println("-------- CASE 3 --------");
        System.out.println("Looking for a Holiday Destination? Try this out!");

        DecisionTree case3 = new DecisionTree("holidays.txt");
        case3.evaluate();
        System.out.println("------- End of CASE 3 -------\n\n\n");
    }
}
