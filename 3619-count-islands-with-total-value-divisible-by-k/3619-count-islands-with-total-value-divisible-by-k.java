
import java.util.*;
class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[][] directions = {
            {-1, 0},  // Up
            {1, 0},   // Down
            {0, -1},  // Left
            {0, 1}    // Right
        };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                long sum = 0;
                Stack<int[]> stack = new Stack<>();
                stack.push(new int[]{i, j});
                sum += grid[i][j];
                grid[i][j] = 0;
                while (!stack.isEmpty()) {
                    int[] cell = stack.pop();
                    int row = cell[0];
                    int col = cell[1];
                    for (int[] dir : directions) {
                        int nr = row + dir[0];
                        int nc = col + dir[1];
                        if (nr >= 0 && nr < m &&
                            nc >= 0 && nc < n &&
                            grid[nr][nc] > 0) {
                            sum += grid[nr][nc];
                            stack.push(new int[]{nr, nc});
                            grid[nr][nc] = 0;
                        }
                    }
                }
                if (sum % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}