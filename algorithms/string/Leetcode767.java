package string;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: string
 * @Author: elvis
 * @CreateTime: 2021-01-14 11:12
 * @Description: 重构字符串
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 *
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 示例 1:
 *
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 *
 * 输入: S = "aaab"
 * 输出: ""
 * 注意:
 *
 * S 只包含小写字母并且长度在[1, 500]区间内。
 */
public class Leetcode767 {

    /**
     * 利用长为26的数组统计字母频率
     * 若出现最多的字母的次数大于(s.length()+1)/2 则无法排列
     * 否则　先排出现次数最多的字母　并且先排偶数位　再排奇数位
     */
    public String reorganizeString(String s) {
        char[] arr = s.toCharArray();
        int[] tmp = new int[26];
        //groupingBy
        for(int i=0;i<arr.length;i++){
            tmp[arr[i] - 'a']++;
        }
        //找到出现次数最多的字母
        int maxIndex = 0;
        for(int i=0;i<tmp.length;i++){
            if(tmp[maxIndex] < tmp[i]){
                maxIndex = i;
            }
        }
        int count = tmp[maxIndex];
        if(count > (arr.length+ 1)/2){
            return "";
        }
        //可行，则先排偶数位
        int index = 0;
        char[] res = new char[arr.length];
        while(tmp[maxIndex]-->0){
            res[index] = (char)(maxIndex + 'a');
            index+=2;
        }
        //考虑其他字符串
        for(int i=0;i<tmp.length;i++){
            while(tmp[i]-- >0){

                if(index >= arr.length){
                    //偶数用完了
                    index = 1;
                }
                res[index] = (char)(i + 'a');
                index +=2;
            }
        }

        return String.valueOf(res);
    }
}
