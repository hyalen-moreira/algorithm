package us.hyalen.algorithm.matrix;

import org.springframework.stereotype.Service;

@Service
public class Solution {
    public int numberOfPaths(int[][] maze) {
        int [][] dp = new int[maze.length][maze[0].length];

        int numLines = maze.length;
        int numColumns = maze[0].length;

        // Fill the lines
        for (int i = 0; i < numLines; i++)
            dp[i][0] = 1;

        // Fill the columns
        for (int i = 0; i < numColumns; i++)
            dp[0][i] = 1;

        for (int i = 1; i < numLines; i++)
            for (int j = 1; j < numColumns; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; // + dp[i - 1][j - 1], if diagonal path is allowed

        return dp[numLines - 1][numColumns - 1];
    }
}
