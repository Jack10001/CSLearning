package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TrimBST_669 {
	//此算法打乱了BST的顺序，重新构造BST不符合题意
	private List<Integer> ans=new ArrayList<>();
	public TreeNode trimBST(TreeNode root, int L, int R) {
		   if(root==null) return null;
	        inorder(root, L, R);
	        int len=ans.size();
	        return constructBST(0, len);
	    }
	private void inorder(TreeNode root,int L,int R) {
		if(root!=null) {
			//L N R
			inorder(root.left, L, R);
			if(root.val>=L && root.val<=R) {
				ans.add(root.val);
			}
			inorder(root.right, L, R);
		}
	}
	private TreeNode constructBST(int first,int last) {
		if(first>last) return null;
		//N L R
		int mid=(first+last)/2;
		TreeNode node=new TreeNode(ans.get(mid));
		//construct left subtree
		node.left=constructBST(first, mid-1);
		//construct right subtree
		node.right=constructBST(mid+1, last);
		return node;
		
	}

}
/*
1.Find the new root in first while loop.
2.Put that root in a stack and loop.
3.if left is less than L, make 'left.right' as its left node. set a flag that tree has been adjusted.
4.if right is greater than R, make 'right.left' as its right node. set a flag that tree has been adjusted.
5.if tree has been adjusted (this means that newly added left or right children of current node needs to be checked), put the same node back to stack and do step 3 and 4.
6.if tree has NOT been adjusted (this means that nodes upto this point are valid and at their correct positions), then put its left and right children into stack and go on.
7.Reset 'adjusted' flag at the end of every loop.
*/
class Solution_669{
	public TreeNode trimBST(TreeNode root, int L, int R) {
		        if(root == null) return root;
		        //Value(root)<L or Value(root)>R
		        while(root.val < L || root.val > R){//找到一个符合[L,R]区间内的根节点
		            if(root.val < L) root = root.right;
		            if(root.val > R) root = root.left;
		        }
		        
		        Deque<TreeNode> stack = new LinkedList<>();
		        stack.push(root);
		        boolean adjusted = false;
		        
		        while(!stack.isEmpty()){
		            TreeNode node = stack.pop();

		            if(node.left != null && node.left.val < L){
		                node.left = node.left.right;//往大的方向调整，靠近L到R的区间
		                adjusted = true;
		            }
		            if(node.right != null && node.right.val > R){
		                node.right = node.right.left;//往小的方向调整，靠近L到R的区间
		                adjusted = true;
		            }
		            //未经调整，说明该节点的左右子树是在[L,R]的区间内的
		            if(!adjusted){
		                if(node.left != null) stack.push(node.left);
		                if(node.right != null) stack.push(node.right);
		            }else{
		                stack.push(node);//将node入栈继续对BST进行调整
		            }
		            adjusted = false;
		            
		        }
		        return root;
		    }
}
	

class Solution_669_{
		//递归 假设命题法 相信你的函数能够做出最正确的选择
		 public TreeNode trimBST(TreeNode root, int L, int R) {
			 if(root==null) return null;
			 //N L R
			 //BST的性质
			 if(root.val<L) return trimBST(root.right, L, R);
			 if(root.val>R) return trimBST(root.left, L, R);
			
			 root.left=trimBST(root.left, L, R);
			 root.right=trimBST(root.right, L, R);
			 return root;
		       
	}
	
}

