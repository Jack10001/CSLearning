package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class N_aryTreeLevelOrderTraversal_429 {
    public List<List<Integer>> levelOrder(N_node root) {
        //对n叉树进行层序遍历
        List<List<Integer>> ans=new ArrayList<>();
       // List<Integer> tmp=new ArrayList<>();
        Queue<N_node> queue=new LinkedList<>();
        if(root==null) return ans;
        queue.add(root);
        N_node curNode=null;
        int size=0;
        while(!queue.isEmpty()){
            size=queue.size();
            List<Integer> tmp=new ArrayList<>();
            for(int i=0;i<size;i++){
                curNode=queue.remove();
                tmp.add(curNode.val);
                // if(curNode.children.size()!=0){
                //     for(int j=0;j<curNode.children.size();j++)
                //         queue.add(curNode.children.get(j));
                // }
                if(curNode.children.size()!=0)
                    queue.addAll(curNode.children);
            }
            ans.add(tmp);
        }
        return ans;
    }
    
}