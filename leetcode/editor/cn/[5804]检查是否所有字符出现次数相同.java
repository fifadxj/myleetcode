//给你一个字符串 s ，如果 s 是一个 好 字符串，请你返回 true ，否则请返回 false 。 
//
// 如果 s 中出现过的 所有 字符的出现次数 相同 ，那么我们称字符串 s 是 好 字符串。 
//
// 
//
// 示例 1： 
//
// 输入：s = "abacbc"
//输出：true
//解释：s 中出现过的字符为 'a'，'b' 和 'c' 。s 中所有字符均出现 2 次。
// 
//
// 示例 2： 
//
// 输入：s = "aaabb"
//输出：false
//解释：s 中出现过的字符为 'a' 和 'b' 。
//'a' 出现了 3 次，'b' 出现了 2 次，两者出现次数不同。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 只包含小写英文字母。 
// 
// 👍 0 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean areOccurrencesEqual(String s) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int c = (int) s.charAt(i);
            Integer count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }

        int target = map.get((int) s.charAt(0));
        for (Integer count : map.values()) {
            if (! count.equals(target)) {
                return false;
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
