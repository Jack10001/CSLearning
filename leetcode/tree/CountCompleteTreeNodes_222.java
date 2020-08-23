package tree;

import java.util.ArrayList;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

public class CountCompleteTreeNodes_222 {
    int count=0; 
	public int countNodes(TreeNode root) {
		 if(root==null) return count;
		 else {
			 count++;
			 countNodes(root.left);
			 countNodes(root.right);
		 }
		 return count;
	    }
	
}

class Solution_222 {
	   public int countNodes(TreeNode root) {
			 Integer res=new Integer(0);
			 helper(root,res);
			 return res.intValue();
		    }
		 private void helper(TreeNode root,Integer res) {
			 if(root!=null) {
			 res++;
			 helper(root.left, res);
			 helper(root.right, res);
		 }
		 }
	}
 
class Solution_222_2 {
    
    int height=0;
    boolean isFirst=true;
    public int countNodes(TreeNode root) {
        
        int countLeafNode = countLeafNode(root, 0);
        int otherNodes =0;
        otherNodes = (int)Math.pow(2, height)-1;
        return countLeafNode + otherNodes;
    }
    
    private int countLeafNode(TreeNode root, int level){
        if(root==null)
            return 0;
            
        if(null==root.left && null==root.right){
            if(isFirst){
                height=level;
                isFirst=false;
            }
            if(level==height)
                return 1;
            return 0;
        }
        
        return countLeafNode(root.left, level+1) + countLeafNode(root.right, level+1);
    }
}



//使用二分法进行查找
class  Solution_222_3{
	
	public int countNodes(TreeNode root) {
	/*
	 * 根据完全二叉树的性质找到节点个数的最大值和最小值，从此区间中进行二分查找*/
		int height=0;
		TreeNode node=root;
		while(node!=null) {
			height++;
			node=node.left;
		}
		int low=(int)Math.pow(2,height-1);
		int high=(int)Math.pow(2, height)-1;
		int mid=-1;
		while(low<high) {
			mid=low+(high-low+1)/2;
			if(hasK(root, mid)) {
				low=mid;
			}
			else {
				high=mid-1;
				
			}
		}
		return low;
		
	}
	private boolean hasK(TreeNode root,int K) {
	/*
	 * 根据编号确定K是否在二叉树中*/
		ArrayList<Integer> vec=new ArrayList<>();
		while(K>0) {
			vec.add(K);
			K=K/2;
		}
		for(int i=vec.size();i>=0;i--) {
			if(root==null) return false;
			if(i==0) return true;
			if(vec.get(i-1)==vec.get(i)*2) {
				root=root.left;
			}else {
				root=root.right;
			}
		}
		return false;
	  
		
	}
	
}