package dp;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs_70 {
	 public int climbStairs(int n) {
	        
	    }

}

class Solution_70 {
    Map<Integer,Integer> maps=new HashMap<>();
    public int climbStairs(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 2;
        if(maps.containsKey(n)) return maps.get(n);
        else{
            int value=climbStairs(n-1)+climbStairs(n-2);
            maps.put(n,value);
            return value;
        }
        
    }
}