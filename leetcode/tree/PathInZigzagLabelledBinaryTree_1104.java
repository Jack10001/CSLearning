package tree;

public class PathInZigzagLabelledBinaryTree_1104{
    public List<Integer> pathInZigZagTree(int label) {
        int level = 0;
        int pow = 1;
        //求出label所在层
        while (pow <=label) {
            pow = pow + (int)Math.pow(2, level);
            level++;
        }
    
        List<Integer> list = new ArrayList<>();
    
        while (label>=1) {
            list.add(label);
            label = (int) Math.pow(2, level-2) + ((int)Math.pow(2, level) - 1 - label)/2;
            level--;
        }
        Collections.sort(list);
        return list;
    }
}