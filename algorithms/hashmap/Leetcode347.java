package hashmap;

import java.util.*;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: hashmap
 * @Author: elvis
 * @CreateTime: 2020-09-21 22:59
 * @Description: 前K个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 *
 *
 * 提示：
 *
 *     你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 *     你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 *     题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 *     你可以按任意顺序返回答案。
 */
public class Leetcode347 {

    /**
     * 快排
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        List<int[]> values = new ArrayList<int[]>();
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            values.add(new int[]{num, count});
        }
        int[] ret = new int[k];
        qsort(values, 0, values.size() - 1, ret, 0, k);
        return ret;
    }

    public void qsort(List<int[]> values, int start, int end, int[] ret, int retIndex, int k) {
        int picked = (int) (Math.random() * (end - start + 1)) + start;
        Collections.swap(values, picked, start);

        int pivot = values.get(start)[1];
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            if (values.get(i)[1] >= pivot) {
                Collections.swap(values, index + 1, i);
                index++;
            }
        }
        Collections.swap(values, start, index);

        if (k <= index - start) {
            qsort(values, start, index - 1, ret, retIndex, k);
        } else {
            for (int i = start; i <= index; i++) {
                ret[retIndex++] = values.get(i)[0];
            }
            if (k > index - start + 1) {
                qsort(values, index + 1, end, ret, retIndex, k - (index - start + 1));
            }
        }
    }

    /**
     * 桶排序　将数字出现频率作为数组下表（桶）　依次填入数据
     * 然后逆序遍历　遍历从最高频率数字开始
     */
    public List<Integer> topKFrequent2(int[] nums, int k) {
        List<Integer> res = new ArrayList();
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //桶排序
        //将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
        List<Integer>[] list = new List[nums.length + 1];
        for (int key : map.keySet()) {
            // 获取出现的次数作为下标
            int i = map.get(key);
            if (list[i] == null) {
                list[i] = new ArrayList();
            }
            list[i].add(key);
        }

        // 倒序遍历数组获取出现顺序从大到小的排列
        for (int i = list.length - 1; i >= 0 && res.size() < k; i--) {
            if (list[i] == null) continue;
            res.addAll(list[i]);
        }
        return res;
    }

    public int[] topKFrequent2_(int[] nums, int k) {
        int[] ret = new int[k];
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //桶排序
        //将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
        List<Integer>[] list = new List[nums.length + 1];
        for (int key : map.keySet()) {
            // 获取出现的次数作为下标
            int i = map.get(key);
            if (list[i] == null) {
                list[i] = new ArrayList();
            }
            list[i].add(key);
        }

        // 倒序遍历数组获取出现顺序从大到小的排列
        for (int i = list.length - 1; i >= 0 && k > 0; i--) {
            if (list[i] == null) continue;
            for (int x : list[i]) ret[--k] = x;
        }
        return ret;
    }

    /**
     * 自实现hash桶
     * int[] keys = new int[n];
     * int[] values = new int[n];　
     * 利用两个数组装载频率值
     * 利用hash+1 解决hash冲突
     */
    public static int[] topKFrequent3(int[] nums, int k) {

        int n = nums.length;
        int[] keys = new int[n];
        int[] values = new int[n];
        for (int num : nums) {
            int hash = hash(num, n);
            while (keys[hash] != num && values[hash] > 0) {
                hash++;
            }
            keys[hash] = num;
            values[hash]++;
        }
        List<Integer>[] sortedByFreq = (List<Integer>[]) new List[nums.length + 1];
        for (int i = 0; i < n; i++) {
            if (values[i] > 0) {
                if (sortedByFreq[values[i]] == null) {
                    sortedByFreq[values[i]] = new ArrayList<>();
                }
                sortedByFreq[values[i]].add(keys[i]);
            }
        }
        int[] topKFrequent = new int[k];
        for (int i = sortedByFreq.length - 1; i >= 0 && k > 0; i--) {
            if (sortedByFreq[i] != null) {
                for (int num : sortedByFreq[i]) {
                    topKFrequent[--k] = num;
                    if (k == 0) {
                        return topKFrequent;
                    }
                }
            }
        }
        return topKFrequent;
    }

    private static int hash(int key, int buckets) {
        return (key & 0x7fffffff) % buckets;
    }

    public static void main(String[] args) {
        topKFrequent3(new int[]{1,2,2,9,9,8,7},4);
    }
}
