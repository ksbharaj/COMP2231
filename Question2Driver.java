//******************************************************************************
// Question2Driver.java
// 
// Karan Bharaj T00693289
// COMP2231 Assignment 4: Question 2
// Uses the LinkedBinarySearchTree implementation. Methods of this class are shown.
// Furthermore, a tree-balancing method is implemented using brute force and test cases
// demonstrate its function.
//******************************************************************************

import jsjf.LinkedBinarySearchTree;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ksbha
 */
public class Question2Driver {
    public static void main(String[] args)
    {
        System.out.println("         ======== QUESTION 1 ========");
        System.out.println("-- PART 1- Test cases for all newly implemented methods --\n");
        System.out.println("-- New Linked Binary Search Tree created with \"5\" --");
        System.out.println("------------ as the root element ------------\n");
        
        LinkedBinarySearchTree tree = new LinkedBinarySearchTree<Integer>(5);
        
        System.out.println("-- Nine integers are now added to the tree --");
        tree.addElement(3);
        tree.addElement(7);
        tree.addElement(2);
        tree.addElement(9);
        tree.addElement(2);
        tree.addElement(1);
        tree.addElement(5);
        tree.addElement(2);
        tree.addElement(2);
        
        System.out.println("-- Inorder representation of the tree: --");        
        System.out.println(tree);
          
        System.out.println("-- Execution of removeMax() method: --");
        System.out.print("The largest element now removed from the tree is: ");
        System.out.println(tree.removeMax());
        
        System.out.println("-- Inorder representation of the tree after removal: --");        
        System.out.println(tree);
        
        System.out.println("-- Execution of removeAllOccurrences() method: --");
        tree.removeAllOccurrences(2);
        System.out.println("-- Inorder representation of the tree after removal: --");        
        System.out.println(tree);
        
        System.out.println("-- Execution of find() method: --");
        System.out.print("The attempt to find 3 in the tree: ");
        System.out.println(tree.find(3));
        System.out.println("-- Inorder representation of the tree after find(): --");        
        System.out.println(tree);
        
        System.out.println("-- Execution of findMin() method: --");
        System.out.print("The smallest element in the tree is: ");
        System.out.println(tree.findMin());
        System.out.println("-- Inorder representation of the tree after findMin(): --");        
        System.out.println(tree);
        
        System.out.println("-- Execution of findMax() method: --");
        System.out.print("The largest element in the tree is: ");
        System.out.println(tree.findMax());
        System.out.println("-- Inorder representation of the tree after findMax(): --");        
        System.out.println(tree);
        
        System.out.println("-- Execution of getLeft() method: --");
        System.out.println("The left subtree of the tree (in inOrder fashion) is: ");
        System.out.println(tree.getLeft());
        System.out.println("-- Inorder representation of the tree after getLeft(): --");        
        System.out.println(tree);
        
        System.out.println("-- Execution of getRight() method: --");
        System.out.println("The right subtree of the tree (in inOrder fashion) is: ");
        System.out.println(tree.getRight());
        System.out.println("-- Inorder representation of the tree after getRight(): --");        
        System.out.println(tree);
        System.out.println("-------- END of PART 1 --------\n");
        
//        System.out.println("----- PART 2- EDGE case for the newly implemented methods -----\n");
//        System.out.println("-- Execution of removeAllOccurrences() method to remove 2: --");
//        tree.removeAllOccurrences(2);
//        
//        System.out.println("-- Execution of find() method to try find 8: --");
//        tree.find(8);
//        
//        System.out.println("-------- END of PART 2 --------\n");
        
        System.out.println("-- PART 3- Brute force balance on degenerate trees --\n");
        System.out.println("-- CASE 1- Creation of a degenerate tree --");
        
        LinkedBinarySearchTree bruteForceTree1 = new LinkedBinarySearchTree<>();
        
        bruteForceTree1.addElement(3);
        bruteForceTree1.addElement(5);
        bruteForceTree1.addElement(9);
        bruteForceTree1.addElement(12);
        bruteForceTree1.addElement(18);
        bruteForceTree1.addElement(20);
        
        System.out.println("-- Inorder representation of the degenerate tree: --"); 
        System.out.println(bruteForceTree1);
        
        System.out.print("Size of the degenerate tree: ");
        System.out.println(bruteForceTree1.size());
        System.out.print("Height of the degenerate tree: ");
        System.out.println(bruteForceTree1.getHeight());
        System.out.print("Root element of the degenerate tree: ");
        System.out.println(bruteForceTree1.getRootElement());
        
        System.out.println("\n-- Implementation of the brute force balance method --"); 
        bruteForceTree1 = bruteForceTree1.bruteForceBalance();
        
        System.out.println("-- Inorder representation of the balanced tree: --"); 
        System.out.println(bruteForceTree1);
        
        System.out.print("Size of the balanced tree: ");
        System.out.println(bruteForceTree1.size());
        System.out.print("Height of the tree after balancing: ");
        System.out.println(bruteForceTree1.getHeight());
        System.out.print("Root element of the balanced tree: ");
        System.out.println(bruteForceTree1.getRootElement());
        
        System.out.println("\nRoot of left subtree: " + bruteForceTree1.getLeft().getRootElement());
        System.out.println("Left subtree of root: ");
        System.out.println(bruteForceTree1.getLeft());
        
        System.out.println("Root of right subtree: " + bruteForceTree1.getRight().getRootElement());
        System.out.println("Right subtree of root: ");
        System.out.println(bruteForceTree1.getRight());
        
        
        System.out.println("------- END of CASE 1 -------");
        
        System.out.println("\n-- CASE 2- Creation of a degenerate tree --");
        
        LinkedBinarySearchTree bruteForceTree2 = new LinkedBinarySearchTree<>();
        
        bruteForceTree2.addElement(30);
        bruteForceTree2.addElement(26);
        bruteForceTree2.addElement(22);
        bruteForceTree2.addElement(18);
        bruteForceTree2.addElement(14);
        bruteForceTree2.addElement(12);
        bruteForceTree2.addElement(9);
        bruteForceTree2.addElement(5);
        
        
        System.out.println("-- Inorder representation of the degenerate tree: --"); 
        System.out.println(bruteForceTree2);
        
        System.out.print("Size of the degenerate tree: ");
        System.out.println(bruteForceTree2.size());
        System.out.print("Height of the degenerate tree: ");
        System.out.println(bruteForceTree2.getHeight());
        System.out.print("Root element of the degenerate tree: ");
        System.out.println(bruteForceTree2.getRootElement());
        
        System.out.println("\n-- Implementation of the brute force balance method --"); 
        bruteForceTree2 = bruteForceTree2.bruteForceBalance();
        
        System.out.println("-- Inorder representation of the balanced tree: --"); 
        System.out.println(bruteForceTree2);
        
        System.out.print("Size of the balanced tree: ");
        System.out.println(bruteForceTree2.size());
        System.out.print("Height of the tree after balancing: ");
        System.out.println(bruteForceTree2.getHeight());
        System.out.print("Root element of the balanced tree: ");
        System.out.println(bruteForceTree2.getRootElement());
        
        System.out.println("\nRoot of left subtree: " + bruteForceTree2.getLeft().getRootElement());
        System.out.println("Left subtree of root: ");
        System.out.println(bruteForceTree2.getLeft());
        
        System.out.println("Root of right subtree: " + bruteForceTree2.getRight().getRootElement());
        System.out.println("Right subtree of root: ");
        System.out.println(bruteForceTree2.getRight());
        
        System.out.println("------- END of CASE 2 -------\n");
        System.out.println("-------- END of PART 3 --------\n");
        
        System.out.println("--- PART 4- Insertions into balanced tree to create a degenerate ---");
        System.out.println("--- tree, and is then rebalanced again using bruteForceBalance() ---");
        
        bruteForceTree2.addElement(4);
        bruteForceTree2.addElement(3);
        bruteForceTree2.addElement(2);
        bruteForceTree2.addElement(1);
        bruteForceTree2.addElement(0);
        
        System.out.println("-- Inorder representation of new degenerate tree: --"); 
        System.out.println(bruteForceTree2);
        
        System.out.print("Size of the degenerate tree: ");
        System.out.println(bruteForceTree2.size());
        System.out.print("Height of the degenerate tree: ");
        System.out.println(bruteForceTree2.getHeight());
        System.out.print("Root element of the degenerate tree: ");
        System.out.println(bruteForceTree2.getRootElement());
        
        System.out.println("\n-- Implementation of the brute force balance method --"); 
        bruteForceTree2 = bruteForceTree2.bruteForceBalance();
        
        System.out.println("-- Inorder representation of the balanced tree: --"); 
        System.out.println(bruteForceTree2);
        
        System.out.print("Size of the balanced tree: ");
        System.out.println(bruteForceTree2.size());
        System.out.print("Height of the tree after balancing: ");
        System.out.println(bruteForceTree2.getHeight());
        System.out.print("Root element of the balanced tree: ");
        System.out.println(bruteForceTree2.getRootElement());
        
        System.out.println("\nRoot of left subtree: " + bruteForceTree2.getLeft().getRootElement());
        System.out.println("Left subtree of root: ");
        System.out.println(bruteForceTree2.getLeft());
        
        System.out.println("Root of right subtree: " + bruteForceTree2.getRight().getRootElement());
        System.out.println("Right subtree of root: ");
        System.out.println(bruteForceTree2.getRight());
        System.out.println("-------- END of PART 4 --------\n");
    }
    
}
