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

        int startX_WHITE = 6;
        int startX_BLACK = 1;

        if (getColor() == PieceColor.White && getCordinate().x() == startX_WHITE) {
            var up = getCordinate().up();
            var up2 = getCordinate().up().up();
            if (up != null && board.getPiece(up) == null) {
                moves.add(up);
                if (board.getPiece(up2) == null)
                    moves.add(up.up());
            }

            if (getCordinate().y() != 0) {
                var leftDiagonal = getCordinate().leftDiagonalUp();
                assert leftDiagonal != null;
                if (board.getPiece(leftDiagonal) != null && board.getPiece(leftDiagonal).getColor() != PieceColor.White)
                    moves.add(leftDiagonal);
            }

            if (getCordinate().y() != 7) {
                var rightDiagonal = getCordinate().rightDiagonalUp();
                assert rightDiagonal != null;
                if (board.getPiece(rightDiagonal) != null && board.getPiece(rightDiagonal).getColor() != PieceColor.White)
                    moves.add(rightDiagonal);
            }
        }
        else if (getColor() == PieceColor.Black && getCordinate().x() == startX_BLACK) {
            var down = getCordinate().down();
            var down2 = getCordinate().down().down();
            if (down != null && board.getPiece(down) == null) {
                moves.add(down);
                if (board.getPiece(down2) == null)
                    moves.add(down2);
            }

            if (getCordinate().y() != 0) {
                var leftDiagonal = getCordinate().leftDiagonalDown();
                assert leftDiagonal != null;
                if (board.getPiece(leftDiagonal) != null && board.getPiece(leftDiagonal).getColor() != PieceColor.Black)
                    moves.add(leftDiagonal);
            }

            if (getCordinate().y() != 7) {
                var rightDiagonal = getCordinate().rightDiagonalDown();
                assert rightDiagonal != null;
                if (board.getPiece(rightDiagonal) != null && board.getPiece(rightDiagonal).getColor() != PieceColor.Black)
                    moves.add(rightDiagonal);
            }
        }

        else if (getColor() == PieceColor.White){
            var up = getCordinate().up();
            if (up != null && board.getPiece(up) == null)
                moves.add(up);

            var leftDiagonalUp = getCordinate().leftDiagonalUp();
            if (leftDiagonalUp != null && board.getPiece(leftDiagonalUp) != null && board.getPiece(leftDiagonalUp).getColor() == PieceColor.Black)
                moves.add(leftDiagonalUp);

            var rightDiagonalUp = getCordinate().rightDiagonalUp();
            if (rightDiagonalUp != null && board.getPiece(rightDiagonalUp) != null && board.getPiece(rightDiagonalUp).getColor() == PieceColor.Black)
                moves.add(rightDiagonalUp);
        }
        else
        {
            var down = getCordinate().down();
            if (down != null && board.getPiece(down) == null)
                moves.add(down);

            var leftDiagonalDown = getCordinate().leftDiagonalDown();
            if (leftDiagonalDown != null && board.getPiece(leftDiagonalDown) != null && board.getPiece(leftDiagonalDown).getColor() == PieceColor.White)
                moves.add(leftDiagonalDown);

            var rightDiagonalDown = getCordinate().rightDiagonalDown();
            if (rightDiagonalDown != null && board.getPiece(rightDiagonalDown) != null && board.getPiece(rightDiagonalDown).getColor() == PieceColor.White)
                moves.add(rightDiagonalDown);
        }

        return moves;
    }

    @Override
    public boolean isKing() {
        return false;
    }
}
