package tree;

import java.util.ArrayList;
import java.util.List;

/**
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        else
            return isMirror(root.left, root.right);
    }
    public boolean isMirror(TreeNode m, TreeNode n) {
        if(m == null & n == null)
            return true;
        else if(m !=null && n !=null && m.val == n.val)
            return (isMirror(m.left, n.right) && isMirror(m.right, n.left));
        else 
            return false; 
    }
}
*/

//DFS 递归 ， BFS 迭代

public class SymmetricTree_101 {
	 public boolean isSymmetric(TreeNode root) {
		 if(root==null) 
			 return true;
		 else
			 return isMirror(root.left, root.right);
	    }
	 
    public boolean isMirror(TreeNode p, TreeNode q) {
		 if(p==null && q==null) {//0 0 
				return true;
			}else if(p==null || q==null) {//0 1 || 1 0
				return false;
			}else {
				if(p.val==q.val) {//1 1
					return isMirror(p.right, q.left) && isMirror(p.left, q.right);
				}else {
					return false;//val值不相等，
				}
			}
	}
}


//迭代解决对称树问题
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        List<TreeNode> l1 = new ArrayList<TreeNode>();
        List<TreeNode> l2 = new ArrayList<TreeNode>();
        l1.add(root.left);
        l2.add(root.right);
        int cur1 = 0;
        int cur2 = 0;
        while(cur1 < l1.size() && cur2 < l2.size()) {
            if(l1.get(cur1) == null && l2.get(cur2) == null) {
                cur1++;
                cur2++;
                continue;
            }
            else if(l1.get(cur1) == null || l2.get(cur2) == null)
                return false;
            else if(l1.get(cur1).val == l2.get(cur2).val) {
                l1.add(l1.get(cur1).left);
                l1.add(l1.get(cur1++).right);
                l2.add(l2.get(cur2).right);
                l2.add(l2.get(cur2++).left);
            }
            else
                return false;
        }
        return true;
    }
}
