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
        //����ΪҶ�ӽ��
        if (root.left != null)
        {
            if(root.left.left == null && root.left.right == null && root.left.val == target)
                root.left = null;                
        }
        //�Һ���ΪҶ�ӽ��
        if (root.right != null)
        {
            if(root.right.left == null && root.right.right == null && root.right.val == target)
                root.right = null;                
        }
        //�Լ�����ΪҶ�ӽڵ㣬ֱ�ӷ���nullֵ����
        if (root.val == target && root.left == null && root.right == null)
            return null;
        
        return root;
        
    }
}