//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[
//k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0. 
//
// Notice that the solution set must not contain duplicate triplets. 
//
// 
// Example 1: 
// Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
// Example 2: 
// Input: nums = []
//Output: []
// Example 3: 
// Input: nums = [0]
//Output: []
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics Array Two Pointers Sorting 👍 18820 👎 1811

package com.licongyang.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//java:3Sum

/**
 *   时间复杂度： O(N^2) 省略排序时间
 *   空间复杂度： O(logN) 省略存储答案空间
 */
class P15ThreeSum{
    public static void main(String[] args){
        Solution solution = new P15ThreeSum().new Solution();
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(solution.threeSum(nums));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 数组排序 -4 -1 -1 0 1  2
        // 排序时间复杂度 O（NlogN）
        Arrays.sort(nums);

        // i从左到右遍历数组元素
        // 第一重循环 时间复杂度 O（N）
        for (int i = 0; i < nums.length; i++) {
            // nums[i] > 0 ; break
            if(nums[i] > 0){
                break;
            }
            // nums[i] == nums[i+1] , 去重continue
            // !!! 注意 i 只能是跟遍历过的i-1判断去重，不能跟右边值判断跳过右边
            //  （可能存在未处理但符合情况 -1 -1  0 1 2 -> -1 -1 2）
            //if (i < nums.length -1 && nums[i] == nums[i+1]) continue;
            if (i > 0 && nums[i] == nums[i-1]) continue;
            // 定义l为i+1, r= nums.length -1;
            int l = i + 1, r = nums.length - 1;
            // 根据i，依次l++,r--,判断i后面是否有符合的数据
            // 第二重循环（双指针 时间复杂度O(N)）
            while(l < r){

                // 判断三者和是否为0
                int sum = nums[i] + nums[l] + nums[r];

                if(sum == 0) {
                    // == 0 ，记录到结果链表中；
                    result.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    //       l、r依次右左判断去重
                    while(l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                }else if(sum > 0){
                    // > 0, r--
                    r--;
                }else {
                    // < 0 , l ++
                    l++;
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}