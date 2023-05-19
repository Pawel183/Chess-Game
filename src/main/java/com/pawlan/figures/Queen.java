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

        var newCord = getCordinate().left();
        while (newCord != null)
        {
            var currentPiece = board.getPiece(newCord);
            if (currentPiece != null) {
                if (currentPiece.getColor() == getColor()) break;
                moves.add(newCord);
                break;
            }

            moves.add(newCord);
            newCord = newCord.left();
        }

        newCord = getCordinate().right();
        while (newCord != null)
        {
            var currentPiece = board.getPiece(newCord);
            if (currentPiece != null) {
                if (currentPiece.getColor() == getColor()) break;
                moves.add(newCord);
                break;
            }

            moves.add(newCord);
            newCord = newCord.right();
        }

        newCord = getCordinate().up();
        while (newCord != null)
        {
            var currentPiece = board.getPiece(newCord);
            if (currentPiece != null) {
                if (currentPiece.getColor() == getColor()) break;
                moves.add(newCord);
                break;
            }

            moves.add(newCord);
            newCord = newCord.up();
        }

        newCord = getCordinate().down();
        while (newCord != null)
        {
            var currentPiece = board.getPiece(newCord);
            if (currentPiece != null) {
                if (currentPiece.getColor() == getColor()) break;
                moves.add(newCord);
                break;
            }

            moves.add(newCord);
            newCord = newCord.down();
        }

        newCord = getCordinate().leftDiagonalUp();
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
