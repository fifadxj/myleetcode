//给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。 
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。 
//
// 
//
// 示例 1： 
//
// 
//输入：p = [1,2,3], q = [1,2,3]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：p = [1,2], q = [1,null,2]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：p = [1,2,1], q = [1,1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 两棵树上的节点数目都在范围 [0, 100] 内 
// -104 <= Node.val <= 104 
// 
// Related Topics 树 深度优先搜索 
// 👍 559 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

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
/*class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Integer[] pDfs = bfs(p);
        Integer[] qDfs = bfs(q);

        if (pDfs.length != qDfs.length) {
            return false;
        }

        for (int i = 0; i < pDfs.length; i++) {
            if (! Objects.equals(pDfs[i], qDfs[i])) {
                return false;
            }
        }

        return true;
    }

    private Integer[] bfs(TreeNode node) {
        List<Integer> bfsResult = new ArrayList();
        List<TreeNode> queue = new ArrayList<>();
        queue.add(node);

        while (queue.size() > 0) {
            TreeNode parent = queue.remove(0);
            bfsResult.add(parent != null ? parent.val : null);
            if (parent != null) {
                queue.add(parent.left);
                queue.add(parent.right);
            }
        }

        return bfsResult.toArray(new Integer[bfsResult.size()]);
    }
}*/

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);

        return left && right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
