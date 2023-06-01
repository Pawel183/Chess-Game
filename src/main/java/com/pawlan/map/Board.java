package com.pawlan.map;

import com.pawlan.Assets;
import com.pawlan.common.Cordinate;
import com.pawlan.figures.*;
import com.pawlan.gui.BoardGUI;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Board {

    private final HashMap<Cordinate, Piece> Pieces = new HashMap<>();
    @Nullable private Piece selectedPiece = null;
    private List<Cordinate> legalMoves = new ArrayList<>();
    private PieceColor playerColor = PieceColor.White;
    public Board() {
        this.initBoard();
    }

    public void switchPlayer() {
        if (playerColor == PieceColor.White)
            playerColor = PieceColor.Black;
        else
            playerColor = PieceColor.White;
    }

    @Nullable
    public Piece getPiece(Cordinate cordinate){
        if (cordinate.isOutSideMap())
            return null;

        return Pieces.get(cordinate);
    }

    public int isKingDead(){
        int whiteKing = 0;
        int blackKing = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                var piece = getPiece(new Cordinate(i,j));

                if (piece != null && piece.isKing() && piece.getColor() == PieceColor.White) {
                    whiteKing = 1;
                } else if (piece != null && piece.isKing() && piece.getColor() == PieceColor.Black) {
                    blackKing = 1;
                }
            }
        }
        if (whiteKing != 1)
            return 2;
        else if (blackKing != 1)
            return 1;
        else
            return 0;
    }

    public void movePiece(Cordinate target)
    {
        if (selectedPiece == null) return;

        var source = selectedPiece.getCordinate();
        selectedPiece.setCordinate(target);
        Pieces.remove(source);
        Pieces.remove(target);
        Pieces.put(target, selectedPiece);
        selectedPiece = null;
    }

    public void handleClick(Cordinate cordinate)
    {
        var piece = getPiece(cordinate);

        if (piece != null && piece.getColor() != playerColor && selectedPiece == null) {     // Kliknięcie nie na swój kolor figury
            legalMoves.clear();
            selectPiece(null);
        }

        if (piece != null && piece.getColor() != playerColor && selectedPiece != null && !legalMoves.contains(cordinate)) {     // Próba ataku na nielegalny ruch
            legalMoves.clear();
            selectPiece(null);
        }

        if (piece != null && piece.getColor() != playerColor && selectedPiece != null && legalMoves.contains(cordinate)) {       // Atak przeciwnej figury
            attack(selectedPiece, piece);
            legalMoves.clear();
            selectPiece(null);
            switchPlayer();
            return;
        }

        if (piece != null && pieceIsSelected() && piece.getColor() == playerColor) {        // Kliknięcie drugi razy z rzędu na swoj kolor figury
            legalMoves.clear();
            selectPiece(null);
        }

        if (piece == null && pieceIsSelected() && !legalMoves.contains(cordinate)) {        // Zły wybór legalnego ruchu
            legalMoves.clear();
            selectPiece(null);
            return;
        }

        if (piece == null && pieceIsSelected() && legalMoves.contains(cordinate)){        // Ruszenie figury
            for (var legalmove : legalMoves) {
                System.out.println(legalmove);
            }
            System.out.println("\n" + cordinate);
            movePiece(cordinate);
            switchPlayer();
            legalMoves.clear();
        }

        if (piece != null && !pieceIsSelected() && piece.getColor() == playerColor) {      // Pierwsze kliknięcie na swój kolor figury
            selectPiece(piece);
            legalMoves = piece.GetLegalMoves(this);
        }

        if (piece != null && ((piece.getColor() == PieceColor.White && piece.getCordinate().x() == 0) ||
                (piece.getColor() == PieceColor.Black && piece.getCordinate().x() == 7))) {
            boolean whitePawnOnLastRow = false;
            boolean blackPawnOnLastRow = false;

            for (int x = 0; x < 8; x++) {
                var pieceOnLastRow = getPiece(new Cordinate(x, 0));
                if (pieceOnLastRow instanceof Pawn && pieceOnLastRow.getColor() == PieceColor.White) {
                    whitePawnOnLastRow = true;
                    break;
                }
            }

            for (int x = 0; x < 8; x++) {
                var pieceOnLastRow = getPiece(new Cordinate(x, 7));
                if (pieceOnLastRow instanceof Pawn && pieceOnLastRow.getColor() == PieceColor.Black) {
                    blackPawnOnLastRow = true;
                    break;
                }
            }

            if (whitePawnOnLastRow || blackPawnOnLastRow) {
                promotion(piece);
            }
        }
    }

    public void promotion(Piece pawn) {
        Cordinate pawnCordinate = pawn.getCordinate();
        Piece promotedPiece;
        if (pawn.getColor() == PieceColor.White) {
            promotedPiece = new Queen(pawnCordinate, pawn.getColor(), Assets.whiteQueen);
        } else {
            promotedPiece = new Queen(pawnCordinate, pawn.getColor(), Assets.blackQueen);
        }

        Pieces.remove(pawnCordinate);
        Pieces.put(pawnCordinate, promotedPiece);
    }


    public void selectPiece(@Nullable Piece piece) {
        selectedPiece = piece;
    }

    public boolean pieceIsSelected() {
        return selectedPiece != null;
    }

    public void attack(Piece attacker, Piece target){
        var targetCordinate = target.getCordinate();

        Pieces.remove(attacker.getCordinate());
        attacker.setCordinate(targetCordinate);
        Pieces.put(targetCordinate, attacker);
        //Pieces.remove(target);
    }

    public void initBoard() {
        Pieces.put(new Cordinate(0, 0), new Rook(new Cordinate(0, 0), PieceColor.Black, Assets.blackRook));
        Pieces.put(new Cordinate(0, 1), new Knight(new Cordinate(0, 1), PieceColor.Black, Assets.blackKnight));
        Pieces.put(new Cordinate(0, 2), new Bishop(new Cordinate(0, 2), PieceColor.Black, Assets.blackBishop));
        Pieces.put(new Cordinate(0, 3), new Queen(new Cordinate(0, 3), PieceColor.Black, Assets.blackQueen));
        Pieces.put(new Cordinate(0, 4), new King(new Cordinate(0, 4), PieceColor.Black, Assets.blackKing));
        Pieces.put(new Cordinate(0, 5), new Bishop(new Cordinate(0, 5), PieceColor.Black, Assets.blackBishop));
        Pieces.put(new Cordinate(0, 6), new Knight(new Cordinate(0, 6), PieceColor.Black, Assets.blackKnight));
        Pieces.put(new Cordinate(0, 7), new Rook(new Cordinate(0, 7), PieceColor.Black, Assets.blackRook));

        for (int y = 0; y < 8; y++) {
            Pieces.put(new Cordinate(1, y), new Pawn(new Cordinate(1, y), PieceColor.Black, Assets.blackPawn));
        }

        for (int y = 0; y < 8; y++) {
            Pieces.put(new Cordinate(6, y), new Pawn(new Cordinate(6, y), PieceColor.White, Assets.whitePawn));
        }

        Pieces.put(new Cordinate(7, 0), new Rook(new Cordinate(7, 0), PieceColor.White, Assets.whiteRook));
        Pieces.put(new Cordinate(7, 1), new Knight(new Cordinate(7, 1), PieceColor.White, Assets.whiteKnight));
        Pieces.put(new Cordinate(7, 2), new Bishop(new Cordinate(7, 2), PieceColor.White, Assets.whiteBishop));
        Pieces.put(new Cordinate(7, 3), new Queen(new Cordinate(7, 3), PieceColor.White, Assets.whiteQueen));
        Pieces.put(new Cordinate(7, 4), new King(new Cordinate(7, 4), PieceColor.White, Assets.whiteKing));
        Pieces.put(new Cordinate(7, 5), new Bishop(new Cordinate(7, 5), PieceColor.White, Assets.whiteBishop));
        Pieces.put(new Cordinate(7, 6), new Knight(new Cordinate(7, 6), PieceColor.White, Assets.whiteKnight));
        Pieces.put(new Cordinate(7, 7), new Rook(new Cordinate(7, 7), PieceColor.White, Assets.whiteRook));
    }

    public List<Cordinate> getLegalMoves() {
        return legalMoves;
    }
}
