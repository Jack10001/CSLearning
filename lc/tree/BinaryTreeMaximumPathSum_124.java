package tree;

public class BinaryTreeMaximumPathSum_124 {
	 public int maxPathSum(TreeNode root) {
	        
	    }

}
class Solution_124 {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        // �ݹ���������ӽڵ�������ֵ
        // ֻ���������ֵ���� 0 ʱ���Ż�ѡȡ��Ӧ�ӽڵ�
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // �ڵ�����·����ȡ���ڸýڵ��ֵ��ýڵ�������ӽڵ�������ֵ
        int priceNewpath = node.val + leftGain + rightGain;//����ýڵ�������·���͵ĸ��ڵ㣬�Դ������ϵĸ���

        // ���´�
        maxSum = Math.max(maxSum, priceNewpath);

        // ���ؽڵ�������ֵ
        return node.val + Math.max(leftGain, rightGain);
    }
}

