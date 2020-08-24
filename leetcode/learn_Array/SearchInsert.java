package learn_Array;

public class SearchInsert {
	 public static int searchInsert(int[] nums, int target) {
		 //¶þ·Ö·¨
		 int mid=-1;
		 int low=0;
		 int high=nums.length-1;
		 while(low<=high) {
			 mid=(int)Math.floor((low+high)/2);
			 if(target==nums[mid]) {
				 return mid;
			 }
			 else if(target<nums[mid]) {
				 high=mid-1;
			 }else {
				 low=mid+1;
				 
			 }
			 
		 }
		 	return low;
	    }
	 public static void main(String[] args) {
		int[] nums= {1,3,5,6};
		System.out.println(searchInsert(nums,7));
	}

}
