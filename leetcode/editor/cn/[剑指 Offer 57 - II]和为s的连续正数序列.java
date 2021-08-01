//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
// Related Topics 数学 双指针 枚举 
// 👍 298 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> ans = new ArrayList();
        int sum = 0;
        int left = 1;
        int right = 1;

        while (right <= target) {
            sum += right;
            right++;

            if (sum == target && (right - left) >= 2) {
                int[] values = new int[right - left];
                for (int i = left; i < right; i++) {
                    values[i - left] = i;
                }
                ans.add(values);
            }

            while (left < right && sum > target) {
                sum -= left;
                left++;

                if (sum == target && (right - left) >= 2) {
                    int[] values = new int[right - left];
                    for (int i = left; i < right; i++) {
                        values[i - left] = i;
                    }
                    ans.add(values);
                }
            }
        }

        int[][] ans_ = new int[ans.size()][];
        for (int i = 0; i < ans_.length; i++) {
            ans_[i] = ans.get(i);
        }

        return ans_;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
