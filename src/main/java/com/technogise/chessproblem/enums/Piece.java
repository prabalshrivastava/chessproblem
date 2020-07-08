package com.technogise.chessproblem.enums;

import java.util.Arrays;
import java.util.List;

import static com.technogise.chessproblem.enums.Directions.*;

public enum Piece {
    KING(Arrays.asList(TopLeft, Top, TopRight, Left, Right, BottomLeft, Bottom, BottomRight), false),
    QUEEN(Arrays.asList(TopLeft, Top, TopRight, Left, Right, BottomLeft, Bottom, BottomRight), true),
    BISHOP(Arrays.asList(TopLeft, TopRight, BottomLeft, BottomRight), true),
    HORSE(Arrays.asList(oneOClock, twoOClock, fourOClock, fiveOClock, sevenOClock, eightOClock, tenOClock, elevenOClock) ,false),
    ROOK(Arrays.asList(Top, Left, Right, Bottom), true),
    PAWN(Arrays.asList(Top), false);

    public final List<Directions> possibleMoves;
    public final boolean acrossBoard;

    Piece(List<Directions> possibleMoves, boolean acrossBoard) {
        this.possibleMoves = possibleMoves;
        this.acrossBoard = acrossBoard;
    }
}
