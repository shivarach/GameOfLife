package org.game;

import org.game.domain.OrthogonalGrid;

public class Game {
    private OrthogonalGrid grid;

    public Game(OrthogonalGrid orthogonalGrid) {
        this.grid = orthogonalGrid;
    }

    public OrthogonalGrid play() {
        grid.nextState();
        return grid;
    }


}
