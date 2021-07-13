//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 
// 👍 1391 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Map<Integer, char[]> map = new HashMap<>();
    List<String> ans = new ArrayList<>();

    public Solution() {
        map.put(2, new char[] {'a', 'b', 'c'});
        map.put(3, new char[] {'d', 'e', 'f'});
        map.put(4, new char[] {'g', 'h', 'i'});
        map.put(5, new char[] {'j', 'k', 'l'});
        map.put(6, new char[] {'m', 'n', 'o'});
        map.put(7, new char[] {'p', 'q', 'r', 's'});
        map.put(8, new char[] {'t', 'u', 'v'});
        map.put(9, new char[] {'w', 'x', 'y', 'z'});
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        backtrace(digits, "");
        return ans;
    }

    public void backtrace(String digits, String path) {
        if (path.length() == digits.length()) {
            ans.add(path);
            return;
        }

        Integer key = Integer.valueOf(digits.charAt(path.length()) + "");
        char[] chars = map.get(key);

        for (int i = 0; i < chars.length; i++) {
            backtrace(digits, path + (char) chars[i]);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
