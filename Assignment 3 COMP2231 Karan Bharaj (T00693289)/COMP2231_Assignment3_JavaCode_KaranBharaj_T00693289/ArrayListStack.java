//******************************************************************************
// ArrayListStack.java
// 
// Karan Bharaj T00693289
// COMP2231 Assignment 3: Question 2
// Class created that use java.util.ArrayList and the StackADT interface to 
// implement a stack. 
//******************************************************************************

// Import ArrayList from Java API, StackADT interface and exception for array if empty
import java.util.ArrayList;
import jsjf.StackADT;
import jsjf.exceptions.EmptyCollectionException;

// Represents an array list implementation of a Stack using the StackADT interface 
public class ArrayListStack<T> implements StackADT<T> 
{
    private ArrayList<T> list;
    
    // Creates an empty array list
    public ArrayListStack()
    {
        list = new ArrayList<T>();
    }
    
    // Adds a new element to the top of the stack
    @Override
    public void push(T element) {
        list.add(0, element);
    }
    
    // Removes the element at the top of this stack and returns a reference to it
    @Override
    public T pop() {
        if (isEmpty())
        {
            throw new EmptyCollectionException("stack");
        }
        return list.remove(0);
    }
    
    // returns a reference to the element at the top of the stack without removing it
    @Override
    public T peek() {
        if (isEmpty()) 
        {
            throw new EmptyCollectionException("stack");
        } 
        return list.get(0);
    }

    // boolean check that returns true if the stack is empty
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // return the number of elements in the stack
    @Override
    public int size() {
        return list.size();
    }
    
    // String representation of the stack, where the topmost element of the stack is printed first
    public String toString() 
    {
        if (isEmpty()) {
            return "This Stack is empty";
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
