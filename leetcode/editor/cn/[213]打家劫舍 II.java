//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的
//房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,2]
//输出：3
//解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,1]
//输出：4
//解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 动态规划 
// 👍 709 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        int[] nums_with_first = new int[n - 1];
        System.arraycopy(nums, 0, nums_with_first, 0, n - 1);
        int[] nums_with_last = new int[n - 1];
        System.arraycopy(nums, 1, nums_with_last, 0, n - 1);

        return Math.max(rob_sub(nums_with_first), rob_sub(nums_with_last));
    }

    public int rob_sub(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[n];//dp[i] = 从第i + 1个房屋开始打劫获得的最大收益
        dp[n - 1] = nums[n - 1];//从最后一个房屋开始打劫，能获得的最大收益就是最后一个房屋里的钱
        dp[n - 2] = Math.max(nums[n - 2], nums[n - 1]);//从最后第二个房屋开始打劫，能获得的最大收益就是max(最后第一个房屋, 最后第二个房屋)

        for (int i = n - 3; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);//要么打劫当前房屋接着打劫下下个房屋，要么直接打劫下个房屋
        }

        return dp[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
