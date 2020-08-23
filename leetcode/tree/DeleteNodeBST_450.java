package tree;
/**
 BST节点的删除分为几种情况：
（a）当该节点为叶子节点，则让该节点的父节点指向其变为NULL，然后释放节点；
（b）当该节点不是叶子节点，但左子树或者右子树为空，则：
        （1）若左子树为空，则让该节点父节点指向其右节点；
        （2）若右子树为空，则让该节点父节点指向其左节点。
（c）当该节点不是叶子节点，且左子树和右子树都不为空，则：
        （1）在该节点的左子树中找到最大节点Lmax（该节点必然是一个叶子节点），取出Lmax的值val，删除Lmax；
        （2）将 val 赋给该节点的值，即：root->val = val。
		（3）判断Lmax的父节点PreLmax的左节点是否等于Lmax，若是则：PreLmax->left = Lmax->left   
		 否则：  PreLmax->right = Lmax->left。
 */
public class DeleteNodeBST_450 {
	public TreeNode deleteNode(TreeNode root, int key) {
	        
	    }

}


class Solution_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        
        if (root.val == key)
			root = edit(root);
			


        else if (root.val > key)//节点值大于key,在左子树中寻找
            root.left = deleteNode(root.left, key);
        else
            root.right = deleteNode(root.right, key);
		
			


        return root;
    }
    
    public TreeNode edit(TreeNode root) {
        if (root.left != null) {
            TreeNode savedRight = root.right;
            root = root.left;
            
            // iterate through to add onto the end of the node!
            TreeNode tmp = root;
            while (tmp.right != null) {
                tmp = tmp.right;
            }
            tmp.right = savedRight; // attach onto the rightmost position!

        } else if (root.right != null) {
            root = root.right; // no left nodes exist, so don't bother adding the left side!
            
        } else {
            root = null; // no children to replace!
        }
        
        return root;
	}
	


	public TreeNode deleteNode1(TreeNode cur, int key) {
		if(cur == null){
			return null;
		}
		//1.右子树递归
		if(key > cur.val){
			cur.right = deleteNode(cur.right, key);
	    //2.左子树递归
		}else if(key < cur.val){
			cur.left = deleteNode(cur.left, key);
		//3.对于当前节点，分为四种情况
		}else{
			//3.1 左右节点都不存在
			if(cur.left == null && cur.right == null){
				return null;
			//3.2 只有左孩子，没有右孩子
			}else if(cur.left != null && cur.right == null){
				return cur.left;
			//3.3 只有右孩子，没有左孩子
			}else if(cur.right != null && cur.left == null){
				return cur.right;
			//3.4 左右孩子均存在
			}else{  
				TreeNode pre = null;
				TreeNode desc = cur.right;
				
				while(desc.left != null){
					pre = desc;
					desc = desc.left;
				}
				
				if(pre != null){
					pre.left = desc.right;
					desc.right = cur.right;
				}
				
				desc.left = cur.left;
				cur = desc;   
			}
		}
			
		return cur;    
	}
}