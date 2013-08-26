package com.Player;

abstract public class Player {

    public static final int MAX_SIZE_FIELD = 4;

    public static final int ZERO = 0;

    public abstract void doMove (int x, int y);

    protected boolean checkValue(int x, int y) {
        if ((x > ZERO && y > ZERO) && (x < MAX_SIZE_FIELD && y < MAX_SIZE_FIELD)) {
            return true;
        }
        return false;
    }

}

