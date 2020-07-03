package bit;

import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: bit
 * @Author: elvis
 * @CreateTime: 2020-07-03 14:38
 * @Description: 子数组按位或操作
 * 我们有一个非负整数数组 A。
 *
 * 对于每个（连续的）子数组 B = [A[i], A[i+1], ..., A[j]] （ i <= j），我们对 B 中的每个元素进行按位或操作，获得结果 A[i] | A[i+1] | ... | A[j]。
 *
 * 返回可能结果的数量。 （多次出现的结果在最终答案中仅计算一次。）
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[0]
 * 输出：1
 * 解释：
 * 只有一个可能的结果 0 。
 * 示例 2：
 *
 * 输入：[1,1,2]
 * 输出：3
 * 解释：
 * 可能的子数组为 [1]，[1]，[2]，[1, 1]，[1, 2]，[1, 1, 2]。
 * 产生的结果为 1，1，2，1，3，3 。
 * 有三个唯一值，所以答案是 3 。
 * 示例 3：
 *
 * 输入：[1,2,4]
 * 输出：6
 * 解释：
 * 可能的结果是 1，2，3，4，6，以及 7 。
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 50000
 * 0 <= A[i] <= 10^9
 */
public class Leetcode898 {


    //一开始没想明白如何剪枝。暴力的第二层循环一定要向回遍历，这样才能直接修改数组不影响后面
    //剪枝就是当(A[i] | A[j]) == A[j]，因为从i-1到0都处理过了，只有A[i]是新的
    //但是由于(A[i] | A[j]) == A[j]，所以在A[j]之前A[i]无法提供新的1的位置了，所以不影响前面的结果
    public int subarrayBitwiseORs(int[] A) {
        if(A.length < 2){
            return A.length;
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < A.length; i++){
            set.add(A[i]);
            for(int j = i - 1; j >= 0; j--){
                if((A[i] | A[j]) == A[j]){
                    break;
                }
                A[j] |= A[i];
                set.add(A[j]);
            }
        }
        return set.size();
    }
}
