package backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: backtracking
 * @Author: elvis
 * @CreateTime: 2020-03-18 17:26
 * @Description: 复原ip
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */
public class Leetcode93 {

    /**
     * 解题思路: 回溯法　并且需要剪枝　避免不必要的回溯　
     * 1、一开始，字符串的长度小于 4 或者大于 12 ，一定不能拼凑出合法的 ip 地址（这一点可以一般化到中间结点的判断中，以产生剪枝行为）；
     *
     * 2、每一个结点可以选择截取的方法只有 3 种：截 1 位、截 2 位、截 3 位，因此每一个结点可以生长出的分支最多只有 3 条分支；
     *
     * 根据截取出来的字符串判断是否是合理的 ip 段，这里写法比较多，可以先截取，再转换成 int ，再判断。我采用的做法是先判断截取长度大于1并且首位为0
     * 不满足条件返回false 再转成 int，是合法的 ip段数值以后，再截取。
     *
     * 3、由于 ip 段最多就 4 个段，因此这棵三叉树最多 4 层，这个条件作为递归终止条件之一；
     *
     * 4. 利用双端队列deque存储ip字符串　并后期进行"."填充
     *
     * 5、每一个结点表示了求解这个问题的不同阶段，需要的状态变量有：
     *
     * count：需要分割ip段数目；
     * begin：截取 ip 段的起始位置；
     * list：记录结果集的变量，常规变量。
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        if (s.length() < 4 | s.length() > 12) return list;
        Deque<String> deque = new ArrayDeque<>();
        ip(list, s, deque, 0, 4);
        return list;
    }

    private void ip(List<String> list, String s, Deque<String> deque, int begin, int count) {
        if (begin == s.length() && count == 0) {
            list.add(String.join(".", deque));
            return;
        }

        for (int i = begin; i < begin + 3; i++) {
            //剪枝　若截取ip起始位置大于s.length() 直接终止循环
            if (i >= s.length()) break;
            //若剩余字符串长度大于ip段最大长度3*剩余ip段长度count 则剪枝　不需要继续遍历
            if (s.length() - i > count * 3) break;
            if (judgeIp(s, begin, i + 1)) {
                deque.addLast(s.substring(begin, i + 1));
                ip(list, s, deque, i + 1, count - 1);
                deque.removeLast();
            }
        }
    }

    private boolean judgeIp(String s, int begin, int i) {
        if (i - begin > 1 && s.charAt(begin) == '0') return false;
        return Integer.valueOf(s.substring(begin, i)) < 256;
    }
}
