//******************************************************************************
// LinkedDeque.java
// 
// Karan Bharaj T00693289
// COMP2231 Assignment 2: Question 3
// Linked Deque class that implements DequeADT to answer Question 3
//******************************************************************************

package jsjf;

// Import the exception to be used when the stack is empty
import jsjf.exceptions.EmptyCollectionException;

//Represents a deque that implements the DequeADT interface
public class LinkedDeque<T> implements DequeADT<T> 
{
    private int count;
    private LinearNode<T> head, tail;
    private int capacity;
    
    // Creates an empty deque including a "capacity" variable for size restriction 
    public LinkedDeque(int sizeLimit)
    {
        // Error thrown if user tries to specify stack size of zero or less
        if (sizeLimit < 1) 
        {
            throw new EmptyCollectionException("deque");
        } else
        {
            count = 0;
            head = tail = null;
            capacity = sizeLimit;
        }
    }
    
    // adds one element to the front of the deque. Insertion does not happen if the deque is full, and user is informed
    public void enqueueFront(T element)
    {
        LinearNode<T> node = new LinearNode<T>(element);

        if (isEmpty())
        {
            head = node;
            tail = node;
            count++;
        } else
        {
            if (count < capacity) {
                node.setNext(head);
                head.setPrevious(node);
                head = node;
                count++;
            } else 
            {
                System.out.println("This deque is full. Dequeue an element and try queuing again");
            }
        }
    }
    
    // adds one element to the rear of the deque. Insertion does not happen if the deque is full, and user is informed
    public void enqueueRear(T element)
    {
        LinearNode<T> node = new LinearNode<T>(element);

        if (isEmpty())
        {
            head = node;
            tail = node;
            count++;
        } else
        {
            if (count < capacity) {
                tail.setNext(node);
                node.setPrevious(tail);
                tail = node;
                count++;
            } else 
            {
                System.out.println("This deque is full. Dequeue an element and try queuing again");
            }
        }
    }
    
    // removes one element from the front of the deque. Error is thrown if the deque was empty.
    public T dequeueFront() 
    {
        if (isEmpty())
            throw new EmptyCollectionException("Deque");
        
        T result = head.getElement();
        head = head.getNext();
        if (head != null) 
        {
            head.setPrevious(null);
        }
        count--;
        
        if (isEmpty())
            tail = null;
        
        return result;
    }
    
    // removes one element from the rear of the deque. Error is thrown if the deque was empty
    public T dequeueRear() 
    {
        if (isEmpty())
            throw new EmptyCollectionException("Deque");
        
        T result = tail.getElement();
        tail = tail.getPrevious();
        if (tail != null)
        {
            tail.setNext(null);
        }
        count--;
        
        if (isEmpty())
            head = null;
        
        return result;
    }
    
    // returns the frontmost element in the deque without removing it from the deque
    @Override
    public T first() 
    {
        if (isEmpty())
            throw new EmptyCollectionException("Deque"); 

        return head.getElement();
    }
    
    // returns the rearmost element in the deque without removing it from the deque
    @Override
    public T last() 
    {
        if (isEmpty())
            throw new EmptyCollectionException("Deque"); 

        return tail.getElement();
    }
    
    // returns true if the deque is empty
    @Override
    public boolean isEmpty() 
    {
        return (count == 0);
    }
    
    // returns the number of elements in the deque
    @Override
    public int size() 
    {
        return count;
    }
    
    // returns true if the deque is full
    @Override
    public boolean isFull() 
    {
        return (count >= capacity);
    }
    
    // returns a string representation of the deque with the frontmost element at the top and rearmost at the bottom
    public String toString() 
    {
        String stringy = "";
        LinearNode<T> track = head;
        while (track != null) {
            stringy += (track.getElement() + "\n");
            track = track.getNext();
        }
        return stringy;
    }

    
}
