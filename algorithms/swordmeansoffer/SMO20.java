package swordmeansoffer;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: swordmeansoffer
 * @Author: elvis
 * @CreateTime: 2020-08-30 09:26
 * @Description: 剑指 Offer 20. 表示数值的字符串
 *
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 *
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"
 *
 * 都表示数值， 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 */
public class SMO20 {

    public static boolean isNumber(String s) {
        //去掉空格
        s=s.trim();
        //正确的情况：
        //.出现一次 并且在.前面必须有数字
        // e出现一次并且在e前面必须有数值
        // + - 必须在第一位 或者在e的后面
        boolean dot=false;
        boolean e=false;
        boolean num=false;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                num =true; // 代表有了数字
            }
            //.前面没出现过. 并且也没出现过e .前面必须要有数字
            else if(s.charAt(i)=='.'&&!dot&&!e){
                if(i >=1 &&s.charAt(i-1)!=' '){
                    dot=true;
                }
                else if(i>=1){
                    return false;
                }
                else{
                    dot=true;
                }
            }
            //e前面没出现过e  并且出现过数字
            else if((s.charAt(i)=='e'||s.charAt(i)=='E') && !e&&num){
                e=true;
                num=false; //因为存在1e+后面的问题
            }
            // + - 只能出现在第一位 或者在e的后面
            else if((s.charAt(i)=='+'||s.charAt(i)=='-') && (i==0||s.charAt(i-1)=='e'||s.charAt(i-1)=='E')){

            }
            else{
                return false;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        isNumber("-1E-16");
    }
}
