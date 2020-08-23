package tree;
/**
 * �����⣺124,543
 * */
public class LongestUnivaluePath_687 {
	public int longestUnivaluePath(TreeNode root) {
	        
	    }

}
class Solution_687{
	public int longestUnivaluePath(TreeNode root) {
		if (root == null) {//0.��ֹ����
			return 0;
		}
		//ʹ�������ԭ���ǣ�ʹ�����ô��ݶ�����ֵ����
		int[] result = new int[1];//1.������¼����ı�������Ϊ��������������ʱ������ǰ�ж���һ���Ԫ�أ�Ҳ����˵ �����ڵ� 4->null = 0��������1.
		longestUnivaluePathHelper(root, result);
		return result[0];//2.���ؽ����
	}
	
	public int longestUnivaluePathHelper(TreeNode root, int[] result) {
		if (root == null) {//3.��ֹ����
			return 0;
		}
	   
		int lPath = longestUnivaluePathHelper(root.left, result);//4.����ߵ�·������
		int rPath = longestUnivaluePathHelper(root.right, result);//5.���ұߵ�·������
		int arrowLeft = 0, arrowRight = 0;//8.����Ĭ��Ϊ0��·�����ȣ�
		if (root.left != null && root.left.val == root.val) {//6.�����ǰ�������ڵ���������������·��+1Ϊ������������0�ˡ��������������·���ͶϿ��ˡ�
			arrowLeft = lPath + 1;//������ֱ�������·���ĳ���+1
			//Ϊʲô��ʹ��lPath=lPath+1��ԭ����Ǳ���������·���Ͽ�
		}
		if (root.right != null && root.right.val == root.val) {//7.ͬ6��˵��
			arrowRight = rPath + 1;
		}
		
		//������������ж������������㣬˵��·���Ѿ��Ͽ�����Ҫ���½���Ѱ�ң���arrowLeft=0, arrowRight=0,���¿�ʼѰ�ң��������ټ���ʹ��lPath��rPath
		//��˵����ߵ�·���Ѿ��Ͽ������ڵ������ĵ���·��ֵ���� *
		result[0] = Math.max(result[0], arrowLeft + arrowRight);//10.���³��ȡ�
		return Math.max(arrowLeft, arrowRight);//9.����һ���·�����ϲ㣬�����ϲ�Ԫ�ز�����������������ģ������㵽���ж೤�ľ��롣
	}
}