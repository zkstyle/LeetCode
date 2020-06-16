package tree.treenode;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: tree.treenode
 * @Author: elvis
 * @CreateTime: 2020-06-16 13:20
 * @Description: node节点类
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
