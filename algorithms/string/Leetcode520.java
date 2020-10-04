package string;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: string
 * @Author: elvis
 * @CreateTime: 2020-10-04 22:34
 * @Description: 检测大写字母
 * 给定一个单词，你需要判断单词的大写使用是否正确。
 *
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 *
 * 全部字母都是大写，比如"USA"。
 * 单词中所有字母都不是大写，比如"leetcode"。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
 * 否则，我们定义这个单词没有正确使用大写字母。
 *
 * 示例 1:
 *
 * 输入: "USA"
 * 输出: True
 * 示例 2:
 *
 * 输入: "FlaG"
 * 输出: False
 * 注意: 输入是由大写和小写拉丁字母组成的非空单词。
 */
public class Leetcode520 {

    /**
     * 判断第一个字符是大小写　s记录
     * 判断第二个字符大小写　并携带第一个字符信息　如果第二字符是小写　第一个大写　则mix为true 单词应为 Abbbb型
     * 否则应为AAAAA型
     */
    public boolean detectCapitalUse(String word) {
        char[] ch=word.toCharArray();
        if(ch.length==1) return true;
        boolean s=ch[0]>=97?true:false;
        boolean mix=s?false:ch[1]>=97?true:false;
        if(s||mix){
            for(int i=1;i<ch.length;i++){
                if(ch[i]<97) return false;
            }
        }else{
            for(int i=1;i<ch.length;i++){
                if(ch[i]>=97) return false;
            }

        }
        return true;
    }
}
