//Given an input string s and a pattern p, implement regular expression 
//matching with support for '.' and '*' where: 
//
// 
// '.' Matches any single character. 
// '*' Matches zero or more of the preceding element. 
// 
//
// The matching should cover the entire input string (not partial). 
//
// 
// Example 1: 
//
// 
//Input: s = "aa", p = "a"
//Output: false
//Explanation: "a" does not match the entire string "aa".
// 
//
// Example 2: 
//
// 
//Input: s = "aa", p = "a*"
//Output: true
//Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, 
//by repeating 'a' once, it becomes "aa".
// 
//
// Example 3: 
//
// 
//Input: s = "ab", p = ".*"
//Output: true
//Explanation: ".*" means "zero or more (*) of any character (.)".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 20 
// 1 <= p.length <= 30 
// s contains only lowercase English letters. 
// p contains only lowercase English letters, '.', and '*'. 
// It is guaranteed for each appearance of the character '*', there will be a 
//previous valid character to match. 
// 
// Related Topics String Dynamic Programming Recursion 👍 8545 👎 1311

package com.licongyang.leetcode.editor.en;

/**
 * 时间复杂度：O（m*n），其中m，n分别为s,p的长度
 * 空间复杂度：O（m*n）,存储所有状态使用的空间
 */
//java:Regular Expression Matching
class P10RegularExpressionMatching {
    public static void main(String[] args) {
        Solution solution = new P10RegularExpressionMatching().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            int m = s.length();
            int n = p.length();
            boolean[][] tables = new boolean[m + 1][n + 1];
            tables[0][0] = true;
            for (int i = 0; i <= m; i++) {
                // 为啥j从1开始
                for (int j = 1; j <= n; j++) {
                    // j前一个位置j-1是*
                    if ('*' == p.charAt(j - 1)) {
                        
                        tables[i][j] = tables[i][j - 2];
                        //为啥 j-1 *, 下面匹配时，匹配的 j -2 ,即*前面的
                        if (matches(s, p, i, j - 1)) {
                            tables[i][j] = tables[i][j] || tables[i - 1][j];
                        }
                    } else {
                        if (matches(s, p, i, j)) {
                            tables[i][j] = tables[i - 1][j - 1];
                        }
                    }
                }
            }
            return tables[m][n];
        }

        private boolean matches(String s, String p, int i, int j) {
            // 为啥i = 0 ，是false
            if (0 == i)
                return false;
            if ('.' == p.charAt(j - 1))
                return true;
            return s.charAt(i - 1) == p.charAt(j - 1);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}