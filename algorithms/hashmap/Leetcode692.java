package hashmap;

import java.util.*;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: hashmap
 * @Author: elvis
 * @CreateTime: 2020-10-01 09:39
 * @Description: 前K个高频单词
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 *
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 *
 * 示例 1：
 *
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 *     注意，按字母顺序 "i" 在 "love" 之前。
 *
 *
 * 示例 2：
 *
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 *     出现次数依次为 4, 3, 2 和 1 次。
 *
 *
 * 注意：
 *
 * 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
 * 输入的单词均由小写字母组成。
 *
 *
 * 扩展练习：
 *
 * 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
 */
public class Leetcode692 {

    /**
     * 计算每个单词的频率，然后将其添加到存储到大小为 k 的小根堆中。它将频率最小的候选项放在堆的顶部。最后，我们从堆中弹出最多 k 次，并反转结果，就可以得到前 k 个高频单词。
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> count=new HashMap<>();
        for(String s:words){
            count.put(s,count.getOrDefault(s,0)+1);
        }
        PriorityQueue<String> priority=new PriorityQueue<>((w1, w2)->(count.get(w1).equals(count.get(w2))?w2.compareTo(w1):count.get(w1)-count.get(w2)));
        for(String key:count.keySet()){
            priority.offer(key);
            if(priority.size()>k) priority.poll();
        }
        List<String> ans=new ArrayList<>();
        while(!priority.isEmpty()) ans.add(priority.poll());
        Collections.reverse(ans);
        return ans;

    }
}
