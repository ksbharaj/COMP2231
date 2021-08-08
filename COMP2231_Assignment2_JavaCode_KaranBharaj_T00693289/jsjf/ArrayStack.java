//******************************************************************************
// ArrayStack.java
// 
// Karan Bharaj T00693289
// COMP2231 Assignment 1: Question 1
// Modified ArrayStack where stack[top] points to the actual top of the stack 
// without using counter variables. All modified methods include one liner 
// comments. Those without modfications do not have any additional comments
//******************************************************************************

package jsjf;

// Import the exception to be used when the stack is empty
import jsjf.exceptions.EmptyCollectionException;
// Import the java.util.Arrays for Arrays.copyOf to expand capacity of the stack
import java.util.Arrays;

/**
* An array implementation of a stack in which the
* bottom of the stack is fixed at index 0.
*
* @author Java Foundations
* @version 4.0
*/
public class ArrayStack<T> implements StackADT<T>
{
    private final static int DEFAULT_CAPACITY = 100;
    private int top;
    private T[] stack;

    /**
    * Creates an empty stack using the default capacity.
    */
    public ArrayStack()
    {
        this(DEFAULT_CAPACITY);
    }
    
    /**
    * Creates an empty stack using the specified capacity.
    * @param initialCapacity the initial size of the array
    */
    // Top the array has a value of -1 initially so it matches index of topmost element in stack once the stack populates
    public ArrayStack(int initialCapacity)
    {
        top = -1;
        stack = (T[])(new Object[initialCapacity]);
    }
    
    /**
    * Adds the specified element to the top of this stack, expanding
    * the capacity of the array if necessary.
    * @param element generic element to be pushed onto stack
    */
    // Method changed to first increment "top" variable and then add the new element
    public void push(T element)
    {
        if (size() == stack.length) 
        {
            expandCapacity();
        }
        
        top++;
        stack[top] = element;
    }
    /**
    * Creates a new array to store the contents of this stack with
    * twice the capacity of the old one.
    */
    private void expandCapacity()
    {
        stack = Arrays.copyOf(stack, stack.length * 2);
    }
    
    /**
    * Removes the element at the top of this stack and returns a
    * reference to it.
    * @return element removed from top of stack
    * @throws EmptyCollectionException if stack is empty
    */
    //Method changed to first remove the top element in the stack, and then decrement the "top" variable
    public T pop() throws EmptyCollectionException
    {
    if (isEmpty())
        {
            throw new EmptyCollectionException("stack");
        }
        T result = stack[top];
        stack[top] = null;
        top--;
        
        return result;
    }
    
    /**
    * Returns a reference to the element at the top of this stack.
    * The element is not removed from the stack.
    * @return element on top of stack
    * @throws EmptyCollectionException if stack is empty
    */
    
    // Method changed to directly use "top variable" (instead of "top - 1") to correctly show topmost element
    public T peek() throws EmptyCollectionException
    {
        if (isEmpty()) 
        {
            throw new EmptyCollectionException("stack");
        }
        
        return stack[top];
    }

    // Method now checks whether the stack size is equal to zero 
    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    // Method now returns stack size by adding one to index of the top-most element (i.e. the "top" variable value)
    @Override
    public int size() {
        return (top + 1);
    }
    
    // String representation of array stack modified such that topmost element is shown at the top of printout
    public String toString() 
    {
        if (isEmpty()) {
            return "This Stack is empty";
        } else 
        {
            String result = "";
            for (int i=top; i >= 0; i--)
            {
                result += stack[i] + "\n";
            }
            return result;
        }
    }
}