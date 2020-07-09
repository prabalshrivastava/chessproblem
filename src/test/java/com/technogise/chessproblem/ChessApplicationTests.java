package com.technogise.chessproblem;

import com.technogise.chessproblem.chess.Chess;
import com.technogise.chessproblem.dto.Block;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.internal.util.collections.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class ChessApplicationTests {

    @Autowired
    Chess chess;

    //        String input = "King D5";
//        String input = "Queen D5";
//        String input = "Rook D5";
//        String input = "Bishop D5";
    @Test
    void testHorse() {
        String input = "Horse E3";
        validatePositions(input, "F5", "G4", "G2", "F1", "D1", "C2", "C4", "D5");
    }

    @Test
    void testKing() {
        String input = "King D5";
        validatePositions(input, "D6", "E6", "E5", "E4", "D4", "C4", "C5", "C6");
    }

    @Test
    void testQueen() {
        String input = "Queen D5";
        validatePositions(input, "F5", "G4", "G2", "F1", "D1", "C2", "C4", "D5");
    }

    @Test
    void testRook() {
        String input = "Rook D5";
        validatePositions(input, "F5", "G4", "G2", "F1", "D1", "C2", "C4", "D5");
    }

    @Test
    void testBishop() {
        String input = "Bishop D5";
        validatePositions(input, "F5", "G4", "G2", "F1", "D1", "C2", "C4", "D5");
    }


    private void validatePositions(String input, String... labels) {
        List<Block> blocks = chess.runChess(input);
        List<Block> expectedList = getExpectedPostions(labels);
        Assertions.assertTrue(blocks.containsAll(expectedList));
    }

    private List<Block> getExpectedPostions(String... labels) {
        List<Block> blocks = new ArrayList<>();
        for (String label : labels) {
            blocks.add(new Block(label));
        }
        return blocks;
    }


}
