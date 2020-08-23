package tree;

import java.util.ArrayList;
import java.util.List;
/**
 * @author mxb14
 * @version 1.0.0
 * @apiNote done*/
public class SumofRootToLeafBinaryNumbers_1022 {
	  private List<String> res=new ArrayList<String>();
	  private StringBuilder tmpBuilde=new StringBuilder();
	  private int sum=0;
	  public int sumRootToLeaf(TreeNode root) {
		  if(root==null) return 0;
		  helper(root);
		  for(String str:res) {
			  sum=sum+(int)BinToTen(str);
		  }
		  return sum;
		  
	    }
	  private void helper(TreeNode root) {
		  if(root==null) return;
		  //N
		  tmpBuilde.append(root.val);
		  //L
		  helper(root.left);
		  //R
		  helper(root.right);
		  //reach leaf node
		  if(root.left==null && root.right==null) {
			  res.add(tmpBuilde.toString());
		  }
		  tmpBuilde.deleteCharAt(tmpBuilde.length()-1);
		  
	  }
	  /*
		 * 按权展开法
		 */
		private double BinToTen(String binary) {
			//查找该二进制是否存在小数点
			int index = binary.indexOf('.');
			//转化成的十进制
			double ten = 0;
			//整数部分
			double integer = 0;
			//小数部分
			double decimal = 0;
			//index等于-1，说明没有小数部分
			if(index == -1) {
				for(int i = 0; i < binary.length(); i++) {
					//48为字符'0'对应的ASCII值；
					//ten += (binary.charAt(i) - 48) * Math.pow(2, -(i-(binary.length() - 1)));
					//或者可以将字符转化为字符串，再由字符串转化为数字
					ten += Integer.parseInt(String.valueOf(binary.charAt(i))) * Math.pow(2, -(i-(binary.length() - 1)));
				}
			} else {
				//计算整数部分
				for(int i = 0; i < index; i++) {
					integer += Integer.parseInt(String.valueOf(binary.charAt(i))) * Math.pow(2, -(i-(index - 1)));
				}
				//计算小数部分
				for(int j = index + 1; j < binary.length(); j++) {
					decimal += Integer.parseInt(String.valueOf(binary.charAt(j))) * Math.pow(2, (index - j));
				}
				ten = integer + decimal;
			}
			return ten;
			
		}


}
