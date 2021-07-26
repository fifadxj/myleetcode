//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
// 
//
// 示例 2: 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9] 
//
// 
//
// 说明： 
//
// 
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。 
// 我们可以不考虑输出结果的顺序。 
// 
//
// 进阶： 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 
// 👍 525 👎 0


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int ptr1 = 0;
        int ptr2 = 0;
        List<Integer> result = new LinkedList<>();

        while (ptr1 < nums1.length && ptr2 < nums2.length) {
            int n1 = nums1[ptr1];
            int n2 = nums2[ptr2];

            if (n1 == n2) {
                result.add(n1);
                ptr1++;
                ptr2++;
            } else if (n1 < n2) {
                ptr1++;
            } else {
                ptr2++;
            }
        }

        int[] result1 = new int[result.size()];
        int i = 0;
        for (int e : result) {
            result1[i++] = e;
        }

        return result1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
