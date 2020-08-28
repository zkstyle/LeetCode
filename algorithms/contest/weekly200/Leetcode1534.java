package contest.weekly200;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: contest.weekly200
 * @Author: elvis
 * @CreateTime: 2020-08-23 21:58
 * @Description: 统计好三元组
 * 给你一个整数数组 arr ，以及 a、b 、c 三个整数。请你统计其中好三元组的数量。
 *
 * 如果三元组 (arr[i], arr[j], arr[k]) 满足下列全部条件，则认为它是一个 好三元组 。
 *
 * 0 <= i < j < k < arr.length
 * |arr[i] - arr[j]| <= a
 * |arr[j] - arr[k]| <= b
 * |arr[i] - arr[k]| <= c
 * 其中 |x| 表示 x 的绝对值。
 *
 * 返回 好三元组的数量 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,0,1,1,9,7], a = 7, b = 2, c = 3
 * 输出：4
 * 解释：一共有 4 个好三元组：[(3,0,1), (3,0,1), (3,1,1), (0,1,1)] 。
 * 示例 2：
 *
 * 输入：arr = [1,1,2,2,3], a = 0, b = 0, c = 1
 * 输出：0
 * 解释：不存在满足所有条件的三元组。
 *
 *
 * 提示：
 *
 * 3 <= arr.length <= 100
 * 0 <= arr[i] <= 1000
 * 0 <= a, b, c <= 1000
 */
public class Leetcode1534 {

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int ct = 0;
        for(int i = 0;i < n;i++){
            for(int j = i+1;j < n;j++){
                for(int k = j+1;k < n;k++){
                    if(
                            Math.abs(arr[j] - arr[i]) <= a &&
                                    Math.abs(arr[k] - arr[j]) <= b &&
                                    Math.abs(arr[k] - arr[i]) <= c
                    ){
                        ct++;
                    }

                }
            }
        }
        return ct;
    }

    List<List<String>> ret=new ArrayList<>();
    public List<List<String>> partition(String s) {
        List<String> list=new ArrayList<>();
        back(s,list,0);
        return ret;
    }

    private void back(String s, List<String> list, int idx) {
        if(idx==s.length()){
            ret.add(new ArrayList<>(list));
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            String str=s.substring(idx,i+1);
            if(isPalindrome(str)){
                list.add(str);
                back(s,list,i+1);
                list.remove(list.size()-1);
            }
        }
    }

    private boolean isPalindrome(String str) {
        int l=0,r=str.length()-1;
        while(l<r){
            if(str.charAt(l++)!=str.charAt(r--)) return false;
        }
        return true;
    }


}
