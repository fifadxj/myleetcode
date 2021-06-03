//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
//
//
// 示例 1：
//
//
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
//
//
// 示例 2：
//
//
//输入：nums = [1]
//输出：1
//
//
// 示例 3：
//
//
//输入：nums = [0]
//输出：0
//
//
// 示例 4：
//
//
//输入：nums = [-1]
//输出：-1
//
//
// 示例 5：
//
//
//输入：nums = [-100000]
//输出：-100000
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 3 * 104
// -105 <= nums[i] <= 105
//
//
//
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
// Related Topics 数组 分治算法 动态规划
// 👍 2874 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/*class Solution {
    public int maxSubArray(int[] nums) {
        int to_i_max = 0;//以i为子序结尾的子序max
        int max = Integer.MIN_VALUE;//所有子序max

        for (int i = 0; i < nums.length; i++) {
            to_i_max = Math.max(nums[i], to_i_max + nums[i]);
            max = Math.max(max, to_i_max);
        }

        return max;
    }
}*/

class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];//以i为子序结尾的子序max
        dp[0] = nums[0];
        int max = dp[0];//所有子序max

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
