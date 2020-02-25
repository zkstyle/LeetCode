package hashmap;

import java.util.*;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.hashmap
 * @Author: Elvis
 * @CreateTime: 2018-12-21 19:51
 * Description:
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 *
 * 上图是一个部分填充的有效的数独。
 *
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 *      但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 说明:
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 */
public class Leetcode36 {
    /**
     * 最优14ms
     */
    public boolean isValidSudokuBest(char[][] board) {
         for(int i = 0; i < 9; i++){
	    	   for(int j = 0; j < 9; j++){
	    		   if(board[i][j] == '.')continue;
	    		   for(int k = 8; k > j; k-- )
	    			   if(board[i][j] == board[i][k])
	    				   return false;
	    		   for(int k = 8; k > i; k--)
	    			   if(board[i][j] == board[k][j])
	    				   return false;
	    		   for(int k = i + 1; k % 3 != 0; k ++){
	    			   for(int h = j /3 *3;h < j / 3 *3 + 3; h ++ )
	    				   if(board[i][j] == board[k][h])
	    					   return false;
	    		   }
	    	   }
	       }
	       return true;
    }

    /**
     * own-version Plus 大佬算法
     * @param board
     * @return
     */
    public static boolean isValidSudokuPlusTwo(char[][] board) {
        /**
         * 判断方式：　所在九宫格是否有重复元素以及同行同列是否重复
         */
        HashSet<String> map = new HashSet(81 * 4);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                String x = "row" + String.valueOf(board[i][j]) + i;
                if (map.contains(x)) {
                    return false;
                }
                map.add(x);
                x =  "columns" + String.valueOf(board[i][j]) + j;
                if (map.contains(x)) {
                    return false;
                }
                map.add(x);

                x = "cell" + String.valueOf(board[i][j]) + ((i / 3) * 3 + j / 3);
                if (map.contains(x)) {
                    return false;
                }
                map.add(x);
            }
        }
        return true;
    }
    /**
     * own-version Plus
     * @param board
     * @return
     */
    public static boolean isValidSudokuPlus(char[][] board) {
        /**
         * 判断方式：　所在九宫格是否有重复元素以及同行同列是否重复
         */
        Set<String> map = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.'){
                    continue;
                }
                String string = "Row" + String.valueOf(board[i][j]) + i;
                if (map.contains(string)) {
                    return false;
                }
                map.add(string);
                string = "Col" + String.valueOf(board[i][j]) + j;
                if (map.contains(string)) {
                    return false;
                }
                map.add(string);
                string = "RC" + String.valueOf(board[i][j]) + ((i / 3) * 3 + j / 3);
                if (map.contains(string)) {
                    return false;
                }
                map.add(string);
            }
        }
        return true;
    }
    /**
     * own-version
     * @param board
     * @return
     */
    public static boolean isValidSudoku(char[][] board) {
        /**
         * isValidSudoku 标志变量　控制返回值
         * int boardRow 行数长度
         * int boardCol 列数长度
         * Map<Integer, Integer[]> map 哈希表　键是数独数字　值是对应的下标
         * Integer digit 获取当前元素的数值型值
         * Integer[] value = {i, j}; 记录当前数字下标
         * 判断方式：　所在九宫格是否有重复元素以及同行同列是否重复
         */
        if (board.length == 0)
            return true;
        boolean isValidSudoku = true;
        Map<Integer, List<Integer[]>> map = new HashMap<>();

        int boardRow = board.length;
        int boardCol = board[0].length;
        for (int i = 0; i < boardRow; i++) {
            for (int j = 0; j < boardCol; j++) {
                if (Character.isDigit(board[i][j])){
                    Integer digit = Character.getNumericValue(board[i][j]);
                    Integer[] value = {i, j};
                    if (map.containsKey(digit)){
                        for (Integer[] index : map.get(digit)){
                            if (index[0] == i || index[1] == j || (index[0]/3 == i/3 && index[1]/3 == j/3)){
                                return false;
                            }
                        }
                        List<Integer[]> list = map.get(digit);
                        list.add(value);
                        map.put(digit, list);
                    }else {
                        List<Integer[]> list = new ArrayList<>();
                        list.add(value);
                        map.put(digit, list);
                    }
                }
            }
        }
        return isValidSudoku;
    }
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '7', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '.', '9'},
        };
        System.out.println(isValidSudoku(board));
    }
}
