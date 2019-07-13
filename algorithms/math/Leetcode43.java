package math;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: math
 * @Author: Elvis
 * @CreateTime: 2019-07-04 10:13
 * Description:字符串相乘
 */
public class Leetcode43 {

    public String multiply(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();

        if(num1.equals("0") || num2.equals("0"))
            return "0";

        int[] num = new int[l1+l2];

        for(int i=l1-1; i>=0;i--){
            int n1 = num1.charAt(i)-'0';
            for(int j=l2-1; j>=0;j--){
                int n2 = num2.charAt(j)-'0';
                num[l1-1+l2-1-i-j]+=n1*n2;
            }
        }
        int carry = 0;
        for(int i=0;i<num.length;i++){
            if(num[i]+carry>=10){
                int sum = num[i]+carry;
                carry = sum/10;
                num[i] = sum%10;
            }else{
                num[i] = num[i] + carry;
                carry=0;
            }
        }

        StringBuffer str = new StringBuffer();
        int l = l1+l2-1;
        while(num[l]==0)
            l--;

        for(int i=l;i>=0;i--){
            str.append(num[i]+"");
        }

        return str.toString();

    }

    public static void main(String[] args) {
        String s1 = "123", s2 = "456";
        new Leetcode43().multiply(s1,s2);
    }
}
