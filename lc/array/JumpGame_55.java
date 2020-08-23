package array;

public class JumpGame_55 {
	 public boolean canJump(int[] nums) {
		 /*
		  * 对于每一个可以到达的位置 x，它使得 x+1, x+2, \cdots, x+\textit{nums}[x]x+1,x+2,⋯,x+nums[x] 这些连续的位置都可以到达。
			这样以来，我们依次遍历数组中的每一个位置，并实时维护 最远可以到达的位置。对于当前遍历到的位置 xx，如果它在 最远可以到达的位置 的范围内，
			那么我们就可以从起点通过若干次跳跃到达该位置，因此我们可以用 x + \textit{nums}[x]x+nums[x] 更新 最远可以到达的位置。*/
		 if(nums.length<=1) return true;
		 int size=nums.length;
		 int reachable=0;
		 for(int i=0;i<size;i++) {
			 if(i>reachable) return false;
			 reachable=Math.max(reachable, nums[i]+i); 
		 }
		 return true;
	        
	    }
}

//回溯，动态规划，贪心算法

//动态规划
class Solution_55 {
    public boolean canJump(int[] nums) {
        if(nums.length <= 1) return true;
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++)
            dp[i] = dp[i-1] == 0 ? 0 : Math.max(dp[i-1]-1, nums[i]);
        
        return dp[nums.length-2] == 0 ? false : true;
    }
}



//贪心算法
class Solution_55_ {
    public boolean canJump(int[] nums) {
        int reachable = 0;
        int len = nums.length;
        for(int i = 0; i<len ; i++){
           if(i > reachable) return false;
           reachable = Math.max(reachable,nums[i]+i);
        }
     return true;       
    }
}