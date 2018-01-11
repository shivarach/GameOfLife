package org.game.domain;

import java.util.List;
import java.util.Optional;

public class OrthogonalGrid {

    private Cell[][] cells;
    private int currentGridSize;

    public OrthogonalGrid(List<Cell> seed, int maxCoordinate) {
        cells = new Cell[maxCoordinate + 1][maxCoordinate + 1];
        currentGridSize = maxCoordinate + 1;

        for (int xCoordinate = 0; xCoordinate <= maxCoordinate; xCoordinate++) {
            for (int yCoordinate = 0; yCoordinate <= maxCoordinate; yCoordinate++) {
                Point point = new Point(xCoordinate, yCoordinate);
                Optional<Cell> pointFromSeed = getPointFromSeed(point, seed);
                cells[xCoordinate][yCoordinate] = pointFromSeed.isPresent() ?
                        pointFromSeed.get() : new Cell(CellStatus.DEAD, point);
            }
        }
    }

    public OrthogonalGrid(Cell[][] cells, int maxCoordinate) {
        this.cells = cells;
        this.currentGridSize = maxCoordinate;
    }

    public int getNumberOfLiveNeighbourCells(int xCoordinate, int yCoordinate) {
        int liveNeighbours = 0;
        int row = -1, column = -1;
        for (int neighbourRow = -1; neighbourRow <= 1; neighbourRow++) {
            for (int neighbourColumn = -1; neighbourColumn <= 1; neighbourColumn++) {
                row = xCoordinate + neighbourRow;
                column = yCoordinate + neighbourColumn;
                if(isIndexOutOfGrid(row, column))
                    continue;
                if(isCellAlive(row, column))
                    liveNeighbours++;
            }
        }
        return isCellAlive(xCoordinate, yCoordinate) ? --liveNeighbours : liveNeighbours;
    }

    public Cell getCell(int xCoordinate, int yCoordinate) {
        return cells[xCoordinate][yCoordinate];
    }

    public int getCurrentGridSize() {
        return currentGridSize;
    }

    private Optional<Cell> getPointFromSeed(Point point, List<Cell> seed) {
        return seed.stream().filter(cell -> cell.equals(new Cell(CellStatus.ALIVE, point))).findFirst();

    }

    private boolean isCellAlive(int row, int column) {
        if(isIndexOutOfGrid(row, column)) {
            throw new IndexOutOfBoundsException();
        }
        return cells[row][column].getStatus().equals(CellStatus.ALIVE);
    }

    private boolean isIndexOutOfGrid(int row, int column) {
        if(row < 0 || column < 0 || row >= currentGridSize || column >= currentGridSize)
            return true;
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        else if (obj == null || !(obj instanceof OrthogonalGrid))
            return false;
        OrthogonalGrid grid = (OrthogonalGrid) obj;
        if (this.cells == grid.cells)
            return true;
        if(this.cells.length != grid.cells.length)
            return false;
        for (int xCoordinate = 0; xCoordinate < this.currentGridSize; xCoordinate++) {
            for(int yCoordinate = 0; yCoordinate < this.currentGridSize; yCoordinate++) {
                if (!this.cells[xCoordinate][yCoordinate].equals(grid.cells[xCoordinate][yCoordinate]))
                    return false;
            }
        }
        return true;
    }

    public void print() {
       for(int i = 0; i < this.currentGridSize; i++) {
            for(int j = 0; j < this.currentGridSize; j++) {
                System.out.print(cells[i][j].getStatus() + " ");
            }
            System.out.println();
        }

    }
}
