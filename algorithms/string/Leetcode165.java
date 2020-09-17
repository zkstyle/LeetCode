package string;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: string
 * @Author: elvis
 * @CreateTime: 2020-09-17 00:07
 * @Description: 比较版本号
 */
public class Leetcode165 {

    /**
     * 版本号比较　首先分割字符串　然后依次比较
     */
    public static int compareVersion(String version1, String version2) {
        String[] v1=version1.split("\\.");
        String[] v2=version2.split("\\.");
        int d1=0,d2=0;
        while(d1<v1.length||d2<v2.length){
            int value1=d1<v1.length?Integer.valueOf(v1[d1]):0;
            int value2=d2<v2.length?Integer.valueOf(v2[d2]):0;
            if(value1>value2) return 1;
            if(value2>value1) return -1;
            d1++;
            d2++;
        }
        return 0;
    }

    public static void main(String[] args) {
        compareVersion("0.1","1.1");
    }
}
