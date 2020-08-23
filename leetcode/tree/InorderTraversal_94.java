package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal_94 {
	 public List<Integer> inorderTraversal(TreeNode root) {
		 //???递归函数一直在堆区创建result,所以只能够返回含有一个值的result
		 List<Integer> result=new ArrayList<>();
		 if(root==null) return null;
		 else {
			 inorderTraversal(root.left);
			 result.add(root.val);
			 inorderTraversal(root.right);
			 
		 }
		 return result;
	        
	    }
	 
	//recursion 
	public List<Integer> inorderTraversal1(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root != null) return helper(root, result);
		return result;
	}

	public List<Integer> helper(TreeNode root, ArrayList<Integer> result) {//传ArrayList的引用
		if (root == null) {
			return null;
		}
		helper(root.left,result);
		result.add(root.val);
		helper(root.right,result);
		return result;
	}
	
	//iteration
	public List<Integer> inorderTraversal2(TreeNode root){
		 List < Integer > res = new ArrayList<> ();
	        Stack < TreeNode > stack = new Stack<> ();
	        TreeNode curr = root;
	        while (curr != null || !stack.isEmpty()) {
	            while (curr != null) {
	                stack.push(curr);
	                curr = curr.left;
	            }
	            curr = stack.pop();
	            res.add(curr.val);
	            curr = curr.right;
	        }
	        return res;
	}
	
	//迭代或者递归空间幅度为O(n)
	//Morris Traversal 方法只需要 O(1) 空间，而且同样可以在 O(n) 时间内完成。 非递归不用栈
	class Solution {
	    public List < Integer > inorderTraversal(TreeNode root) {
	        List < Integer > res = new ArrayList < > ();
	        TreeNode curr = root;
	        TreeNode pre;
	        while (curr != null) {
	            if (curr.left == null) {
	                res.add(curr.val);
	                curr = curr.right; // move to next right node
	            } else { // has a left subtree
	                pre = curr.left;
	                while (pre.right != null) { // find rightmost
	                    pre = pre.right;
	                }
	                pre.right = curr; // put cur after the pre node
	                TreeNode temp = curr; // store cur node
	                curr = curr.left; // move cur to the top of the new tree
	                temp.left = null; // original cur left be null, avoid infinite loops
	            }
	        }
	        return res;
	    }
	}
	
}
