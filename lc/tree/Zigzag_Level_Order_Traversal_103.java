package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Zigzag_Level_Order_Traversal_103 {
	 public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	        LinkedList<List<Integer>> result=new LinkedList<>();
	        int size=-1;
	        int count=0;
	        if(root==null)
	        	return result;
	        Queue<TreeNode> tree=new LinkedList<>();//LinkedListʵ���˽ӿ�Queue�Ĺ��ܣ���LinkedListҲ�ж��е���Ӧ����
	        tree.add(root);
	        while(!tree.isEmpty()) {
	        	List<Integer> level=new ArrayList<>();
	        	size=tree.size();
	            count++;
	        	for(int i=0;i<size;i++) {
	        		TreeNode q=tree.poll();
	        		
	        		if(count%2==1) {//������������
	        			level.add(q.val);
	        		}else {
	        			level.add(0, q.val);//ż����������
	        		}
	        		
	        		if(q.left!=null)
	        			tree.add(q.left);
	        		if(q.right!=null)
	        			tree.add(q.right);
	        	}
	        	result.add(level);
	        }
	        return result;
	        
	     }


}
