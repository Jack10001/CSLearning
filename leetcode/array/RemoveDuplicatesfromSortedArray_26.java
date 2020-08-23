package array;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesfromSortedArray_26 {
	 public int removeDuplicates(int[] nums) {
		 //把nums放入set中，再将set转换为数组
		 Set<Integer> numsSet=new HashSet<>();
		 for(int i=0;i<nums.length;i++)
			 numsSet.add(nums[i]);
	     return numsSet.size();
	     
	    }
	 public int removeDuplicates1(int[] nums) {
		 
	 }
}
