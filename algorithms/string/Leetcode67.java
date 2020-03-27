package string;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: string
 * @Author: elvis
 * @CreateTime: 2020-03-27 19:28
 * @Description: 二进制求和
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101
 */
public class Leetcode67 {

    /**
     * 基本思路：　分别用两个指针i,j指向两个字符串尾端　进行计算　将字符转换为数字
     * 因为可能有长有短　while循环只要有一个字符串没有结束(i>=0||j>=0||flag==1) flag是进位
     * 然后switch判断ia+ib+flag和　有四种情况　0 1 2 3分别处理
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0 || flag == 1) {
            //若 i>=0 字符串a还没有遍历完　若当前字符为1 返回1
            int ia = i >= 0 ? a.charAt(i) == '1' ? 1 : 0 : 0;
            int ib = j >= 0 ? b.charAt(j) == '1' ? 1 : 0 : 0;
            int sum = ia + ib + flag;
            switch (sum) {
                case 0:
                    sb.append(0);
                    break;
                case 1:
                    sb.append(1);
                    flag = 0;
                    break;
                case 2:
                    sb.append(0);
                    flag = 1;
                    break;
                case 3:
                    sb.append(1);
                    flag = 1;
                    break;
            }
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}
