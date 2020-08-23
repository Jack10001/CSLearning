package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeOrderTraversal_1_102 {
	/*
	 * �������������ڵ��Լ�ֵ
	 * ÿ����λ��֣�����-----���ݶ��еĴ�Сȷ��ÿ��ڵ�ĸ���
	 * */
	 public List<List<Integer>> levelOrder(TreeNode root) {
		 LinkedList<List<Integer>> result=new LinkedList<>();
		 if(root==null)
			 return result;
		 Queue<TreeNode> tree=new LinkedList<>();
		 tree.add(root);
		 while(!tree.isEmpty()) {
			 List<Integer> level_result=new ArrayList<>();
			 int size=tree.size();
			 for(int i=0;i<size;i++) {
				 TreeNode q=tree.poll();
				 level_result.add(q.val);
				 if(q.left!=null)
					 tree.add(q.left);
				 if(q.right!=null)
					 tree.add(q.right);
			 }
			 result.add(level_result);
			 
		 }
		 return result;
	        
	    }

}
