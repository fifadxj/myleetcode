//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 数组 回溯 
// 👍 744 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> candidates = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            candidates.add(nums[i]);
        }
        backtrack(candidates, new ArrayList<>(), candidates.size());
        return ans;
    }

    public void backtrack(List<Integer> candidates, List<Integer> selection, int fullCount) {
        if (selection.size() == fullCount) {
            ans.add(new ArrayList<>(selection));
            return;
        }

        int prev = -99;
        for (int i = 0; i < candidates.size(); i++) {
            if (candidates.get(i) == prev) {
                continue;
            }
            selection.add(candidates.get(i));
            List<Integer> newCandidates = new ArrayList<>(candidates);
            newCandidates.remove(i);
            backtrack(newCandidates, selection, fullCount);
            newCandidates.add(i, candidates.get(i));
            selection.remove(selection.size() - 1);
            prev = candidates.get(i);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
