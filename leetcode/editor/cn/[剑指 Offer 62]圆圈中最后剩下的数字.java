//0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
// 
//
// 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。 
//
// 
//
// 示例 1： 
//
// 
//输入: n = 5, m = 3
//输出: 3
// 
//
// 示例 2： 
//
// 
//输入: n = 10, m = 17
//输出: 2
// 
//
// 
//
// 限制： 
//
// 
// 1 <= n <= 10^5 
// 1 <= m <= 10^6 
// 
// Related Topics 递归 数学 
// 👍 412 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lastRemaining(int n, int m) {
        List<Integer> circle = new ArrayList();
        for (int i = 0; i < n; i++) {
            circle.add(i);
        }

        int i = -1;
        while (circle.size() > 1) {
            i = (i + m) % circle.size();
            Integer num = circle.remove(i);
            i = i - 1;
        }

        return circle.get(0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
