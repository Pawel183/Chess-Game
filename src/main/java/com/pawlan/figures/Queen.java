package com.pawlan.figures;

import com.pawlan.common.Cordinate;
import com.pawlan.map.Board;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {
    public Queen(Cordinate cordinate, PieceColor color, ImageIcon icon) {
        super(cordinate, color, icon);
    }

    @Override
    public List<Cordinate> GetLegalMoves(Board board) {
        var moves = new ArrayList<Cordinate>();

        var directions = new ArrayList<Cordinate>();

        directions.add(getCordinate().left());
        directions.add(getCordinate().right());
        directions.add(getCordinate().down());
        directions.add(getCordinate().up());
        directions.add(getCordinate().leftDiagonalDown());
        directions.add(getCordinate().leftDiagonalUp());
        directions.add(getCordinate().rightDiagonalDown());
        directions.add(getCordinate().rightDiagonalUp());

        for (int i = 0; i < directions.size(); i++) {
            Cordinate newCord = directions.get(i);
            while (newCord != null) {
                var currentPiece = board.getPiece(newCord);
                if (currentPiece != null) {
                    if (currentPiece.getColor() == getColor()) break;
                    moves.add(newCord);
                    break;
                }
                moves.add(newCord);

                if (i == 0) {
                    newCord = newCord.left();
                } else if (i == 1) {
                    newCord = newCord.right();
                } else if (i == 2) {
                    newCord = newCord.down();
                } else if (i == 3) {
                    newCord = newCord.up();
                } else if (i == 4) {
                    newCord = newCord.leftDiagonalDown();
                } else if (i == 5) {
                    newCord = newCord.leftDiagonalUp();
                } else if (i == 6) {
                    newCord = newCord.rightDiagonalDown();
                } else if (i == 7) {
                    newCord = newCord.rightDiagonalUp();
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
