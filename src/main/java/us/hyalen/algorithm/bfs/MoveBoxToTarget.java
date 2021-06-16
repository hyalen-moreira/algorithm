package us.hyalen.algorithm.bfs;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/*
  Tips:
      Create a Point class
      Create state of moving
      Use Manhattan Distance
      A* algorithm
        Use PriorityQueue to navigate around the grid
      Use Set to register to avoid treat same states
 */
class Point {
    int row;
    int col;

    Point(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class State {
    int distance;
    int moves;
    Point start;
    Point box;

    State(int distance, int moves, Point start, Point box) {
        this.distance = distance;
        this.moves = moves;
        this.box = box;
        this.start = start;
    }
}

public class MoveBoxToTarget {
    private final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int minPushBox(char[][] grid) {
        // Edge cases ...

        Point start = null;
        Point box = null;
        Point target = null;
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> b.distance - a.distance);
        Set<String> visited = new HashSet<>();

        for (int row = 0; row < grid.length; row++)
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 'S')
                    start = new Point(row, col);

                if (grid[row][col] == 'B')
                    box = new Point(row, col);

                if (grid[row][col] == 'T')
                    target = new Point(row, col);
            }

        pq.offer(new State(distance(box, target), 0, start, box));
        visited.add(start.row + ":" + start.col + "|" + box.row + ":" + box.col);

        while (!pq.isEmpty()) {
            State state = pq.poll();

            if (state.box.row == target.row && state.box.col == target.col)
                return state.moves;

            for (int[] direction : DIRECTIONS) {
                
            }
        }

        return -1;
    }

    private int distance(Point box, Point target) {
        return box.row - target.row + box.col - target.col;
    }
}
