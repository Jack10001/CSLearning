package tree;

import java.util.List;

public class N_node {
    public int val;
    public List<N_node> children;

    public N_node() {}

    public N_node(int _val) {
        val = _val;
    }

    public N_node(int _val, List<N_node> _children) {
        val = _val;
        children = _children;
    }
};