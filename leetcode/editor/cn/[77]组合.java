//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 数组 回溯 
// 👍 622 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, 1, k, new ArrayList<>());
        return ans;
    }

    public void backtrack(int n, int index, int k, List<Integer> selection) {
        if (selection.size() == k) {
            ans.add(new ArrayList<>(selection));
            return;
        }

        for (int i = index; i <= n; i++) {
            selection.add(i);
            backtrack(n, i + 1, k, selection);
            selection.remove(selection.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
