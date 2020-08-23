package tree;

import java.util.ArrayList;
import java.util.List;

public class Flip_971 {
	  public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
	        
	    }

}

class Solution_971 {
	//N L R
    List<Integer> ans = new ArrayList<>();
    int index = 0;
    boolean flag = false;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        dfs(root, voyage);
        if(flag){
            ans.clear();
            ans.add(-1);
        }
        return ans;
    }
    
    public void dfs(TreeNode root, int[] voyage){
        if(root == null || flag) return;
        if(root.val != voyage[index]){
            flag = true;
            return;
        }
        if(root.left != null && root.left.val != voyage[index + 1]){
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;
            ans.add(root.val);
        }
        index++;
        dfs(root.left, voyage);
        dfs(root.right, voyage);
    }
}
