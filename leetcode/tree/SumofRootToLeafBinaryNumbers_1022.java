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
		 * ��Ȩչ����
		 */
		private double BinToTen(String binary) {
			//���Ҹö������Ƿ����С����
			int index = binary.indexOf('.');
			//ת���ɵ�ʮ����
			double ten = 0;
			//��������
			double integer = 0;
			//С������
			double decimal = 0;
			//index����-1��˵��û��С������
			if(index == -1) {
				for(int i = 0; i < binary.length(); i++) {
					//48Ϊ�ַ�'0'��Ӧ��ASCIIֵ��
					//ten += (binary.charAt(i) - 48) * Math.pow(2, -(i-(binary.length() - 1)));
					//���߿��Խ��ַ�ת��Ϊ�ַ����������ַ���ת��Ϊ����
					ten += Integer.parseInt(String.valueOf(binary.charAt(i))) * Math.pow(2, -(i-(binary.length() - 1)));
				}
			} else {
				//������������
				for(int i = 0; i < index; i++) {
					integer += Integer.parseInt(String.valueOf(binary.charAt(i))) * Math.pow(2, -(i-(index - 1)));
				}
				//����С������
				for(int j = index + 1; j < binary.length(); j++) {
					decimal += Integer.parseInt(String.valueOf(binary.charAt(j))) * Math.pow(2, (index - j));
				}
				ten = integer + decimal;
			}
			return ten;
			
		}


}
