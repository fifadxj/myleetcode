//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 966 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        List<String> items = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                char isLands = grid[i][j];
                if (isLands == '1') {
                    items.add(key(i, j));
                }
            }
        }

        UnionFindSet<String> unionFindSet = new UnionFindSet<>(items);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    if ((i + 1 < grid.length) && grid[i + 1][j] == '1') {
                        unionFindSet.union(key(i + 1, j), key(i, j));
                        //System.out.println(key(i + 1, j) + key(i, j));
                    }
                    if ((i - 1 >= 0) && grid[i - 1][j] == '1') {
                        unionFindSet.union(key(i - 1, j), key(i, j));
                        //System.out.println(key(i - 1, j) + key(i, j));
                    }
                    if ((j + 1 < grid[i].length) && grid[i][j + 1] == '1') {
                        unionFindSet.union(key(i, j + 1), key(i, j));
                        //System.out.println(key(i, j + 1) + key(i, j));
                    }
                    if ((j - 1 >= 0) && grid[i][j - 1] == '1') {
                        unionFindSet.union(key(i, j - 1), key(i, j));
                        //System.out.println(key(i, j - 1) + key(i, j));
                    }
                }
            }
        }

        return unionFindSet.getCount();
    }

    String key(int i, int j) {
        return i + "-" + j;
    }
}

class UnionFindSet<K> {
    Map<K, K> parentMap = new HashMap<>();
    Map<K, Integer> rankMap = new HashMap<>();
    int count;

    public UnionFindSet(Iterable<K> items){
        for(K item : items) {
            parentMap.put(item, item);
            rankMap.put(item, 1);
        }
        count = parentMap.size();
    }

    public K findRoot(K key){
        K parent = parentMap.get(key);
        if(key.equals(parent)){
            return key;
        }
        K root = findRoot(parent);
        parentMap.put(key, root);

        return root;
    }

    boolean isSameSet(K x, K y)
    {
        return Objects.equals(findRoot(x), findRoot(y));
    }

    public boolean union(K x, K y){
        K rootX = findRoot(x);
        K rootY = findRoot(y);
        if(Objects.equals(rootX, rootY)){
            return false;
        }

        if(rankMap.get(rootX) > rankMap.get(rootY)){
            parentMap.put(rootY, rootX);
        }
        else{
            if(rankMap.get(rootX) == rankMap.get(rootY)){
                rankMap.put(rootY, rankMap.get(rootY) + 1);
            }
            parentMap.put(rootX, rootY);
        }

        count--;
        return true;
    }

    public int getCount(){
        return count;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
