package tree;



public class DeleteLeavesWithaGivenValue_1325 {
	
	 public TreeNode removeLeafNodes(TreeNode root, int target) {
		 if(root==null) return null;
		 //L R N
		 root.left=removeLeafNodes(root.left, target);
		 root.right=removeLeafNodes(root.right, target);
	     if(root.left==null && root.right==null && root.val==target) return null;
		
		 return root;
	        
	    }
	

}

class Solution_1325 {
    public TreeNode removeLeafNodes(TreeNode root, int target) 
    {
        if (root == null)
            return root;
        
        removeLeafNodes(root.left, target);
        removeLeafNodes(root.right,target);
        //左孩子为叶子结点
        if (root.left != null)
        {
            if(root.left.left == null && root.left.right == null && root.left.val == target)
                root.left = null;                
        }
        //右孩子为叶子结点
        if (root.right != null)
        {
            if(root.right.left == null && root.right.right == null && root.right.val == target)
                root.right = null;                
        }
        //自己本身为叶子节点，直接返回null值即可
        if (root.val == target && root.left == null && root.right == null)
            return null;
        
        return root;
        
    }
}