package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PathSum_2_113 {
	
	class NodeVal{
		TreeNode node;
		int total_val;
		public NodeVal(TreeNode node,int val) {
			this.node=node;
			this.total_val=val;
		}
	}
	
	public void pathSum(TreeNode root, int sum) {
		if(root==null) return null;
		
		List<List<Integer>> resultList=new ArrayList<>();
		List<Integer> tmp_result=new ArrayList<>();
		
		Stack<NodeVal> stack=new Stack<>();
		NodeVal nodeVal=new NodeVal(root,root.val);
		TreeNode node=null;
		int total_value=-1;
		stack.push(nodeVal);
		while(!stack.empty()) {
			nodeVal=stack.pop();
			node=nodeVal.node;
			total_value=nodeVal.total_val;
			if(node.left==null && node.right==null && total_value==sum) {
				
			}
			else {
				if(node.left!=null) stack.push(new NodeVal(node.left,node.left.val+total_value));
				if(node.right!=null) stack.push(new NodeVal(node.right,node.right.val+total_value));
				
			}
			
	}
	    
    }
}


class Solution_113_1 {
	//��¼״̬������
	List<List<Integer>> resPathSum = new ArrayList<>();
       public List<List<Integer>> pathSum(TreeNode root, int sum) {
           pathSumRec(new Stack<Integer>(),root,sum);
           return resPathSum;
       }

       private void pathSumRec(Stack<Integer> temp, TreeNode root, int sum){
           //1.�жϸ��ڵ�Ϊ��
    	   if(root==null)
               return;
           temp.push(root.val);
           //2.�жϵ�ǰ�ڵ�����������Ƿ�Ϊ��
           if(root.left==null && root.right==null){
               if(root.val==sum){
                   List<Integer> li = new ArrayList<>(temp);
                   resPathSum.add(li);
               }
               temp.pop();//����
               return;
           }
           //3.�����������Ͻ���Ѱ��
           pathSumRec(temp,root.left,sum-root.val);//��������Ѱ��
           pathSumRec(temp,root.right,sum-root.val);//������������
           temp.pop();//����
       }
}



//����������������ǻ����������㷨������
class Solution_113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), root, sum, 0);
        return result;
    }
    
	// (N L R -> preorder traversal)
    private void helper(List<List<Integer>> res, List<Integer> cur, TreeNode node, int sum, int curSum) { 
        if (node == null) return;
        
		// N: 
        // do the math 
        cur.add(node.val);
        curSum += node.val;
        
        // traverse all the way down, till base case gets hit
        // L
	    helper(res, cur, node.left, sum, curSum);
	    // R
        helper(res, cur, node.right, sum, curSum);
        
		// since we hit the base case, we bubble up until the current node is a leaf (left and right are null)
		// make sure its a leaf and its curSum is equals to expected sum
        /*
         * �ҵ����������Ľ���б��棬�ҽ��ж�����Ե�ǰ����л��ݣ���Ѱ�Ҹ���Ľ�*/
		if (node.left == null && node.right == null && curSum == sum) {
			res.add(new ArrayList<>(cur));
		}
        // backtrack, undo actions so we are not biased when we check other branches of recursion tree
        cur.remove(cur.size() - 1);
        curSum -= node.val;
    }
}
