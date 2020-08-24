package learn_Array;

public class Min_index {
	public static int pivotIndex(int[] nums) {
		int left_sum,right_sum;
		for(int i=0;i<nums.length;++i) {
			left_sum=0;
			right_sum=0;
			for(int left=0;left<i;++left) {
				left_sum+=nums[left];
			}
			for(int right=i+1;right<nums.length;++right) {
				right_sum+=nums[right];
			}
			if(left_sum==right_sum) return i;
		}
		return -1;

    }
	public static void main(String[] args) {
		int[] nums= {1, 2, 3};
		System.out.println(pivotIndex(nums));
	}

}
