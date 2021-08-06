//******************************************************************************
// SortMetrics.java
// 
// Karan Bharaj T00693289
// COMP2231 Assignment 1: Questions 1, 2 and 3
// This application is a class that contains all the metrics of the data to be
// sorted, such as the runtime, comparisons, passes and swaps. 
//******************************************************************************

public class SortMetrics 
{
    // Variables to record the start and end of timing
    private long startTime; 
    private long endTime;
    
    // Variables to count the number of comparisons, swaps and passes made
    private long comparisons;
    private long swaps;
    private long passes;
    
    // Method that start timing
    public void startTimer() 
    { 
        startTime = System.currentTimeMillis();
    }
    
    // Method that stops timing
    public void stopTimer() 
    {
        endTime = System.currentTimeMillis();
    }
    
    // Method that increments the comparisons count by one
    public void addComparison() 
    { 
        comparisons++;
    }
    
    // Method that increments the swaps count by one
    public void addSwap() 
    {
        swaps++;
    }
    
    // Method that increments the passes count by one
    public void addPass() 
    {
        passes++;
    }
    
    // Method that returns the number of comparisons counted
    public long getComparisons()
    {
        return comparisons;
    }
    
    // Method that returns the number of swaps counted
    public long getSwaps()
    {
        return swaps;
    }
    
    // Method that returns the number of passes counted
    public long getPasses() 
    {
        return passes;
    }
    
    // Method that returns the duration of time recorded
    public long getDurationTime() 
    {
            return endTime - startTime;
    }
    
    //Method to return a summary of the sorting metrics in a desirable format
    public String toString() 
    {
        return "Number of Comparisons: " + comparisons + "\n" +
                "Number of Swaps: " + swaps + "\n" +
        "Execution Time: " + this.getDurationTime() + " milliseconds";
//        return "";
    }
}
