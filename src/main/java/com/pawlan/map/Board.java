package com.pawlan.map;

import com.pawlan.Assets;
import com.pawlan.common.Cordinate;
import com.pawlan.figures.*;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Board {

    private final HashMap<Cordinate, Piece> Pieces = new HashMap<>();
    @Nullable private Piece selectedPiece = null;
    private List<Cordinate> legalMoves = new ArrayList<>();

    public Board() {
        this.initBoard();
    }

    @Nullable
    public Piece getPiece(Cordinate cordinate){
        if (cordinate.isOutSideMap())
            return null;

        return Pieces.get(cordinate);
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

        if (piece == null && pieceIsSelected()){
            movePiece(cordinate);
            legalMoves.clear();
        }

        if (piece != null && !pieceIsSelected()) {
            selectPiece(piece);
            legalMoves = piece.GetLegalMoves(this);
        }
    }

    public void selectPiece(@Nullable Piece piece) {
        selectedPiece = piece;
    }

    public boolean pieceIsSelected() { return selectedPiece != null;}

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
