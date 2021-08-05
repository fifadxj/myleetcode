//给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。 
//
// 示例 1: 
//
// 
//输入: [2,2,3,4]
//输出: 3
//解释:
//有效的组合是: 
//2,3,4 (使用第一个 2)
//2,3,4 (使用第二个 2)
//2,2,3
// 
//
// 注意: 
//
// 
// 数组长度不超过1000。 
// 数组里整数的范围为 [0, 1000]。 
// 
// Related Topics 贪心 数组 双指针 二分查找 排序 
// 👍 255 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int left = j + 1;
                int right = nums.length - 1;
                int sum = nums[i] + nums[j];

                int pos = -1;
                while (left <= right) {
                    int mid = (left + right) / 2;

                    if (sum > nums[mid]) {
                        left = mid + 1;
                        pos = mid;
                    } else {
                        right = mid - 1;
                    }
                }
                if (pos != -1) {
                    ans = ans + pos - j;
                }
            }
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
