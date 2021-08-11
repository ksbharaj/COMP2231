//******************************************************************************
// LinkedListQueue.java
// 
// Karan Bharaj T00693289
// COMP2231 Assignment 3: Question 3
// Class created that use java.util.LinkedList and the QueueADT interface to 
// implement a queue. 
//******************************************************************************

// Import LinkedList from Java API, QueueADT interface and exception for array if empty
import java.util.LinkedList;
import jsjf.QueueADT;
import jsjf.exceptions.EmptyCollectionException;

// Represents a linked list implementation of a queue using the QueueADT interface 
public class LinkedListQueue<T> implements QueueADT<T> 
{
    private LinkedList<T> list;
    
    // Creates a new empty linked list
    public LinkedListQueue()
    {
        list = new LinkedList<T>();
    }
    
    // Adds a new element to the rear of the queue
    @Override
    public void enqueue(T element) 
    {
        list.push(element);
    }

    // Removes an element from the front of the queue and returns a reference to it
    @Override
    public T dequeue() 
    {
        if (isEmpty()) 
        {
            throw new EmptyCollectionException("queue");
        }
            return list.removeLast();
    }

    // returns a reference to the element at the front of the queue without removing it
    @Override
    public T first() 
    {
        if (isEmpty()) 
        {
            throw new EmptyCollectionException("queue");
        }
        return list.getLast();
    }

    // boolean check that returns true if the queue is empty
    @Override
    public boolean isEmpty() 
    {
        return (list.size() == 0);
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
