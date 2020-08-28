package binary_search;

public class Sqrt_69 {
	  public int mySqrt(int x) {
		  return (int)Math.sqrt(x);
	        
	    }

}

//binary search
class Solution_69 {
    public int mySqrt(int x) {
        if(x < 2) return x;
        int l = 0, r = x;
        while(l < r) {
            int mid = l + (r - l) / 2 + 1;
            if(Math.pow(mid, 2) > x) r = mid - 1;
            else l = mid;
        }
        return l;
    }
}

//newton method
class Solution_69_{
	public class Solution {
	    public int mySqrt(int x) {
	        if (x <= 1) return x;

	        double last = 0, res = 1;
	        while(last != res) {
	            last = res;
	            res = (res + x/res)/2;
	        }
	        return (int)res;
	    }
	}
}