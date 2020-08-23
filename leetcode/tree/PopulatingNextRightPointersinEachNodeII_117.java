package tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNodeII_117 {
	//使用BFS不管是不是完全二叉树
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


class Solution_117_1 {
	//DFS
    public Node connect(Node curr) {
        if (curr == null) {
            return null;
        }
        
        if (curr.left != null) {
            if (curr.right != null) {
                curr.left.next = curr.right;
            } else {
                curr.left.next = findNext(curr.next);
            }
            
        }
        
        if (curr.right != null) {
            curr.right.next = findNext(curr.next);
        }
        
        connect(curr.right);
        connect(curr.left);
        return curr;
    }
    //在同一层级一直往右寻找，直到找到为止  
    public Node findNext(Node curr) {
        while(curr!=null) {
	        if (curr.left != null) {
	            return curr.left;
	        }
	        
	        if (curr.right != null) {
	            return curr.right;
	        }
	        
	        curr=curr.next;
        }
    	return null;
    }
}
