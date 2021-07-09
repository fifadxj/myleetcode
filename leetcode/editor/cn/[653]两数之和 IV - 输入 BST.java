//给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。 
//
// 案例 1: 
//
// 
//输入: 
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//Target = 9
//
//输出: True
// 
//
// 
//
// 案例 2: 
//
// 
//输入: 
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//Target = 28
//
//输出: False
// 
//
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 哈希表 双指针 二叉树 
// 👍 250 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> values = new ArrayList<>();
        bfs(root, values);
        Integer[] numbers = values.toArray(new Integer[values.size()]);

        return twoSum(numbers, k);
    }

    public void bfs(TreeNode node, List<Integer> values) {
        if (node == null) {
            return;
        }
        bfs(node.left, values);
        values.add(node.val);
        bfs(node.right, values);
    }

    public boolean twoSum(Integer[] numbers, int target) {
        int ptr1 = 0;
        int ptr2 = numbers.length - 1;

        while (ptr1 < ptr2) {
            int sum = numbers[ptr1] + numbers[ptr2];
            if (sum == target) {
                return true;
            } else if (sum < target) {
                ptr1++;
            } else if (sum > target) {
                ptr2--;
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
