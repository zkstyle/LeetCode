package tree.binary_search_tree;

import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: tree.binary_search_tree
 * @Author: elvis
 * @CreateTime: 2020-06-20 15:40
 * @Description:　多叉树
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
