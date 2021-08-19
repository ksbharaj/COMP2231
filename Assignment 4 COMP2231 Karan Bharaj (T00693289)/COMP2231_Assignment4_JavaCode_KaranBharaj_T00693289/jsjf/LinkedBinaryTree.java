//******************************************************************************
// LinkedBinaryTree.java
// 
// Karan Bharaj T00693289
// COMP2231 Assignment 4: Questions 1 and 2
// Completed implementation of LinkedBinaryTree to answer Questions 1 and 2 of 
// Assignment 4
//******************************************************************************

package jsjf;

import java.util.*;
import jsjf.exceptions.*;

/**
 * LinkedBinaryTree implements the BinaryTreeADT interface
 * 
 * @author Java Foundations
 * @version 4.0
 */
public class LinkedBinaryTree<T> implements BinaryTreeADT<T>, Iterable<T>
{
    protected BinaryTreeNode<T> root; 
    protected int modCount;

    /**
     * Creates an empty binary tree.
     */
    public LinkedBinaryTree() 
    {
            root = null;
    }

    /**
     * Creates a binary tree with the specified element as its root.
     *
     * @param element the element that will become the root of the binary tree
     */
    public LinkedBinaryTree(T element) 
    {
            root = new BinaryTreeNode<T>(element);
    }

    /**
     * Creates a binary tree with the specified element as its root and the 
     * given trees as its left child and right child
     *
     * @param element the element that will become the root of the binary tree
     * @param left the left subtree of this tree
     * @param right the right subtree of this tree
     */
    public LinkedBinaryTree(T element, LinkedBinaryTree<T> left, 
                    LinkedBinaryTree<T> right) 
    {
            root = new BinaryTreeNode<T>(element);
            root.setLeft(left.root);
            root.setRight(right.root);
    }

    /**
     * Returns a reference to the element at the root
     *
     * @return a reference to the specified target
     * @throws EmptyCollectionException if the tree is empty
     */
    public T getRootElement() throws EmptyCollectionException
    {
        // Error thrown if the tree is empty
        if (root == null)
            throw new EmptyCollectionException("LinkedBinaryTree");
        
        // If not empty, the element stored as the root of the tree is returned as a reference
        return (root.getElement());
    }

    /**
     * Returns a reference to the node at the root
     *
     * @return a reference to the specified node
     * @throws EmptyCollectionException if the tree is empty
     */
    protected BinaryTreeNode<T> getRootNode() throws EmptyCollectionException
    {
        // Error thrown if the tree is empty
        if (root == null)
            throw new EmptyCollectionException("LinkedBinaryTree");
        
        // If not empty, a reference the root of the tree is returned as a node
        return (root);
    }

    /**
     * Returns the left subtree of the root of this tree.
     *
     * @return a link to the left subtree fo the tree
     */
    public LinkedBinaryTree<T> getLeft()
    {
        // Error thrown if the tree is empty
        if (root == null)
            throw new EmptyCollectionException("Get left operation "
                                                + "failed. The tree is empty.");

        // If not empty, a reference the left subtree is returned
        LinkedBinaryTree<T> result = new LinkedBinaryTree<T>();
        result.root = root.getLeft();

        return result;
    }

    /**
     * Returns the right subtree of the root of this tree.
     *
     * @return a link to the right subtree of the tree
     */
    public LinkedBinaryTree<T> getRight()
    {
        // Error thrown if the tree is empty
        if (root == null)
            throw new EmptyCollectionException("Get right operation "
                    + "failed. The tree is empty.");

        // If not empty, a reference the right subtree is returned
        LinkedBinaryTree<T> result = new LinkedBinaryTree<T>();
        result.root = root.getRight();

        return result;
    }

    /**
     * Returns true if this binary tree is empty and false otherwise.
     *
     * @return true if this binary tree is empty, false otherwise
     */
    public boolean isEmpty() 
    {
            return (root == null);
    }

    /**
     * Returns the integer size of this tree.
     *
     * @return the integer size of the tree
     */
    public int size() 
    {
        // Returns the number of elements in the tree
        return root.numChildren() + 1;
    }

