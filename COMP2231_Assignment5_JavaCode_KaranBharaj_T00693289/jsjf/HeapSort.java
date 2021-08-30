//******************************************************************************
// HeapSort.java
// 
// Karan Bharaj T00693289
// COMP2231 Assignment 5: Question 1
// Implementation of HeapSort.java that intends to make the algorithm more efficient
// by building a heap in place using the array to be sorted. 
//******************************************************************************

package jsjf;

import java.util.Arrays;

/**
 * HeapSort sorts a given array of Comparable objects using a heap.
 * 
 * @author Java Foundations
 * @version 4.0
 */
public class HeapSort<T>
{
    /**
     * Sorts the specified array using a Heap
     *
     * @param data the data to be added to the heapsort
     */
    
    protected int operationCount;
    
    public HeapSort() 
    {
        // the number of operations/comparisons is initially set to zero
        operationCount = 0;
    }
    
    public void heapSort(T[] data) 
    {
        ArrayHeap<T> heap = new ArrayHeap<T>();

        // copy the array into a heap 
        for (int i = 0; i < data.length; i++)
            heap.addElement(data[i]);
        
        // Printout the number of comparisons made during the "add" operation  
        int additionOperations = heap.numberOfOperations();
        System.out.println("Number of comparisons from addition of elements: " + additionOperations + "\n");
        
        // Printout of array before the "remove operation"
        System.out.println("Printout of heap after \"add\" operation and before \"remove\" ");
        System.out.println(heap + "\n");
        
        // place the sorted elements from the heap back into the array 
        int count = 0;
        while (!(heap.isEmpty()))
        {
            data[count] = heap.removeMin();
            count++;
        }
        
        // Printout the number of comparisons made during the "remove" operation        
        System.out.println("Number of removals from heap: " + (heap.numberOfOperations() - additionOperations) + "\n");
        
        // Printout the final, sorted array
        System.out.println("YOUR SORTED ARRAY: " + Arrays.toString(data));
    }
        
    // Method that implements the improved HeapSort
    public void betterHeapSort(T[] data)
    {
        // Size variable defined to capture length
        int size = data.length;
        
        // Determine the height of the array
        int h = (int) (Math.log(size)/(Math.log(2)));

        // Subtract the size of the array by the maximum number of nodes in all
        // levels with no leaves
        int leaves = (int) (size - (Math.pow(2,h) - 1));

        // Determine the index of the first non-leaf node
        int n = 0;
        if (size > 3)
        {
            n = (int) ((Math.pow(2,h-1) - 1) + (((leaves-1)/2)));
        }

        // Values are swapped according to the "recursiveSwap" function up to and 
        // until the index of the root is reached. This sorts the array
        while (n >= 0)
        {
            data = recursiveSwap(data, n);
            n -= 1;
        }
        
        // New array heap of the sorted array is created
        ArrayHeap<T> heap = new ArrayHeap<T>(data);
        
        // Printout the number of comparisons made during the "add" operation 
        System.out.println("\nNumber of comparisons from addition of elements: " + numberOfOperations());
        
        // Printout the value of the first non-leaf node
        System.out.println("\nPrintout of the sorted array as a heap: ");
        System.out.println(heap + "\n");
        
        // remove elements from the heap back into the original array 
        int count = 0;
        while (!(heap.isEmpty()))
        {
            data[count] = heap.removeMin();
            count++;
        }
        
        // Printout the number of comparisons made during the "remove" operation 
        System.out.println("Number of removals from heap: " + (heap.numberOfOperations()) + "\n");
        
        // Printout the final, sorted array
        System.out.println("YOUR SORTED ARRAY: " + Arrays.toString(data));
    }
       
    // Method to recursively swap nodes with their children until the given node does not have a child smaller than it
    public T[] recursiveSwap(T[] data, int n)
    {
        // variable "swap" helps track whether a swap took place previously
        boolean swap = true;

        // whilst a "swap" took place in the previous cycle, execute this loop
        while (swap == true)
        {
            // setting "swap" to false ensures we get a swap in this pass
            swap = false;
            
            // "value" is set as the value of the index we are currently on. 
            T value = data[n];
            
            // the right and left child of "value" are both initially set as "null"
            T right = null;
            T left = null;
            
            // variable helps track the number of swaps that happen for a non-leaf node
            int swapChecker = 0;

            // If the value has a child, they are assigned their values from the array, otherwise these remain as "null"
            try
            {
                left = data[2*n + 1];
                right = data[2*(n + 1)];
            } catch (Exception e)
                {
                }
        
            // If we are at a leaf node, then we exit the while loop
            if (right == null & left == null)
            {
                break;
            }
            
            // if the node has a right child, a swap takes place if the right child's value is smaller than the node's value
            if (right != null)
                {
                if ((((Comparable) value).compareTo(right) > 0)) 
                    {
                    // the comparison is recorded in the operation count
                    operationCount += 1;
                    
                    // The array, and "value", "right" and "swap" variables are updated due to the swap
                    data[n] = right;
                    data[2*(n + 1)] = value;
                    value = data[n];
                    right = data[2*(n + 1)];
                    swap = true;
                    
                    // "swapChecker" is updated to indicate a swap with the right child
                    swapChecker += 1;
                    }
                }
            
            // if the node has a left child, a swap takes place if the left child's value is smaller than the node's value
            if (left != null)
                {
                if ((((Comparable) value).compareTo(left) > 0)) 
                    {
                    // the comparison is recorded in the operation count
                    operationCount += 1;
                    
                    // The array, and "value", "left" and "swap" variables are updated due to the swap
                    data[n] = left;
                    data[2*n + 1] = value;
                    value = left;
                    left = data[2*n + 1];
                    swap = true;
                    
                    // "swapChecker" is updated to indicate a swap with the left child
                    swapChecker -= 1;
                    }
                }
            
            // Depending on the value of "swapChecker", the node to use for the next iteration can be assigned
            // If a swap occurred with the left child, swapchecker is 0 or less, and "n" is assigned as shown below
            if (swapChecker <= 0 && swap == true)
                {
                    n = 2*n + 1;
                }
            // If a swap occurred with the right child, then "n" is assigned as shown below
            else if ((swapChecker == 1 && swap == true))
                {
                    n = 2*(n + 1);
                }            
        }
        // The updated array is returned after exiting the "while" loop
        return data;
    }
    
    // method to return the number of comparisons/operations counted
    public int numberOfOperations()
    {
        return operationCount;
    }

}