//******************************************************************************
// BookEntry.java
// 
// Karan Bharaj T00693289
// COMP2231 Assignment 5: Question 3
// Books are added into a hash table with book names as a "BookEntry" object. 
// This object is as shown below, created to help answer the requirements of 
// question 3.
//******************************************************************************

package jsjf;

// Create a class for the book entry as shown below
public class BookEntry {
    
    // holds the ISBN as the "key" of the entry
    private String key;
    
    // contains the name of the book 
    private String name;
    
    // holds a varaible that tracks whether the book has been deleted or not
    private boolean deleted;
    
    // To create an instance of the book, the key (ISBN) and name must be provided, 
    // and both are assigned accordingly
    public BookEntry(String key, String name)
    {
        this.key = key;
        this.name = name;
        
        // the delete status of the book is set to false initially
        this.deleted = false;
    }
    
    // method to return the key/ISBN as a string
    public String getKey()
    {
        return key;
    }
    
    // method to return the name of the book as a string
    public String getName()
    {
        return name;
    }
    
    // method to return the printout of the book with its key/ISBN and name
    public String toString()
    {
        return key + ": " + name;
    }
    
    // method to assign whether the book was deleted or not
    public void setDeleteStatus(boolean status)
    {
        deleted = status;
    }
    
    // method to return whether the book is deleted or not (as a boolean)
    public boolean getDeleteStatus()
    {
        return deleted;
    }    
}
