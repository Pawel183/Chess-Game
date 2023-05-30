package com.pawlan.common;

import org.jetbrains.annotations.Nullable;

public class Cordinate {
    private int x;
    private int y;

    public Cordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public boolean isOutSideMap() {
        return x < 0 || x > 7 || y < 0 || y > 7;
    }

    @Nullable public Cordinate up() {
        var newCord = new Cordinate(x - 1, y);
        if (newCord.isOutSideMap()) return null;

        return newCord;
    }
    @Nullable public Cordinate down() {
        var newCord = new Cordinate(x + 1, y);
        if (newCord.isOutSideMap()) return null;

        return newCord;
    }

    @Nullable public Cordinate left() {
        var newCord = new Cordinate(x, y - 1);
        if (newCord.isOutSideMap()) return null;

        return newCord;
    }

    @Nullable public Cordinate right() {
        var newCord = new Cordinate(x, y + 1);
        if (newCord.isOutSideMap()) return null;

        return newCord;
    }

    @Nullable public Cordinate leftDiagonalUp() {
        var newCord = new Cordinate(x-1, y-1);
        if (newCord.isOutSideMap()) return null;

        return newCord;
    }

    @Nullable public Cordinate leftDiagonalDown() {
        var newCord = new Cordinate(x+1, y-1);
        if (newCord.isOutSideMap()) return null;

        return newCord;
    }

    @Nullable public Cordinate rightDiagonalUp() {
        var newCord = new Cordinate(x-1, y+1);
        if (newCord.isOutSideMap()) return null;

        return newCord;
    }

    @Nullable public Cordinate rightDiagonalDown() {
        var newCord = new Cordinate(x+1, y+1);
        if (newCord.isOutSideMap()) return null;

        return newCord;
    }
}
