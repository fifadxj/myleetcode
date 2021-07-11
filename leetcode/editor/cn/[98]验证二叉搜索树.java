//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 1125 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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
    public boolean isValidBST(TreeNode root) {
        return isValid(root).valid;
    }

    public Result isValid(TreeNode node) {
        if (node.left == null && node.right == null) {
            return new Result(true, node.val, node.val);
        }

        int min = node.val;
        int max = node.val;
        if (node.left != null) {
            Result result = isValid(node.left);
            if (! result.valid) {
                return new Result(false);
            }
            min = result.min;
            if (node.val <= result.max) {
                return new Result(false);
            }
        }
        if (node.right != null) {
            Result result = isValid(node.right);
            if (! result.valid) {
                return new Result(false);
            }
            max = result.max;
            if (node.val >= result.min) {
                return new Result(false);
            }
        }
        return new Result(true, min, max);
    }

    class Result {
        int min;
        int max;
        boolean valid;
        Result(boolean valid) {
            this.valid = valid;
        }
        Result(boolean valid, int min, int max) {
            this.valid = valid;
            this.min = min;
            this.max = max;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
