package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class N_aryTreePostorderTraversal_590 {
	private List<Integer> ans=new ArrayList<Integer>();
	public List<Integer> postorder(N_node root) {
		 //for each node(except root node),they have a parent node and many children node
		 if(root!=null) {
			 //N L R
			 for(int i=0;i<root.children.size();i++)
				 postorder(root.children.get(i));
			 ans.add(root.val);
		 }
	       return ans;
	        
	    }

}

class Solition_590{
	public List<Integer> postorder(N_node root) {
		
	}
}

class Solution_ {
    public List<Integer> postorder(N_node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<N_node> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.empty()){
            N_node parent = stack.pop();
            if (parent.children.size() != 0){
                for(int i = parent.children.size() - 1; i >= 0; i--){
                    stack.push(parent.children.remove(i));
                }
            } else {
                res.add(stack.pop().val);
            }
        }
        return res;
    }
}