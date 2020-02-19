package string;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.string
 * @Author: Elvis
 * @CreateTime: 2019-03-11 09:23
 * Description: Roman to Integer
 * Example 1:
 *
 * Input: "III"
 * Output: 3
 * Example 2:
 *
 * Input: "IV"
 * Output: 4
 * Example 3:
 *
 * Input: "IX"
 * Output: 9
 * Example 4:
 *
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 5:
 *
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class Leetcode13 {
    /**
     * 功能描述: 总的来说　这种思路很奇巧　不是通过常规的字符判断
     * 首先对每一个单个字符进行判断　对于可能有两种情况的罗马数字　比如IV I 是两种情况
     * 对于I判断　如果大于等于５　则肯定是IV组合　进行减一操作　对V进行+5操作　这样IV = 5 - 1 = 4
     */
    public int romanToInt(String s) {
        int result = 0;
        int length = s.length();
        for (int i = length - 1; i > -1; i--) {
            switch (s.charAt(i)) {
                case 'I':
                    result += result >= 5 ? -1 : 1;
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'X':
                    result += result >= 50 ? -10 : 10;
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'C':
                    result += result >= 500 ? -100 : 100;
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'M':
                    result += 1000;
                    break;
            }
        }
        return result;
    }

    public int romanToInt2(String s) {
        String[] str = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int ans = 0, index = 0;
        s += "..";  // 后期补丁..因为下面所用函数substring需要+一个str[i]长度　故延长两个单位
        for (int i = 0; i < str.length; i++) {
            //依据上题数字转罗马的思路　逐一对字符串截取判断
            while (s.substring(index, index + str[i].length()).equals(str[i])) {
                ans += nums[i];
                // 若截取字符串符合条件　则更新下标
                index += str[i].length();
            }
        }
        return ans;
    }

}
