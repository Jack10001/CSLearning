package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class N_aryTreePreorderTraversal_589 {
	
	//recursion
	private List<Integer> ans=new ArrayList<>();
	 public List<Integer> preorder(N_node root) {
		 //n-ary的父节点只有一个，但是子节点可以有很多个
		 if(root!=null) {
			 //N L R
			 ans.add(root.val);
			 for(int i=0;i<root.children.size();i++)
				 preorder(root.children.get(i));
		 }
	       return ans;
	    }

}
//iterative
class Solution_589{
	public List<Integer> preorder(N_node root) {
		if(root==null) return null;
		List<Integer> ans=new ArrayList<>();
		Stack<N_node> stack=new Stack<>();
		N_node curNode=null;
		stack.push(root);
		while(!stack.isEmpty()){
			curNode=stack.pop();
			ans.add(curNode.val);
			for(int i=curNode.children.size()-1;i>=0;i--){
				if(curNode.children.get(i)!=null)
					stack.push(curNode.children.get(i));

			}
		}
		
		return ans;
	}
	
}
