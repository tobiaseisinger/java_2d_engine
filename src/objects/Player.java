package objects;

import textures.Sprite;

public class Player extends GameObject {

    public Player(int x, int y, Sprite[][] sprites) {
        super(x, y, sprites);
    }

    @Override
    public void tick() {
        x += 1;
    }
}
