import org.game.Game;
import org.game.domain.OrthogonalGrid;
import org.junit.Assert;
import org.junit.Test;

public class GameTest {

    @Test
    public void shouldVerifyLiveCellWithFewerThanTwoLiveNeighboursDies() {
        int[][] finalState = {{1, 1}, {1, 2}, {1, 3}};
        OrthogonalGrid expectedOrthogonalGrid = new OrthogonalGrid(finalState);

        int[][] seed = {{0, 0}, {0, 3}, {1, 2}, {2, 0}, {2, 3}};
        OrthogonalGrid intialGrid = new OrthogonalGrid(seed);
        Game game = new Game(intialGrid);
        OrthogonalGrid actualGridAfterFirstPlay = game.play();

        Assert.assertEquals(expectedOrthogonalGrid, actualGridAfterFirstPlay);
    }


    @Test
    public void shouldVerifyLiveCellWithMoreThanThreeLiveNeighboursDiesByOverCrowd() {
        int[][] finalState = {{0, 1}, {0, 2}, {2, 1}, {2, 2}};
        OrthogonalGrid expectedOrthogonalGrid = new OrthogonalGrid(finalState);

        int[][] seed = {{0, 2}, {1, 1}, {1, 2}, {2, 1}, {2, 2}};
        OrthogonalGrid intialGrid = new OrthogonalGrid(seed);
        Game game = new Game(intialGrid);
        OrthogonalGrid actualGridAfterFirstPlay = game.play();

        Assert.assertEquals(expectedOrthogonalGrid, actualGridAfterFirstPlay);
    }
    @Test
    public void shouldVerifyLiveCellWithTwoOrThreeLiveNeighboursUnchanged() {
        int[][] finalState = {{1,1},{1, 2}};
        OrthogonalGrid expectedOrthogonalGrid = new OrthogonalGrid(finalState);

        int[][] seed = {{0, 2}, {1, 2}, {2, 1}};
        OrthogonalGrid intialGrid = new OrthogonalGrid(seed);
        Game game = new Game(intialGrid);
        OrthogonalGrid actualGridAfterFirstPlay = game.play();

        Assert.assertEquals(expectedOrthogonalGrid, actualGridAfterFirstPlay);
    }
    @Test
    public void shouldVerifyDeadCellWithThreeLiveNeighboursComesToLife() {
        int[][] finalState = {{1, 1}, {1, 2}, {2, 1}, {2, 2}};
        OrthogonalGrid expectedOrthogonalGrid = new OrthogonalGrid(finalState);

        int[][] seed = {{1, 1}, {1, 2}, {2, 1}};
        OrthogonalGrid intialGrid = new OrthogonalGrid(seed);
        Game game = new Game(intialGrid);
        OrthogonalGrid actualGridAfterFirstPlay = game.play();

        Assert.assertEquals(expectedOrthogonalGrid, actualGridAfterFirstPlay);
    }

    @Test
    public void shouldVerifyToadPatternTwoPhaseOscillator() {
        int[][] finalState = {{0, 2}, {1, 1}, {1, 4}, {2, 1}, {2, 4}, {3, 3}};
        OrthogonalGrid expectedOrthogonalGrid = new OrthogonalGrid(finalState);

        int[][] seed = {{1, 1}, {1, 2}, {1, 3}, {2, 2}, {2, 3}, {2, 4}};
        OrthogonalGrid intialGrid = new OrthogonalGrid(seed);
        Game game = new Game(intialGrid);
        OrthogonalGrid actualGridAfterFirstPlay = game.play();

        Assert.assertEquals(expectedOrthogonalGrid, actualGridAfterFirstPlay);
    }

}
