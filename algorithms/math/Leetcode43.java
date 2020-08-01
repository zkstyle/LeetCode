package math;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: math
 * @Author: Elvis
 * @CreateTime: 2019-07-04 10:13
 * Description:字符串相乘
 */
public class Leetcode43 {

    /**
     * 首先边界特殊情况处理　其中一个字符串为0　直接返回0
     * 用数组临时存储计算结果　temp[i+j] 存储 nums1 第 i 位　乘以　nums2 的第　j　位数
     * 最后对每一位进位进行处理　最高位就不处理　直接append就可以了
     */
    public String multiply(String num1, String num2) {
        // 首先处理结果为 "0" 的情况
        if ("0".equals(num1) || "0".equals(num2)) return "0";
        int len1 = num1.length();
        int len2 = num2.length();

        // 转字符串数组，方便操作
        char[] cs1 = num1.toCharArray();
        char[] cs2 = num2.toCharArray();

        // 创建临时结果数组
        int len = len1 + len2 - 1;
        int[] temp = new int[len];

        // 计算：（不要忘记 "+" 号）
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                temp[i + j] += (cs1[i] - '0') * (cs2[j] - '0');
            }
        }

        // 整理结果，从结果低位（数组高位）开始整理，保证每个数都 < 10
        for (int i = len - 1; i > 0; i--) {
            if (temp[i] > 9) {
                int add = temp[i] / 10;
                temp[i - 1] += add;
                temp[i] = temp[i] % 10;
            }
        }

        // 生成结果字符串
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            builder.append(temp[i]);
        }
        // 输出结果
        return builder.toString();
    }
}
