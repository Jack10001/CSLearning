package tree;

import java.util.LinkedList;
import java.util.Queue;



public class SubtreeofAnotherTree_572 {
	 public boolean isSubtree(TreeNode s, TreeNode t) {
		 //BFS+DFS t is subtree of s
		 //BFS
		 if(t==null) return true;
		 if(s==null) return false;
		 Queue<TreeNode> queue=new LinkedList<>();
		 queue.add(s);
		 TreeNode curNode=null;
		 while(!queue.isEmpty()){
			 curNode=queue.poll();
			 if(curNode.val==t.val && check(t,curNode )) return true;
			 if(curNode.left!=null) queue.add(curNode.left);
			 if(curNode.right!=null) queue.add(curNode.right);
		 }
		 return false;

		}
	private boolean check(TreeNode r1, TreeNode r2){
		if((r1==null && r2!=null) || (r1!=null && r2==null) || (r1!=null && r2!=null && r1.val != r2.val)) return false;
		else if(r1 == null && r2 == null) return true;
		
		boolean leftres = false, rightres = false;
		
		leftres = check(r1.left, r2.left);
		rightres = check(r1.right, r2.right);

		return leftres && rightres;
	}





	public boolean isSubtree1(TreeNode s, TreeNode t) {
		if(t==null) return true;
		if(s==null && t!=null) return false;
		if(checkSubtree(s, t)) return true;
		return checkSubtree(s.left, t)||checkSubtree(s.right, t);

	}
	private boolean checkSubtree(TreeNode root,TreeNode sub){
		/*返回false：
		1.左子树不为空，右子树为空；
		2. 左子树为空，右子树不为空
		3.左右子树均不为空，但是值不相同*/
		if(sub==null) return true;
		if(root==null) return false;
		if(root.val!=sub.val) return false;
		return checkSubtree(root.left, sub.left) && checkSubtree(root.right, sub.right);

	}

}

class Solution_572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) return false;
        if((s!=null && t!=null) && (s.val == t.val)){
            if(check(s, t)) return true;
        }
        
        boolean leftres = false, rightres = false;
        
        if(s.left != null) leftres = isSubtree(s.left, t);
        if(s.right != null) rightres = isSubtree(s.right, t);
        
        return leftres || rightres; 
    }

    private boolean check(TreeNode r1, TreeNode r2){
        if((r1==null && r2!=null) || (r1!=null && r2==null) || (r1!=null && r2!=null && r1.val != r2.val)) return false;
        else if(r1 == null && r2 == null) return true;
        
        boolean leftres = false, rightres = false;
        
        leftres = check(r1.left, r2.left);
        rightres = check(r1.right, r2.right);

        return leftres && rightres;
    }
}