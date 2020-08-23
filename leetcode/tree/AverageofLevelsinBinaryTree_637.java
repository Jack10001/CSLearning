package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageofLevelsinBinaryTree_637 {
	

}

class Solution_637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double levelSum = 0;
            
            for (int i=0; i<levelSize; i++) {
                TreeNode currentNode = queue.poll();
                levelSum += currentNode.val;
                
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                } 
                
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            
            result.add(levelSum / levelSize);
        }
        
        return result;
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
class Solution_6371{
    public List < Double > averageOfLevels(TreeNode root) {
        List < Integer > count = new ArrayList < > ();
        List < Double > res = new ArrayList < > ();
        average(root, 0, res, count);
        for (int i = 0; i < res.size(); i++)
            res.set(i, res.get(i) / count.get(i));
        return res;
    }
    public void average(TreeNode t, int i, List < Double > sum, List < Integer > count) {
       //N L R  �������������ÿ�����ֵ������
    	if (t == null)
            return;
    	//�����ǰ����С��sum.size()��ζ��sumͳ���Ѿ���������һ���������¼��㣬��ʱֻ��Ҫ��sum�е�i����ȡ�������i�㣬���Ըò�Ľڵ������Ӧ��
    	//����
        if (i < sum.size()) {//i���������sum.size()��ֵ����Ͳ���i���
            sum.set(i, sum.get(i) + t.val);//sum���ڶԶ�����ÿ����ܺͽ���ͳ��
            count.set(i, count.get(i) + 1);//count���ڶԶ�������ÿ��Ľڵ��������ͳ��
        } else {
            sum.add(1.0 * t.val);
            count.add(1);
        }
        average(t.left, i + 1, sum, count);
        average(t.right, i + 1, sum, count);
    }
}
