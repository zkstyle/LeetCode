package tree;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: tree
 * @Author: elvis
 * @CreateTime: 2020-06-28 21:24
 * @Description: 前缀树
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 *
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 */
public class Leetcode208 {

    class Node {
        boolean terminal;
        Node[] alphabet;

        public Node() {
            terminal = false;
            alphabet = new Node[26];
        }

        public Node add(int index) {
            if (!exist(index)) {
                alphabet[index] = new Node();
            }
            return alphabet[index];
        }

        public boolean exist(int index) {
            return alphabet[index] != null;
        }

        public Node get(int index) {
            return alphabet[index];
        }

        public void terminal() {
            terminal = true;
        }

        public boolean isTerminal() {
            return terminal;
        }
    }

    class Trie {
        private Node root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new Node();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Node ite = root;
            for (int i = 0; i < word.length(); i++) {
                int pos = getPosition(word, i);
                ite = ite.add(pos);
            }
            ite.terminal();
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Node ite = root;
            for (int i = 0; i < word.length(); i++) {
                int pos = getPosition(word, i);
                if (!ite.exist(pos)) {
                    return false;
                }
                ite = ite.get(pos);
            }
            return ite.isTerminal();
        }

        private int getPosition(String word, int wordPos) {
            return word.charAt(wordPos) - 'a';
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Node ite = root;
            for (int i = 0; i < prefix.length(); i++) {
                int pos = getPosition(prefix, i);
                if (!ite.exist(pos)) {
                    return false;
                }
                ite = ite.get(pos);
            }
            return true;
        }
    }

}
