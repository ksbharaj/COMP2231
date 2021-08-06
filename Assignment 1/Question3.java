//******************************************************************************
// Question3.java
// 
// Karan Bharaj T00693289
// COMP2231 Assignment 1: Question 3
// This application executes methods in "Sorting.java", such that the
// instructions laid out in Question 3 are answered.
//******************************************************************************

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class Question3 
{
    public static void main(String[] args) throws FileNotFoundException
    {
        // Create integer list of array sizes to be sorted
        int[] sizes = {10, 100, 1000, 10000, 100000};
        
        // Number of iterations specified to get fair and unbiased approximations
        int iterations = 20;
    
        // Initialising 6 2D long arrays that each have 5 columns to capture the 
        // array size, comparisons, swaps, passes and runtimes
        long[][] ShellSortDataRandom = new long[sizes.length*iterations][5];
        long[][] BubbleSortDataRandom = new long[sizes.length*iterations][5];
        long[][] BubbleSort2DataRandom = new long[sizes.length*iterations][5];
        long[][] ShellSortDataSorted = new long[sizes.length*iterations][5];
        long[][] BubbleSortDataSorted = new long[sizes.length*iterations][5];
        long[][] BubbleSort2DataSorted = new long[sizes.length*iterations][5];
        
        // Keeps track of the number of passes through subsequnt loop
        int counter = 0;
                        
        for (int i=0; i<sizes.length; i++) 
        {
            // Specify size of array to be generated
            int size = sizes[i];
            
            for (int j=0; j<iterations; j++) 
            {
            
            System.out.println("=============================================");
            // Printout the Iteration number
            System.out.println("Iteration #: " + (j+1));
            System.out.println("================RANDOM ARRAY=================");
            // Printout the size of the Array
            System.out.println("Size of Array: " + size);
            // Random Integer array of specified size created
            int[] randomArray = RandomArray(size);
            System.out.println("=============================================");
            System.out.println("---------------Shell Sort----------------"); 
            // Copy of the random array is sorted using Shell Sort and metrics are printed out
            SortMetrics randomShellSort = Sorting.shellSort(Arrays.copyOf(randomArray, randomArray.length));
            System.out.println(randomShellSort);
            // Metrics data then added to relevant Shell Sort array
            ShellSortDataRandom[counter][0] = size;
            ShellSortDataRandom[counter][1] = randomShellSort.getComparisons();
            ShellSortDataRandom[counter][2] = randomShellSort.getSwaps();
            ShellSortDataRandom[counter][3] = randomShellSort.getPasses();
            ShellSortDataRandom[counter][4] = randomShellSort.getDurationTime();
            System.out.println("---------------------------------------------");
            System.out.println("---------------Bubble Sort----------------");
            // Copy of the random array is sorted using Old Bubble Sort and metrics are printed out
            SortMetrics randomOldBubbleSort = Sorting.bubbleSort(Arrays.copyOf(randomArray, randomArray.length));
            System.out.println(randomOldBubbleSort);
            // Metrics data then added to relevant Old Bubble Sort array
            BubbleSortDataRandom[counter][0] = size;
            BubbleSortDataRandom[counter][1] = randomOldBubbleSort.getComparisons();
            BubbleSortDataRandom[counter][2] = randomOldBubbleSort.getSwaps();
            BubbleSortDataRandom[counter][3] = randomOldBubbleSort.getPasses();
            BubbleSortDataRandom[counter][4] = randomOldBubbleSort.getDurationTime();
            System.out.println("---------------------------------------------");
            System.out.println("----------------Bubble2 Sort------------------");
            // Copy of the random array is sorted using New Bubble Sort and metrics are printed out
            SortMetrics randomNewBubbleSort = Sorting.bubbleSort2(Arrays.copyOf(randomArray, randomArray.length));
            System.out.println(randomNewBubbleSort);
            // Metrics data then added to relevant New Bubble Sort array
            BubbleSort2DataRandom[counter][0] = size;
            BubbleSort2DataRandom[counter][1] = randomNewBubbleSort.getComparisons();
            BubbleSort2DataRandom[counter][2] = randomNewBubbleSort.getSwaps();
            BubbleSort2DataRandom[counter][3] = randomNewBubbleSort.getPasses();
            BubbleSort2DataRandom[counter][4] = randomNewBubbleSort.getDurationTime();
            System.out.println("---------------------------------------------");
            System.out.println("=============================================");
            System.out.println("================SORTED ARRAY=================");
            // Printout the size of the Array
            System.out.println("Size of Array: " + size);
            // Sorted Integer array of specified size created
            int[] sortedArray = SortedArray(size);
            System.out.println("=============================================");
            System.out.println("---------------Shell Sort----------------");
            // Copy of the sorted array is sorted using Shell Sort and metrics are printed out
            SortMetrics sortedShellSort = Sorting.shellSort(Arrays.copyOf(sortedArray, sortedArray.length));
            System.out.println(sortedShellSort);
            // Metrics data then added to relevant Shell Sort array
            ShellSortDataSorted[counter][0] = size;
            ShellSortDataSorted[counter][1] = sortedShellSort.getComparisons();
            ShellSortDataSorted[counter][2] = sortedShellSort.getSwaps();
            ShellSortDataSorted[counter][3] = sortedShellSort.getPasses();
            ShellSortDataSorted[counter][4] = sortedShellSort.getDurationTime();
            System.out.println("---------------------------------------------");
            System.out.println("---------------Bubble Sort----------------"); 
            // Copy of the sorted array is sorted using Old Bubble Sort and metrics are printed out
            SortMetrics sortedOldBubbleSort = Sorting.bubbleSort(Arrays.copyOf(sortedArray, sortedArray.length));
            System.out.println(sortedOldBubbleSort);
            // Metrics data then added to relevant Old Bubble Sort array
            BubbleSortDataSorted[counter][0] = size;
            BubbleSortDataSorted[counter][1] = sortedOldBubbleSort.getComparisons();
            BubbleSortDataSorted[counter][2] = sortedOldBubbleSort.getSwaps();
            BubbleSortDataSorted[counter][3] = sortedOldBubbleSort.getPasses();
            BubbleSortDataSorted[counter][4] = sortedOldBubbleSort.getDurationTime();
            System.out.println("---------------------------------------------");
            System.out.println("----------------Bubble2 Sort------------------");
            // Copy of the sorted array is sorted using New Bubble Sort and metrics are printed out
            SortMetrics sortedNewBubbleSort = Sorting.bubbleSort2(Arrays.copyOf(sortedArray, sortedArray.length));
            System.out.println(sortedNewBubbleSort);
            // Metrics data then added to relevant Old Bubble Sort array
            BubbleSort2DataSorted[counter][0] = size;
            BubbleSort2DataSorted[counter][1] = sortedNewBubbleSort.getComparisons();
            BubbleSort2DataSorted[counter][2] = sortedNewBubbleSort.getSwaps();
            BubbleSort2DataSorted[counter][3] = sortedNewBubbleSort.getPasses();
            BubbleSortDataSorted[counter][4] = sortedOldBubbleSort.getDurationTime();
            System.out.println("---------------------------------------------");
            System.out.println("=============================================");
            // Increment counter by 1
            counter++;
            }
        }
        
        // Method called to generate CSV files for each Integer Array
        generateCSV("ShellSortDataRandom.csv", ShellSortDataRandom);
        generateCSV("BubbleSortDataRandom.csv", BubbleSortDataRandom);
        generateCSV("BubbleSort2DataRandom.csv", BubbleSort2DataRandom);
        generateCSV("ShellSortDataSorted.csv", ShellSortDataSorted);
        generateCSV("BubbleSortDataSorted.csv", BubbleSortDataSorted);
        generateCSV("BubbleSort2DataSorted.csv", BubbleSort2DataSorted);

    }
    
    // Method created that generates CSV files from the Integer Arrays
    private static void generateCSV (String filename, long[][] data) throws FileNotFoundException 
    {
        // "PrintWriter" used to create instance of writer file
        File file = new File(filename);
        PrintWriter writer = new PrintWriter(file);
        // Loop thoruhg each row
        for (int i = 0; i < data.length; i++){
            // In each row, loop thorugh each column and write the value to csv file
            for (int j = 0; j < data[i].length; j++){
                // Separate each value with a comma
                writer.print(data[i][j] + ",");
            }
            // After completing a row, write a line before moving to next row
            writer.print("\n");
        }
        // close writer when Integer array is fully written
        writer.close();
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

            
  
