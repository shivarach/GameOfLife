package org.game;

import org.game.domain.Cell;
import org.game.domain.CellStatus;
import org.game.domain.OrthogonalGrid;
import org.game.domain.Point;


public class GameOfLife {
    private OrthogonalGrid grid;

    public GameOfLife(OrthogonalGrid grid) {
        this.grid = grid;
    }

    public OrthogonalGrid getNextStateGrid() {
        int gridSize = grid.getCurrentGridSize();
        Cell[][] cells = new Cell[gridSize][gridSize];
        for(int xCoordinate = 0; xCoordinate < gridSize; xCoordinate++) {
            for(int yCoordinate = 0; yCoordinate < gridSize; yCoordinate++) {
                setCellState(cells, xCoordinate, yCoordinate);
            }
        }
        this.grid = new OrthogonalGrid(cells, gridSize);
        return this.grid;
    }

    private void setCellState(Cell[][] cells, int xCoordinate, int yCoordinate) {
        Point point = new Point(xCoordinate, yCoordinate);
        int numberOfLiveNeighbourCells = grid.getNumberOfLiveNeighbourCells(xCoordinate, yCoordinate);
        CellStatus cellStatus = grid.getCell(xCoordinate, yCoordinate).getStatus();
        if(cellStatus.equals(CellStatus.ALIVE) && numberOfLiveNeighbourCells < 2) {
            cells[xCoordinate][yCoordinate] = new Cell(CellStatus.DEAD, point);
        }
        else if(cellStatus.equals(CellStatus.ALIVE) && numberOfLiveNeighbourCells > 3) {
            cells[xCoordinate][yCoordinate] = new Cell(CellStatus.DEAD, point);
        }
        else if(cellStatus.equals(CellStatus.DEAD) && numberOfLiveNeighbourCells == 3) {
            cells[xCoordinate][yCoordinate] = new Cell(CellStatus.ALIVE, point);
        }
        else {
            cells[xCoordinate][yCoordinate] = new Cell(cellStatus, point);
        }
    }
}
