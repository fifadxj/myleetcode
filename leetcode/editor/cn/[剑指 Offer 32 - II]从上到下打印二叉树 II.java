//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
//
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-tra
//versal/ 
// Related Topics 树 广度优先搜索 二叉树 
// 👍 124 👎 0


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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<LevelNode> queue = new ArrayList<>();
        List<List<Integer>> bfs = new ArrayList<>();
        queue.add(new LevelNode(root, 1));

        while (queue.size() > 0) {
            LevelNode levelNode = queue.remove(0);
            if (bfs.size() < levelNode.level) {
                bfs.add(new ArrayList<>());
            }
            bfs.get(levelNode.level - 1).add(levelNode.node.val);

            if (levelNode.node.left != null) {
                queue.add(new LevelNode(levelNode.node.left, levelNode.level + 1));
            }
            if (levelNode.node.right != null) {
                queue.add(new LevelNode(levelNode.node.right, levelNode.level + 1));
            }
        }

        return bfs;
    }

    class LevelNode {
        TreeNode node;
        int level;

        LevelNode(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
