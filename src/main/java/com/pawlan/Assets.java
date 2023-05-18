package com.pawlan;

import javax.swing.*;
import java.awt.*;

public final class Assets {

    private static Image getScaledImage(Image img) {
        int newWidth = (int) (img.getWidth(null) * 1.3);
        int newHeight = (int) (img.getHeight(null) * 1.3);

        return img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
    }

    public static ImageIcon whitePawn = new ImageIcon(getScaledImage(new ImageIcon(Assets.class.getResource("/wpawn.png")).getImage()));
    public static ImageIcon whiteKnight = new ImageIcon(getScaledImage(new ImageIcon(Assets.class.getResource("/wknight.png")).getImage()));
    public static ImageIcon whiteBishop = new ImageIcon(getScaledImage(new ImageIcon(Assets.class.getResource("/wbishop.png")).getImage()));
    public static ImageIcon whiteRook = new ImageIcon(getScaledImage(new ImageIcon(Assets.class.getResource("/wrook.png")).getImage()));
    public static ImageIcon whiteQueen = new ImageIcon(getScaledImage(new ImageIcon(Assets.class.getResource("/wqueen.png")).getImage()));
    public static ImageIcon whiteKing = new ImageIcon(getScaledImage(new ImageIcon(Assets.class.getResource("/wking.png")).getImage()));
    public static ImageIcon blackPawn = new ImageIcon(getScaledImage(new ImageIcon(Assets.class.getResource("/bpawn.png")).getImage()));
    public static ImageIcon blackKnight = new ImageIcon(getScaledImage(new ImageIcon(Assets.class.getResource("/bknight.png")).getImage()));
    public static ImageIcon blackBishop = new ImageIcon(getScaledImage(new ImageIcon(Assets.class.getResource("/bbishop.png")).getImage()));
    public static ImageIcon blackRook = new ImageIcon(getScaledImage(new ImageIcon(Assets.class.getResource("/brook.png")).getImage()));
    public static ImageIcon blackQueen = new ImageIcon(getScaledImage(new ImageIcon(Assets.class.getResource("/bqueen.png")).getImage()));
    public static ImageIcon blackKing = new ImageIcon(getScaledImage(new ImageIcon(Assets.class.getResource("/bking.png")).getImage()));
}
