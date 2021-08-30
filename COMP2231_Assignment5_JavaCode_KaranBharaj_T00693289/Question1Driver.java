//******************************************************************************
// Question1Driver.java
// 
// Karan Bharaj T00693289
// COMP2231 Assignment 5: Question 1
// A better heap sort algorithm is tested below, and compared to the old/original 
// heap sort algorithm using a variety of sorted (both in ascending and descending
// order) and random arrays.
//******************************************************************************

import java.util.Arrays;
import java.util.Random;
import jsjf.HeapSort;

public class Question1Driver {
    public static void main(String[] args)
	{
            // RANDOM ARRAYS //
            Integer[] intArray1 = RandomArray(10);
            System.out.println("         ======== QUESTION 1 ========\n");
            System.out.println("===== Example 1 =====");
            System.out.println("----- Array to be sorted: -----");
            System.out.println(Arrays.toString(intArray1));
            HeapSort<Integer> heap1 = new HeapSort<Integer>();
            System.out.println("");
            
            System.out.println("--- Execution of Old Heap Sort Method ---\n");
            heap1.heapSort(Arrays.copyOf(intArray1, intArray1.length));            
            System.out.println("------------------------------\n");
            System.out.println("--- Execution of Better Heap Sort Method ---");
            heap1.betterHeapSort(Arrays.copyOf(intArray1, intArray1.length));
            System.out.println("------------------------------\n\n\n");
            
            System.out.println("===== Example 2 =====");
            Integer[] intArray2 = RandomArray(17);
            System.out.println("----- Array to be sorted: -----");
            System.out.println(Arrays.toString(intArray2));
            HeapSort<Integer> heap2 = new HeapSort<Integer>();
            System.out.println("");
            
            System.out.println("--- Execution of Old Heap Sort Method ---\n");
            heap2.heapSort(Arrays.copyOf(intArray2, intArray2.length));            
            System.out.println("------------------------------\n");
            System.out.println("--- Execution of Better Heap Sort Method ---");
            heap2.betterHeapSort(Arrays.copyOf(intArray2, intArray2.length));
            System.out.println("------------------------------\n\n\n");
            
            System.out.println("===== Example 3 =====");
            Integer[] intArray3 = RandomArray(25);
            System.out.println("----- Array to be sorted: -----");
            System.out.println(Arrays.toString(intArray3));
            HeapSort<Integer> heap3 = new HeapSort<Integer>();
            System.out.println("");
            
            System.out.println("--- Execution of Old Heap Sort Method ---\n");
            heap3.heapSort(Arrays.copyOf(intArray3, intArray3.length));            
            System.out.println("------------------------------\n");
            System.out.println("--- Execution of Better Heap Sort Method ---");
            heap3.betterHeapSort(Arrays.copyOf(intArray3, intArray3.length));
            System.out.println("------------------------------\n\n\n");
            
            // SORTED ARRAY (in ascending order) //           
            System.out.println("===== Example 4 =====");
            Integer[] intArray4 = SortedArray(17);
            System.out.println("----- Array to be sorted: -----");
            System.out.println(Arrays.toString(intArray4));
            HeapSort<Integer> heap4 = new HeapSort<Integer>();
            System.out.println("");
            
            System.out.println("--- Execution of Old Heap Sort Method ---\n");
            heap4.heapSort(Arrays.copyOf(intArray4, intArray4.length));            
            System.out.println("------------------------------\n");
            System.out.println("--- Execution of Better Heap Sort Method ---");
            heap4.betterHeapSort(Arrays.copyOf(intArray4, intArray4.length));
            System.out.println("------------------------------\n\n\n");
            
            // REVERSE SORTED ARRAYS (in descending order) //
            System.out.println("===== Example 5 =====");
            Integer[] intArray5 = ReverseSortedArray(17);
            System.out.println("----- Array to be sorted: -----");
            System.out.println(Arrays.toString(intArray5));
            HeapSort<Integer> heap5 = new HeapSort<Integer>();
            System.out.println("");
            
            System.out.println("--- Execution of Old Heap Sort Method ---\n");
            heap5.heapSort(Arrays.copyOf(intArray5, intArray5.length));            
            System.out.println("------------------------------\n");
            System.out.println("--- Execution of Better Heap Sort Method ---");
            heap5.betterHeapSort(Arrays.copyOf(intArray5, intArray5.length));
            System.out.println("------------------------------\n\n\n");
            
            System.out.println("===== Example 6 =====");
            Integer[] intArray6 = ReverseSortedArray(25);
            System.out.println("----- Array to be sorted: -----");
            System.out.println(Arrays.toString(intArray6));
            HeapSort<Integer> heap6 = new HeapSort<Integer>();
            System.out.println("");
            
            System.out.println("--- Execution of Old Heap Sort Method ---\n");
            heap6.heapSort(Arrays.copyOf(intArray6, intArray6.length));            
            System.out.println("------------------------------\n");
            System.out.println("--- Execution of Better Heap Sort Method ---");
            heap6.betterHeapSort(Arrays.copyOf(intArray6, intArray6.length));
            System.out.println("------------------------------\n\n\n");
        }
    
    // Method used to generate Integer array with random values at specified size
    private static Integer[] RandomArray(int size) 
    {
        // Integer array initialised
        Integer[] array = new Integer[size];
        // Random number generator called
        Random random = new Random();
        
        // for loop to add random numbers to the Integer array
        for(int i=0; i<size; i++) 
        {
            Integer int1 = random.nextInt(size);
            Integer int2 = random.nextInt(size);
            array[i] = int1 + int2;
        }
        return array;
    }
    
    private static Integer[] SortedArray(int size) 
    {
        // Integer array initialised
        Integer[] array = new Integer[size];
        
        // for loop to add numbers in ascending order from 0
        for(int i=0; i<size; i++) 
        {
            array[i] = i;
        }
        return array;
    }
    
    private static Integer[] ReverseSortedArray(int size) 
    {
        // Integer array initialised
        Integer[] array = new Integer[size];
        // for loop to add numbers in descending order till 1
        for(int i=0; i<size; i++) 
        {
            array[i] = size-i;
        }
        return array;
    }
}
