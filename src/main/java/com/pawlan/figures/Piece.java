package com.pawlan.figures;

import com.pawlan.common.Cordinate;
import com.pawlan.map.Board;

import javax.swing.*;
import java.util.List;

public abstract class Piece {
    private final PieceColor color;
    private Cordinate cordinate;
    private final ImageIcon Image;

    public Piece(Cordinate cordinate, PieceColor color, ImageIcon icon) {
        this.color = color;
        this.cordinate = cordinate;
        this.Image = icon;
    }

    public PieceColor getColor() {
        return color;
    }

    public ImageIcon getImage() {
        return Image;
    }

    public Cordinate getCordinate() {
        return cordinate;
    }

    public abstract List<Cordinate> GetLegalMoves(Board board);

    public void setCordinate(Cordinate cordinate) {
        this.cordinate = cordinate;
    }

    public abstract boolean isKing();
}
