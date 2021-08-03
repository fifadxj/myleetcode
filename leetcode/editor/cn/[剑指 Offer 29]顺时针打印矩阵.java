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


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<Integer> ansList = new ArrayList<>();

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        spiralOrder(matrix, 0, rows - 1, 0, cols - 1);

        int[] ans = new int[ansList.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = ansList.get(i);
        }

        return ans;
    }

    void spiralOrder(int[][] matrix, int fromRow, int toRow, int fromCol, int toCol) {
        if (fromRow > toRow || fromCol > toCol) {
            return;
        }

        if (fromRow == toRow) {
            for (int col = fromCol; col <= toCol; col++)  {
                ansList.add(matrix[fromRow][col]);
            }
        } else if (fromCol == toCol) {
            for (int row = fromRow; row <= toRow; row++) {
                ansList.add(matrix[row][toCol]);
            }
        } else {
            for (int col = fromCol; col <= toCol; col++) {
                ansList.add(matrix[fromRow][col]);
            }
            for (int row = fromRow + 1; row <= toRow - 1; row++) {
                ansList.add(matrix[row][toCol]);
            }
            for (int col = toCol; col >= fromCol; col--) {
                ansList.add(matrix[toRow][col]);
            }
            for (int row = toRow - 1; row >= fromRow + 1; row--) {
                ansList.add(matrix[row][fromCol]);
            }
        }

        spiralOrder(matrix, fromRow + 1, toRow - 1, fromCol + 1, toCol - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
