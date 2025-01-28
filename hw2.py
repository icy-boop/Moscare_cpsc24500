def location(maze):
    num_rows = len(maze)
    num_cols = len(maze[0])

    row, col = 0, 0
    trajectory = [maze[row][col]] 


    while row < num_rows - 1 or col < num_cols - 1:
        if row == num_rows - 1:
            col += 1
        elif col == num_cols - 1:
            row += 1
        else:
            if maze[row + 1][col] < maze[row][col + 1]:
                row += 1  
            else:
                col += 1
        trajectory.append(maze[row][col])

    return trajectory


# Test case based on the problem output that should yield [27, 4, 22, 3, 10, 16, 1, 7, 14, 25, 2]
maze = [
    [27, 4, 22],
    [16, 3, 25],
    [1, 7, 2],
    [10, 14, 9]
]

result = location(maze)
print(result)
