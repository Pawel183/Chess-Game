package com.pawlan.common;

import org.jetbrains.annotations.Nullable;

public record Cordinate(int x, int y) {

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
}
