//******************************************************************************
// Sorting.java
// 
// Karan Bharaj T00693289
// COMP2231 Assignment 1: Questions 1, 2 and 3
// This application contains the various sorting methods that are run to for
// this assignment, including ShellSort, (Old) BubbleSort and (New) BubbleSort2.
//******************************************************************************

import java.util.Arrays;

public class Sorting 
{  
    // Swaps the values in an array based on their index positions
    private static void swap(int[] data, int index1, int index2) 
    {
        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }
    
    // Sorts the input array using the Shell sort method
    public static SortMetrics shellSort(int[] data) 
    {
        // Creates a set to record the sorting metrics, and timer is started
        SortMetrics set = new SortMetrics();
        set.startTimer();
        
        // Variable initialised that will be used to scan through the array
        int scan;
        // Initially gap size is set as half of array size
        int gap = data.length / 2;    
        
        while (gap > 0) 
        {
            // Swapflag introduced to assess whether a swap occurs at a given pass. It is set to true
            // before the inner while loop to ensure array is scanned after the gap size is halved
            boolean swapflag = true; 
            while (swapflag) 
            {
                // Increment the number of passes by one for the next pass
                set.addPass();
                // Printout of pass number and gap size
//                System.out.println("Pass #: " + set.getPasses() + " Gap Size: " + gap);
                // Swapflag is assigned false below to ensure that the next scan through the 
                // array indentifies a swap
                swapflag = false;
                // loop through the array swapping at specified gap size
                for (scan = 0; scan < (data.length - gap); scan++) 
                {
                    // Increments the number of comparisons made by 1
                    set.addComparison();
                    // Values swapped if possible, incrementing "swaps" by 1 and
                    // swapflag is set as true
                    if (data[scan] > data[scan+gap]) 
                    {
                        swap(data, scan, scan + gap);
                        swapflag = true;
                        set.addSwap();
//                        System.out.println(Arrays.toString(data));
                    }
                }
                // If the gap size is greater than one, we want to half the gap size regardless
                // of whether a swap occurred in the previous pass
                if (gap > 1) 
                {
                    swapflag = false;
                }
                
            }
            
            // gap size is halved if it was greater than 1, or if there were no swaps in previous pass
            gap /= 2 ;
        }  
        // The timer is stopped, and set metrics are returned
        set.stopTimer();
        return set;
    }
    

      
    // Sorts the input array using the Bubble sort method
    public static SortMetrics bubbleSort(int[] data) 
    {
        // Creates a set to record the sorting metrics, and timer is started
        SortMetrics set = new SortMetrics();
        set.startTimer();
        
        // Variables initialised to help scan through the array
        int position, scan;

        for(position = data.length - 1; position >= 0; position--) 
        {
            // Increment the number of passes by one for the next pass
            set.addPass();
            // Printout of pass number and gap size
//            System.out.println("Pass #: " + set.getPasses());
            for(scan = 0; scan <= position - 1; scan++) 
            {
                // Increments the number of comparisons made by 1
                set.addComparison();
                // Values swapped if possible, incrementing "swaps" by 1
                if(data[scan] > data[scan + 1]) 
                {
                    swap(data, scan, scan + 1);
                    set.addSwap();
                }
            }
            // Printout of array after each pass, and increment the number of 
            // passes by one for the next pass
//            System.out.println(Arrays.toString(data));
        }
        // The timer is stopped, and set metrics are returned
        set.stopTimer();
        return set;
    }
    
    public static SortMetrics bubbleSort2(int[] data) 
    {  
        // Creates a set to record the sorting metrics, and timer is started
        SortMetrics set = new SortMetrics();
        set.startTimer();
        // Swapflag introduced to assess a swap occurs at a given pass
        boolean swapflag = true;
        // Variable initialised to help scan through the array
        int scan;
        // position intialised as the last index
        int position = data.length - 1;
        
        // If a swap occured in the previous pass, the next loop takes place 
        while (swapflag) 
        {
            // Swapflag set as false in start of loop to determine whether a 
            // swap is has taken place by the end of the loop
            swapflag = false;
            // Increment the number of passes by one for the next pass
            set.addPass();
            // Printout of pass number and gap size
//            System.out.println("Pass #: " + set.getPasses()); 
            for (scan = 0; scan < position ; scan++) 
            {
                // Increments the number of comparisons made by 1
                set.addComparison();
                // Values swapped if possible, incrementing "swaps" by 1 and
                // swapflag is set as true
                if (data[scan] > data[scan+1]) 
                {
                    swapflag = true;
                    swap(data, scan, scan + 1);
                    set.addSwap();
                }
            }
            // Printout of array after each pass, and increment the number of 
            // passes by one for the next pass
//            System.out.println(Arrays.toString(data));
            // position moved one index position to the left
            position--;
        }
        // The timer is stopped, and set metrics are returned
        set.stopTimer();
        return set;
    }    
}
