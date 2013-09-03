/*
Copyright (c) 2013 Evgeniy Dolgikh

See the file LICENSE for copying permission.
*/
package org.hexlet.xo;

import org.hexlet.xo.player.Player;

public interface GameStateListener {
    void onWin(Player player);
    void onDraw();
}
