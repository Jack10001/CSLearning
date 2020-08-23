package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree_Order_Traversal_2_107 {
	/*
	 * ˼·��
	 * �������������ÿһ��Ľڵ��ֵ������ÿһ���ֵ�ŵ����list����ǰ��
	 * */

public static List<List<Integer>> levelOrder(TreeNode root) {
    LinkedList<List<Integer>> result = new LinkedList<>();
    if (root == null) {
        return result;
    }
    Queue<TreeNode> trees = new LinkedList<>();
    trees.add(root);
    while (!trees.isEmpty()) {
        int size = trees.size();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            TreeNode tree = trees.poll();
            list.add(tree.val);
            if (tree.left!= null) {
                trees.add(tree.left);
            }
            if (tree.right != null) {
                trees.add(tree.right);
            }
        }
        result.addFirst(list);
    }
    return result;

}


}
