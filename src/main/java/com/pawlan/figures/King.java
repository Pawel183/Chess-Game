package com.pawlan.figures;

import com.pawlan.common.Cordinate;
import com.pawlan.map.Board;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class King extends Piece {

    public King(Cordinate cordinate, PieceColor color, ImageIcon icon) {
        super(cordinate, color, icon);
    }

    public boolean isKing() {
        return true;
    }

    @Override
    public List<Cordinate> GetLegalMoves(Board board) {
        var moves = new ArrayList<Cordinate>();

        var kingMovesCords = new ArrayList<Cordinate>();

        var up = getCordinate().up();
        if (up != null) kingMovesCords.add(up);

        var rightDiagonalUp = getCordinate().rightDiagonalUp();
        if (rightDiagonalUp != null) kingMovesCords.add(rightDiagonalUp);

        var right = getCordinate().right();
        if (right != null) kingMovesCords.add(right);

        var rightDiagonalDown = getCordinate().rightDiagonalDown();
        if (rightDiagonalDown != null) kingMovesCords.add(rightDiagonalDown);

        var down = getCordinate().down();
        if (down != null) kingMovesCords.add(down);

        var leftDiagonalDown = getCordinate().leftDiagonalDown();
        if (leftDiagonalDown != null) kingMovesCords.add(leftDiagonalDown);

        var left = getCordinate().left();
        if (left != null) kingMovesCords.add(left);

        var leftDiagonalUp = getCordinate().leftDiagonalUp();
        if (leftDiagonalUp != null) kingMovesCords.add(leftDiagonalUp);

        for (Cordinate kingMove : kingMovesCords) {
            if (kingMove != null) {
                var currentPiece = board.getPiece(kingMove);
                if (currentPiece == null || currentPiece.getColor() != getColor()) {
                    moves.add(kingMove);
                }
            }
        }

        return moves;
    }
}
