//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 325 👎 0


import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        int ptr1 = 0;
        int ptr2 = s.length() - 1;

        while (ptr1 < ptr2) {
            char char1 = s.charAt(ptr1);
            char char2 = s.charAt(ptr2);

            if (! valid(char1)) {
                ptr1++;
                continue;
            }

            if (! valid(char2)) {
                ptr2--;
                continue;
            }

            if (! String.valueOf(char1).equalsIgnoreCase(String.valueOf(char2))) {
                return false;
            }

            ptr1++;
            ptr2--;
        }

        return true;
    }

    boolean valid(int c) {
        if (c >= 48 && c <= 57) {
            return true;
        }
        if (c >= 65 && c <= 90) {
            return true;
        }
        if (c >= 97 && c <= 122) {
            return true;
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
