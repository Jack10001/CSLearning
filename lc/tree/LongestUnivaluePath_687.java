package tree;
/**
 * 类似题：124,543
 * */
public class LongestUnivaluePath_687 {
	public int longestUnivaluePath(TreeNode root) {
	        
	    }

}
class Solution_687{
	public int longestUnivaluePath(TreeNode root) {
		if (root == null) {//0.终止条件
			return 0;
		}
		//使用数组的原因是，使用引用传递而不是值传递
		int[] result = new int[1];//1.创建记录结果的变量，因为这里我们在求解的时候是提前判断下一层的元素，也就是说 最左侧节点 4->null = 0，而不是1.
		longestUnivaluePathHelper(root, result);
		return result[0];//2.返回结果。
	}
	
	public int longestUnivaluePathHelper(TreeNode root, int[] result) {
		if (root == null) {//3.终止条件
			return 0;
		}
	   
		int lPath = longestUnivaluePathHelper(root.left, result);//4.求左边的路径长度
		int rPath = longestUnivaluePathHelper(root.right, result);//5.求右边的路径长度
		int arrowLeft = 0, arrowRight = 0;//8.设置默认为0的路径长度，
		if (root.left != null && root.left.val == root.val) {//6.如果当前结点的左侧节点符合条件，则左侧路径+1为结果，否则就是0了。你可以理解成这条路径就断开了。
			arrowLeft = lPath + 1;//？？？直接用左边路径的长度+1
			//为什么不使用lPath=lPath+1的原因就是遍历过程中路径断开
		}
		if (root.right != null && root.right.val == root.val) {//7.同6的说法
			arrowRight = rPath + 1;
		}
		
		//如果上述两个判断条件都不满足，说明路径已经断开，则要重新进行寻找，即arrowLeft=0, arrowRight=0,重新开始寻找，而不是再继续使用lPath和rPath
		//就说明左边的路径已经断开，本节点的左方向的单向路径值清零 *
		result[0] = Math.max(result[0], arrowLeft + arrowRight);//10.更新长度。
		return Math.max(arrowLeft, arrowRight);//9.返回一个最长路径到上层，对于上层元素并不关心你从哪里来的，而是你到底有多长的距离。
	}
}