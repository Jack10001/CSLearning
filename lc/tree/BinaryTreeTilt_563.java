package tree;

public class BinaryTreeTilt_563 {
	int sumTilt=0;
    public int findTilt(TreeNode root) {
    	//N L R
    	if(root==null) return 0;
    	helper(root);
    	return sumTilt;
    }
    
    private void helper(TreeNode root) {
    	if(root==null) return;
    	if(root.left!=null && root.right!=null)
    		sumTilt+=Math.abs(root.left.val-root.right.val);
    	if(root.left!=null && root.right==null)
    		sumTilt+=Math.abs(root.left.val);
    	if(root.left==null && root.right!=null)
    		sumTilt+=Math.abs(root.right.val);
    	helper(root.left);
    	helper(root.right);
    }

}

class Solution_563 {
    int tilt=0;
    public int findTilt(TreeNode root) {
        traverse(root);
        return tilt;
    }
    public int traverse(TreeNode root)
    {
        if(root==null )
            return 0;
        int left=traverse(root.left);
        int right=traverse(root.right);
        tilt+=Math.abs(left-right);
        return left+right+root.val;
    }
}

