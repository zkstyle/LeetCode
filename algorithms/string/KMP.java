package string;

/**
 * 假设现在文本串S匹配到 i 位置，模式串P匹配到 j 位置 如果j = -1，或者当前字符匹配成功（即S[i] ==
 * P[j]），都令i++，j++，继续匹配下一个字符； 如果j != -1，且当前字符匹配失败（即S[i] != P[j]），则令 i 不变，j =
 * next[j]，此举意味着模式串P相对于文本串S向右移动了至少1位（换言之，当匹配失败时，模式串向右移动的位数为：失配字符所在位置 -
 * 失配字符对应的next 值，即移动的实际位数为：j - next[j]，且此值大于等于1）。
 *
 * @author elvis
 *
 */
public class KMP {

    char[] s;
    char[] p;
    int[] next;

    public KMP(String s, String p) {
        this.s = s.toCharArray();
        this.p = p.toCharArray();
        this.next = new int[this.p.length];
        getNext();
        for(int i=0;i<next.length;i++)
            System.out.print(next[i]+" ");
    }

    /**
     * 填充next数组 若pattern[k] == pattern[j]，则next[j + 1 ] = next [j] + 1 = k + 1；
     * 若pattern[k ] ≠ pattern[j]，如果此时pattern[ next[k] ] == pattern[j ]，则next[ j
     * + 1 ] = next[k] + 1，否则重复此过程。 现在前缀“p0 pk-1 pk” 去跟后缀 “pj-k pj-1
     * pj”匹配，发现在pk处匹配失败，那么前缀需要向右移动多少位呢？根据已经求得的前缀各个字符的next 值，可得前缀应该向右移动k -
     * next[k]位，相当于k = next[k]。 若移动之后，pk' = pj，则代表字符E前存在长度为next[ k' ] +
     * 1的相同前缀后缀； 否则继续递归k = next [k]，直到pk’’ 跟pj匹配成功，或者不存在任何k（0 < k < j）满足pk = pj
     * ，且 k = next[k] = -1停止递归。
     */
    public void getNext() {
        next[0] = -1;
        int j = 0;
        int k = -1;
        while (j < p.length - 1) {
            if (k == -1 || p[k] == p[j]) {
                k++;
                j++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
    }

    /**
     * @Param: String s="BBCABCDABABCDABCDABDE";
     *         String p="ABCDABD";
     */
    public int match(){

        int i=0;
        int j=0;
        while(i<s.length&&j<p.length){
            if(j==-1||s[i]==p[j]){
                i++;
                j++;
            }else {
                j=next[j];
            }
        }
        if(j==p.length){
            return i-j;
        }
        else
            return -1;
    }

    public static void main(String[] args) {
        String s="BBCABCDABABCDABCDABDE";
        String p="ABCDABD";
        KMP k=new KMP(s, p);
        System.out.println();
        System.out.println(k.match());


    }
}