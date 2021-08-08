//******************************************************************************
// DequeADT.java
// 
// Karan Bharaj T00693289
// COMP2231 Assignment 2: Question 3
// Linked Deque class that implements DequeADT to answer Question 3
//******************************************************************************

// Part of the "jsjf" packages
package jsjf;

// Defines the interface to a double-ended queue (deque) collection
public interface DequeADT<T> 
{
    // adds one element to the front of the deque
    public void enqueueFront(T element);
    
    // adds one element to the rear of the deque
    public void enqueueRear(T element);

    // removes and returns the frontmost element in the deque
    public T dequeueFront();
    
    // removes and returns the rearmost element in the deque
    public T dequeueRear();

    // returns the frontmost element in the deque without removing it from the deque
    public T first();
    
    // returns the rearmost element in the deque without removing it from the deque
    public T last();

    // returns true if the deque is empty
    public boolean isEmpty();
    
    // returns true if the deque is full
    public boolean isFull();

    // returns the number of elements in the deque
    public int size();

    // returns a string representation of the deque
    public String toString();
    
}
