//给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。 
//
// 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,3,null,null,2]
//输出：[3,1,null,null,2]
//解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
// 
//
// 示例 2： 
//
// 
//输入：root = [3,1,4,null,null,2]
//输出：[2,1,4,null,null,3]
//解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。 
//
// 
//
// 提示： 
//
// 
// 树上节点的数目在范围 [2, 1000] 内 
// -231 <= Node.val <= 231 - 1 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 502 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public void recoverTree(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        dfs(root, nodes);

        List<TreeNode> nodes2 = nodes.stream().map(o -> {
            return new TreeNode(o.val, o.left, o.right);
        }).collect(Collectors.toList());
        nodes2.sort((o1, o2) -> {
            return new Integer(o1.val).compareTo(new Integer(o2.val));
        });

        for (int i = 0; i < nodes.size(); i++) {
            TreeNode node = nodes.get(i);
            TreeNode node2 = nodes2.get(i);
            if (node.val != node2.val) {
                node.val = node2.val;
            }
        }
    }

    public void dfs(TreeNode node, List<TreeNode> nodes) {
        if (node == null) {
            return;
        }

        dfs(node.left, nodes);
        nodes.add(node);
        dfs(node.right, nodes);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
