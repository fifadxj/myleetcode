//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯 
// 👍 1424 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, new ArrayList<>());

        List<List<Integer>> uniqAns = new ArrayList<>();
        for (int i = 0; i < ans.size(); i++) {
            boolean dup = false;
            for (int j = 0; j < uniqAns.size(); j++) {
                if (same(ans.get(i), uniqAns.get(j))) {
                    dup = true;
                    break;
                }
            }
            if (! dup) {
                uniqAns.add(ans.get(i));
            }
        }

        return uniqAns;
    }

    public void backtrack(int[] candidates, int target, List<Integer> selection) {
        if (target == 0) {
            ans.add(new ArrayList<>(selection));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            selection.add(candidates[i]);
            backtrack(candidates, target - candidates[i], selection);
            selection.remove(selection.size() - 1);
        }
    }

    public boolean same(List<Integer> list1, List<Integer> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }

        list1.sort(null);
        list2.sort(null);
        for (int i = 0; i < list1.size(); i++) {
            if (! list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
