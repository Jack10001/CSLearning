package tree;





public class Same_tree_100 {
	
	public boolean isSameTree1(TreeNode p, TreeNode q) {
		if(p!=null && q!=null) {
			if(p.val!=q.val) {
				return false;
			}else {
				return isSameTree1(p.right,q.right)&& isSameTree1(p.left,q.left);//必须要求子树节点的值都相同
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
	 * 思路：在遍历的同时进行判断，要求必须子树的所有节点都相同*/
	@SuppressWarnings("null")
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p==null && q==null) {//return true 递归的时候一层一层返回 ？？？ 一次性返回？？？
			//递归逐级向上返回值，直到第一个被调用的递归函数，把值返回给主函数
			
			//true返回给上层函数？？？		false返回给上层函数？？？
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
			//访问根节点
			pre_order(p.right);
			pre_order(p.left);
		}
		
	}
	
	public void min_order(TreeNode root) {
		
	}
	
	public static void main(String[] args) {
		
	}

}
