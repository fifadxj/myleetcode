//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 矩阵 模拟 
// 👍 281 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int visitedCount = 0;
        int row = 0;
        int col = 0;

        while (visitedCount < rows * cols) {
            //往右
            while (col < cols && ! visited[row][col]) {
                visitedCount++;
                visited[row][col] = true;
                col++;
            }

            //往下
            while (col < cols && ! visited[row][col]) {
                visitedCount++;
                visited[row][col] = true;
                col++;
            }

            //往左
            while (col < cols && ! visited[row][col]) {
                visitedCount++;
                visited[row][col] = true;
                col++;
            }

            //往上
            while (col < cols && ! visited[row][col]) {
                visitedCount++;
                visited[row][col] = true;
                col++;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
