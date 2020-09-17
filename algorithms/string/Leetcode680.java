package string;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: string
 * @Author: elvis
 * @CreateTime: 2020-09-17 22:40
 * @Description: x
 */
public class Leetcode680 {

    /**
     * 两次检查回文串　若出现不相等字符　ch[l]!=ch[r] 那么要么
     * ch[l]==ch[r-1] || ch[l+1]==ch[r] 否则返回false
     */
    public boolean validPalindrome(String s) {
        int length = s.length();
        if (length == 0 || length == 1) return true;
        int number = 0;
        int l = 0, r = length - 1;
        char[] charS = s.toCharArray();

        while (l <= r) {
            if (charS[l] == charS[r]) {
                l++;
                r--;
            } else {
                if (charS[l] == charS[r - 1]) {
                    if (isPalindrome(charS, l, r - 1))
                        return true;
                }
                if (charS[r] == charS[l + 1]) {
                    if (isPalindrome(charS, l + 1, r))
                        return true;
                }
                return false;
            }
        }
        return true;

    }

    public boolean isPalindrome(char[] charS, int l, int r) {
        while (l < r) {
            if (charS[l] == charS[r]) {
                l++;
                r--;
            } else
                return false;
        }
        return true;
    }
}
