package com.technogise.chessproblem;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootApplication
public class ChessproblemApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChessproblemApplication.class, args);
        populateChessBoard();
    }

    private static void populateChessBoard() {
        Map<Block, List<Integer>> chessboard = new LinkedHashMap<>();
        int n = 8;
        char characters = (char) ('A' + n);
        for (int i = n; i > 0; i--) {
            for (int j = n; j > 0; j--) {
                chessboard.put(new Block(i, j, String.format("%s%s", (char) (characters - i), j), null), null);
            }
        }
        printChessBoard(chessboard);
    }

    private static void printChessBoard(Map<Block, List<Integer>> chessboard) {
        for (Block block : chessboard.keySet()) {
            System.out.print(block.getLabel() + " ");
            if (1 == block.getY()) {
                System.out.println("");
            }
        }
    }


}


