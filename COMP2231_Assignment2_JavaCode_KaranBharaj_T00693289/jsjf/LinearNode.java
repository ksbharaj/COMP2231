//******************************************************************************
// LinearNode.java
// 
// Karan Bharaj T00693289
// COMP2231 Assignment 2: Question 3
// LinearNode.java class modified to include a "previous" variable reference
//******************************************************************************

package jsjf;

/**
* Represents a node in a linked list.
*
* @author Java Foundations
* @version 4.0
*/
// similar to "next", a variable called "previous" is introduced
public class LinearNode<T>
{
    private LinearNode<T> next;
    private T element;
    private LinearNode<T> previous;
    
    /**
    * Creates an empty node.
    */
    // similar to "next", "previous" is also initialised as null
    public LinearNode()
    {
        next = null;
        element = null;
        previous = null;
    }
    
    /**
    * Creates a node storing the specified element.
    * @param elem element to be stored
    */
    // similar to "next", "previous" is also initialised as null
    public LinearNode(T elem)
    {
        next = null;
        element = elem;
        previous = null;
    }
    
    /**
    * Returns the node that follows this one.
    * @return reference to next node
    */
    public LinearNode<T> getNext() {
        return next;
    }
    
    /**
    * Returns the node that precedes this one.
    * @return reference to previous node
    */
    // new method added to return the previous node
    public LinearNode<T> getPrevious() {
        return previous;
    }
    
    /**
    * Sets the node that follows this one.
    * @param node node to follow this one
    */
    public void setNext(LinearNode<T> node) {
        next = node;
    }
    
    /**
    * Sets the node that follows this one.
    * @param node node to follow this one
    */
    // new method set the node that precedes this one
    public void setPrevious(LinearNode<T> node) {
        previous = node;
    }
    
    /**
    * Returns the element stored in this node.
    * @return element stored at the node
    */
    public T getElement() {
        return element;
    }
    
    /**
    * Sets the element stored in this node.
    * @param elem element to be stored at this node
    */
    public void setElement(T elem)
    {
        element = elem;
    }
}