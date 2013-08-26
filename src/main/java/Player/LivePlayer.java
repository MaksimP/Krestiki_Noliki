package main.java.Player;

import main.java.*;

public class LivePlayer extends Player {

    public LivePlayer(String name, CellState figure) {
        super(name, figure);
    }

    public LivePlayer(CellState figure) {
        this("default", figure);
    }

}