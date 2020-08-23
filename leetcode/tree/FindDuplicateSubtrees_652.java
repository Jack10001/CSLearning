package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class FindDuplicateSubtrees_652 {
	 public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
	        
	    }

}


class Solution_652 {
    private static class Type {
        final Integer leftTypeId;
        final Integer rightTypeId;
        final Integer root;
        
        Type(Integer leftTypeId, Integer rightTypeId, int root) {
            this.leftTypeId = leftTypeId;
            this.rightTypeId = rightTypeId;
            this.root = root;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(leftTypeId, rightTypeId, root);
        }
        
        @Override
        public boolean equals(Object other) {
            if (other == null) return false;
            if (!(other instanceof Type)) return false;
            Type otherType = (Type) other;
            
            return Objects.equals(this.leftTypeId, otherType.leftTypeId) &&
                Objects.equals(this.rightTypeId, otherType.rightTypeId) &&
                Objects.equals(this.root, otherType.root);
        }
    }
    
    private final Map<Type, Integer> types = new HashMap<>();
    private final Map<Integer, Integer> seen = new HashMap<>();
    
    private final List<TreeNode> ans = new ArrayList<>();
    private int typeCount = 0;
    
    private Integer dups(TreeNode root) {
        if (root == null) return null;
        
        final Integer left = dups(root.left);
        final Integer right = dups(root.right);
        
        final Type currType = new Type(left, right, root.val);
        
        int currTypeId = -1;
        if (!types.containsKey(currType)) {
            types.put(currType, typeCount);
            currTypeId = typeCount;
            typeCount++;
        } else {
            currTypeId = types.get(currType);
        }
        
        if (seen.getOrDefault(currTypeId, 0) == 1) {
            ans.add(root);
        }
        seen.put(currTypeId, seen.getOrDefault(currTypeId, 0) + 1);
        
        return currTypeId;
    }
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dups(root);
        return ans;    
    }
}