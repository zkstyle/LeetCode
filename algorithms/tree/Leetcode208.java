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

    static class Trie {

        private Node head = new Node();

        /** Initialize your data structure here. */
        public Trie() {

        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            this.goTo(word, true).isWord = true;
        }

        private Node goTo(String s, boolean createdIfNotExisted) {
            Node cur = head;
            for (int i = 0, c; cur != null && i < s.length(); i++) {
                c = s.charAt(i) - 'a';
                if (createdIfNotExisted && cur.children[c] == null) {
                    cur.children[c] = new Node();
                }
                cur = cur.children[c];
            }
            return cur;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Node result = this.goTo(word, false);
            return result != null && result.isWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            return this.goTo(prefix, false) != null;
        }
    }

    static class Node {
        boolean isWord = false;
        Node children[] = new Node[26];
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        trie.search("apple");   // 返回 true
        trie.search("app");     // 返回 false
        trie.startsWith("app"); // 返回 true
        trie.insert("app");
        trie.search("app");     // 返回 true

    }

}
