package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintBinaryTree_655 {
	 public List<List<String>> printTree(TreeNode root) {
	        
	    }

}

class Solution_655 {
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        int width = (int) Math.pow(2, height) - 1;
        String[][] arr = new String[height][width];
        
        for (String[] a: arr)
            Arrays.fill(a, "");
        
        helper(arr, 0, 0, width - 1, root);
        
        List<List<String>> res = new ArrayList<>();
        for (String[] a: arr) {
            res.add(Arrays.asList(a));
        }
        
        return res;
    }
    
    void helper(String[][] arr, int level, int left, int right, TreeNode node) {
        if (node == null)
            return;
        
        int mid = left + (right - left) / 2;
        arr[level][mid] = String.valueOf(node.val);
        helper(arr, level + 1, left, mid - 1, node.left);
        helper(arr, level + 1, mid + 1, right, node.right);
    }
    
    int getHeight(TreeNode node) {
        if (node == null)
            return 0;
        
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
}
