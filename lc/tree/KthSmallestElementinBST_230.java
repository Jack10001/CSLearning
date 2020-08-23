package tree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementinBST_230 {
	 public int kthSmallest(TreeNode root, int k) {
		 /*
		  * ˼·��ʹ����������ķ�ʽ��BSTչ����ArrayList�У�ʹ��get����ȡ�õ�KС��ֵ*/
		 List<Integer> res=new ArrayList<>();
		 inorder(root, res);
		 return res.get(k-1);
	    }
	 private void inorder(TreeNode root,List<Integer> res) {
		 if(root==null) return;
		 //L
		 inorder(root.left, res);
		 //N
		 res.add(root.val);
		 //R
		 inorder(root.right, res);
	 }

}

class Solution_230{
	 public int kthSmallest(TreeNode root, int k) {
		TreeNode node = morrisTraversal(root,k);
	    return node.val;
	    
	}

	TreeNode morrisTraversal(TreeNode root, int k){
	    
	    TreeNode currentNode = root;
	    int count=0;
	    while(currentNode!=null){
	    if(currentNode.left==null){
	        count++;
	        if(count==k){
	            
	                return currentNode;
	            }
	        currentNode = currentNode.right;
	    }else{
	        
	        //find the inorder predecessor of current
	        
	        TreeNode node = currentNode.left;
	        
	        while(node.right!=null && node.right!=currentNode){
	            node = node.right;
	        }
	        
	        if(node.right==null){
	            node.right = currentNode;   
	            currentNode = currentNode.left;
	        }else{
	            
	            node.right=null;
	            count++;
	            if(count==k){
	                return currentNode;
	            }
	            currentNode = currentNode.right;
	        }

	        
	    }
	    }
	    return null;

	}
}