//******************************************************************************
// ArrayListQueue.java
// 
// Karan Bharaj T00693289
// COMP2231 Assignment 3: Question 4
// Class created that use java.util.ArrayList and the QueueADT interface to 
// implement a queue. 
//******************************************************************************

// Import ArrayList from Java API, QueueADT interface and exception for array if empty
import java.util.ArrayList;
import jsjf.QueueADT;
import jsjf.exceptions.EmptyCollectionException;

// Represents a array list implementation of a queue using the QueueADT interface 
public class ArrayListQueue<T> implements QueueADT<T>
{
    private ArrayList<T> list;
    
    // Creates a new empty array list
    public ArrayListQueue()
    {
        list = new ArrayList<T>();
    }
    
    // Adds a new element to the rear of the queue
    @Override
    public void enqueue(T element) 
    {
        list.add(0, element);
    }
    
    // Removes an element from the front of the queue and returns a reference to it
    @Override
    public T dequeue() 
    {
        if (isEmpty()) 
        {
            throw new EmptyCollectionException("queue");
        }
        return list.remove(list.size()-1); 
    }

    // returns a reference to the element at the front of the queue without removing it
    @Override
    public T first() 
    {
        if (isEmpty()) 
        {
            throw new EmptyCollectionException("queue");
        }
        return list.get(list.size()-1);
    }

    // boolean check that returns true if the queue is empty
    @Override
    public boolean isEmpty() 
    {
        return (size() == 0);
    }

    // return the number of elements in the queue
    @Override
    public int size() 
    {
        return list.size();
    }
    
    // String represetantion of the queue, where the topmost element is the front of the queue
    public String toString() 
    {
        if (isEmpty()) 
        {
            return "This queue is empty";
        } else 
        {
            String result = "";
            for (int i=list.size()-1; i >= 0; i--)
            {
                result += list.get(i) + "\n";
            }
            return result;
        }
    }
}
