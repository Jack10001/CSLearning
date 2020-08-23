package tree;

import java.util.ArrayList;
import java.util.List;

public class SumRoottoLeafNumbers_129 {
	//preorder遍历
	public int sumNumbers(TreeNode root) {
	        //保存root-->left的所有路径
		if(root==null) return 0;
		List<List<Integer>> res=new ArrayList<>();
		List<Integer> tmp=new ArrayList<>();
 		helper(root,res,tmp);
		
 		int sum=0,listSum=0,rela=0;
		for(List<Integer> list:res) {
			listSum=0;
			rela=relation(list.size());
			for(Integer num:list){
				listSum=listSum+(num*rela);
				rela=rela/10;
			}
			sum+=listSum; 
		}
 		return sum;
	    }
	private void helper(TreeNode root,List<List<Integer>> res,List<Integer> tmp) {
		//N
		if(root==null) return;
		tmp.add(root.val);
		//L
		helper(root.left, res,tmp);
		//R
		helper(root.right, res,tmp);
		
		//判断是否到达根节点
		if(root.left==null && root.right==null) {
			res.add(new ArrayList<>(tmp));
		}
		tmp.remove(tmp.size() - 1);
		
	}
	private int relation(int size) {
		int res=1;
		for(int i=0;i<size-1;i++) {
			res=res*10;
		}
		return res;
		
	}

}

class Solution_129{
	int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null) return sum;        
        sumNumbersUtility(root, 0);
        return sum;
    }
    
    public void sumNumbersUtility(TreeNode root, int rootToLeafValue){
        //N
    	if(root == null) return;
        
        rootToLeafValue = (rootToLeafValue * 10) + root.val;        
        if(root.left == null && root.right == null){
            sum += rootToLeafValue;
        }
        //L
        sumNumbersUtility(root.left, rootToLeafValue);
        //R
        sumNumbersUtility(root.right, rootToLeafValue);        
    }
}
