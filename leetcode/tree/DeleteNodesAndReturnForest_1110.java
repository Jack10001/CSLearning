package tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class DeleteNodesAndReturnForest_1110 {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete){
        Set<Integer> del = new HashSet<>();
        //Set是无序但里面的值是唯一的数据结构
        for(int i : to_delete){
            del.add(i);
        }
        Queue<TreeNode> q = new LinkedList<>();
        List<TreeNode> list = new ArrayList<>();
        q.add(root);
        //删除的之中不包括树根节点的值
        if(!del.contains(root.val))
            list.add(root);
        while(q.size()!=0){
            TreeNode current = q.poll();
            TreeNode right=null, left=null;
            if(current.right!=null){
                right = current.right;
                q.add(current.right);
                //跟父节点断开
                if(del.contains(right.val))
                    current.right = null;
            }
            if(current.left != null){
                left = current.left;
                q.add(current.left);
                if(del.contains(left.val))
                    current.left = null;
            }
            if(del.contains(current.val)){
                //跟左右子节点断开
                current.left = null;
                current.right = null;
                if(left!=null && !del.contains(left.val))
                    list.add(left);
                if(right!=null && !del.contains(right.val))
                    list.add(right);
                
                
            }
        }
        return list;
    }

}

