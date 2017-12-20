package org.game.domain;

public class OrthogonalGrid {
    private int[][] grid;

    public OrthogonalGrid(int[][] seed) {
        createAndInitiateGrid(seed);
    }

    private void createAndInitiateGrid(int[][] seed) {
        if (seed == null) {
            grid = new int[0][0];
            return;
        }
        int gridLength = findMaxCoordianteInSeed(seed);
        grid = new int[gridLength + 3][gridLength + 3];
        for (int row = 0; row < seed.length; row++) {
            int currentRow = seed[row][0] + 1;
            int currentColumn = seed[row][1] + 1;
            grid[currentRow][currentColumn] = 1;
        }

    }

    private int findMaxCoordianteInSeed(int[][] seed) {
        int max = 1;
        for (int row = 0; row < seed.length; row++) {
            max = seed[row][0] < max ? max : seed[row][0];
            max = seed[row][1] < max ? max : seed[row][1];
        }
        return max;
    }

    public void nextState() {
        int[][] newGrid = clone(grid);
        int i = 1;
        for (int row = 1; row < newGrid.length - 1; row++) {
            for (int column = 1; column < newGrid[0].length - 1; column++) {
                int liveNeighbours = findNeighbourLiveCells(row, column);
                if (newGrid[row][column] == 1 && liveNeighbours < 2) {
                    newGrid[row][column] = 0;
                } else if (newGrid[row][column] == 1 && liveNeighbours > 3) {
                    newGrid[row][column] = 0;
                } else if (newGrid[row][column] == 0 && liveNeighbours == 3) {
                    newGrid[row][column] = 1;
                }

            }
        }
        grid = newGrid;
    }

    private int[][] clone(int[][] grid) {
        int[][] tempGrid = new int[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                tempGrid[row][column] = grid[row][column];
            }
        }
        return tempGrid;
    }

    private int findNeighbourLiveCells(int row, int column) {
        int liveNeighbours = 0;
        for (int neighbourRow = -1; neighbourRow <= 1; neighbourRow++) {
            for (int neighbourColumn = -1; neighbourColumn <= 1; neighbourColumn++) {
                liveNeighbours += grid[row + neighbourRow][column + neighbourColumn];
            }
        }
        return grid[row][column] == 1 ? --liveNeighbours : liveNeighbours;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        else if (obj == null || !(obj instanceof OrthogonalGrid))
            return false;
        OrthogonalGrid orthogonalGrid = (OrthogonalGrid) obj;
        if (this.grid.length != orthogonalGrid.grid.length)
            return false;
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                if (this.grid[row][column] != orthogonalGrid.grid[row][column]) {
                    return false;
                }
            }
        }
        return true;
    }
}
