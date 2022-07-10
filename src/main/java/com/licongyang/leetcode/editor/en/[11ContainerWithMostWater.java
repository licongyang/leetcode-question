//You are given an integer array height of length n. There are n vertical lines 
//drawn such that the two endpoints of the iᵗʰ line are (i, 0) and (i, height[i]).
// 
//
// Find two lines that together with the x-axis form a container, such that the 
//container contains the most water. 
//
// Return the maximum amount of water a container can store. 
//
// Notice that you may not slant the container. 
//
// 
// Example 1: 
//
// 
//Input: height = [1,8,6,2,5,4,8,3,7]
//Output: 49
//Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,
//3,7]. In this case, the max area of water (blue section) the container can 
//contain is 49.
// 
//
// Example 2: 
//
// 
//Input: height = [1,1]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// n == height.length 
// 2 <= n <= 10⁵ 
// 0 <= height[i] <= 10⁴ 
// 
// Related Topics Array Two Pointers Greedy 👍 18204 👎 987

package com.licongyang.leetcode.editor.en;
//java:Container With Most Water

/**
 *  时间复杂度：O(N),双指针总计最多遍历整个数组一次
 *  空间复杂度：O(1), 只需要额外的常数级空间
 */
class P11ContainerWithMostWater{
    public static void main(String[] args){
        Solution solution = new P11ContainerWithMostWater().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while(l < r){
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(area, ans);
            if(height[l] <= height[r]){
                l++;
            }else {
                r--;
            }
        }
        return  ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}