package main.java.Player;

import main.java.CellState;

public class RemotePlayer extends Player {

    public RemotePlayer(CellState figure) {
        super("default", figure);
    }

    private int getID() {
        int id = 0;
        for (int i = 0; i < 10; i++) {
            id += Math.random() * 2000 ;
        }
        return id;
    }

}
