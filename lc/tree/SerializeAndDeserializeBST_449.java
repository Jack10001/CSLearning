package tree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBST_449 {

}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */ 
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	if(root==null) return null;
    	Queue<TreeNode> queue=new LinkedList<>();
    	int size=-1;
    	queue.add(root);
    	StringBuilder sb=new StringBuilder();
    	TreeNode node=null;
    	while(!queue.isEmpty()) {
    		size=queue.size();
    		while(size>0) {
    			node=queue.remove();
    			if(node==null) {
    				sb.append("null"+",");
    				continue;
    			}
    			sb.append(node.val+",");
    			queue.add(node.left);
    			queue.add(node.right);
    			size--;
    		}
    	}
    	
        return sb.toString();
    }

    
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) { 
        if(data == null || data.length() == 0) return null;
       
        String[] nodes = data.split(",");
        if(nodes[0].equals("null")) return null;
        
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
        queue.add(root);
        int index = 1;
        
        while(!queue.isEmpty()){
            TreeNode currentNode = queue.remove();
            // retrieve next two nodes from the string array and add those as current node left and right node
            TreeNode leftNode = !nodes[index].equals("null") ? new TreeNode(Integer.valueOf(nodes[index])) : null;
            index++;
            TreeNode rightNode = !nodes[index].equals("null") ? new TreeNode(Integer.valueOf(nodes[index])) : null;
            index++;
            
            currentNode.left = leftNode;
            currentNode.right = rightNode;
			// add left, right node to the queue only if they are not null
            if(leftNode != null)
                queue.add(leftNode);
            if(rightNode != null)
                queue.add(rightNode);
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));