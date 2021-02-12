//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4946 👎 0


import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] a = s.toCharArray();
        Set<Integer> alreadyAppears = new HashSet<>();
        int ptr1 = 0;
        int ptr2 = 0;
        int longest = 0;

        while (ptr2 < a.length) {
            if (! alreadyAppears.contains((int) a[ptr2])) {
                alreadyAppears.add((int) a[ptr2]);
                ptr2++;
                longest = Math.max(longest, ptr2 - ptr1);
            } else {
                while (ptr1 < ptr2) {
                    alreadyAppears.remove((int) a[ptr1]);
                    if (a[ptr1] == a[ptr2]) {
                        ptr1++;
                        break;
                    }
                    ptr1++;
                }
            }
        }

        return longest;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
