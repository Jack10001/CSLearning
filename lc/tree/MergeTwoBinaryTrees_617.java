package tree;
/**
 * @author mxb14
 *
 */
public class MergeTwoBinaryTrees_617 {
	  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		  //N L R
		  //if(t1==null && t2==null) return t1;
		 //  if((t1.left!=null && t1.right!=null)&&(t2.left!=null && t2.right!==null))
			//   t1.val=t1.val+t2.val;
		  if(t1==null) return t2;
		  if(t2==null) return t1;
		  t1.val=t1.val+t2.val;
		  t1.left=mergeTrees(t1.left,t2.left);
		  t1.right=mergeTrees(t1.right,t2.right);
		  return t1;
	        
	    }

}

class Solution_617{
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		//N L R 
		if(t1 == null ) return t2;
		if(t2 == null ) return t1;
		TreeNode head = new TreeNode(t1.val+t2.val);
		head.left=mergeTrees(t1.left, t2.left);
		head.right=mergeTrees(t1.right, t2.right);
		return head;
	}
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution_617_1 {
	//将 节点对 放入栈中进行遍历
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        Stack < TreeNode[] > stack = new Stack < > ();
        stack.push(new TreeNode[] {t1, t2});
        while (!stack.isEmpty()) {
            TreeNode[] t = stack.pop();
            if (t[0] == null || t[1] == null) {
                continue;
            }
            t[0].val += t[1].val;
			if (t[0].left == null) {
				t[0].left = t[1].left;
			}
			else {
                stack.push(new TreeNode[] {t[0].left, t[1].left});
            }
            if (t[0].right == null) {
                t[0].right = t[1].right;
			}
			else {
                stack.push(new TreeNode[] {t[0].right, t[1].right});
            }
        }
        return t1;
    }
}
