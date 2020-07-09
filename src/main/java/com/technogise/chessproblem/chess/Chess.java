package com.technogise.chessproblem.chess;

import com.technogise.chessproblem.dto.Block;
import com.technogise.chessproblem.enums.Directions;
import com.technogise.chessproblem.enums.Piece;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class Chess {

    public List<Block> runChess(String input) {
        int n = 8;
        String[] inputArray = input.split(" ");
        String piece = inputArray[0];
        String position = inputArray[1];



        Map<Block, List<Integer>> chessBoard = populateChessBoard(n);
        int xCoordinateOfPiece = position.charAt(0) - 'A' + 1;
        int yCoordinateOfPiece = Integer.parseInt(Character.toString(position.charAt(1)));
        System.out.println(xCoordinateOfPiece + "-" + yCoordinateOfPiece);

        Piece currentPiece = Piece.valueOf(piece.toUpperCase());
        List<Block> possibleBlocks = new ArrayList<>();
        if (!currentPiece.acrossBoard) {
            for (Directions possibleDirections : currentPiece.possibleMoves) {
                addBlock(possibleBlocks, xCoordinateOfPiece + possibleDirections.x, yCoordinateOfPiece + possibleDirections.y);
            }
        } else {
            int possibleXCoordinate;
            int possibleYCoordinate;
            for (Directions possibleDirections : currentPiece.possibleMoves) {
                possibleXCoordinate = xCoordinateOfPiece;
                possibleYCoordinate = yCoordinateOfPiece;
                for (; 0 < possibleXCoordinate && possibleXCoordinate <= n && 0 < possibleYCoordinate && possibleYCoordinate <= n; possibleXCoordinate += possibleDirections.x, possibleYCoordinate += possibleDirections.y) {
                    System.out.print(possibleXCoordinate + "-" + possibleYCoordinate + "\t");
                    addBlock(possibleBlocks, possibleXCoordinate, possibleYCoordinate);
                }
            }
        }
        possibleBlocks.remove(new Block(xCoordinateOfPiece, yCoordinateOfPiece));
        System.out.println("\n" + possibleBlocks);
        printChessBoard(chessBoard, n, possibleBlocks);
        return possibleBlocks;
    }

    public void addBlock(List<Block> possibleBlocks, int possibleXCoordinate, int possibleYCoordinate) {
        Block block = new Block(possibleXCoordinate, possibleYCoordinate);
        if (!possibleBlocks.contains(block))
            possibleBlocks.add(block);
    }

    public Map<Block, List<Integer>> populateChessBoard(int n) {
        Map<Block, List<Integer>> chessboard = new LinkedHashMap<>();
        char characters = (char) ('A' + n);
        for (int j = n; j > 0; j--) {
            for (int i = n; i > 0; i--) {
                chessboard.put(new Block(i, j, String.format("%s%s", (char) (characters - i), j), null), null);
            }
        }
        printChessBoard(chessboard, n, null);
        return chessboard;
    }

    public void printChessBoard(Map<Block, List<Integer>> chessboard, int length, List<Block> possiblePositions) {
        boolean isPlainChessBoard = CollectionUtils.isEmpty(possiblePositions);
        for (Block block : chessboard.keySet()) {
            String s;
            if (isPlainChessBoard) {
                s = block.getLabel() + " ";
            } else {
                if (possiblePositions.contains(block))
                    s = "(" + block.getLabel() + ") ";
                else
                    s = " " + block.getLabel() + "  ";

            }
            System.out.print(s);
            if (StringUtils.equals(String.valueOf((char) (length + 'A' - 1)), block.getLabel().split("")[0])) {
                System.out.println("");
            }
        }
    }

}
