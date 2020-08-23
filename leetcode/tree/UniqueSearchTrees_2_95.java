package tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;



public class UniqueSearchTrees_2_95 {
	/**
	 * 算法过程：
	 * 1.for min to max://第i个节点为K，则左子树min--K-1，右子树k+1--max
	 * 	  2. creatroot(i)
	 * 	  3.helper---list of left subtree BST
	 *             list of right subtree BST
	 *    4.将左右子树的与根节点进行连接*/
	 public  List<TreeNode> generateTrees(int n) {
		 return helper(1,n);
	 }
	 private List<TreeNode> helper(int min,int max) {
		 List<TreeNode> result=new LinkedList<>();
		 if(min>max) return result;
		 for(int i=min;i<=max;++i) {
			 List<TreeNode> left_subtrees=helper(min, i-1);
			 List<TreeNode> right_subtrees=helper(i+1, max);
			 //判断左子树们和右子树们的大小
			 if(left_subtrees.size()==0 && right_subtrees.size()==0) {
				 TreeNode root=new TreeNode(i);
				 result.add(root);
			 }else if(left_subtrees.size()==0) {//没有左子树们，只有右子树们
				 for(TreeNode node:right_subtrees) {
					 TreeNode root=new TreeNode(i);
					 root.right=node;
					 result.add(root);
				 }
				 
			 }else if(right_subtrees.size()==0) {//只有右子树梦，没有左子树们
				 for(TreeNode node:left_subtrees) {
					 TreeNode root=new TreeNode(i);
					 root.left=node;
					 result.add(root);
				 }
			 }else {
				 for (TreeNode leftTree : left_subtrees) {//左子树们和右子树们都有，每一个左子树对应每一个右子树
		                for (TreeNode rightTree : right_subtrees) {
		                    TreeNode current = new TreeNode(i);                  
		                    current.left = leftTree;
		                    current.right = rightTree;
		                    result.add(current);
		                }
		            }
			 }
		 }
		return result; 
	}
	
	
	 
	 
	 public static List<TreeNode> generateTrees1(int n) {
	        if (n <= 0) return Collections.emptyList();
	        if (n == 1) return Collections.singletonList(new TreeNode(1));
	        return generateTrees(1, n);
	    }

	    /**
	     * https://leetcode.com/problems/unique-binary-search-trees/submissions/
	     * 1.result(n) = f(1,n) + f(2,n) + ... + f(n,n)
	     * 2.f(i,n) = result(i - 1) * result(n - i)
	     */
	    private static List<TreeNode> generateTrees(int start, int end) {
	        List<TreeNode> result = new LinkedList<>();
	        if (start > end) {
	            result.add(null);
	            return result;
	        }
	        // result[n] = f(1) + f(2) + ... + f(n)
	        // f(i) = left:result(i - 1) * right:result(n - i) 
	        for (int i = start; i <= end; i++) {
	            List<TreeNode> leftTrees = generateTrees(start, i - 1);//每一个有效的左子树的根节点
	            List<TreeNode> rightTrees = generateTrees(i + 1, end);//每一个有效的右子树的根节点
             
	            for (TreeNode leftTree : leftTrees) {
	                for (TreeNode rightTree : rightTrees) {
	                    TreeNode current = new TreeNode(i);
	                   
	                    current.left = leftTree;
	                    current.right = rightTree;
	                    result.add(current);
	                }
	            }
	        }
	        return result;
	    }
	    
	    
	    
	    
	    
	    public static void preorder(TreeNode root) {
	    	if(root==null) {
	    		System.out.print("null"+" ");
	    		return;
	    		}
	    	else{
	    		System.out.print(root.val+" ");
	    		preorder(root.left);
	    		preorder(root.right);	    		
	    	}
	    }
	    
	    
	    
	    
	    
	    
	    public static void main(String[] args) {
	    	 List<TreeNode> result=new LinkedList<>();
	    	 result=generateTrees1(3);
	    	// for(TreeNode node:result) {
	    	//	 preorder(node);
	    	//	 System.out.println();
	    	 //}
	    	 
			
		}

}
