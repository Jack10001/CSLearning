package tree;

public class PreAndIn_order_105 {
	/**
	 * 根据线序找到根节点，然后在inorder中找到先序的根节点的索引，然后将preorder分为左子树和右子树，将inorder分为左子树和右子树，递归遍历即可*/ 
	
	/*问题的关键：确定出左子树范围和右子树的范围*/
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder.length==0 || inorder.length==0) return null;
		else 
			return buildTreeHelper(preorder,inorder,0,0,inorder.length-1);
		 
	    }
	//问题关键：pre_start,in_start,in_end,而pre_end可以通过其他的确定出来
	private TreeNode buildTreeHelper(int[] preorder,int[] inorder,int pre_start,int in_start,int in_end) {
		//参数的终止条件
		if(pre_start>preorder.length || in_start > in_end) return null;
		else {
			TreeNode root=new TreeNode(preorder[pre_start]);
			int index=in_start;
			while(index<=in_end) {
				if(inorder[index]==preorder[pre_start]) break;
				index++;
			}
			//将根节点与左右子树连接起来
			root.left=buildTreeHelper(preorder, inorder, pre_start+1,in_start , index-1);//在preorder和inorder中确定左子树和右子树的数组访问
			root.right=buildTreeHelper(preorder, inorder, pre_start+(index-in_start+1), index+1, in_end);
			return root;
		}
	}
	
	
	
	
	public TreeNode buildTree1(int[] preorder, int[] inorder) {
		if(preorder.length==0 || inorder.length==0) return null;
		//确定跟节点，确定代表左右子树的数组
		else {
			TreeNode root=new TreeNode(preorder[0]);
			//1.在inorder中找到根节点的索引
			int index=-1;
			for(int i=0;i<inorder.length;++i) {
				if(inorder[i]==preorder[0]) {
					index=i;
					break;
				}
			}
			//2.确定代表左右子树的数组
			//pre_left:1--index+1
			//pre_right:0+index+1,preorder.end()
			//in_left:0--index
			//in_right:inorder.begin()+index+1,inorder.end()
			/**
			 * vector<int> l_pre(preorder.begin()+1,preorder.begin()+1+flag);//左子树前、中序列
        	   vector<int> l_in(inorder.begin(),inorder.begin()+flag);
        	   vector<int> r_pre(preorder.begin()+1+flag,preorder.end());//右子树前、中序列
        	   vector<int> r_in(inorder.begin()+flag+1,inorder.end());
			 * */
			int[] pre_left=preorder[];
			int[] pre_right=;
			int[] in_left=;
			int[] in_right=;
			
			root.left=buildTree(pre_left, in_left);
			root.right=buildTree(pre_right, in_right);
			return root;
		}
	}

}















