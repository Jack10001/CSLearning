package tree;





public class Same_tree_100 {
	
	public boolean isSameTree1(TreeNode p, TreeNode q) {
		if(p!=null && q!=null) {
			if(p.val!=q.val) {
				return false;
			}else {
				return isSameTree1(p.right,q.right)&& isSameTree1(p.left,q.left);//����Ҫ�������ڵ��ֵ����ͬ
			}
		}else {
			if(p==null && q==null) {
				return true;
			}else {
				return false;
			}
		}
    }
	
	
	
	
	
	/**
	 * ˼·���ڱ�����ͬʱ�����жϣ�Ҫ��������������нڵ㶼��ͬ*/
	@SuppressWarnings("null")
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p==null && q==null) {//return true �ݹ��ʱ��һ��һ�㷵�� ������ һ���Է��أ�����
			//�ݹ������Ϸ���ֵ��ֱ����һ�������õĵݹ麯������ֵ���ظ�������
			
			//true���ظ��ϲ㺯��������		false���ظ��ϲ㺯��������
			return true;
		}else if(p==null || q==null) {
			return false;
		}else {
			if(p.val==q.val) {
				return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
			}else {
				return false;
			}
		}
    }
	
	
	
	
	
	public void pre_order(TreeNode root) {
		TreeNode p=root;
		if(p==null)
			return ;
		else {
			//���ʸ��ڵ�
			pre_order(p.right);
			pre_order(p.left);
		}
		
	}
	
	public void min_order(TreeNode root) {
		
	}
	
	public static void main(String[] args) {
		
	}

}
