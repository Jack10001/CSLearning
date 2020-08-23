package tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersEachNode_116 {
	 public Node connect(Node root) {
		 if(root==null) return null;
		 Queue<Node> queue=new LinkedList<>();
		 int size=-1;
		 Node node=root,curNode=null;
		 queue.add(node);
		 while(!queue.isEmpty()) {
			 size=queue.size();
			 while(size>0) {
				 curNode=queue.poll();
				 
				 if(size==1) curNode.next=null;
				 if(size>1) {
					 curNode.next=queue.peek();
				 }
				 
				 if(curNode.left!=null) queue.add(curNode.left);
				 if(curNode.right!=null) queue.add(curNode.right);
				
				 size--;
			 }
		}
		 return node;
	        
	    }
}

class Solution_116 {
	public Node connect(Node root) {
	    put(root);
		return root;
	}
	//以preorder为基础，对整颗二叉树进行操作
	private void put(Node root) {
	    if (root == null )
			return;

			if (root.left != null)
				root.left.next = root.right;

			if (root.right != null)
				root.right.next = (root.next != null) ? root.next.left : null;

			put(root.left);
			put(root.right);
	}
}
