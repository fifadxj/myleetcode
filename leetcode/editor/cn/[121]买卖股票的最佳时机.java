//给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。 
//
// 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。 
//
// 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：[7,1,5,3,6,4]
//输出：5
//解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2： 
//
// 
//输入：prices = [7,6,4,3,1]
//输出：0
//解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 105 
// 0 <= prices[i] <= 104 
// 
// Related Topics 数组 动态规划 
// 👍 1427 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/*class Solution {
    public int maxProfit(int[] prices) {
        int min_before_now = prices[0];//当前i之前的前缀子序列的最小值（历史最低价）
        int max = Integer.MIN_VALUE;//最大收益

        for (int i = 1; i < prices.length; i++) {
            int max_when_sell_now = prices[i] - min_before_now;//当前i卖出,能获得的最大收益
            max = Math.max(max, max_when_sell_now);
            min_before_now = Math.min(min_before_now, prices[i]);
        }

        if (max < 0) {
            max = 0;
        }

        return max;
    }
}*/

/*class Solution {
    public int maxProfit(int[] prices) {
        //dp[i]: 前i天的最大收益
        // 状态转移方程: dp[i] = max(di[i - 1], 在第i天卖出的最大收益)
        //在第i天卖出的最大收益 = 第i天的价格 - 前i-1天中的最小价格
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int min_before_now = prices[0];//之前的历史最低价

        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - min_before_now);
            min_before_now = Math.min(min_before_now, prices[i]);
        }

        return dp[prices.length - 1];
    }
}*/

class Solution {
    //转换为[53]最大子序和问题
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }

        //n+1日和n日的差价
        int[] nums = new int[prices.length - 1];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = prices[i + 1] - prices[i];
        }

        int ans = maxSubArray(nums);

        return ans > 0 ? ans : 0;
    }

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
