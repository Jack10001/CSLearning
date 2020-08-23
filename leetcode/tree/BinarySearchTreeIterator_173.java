package tree;

import java.util.ArrayList;
import java.util.Stack;

public class BinarySearchTreeIterator_173 {
	

}

class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        
        // The main idea here is to always push all small left elements in a stack, 
        // instead of converting Tree to a LinkedList and consumed O(N) space
        pushAllLeftis(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode current = stack.pop();
        
        // If we find a right node for the current node, this means that we can have 
        // a left element under this right that can be the next smallest one, so we push 
        // from right + all of its lefts into the stack.
        if (current.right != null) {
            pushAllLeftis(current.right);
        }
        
        return current.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    void pushAllLeftis(TreeNode root) {
        // Simply push all lefts in the stack starting from right
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}

class BSTIterator1 {

    ArrayList<Integer> nodesSorted;
    int index;

    public BSTIterator1(TreeNode root) {

        // Array containing all the nodes in the sorted order
        this.nodesSorted = new ArrayList<Integer>();
        
        // Pointer to the next smallest element in the BST
        this.index = -1;
        
        // Call to flatten the input binary search tree
        this._inorder(root);
    }

    private void _inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        this._inorder(root.left);
        this.nodesSorted.add(root.val);
        this._inorder(root.right);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return this.nodesSorted.get(++this.index);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return this.index + 1 < this.nodesSorted.size();
    }
}
