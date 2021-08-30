//******************************************************************************
// BookNamesHashTable.java
// 
// Karan Bharaj T00693289
// COMP2231 Assignment 5: Question 3
// New class created that is a hash table that takes a "BookEntry" object. Designed
// to answer the requirements of question 3 i.e. 
//******************************************************************************

package jsjf;

// Class created that holds BookEntry objects
public class BookNamesHashTable<T>
{
    private BookEntry[] hashTable;
    // "count" variable to keep track of number of books in the hash table
    private int count;
    // "capacity" is the maximum number of books the table can hold
    private int capacity;
    // the number of books, when surpassed, enforces an expansion in capacity
    private int threshold;
    // factor, when multiplied with the capacity, derives the threshold
    private double loadFactor;
    
    // An instance of this class can be initilaised by sepcifying an initial capacity and load factor
    public BookNamesHashTable(int initialCapacity, double loadFactor)
    {
        // If the initally capacity or the load factor is incorrectly specified, errors are thrown         
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        if (loadFactor <= 0 || Double.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal Load: " + loadFactor);
        
        // capacity and loadFactor are assigned, and threshold is calculated and assigned accordingly
        this.capacity = initialCapacity;
        this.loadFactor = loadFactor;
        this.threshold = (int) (capacity * loadFactor);
        
        // a new hashtable is created as an array of BookEntries according to specified capacity
        hashTable = new BookEntry[initialCapacity];
    }
    
    // Method to return the hash value based on the key of BookEntry (i.e. ISBN)
    private int getHash(String key, int length) {
        // extracts the last 3 digits of the key/ISBN, and uses the remainder of its 
        // division by the length specified
        int value = Integer.parseInt(key.substring(7,10));
        return value % length;
    }
    
    // Method to enter a new book entry into the hash table
    public void put(String key, String name) {
        
        // If the new entry exceed the threshold, the hash table is expanded and rehashed
        if ((count + 1) > threshold)
        {
            expandCapacityAndRehash();
        }
        
        // "hashIndex" calculated and assigned using the getHash method
        int hashIndex = getHash(key, capacity);
        
        // if the hash table location at the index is vacant, then the new Book Entry is added
        if (hashTable[hashIndex] == null || hashTable[hashIndex].getDeleteStatus() == true)
        {
            hashTable[hashIndex] = new BookEntry(key, name);
        
        // Otherwise, there is a collision
        } else
        {
            System.out.println("COLLISION! " + name + " can't go in at " +  (hashIndex+1));
            
            // until a vacant slot is available, linear probing is used to determine the next
            // available vacant slot in the hash table
            while (hashTable[hashIndex] != null) {
                if (hashTable[hashIndex].getDeleteStatus() == true)
                {
                    break;
                }
                hashIndex = (hashIndex + 1) % capacity;
            }
            
            // The new BookEntry is added to the hash table
            hashTable[hashIndex] = new BookEntry(key, name);
            System.out.println("Instead, " + name + " will go in at " +  (hashIndex+1) + "\n");
            
        }
        // count is incremented
        count++;
    }
    
    // private method that returns the index of a BookEntry based on its key (i.e. ISBN)
    private int findIndex(String key) 
    {
        // determine the from the key/ISBN and assign it as the "hashIndexToFind" variable 
        int hashIndexToFind = getHash(key, capacity);
        
        // if hashIndexToFind is empty, return -1
        if (hashTable[hashIndexToFind] == null)
        {
            return -1;
        
        // if the specified key/ISBN matches with the key/ISBN in the table at 
        // "hashIndexToFind", the key/ISBN is found and the index is returned
        } else if (hashTable[hashIndexToFind].getKey().equals(key))
        {
            if (hashTable[hashIndexToFind].getDeleteStatus() == true)
            {
                return -1;
            } else
            {
                return hashIndexToFind;
            }
            
        // Otherwise, cycle thorugh the hash table to find a match between the keys/ISBNs
        } else 
        {
            // assign "hashIndexToFind" to a "startingIndex" variable
            int startingIndex = hashIndexToFind;
            
            // increment "hashIndexToFind", and cycle to the top if last index is surpassed
            hashIndexToFind = (hashIndexToFind + 1) % capacity;
            
            // while entry at index exists or a full cycle of the table is not completed, continue in while loop
            while ((hashTable[hashIndexToFind].getKey() != null)  || (hashIndexToFind != startingIndex))
            {
                // if the keys/ISBNs match and the entry was not been deleted, index is returned.
                if (hashTable[hashIndexToFind].getKey().equals(key))
                {
                    if (hashTable[hashIndexToFind].getDeleteStatus() == false)
                    {
                        return hashIndexToFind;
                    // if the keys/ISBNs match and the entry was deleted, -1 is returned.
                    } else
                    {
                        return -1;
                    }
                }
                // if the keys/ISBNs did not match, simply move to next possible cell in the table
                hashIndexToFind = (hashIndexToFind + 1) % capacity;
            }
            
            // return -1 if none of the aforementioned criteria is met
            return -1;
        }
    } 
    
    // method to return the BookEntry object if the book is found in the table by using its key/ISBN
    public BookEntry find (String key)
    {
        // the Book's index in the hash table is found using the "findIndex()" method
        int bookIndex = findIndex(key);
        
        // if the index returned is -1, the book was not found in the table
        if (bookIndex == -1)
        {
            System.out.println("Sorry, your book was not found in the table");
            return null;
        }
        
        // if an acceptable index is returned, the book at that index position is returned from the table
        else 
        {
            return (hashTable[bookIndex]);
        }
    }
    
    // method to delete a book when given the key/ISBN 
    public void delete (String key)
    {
        // the Book's index in the hash table is found using the "findIndex()" method
        int bookIndex = findIndex(key);
        
         // if the index returned is -1, the book was not found in the table
        if (bookIndex == -1)
        {
            System.out.println("Sorry, your book was not found in the table, so couldn't be deleted");
        }
        
        // if an acceptable index is returned, the book at that index position is is marked as deleted
        else
        {
            hashTable[bookIndex].setDeleteStatus(true);
            count--;
        }
    }
    
    // method to expand the capacity of the hash table and rehash its contents 
    private void expandCapacityAndRehash()
    {
        // printout to notify the user about the expansion and rehash
        System.out.println("Capacity threshold reached! Table to be expanded and rehashed\n");
        
        // Create a new hash table with twice the capacity
        BookNamesHashTable newHashTable = new BookNamesHashTable(getCapacity() * 2, loadFactor);
        
        // each book in the existing table is added to its "hashed" index position in the new hash table
        for (int i = 0; i < getCapacity(); i++)
        {
            if (hashTable[i] != null)
            {
                newHashTable.put(hashTable[i].getKey(), hashTable[i].getName());
            }
        }
        
        // allcoate the new table as the current table
        this.hashTable = newHashTable.hashTable;
        this.capacity = newHashTable.capacity;
        this.threshold = (int) (capacity * loadFactor);
    }
    
    // method to return the capacity of the current hash table
    public int getCapacity() 
    {
        return capacity;
    }
    
    // method to return the number of books in the hash table
    public int numberOfBooks()
    {
        return count;
    }
    
    // method to display the contents of the hash table
    public String toString() {
        String output = "";
        
        output += "--------------------------------------\n";
        for (int i = 0; i < getCapacity(); i++)
        {
            output += (" " + (i+1) + " | ");
            if (hashTable[i] != null)
            {
                if (hashTable[i].getDeleteStatus() == false)
                {
                    output += hashTable[i];
                }
            }
            output += "\n----------------------------------\n";
        }
        
        return output;
    }
}
