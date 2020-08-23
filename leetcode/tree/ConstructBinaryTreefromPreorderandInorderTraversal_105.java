package tree;

public class ConstructBinaryTreefromPreorderandInorderTraversal_105 {

}

class Solution_105 {
	   public TreeNode buildTree(int[] preorder, int[] inorder) {
			if(preorder.length==0 || inorder.length==0) return null;
			else 
				return buildTreeHelper(preorder,inorder,0,0,inorder.length-1);
			 
		    }
	   
	   
		//����ؼ���pre_start,in_start,in_end,��pre_endͨ��������Ԫ�صĸ���ȷ��
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
				root.left=buildTreeHelper(preorder, inorder, pre_start+1,in_start , index-1);
				root.right=buildTreeHelper(preorder, inorder, pre_start+(index-in_start+1), index+1, in_end);
				return root;
			}
		}
	}
