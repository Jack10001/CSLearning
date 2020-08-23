package tree;

import java.util.LinkedList;
import java.util.List;

public class UniqueSearchTrees_1_96 {
	public int numTrees(int n) {
		
	}
}

//¶¯Ì¬¹æ»®
class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            int trees = 0;
            for(int j = 0; j < i; j++) {
                trees += dp[j] * dp[i - j - 1];
            }
            dp[i] = trees;
        }
        
        return dp[n];
    }
}
