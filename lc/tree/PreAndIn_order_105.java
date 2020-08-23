package tree;

public class PreAndIn_order_105 {
	/**
	 * ���������ҵ����ڵ㣬Ȼ����inorder���ҵ�����ĸ��ڵ��������Ȼ��preorder��Ϊ������������������inorder��Ϊ�����������������ݹ��������*/ 
	
	/*����Ĺؼ���ȷ������������Χ���������ķ�Χ*/
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder.length==0 || inorder.length==0) return null;
		else 
			return buildTreeHelper(preorder,inorder,0,0,inorder.length-1);
		 
	    }
	//����ؼ���pre_start,in_start,in_end,��pre_end����ͨ��������ȷ������
	private TreeNode buildTreeHelper(int[] preorder,int[] inorder,int pre_start,int in_start,int in_end) {
		//��������ֹ����
		if(pre_start>preorder.length || in_start > in_end) return null;
		else {
			TreeNode root=new TreeNode(preorder[pre_start]);
			int index=in_start;
			while(index<=in_end) {
				if(inorder[index]==preorder[pre_start]) break;
				index++;
			}
			//�����ڵ�������������������
			root.left=buildTreeHelper(preorder, inorder, pre_start+1,in_start , index-1);//��preorder��inorder��ȷ�������������������������
			root.right=buildTreeHelper(preorder, inorder, pre_start+(index-in_start+1), index+1, in_end);
			return root;
		}
	}
	
	
	
	
	public TreeNode buildTree1(int[] preorder, int[] inorder) {
		if(preorder.length==0 || inorder.length==0) return null;
		//ȷ�����ڵ㣬ȷ��������������������
		else {
			TreeNode root=new TreeNode(preorder[0]);
			//1.��inorder���ҵ����ڵ������
			int index=-1;
			for(int i=0;i<inorder.length;++i) {
				if(inorder[i]==preorder[0]) {
					index=i;
					break;
				}
			}
			//2.ȷ��������������������
			//pre_left:1--index+1
			//pre_right:0+index+1,preorder.end()
			//in_left:0--index
			//in_right:inorder.begin()+index+1,inorder.end()
			/**
			 * vector<int> l_pre(preorder.begin()+1,preorder.begin()+1+flag);//������ǰ��������
        	   vector<int> l_in(inorder.begin(),inorder.begin()+flag);
        	   vector<int> r_pre(preorder.begin()+1+flag,preorder.end());//������ǰ��������
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















