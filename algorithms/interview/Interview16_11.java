package interview;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: interview
 * @Author: elvis
 * @CreateTime: 2020-10-04 23:10
 * @Description: 面试题 16.11. 跳水板
 * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 *
 * 返回的长度需要从小到大排列。
 *
 * 示例 1
 *
 * 输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： [3,4,5,6]
 * 解释：
 * 可以使用 3 次 shorter，得到结果 3；使用 2 次 shorter 和 1 次 longer，得到结果 4 。以此类推，得到最终结果。
 * 提示：
 *
 * 0 < shorter <= longer
 * 0 <= k <= 100000
 */
public class Interview16_11 {

    /**
     * 如果 k=0，则不能建造任何跳水板，因此返回空数组。
     *
     * 如果 horter 和 longer 相等，则建造的跳水板的长度是唯一的，都等于 shorter*k，因此返回长度为 1 的数组，数组中的元素为 shorter*k
     *
     * 然后考虑一般情况，即 shorter<longer且 k>0。由于短木板和长木板一共使用 k 块，因此一共有 k+1种组合，每种组合下建造的跳水板长度都是不一样的，一共有 k+1 种不同的长度。
     */
    public int[] divingBoard(int shorter, int longer, int k) {
        if(k==0) return new int[0];
        if(shorter==longer) return new int[]{shorter*k};
        int[] ans=new int[k+1];
        for(int i=0;i<=k;i++)
            ans[i]=shorter*(k-i)+longer*i;
        return ans;
    }
}
