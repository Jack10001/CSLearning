package tree;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (root != null) return helper(root, result);
    return result;
}

public List<Integer> helper(TreeNode root, ArrayList<Integer> result) {
    if (root == null) {
        return null;
    }
    helper(root.left,result);
    result.add(root.val);
    helper(root.right,result);
    return result;
}
}