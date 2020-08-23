package tree;

public class LowestCommonAncestorBinaryTree_236 {
	 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		 return null;
	        
	    }
	 
	 
	 /*
	  * �ݹ������
			��ֹ������
				��Խ��Ҷ�ڵ㣬��ֱ�ӷ��� null ��
				�� root ���� p,q����ֱ�ӷ��� root ��
			���ƹ�����
				�����ݹ����ӽڵ㣬����ֵ��Ϊ left ��
				�����ݹ����ӽڵ㣬����ֵ��Ϊ right ��
			����ֵ�� ���� left �� right ����չ��Ϊ���������
				�� left �� right ͬʱΪ�� ��˵�� root ���� / �������ж������� p,q ������ null ��
				�� left �� right ͬʱ��Ϊ�� ��˵�� p,q ������ root �� ��� ���ֱ��� �� / ������������� root Ϊ����������ȣ����� root ��
				�� left Ϊ�� ��right ��Ϊ�� ��p,q ������ root ���������У�ֱ�ӷ��� right ������ɷ�Ϊ���������
				p,q ����һ���� root �� ������ �У���ʱ right ָ�� p������Ϊ p ����
				p,q ���ڵ㶼�� root �� ������ �У���ʱ�� right ָ�� ����������Ƚڵ� ��
				�� left ��Ϊ�� �� right Ϊ�� ������� 3. ͬ��
		
	  * */
	 class Solution {
		    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		        if(root == null || root == p || root == q) return root;
		        TreeNode left = lowestCommonAncestor(root.left, p, q);
		        TreeNode right = lowestCommonAncestor(root.right, p, q);
		        if(left == null && right == null) return null; // 1.
		        if(left == null) return right; // 3.
		        if(right == null) return left; // 4.
		        return root; // 2. if(left != null and right != null)
		    }
		}
}
