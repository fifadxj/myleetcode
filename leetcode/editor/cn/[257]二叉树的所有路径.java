//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索 字符串 二叉树 
// 👍 521 👎 0


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
class Solution {//回溯
    List<String> ans = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        bfs(root, new ArrayList<>());
        return ans;
    }

    public void bfs(TreeNode node, List<TreeNode> path) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            path.add(node);
            ans.add(path2String(path));
            path.remove(node);
            return;
        }

        path.add(node);
        bfs(node.left, path);
        bfs(node.right, path);
        path.remove(node);
    }

    public String path2String(List<TreeNode> path) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < path.size(); i++) {
            if (i > 0) {
                sb.append("->");
            }
            sb.append(path.get(i).val);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
