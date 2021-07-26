//有 n 个朋友在举办一个派对，这些朋友从 0 到 n - 1 编号。派对里有 无数 张椅子，编号为 0 到 infinity 。当一个朋友到达派对时，他会占
//据 编号最小 且未被占据的椅子。 
//
// 
// 比方说，当一个朋友到达时，如果椅子 0 ，1 和 5 被占据了，那么他会占据 2 号椅子。 
// 
//
// 当一个朋友离开派对时，他的椅子会立刻变成未占据状态。如果同一时刻有另一个朋友到达，可以立即占据这张椅子。 
//
// 给你一个下标从 0 开始的二维整数数组 times ，其中 times[i] = [arrivali, leavingi] 表示第 i 个朋友到达和离开的
//时刻，同时给你一个整数 targetFriend 。所有到达时间 互不相同 。 
//
// 请你返回编号为 targetFriend 的朋友占据的 椅子编号 。 
//
// 
//
// 示例 1： 
//
// 输入：times = [[1,4],[2,3],[4,6]], targetFriend = 1
//输出：1
//解释：
//- 朋友 0 时刻 1 到达，占据椅子 0 。
//- 朋友 1 时刻 2 到达，占据椅子 1 。
//- 朋友 1 时刻 3 离开，椅子 1 变成未占据。
//- 朋友 0 时刻 4 离开，椅子 0 变成未占据。
//- 朋友 2 时刻 4 到达，占据椅子 0 。
//朋友 1 占据椅子 1 ，所以返回 1 。
// 
//
// 示例 2： 
//
// 输入：times = [[3,10],[1,5],[2,6]], targetFriend = 0
//输出：2
//解释：
//- 朋友 1 时刻 1 到达，占据椅子 0 。
//- 朋友 2 时刻 2 到达，占据椅子 1 。
//- 朋友 0 时刻 3 到达，占据椅子 2 。
//- 朋友 1 时刻 5 离开，椅子 0 变成未占据。
//- 朋友 2 时刻 6 离开，椅子 1 变成未占据。
//- 朋友 0 时刻 10 离开，椅子 2 变成未占据。
//朋友 0 占据椅子 2 ，所以返回 2 。
// 
//
// 
//
// 提示： 
//
// 
// n == times.length 
// 2 <= n <= 104 
// times[i].length == 2 
// 1 <= arrivali < leavingi <= 105 
// 0 <= targetFriend <= n - 1 
// 每个 arrivali 时刻 互不相同 。 
// 
// 👍 3 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        List<IOTime> ioTimes = new ArrayList<>();
        for (int i = 0; i < times.length; i++) {
            int[] time = times[i];
            ioTimes.add(new IOTime(time[0], true, i));
            ioTimes.add(new IOTime(time[1], false, i));
        }
        ioTimes.sort(null);

        int[] chairs = new int[times.length];
        for (int i = 0; i < chairs.length; i++) {
            chairs[i] = -1;
        }

        for (int i = 0; i < ioTimes.size(); i++) {
            IOTime ioTime = ioTimes.get(i);
            if (ioTime.in) {//进
                for (int j = 0; j < chairs.length; j++) {
                    if (chairs[j] == -1) {
                        if (targetFriend == ioTime.index) {
                            return j;
                        }
                        chairs[j] = ioTime.index;
                        break;
                    }
                }
            } else {//出
                for (int j = 0; j < chairs.length; j++) {
                    if (chairs[j] == ioTime.index) {
                        chairs[j] = -1;
                        break;
                    }
                }
            }
        }

        return -1;
    }

    public static class IOTime implements Comparable<IOTime> {
        Integer time;
        Boolean in;
        Integer index;
        public IOTime(Integer time, Boolean in, Integer index) {
            this.time = time;
            this.in = in;
            this.index = index;
        }

        @Override
        public int compareTo(IOTime o) {
            if (this.time.equals(o.time)) {
                return in ? 1 : -1;
            }
            return this.time.compareTo(o.time);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
