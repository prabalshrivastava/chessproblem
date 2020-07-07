package com.technogise.chessproblem;

public enum Directions {
    TopLeft(-1, 1),
    Top(0, 1),
    TopRight(1, 1),

    Left(-1, 0),
    Right(1,0),

    BottomLeft(-1, -1),
    Bottom(0, -1),
    BottomRight(1, -1),

    oneOClock(1,2),
    twoOClock(2,1),
    fourOClock(2,-1),
    fiveOClock(1,-2),
    sevenOClock(-1,-2),
    eightOClock(-2,-1),
    tenOClock(-2,1),
    elevenOClock(-1,2);

    int x;
    int y;

    Directions(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
