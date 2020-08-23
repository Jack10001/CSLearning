package tree;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees_872 {
	/*
	 * 1.得到root1和root2的叶子结点序列
	 * 2.比较两个序列是否完全相等*/
	
	 public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		 if(root1==null || root2==null) return false;
		 List<Integer> ls1=new ArrayList<>();
		 List<Integer> ls2=new ArrayList<>();
		 getLeftSequence(root1, ls1);
		 getLeftSequence(root2, ls2);
		 return listEquals(ls1, ls2);
		 
	        
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
	 private boolean listEquals(List<Integer> ls1,List<Integer> ls2) {
		 if(ls1==null || ls2==null) return false;
		 if(ls1.size() !=ls2.size()) return false;
		 for(int i=0;i<ls1.size();i++) {
			 if(!(ls1.get(i).equals(ls2.get(i)))) return false; 
		 }
		 return  true;
	 }

}
