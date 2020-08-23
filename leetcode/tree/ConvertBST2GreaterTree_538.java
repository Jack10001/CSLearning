package tree;

import java.util.ArrayList;

import java.util.List;



public class ConvertBST2GreaterTree_538 {
	  private List<Integer> ans=new ArrayList<>();
	  public TreeNode convertBST(TreeNode root) {
		  getList(root);
		  convert2GT(root);
		  return root;
	        
	    }
	  private void getList(TreeNode root) {
		  if(root!=null) {
			  //BST inorder is sorted
			  getList(root.left);
			  ans.add(root.val);
			  getList(root.right);
		  }
		  
	  }
	  private void convert2GT(TreeNode root) {
		  if(root!=null) {
			  //N L R
			  int index=ans.indexOf(root.val);
			  int sum=0;
			  for(int i=index;i<ans.size();i++) {
				  sum+=ans.get(i);
			  }
			  root.val=sum;
			  convert2GT(root.left);
			  convert2GT(root.right);
		  }
	  }

}
class Solution_538 {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root !=  null){
            convertBST(root.right); //go till end of right subtree to find max val
            sum += root.val;   //update the sum (Accumulative)
            root.val = sum;    //update recent node's val to sum 
            convertBST(root.left); //go in left subtree to update the sum
        }
        return root;
    }
}
