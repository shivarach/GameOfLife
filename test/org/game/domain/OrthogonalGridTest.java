package org.game.domain;

import org.junit.Assert;
import org.junit.Test;

public class OrthogonalGridTest {

    @Test
    public void shouldVerifyNumberOfLiveNeighbourCellsAreThreeWhenTheCurrentCellIsLive() {
        OrthogonalGrid grid = OrthogonalGridTestUtil.getATwoByTwoGridWithAllCellsAlive();
        Assert.assertEquals(3, grid.getNumberOfLiveNeighbourCells(0, 0));
    }

    @Test
    public void shouldVerifyNumberOfLiveNeighbourCellsAreThreeWhenTheCurrentCellIsDead() {
        OrthogonalGrid grid = OrthogonalGridTestUtil.getATwoByTwoGridWithADeadCellSurroundedByExactlyThreeLiveNeighours();
        Assert.assertEquals(3, grid.getNumberOfLiveNeighbourCells(1, 1));
    }

    @Test
    public void shouldVerifyNumberOfLiveNeighbourCellsAreZeroWhenAllTheCellsAreDead() {
        OrthogonalGrid grid = OrthogonalGridTestUtil.getATwoByTwoGridWithAllCellsDead();
        Assert.assertEquals(0, grid.getNumberOfLiveNeighbourCells(0, 0));
    }

    @Test
    public void shouldVerifyNumberOfLiveNeighbourCellsAreThreeWhenAllTheCellsAreAlive() {
        OrthogonalGrid grid = OrthogonalGridTestUtil.getATwoByTwoGridWithAllCellsAlive();
        Assert.assertEquals(3, grid.getNumberOfLiveNeighbourCells(0, 0));
    }

    @Test
    public void shouldVerifyGridReturnsExpectedCell() {
        OrthogonalGrid grid = OrthogonalGridTestUtil.getTwoByTwoGridWithTwoCellsAliveAndOthersDead();
        Cell cell = new Cell(CellStatus.ALIVE, new Point(0, 0));
        Cell cell1 = new Cell(CellStatus.ALIVE, new Point(0, 1));
        Cell cell2 = new Cell(CellStatus.DEAD, new Point(1, 0));
        Cell cell3 = new Cell(CellStatus.DEAD, new Point(1, 1));

        Assert.assertEquals(cell, grid.getCell(0, 0));
        Assert.assertEquals(cell1, grid.getCell(0, 1));
        Assert.assertEquals(cell2, grid.getCell(1, 0));
        Assert.assertEquals(cell3, grid.getCell(1, 1));
    }

    @Test
    public void shouldVeirifyTheCurrentGridSizeIsTwo() {
        OrthogonalGrid grid = OrthogonalGridTestUtil.getTwoByTwoGridWithTwoCellsAliveAndOthersDead();
        Assert.assertEquals(2, grid.getCurrentGridSize());
    }

}
