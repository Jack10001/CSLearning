package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**Given a binary tree, return all root-to-leaf paths.
   Note: A leaf is a node with no children.
*/


/**
 * class Solution:
    def binaryTreePaths(self, root: TreeNode) -> List[str]:
        res=[]
        stack=[(root,"")]
        if not root:
            return []
        while stack:
            node,strr=stack.pop()
            if not node.right and not node.left:
                res.append(strr+str(node.val))
            if node.left:
                stack.append((node.left,strr+str(node.val)+"->"))
            if node.right:
                stack.append((node.right,strr+str(node.val)+"->"))
        return res
 * */
public class BinaryTreePaths_257 {
	 public List<String> binaryTreePaths(TreeNode root) {
		 class Element{
			 TreeNode treeNode;
			 String strr;
			 
			 public Element(TreeNode treeNode,String strr) {
				 this.strr=strr;
				 this.treeNode=treeNode;
			 }
			 public TreeNode get_treenode() {
				 return this.treeNode;
			 }
			 public String get_strr() {
				 return this.strr;
			 }
			 
		 } 
		 
		 
		 List<Element> stack=new LinkedList<>();
		 LinkedList<String> result;
		 Element element=new Element(root, "");
		 stack.add(element);
		 while(!stack.isEmpty()) {
			  element=stack.get(stack.size()-1);
			  TreeNode treeNode=element.get_treenode();
			  String strr=element.get_strr();
			  if(treeNode.left==null && treeNode.right==null)
				  result.add(strr+"->"+Integer.toString(treeNode.val));
			  if(treeNode.left)
			 
		 }
	        
	    }

}
