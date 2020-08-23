package tree;


public class MaximumBinaryTree_654 {
	//pre-i-1
	//i
	//i+1--end 
	//确定pre和end方式另外开辟一个和nums一样大的数组，如果元素已经被使用了，则对应位为1，否则为0
	 public TreeNode constructMaximumBinaryTree(int[] nums) {
		Boolean[] bool=new Boolean[nums.length];
		for(int i=0;i<bool.length;i++) {
			bool[i]=false;
		}
		
		return helper(nums,bool,0,nums.length-1);
	        
	    }
	 private TreeNode helper(int[] nums,Boolean[] bool,int pre,int end) {
		 if(pre>end ) return null;
		 int cur=findMax(nums,pre,end);
		 bool[cur]=true;
		 TreeNode root=new TreeNode(nums[cur]);
		 
//		 pre=findPre(nums, bool, cur);
//		 end=findEnd(nums, bool, cur);
		 
		 root.left=helper(nums, bool, pre, cur-1);
		 root.right=helper(nums, bool, cur+1, end);
		 return root;
		 
	 }
	 
	 private int findMax(int[] nums,int start,int end) {
		 int temp=start;
		 for(int i=start;i<=end;i++) {
			 if(nums[i]>nums[temp])
				 temp=i;
		 }
		 return temp;
	 }
	 
	 private int findPre(int[] nums,Boolean[] bool,int cur) {
		 int i=cur-1;
		 while(i>0) {
			 if(bool[i]==true) break;
			 i--;
		 }
		 if(i==0) return i;
		 else return i+1;
		 
	 }
	 
	 private int findEnd(int[] nums,Boolean[] bool,int cur) {
		 int i=cur+1;
		 while(i<nums.length) {
			 if(bool[i]==true)
			 i++;
		 }
		 if(i==nums.length) return i;
		 else return i-1;
		 
	 }
	 

}


class Solution_654{
	
	private int findIndexOfMaxInArray(int[] numbers, int from, int to) {
	    int maxIndex = from;
	    for (int i = from; i < to; i++) {
	        if (numbers[maxIndex] < numbers[i]) {
	            maxIndex = i;
	        }
	    }
	    return maxIndex;
	}

	private TreeNode constructMaximumBinaryTree(int[] nums, int from, int to) {
	    if (to - from > 0) {
	        int maxIndex = findIndexOfMaxInArray(nums, from, to);
	        TreeNode head = new TreeNode(nums[maxIndex]);
	        head.left = constructMaximumBinaryTree(nums, from, maxIndex);
	        head.right = constructMaximumBinaryTree(nums, maxIndex + 1, to);

	        return head;
	    }

	    return null;
	}

	public TreeNode constructMaximumBinaryTree(int[] nums) {
	    if (nums != null) {
	        return constructMaximumBinaryTree(nums, 0, nums.length);
	    }
	    return null;
	}
}
