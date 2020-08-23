package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class LeafSimilarTrees_87 {
	
	 public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		 if(root1==null || root2==null) return false;
		 List<Integer> ls1=new ArrayList<>();
		 List<Integer> ls2=new ArrayList<>();
		 getLeftSequence(root1, ls1);
		 getLeftSequence(root2, ls2);
		 return ls1.retainAll(ls2) && ls2.retainAll(ls1);
		 
	        
	    }
	 private void getLeftSequence(TreeNode root,List<Integer> ls1){
		 if(root==null) return;
		 //N L R 
		 if(root.left==null && root.right==null) {
			 ls1.add(root.val);
		 }
		 getLeftSequence(root.left,ls1);
		 getLeftSequence(root.right,ls1);
		
		 
	 }

}

public class MainClass {
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }
    
        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
    
        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
    
            if (index == parts.length) {
                break;
            }
    
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }
    
            if (index == parts.length) {
                break;
            }
    
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);
            
            int ret = new LeafSimilarTrees_87().sumRootToLeaf(root);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}