    /**
     * Returns the height of this tree.
     *
     * @return the height of the tree
     */
    public int getHeight()
    {
        // Returns the height of the tree from the root
        return height(root) - 1;
    }

    /**
     * Returns the height of the specified node.
     *
     * @param node the node from which to calculate the height
     * @return the height of the tree
     */
    private int height(BinaryTreeNode<T> node) 
    {
        // Returns the height from a specified node
        int result = 0;
        if (node != null)
            result = Math.max(height(node.getLeft()), height(node.getRight())) + 1;
        return result;
    }

    /**
     * Returns true if this tree contains an element that matches the
     * specified target element and false otherwise.
     *
     * @param targetElement the element being sought in this tree
     * @return true if the element in is this tree, false otherwise
     */
    public boolean contains(T targetElement) 
    {
        // Uses findNode() to see if element is in tree. If found, returns true. 
        if (findNode(targetElement, root) != null) {
    		return true;
    	} else {    		
            return false;
    	}
    }

    /**
     * Returns a reference to the specified target element if it is
     * found in this binary tree.  Throws a ElementNotFoundException if
     * the specified target element is not found in the binary tree.
     *
     * @param targetElement the element being sought in this tree
     * @return a reference to the specified target
     * @throws ElementNotFoundException if the element is not in the tree
     */
    public T find(T targetElement) throws ElementNotFoundException
    {
            BinaryTreeNode<T> current = findNode(targetElement, root);

            if (current == null)
                    throw new ElementNotFoundException("LinkedBinaryTree");

            return (current.getElement());
    }

    /**
     * Returns a reference to the specified target element if it is
     * found in this binary tree.
     *
     * @param targetElement the element being sought in this tree
     * @param next the element to begin searching from
     */
    private BinaryTreeNode<T> findNode(T targetElement, 
                    BinaryTreeNode<T> next)
    {
        BinaryTreeNode<T> result = null;
        // code is executed if the tree node to search on exists
        if (next != null) { 
    
            //if the next equals the element, it is returned
            if (next.getElement().equals(targetElement)) 
            {
                return next;
            }

            // Otherwise, recursively continue finding in the left subtree
            result = findNode(targetElement, next.getLeft());

            //if the left child does not have the element, recursively start 
            // finding in the right subtree
            if (result == null) 
            {
                result = findNode(targetElement, next.getRight());
            }
        }
        // return the resulting node 
        return result;
    }

    /**
     * Returns a string representation of this binary tree showing
     * the nodes in an inorder fashion.
     *
     * @return a string representation of this binary tree
     */
    public String toString() 
    {
        // ArrayUnorderedList<T> in inOrder fashion returned in String representation
        return inOrderList().toString();
        
    }
    
    // Returns the ArrayUnorderedList<T> in inOrder fashion as an Array
    public T[] toArray() 
    {
        return inOrderList().toArray();
        
    }
    
    // Method the convert the tree to an ArrayUnorderedList<T> in inOrder fashion
    private ArrayUnorderedList<T> inOrderList()
    {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        inOrder(root, tempList);
        
        return tempList;
    }
    


    /**
     * Returns an iterator over the elements in this tree using the 
     * iteratorInOrder method
     *
     * @return an in order iterator over this binary tree
     */
    public Iterator<T> iterator()
    {
            return iteratorInOrder();
    }

    /**
     * Performs an inorder traversal on this binary tree by calling an
     * overloaded, recursive inorder method that starts with
     * the root.
     *
     * @return an in order iterator over this binary tree
     */
    public Iterator<T> iteratorInOrder()
    {
            ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
            inOrder(root, tempList);

            return new TreeIterator(tempList.iterator());
    }

