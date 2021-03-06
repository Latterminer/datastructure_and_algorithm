package com.wy.leetcode.question1034;

/**
 * @author wangyong
 * @date 2019/6/9
 * @description 给出一个二维整数网格 grid，网格中的每个值表示该位置处的网格块的颜色。
 * <p>
 * 只有当两个网格块的颜色相同，而且在四个方向中任意一个方向上相邻时，它们属于同一连通分量。
 * <p>
 * 连通分量的边界是指连通分量中的所有与不在分量中的正方形相邻（四个方向上）的所有正方形，或者在网格的边界上（第一行/列或最后一行/列）的所有正方形。
 * <p>
 * 给出位于 (r0, c0) 的网格块和颜色 color，使用指定颜色 color 为所给网格块的连通分量的边界进行着色，并返回最终的网格 grid 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[1,1],[1,2]], r0 = 0, c0 = 0, color = 3
 * 输出：[[3, 3], [3, 2]]
 * 示例 2：
 * <p>
 * 输入：grid = [[1,2,2],[2,3,2]], r0 = 0, c0 = 1, color = 3
 * 输出：[[1, 3, 3], [2, 3, 3]]
 * 示例 3：
 * <p>
 * 输入：grid = [[1,1,1],[1,1,1],[1,1,1]], r0 = 1, c0 = 1, color = 2
 * 输出：[[2, 2, 2], [2, 1, 2], [2, 2, 2]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length <= 50
 * 1 <= grid[0].length <= 50
 * 1 <= grid[i][j] <= 1000
 * 0 <= r0 < grid.length
 * 0 <= c0 < grid[0].length
 * 1 <= color <= 1000
 */
public class Solution {
    /**
     * dfs
     * @param grid
     * @param r0
     * @param c0
     * @param color
     * @return
     */
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        boolean[][] edges = new boolean[rows][cols];
        markEdge(grid, r0, c0, grid[r0][c0], visited, edges);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (edges[i][j]) {
                    grid[i][j] = color;
                }
            }
        }
        return grid;
    }

    private void markEdge(int[][] grid, int row, int col, int color, boolean[][] visit, boolean[][] edges) {
        if (row < 0 || row > grid.length-1 || col < 0 || col > grid[0].length-1 || grid[row][col] != color || visit[row][col]) {
            return;
        }
        boolean isEdge = row == 0 || col == 0 || row == grid.length - 1 || col == grid[0].length - 1
                || grid[row - 1][col] != color || grid[row + 1][col] != color
                || grid[row][col - 1] != color || grid[row][col + 1] != color;
        if (isEdge) {
            visit[row][col] = true;
            edges[row][col] = true;
        } else {
            visit[row][col] = true;
        }
        markEdge(grid, row - 1, col, color, visit, edges);
        markEdge(grid, row + 1, col, color, visit, edges);
        markEdge(grid, row, col - 1, color, visit, edges);
        markEdge(grid, row, col + 1, color, visit, edges);
    }
}
