package com.pawlan.figures;

import com.pawlan.common.Cordinate;
import com.pawlan.map.Board;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece{

    public Knight(Cordinate cordinate, PieceColor color, ImageIcon icon) {
        super(cordinate, color, icon);
    }

    @Override
    public List<Cordinate> GetLegalMoves(Board board) {
        var moves = new ArrayList<Cordinate>();

        var knightMovesCords = new ArrayList<Cordinate>();

        var up = getCordinate().up();
        if (up != null) {
            knightMovesCords.add(up.leftDiagonalUp());
            knightMovesCords.add(up.rightDiagonalUp());
        }

        var left = getCordinate().left();
        if (left != null) {
            knightMovesCords.add(left.leftDiagonalUp());
            knightMovesCords.add(left.leftDiagonalDown());
        }

        var right = getCordinate().right();
        if (right != null) {
            knightMovesCords.add(right.rightDiagonalUp());
            knightMovesCords.add(right.rightDiagonalDown());
        }

        var down = getCordinate().down();
        if (down != null) {
            knightMovesCords.add(down.leftDiagonalDown());
            knightMovesCords.add(down.rightDiagonalDown());
        }

        for (Cordinate knightMove : knightMovesCords) {
            if (knightMove != null) {
                var currentPiece = board.getPiece(knightMove);
                if (currentPiece == null || currentPiece.getColor() != getColor()) {
                    moves.add(knightMove);
                }
            }
        }

        return moves;
    }

    @Override
    public boolean isKing() {
        return false;
    }

}
