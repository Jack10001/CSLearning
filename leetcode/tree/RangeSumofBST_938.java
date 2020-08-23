package tree;


public class RangeSumofBST_938 {
	 private int sum=0;
	 public int rangeSumBST(TreeNode root, int L, int R) {
		 //N
		 if(root!=null) {
			 if(root.val>=L && root.val <= R)
				 sum=sum+root.val;
		 //L
		 rangeSumBST(root.left,L,R);
		 //R
		 rangeSumBST(root.right,L,R);
		 }
		 return sum;
	    }

}
