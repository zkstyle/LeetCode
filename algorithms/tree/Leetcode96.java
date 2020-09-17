package tree;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: tree
 * @Author: elvis
 * @CreateTime: 2020-08-13 21:45
 * @Description: xx
 */
public class Leetcode96 {

    /**
     * 算法
     *
     * 题目要求是计算不同二叉搜索树的个数。为此，我们可以定义两个函数：
     *
     * G(n): 长度为 n 的序列能构成的不同二叉搜索树的个数。
     *
     * F(i, n): 以 i 为根、序列长度为 n的不同二叉搜索树个数(1≤i≤n)。
     *
     * 可见，G(n)是我们求解需要的函数。
     *
     * 稍后我们将看到，G(n)可以从 F(i, n) 得到，而 F(i, n)又会递归地依赖于 G(n)
     *
     * 首先，根据上一节中的思路，不同的二叉搜索树的总数 G(n)，是对遍历所有 i(1≤i≤n) 的 F(i, n) 之和。换言之：
     *
     * G(n) = sum( F(i, n)) i=1,2...,n (1)
     *
     * 对于边界情况，当序列长度为 1（只有根）或为 0（空树）时，只有一种情况，即：
     *
     * G(0)=1,G(1)=1
     *
     * 不同二叉搜索树的个数为F(3,7)。我们将 [1,2]构建不同左子树的数量表示为 G(2), 从 [4,5,6,7] 构建不同右子树的数量表示为 G(4)，
     *
     * 注意到 G(n) 和序列的内容无关，只和序列的长度有关。于是，F(3,7)=G(2)⋅G(4)。 因此，我们可以得到以下公式：
     *
     * F(i,n)=G(i−1)⋅G(n−i) (2)
     *
     * 将公式 (1),(2) 结合，可以得到 G(n) 的递归表达式：
     *
     * G(n)= ∑ G(i−1)⋅G(n−i)(3)
     */

    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++)
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        return G[n];
    }
}