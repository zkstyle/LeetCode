package stack;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.stack
 * @Author: Elvis
 * @CreateTime: 2019-04-10 11:27
 * Description:
 */
public class Leetcode224 {

    public int calculate(String s) {
        int[] position = {0};
        return eval2(s.toCharArray(),position);
    }
    public int eval2(char[] expression,int[] position){
        int res = 0;
        int operator = 1;
        int pre = 0;
        int i = position[0];
        while (i<expression.length) {
            switch (expression[i]) {
                case '+':
                    res += operator * pre;
                    operator = 1;
                    pre = 0;
                    i++;
                    break;
                case '-':
                    res += operator * pre;
                    operator = -1;
                    pre = 0;
                    i++;
                    break;
                case '(':
                    position[0] = i+1;
                    res += operator * eval2(expression, position);
                    i = position[0];
                    break;
                case ')':
                    position[0] = i+1;
                    return res + operator * pre;
                case ' ':
                    i++;
                    continue;
                default:
                    pre = pre * 10 + expression[i] - '0';
                    i ++;
            }
        }
        return res+operator * pre;
    }

    public static void main(String[] args) {
        String s = "1-11";
        new Leetcode224().calculate(s);
    }
}
