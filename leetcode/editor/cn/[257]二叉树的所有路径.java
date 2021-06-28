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
        List<TreeNode> path = new ArrayList<>();
        path.add(root);
        bfs(root, path);
        return ans;
    }

    public void bfs(TreeNode node, List<TreeNode> path) {
        if (node == null) {
            return;
        }

        //退出条件
        if (node.left == null && node.right == null) {
            //加入结果
            ans.add(path2String(path));
            return;
        }

        //选择
        path.add(node.left);
        bfs(node.left, path);
        //取消选择
        path.remove(node.left);

        //选择
        path.add(node.right);
        bfs(node.right, path);
        //取消选择
        path.remove(node.right);
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
