//******************************************************************************
// LinkedListStack.java
// 
// Karan Bharaj T00693289
// COMP2231 Assignment 3: Question 1
// Class created that use java.util.LinkedList and the StackADT interface to 
// implement a stack. 
//******************************************************************************

// Import LinkedList from Java API, StackADT interface and exception for array if empty
import java.util.LinkedList;
import jsjf.StackADT;
import jsjf.exceptions.EmptyCollectionException;

// Represents a linked list implementation of a Stack using the StackADT interface 
public class LinkedListStack<T> implements StackADT<T> 
{
    private LinkedList<T> list;
    
    // Creates a new empty linked list
    public LinkedListStack()
    {
        list = new LinkedList<T>();
    }

    // Adds a new element to the top of the stack
    @Override
    public void push(T element) 
    {
        list.push(element);
    }

    // Removes the element at the top of this stack and returns a reference to it
    @Override
    public T pop() 
    {
        if (isEmpty())
        {
            throw new EmptyCollectionException("stack");
        } 
        return list.pop();
    }

    // returns a reference to the element at the top of the stack without removing it
    @Override
    public T peek() 
    {
        if (isEmpty()) 
        {
            throw new EmptyCollectionException("stack");
        }
        return list.peek();
    }

    // boolean check that returns true if the stack is empty
    @Override
    public boolean isEmpty() 
    {
        return (list.size() == 0);
    }

    // return the number of elements in the stack
    @Override
    public int size() 
    {
        return list.size();
    }   
    
    // String representation of the stack, where the topmost element of the stack is printed first
    public String toString() 
    {
        if (isEmpty()) {
            return "This stack is empty";
        } else 
        {
            String result = "";
            for (int i=0; i < list.size(); i++)
            {
                result += list.get(i) + "\n";
            }
            return result;
        }
    }
}
