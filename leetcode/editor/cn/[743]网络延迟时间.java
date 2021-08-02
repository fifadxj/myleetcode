//有 n 个网络节点，标记为 1 到 n。 
//
// 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， w
//i 是一个信号从源节点传递到目标节点的时间。 
//
// 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：times = [[1,2,1]], n = 2, k = 1
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：times = [[1,2,1]], n = 2, k = 2
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= n <= 100 
// 1 <= times.length <= 6000 
// times[i].length == 3 
// 1 <= ui, vi <= n 
// ui != vi 
// 0 <= wi <= 100 
// 所有 (ui, vi) 对都 互不相同（即，不含重复边） 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 最短路 堆（优先队列） 
// 👍 391 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Map<Integer, List<int[]>> nextsMap = new HashMap();

    public int networkDelayTime(int[][] times, int n, int k) {
        int[] costs = new int[n + 1];
        for (int i = 1; i < costs.length; i++) {
            costs[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < times.length; i++) {
            int[] time = times[i];
            int src = time[0];
            int dest = time[1];
            int cost = time[2];
            List nexts = nextsMap.getOrDefault(src, new ArrayList());
            nexts.add(new int[] {dest, cost});
            nextsMap.put(src, nexts);
        }

        dfs(k, 0, costs);

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < costs.length; i++) {
            max = Math.max(max, costs[i]);
        }

        return max == Integer.MAX_VALUE ? -1 : max;
    }

    void dfs(int node, int totalCost, int[] costs) {
        if (totalCost >= costs[node]) {
            return;
        }

        costs[node] = totalCost;
        List<int[]> nexts = nextsMap.get(node);
        if (nexts != null) {
            for (int i = 0; i < nexts.size(); i++) {
                int[] next = nexts.get(i);
                int dest = next[0];
                int cost = next[1];
                dfs(dest, totalCost + cost, costs);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
