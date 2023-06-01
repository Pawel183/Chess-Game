package com.pawlan.figures;

import com.pawlan.common.Cordinate;
import com.pawlan.map.Board;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

        var piece1 = board.getPiece(Objects.requireNonNull(Objects.requireNonNull(Objects.requireNonNull(getCordinate().left()).left()).left()));
        var piece2 = board.getPiece(Objects.requireNonNull(Objects.requireNonNull(getCordinate().left()).left()));
        var piece3 = board.getPiece(Objects.requireNonNull(getCordinate().left()));
        var piece4 = board.getPiece(Objects.requireNonNull(Objects.requireNonNull(getCordinate().right()).right()));
        var piece5 = board.getPiece(Objects.requireNonNull(getCordinate().right()));

        //Dluga roszada Białych
        if (!board.whiteKingMoved && !board.rookA1Moved) {
            if (piece1 == null && piece2 == null & piece3 == null)
                moves.add(Objects.requireNonNull(getCordinate().left()).left());
        }

        //Krótka roszada białych
        if (!board.whiteKingMoved && !board.rookA8Moved) {
            if (piece4 == null && piece5 == null)
                moves.add(Objects.requireNonNull(getCordinate().right()).right());
        }

        //Długa roszada czarnych
        if (!board.blackKingMoved && !board.rookH1Moved) {
            if (piece1 == null && piece2 == null & piece3 == null)
                moves.add(Objects.requireNonNull(getCordinate().left()).left());
        }

        //Krótka roszada czarnych
        if (!board.blackKingMoved && !board.rookH8Moved) {
            if (piece4 == null && piece5 == null)
                moves.add(Objects.requireNonNull(getCordinate().right()).right());
        }

        return moves;
    }
}
