package tree;

import java.util.Stack;

public class ConvertSortedArraytoBST_108 {
	/**
	 * */
	//ʹ�÷ֶ���֮��˼�룬���������൱�ڽ��ж��ִ���
	//1.ѡ���м�ڵ�Ϊ���ڵ�
	//2.�ݹ��ҵ����ڵ����������������
	  public TreeNode sortedArrayToBST(int[] nums) {
		    if(nums==null || nums.length==0) return null;
	        int last=nums.length-1;
	        int first=0;
	        return helper(nums, first, last);
		  
	    }
	  
	  private TreeNode helper(int[] nums,int first,int last) {
		  if(first>last) return null;
		  //�ֶ���֮
		  int mid=(int)((first+last)/2);
		  TreeNode root=new TreeNode(nums[mid]);
		  root.left=helper(nums, first, mid-1);
		  root.right=helper(nums, mid+1, last);
		  return root;
	  }

}

class Solution_108 {
    class Node{ // need another class to store multi information
        int low, up; // means the TreeNode covers [low, up], low and up are all index
        TreeNode t;
        Node(int l, int p, TreeNode node){
            low = l;
            up = p;
            t = node;
        }
    }
    public TreeNode sortedArrayToBST(int[] num) {
        if(num == null || num.length == 0) return null;
        Stack<Node> stack = new Stack<Node>();
        // initialize
        TreeNode root = new TreeNode(num[(num.length-1)/2]);//����������м�ڵ���Ϊ���ڵ�
        Node rootNode = new Node(0,num.length-1,root);//���䱣��������
        stack.push(rootNode);
        // iteration
        while(!stack.isEmpty()){
            Node node = stack.pop();
            int middle = (node.low+node.up)/2; // cut half for [low, up]
            
            // [low, middle-1]
            if(middle-1 >= node.low){
                TreeNode leftnode = new TreeNode(num[(middle-1+node.low)/2]);//���ֲ���
                node.t.left = leftnode;
                Node left = new Node(node.low, middle-1, leftnode);
                stack.push(left);
            }
            // [middle+1, up]
            if(middle+1 <= node.up){
                TreeNode rightnode = new TreeNode(num[(middle+1+node.up)/2]);
                node.t.right = rightnode;
                Node right = new Node(middle+1, node.up, rightnode);
                stack.push(right);
            }
        }
        return root;
    }
}
