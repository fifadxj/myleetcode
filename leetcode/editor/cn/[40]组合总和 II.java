//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// Related Topics 数组 回溯 
// 👍 626 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, new ArrayList<>());

        return ans;
    }

    public void backtrack(int[] candidates, int index, int target, List<Integer> selection) {
        if (target == 0) {
            ans.add(new ArrayList<>(selection));
            return;
        }

        if (target < 0) {
            return;
        }

        int prev = 0;
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] == prev) {
                continue;
            }
            selection.add(candidates[i]);
            backtrack(candidates, i + 1, target - candidates[i], selection);
            selection.remove(selection.size() - 1);
            prev = candidates[i];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
