package tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum_3_437 {
    public int pathSum(TreeNode root, int sum) {
        
    }

}


class Solution_437{
    public int pathSum(TreeNode root, int sum) {
        return pathSumRec(root, sum, new ArrayList<Integer>());	
    }
    public int pathSumRec(TreeNode node, int k, List<Integer> pathSums) {
        if(node==null) return 0;
        List<Integer> pathSumsLeft = new ArrayList<>();
        int pathsInLeft = pathSumRec(node.left, k, pathSumsLeft);
        List<Integer> pathSumsRight = new ArrayList<>();
        int pathsInRight = pathSumRec(node.right, k, pathSumsRight);
        
        int paths = 0;
        if(node.val==k) paths++;
        pathSums.add(node.val);
        
        for(int i: pathSumsLeft) {
            if(node.val+i==k) {
                paths++;
            }
            pathSums.add(node.val+i);
        }

        for(int i: pathSumsRight) {
            if(node.val+i==k) {
                paths++;
            }
            pathSums.add(node.val+i);
        }
        return paths+pathsInLeft+pathsInRight;
    }
}