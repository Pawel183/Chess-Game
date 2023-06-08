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

        var directions = new ArrayList<Cordinate>();
        directions.add(getCordinate().up());
        directions.add(getCordinate().rightDiagonalUp());
        directions.add(getCordinate().right());
        directions.add(getCordinate().rightDiagonalDown());
        directions.add(getCordinate().down());
        directions.add(getCordinate().leftDiagonalDown());
        directions.add(getCordinate().left());
        directions.add(getCordinate().leftDiagonalUp());

        for (Cordinate direction : directions) {
            if (direction != null) {
                kingMovesCords.add(direction);
            }
        }

        for (Cordinate kingMove : kingMovesCords) {
            var currentPiece = board.getPiece(kingMove);
            if (currentPiece == null || currentPiece.getColor() != getColor()) {
                moves.add(kingMove);
            }
        }

        if (!board.whiteKingMoved || !board.blackKingMoved) {
            var piece1 = board.getPiece(getCordinate().left().left().left());
            var piece2 = board.getPiece(getCordinate().left().left());
            var piece3 = board.getPiece(getCordinate().left());
            var piece4 = board.getPiece(getCordinate().right().right());
            var piece5 = board.getPiece(getCordinate().right());

            //Dluga roszada Białych
            if (!board.rookA1Moved) {
                if (piece1 == null && piece2 == null & piece3 == null)
                    moves.add(getCordinate().left().left());
            }

            //Krótka roszada białych
            if (!board.rookA8Moved) {
                if (piece4 == null && piece5 == null)
                    moves.add(getCordinate().right().right());
            }

            //Długa roszada czarnych
            if (!board.rookH1Moved) {
                if (piece1 == null && piece2 == null & piece3 == null)
                    moves.add(getCordinate().left().left());
            }

            //Krótka roszada czarnych
            if (!board.rookH8Moved) {
                if (piece4 == null && piece5 == null)
                    moves.add(getCordinate().right().right());
            }
        }
        return moves;
    }
}
