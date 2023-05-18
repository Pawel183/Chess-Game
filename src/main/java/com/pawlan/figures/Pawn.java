package com.pawlan.figures;

import com.pawlan.common.Cordinate;
import com.pawlan.map.Board;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

    public Pawn(Cordinate cordinate, PieceColor color, ImageIcon icon) {
        super(cordinate, color, icon);
    }

    @Override
    public List<Cordinate> GetLegalMoves(Board board) {

        var moves = new ArrayList<Cordinate>();

        if (getColor() == PieceColor.White)
        {
            var up = getCordinate().up();
            if (up != null) moves.add(up);
        }
        else
        {
            var down = getCordinate().down();
            if (down != null) moves.add(down);
        }

        return moves;
    }
}
