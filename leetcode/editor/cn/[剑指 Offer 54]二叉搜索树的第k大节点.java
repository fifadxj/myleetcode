//给定一棵二叉搜索树，请找出其中第k大的节点。 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 1 ≤ k ≤ 二叉搜索树元素个数 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 174 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int k;
    Integer val = null;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return val;
    }

    public void dfs(TreeNode node) {
        if (k == 0) {
            return;
        }

        if (node == null) {
            return;
        }

        dfs(node.right);
        k = k - 1;
        if (k == 0) {
            val = node.val;
        }
        dfs(node.left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