    /**
     * Performs a recursive inorder traversal.
     *
     * @param node the node to be used as the root for this traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void inOrder(BinaryTreeNode<T> node, 
                    ArrayUnorderedList<T> tempList) 
    {
            if (node != null)
            {
                inOrder(node.getLeft(), tempList);
                tempList.addToRear(node.getElement());
                inOrder(node.getRight(), tempList);
            }
    }

    /**
     * Performs an preorder traversal on this binary tree by calling 
     * an overloaded, recursive preorder method that starts with
     * the root.
     *
     * @return a pre order iterator over this tree
     */
    public Iterator<T> iteratorPreOrder() 
    {
            // To be completed as a Programming Project

            ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
            preOrder(root, tempList);

            return new TreeIterator(tempList.iterator());
    }

    /**
     * Performs a recursive preorder traversal.
     *
     * @param node the node to be used as the root for this traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void preOrder(BinaryTreeNode<T> node, 
                    ArrayUnorderedList<T> tempList) 
    {
            // To be completed as a Programming Project
        if (node != null)
        {
            tempList.addToRear(node.getElement());
            preOrder(node.getLeft(), tempList);
            preOrder(node.getRight(), tempList);
        }
    }

    /**
     * Performs an postorder traversal on this binary tree by calling
     * an overloaded, recursive postorder method that starts
     * with the root.
     *
     * @return a post order iterator over this tree
     */
    public Iterator<T> iteratorPostOrder() 
    {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        postOrder(root, tempList);

        return new TreeIterator(tempList.iterator());
    }

    /**
     * Performs a recursive postorder traversal.
     *
     * @param node the node to be used as the root for this traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void postOrder(BinaryTreeNode<T> node, 
                    ArrayUnorderedList<T> tempList) 
    {
        if (node != null)
        {
            postOrder(node.getLeft(), tempList);
            postOrder(node.getRight(), tempList);
            tempList.addToRear(node.getElement());
        }
    }

    /**
     * Performs a levelorder traversal on this binary tree, using a
     * templist.
     *
     * @return a levelorder iterator over this binary tree
     */
    public Iterator<T> iteratorLevelOrder() 
    {
            ArrayUnorderedList<BinaryTreeNode<T>> nodes = 
                            new ArrayUnorderedList<BinaryTreeNode<T>>();
            ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
            BinaryTreeNode<T> current;

            nodes.addToRear(root);

            while (!nodes.isEmpty()) 
            {
                    current = nodes.removeFirst();

                    if (current != null)
                    {
                            tempList.addToRear(current.getElement());
                            if (current.getLeft() != null)
                                    nodes.addToRear(current.getLeft());
                            if (current.getRight() != null)
                                    nodes.addToRear(current.getRight());
                    }
                    else
                            tempList.addToRear(null);
            }

            return new TreeIterator(tempList.iterator());
    }

    /**
     * Inner class to represent an iterator over the elements of this tree
     */
    private class TreeIterator implements Iterator<T>
    {
        private int expectedModCount;
        private Iterator<T> iter;

        /**
         * Sets up this iterator using the specified iterator.
         *
         * @param iter the list iterator created by a tree traversal
         */
        public TreeIterator(Iterator<T> iter)
        {
                this.iter = iter;
                expectedModCount = modCount;
        }

        /**
         * Returns true if this iterator has at least one more element
         * to deliver in the iteration.
         *
         * @return  true if this iterator has at least one more element to deliver
         *          in the iteration
         * @throws  ConcurrentModificationException if the collection has changed
         *          while the iterator is in use
         */
        public boolean hasNext() throws ConcurrentModificationException
        {
                if (!(modCount == expectedModCount))
                        throw new ConcurrentModificationException();

                return (iter.hasNext());
        }

        /**
         * Returns the next element in the iteration. If there are no
         * more elements in this iteration, a NoSuchElementException is
         * thrown.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iterator is empty
         */
        public T next() throws NoSuchElementException
        {
                if (hasNext())
                        return (iter.next());
                else 
                        throw new NoSuchElementException();
        }

        /**
         * The remove operation is not supported.
         * 
         * @throws UnsupportedOperationException if the remove operation is called
         */
        public void remove()
        {
                throw new UnsupportedOperationException();
        }
    }
}

