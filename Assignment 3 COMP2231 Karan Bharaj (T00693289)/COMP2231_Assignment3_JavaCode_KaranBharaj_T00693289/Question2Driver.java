//******************************************************************************
// Question1Driver.java
// 
// Karan Bharaj T00693289
// COMP2231 Assignment 3: Question 2
// This driver implements a stack using the Java API's java.util.ArrayList class
// to answer the requirements of Question 2
//******************************************************************************

public class Question2Driver 
{
    public static void main(String[] args) 
    {
        System.out.println("         ======== QUESTION 2 ========\n");
        System.out.println("--- New ArrayListStack \"scientists\" created ---");
        System.out.println("---------  using ArrayListStack.java  ---------");
        ArrayListStack scientists = new ArrayListStack();
        System.out.println("\n");
        
        System.out.println("--- Check to see if scientists is empty ---");
        System.out.println("The stack \"scientists\" is empty: " + scientists.isEmpty());
        System.out.println("\n");
        
        System.out.println("--- Four scientists added to the stack ---");
        scientists.push("Albert Einstein");
        scientists.push("Isaac Newton");
        scientists.push("Robert Hooke");
        scientists.push("Richard Feynman");
        
        System.out.println("\n\n--- Print-out of members in \"scientists\": ---");
        System.out.println(scientists);
        
        System.out.println("\n--- peek() method executed on \"scientists\" ---");
        System.out.println("Scientist at the top of the stack: " + scientists.peek());
        
        System.out.println("\n\n--- size() method called on \"scientists\" ---");
        System.out.println("Size of the stack: " + scientists.size());
        
        System.out.println("\n--- pop() method executed on \"scientists\" ---");
        System.out.println("Scientist removed from stack: " + scientists.pop());
        System.out.println("");
        
        System.out.println("\n--- pop() method executed on \"scientists\" ---");
        System.out.println("Scientist removed from the stack: " + scientists.pop());
        System.out.println("");
        
        System.out.println("\n--- size() method called on \"scientists\" ---");
        System.out.println("Size of the stack: " + scientists.size());
        
        System.out.println("\n\nPrint-out of members in the \"scientists\" stack:");
        System.out.println(scientists);
        
        System.out.println("\n--- peek() method executed on \"scientists\" ---");
        System.out.println("Scientist at the top of the stack: " + scientists.peek());
        
        System.out.println("\n\n--- Check to see if scientists is empty---");
        System.out.println("The stack \"scientists\" is empty: " + scientists.isEmpty());
        
        System.out.println("\n\n--- pop() method executed on \"scientists\" ---");
        System.out.println("Scientist removed from the stack: " + scientists.pop());
        
        System.out.println("\n\n--- pop() method executed on \"scientists\" ---");
        System.out.println("Scientist removed from the stack: " + scientists.pop());
        
        System.out.println("\n\n--- size() method called on \"scientists\" ---");
        System.out.println("Size of the stack: " + scientists.size());
        
        System.out.println("\n\n--- Check to see if scientists is empty---");
        System.out.println("The stack \"scientists\" is empty: " + scientists.isEmpty());
    }
}
