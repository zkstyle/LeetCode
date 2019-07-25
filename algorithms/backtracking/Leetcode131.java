package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: backtracking
 * @Author: Elvis
 * @CreateTime: 2019-07-18 11:06
 * Description:
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class Leetcode131 {

    List<List<String>> res=new ArrayList<List<String>>();
    String str;
    int len;

    public List<List<String>> partition(String s) {
        str=s;
        len=s.length()-1;
        find(new ArrayList<>(),0);
        return res;
    }

    //主函数
    public void find(List<String> list,int index) {
        if(index==len+1){
            res.add(new ArrayList<>(list));
            return;
        }
        int i=index;
        while(i<=len){
            if(isRever(index,i)){
                list.add(str.substring(index,i+1));
                find(list,i+1);
                list.remove(list.size()-1);
            }
            i++;
        }
    }
    //判断是否是回文字符串
    public boolean isRever(int i,int j){
        while(i<=j){
            if(str.charAt(i)!=str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

}
