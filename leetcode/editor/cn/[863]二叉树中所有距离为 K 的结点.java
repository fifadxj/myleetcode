//给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。 
//
// 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
//输出：[7,4,1]
//解释：
//所求结点为与目标结点（值为 5）距离为 2 的结点，
//值分别为 7，4，以及 1
//
//
//
//注意，输入的 "root" 和 "target" 实际上是树上的结点。
//上面的输入仅仅是对这些对象进行了序列化描述。
// 
//
// 
//
// 提示： 
//
// 
// 给定的树是非空的。 
// 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。 
// 目标结点 target 是树上的结点。 
// 0 <= K <= 1000. 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 383 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

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
    Map<TreeNode, TreeNode> parentMap = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dfs(root.left, root);
        dfs(root.right, root);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        int depth =  0;
        Set<TreeNode> visited = new HashSet<>();

        while (! queue.isEmpty()) {
            int size = queue.size();
            List<Integer> ans = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                visited.add(node);
                ans.add(node.val);
                if (node != root && ! visited.contains(parentMap.get(node))) {
                    queue.offer(parentMap.get(node));
                }
                if (node.left != null && ! visited.contains(node.left)) {
                    queue.offer(node.left);
                }
                if (node.right != null && ! visited.contains(node.right)) {
                    queue.offer(node.right);
                }
            }
            depth++;
            if (depth - 1 == k) {
                return ans;
            }
        }

        return new LinkedList<>();
    }

    void dfs(TreeNode node, TreeNode parent) {
        if (node == null) {
            return;
        }
        parentMap.put(node, parent);
        dfs(node.left, node);
        dfs(node.right, node);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
