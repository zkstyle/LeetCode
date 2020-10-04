package math;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: math
 * @Author: elvis
 * @CreateTime: 2020-09-30 15:47
 * @Description: x
 */
public class Leetcode390 {

    /**
     *  f(2k) = 2(k+1-f(k))
     *  f(2k+1)=2(k+1−f(k))
     */
     public int lastRemaining(int n) {
         return n==1 ? 1 : 2*(n/2+1-lastRemaining(n/2));
     }


    /**
     * 我们的目标是要寻找最后只剩下一个元素的列表的第一个元素。假设first是消除过程中列表的第一个元素，count为消除后剩下的元素个数，diff为列表的公差。我们可以发现以下几个规律：
     *
     * 消除过程中的列表必定是一个等差数列，且diff是不断翻倍的。我们可以用first和diff来表征一个列表；
     * 每轮消除之后，count变成原来的1/2；
     * 每轮消除之后的first跟当前消除的方向以及count的奇偶性有关。
     * 如果从左往右消除，则新列表的first就是当前消除列表的第二个元素，即为first + diff，其中diff是当前要消除的列表的diff；
     * 如果是从右往左消除，则新列表的first值会受count的奇偶性所影响，举个例子，如果count是奇数，如[1,2,3,4,5]，那么从右开始消除，则会消掉1, 3, 5 剩下[2,4]。
     * 如果count是偶数, 如[1,2,3,4]，则从右开始消除之后，剩下[1,3]。可以发现，如果count是奇数，新列表的first即为first + diff，否则新列表first不变。
     */
    public int lastRemaining2(int n) {
        int count = n;
        int first = 1;
        int diff = 1;
        boolean isFromLeft = true;
        while (count > 1) {
            if (isFromLeft) {
                first += diff;
            } else {
                if ((count & 1) == 1) {
                    first += diff;
                }
            }

            count >>>= 1;
            diff <<= 1;
            isFromLeft = !isFromLeft;
        }

        return first;
    }
}
