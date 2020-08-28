package binary_search;

public class BinarySearch_704 {
	 public int search(int[] nums, int target) {
		 //二分查找的前提：数组有序
		 if(nums==null || nums.length==0) return -1;
		 int low=0,high=nums.length-1;
		 int mid=-1;
		 while(low<=high) {
			 mid=low+(high-low)/2;
			 if(nums[mid]==target)
				 return mid;
			 if(nums[mid]<target)
				 low=mid+1;
			 else 
				 high=mid-1;
		 }
		 return -1;
	        
	    }

}
