package com.pawlan.figures;

import com.pawlan.common.Cordinate;
import com.pawlan.map.Board;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece{

    public Bishop(Cordinate cordinate, PieceColor color, ImageIcon icon) {
        super(cordinate, color, icon);
    }

    @Override
    public List<Cordinate> GetLegalMoves(Board board) {
        var moves = new ArrayList<Cordinate>();

        var newCord = getCordinate().leftDiagonalUp();
        while (newCord != null)
        {
            var currentPiece = board.getPiece(newCord);
            if (currentPiece != null) {
                if (currentPiece.getColor() == getColor()) break;
                moves.add(newCord);
                break;
            }

            moves.add(newCord);
            newCord = newCord.leftDiagonalUp();
        }

        newCord = getCordinate().rightDiagonalUp();
        while (newCord != null)
        {
            var currentPiece = board.getPiece(newCord);
            if (currentPiece != null) {
                if (currentPiece.getColor() == getColor()) break;
                moves.add(newCord);
                break;
            }

            moves.add(newCord);
            newCord = newCord.rightDiagonalUp();
        }

        newCord = getCordinate().leftDiagonalDown();
        while (newCord != null)
        {
            var currentPiece = board.getPiece(newCord);
            if (currentPiece != null) {
                if (currentPiece.getColor() == getColor()) break;
                moves.add(newCord);
                break;
            }

            moves.add(newCord);
            newCord = newCord.leftDiagonalDown();
        }

        newCord = getCordinate().rightDiagonalDown();
        while (newCord != null)
        {
            var currentPiece = board.getPiece(newCord);
            if (currentPiece != null) {
                if (currentPiece.getColor() == getColor()) break;
                moves.add(newCord);
                break;
            }

            moves.add(newCord);
            newCord = newCord.rightDiagonalDown();
        }
        return moves;
    }
}
