//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例: 
//
// s = "abaccdeff"
//返回 "b"
//
//s = "" 
//返回 " "
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 队列 哈希表 字符串 计数 
// 👍 119 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char firstUniqChar(String s) {
        Map<Integer, Integer> countMap =  new HashMap();
        for (int i = 0; i < s.length(); i++) {
            Integer c = (int) s.charAt(i);
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            Integer c = (int) s.charAt(i);
            if (countMap.get(c) == 1) {
                return s.charAt(i);
            }
        }

        return ' ';
    }
}
//leetcode submit region end(Prohibit modification and deletion)
