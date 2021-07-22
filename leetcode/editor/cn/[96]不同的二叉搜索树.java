//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树 
// 👍 1234 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Map<String, Integer> memo = new HashMap<>();

    public int numTrees(int n) {
        return numTrees(1, n);
    }

    public int numTrees(int from, int to) {
        String key = from + "-" + to;

        if (memo.get(key) != null) {
            return memo.get(key);
        }

        if (from >= to) {
            memo.put(key, 1);
            return 1;
        }

        int sum = 0;
        for (int i = from; i <= to; i++) {
            sum = sum + numTrees(from, i - 1) * numTrees(i + 1, to);
        }

        memo.put(key, sum);
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
