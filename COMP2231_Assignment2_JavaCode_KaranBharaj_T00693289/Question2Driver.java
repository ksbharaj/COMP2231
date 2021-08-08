//******************************************************************************
// Question2Driver.java
// 
// Karan Bharaj T00693289
// COMP2231 Assignment 2: Question 2
// This driver implements a Drop-out stack (DropOutStack.java) which is 
// restricted in size, and uses it to answer the requirements of Question 2.
//******************************************************************************

import jsjf.DropOutStack;

public class Question2Driver 
{
    public static void main(String[] args) 
    {
        System.out.println("         ======== QUESTION 2 ========\n");
        System.out.println("--- New Drop-out Stack \"astronauts\" created with a capacity of 5 ---");
        DropOutStack astronauts = new DropOutStack(5);
        System.out.println("\n");
        
        System.out.println("--- 5 names pushed into the \"astronauts\" Drop-out Stack ---");
        astronauts.push("Karan Bharaj");
        System.out.println(astronauts.peek() + " added to the \"astronauts\" Drop-out Stack");
        astronauts.push("Chris Hadfield");
        System.out.println(astronauts.peek() + " added to the \"astronauts\" Drop-out Stack");
        astronauts.push("Neil Armstrong");
        System.out.println(astronauts.peek() + " added to the \"astronauts\" Drop-out Stack");
        astronauts.push("Yuri Gagarin");
        System.out.println(astronauts.peek() + " added to the \"astronauts\" Drop-out Stack");
        astronauts.push("Buzz Aldrin");
        System.out.println(astronauts.peek() + " added to the \"astronauts\" Drop-out Stack");
        System.out.println("\n");
        
        System.out.println("--- Contents of the \"astronauts\" Drop-out Stack ---");
        System.out.println(astronauts);
        System.out.println("");
        
        System.out.println("--- Size method executed on \"astronauts\" Drop-out Stack ---");
        System.out.println(astronauts.size() + "\n");
        System.out.println("");
        
        System.out.println("--- Peek method executed on \"astronauts\" Drop-out Stack ---");
        System.out.println(astronauts.peek() + "\n");
        System.out.println("");
        
        System.out.println("--- Another name pushed into the \"astronauts\" Drop-out Stack ---");
        astronauts.push("Sally Ride");
        System.out.println("Name added to the \"astronauts\" Drop-out Stack: " + astronauts.peek());
        System.out.println("Size of the \"astronauts\" Drop-out Stack: " + astronauts.size());
        System.out.println("");
        System.out.println("--- Contents of the \"astronauts\" Drop-out Stack ---");
        System.out.println(astronauts);
        System.out.println("");
        
        System.out.println("--- Another name pushed into the \"astronauts\" Drop-out Stack ---");
        astronauts.push("Guion Bluford");
        System.out.println("Name added to \"astronauts\": " + astronauts.peek());
        System.out.println("Total names in the \"astronauts\" Drop-out Stack: " + astronauts.size());
        System.out.println("");
        System.out.println("--- Contents of the \"astronauts\" Drop-out Stack ---");
        System.out.println(astronauts);
        System.out.println("");
    }
}
