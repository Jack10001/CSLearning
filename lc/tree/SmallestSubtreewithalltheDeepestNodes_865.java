package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;


public class SmallestSubtreewithalltheDeepestNodes_865 {
	//BFS
	  public TreeNode subtreeWithAllDeepest(TreeNode root) {
	      if(root==null) return null;  
	      if(root.left==null || root.right==null) return root;
		  Queue<TreeNode> queue=new LinkedList<>();
		  TreeNode curNode=null,ansNode=null;
		  int height=-1;
		  int size=0;
		  queue.add(root);
		  while(!queue.isEmpty()) {
			  size=queue.size();
			  for(int i=0;i<size;i++) {
				  curNode=queue.poll();
				  if(curNode.left!=null || curNode.right!=null) ansNode=curNode;
		
				  if(curNode.left!=null) queue.add(curNode.left);
				  if(curNode.right!=null) queue.add(curNode.right);
			  }
			  height++;
			  
		  }
	     return ansNode;   
	    }
	 
	

}

class Solution_865 {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
		if (root == null)
			return root;
       
        q.add(root);
        HashMap<TreeNode, TreeNode> mapOfNodes = new HashMap<>();
        
        while (!q.isEmpty()) {
            Queue<TreeNode> tempQ = new LinkedList<TreeNode>();
            for(TreeNode t: q) {                
                if(t.left != null) {
                    tempQ.add(t.left);
                    mapOfNodes.put(t.left, t);//保存子节点和父节点
                }

                if(t.right != null) {
                    tempQ.add(t.right);
                    mapOfNodes.put(t.right, t);
                }
            }
            if(tempQ.size() == 0) {
                break;
            }
            else {
                q = tempQ;
            }
        }
        
        return getSharedParent(q, mapOfNodes);
    }
    
    private TreeNode getSharedParent(Queue<TreeNode> q,  HashMap<TreeNode, TreeNode> mapOfNodes) {
         while(!q.isEmpty()) {
            if(q.size() == 1) return q.poll();
            
            Queue<TreeNode> tempQ = new LinkedList<TreeNode>();
            for(TreeNode t: q) {
                if(!tempQ.contains(mapOfNodes.get(t))) {
                    tempQ.add(mapOfNodes.get(t));
                }
            }
            q = tempQ;
        }
        return null;
   }
}

/*
 * 一个包含所有最大深度结点的最近祖先一定满足条件：左子树的深度等于右子树的深度；
 * 当左子树深度大于右子树深度时，要查找的点一定在左侧，否则在右侧
*/

class Solution_865_{
	private int height(TreeNode root){
        if(root == null) return 0;
        int l = height(root.left);
        int r = height(root.right);
        return Math.max(l,r)+1;
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root == null) return root;
        int l = height(root.left);
        int r = height(root.right);
        if(l == r) return root;
        if(l > r) return subtreeWithAllDeepest(root.left);
        else return subtreeWithAllDeepest(root.right);
    }
}