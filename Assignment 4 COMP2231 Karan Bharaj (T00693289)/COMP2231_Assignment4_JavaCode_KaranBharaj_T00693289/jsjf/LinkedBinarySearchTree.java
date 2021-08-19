//******************************************************************************
// LinkedBinarySearchTree.java
// 
// Karan Bharaj T00693289
// COMP2231 Assignment 4: Question 2
// Completed implementation of LinkedBinarySearchTree.java for answering the 
// requirements of Question 2
//******************************************************************************

package jsjf;

import java.util.Arrays;
import jsjf.exceptions.*;

/**
 * LinkedBinarySearchTree implements the BinarySearchTreeADT interface 
 * with links.
 * 
 * @author Java Foundations
 * @version 4.0
 */
public class LinkedBinarySearchTree<T> extends LinkedBinaryTree<T>
implements BinarySearchTreeADT<T>
{
    /**
     * Creates an empty binary search tree.
     */
    public LinkedBinarySearchTree() 
    {
        super();
    }

    /**
     * Creates a binary search with the specified element as its root.
     *
     * @param element the element that will be the root of the new binary
     *        search tree
     */
    public LinkedBinarySearchTree(T element) 
    {
        super(element);

        if (!(element instanceof Comparable))
                throw new NonComparableElementException("LinkedBinarySearchTree");
    }

    /**
     * Adds the specified object to the binary search tree in the
     * appropriate position according to its natural order.  Note that
     * equal elements are added to the right.
     *
     * @param element the element to be added to the binary search tree
     */
    public void addElement(T element) 
    {
        if (!(element instanceof Comparable))
            throw new NonComparableElementException("LinkedBinarySearchTree");

        Comparable<T> comparableElement = (Comparable<T>)element;

        if (isEmpty())
            root = new BinaryTreeNode<T>(element);
        else 
        {
            if (comparableElement.compareTo(root.getElement()) < 0)
            {
                if (root.getLeft() == null) 
                    this.getRootNode().setLeft(new BinaryTreeNode<T>(element));
                else
                    addElement(element, root.getLeft());
            }
            else
            {
                if (root.getRight() == null) 
                    this.getRootNode().setRight(new BinaryTreeNode<T>(element));
                else
                    addElement(element, root.getRight());
            }
        }
        modCount++;
    }

    /**
     * Adds the specified object to the binary search tree in the
     * appropriate position according to its natural order.  Note that
     * equal elements are added to the right.
     *
     * @param element the element to be added to the binary search tree
     */
    private void addElement(T element, BinaryTreeNode<T> node) 
    {
            Comparable<T> comparableElement = (Comparable<T>)element;

            if (comparableElement.compareTo(node.getElement()) < 0)
            {
                if (node.getLeft() == null) 
                    node.setLeft(new BinaryTreeNode<T>(element));
                else
                    addElement(element, node.getLeft());
            }
            else
            {
                if (node.getRight() == null) 
                    node.setRight(new BinaryTreeNode<T>(element));
                else
                    addElement(element, node.getRight());
            }
    }


    /**
     * Removes the first element that matches the specified target
     * element from the binary search tree and returns a reference to
     * it.  Throws a ElementNotFoundException if the specified target
     * element is not found in the binary search tree.
     *
     * @param targetElement the element being sought in the binary search tree
     * @throws ElementNotFoundException if the target element is not found
     */
    public T removeElement(T targetElement) throws ElementNotFoundException 
    {
        T result = null;

        if (isEmpty())
                throw new ElementNotFoundException("LinkedBinarySearchTree");
        else
        {
            BinaryTreeNode<T> parent = null;
            if (((Comparable<T>)targetElement).equals(root.element)) 
            {
                result =  root.element;
                BinaryTreeNode<T> temp = replacement(root);
                if (temp == null)
                        root = null;
                else 
                {
                    root.element = temp.element;
                    root.setRight(temp.right);
                    root.setLeft(temp.left);
                }

                modCount--;
            }
            else 
            {                
                parent = root;
                if (((Comparable)targetElement).compareTo(root.element) < 0)
                    result = removeElement(targetElement, root.getLeft(), parent);
                else
                    result = removeElement(targetElement, root.getRight(), parent);
            }
        }

        return result;
    }

    /**
     * Removes the first element that matches the specified target
     * element from the binary search tree and returns a reference to
     * it.  Throws a ElementNotFoundException if the specified target
     * element is not found in the binary search tree.
     *
     * @param targetElement the element being sought in the binary search tree
     * @param node the node from which to search
     * @param parent the parent of the node from which to search
     * @throws ElementNotFoundException if the target element is not found
     */
    private T removeElement(T targetElement, BinaryTreeNode<T> node, BinaryTreeNode<T> parent)
                    throws ElementNotFoundException 
    {
        T result = null;

        if (node == null)
            throw new ElementNotFoundException("LinkedBinarySearchTree");
        else
        {
            if (((Comparable<T>)targetElement).equals(node.element)) 
            {
                result =  node.element;
                BinaryTreeNode<T> temp = replacement(node);
                if (parent.right == node)
                    parent.right = temp;
                else 
                    parent.left = temp;

                modCount--;
            }
            else 
            {                
                parent = node;
                if (((Comparable)targetElement).compareTo(node.element) < 0)
                    result = removeElement(targetElement, node.getLeft(), parent);
                else
                    result = removeElement(targetElement, node.getRight(), parent);
            }
        }

        return result;
    }

    /**
     * Returns a reference to a node that will replace the one
     * specified for removal. In the case where the removed node has 
     * two children, the inorder successor is used as its replacement.
     *
     * @param node the node to be removed
     * @return a reference to the replacing node
     */
    private BinaryTreeNode<T> replacement(BinaryTreeNode<T> node) 
    {
        BinaryTreeNode<T> result = null;

        if ((node.left == null) && (node.right == null))
            result = null;

        else if ((node.left != null) && (node.right == null))
            result = node.left;

        else if ((node.left == null) && (node.right != null))
            result = node.right;

        else
        {
            BinaryTreeNode<T> current = node.right;
            BinaryTreeNode<T> parent = node;

            while (current.left != null)
            {
                parent = current;
                current = current.left;
            }

            current.left = node.left;
            if (node.right != current)
            {
                parent.left = current.right;
                current.right = node.right;
            }

            result = current;
        }

        return result;
    }

    /**
     * Removes elements that match the specified target element from 
     * the binary search tree. Throws a ElementNotFoundException if 
     * the specified target element is not found in this tree.
     *
     * @param targetElement the element being sought in the binary search tree
     * @throws ElementNotFoundException if the target element is not found
     */
    public void removeAllOccurrences(T targetElement)
        throws ElementNotFoundException 
    {
        removeElement(targetElement);

        try
        {
            while (contains((T)targetElement))
                removeElement(targetElement);
        }

        catch (Exception ElementNotFoundException)
        {
        }
    }

    /**
     * Removes the node with the least value from the binary search
     * tree and returns a reference to its element.  Throws an
     * EmptyCollectionException if this tree is empty. 
     *
     * @return a reference to the node with the least value
     * @throws EmptyCollectionException if the tree is empty
     */
    public T removeMin() throws EmptyCollectionException 
    {
        T result = null;

        if (isEmpty())
                throw new EmptyCollectionException("LinkedBinarySearchTree");
        else 
        {
            if (root.left == null) 
            {
                    result = root.element;
                    root = root.right;
            }
            else 
            {
                BinaryTreeNode<T> parent = root;
                BinaryTreeNode<T> current = root.left;
                while (current.left != null) 
                {
                    parent = current;
                    current = current.left;
                }
                result =  current.element;
                parent.left = current.right;
            }

            modCount--;
        }

        return result;
    }

    /**
     * Removes the node with the highest value from the binary
     * search tree and returns a reference to its element.  Throws an
     * EmptyCollectionException if this tree is empty. 
     *
     * @return a reference to the node with the highest value
     * @throws EmptyCollectionException if the tree is empty
     */
    // This method is similar to removeMin(), however, instead of continuously accessing
    // the left subtree of the tree, this method continuously access the right subtree, 
    // eventually removing the element with no further right subtree or node.
    public T removeMax() throws EmptyCollectionException 
    {
        
        T result = null;

        if (isEmpty())
                throw new EmptyCollectionException("LinkedBinarySearchTree");
        else 
        {
            if (root.right == null) 
            {
                result = root.element;
                root = root.left;
            }
            else 
            {
                BinaryTreeNode<T> parent = root;
                BinaryTreeNode<T> current = root.right;
                while (current.right != null) 
                {
                    parent = current;
                    current = current.right;
                }
                result =  current.element;
                parent.right = current.left;
            }
            modCount--;
        }
        return result;  // temp
    }

    /**
     * Returns the element with the least value in the binary search
     * tree. It does not remove the node from the binary search tree. 
     * Throws an EmptyCollectionException if this tree is empty.
     *
     * @return the element with the least value
     * @throws EmptyCollectionException if the tree is empty
     */
    
    // This method is similar to removeMin(), however, instead of removing the element,
    // it only returns a reference to it. 
    public T findMin() throws EmptyCollectionException 
    {
        T result = null;

        if (isEmpty())
            throw new EmptyCollectionException("LinkedBinarySearchTree");
        else 
        {
            BinaryTreeNode<T> current = root;

            while (current.left != null)
                current = current.left;

            result = current.element;
        }

        return result;
    }

    /**
     * Returns the element with the highest value in the binary
     * search tree.  It does not remove the node from the binary
     * search tree.  Throws an EmptyCollectionException if this 
     * tree is empty.
     *
     * @return the element with the highest value
     * @throws EmptyCollectionException if the tree is empty
     */
    
    // This method is similar to removeMax(), however, instead of removing the element,
    // it only returns a reference to it. 
    public T findMax() throws EmptyCollectionException 
    {
        T result = null;

        if (isEmpty())
            throw new EmptyCollectionException("LinkedBinarySearchTree");
        else 
        {
            BinaryTreeNode<T> current = root;

            while (current.right != null)
                current = current.right;

            result = current.element;
        }

        return result;
    }

    /**
     * Returns a reference to the specified target element if it is
     * found in the binary tree.  Throws a NoSuchElementException if
     * the specified target element is not found in this tree.
     *
     * @param targetElement the element being sough in the binary tree
     * @throws ElementNotFoundException if the target element is not found
     */
    // Method recursively uses the findNode() method to determine if the specified
    // element exists in the tree.
    public T find(T targetElement) throws ElementNotFoundException 
    {

        // start the search at the root
        BinaryTreeNode<T> current = findNode(targetElement, root);

        // if element is not found after recursion, error is thrown
        if (current == null) {
                throw new ElementNotFoundException("LinkedBinarySearchTree");
        } 

        // if the element is found, it is returned
        return current.getElement();
    }
    
    /**
     * Returns a reference to the specified target element if it is
     * found in this tree.  
     *
     * @param targetElement the element being sought in the tree
     * @param next the tree node to begin searching on
     */
    // Implement recursively by find() to help find an element
    private BinaryTreeNode<T> findNode(T targetElement, BinaryTreeNode<T> next) 
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
     * Returns the left subtree of the root of this tree.
     *
     * @return a link to the left subtree fo the tree
     */
    // Method uses the getLeft() method of BinaryTreeNode to return the left subtree
    public LinkedBinarySearchTree<T> getLeft()
    {
        if (root == null)
            throw new EmptyCollectionException("Get left operation "
                                                + "failed. The tree is empty.");

        LinkedBinarySearchTree<T> result = new LinkedBinarySearchTree<T>();
        result.root = root.getLeft();

        return result;
    }

    /**
     * Returns the right subtree of the root of this tree.
     *
     * @return a link to the right subtree of the tree
     */
    // Method uses the getRight() method of BinaryTreeNode to return the right subtree
    public LinkedBinarySearchTree<T> getRight()
    {
        if (root == null)
            throw new EmptyCollectionException("Get right operation "
            + "failed. The tree is empty.");

        LinkedBinarySearchTree<T> result = new LinkedBinarySearchTree<T>();
        result.root = root.getRight();

        return result;
    }

    

    // Method to balance a binary search tree
    public LinkedBinarySearchTree<T> bruteForceBalance()
    {
        // First, the tree is converted to a an array in inOrder fashion using 
        // LinkedBinaryTree's toArray() method.
        T[] tempList = (T[])(new Object[size()]);
        tempList = toArray();
        
        // This list is then recursively balanced to eventually return a balanced tree
        LinkedBinarySearchTree balancedTree = new LinkedBinarySearchTree<>();
        balancedTree.recursivelyBalance(tempList);

        return balancedTree;
    }

    // Method that recursively inserts the middle element of the array to a linked 
    // binary search tree to eventually create a balanced tree
    private void recursivelyBalance(T[] list)
    {
        // If the list is empty, none of the code in the method is executed
        if (list != null)
        {
            // If the list has one element only, then it is simply added to the tree
            if (list.length == 1)
            {
                addElement(list[0]);
            } else 
            // If list has more than 1 element, the middle value of list is added to
            // tree, and the remaining halves are recursively balanced
            {
                int mid = list.length/2;
                addElement(list[mid]);
                recursivelyBalance(rangeBetween(list, 0, mid-1));
                recursivelyBalance(rangeBetween(list, mid+1, list.length-1));
            }
        }
    }        

    // Method that returns a sublist of the list provided between the specified indices
    private T[] rangeBetween(T[] list, int start, int end)
    {
        // This check ensures that a valid sublist can be created. If not, null is returned
        if (start > end)
        {
            return null;
        }
        T[] tempList = (T[])(new Object[(end-start)]);
        tempList = Arrays.copyOfRange(list, start, end+1);
        return tempList;
    }    
        
}

