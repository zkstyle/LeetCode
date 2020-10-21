package array;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: array
 * @Author: elvis
 * @CreateTime: 2020-10-21 13:21
 * @Description: 复写零
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 *
 * 注意：请不要在超过该数组长度的位置写入元素。
 *
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,0,2,3,0,4,5,0]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 * 示例 2：
 *
 * 输入：[1,2,3]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,2,3]
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 */
public class Leetcode1089 {

    /**
     * 我们可以理解成非零数据占用1个位置，元素为0占用两个位置，于是可以按照下面的思路思考：
     *
     * 由于元素为0需要占用2个位置（复写一遍），那么必然会丢弃一些数据
     * 遍历一次源数据，统计能装下的有效数据（非零占1个空间，霸道总裁占2个空间），扫描到第i个元素时会使用完当前的arr空间
     * i后面的元素可以直接抛弃，减少多余的遍历
     * 再倒序遍历填充数据，从第i个开始填充，霸道0填充2次即可
     */
    public void duplicateZeros(int[] arr) {
        int len = arr.length;
        int i = 0, count = 0;
        /*第一次遍历，计算有效位置i*/
        for (; i < len; i++) {
            if (arr[i] == 0) count++;
            if ((i + count) >= len - 1) break;
        }

        /*特殊判断*/
        if ((count + i) > len - 1) {
            arr[len-- - 1] = arr[i--];
        }

        /*从i开始填充数据*/
        int j = len - 1;
        while (j > i) {
            if (arr[i] == 0) {
                arr[j] = 0;
                arr[--j] = 0;
            } else {
                arr[j] = arr[i];
            }
            i--;
            j--;
        }
    }
}
