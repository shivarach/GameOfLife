package org.game.domain;

import java.security.InvalidParameterException;

public class Cell {
    private CellStatus status;
    private Point coordinates;

    public Cell(CellStatus status, Point point) {
        this.status = status == null ? CellStatus.DEAD : status;
        if(point == null) {
            throw new InvalidParameterException("Point should not be null");
        }
        this.coordinates = point;
    }

    public CellStatus getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        else if (obj == null || !(obj instanceof Cell))
            return false;
        Cell cell = (Cell) obj;
        return this.status == cell.status && this.coordinates.equals(cell.coordinates);
    }
}
