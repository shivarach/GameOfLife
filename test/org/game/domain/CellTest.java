package org.game.domain;

import org.junit.Assert;
import org.junit.Test;

import java.security.InvalidParameterException;

public class CellTest {

    @Test
    public void shouldVerifyCellStatusIsAlive() {
        Cell cell = new Cell(CellStatus.ALIVE, new Point(0,0));
        Assert.assertEquals(CellStatus.ALIVE, cell.getStatus());
    }

    @Test
    public void shouldVerifyCellStatusIsNotDead() {
        Cell cell = new Cell(CellStatus.ALIVE, new Point(0,0));
        Assert.assertNotEquals(CellStatus.DEAD, cell.getStatus());
    }

    @Test
    public void shouldVerifyTheCellStatusIsDeadWhenNoStatusIsProvidedForCell() {
        Cell cell = new Cell(null, new Point(0,0));
        Assert.assertEquals(CellStatus.DEAD, cell.getStatus());
    }

    @Test (expected = InvalidParameterException.class)
    public void shouldThrowInvalidParameterExceptionWhenPointIsNotPassedToCell() {
        new Cell(CellStatus.DEAD, null);
    }
}
