## leetcode 69 题解

### 题目
```java
Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

```

### 解法
1.**二分查找法**
```Java
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
```
2.**牛顿法**

如图：
![牛顿法](./leetcode/images/newton.png)
```Java
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
```

