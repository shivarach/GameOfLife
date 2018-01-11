package org.game.domain;

public class Point {

    private int xCoordinate;
    private int yCoordinate;

    public Point(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        else if (obj == null || !(obj instanceof Point))
            return false;
        Point point = (Point) obj;
        return this.xCoordinate == point.xCoordinate && this.yCoordinate == point.yCoordinate;
    }

}
