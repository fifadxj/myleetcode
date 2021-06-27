//给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//输出: 6 
//解释: 节点 2 和节点 8 的最近公共祖先是 6。
// 
//
// 示例 2: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//输出: 2
//解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉搜索树中。 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 607 👎 0


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

 //此解法没有利用BST的排序特性。。
class Solution {
    boolean find = false;
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        matchCount(root, p.val, q.val);
        return ans;
    }

    //是p或q的祖先返回1，是p和q的共同祖先返回2, 都不是返回0, 已找到返回0
    public Integer matchCount(TreeNode node, int p, int q) {
        if (find == true) {
            return 0;
        }
        if (node == null) {
            return 0;
        }

        Integer left = matchCount(node.left, p, q);
        Integer right = matchCount(node.right, p, q);

        Integer current = 0;
        if (node.val == p || node.val == q) {
            current = 1;
        }

        int matchCount = left + right + current;
        if (left + right + current >= 2) {
            find = true;
            ans = node;
            return 0;
        }

        return matchCount;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
