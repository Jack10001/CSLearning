package tree;

import java.util.Stack;

import tree.PathSum_112.NodeVal;

public class PathSum_112 {
	public boolean hasPathSum1(TreeNode root, int sum) {
		//����
		//int result=0;
		Integer result=new Integer(0);
		return getsum(root,sum,result);
    	}
	private boolean getsum(TreeNode root,int sum,Integer result) {
		if(root==null) {
			
		}
		else{
			int val=root.val;
			result+=val;
			
			getsum(root.left, sum, result);
			getsum(root.right, sum, result);
			
		}
		
		
	}
	
	/*
	 * ��Ͳ������*/
	public boolean hasPathSum(TreeNode root, int sum) {
		//1.�ж�Ϊ��
		if(root==null) return false;
		
		if(root.left==null && root.right==null && root.val==sum) return true;
		else {
			return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
		}
		
	}
	
	
	
	/*˼·��ʹ��ջ��ͬʱ����node��root����·������node��totalֵ*/
	class NodeVal{
		TreeNode node;
		int total_val;
		public NodeVal(TreeNode node,int val) {
			this.node=node;
			this.total_val=val;
		}
	}
	public boolean hasPathSum2(TreeNode root, int sum) {
		if(root==null) return false;
		Stack<NodeVal> stack=new Stack<>();
		NodeVal nodeVal=new NodeVal(root,root.val);
		TreeNode node=null;
		int total_value=-1;
		stack.push(nodeVal);
		while(!stack.empty()) {
			nodeVal=stack.pop();
			node=nodeVal.node;
			total_value=nodeVal.total_val;
			if(node.left==null && node.right==null && total_value==sum)
				return true;
			else {
				if(node.left!=null) stack.push(new NodeVal(node.left,node.left.val+total_value));
				if(node.right!=null) stack.push(new NodeVal(node.right,node.right.val+total_value));
				
			}
			
	}
		return false;
	}

}
