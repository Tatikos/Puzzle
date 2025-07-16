# N-Puzzle Game

A Java implementation of the classic sliding puzzle game with both interactive and automatic solving capabilities.

## Features

- **Interactive Play**: Solve the puzzle manually using keyboard controls (u/d/l/r/e)
- **Automatic Solver**: Watch the computer attempt to solve puzzles automatically
- **Dual Graphics**: Choose between text-based console output or StdDraw graphics
- **Configurable Difficulty**: Set puzzle size (N×N) and shuffle complexity
- **Performance Analysis**: View solving statistics including success rates and move counts

## Compilation & Execution

```bash
# Compile (requires stdlib.jar for graphics)
javac -cp \path\to\stdlib.jar NPuzzle.java NPuzzleLib.java

# Run
java -cp \path\to\stdlib.jar NPuzzle N d
```

**Parameters:**
- `N`: Puzzle size (N×N grid)
- `d`: Display mode (0=exit, 1=text, 2=graphics)

## Controls

- `u` - Move up
- `d` - Move down  
- `l` - Move left
- `r` - Move right
- `e` - Exit game

## Author

Giorgos Fotiou (October 2023)