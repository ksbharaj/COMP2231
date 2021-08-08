//******************************************************************************
// Question1Driver.java
// 
// Karan Bharaj T00693289
// COMP2231 Assignment 2: Question 1
// This driver implements the modified ArrayStack where stack[top] points
// to the actual top of the stack without using counter variables. 
//******************************************************************************
import jsjf.ArrayStack;

public class Question1Driver
{
    public static void main(String[] args) 
    {
        System.out.println("         ======== QUESTION 1 ========\n");
        System.out.println("--- New Stack \"X\" created using ArrayStack.java ---");
        ArrayStack X = new ArrayStack();
        System.out.println("\n");
        
        System.out.println("--- Check to see if X is empty- isEmpty() method ---");
        System.out.println("Is Stack \"X\" empty? " + X.isEmpty());
        System.out.println("\n");
        
        System.out.println("--- Integer \"3\" pushed into X ---");
        X.push(3);
        System.out.println("Printout of Stack X:\n" + X);
        System.out.println("");
        
        System.out.println("--- Check to see if X is empty- isEmpty() method ---");
        System.out.println(X.isEmpty());
        System.out.println("\n");
        
        System.out.println("--- Integer \"4\" pushed into X ---");
        X.push(4);
        System.out.println("Printout of Stack X:\n" + X);
        System.out.println("");
        
        System.out.println("--- Integer \"7\" pushed into X ---");
        X.push(7);
        System.out.println("Printout of Stack X:\n" + X);
        System.out.println("");
        
        System.out.println("--- pop() method executed on X ---");
        System.out.println("Integer popped: " + X.pop());
        System.out.println("Printout of Stack X:\n" + X);
        
        System.out.println("--- peek() method executed on X ---");
        System.out.println("Integer peeked at: " + X.peek());
        System.out.println("Printout of Stack X:\n" + X);
        System.out.println("");
        
        System.out.println("--- Integer \"2\" pushed into X ---");
        X.push(2);
        System.out.println("Printout of Stack X:\n" + X);
        System.out.println("");
        
        System.out.println("--- Integer \"1\" pushed into X ---");
        X.push(1);
        System.out.println("Printout of Stack X:\n" + X);
        System.out.println("");
        
        System.out.println("--- size() method called on X ---");
        System.out.println("Size of Stack X: " + X.size());
    }
}
