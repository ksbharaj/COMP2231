//******************************************************************************
// Questions1and2Driver.java
// 
// Karan Bharaj T00693289
// COMP2231 Assignment 1: Questions 1 and 2
// This application executes methods in "Sorting.java" and "SortMetrics.java",
// such that the instructions laid out in Questions 1 and Questions 2 are answered.
//******************************************************************************
        
import java.util.Arrays;
import java.util.Random;

public class Questions1and2Driver 
{
    public static void main(String[] args) 
    {
        // Integer array initialised with example array
        int[] array = {9, 6, 8, 12, 3, 1, 7};
 
        System.out.println("--------------QUESTION 1--------------");
        
        System.out.println("=============EXAMPLE ARRAY=============");
        // Printout of example array
        System.out.println("Array: " + Arrays.toString(array));
        // Example array sorted using Shell Sort and the array is printed out after each pass
        SortMetrics exampleShellSort = Sorting.shellSort(array);
        System.out.println(exampleShellSort);
        
        System.out.println("=============RANDOM ARRAY OF SIZE 10===============");
        // Random Integer array of size 10 created and printed out
        int[] randomArray10 = RandomArray(10);
        System.out.println("Array: " + Arrays.toString(Arrays.copyOf(randomArray10, randomArray10.length)));
        // Random array sorted using Shell Sort and the array is printed out after each pass
        SortMetrics randomShellSort10 = Sorting.shellSort(Arrays.copyOf(randomArray10, randomArray10.length));
        System.out.println(randomShellSort10);
        
        System.out.println("=============RANDOM ARRAY OF SIZE 20===============");
        // Random Integer array of size 20 created and printed out
        int[] randomArray20 = RandomArray(20);
        System.out.println("Array: " + Arrays.toString(randomArray20));
        // Random array sorted using Shell Sort and the array is printed out after each pass
        SortMetrics randomShellSort20 = Sorting.shellSort(randomArray20);
        System.out.println(randomShellSort20);
        
        System.out.println("--------------QUESTION 2--------------");
        
        System.out.println("\n========OLD BUBBLE SORT RANDOM ARRAY OF SIZE 10========");
        // New random Integer array of size 10 created and printed out
        System.out.println("Array: " + Arrays.toString(Arrays.copyOf(randomArray10, randomArray10.length)));
        // Copy of random array sorted using Old Bubble Sort and the array is printed out after each pass
        SortMetrics bubbleSortRandom10 = Sorting.bubbleSort(Arrays.copyOf(randomArray10, randomArray10.length));
        System.out.println(bubbleSortRandom10);
        
        System.out.println("========NEW BUBBLE SORT RANDOM ARRAY OF SIZE 10========");
        // Copy of random array sorted using BubbleSort2 and the array is printed out after each pass
        System.out.println("Array: " + Arrays.toString(Arrays.copyOf(randomArray10, randomArray10.length)));
        SortMetrics bubbleSort2Random10 = Sorting.bubbleSort2(Arrays.copyOf(randomArray10, randomArray10.length));
        System.out.println(bubbleSort2Random10);
             
        System.out.println("========OLD BUBBLE SORT SORTED ARRAY OF SIZE 10========");
        // New sorted Integer array of size 10 created and printed out
        int[] sortedArray10 = SortedArray(10);
        System.out.println("Array: " + Arrays.toString(sortedArray10));
        // Copy of sorted array sorted using Old Bubble Sort and the array is printed out after each pass
        SortMetrics bubbleSortSorted10 = Sorting.bubbleSort(sortedArray10.clone());
        System.out.println(bubbleSortSorted10);
        
        System.out.println("========NEW BUBBLE SORT SORTED ARRAY OF SIZE 10========");
        // Copy of sorted array sorted using BubbleSort2 and the array is printed out after each pass
        System.out.println("Array: " + Arrays.toString(sortedArray10));
        SortMetrics bubbleSort2Sorted10 = Sorting.bubbleSort2(sortedArray10.clone());
        System.out.println(bubbleSort2Sorted10);
    }
    
    // Method used to generate Integer array with random values at specified size
    private static int[] RandomArray(int size) 
    {
        // Integer array initialised
        int[] array = new int[size];
        // Random number generator called
        Random random = new Random();
        // For loop to add random numbers to the Integer array
        for(int i=0; i<size; i++) 
        {
            array[i] = random.nextInt(size*2) + 1;
        }
        return array;
    }
    
    // Method used to generate Integer array with sorted values in ascending order at specified size
    private static int[] SortedArray(int size) 
    {
        // Integer array initialised
        int[] array = new int[size];
        // For loop to add numbers in ascending order from 0
        for(int i=0; i<size; i++) 
        {
            array[i] = i;
        }
        return array;
    }
}
