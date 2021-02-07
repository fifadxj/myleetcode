//
// 
// 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连
//。 
//
// 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。 
//
// 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 
//isConnected[i][j] = 0 表示二者不直接相连。 
//
// 返回矩阵中 省份 的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 200 
// n == isConnected.length 
// n == isConnected[i].length 
// isConnected[i][j] 为 1 或 0 
// isConnected[i][i] == 1 
// isConnected[i][j] == isConnected[j][i] 
// 
// 
// 
// Related Topics 深度优先搜索 并查集 
// 👍 486 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int cityNum = isConnected[0].length;
        int[] items = new int[cityNum];
        UnionFindSet unionFindSet = new UnionFindSet(cityNum);

        for (int i = 0; i < cityNum; i++) {
            for (int j = 0; j < cityNum; j++) {
                if (isConnected[i][j] == 1) {
                    unionFindSet.union(i, j);
                }
            }
        }

        return unionFindSet.getCount();
    }
}

class UnionFindSet {
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
        int rootX = find(x);
        int rootY = find(y);
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

    public int find(int x){
        if(x == parent[x]) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public int getCount(){
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
