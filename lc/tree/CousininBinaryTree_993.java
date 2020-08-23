package tree;

import java.util.LinkedList;
import java.util.Queue;

public class CousininBinaryTree_993 {
	//BFS 1.same depth 2.different parent 
	//�������ڵ��ֵ��Ψһ��
	/**
	 * ˼·�����ҵ�x��y�����ҵ���һ��*/
	public boolean isCousins(TreeNode root, int x, int y) {
		if(root==null) return false;
		if(root.val==x || root.val==y) return false;
		boolean  isFoundHalf=false;
		Queue<TreeNode> queue=new LinkedList<>();
		queue.add(root);
		int size=-1;
		TreeNode curNode=null;
		while(!queue.isEmpty()) {
			size=queue.size();
			//��ͬһ������жϣ�������ж���ͬcousin�ڵ����ͬ���
			for(int i=0;i<size;i++) {
				curNode=queue.poll();
				if(curNode.left!=null) queue.add(curNode.left);
				if(curNode.right!=null) queue.add(curNode.right);
				//check same parent
				if((curNode.left!=null && curNode.right!=null)
						&& (curNode.left.val==x || curNode.left.val==y) 
						&&(curNode.right.val==x || curNode.right.val==y)) return false;
				if(curNode.left!=null && (curNode.left.val==x || curNode.left.val==y)) {
					if(isFoundHalf) return true;
					isFoundHalf=true;
				}
				if(curNode.right!=null && (curNode.right.val==x || curNode.right.val==y)) {
					if(isFoundHalf) return true;
					isFoundHalf=true;
				}
				
			}
			isFoundHalf=false;
		}
		return false;
		
	        
	    }

}



class Solution_993 {
    TreeNode xpar,ypar;
    Integer xdepth,ydepth;
    //track parent for every node in the recursion
    public void dfs(TreeNode root,TreeNode parent,int x,int y,int depth){
	//you can return if parent of x and y are already found
        if(root==null || (xpar!=null &&ypar!=null)){
           return; 
        }
        if(root.val==x){
            xpar=parent;
            xdepth=depth;
        }else if(root.val==y){
            ypar=parent;
            ydepth=depth;
        }
        
        dfs(root.left,root,x,y,depth+1);
        dfs(root.right,root,x,y,depth+1);
        
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root,null,x,y,0);
        return xdepth==ydepth && xpar!=ypar;
    }
}
