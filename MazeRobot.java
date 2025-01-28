import java.util.ArrayList;
import java.util.List;

public class MazeRobot {
    
    // Method to return the trajectory of the robot
    public static List<Integer> location(int[][] maze) {
        int numRows = maze.length;
        int numCols = maze[0].length;
        
        // Starting position at the top-left corner (0, 0)
        int row = 0, col = 0;
        List<Integer> trajectory = new ArrayList<>();
        
        // Add the starting element to the trajectory
        trajectory.add(maze[row][col]);
        
        // Traverse until reaching the bottom-right corner
        while (row < numRows - 1 || col < numCols - 1) {
            if (row == numRows - 1) {
                // Only the right neighbor exists (last row)
                col++;
            } else if (col == numCols - 1) {
                // Only the below neighbor exists (last column)
                row++;
            } else {
                // Both neighbors exist, choose the smaller one
                if (maze[row + 1][col] < maze[row][col + 1]) {
                    row++;  // Move down
                } else {
                    col++;  // Move right
                }
            }
            // Add the current element to the trajectory
            trajectory.add(maze[row][col]);
        }
        
        return trajectory;
    }

    public static void main(String[] args) {
        // Define the maze
        int[][] maze = {
            {27, 4, 22},
            {16, 3, 25},
            {1, 7, 2},
            {10, 14, 9}
        };
        
        // Call the location method and print the result
        List<Integer> result = location(maze);
        System.out.println(result);  // Expected output: [27, 4, 22, 3, 10, 16, 1, 7, 14, 25, 2]
    }
}
