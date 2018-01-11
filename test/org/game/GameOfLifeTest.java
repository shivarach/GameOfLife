package org.game;

import org.game.domain.OrthogonalGrid;
import org.game.domain.OrthogonalGridTestUtil;
import org.junit.Assert;
import org.junit.Test;

public class GameOfLifeTest {

    @Test
    public void shouldVerifyALiveCellWithFewerThanTwoLiveNeighboursDies() {
        OrthogonalGrid actualGrid = OrthogonalGridTestUtil.getTwoByTwoGridWithTwoCellsAliveAndOthersDead();
        GameOfLife gameOfLife = new GameOfLife(actualGrid);
        actualGrid = gameOfLife.getNextStateGrid();
        OrthogonalGrid expectedGrid = OrthogonalGridTestUtil.getATwoByTwoGridWithAllCellsDead();
        Assert.assertEquals(expectedGrid, actualGrid);
    }

    @Test
    public void shouldVerifyALiveCellWithMoreThanThreeLiveNeighboursDies() {
        OrthogonalGrid actualGrid = OrthogonalGridTestUtil.getAThreeByThreeGridWithALiveCellSurroundedByMoreThanThreeLiveNeighbours();
        GameOfLife gameOfLife = new GameOfLife(actualGrid);
        actualGrid = gameOfLife.getNextStateGrid();
        OrthogonalGrid expectedGrid = OrthogonalGridTestUtil.getExpectedGridWhenALiveCellSurroundedByMorethanThreeNeighbours();
        Assert.assertEquals(expectedGrid, actualGrid);
    }

    @Test
    public void shouldVerifyALiveCellWithTwoLiveNeighboursIsUnchanged() {
        OrthogonalGrid actualGrid = OrthogonalGridTestUtil.getATwoByTwoGridWithALiveCellSurroundedByOnlyTwoLiveNeighbours();
        GameOfLife gameOfLife = new GameOfLife(actualGrid);
        actualGrid = gameOfLife.getNextStateGrid();
        OrthogonalGrid expectedGrid = OrthogonalGridTestUtil.getATwoByTwoGridWithAllCellsAlive();
        Assert.assertEquals(expectedGrid, actualGrid);
    }

    @Test
    public void shouldVerifyALiveCellWithThreeLiveNeighboursIsUnchanged() {
        OrthogonalGrid actualGrid = OrthogonalGridTestUtil.getATwoByTwoGridWithAllCellsAlive();
        GameOfLife gameOfLife = new GameOfLife(actualGrid);
        actualGrid = gameOfLife.getNextStateGrid();
        OrthogonalGrid expectedGrid = OrthogonalGridTestUtil.getATwoByTwoGridWithAllCellsAlive();
        Assert.assertEquals(expectedGrid, actualGrid);
    }

    @Test
    public void shouldVerifyADeadCellWithExactlyThreeLiveNeighboursBecomesAlive() {
        OrthogonalGrid actualGrid = OrthogonalGridTestUtil.getATwoByTwoGridWithADeadCellSurroundedByExactlyThreeLiveNeighours();
        GameOfLife gameOfLife = new GameOfLife(actualGrid);
        actualGrid = gameOfLife.getNextStateGrid();
        OrthogonalGrid expectedGrid = OrthogonalGridTestUtil.getATwoByTwoGridWithAllCellsAlive();
        Assert.assertEquals(expectedGrid, actualGrid);
    }

    @Test
    public void shouldVerifyATwoByTwoGridWithAllCellsDeadRemainsUnchanged() {
        OrthogonalGrid actualGrid = OrthogonalGridTestUtil.getATwoByTwoGridWithAllCellsDead();
        GameOfLife gameOfLife = new GameOfLife(actualGrid);
        actualGrid = gameOfLife.getNextStateGrid();
        OrthogonalGrid expectedGrid = OrthogonalGridTestUtil.getATwoByTwoGridWithAllCellsDead();
        Assert.assertEquals(expectedGrid, actualGrid);
    }

}
