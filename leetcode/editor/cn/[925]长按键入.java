//你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。 
//
// 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。 
//
// 
//
// 示例 1： 
//
// 输入：name = "alex", typed = "aaleex"
//输出：true
//解释：'alex' 中的 'a' 和 'e' 被长按。
// 
//
// 示例 2： 
//
// 输入：name = "saeed", typed = "ssaaedd"
//输出：false
//解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
// 
//
// 示例 3： 
//
// 输入：name = "leelee", typed = "lleeelee"
//输出：true
// 
//
// 示例 4： 
//
// 输入：name = "laiden", typed = "laiden"
//输出：true
//解释：长按名字中的字符并不是必要的。
// 
//
// 
//
// 提示： 
//
// 
// name.length <= 1000 
// typed.length <= 1000 
// name 和 typed 的字符都是小写字母。 
// 
//
// 
//
// 
// Related Topics 双指针 字符串 
// 👍 185 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        char[] s1 = name.toCharArray();
        char[] s2 = typed.toCharArray();
        int ptr1 = 0;
        int ptr2 = 0;

        while (ptr1 < s1.length && ptr2 < s2.length) {
            if (s1[ptr1] != s2[ptr2]) {
                //如果不相等,name往后退一个字符再和typed的当前字符比
                if (ptr1 == 0) {//name的第一个字符不能往前退
                    return false;
                }
                if (s1[--ptr1] != s2[ptr2]) {
                    return false;
                }
            }
            ptr1++;
            ptr2++;
        }

        if (ptr1 < s1.length) {
            return false;
        } else if (ptr2 < s2.length) {
            //name和typed比对完，typed剩余部分必须和name最后一个字符相等
            for (int i = ptr2; i < s2.length; i++) {
                if (s2[i] != s1[s1.length - 1]) {
                    return false;
                }
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
