package org.game.domain;

import java.util.ArrayList;
import java.util.List;

public class OrthogonalGridTestUtil {

    public static OrthogonalGrid getATwoByTwoGridWithAllCellsAlive() {
        List<Cell> cells = new ArrayList<Cell>();
        cells.add(new Cell(CellStatus.ALIVE, new Point(0, 0)));
        cells.add(new Cell(CellStatus.ALIVE, new Point(0, 1)));
        cells.add(new Cell(CellStatus.ALIVE, new Point(1, 0)));
        cells.add(new Cell(CellStatus.ALIVE, new Point(1, 1)));

        return new OrthogonalGrid(cells, 1);
    }

    public static OrthogonalGrid getTwoByTwoGridWithTwoCellsAliveAndOthersDead() {
        List<Cell> cells = new ArrayList<Cell>();
        cells.add(new Cell(CellStatus.ALIVE, new Point(0, 0)));
        cells.add(new Cell(CellStatus.ALIVE, new Point(0, 1)));
        cells.add(new Cell(CellStatus.DEAD, new Point(1, 0)));
        cells.add(new Cell(CellStatus.DEAD, new Point(1, 1)));

        return new OrthogonalGrid(cells, 1);
    }

    public static OrthogonalGrid getATwoByTwoGridWithAllCellsDead() {
        List<Cell> cells = new ArrayList<Cell>();
        cells.add(new Cell(CellStatus.DEAD, new Point(0, 0)));
        cells.add(new Cell(CellStatus.DEAD, new Point(0, 1)));
        cells.add(new Cell(CellStatus.DEAD, new Point(1, 0)));
        cells.add(new Cell(CellStatus.DEAD, new Point(1, 1)));

        return new OrthogonalGrid(cells, 1);
    }

    public static OrthogonalGrid getAThreeByThreeGridWithALiveCellSurroundedByMoreThanThreeLiveNeighbours() {
        List<Cell> cells = new ArrayList<Cell>();
        cells.add(new Cell(CellStatus.ALIVE, new Point(0, 0)));
        cells.add(new Cell(CellStatus.ALIVE, new Point(0, 1)));
        cells.add(new Cell(CellStatus.ALIVE, new Point(0, 2)));
        cells.add(new Cell(CellStatus.ALIVE, new Point(1, 0)));
        cells.add(new Cell(CellStatus.ALIVE, new Point(1, 1)));
        cells.add(new Cell(CellStatus.DEAD, new Point(1, 2)));
        cells.add(new Cell(CellStatus.DEAD, new Point(2, 0)));
        cells.add(new Cell(CellStatus.DEAD, new Point(2, 1)));
        cells.add(new Cell(CellStatus.DEAD, new Point(2, 2)));

        return new OrthogonalGrid(cells, 2);
    }
    public static OrthogonalGrid getExpectedGridWhenALiveCellSurroundedByMorethanThreeNeighbours() {
        List<Cell> cells = new ArrayList<Cell>();
        cells.add(new Cell(CellStatus.ALIVE, new Point(0, 0)));
        cells.add(new Cell(CellStatus.DEAD, new Point(0, 1)));
        cells.add(new Cell(CellStatus.ALIVE, new Point(0, 2)));
        cells.add(new Cell(CellStatus.ALIVE, new Point(1, 0)));
        cells.add(new Cell(CellStatus.DEAD, new Point(1, 1)));
        cells.add(new Cell(CellStatus.ALIVE, new Point(1, 2)));
        cells.add(new Cell(CellStatus.DEAD, new Point(2, 0)));
        cells.add(new Cell(CellStatus.DEAD, new Point(2, 1)));
        cells.add(new Cell(CellStatus.DEAD, new Point(2, 2)));

        return new OrthogonalGrid(cells, 2);
    }

    public static OrthogonalGrid getATwoByTwoGridWithALiveCellSurroundedByOnlyTwoLiveNeighbours() {
        List<Cell> cells = new ArrayList<Cell>();
        cells.add(new Cell(CellStatus.ALIVE, new Point(0, 0)));
        cells.add(new Cell(CellStatus.ALIVE, new Point(0, 1)));
        cells.add(new Cell(CellStatus.ALIVE, new Point(1, 0)));
        cells.add(new Cell(CellStatus.DEAD, new Point(1, 1)));

        return new OrthogonalGrid(cells, 1);
    }
    public static OrthogonalGrid getATwoByTwoGridWithADeadCellSurroundedByExactlyThreeLiveNeighours() {
        return getATwoByTwoGridWithALiveCellSurroundedByOnlyTwoLiveNeighbours();
    }

    public static OrthogonalGrid getAnEmptyGrid() {
        List<Cell> cells = new ArrayList<Cell>();
        return new OrthogonalGrid(cells, 0);
    }
}
