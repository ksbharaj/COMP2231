//******************************************************************************
// Question3Driver.java
// 
// Karan Bharaj T00693289
// COMP2231 Assignment 5: Question 3
// Implementation of a dynamically resizable hash table that stores book names 
// and 10-digit ISBN numbers, and implements methods that answer the questions 
// as required.
//******************************************************************************

import jsjf.BookNamesHashTable;

public class Question3Driver {
    public static void main(String[] args)
	{
            System.out.println("         ======== QUESTION 3 ========\n");
            System.out.println("----- New Hash Table is created: -----");
            BookNamesHashTable bookNames = new BookNamesHashTable(11, 0.7);
            System.out.println("");
            System.out.println("----- 5 books added to the hash table -----");
            System.out.println("These 5 books are selected to have no collisions");
            bookNames.put("0399501487", "Lord of the flies");
            bookNames.put("0060935464", "To kill a Mockingbird");
            bookNames.put("0140177396", "Of Mice and Men");
            bookNames.put("0141439556", "Wuthering Heights");
            bookNames.put("0553211404", "Jane Eyre");
            System.out.println("");
            System.out.println("Current capacity of the hash table: " + bookNames.getCapacity());
            System.out.println("Number of books currently in the hash table: " + bookNames.numberOfBooks());
            System.out.println("");
            System.out.println("Print out of the hash table:");
            System.out.println(bookNames);
            System.out.println("----  ----  ----  ----  ----  ----  -----");
            System.out.println("----- Add a book that causes a collision -----");
            System.out.println("");
            bookNames.put("0735211299", "Atomic Habits");
            bookNames.put("0316296619", "Bomber Mafia");
            System.out.println("Print out of the hash table:");
            System.out.println(bookNames);
            System.out.println("Current capacity of the hash table: " + bookNames.getCapacity());
            System.out.println("Number of books currently in the hash table: " + bookNames.numberOfBooks());
            System.out.println("");
            System.out.println("--- Attempt to find a book that was --- ");
            System.out.println("---   was added with NO collisions  ---\n");
            System.out.println(bookNames.find("0060935464"));
            System.out.println("");
            System.out.println("--- Attempt to find a book that was --- ");
            System.out.println("- was added with alteast a collision -\n");
            System.out.println(bookNames.find("0316296619"));
            System.out.println("");
            System.out.println("--- Attempt to delete a book that was --- ");
            System.out.println("---    entered with NO collisions    ---\n");
            System.out.println("Book \"Of Mice and Men\" attempted to be deleted");
            bookNames.delete("0140177396");
            System.out.println("");
            System.out.println("Print out of the hash table:");
            System.out.println(bookNames);
            System.out.println("--- Attempt to delete a book that was --- ");
            System.out.println("--- entered with atleast 1 collision  ---\n");
            System.out.println("Book \"Bomber Mafia\" attempted to be deleted");
            bookNames.delete("0316296619");
            System.out.println("");
            System.out.println("Print out of the hash table:");
            System.out.println(bookNames);
            System.out.println("Current capacity of the hash table: " + bookNames.getCapacity());
            System.out.println("Number of books currently in the hash table: " + bookNames.numberOfBooks());
            System.out.println("");
            System.out.println("--- Attempt to find a book that was --- ");
            System.out.println("----   was deleted from the table  ----\n");
            System.out.println("Book \"Of Mice and Men\" attempted to be found");
            bookNames.find("0140177396");
            System.out.println("");
            System.out.println("Book \"Of Mice and Men\" attempted to be deleted again");
            bookNames.delete("0140177396");
            System.out.println("");
            System.out.println("------ Add two more books to the table at ------ ");
            System.out.println("--- positions that were previously populated  ---\n");
            bookNames.put("0812981605", "The Power of Habit");
            bookNames.put("1612680178", "Rich Dad Poor Dad");
            System.out.println("");
            System.out.println("Print out of the hash table:");
            System.out.println(bookNames);
            System.out.println("Current capacity of the hash table: " + bookNames.getCapacity());
            System.out.println("Number of books currently in the hash table: " + bookNames.numberOfBooks() + "\n");
            System.out.println("----  Add another book to the table that will  ---- ");
            System.out.println("-- expand the capacity of the table and rehash it --\n");
            bookNames.put("0316017930", "Outliers");
            System.out.println(bookNames);
            System.out.println("Current capacity of the hash table: " + bookNames.getCapacity());
            System.out.println("Number of books currently in the hash table: " + bookNames.numberOfBooks());
            System.out.println("");
            System.out.println("---  Another 7 books added to the hash table---\n");
            bookNames.put("1585424331", "Think and Grow Rich");
            bookNames.put("0857197681", "The Psychology of Money");
            bookNames.put("1250217768", "Bitcoin Billionaires");
            bookNames.put("0525633766", "A Promised Land");
            bookNames.put("1524763144", "Becoming");
            bookNames.put("0525559477", "The Midnight Library");
            bookNames.put("9781250072", "The Song of Achilles");
            System.out.println("Print out of the hash table:");
            System.out.println(bookNames);
            System.out.println("Current capacity of the hash table: " + bookNames.getCapacity());
            System.out.println("Number of books currently in the hash table: " + bookNames.numberOfBooks());
            System.out.println("");
            System.out.println("------ Attempt to find a book that ------ ");
            System.out.println("--- was entered to the expanded table ---\n");
            System.out.println(bookNames.find("1524763144"));
            System.out.println("");
            System.out.println("-- Attempt to delete the last book that -- ");
            System.out.println("--- was entered to the expanded table ---\n");
            bookNames.delete("9781250072");
            System.out.println("Print out of the hash table:");
            System.out.println(bookNames);
            System.out.println("Current capacity of the hash table: " + bookNames.getCapacity());
            System.out.println("Number of books currently in the hash table: " + bookNames.numberOfBooks());
        }
}
