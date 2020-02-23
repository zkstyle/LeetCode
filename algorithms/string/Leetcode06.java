package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: string
 * @Author: elvis
 * @CreateTime: 2020-02-23 09:38
 * @Description: Z字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class Leetcode06 {
    /**
     * 思路：找规律　按行查找　一次查找每一行　找寻每一行的规律
     * 首先对于特殊行　第一行下标索引为　k*(2*numRows-2) 最后一行 k*(2*numRows-2)+numsRows-1
     * 对于中间行　有两种可能性　一种就是第一行+行标 k*(2*numRows-2)+i 以及　k*(2*numRows-2)-i
     * 时间复杂度O(N) 空间复杂度O(N)
     */
    public String convert2(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) return s;
        char[] ch = new char[s.length()];
        int index = 0;
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                //对第一行以及最后一行特殊处理　比较简单
                int sign = i;
                while (sign < ch.length) {
                    ch[index] = s.charAt(sign);
                    index++;
                    sign += 2 * (numRows - 1);
                }
            } else {
                // 两种情况的起始节点　间距都是2 * numRows - 2
                int sign1 = i, sign2 = i + 2 * (numRows - i - 1);
                while (sign2 < ch.length) {
                    ch[index] = s.charAt(sign1);
                    index++;
                    sign1 += 2 * (numRows - 1);
                    ch[index] = s.charAt(sign2);
                    index++;
                    sign2 += 2 * (numRows - 1);
                }
                // 有可能第一种情况节点还剩一个
                if (sign1 < ch.length) {
                    ch[index] = s.charAt(sign1);
                    index++;
                }
            }
        }
        return new String(ch);
    }

    /**
     * Leetcode官方解析思路
     *
     * 通过从左向右迭代字符串，我们可以轻松地确定字符位于 Z 字形图案中的哪一行。
     *
     * 算法
     *
     * 我们可以使用 min(numRows,len(s)) 个列表来表示 Z 字形图案中的非空行。
     *
     * 从左到右迭代 ss，将每个字符添加到合适的行。可以使用当前行和当前方向这两个变量对合适的行进行跟踪。
     *
     * 只有当我们向上移动到最上面的行或向下移动到最下面的行时，当前方向才会发生改变。
     */
    public String convert_(String s, int numRows) {
        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;  //标志位　当当前行为第一行或最后一行时　改变标志位　

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            //神奇的一行代码　当curRow为第一行或最后一行　方向逆转　行数递增或递减(先递增再递减...循环)
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
}
