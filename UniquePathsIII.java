class UniquePathsIII {
    public int uniquePathsIII(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        int numOfZeros = 0;
        int stRow = 0, stCol = 0;
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 0) {
                    numOfZeros++;
                } else if (grid[i][j] == 1) {
                    stRow = i;
                    stCol = j;
                }
            }
        }

        boolean[][] visit = new boolean[rows][cols];
        AtomicInteger count = new AtomicInteger(0);

        visit[stRow][stCol] = true;

        int[][] directions = new int[][] { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

        for(int i = 0; i < directions.length; i++) {
            dfs(stRow + directions[i][0], stCol + directions[i][1], 0, numOfZeros, count, grid, visit);
        }

        return count.get();
    }

    private void dfs(int row, int col, int zerosCount, int targetZeros, AtomicInteger count, int[][] grid, boolean[][] visit) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == -1 || visit[row][col]) {
            return;
        }

        if(grid[row][col] == 2) {
            if(zerosCount == targetZeros) {
                count.set(count.get() + 1);
            }

            return;
        }

        visit[row][col] = true;

        int[][] directions = new int[][] { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

        for(int i = 0; i < directions.length; i++) {
            dfs(row + directions[i][0], col + directions[i][1], zerosCount + 1, targetZeros, count, grid, visit);
        }

        visit[row][col] = false;
    }
}
