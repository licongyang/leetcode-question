//Given an integer x, return true if x is palindrome integer. 
//
// An integer is a palindrome when it reads the same backward as forward. 
//
// 
// For example, 121 is a palindrome while 123 is not. 
// 
//
// 
// Example 1: 
//
// 
//Input: x = 121
//Output: true
//Explanation: 121 reads as 121 from left to right and from right to left.
// 
//
// Example 2: 
//
// 
//Input: x = -121
//Output: false
//Explanation: From left to right, it reads -121. From right to left, it 
//becomes 121-. Therefore it is not a palindrome.
// 
//
// Example 3: 
//
// 
//Input: x = 10
//Output: false
//Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
// 
//
// 
// Constraints: 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// 
//Follow up: Could you solve it without converting the integer to a string? 
//Related Topics Math 👍 6319 👎 2196

package com.licongyang.leetcode.editor.en;
//java:Palindrome Number
class P9PalindromeNumber{
    public static void main(String[] args){
        Solution solution = new P9PalindromeNumber().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(int x) {

        //特殊情况：
        // 当x < 0 ,不是回文数
        // 当末尾 = 0 ，不是回文数
        if(x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        // 对半比对
        int revertedNumber = 0;
        while(x > revertedNumber){
            revertedNumber = revertedNumber * 10 + x % 10;
            x = x / 10;
        }
        // 当数字为奇数，可以通过 revertedNumber/10得到去除中间数的数字
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}