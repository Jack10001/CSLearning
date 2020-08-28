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
 public class Solution {
    public int mySqrt(int x) {
        if (x <= 1) return x;

        int left = 1, right = x/2;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(mid > x/mid) {
                right = mid - 1;
            }
            else {
                if((mid + 1) > x/(mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
        return 0;
    }
}
```
2.**牛顿法**

如图：

![image may be lost](https://github.com/Jack10001/CSLearning/blob/master/leetcode/images/newton.png)
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

