//Given a string s, return the longest palindromic substring in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Explanation: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters. 
// 
// Related Topics String Dynamic Programming 👍 19402 👎 1124

package com.licongyang.leetcode.editor.en;

/**
 *  暴力解法
 *  时间复杂度：O(n^3)
 *  空间复杂度：O(1)
 */
//java:Longest Palindromic Substring
class P5LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        String ss = "dabcdcbax";
        System.out.println(solution.longestPalindrome(ss));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        char[] chars;

        public String longestPalindrome(String s) {
            // 暴力解法
            int length = s.length();
            if (length < 2) {
                return s;
            }

            // 只用到了常数个临时变量
            int maxLen = 1;
            int begin = 0;

            chars = s.toCharArray();

            for (int i = 0; i < length - 1; i++) {
                for (int j = i + 1; j < length; j++) {
                    // 两个for里面还有一次遍历（check while）,所以时间复杂度为O(n^3)
                    if (j - i + 1 > maxLen && check(i, j)) {
                        maxLen = j - i + 1;
                        begin = i;
                    }
                }
            }
            return s.substring(begin, begin + maxLen);
        }

        /**
         * 判断是否回文方法，传入字节数组的左右位置
         */
        boolean check(int i, int j) {
            while (i < j) {
                if (chars[i++] != chars[j--]) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}