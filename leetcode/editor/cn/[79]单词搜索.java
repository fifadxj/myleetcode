//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SE
//E"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯 矩阵 
// 👍 956 👎 0


import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        int width = board[0].length;
        int height = board.length;
        boolean[][] selectedGrid = new boolean[height][width];

        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                if (board[row][col] == word.charAt(0)) {
                    selectedGrid[row][col] = true;
                    boolean found = backtrack(board, word, row, col, 1, selectedGrid);
                    if (found) {
                        return true;
                    };
                    selectedGrid[row][col] = false;
                }
            }
        }

        return false;
    }

    public boolean backtrack(char[][] board, String word, int row, int col, int selectedChars, boolean[][] selectedGrid) {
        if (selectedChars == word.length()) {
            return true;
        }

        int width = board[0].length;
        int height = board.length;

        if (row + 1 < height && (! selectedGrid[row + 1][col]) && board[row + 1][col] == word.charAt(selectedChars)) {
            selectedGrid[row + 1][col] = true;
            boolean found = backtrack(board, word, row + 1, col, selectedChars + 1, selectedGrid);
            if (found) {
                return true;
            };
            selectedGrid[row + 1][col] = false;
        }
        if (row - 1 >= 0 && (! selectedGrid[row - 1][col]) && board[row - 1][col] == word.charAt(selectedChars)) {
            selectedGrid[row - 1][col] = true;
            boolean found = backtrack(board, word, row - 1, col, selectedChars + 1, selectedGrid);
            if (found) {
                return true;
            };
            selectedGrid[row - 1][col] = false;
        }
        if (col + 1 < width && (! selectedGrid[row][col + 1]) && board[row][col + 1] == word.charAt(selectedChars)) {
            selectedGrid[row][col + 1] = true;
            boolean found = backtrack(board, word, row, col + 1, selectedChars + 1, selectedGrid);
            if (found) {
                return true;
            };
            selectedGrid[row][col + 1] = false;
        }
        if (col - 1 >= 0 && (! selectedGrid[row][col - 1]) && board[row][col - 1] == word.charAt(selectedChars)) {
            selectedGrid[row][col - 1] = true;
            boolean found = backtrack(board, word, row, col - 1, selectedChars + 1, selectedGrid);
            if (found) {
                return true;
            };
            selectedGrid[row][col - 1] = false;
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
