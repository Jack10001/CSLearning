package tree;

public class  ConstructStringfromBinaryTree_606{
    public String tree2str(TreeNode t) {
        
    }
}



class Solution_606 {
    //四种情况
    /*
    1.如果当前节点有两个孩子，那我们在递归时，需要在两个孩子的结果外都加上一层括号；
    2.如果当前节点没有孩子，那我们不需要在节点后面加上任何括号；
    3.如果当前节点只有左孩子，那我们在递归时，只需要在左孩子的结果外加上一层括号，而不需要给右孩子加上任何括号；
    4.如果当前节点只有右孩子，那我们在递归时，需要先加上一层空的括号 () 表示左孩子为空，再对右孩子进行递归，并在结果外加上一层括号。
     */
    public String tree2str(TreeNode t) {
        if(t==null)
            return "";
        if(t.left==null && t.right==null)
            return t.val+"";
        //情况3
        if(t.right==null)
            return t.val+"("+tree2str(t.left)+")";
        //情况4
        return t.val+"("+tree2str(t.left)+")("+tree2str(t.right)+")";   
    }
}

class Solution_606_1 {
    public String tree2str(TreeNode t) {
        if (t == null) 
            return "";
        TreeNode dummy = new TreeNode(0);
        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> s = new ArrayDeque<>();
        s.push(t);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            if (node == dummy) {
                sb.append(')');
                continue;
            }
            sb.append('(').append(node.val);
            s.push(dummy);
            if (node.left == null && node.right != null)
                sb.append("()");
            if (node.right != null) 
                s.push(node.right);
            if (node.left != null) 
                s.push(node.left);
        }
        return sb.substring(1, sb.length() - 1);
    }
}


class Solution_606_2 {
    public String tree2str(TreeNode t) {
        if (t == null)
            return "";
        Stack < TreeNode > stack = new Stack < > ();
        stack.push(t);
        Set < TreeNode > visited = new HashSet < > ();
        StringBuilder s = new StringBuilder();
        while (!stack.isEmpty()) {
            t = stack.peek();
            if (visited.contains(t)) {
                stack.pop();
                s.append(")");
            } else {
                visited.add(t);
                s.append("(" + t.val);
                if (t.left == null && t.right != null)
                    s.append("()");
                if (t.right != null)
                    stack.push(t.right);
                if (t.left != null)
                    stack.push(t.left);
            }
        }
        return s.substring(1, s.length() - 1);
        //return s.toString();
    }
}


class Solution_606_3{
    public String tree2str(TreeNode t) {
        //1.左右子树为空；2.左右子树都不为空 3.左子树为空，右子树不为空 4.右子树为空，左子树不为空
        if(t==null) return "";
        if(t.left==null && t.right==null) return t.val+"";
        if(t.left==null) return t.val+"()"+"("+tree2str(t.right)+")";
        if(t.right==null) return t.val+"("+tree2str(t.left)+")";
        return t.val+"("+tree2str(t.left)+")("+tree2str(t.right)+")";
    }

}