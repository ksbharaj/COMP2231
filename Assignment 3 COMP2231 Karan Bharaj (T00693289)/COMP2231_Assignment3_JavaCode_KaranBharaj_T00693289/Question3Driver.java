//******************************************************************************
// Question3Driver.java
// 
// Karan Bharaj T00693289
// COMP2231 Assignment 3: Question 3
// This driver implements a queue using the Java API's java.util.LinkedList class
// to answer the requirements of Question 3
//******************************************************************************

public class Question3Driver 
{
    public static void main(String[] args) 
    {
        System.out.println("         ======== QUESTION 3 ========\n");
        System.out.println("--- New LinkedListQueue \"scientists\" created ---");
        System.out.println("---------  using LinkedListQueue.java  ---------");
        LinkedListQueue scientists = new LinkedListQueue();
        System.out.println("\n");
        
        System.out.println("--- Check to see if scientists is empty ---");
        System.out.println("The queue \"scientists\" is empty: " + scientists.isEmpty());
        System.out.println("\n");
        
        System.out.println("--- Four scientists added to the queue ---");
        scientists.enqueue("Albert Einstein");
        scientists.enqueue("Isaac Newton");
        scientists.enqueue("Robert Hooke");
        scientists.enqueue("Richard Feynman");
        
        System.out.println("\n\n--- Print-out of members in \"scientists\": ---");
        System.out.println(scientists);
        
        System.out.println("\n--- first() method executed on \"scientists\" ---");
        System.out.println("Scientist at the front of the queue: " + scientists.first());
        
        System.out.println("\n\n--- size() method called on \"scientists\" ---");
        System.out.println("Size of the queue: " + scientists.size());
        
        System.out.println("\n--- dequeue() method executed on \"scientists\" ---");
        System.out.println("Scientist removed from queue: " + scientists.dequeue());
        System.out.println("");
        
        System.out.println("\n--- dequeue() method executed on \"scientists\" ---");
        System.out.println("Scientist removed from the queue: " + scientists.dequeue());
        System.out.println("");
        
        System.out.println("\n--- size() method called on \"scientists\" ---");
        System.out.println("Size of the queue: " + scientists.size());
        
        System.out.println("\n\nPrint-out of members in the \"scientists\" queue:");
        System.out.println(scientists);
        
        System.out.println("\n--- first() method executed on \"scientists\" ---");
        System.out.println("Scientist at the front of the queue: " + scientists.first());
        
        System.out.println("\n\n--- Check to see if scientists is empty---");
        System.out.println("The queue \"scientists\" is empty: " + scientists.isEmpty());
        
        System.out.println("\n\n--- dequeue() method executed on \"scientists\" ---");
        System.out.println("Scientist removed from the queue: " + scientists.dequeue());
        
        System.out.println("\n\n--- dequeue() method executed on \"scientists\" ---");
        System.out.println("Scientist removed from the queue: " + scientists.dequeue());
        
        System.out.println("\n\n--- size() method called on \"scientists\" ---");
        System.out.println("Size of the queue: " + scientists.size());
        
        System.out.println("\n\n--- Check to see if scientists is empty---");
        System.out.println("The queue \"scientists\" is empty: " + scientists.isEmpty());
    }
}
