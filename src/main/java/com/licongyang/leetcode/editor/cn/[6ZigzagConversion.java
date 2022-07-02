//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下： 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// 
//string convert(string s, int numRows); 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
// 
//示例 2：
//
// 
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// 示例 3： 
//
// 
//输入：s = "A", numRows = 1
//输出："A"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由英文字母（小写和大写）、',' 和 '.' 组成 
// 1 <= numRows <= 1000 
// 
// Related Topics 字符串 👍 1718 👎 0

package com.licongyang.leetcode.editor.cn;

/**
 *  时间复杂度：O(R * N)
 *  时间主要消耗在矩阵的创建和遍历上，矩阵行数为r，列数可以认为O(n)
 *  空间复杂度：O(R * N)
 */
//java:Z 字形变换
class P6ZigzagConversion{
    public static void main(String[] args){
        Solution solution = new P6ZigzagConversion().new Solution();
        String ss = "PAYPALISHIRING";
        System.out.println(solution.convert(ss, 4));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convert(String s, int numRows) {
        int n = s.length(), r = numRows;
        if(r == 1 || r >= n){
            return s;
        }

        int t = r * 2 - 2;
        int c = (n + t - 1) / t *  (r - 1);

        char[][] mat = new char[r][c];

        for(int i = 0, x = 0, y = 0; i < n; ++i){
            mat[x][y] = s.charAt(i);
            if(i % t < r - 1){
                ++x;
            }else{
                --x;
                ++y;
            }
        }

        StringBuffer ans = new StringBuffer();
        for (char[] row : mat){
            for(char ch : row){
                if(ch != 0){
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}