//******************************************************************************
// DropOutStack.java
// 
// Karan Bharaj T00693289
// COMP2231 Assignment 2: Question 2
// Drop-Out stack using links that implements StackADT to answer Question 2
//******************************************************************************

package jsjf;

// Import the exception to be used when the stack is empty
import jsjf.exceptions.EmptyCollectionException;

//Represents a linked implementation of a Drop-Out type Stack, which includes a "capacity" variable
public class DropOutStack<T> implements StackADT<T>
{  
    private int count;
    private LinearNode<T> top;
    private int capacity;
    
    // Creates an empty stack that requires the capacity to be specified.
    public DropOutStack(int sizeLimit)
    {
        // Error thrown if user tries to specify stack size of zero or less
        if (sizeLimit < 1) 
        {
            throw new EmptyCollectionException("Drop-out stack");
        } else
        {
            count = 0;
            top = null;
            capacity = sizeLimit;
        }
    }
    
    // Adds a new element to the top of the stack
    public void push(T element)
    {      
        LinearNode<T> temp = new LinearNode<T>(element);
        temp.setNext(top);
        top = temp;
        
        // Check to ensure that the stack is under capacity
        if (count < capacity)
        {    
            count++;
        // If the stack is full, while loop is run to find and remove the last element from the stack
        } else 
        {
            LinearNode<T> track = top;
            while (track.getNext().getNext() != null) {
                track = track.getNext();
            }
            track.setNext(null);
        }
    }
    
    
    // Removes the element at the top of this stack and returns a reference to it
    public T pop() throws EmptyCollectionException
    {
        if (isEmpty())
        {
            throw new EmptyCollectionException("Drop-out stack");
        }
        T result = top.getElement();
        top = top.getNext();
        count--;
        return result;
    }

    // returns a reference to the topmost element in the stack without removing it
    @Override
    public T peek() {
        if (isEmpty()) 
        {
            throw new EmptyCollectionException("Drop-out stack");
        }
        return top.getElement();
    }

    // boolean check that returns true if the stack is empty
    @Override
    public boolean isEmpty() {
        return (count==0);
    }

    // method to return the size of the stack
    @Override
    public int size() {
        return count;
    }
    
    // String represetantion of drop-out stack, where the topmost element of the stack is printed first
    public String toString() 
    {
        String result = "";
        LinearNode<T> track = top;
        
        while (track != null) {
            result += track.getElement() + "\n";
            track = track.getNext();
        }
        return result;
    }
}