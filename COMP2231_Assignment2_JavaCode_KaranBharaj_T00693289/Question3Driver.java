//******************************************************************************
// Question3Driver.java
// 
// Karan Bharaj T00693289
// COMP2231 Assignment 2: Question 3
// This driver implements a Double-ended queue (Deque) using a DequeADT.java  
// interface and LinkedDeque.java class. The deque has is restricted in capacity  
// and is used to answer the requirements of Question 3.
//******************************************************************************

import jsjf.LinkedDeque;

public class Question3Driver
{
    public static void main(String[] args) 
    {
        System.out.println("         =========== QUESTION 3 ===========\n");
        System.out.println("--- New Deque \"astronauts\" created with a capacity of 5 ---");
        LinkedDeque astronauts = new LinkedDeque(5);
        System.out.println("\n");
        
        frontAdditionPrintout("Neil Armstrong", astronauts);
        frontAdditionPrintout("Chris Hadfield", astronauts);
        frontAdditionPrintout("Buzz Aldrin", astronauts);
        
        rearAdditionPrintout("Valentina Tereshkova", astronauts);
        rearAdditionPrintout("Yuri Gagarin", astronauts);
        
        frontAdditionPrintout("Karan Bharaj", astronauts);
        rearAdditionPrintout("Karan Bharaj", astronauts);
        
        rearRemovalPrintout(astronauts);
        frontRemovalPrintout(astronauts);
        frontRemovalPrintout(astronauts);
        rearRemovalPrintout(astronauts);
        frontRemovalPrintout(astronauts);
        rearRemovalPrintout(astronauts);
        frontRemovalPrintout(astronauts);
    }
    
    // Prints out the details of the Deque as required to answer the question
    private static void printoutSummary(LinkedDeque X) 
    {
        if (X.isEmpty())
        {
            System.out.println("This Deque is Empty. Try adding an element before dequeuing");
        } else 
        {
            System.out.println("");
            System.out.println("Size of deque: " + X.size() + "\n" +
                               "Frontmost element of deque: " + X.first() + "\n" +
                               "Rearmost element of deque: " + X.last());
            System.out.println("");
            System.out.println("Contents of deque:");
            System.out.println(X);
        }
    }
    
    // Printout arrangement for addition of an element to the front of the deque
    private static void frontAdditionPrintout(String astronaut, LinkedDeque X)
    {
        System.out.println("--- Astronaut name add attempt to the front of the deque ---");
        if (X.isFull())
        {
            System.out.println(astronaut + " cannot be added to the front of this deque");
            X.enqueueFront(astronaut);
        } else
        {
            X.enqueueFront(astronaut);
            System.out.println("Astronaut added to the front of the deque: " + X.first());
            printoutSummary(X);
        }
        System.out.println("-----------------------------------------------------------\n\n");
    }
    
    // Printout arrangement for addition of an element to the rear of the deque
    private static void rearAdditionPrintout(String astronaut, LinkedDeque X)
    {
        System.out.println("--- Astronaut name add attempt to the rear of the deque ---");
        if (X.isFull())
        {
            System.out.println(astronaut + " cannot be added to the rear of this deque");
            X.enqueueRear(astronaut);
        } else 
        {
            X.enqueueRear(astronaut);
            System.out.println("Astronaut added to the rear of the deque: " + X.last());
            printoutSummary(X);
        }
        System.out.println("-----------------------------------------------------------\n\n");
    }
    
    // Printout arrangement for removal of an element from the front of the deque
    private static void frontRemovalPrintout(LinkedDeque X)
    {
        System.out.println("--- Astronaut removal attempt from the front of the deque ---");
        
        if (X.isEmpty()) 
        {
            System.out.println("This Deque is empty. Try adding an element before dequeuing");
        } else 
        {
            Object astronaut = X.dequeueFront();
            System.out.println("Astronaut removed from the front of the deque: " + astronaut);
            printoutSummary(X);
        }
        
        System.out.println("-----------------------------------------------------------\n\n");
    }
    
    // Printout arrangement for removal of an element from the rear of the deque
    private static void rearRemovalPrintout(LinkedDeque X)
    {
        System.out.println("--- Astronaut removal attempt from the rear of the deque ---");
        
        if (X.isEmpty()) 
        {
            System.out.println("This Deque is empty. Try adding an element before dequeuing");
        } else 
        {
            Object astronaut = X.dequeueRear();
            System.out.println("Astronaut removed from the rear of the deque: " + astronaut);
            printoutSummary(X);
        }
        
        System.out.println("-----------------------------------------------------------\n\n");
    }
}
