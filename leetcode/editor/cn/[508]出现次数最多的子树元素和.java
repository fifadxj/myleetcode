//给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。 
//
// 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。 
//
// 
//
// 示例 1： 
//输入: 
//
//   5
// /  \
//2   -3
// 
//
// 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。 
//
// 示例 2： 
//输入： 
//
//   5
// /  \
//2   -5
// 
//
// 返回 [2]，只有 2 出现两次，-5 只出现 1 次。 
//
// 
//
// 提示： 假设任意子树元素和均可以用 32 位有符号整数表示。 
// Related Topics 树 深度优先搜索 哈希表 二叉树 
// 👍 117 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<Integer, Integer> sumCountMap = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        int maxFreq = Integer.MIN_VALUE;
        List<Integer> ans_ = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : sumCountMap.entrySet()) {
            maxFreq = Math.max(maxFreq, entry.getValue());
        }
        for (Map.Entry<Integer, Integer> entry : sumCountMap.entrySet()) {
            if (entry.getValue() == maxFreq) {
                ans_.add(entry.getKey());
            }
        }

        int[] ans = new int[ans_.size()];
        for (int i = 0; i < ans_.size(); i++) {
            ans[i] = ans_.get(i);
         }

        return ans;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int sum = node.val + dfs(node.left) + dfs(node.right);
        int count = sumCountMap.getOrDefault(sum, 0);
        sumCountMap.put(sum, count + 1);

        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
