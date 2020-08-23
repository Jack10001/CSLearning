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
	        Queue<TreeNode> tree=new LinkedList<>();//LinkedList实现了接口Queue的功能，故LinkedList也有队列的相应功能
	        tree.add(root);
	        while(!tree.isEmpty()) {
	        	List<Integer> level=new ArrayList<>();
	        	size=tree.size();
	            count++;
	        	for(int i=0;i<size;i++) {
	        		TreeNode q=tree.poll();
	        		
	        		if(count%2==1) {//奇数从左往右
	        			level.add(q.val);
	        		}else {
	        			level.add(0, q.val);//偶数从右往左
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
