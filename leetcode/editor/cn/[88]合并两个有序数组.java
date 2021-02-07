//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nu
//ms2 的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m + n 
// nums2.length == n 
// 0 <= m, n <= 200 
// 1 <= m + n <= 200 
// -109 <= nums1[i], nums2[i] <= 109 
// 
// Related Topics 数组 双指针 
// 👍 756 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        int ptr1 = 0;
        int ptr2 = 0;
        int i = 0;

        while (ptr1 < m && ptr2 < n) {
            if (nums1_copy[ptr1] <= nums2[ptr2]) {
                nums1[i++] = nums1_copy[ptr1++];
            } else {
                nums1[i++] = nums2[ptr2++];
            }
        }

        //一个数组完了，把另一个数组剩余的都加上
        if (ptr2 < n) {
            System.arraycopy(nums2, ptr2, nums1, i, n - ptr2);
            return;
        }
        if (ptr1 < m) {
            System.arraycopy(nums1_copy, ptr1, nums1, i, m - ptr1);
            return;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
