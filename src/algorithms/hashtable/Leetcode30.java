package algorithms.hashtable;

import org.omg.CORBA.OBJ_ADAPTER;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.hashtable
 * @Author: Elvis
 * @CreateTime: 2018-12-20 13:00
 * Description:
 * 给定一个字符串 s 和一些长度相同的单词 words。在 s 中找出可以恰好串联 words 中所有单词的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 * 示例 1:
 *
 * 输入:
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * 输出: [0,9]
 * 解释: 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2:
 *
 * 输入:
 *   s = "wordgoodstudentgoodword",
 *   words = ["word","student"]
 * 输出: []
 *
 * "wordgoodgoodgoodbestword"
 * ["word","good","best","good"]
 *
 * 思考：记录单词的首字母　根据相同的单词长度可以进行遍历　如果首字母相同则进行全字母遍历
 */
public class Leetcode30 {
    /**
     * 大神优化版本
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstringPlus(String s, String[] words) {
        if (s.length() == 0 || words.length == 0)
            return new ArrayList<>();
        Map<String, Integer> wordsCounter = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        int wordLen = words[0].length();
        int wordsLen = words.length;
        int allLength = wordLen * wordsLen;

        for (int i = 0; i < words.length; i++) {
            wordsCounter.put(words[i], wordsCounter.getOrDefault(words[i], 0) + 1);
        }

        for (int i = 0; i < wordLen; i++) {
            for (int j = i; j + allLength <= s.length(); j += wordLen) {
                String curStr = s.substring(j, j + allLength);
                Map<String, Integer> map = new HashMap<>();
                for (int k = wordsLen - 1; k >= 0; k--) {
                    String subCurStr = curStr.substring(k * wordLen, (k + 1) * wordLen);
                    int count = map.getOrDefault(subCurStr, 0) + 1;
                    if (count > wordsCounter.getOrDefault(subCurStr, 0)) {
                        j = j + k * wordLen;
                        break;
                    } else if (k == 0 && !res.contains(j)) {
                        res.add(j);
                    } else map.put(subCurStr, count);
                }
            }
        }

        return res;
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        if (words.length == 0 || s.length() == 0 || s.length() < words[0].length())//如果字符串长度小于单词长度　
            return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int wordLen = words[0].length();//获取等长单词长度
        int wordsLen = words.length;
        int allLength = wordLen * wordsLen;
        //判断单词长度是否相等
        for (String word : words){
            if (word.length() != wordLen){
                return list;
            }
        }
        String split ;
        for (int j = 0; j < s.length() - allLength + 1; j++) {
            for (int i = j ; i < allLength + j; i += wordLen) {
                split = s.substring(i, i + wordLen);
                //count 记录单词重复出现次数
                Integer count = 1;
                //将字符串存储到map中
                if (map.containsKey(split)) {
                    count = map.get(split);
                    count++;
                    map.put(split,count);
                }else {
                    map.put(split,count);
                }
            }
            //判断与单词数组完全匹配
            for (int h = 0; h < wordsLen; h++) {
                if (map.containsKey(words[h])){
                    Integer i = map.get(words[h]);
                    if (i > 1){//map里存在重复的单词
                        i --;
                        map.put(words[h], i);
                    }else {
                        map.remove(words[h]);
                    }
                }else {
                    //不匹配则不存在　进行下一次循环
                    break;
                }
            }
            if (map.size() == 0){
                list.add(j);
            }
            //一次判断匹配后清除map
            map.clear();
        }
        return list;
    }

    public static void main(String[] args) {
       /* String s = "barfoothefoobarman";
        String[] words = {"bar","foo"};*/
       /* String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};*/
        String s = "wordgoodstudentgoodword";
        String[] words = {"word","student"};
        List<Integer> list = findSubstring(s,words);
        for (Integer integer : list){
            System.out.println(integer);
        }
    }
}
