//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 321 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
/*class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>();
        for (int num : nums1) {
            nums1Set.add(num);
        }

        List<Integer> intersection = new LinkedList<>();
        for (int num : nums2) {
            if (nums1Set.contains(num)) {
                nums1Set.remove(num);
                intersection.add(num);
            }
        }

        int[] result = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); i++) {
            result[i] = intersection.get(i);
        }

        return result;
    }
}*/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int ptr1 = 0;
        int ptr2 = 0;
        Set<Integer> result = new HashSet<>();

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
