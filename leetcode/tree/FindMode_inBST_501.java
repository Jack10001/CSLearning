package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

class FindMode_inBST_501 {
	 public int[] findMode(TreeNode root) {
	        if(root==null) return null;
		    Map<Integer, Integer> tmpMap=new HashMap<>();
	        Queue<TreeNode> queue=new LinkedList<>();
	        List<Integer> res=new ArrayList<>();
	        queue.add(root);
	        TreeNode curNode=null;
	        while(!queue.isEmpty()) {
	        	curNode=queue.poll();
	        	if(!tmpMap.containsKey(Integer.valueOf(curNode.val))) tmpMap.put(Integer.valueOf(curNode.val), Integer.valueOf(1));
	        	else {
	        		Integer valueInteger=tmpMap.get(Integer.valueOf(curNode.val));
	        		tmpMap.replace(Integer.valueOf(curNode.val),valueInteger++);
	        	}
	        	if(curNode.left!=null) queue.add(curNode.left);
	        	if(curNode.right!=null) queue.add(curNode.right);
	        	
	        }
	        int count=-1;
	        //找到最大数
	        Iterator<Entry<Integer, Integer>> iter1=tmpMap.entrySet().iterator();
	        while(iter1.hasNext()){
		        Map.Entry<Integer,Integer> entry=(Map.Entry<Integer,Integer>)iter1.next();
		        if(entry.getValue()>count) count=entry.getValue();
	        }
	        
	        Iterator<Entry<Integer, Integer>> iter2=tmpMap.entrySet().iterator();
	        while(iter2.hasNext()){
		        Map.Entry<Integer,Integer> entry=(Map.Entry<Integer,Integer>)iter2.next();
		        if(entry.getValue()==count) res.add(entry.getKey());
	        }
	        int[] d = new int[res.size()];
	        for(int i = 0;i<res.size();i++){
	            d[i] = res.get(i);
	        }
	        
	        return d;
	        
	    }

}


class Solution_501 {
    private Map<Integer, Integer> hashMap = new HashMap<>();
    private int max = 1;
    public int[] findMode(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        helper(root);
        int result[] = new int[hashMap.size()]; 
        int i = 0;
        for(Integer k: hashMap.keySet()){
            if(hashMap.get(k) == max)
                result[i++] = k;
        }
        return Arrays.copyOf(result, i);
    }
    
    private void helper(TreeNode root){
        if(root != null){
        	//N
            if(hashMap.containsKey(root.val)){
                int count = hashMap.get(root.val) + 1;
                hashMap.replace(root.val, hashMap.get(root.val) + 1);
                max = Math.max(max, count);//保存众数
            }
            else
                hashMap.put(root.val, 1);
            //L
            helper(root.left);
            //R
            helper(root.right);
        }
    }
}
