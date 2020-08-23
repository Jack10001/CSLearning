package tree;

import java.util.ArrayList;
import java.util.List;

public class TwoSum_IV_InputBST_653 {
	  public boolean findTarget(TreeNode root, int k) {
	        /*
	         * 1.将BSST中的节点值转存到List中
	         * 2.在List中寻找两个数之后为target*/
		  if(root==null) return false;
		  if(root.left==null && root.right==null) return false;
		  ArrayList<Integer> ans=new ArrayList<>();
		  inorder(root, ans);
		  for(int i=0;i<ans.size();i++) {
			  for(int j=i+1;j<ans.size();j++) {
				  if(ans.get(i)+ans.get(j)==k) return true;
			  }
		  }
		  return false;
		  
	    }
	  
	  private void inorder(TreeNode root,ArrayList<Integer> ans) {
		  if(root==null) return;
		  //L N R
		  if(root.left!=null) inorder(root.left, ans);
		  ans.add(root.val);
		  if(root.right!=null) inorder(root.right, ans);

	  
	  }

}


class Solution_653 {
	private ArrayList<Integer> list=new ArrayList<>();
	boolean ans=false;
    public boolean findTarget(TreeNode root, int k) {
    	/*
    	 * 1.L N R
    	 * 2.使用二分查找的思想，对于当前节点，在List中查找 k-root.val即可*/
    	if(root!=null) {
    		//L N R
    		if(root.left!=null) findTarget(root.left, k);
    		if(binarySearch(k-root.val))
    			ans=true;
    		list.add(root.val);
    		if(root.right!=null) findTarget(root.right, k);
    	}
    	return ans;
	    
	  }
    private boolean binarySearch(int taret){
    	int low=0,high=list.size()-1;
    	int mid=-1;
    	while(low<=high) {
    		mid=(low+high)/2;
    		if(list.get(mid)==taret) return true;
    		else if(list.get(mid)<taret) {
    			low=mid+1;
    			
    		}else {
    			high=mid-1;
    			
    		}
    	}
    	return false;
    }

}