//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。 
//
// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。 
//
// 示例: 
//
// X X X X
//X O O X
//X X O X
//X O X X
// 
//
// 运行你的函数后，矩阵变为： 
//
// X X X X
//X X X X
//X X X X
//X O X X
// 
//
// 解释: 
//
// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被
//填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 468 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int width;
    int height;
    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }

        width = board[0].length;
        height = board.length;
        int size = width * height + 1;
        int edgeParentIndex = size - 1;
        UnionFindSet unionFindSet = new UnionFindSet(size);

        for (int i = 0; i < height; i++) {
            //第一列
            if (board[i][0] == 'O') {
                unionFindSet.union(key(i, 0), edgeParentIndex);
            }
            //最后一列
            if (board[i][width - 1] == 'O') {
                unionFindSet.union(key(i, width - 1), edgeParentIndex);
            }
        }

        for (int i = 0; i < width; i++) {
            //第一行
            if (board[0][i] == 'O') {
                unionFindSet.union(key(0, i), edgeParentIndex);
            }
            //最后一行
            if (board[height - 1][i] == 'O') {
                unionFindSet.union(key(height - 1, i), edgeParentIndex);
            }
        }


        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == 'O') {
                    if ((i + 1 < height) && board[i + 1][j] == 'O') {
                        unionFindSet.union(key(i + 1, j), key(i, j));
                    }
                    if ((i - 1 >= 0) && board[i - 1][j] == 'O') {
                        unionFindSet.union(key(i - 1, j), key(i, j));
                    }
                    if ((j + 1 < width) && board[i][j + 1] == 'O') {
                        unionFindSet.union(key(i, j + 1), key(i, j));
                    }
                    if ((j - 1 >= 0) && board[i][j - 1] == 'O') {
                        unionFindSet.union(key(i, j - 1), key(i, j));
                    }
                }
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int root = unionFindSet.findRoot(key(i, j));
                int root2 = unionFindSet.findRoot(edgeParentIndex);
                if (root != root2) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    int key(int i, int j) {
        return i * width + j;
    }
}

public class UnionFindSet {
    int[] parent;
    int[] rank;
    int count;

    public UnionFindSet(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
        count = n;
    }

    public boolean union(int x, int y){
        int rootX = findRoot(x);
        int rootY = findRoot(y);
        if(rootX == rootY){
            return false;
        }
        if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            if (rank[rootX] == rank[rootY]) {
                rank[rootY]++;
            }
            parent[rootX] = rootY;
        }

        count--;
        return true;
    }

    public int findRoot(int x){
        if(x == parent[x]) {
            return x;
        }
        parent[x] = findRoot(parent[x]);
        return parent[x];
    }

    public int getCount(){
        return count;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
