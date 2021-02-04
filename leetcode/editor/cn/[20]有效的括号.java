//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2131 👎 0


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Stack<Integer> brackets = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                brackets.push(c);
            }
            else {
                if (brackets.empty()) {
                    return false;
                }

                int left = brackets.pop();

                if (left == '(' && c != ')') {
                    return false;
                }
                if (left == '[' && c != ']') {
                    return false;
                }
                if (left == '{' && c != '}') {
                    return false;
                }
            }
        }

        if (brackets.size() != 0) {
            return false;
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
