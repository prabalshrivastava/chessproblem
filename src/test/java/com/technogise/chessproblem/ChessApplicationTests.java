package com.technogise.chessproblem;

import com.technogise.chessproblem.chess.Chess;
import com.technogise.chessproblem.dto.Block;
import com.technogise.chessproblem.exception.ChessException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ChessApplicationTests {

    @Autowired
    Chess chess;

    @Test
    void testEmpty() throws ChessException{
        Assertions.assertThrows(ChessException.class, () -> validatePositions("", ""));
    }


    @Test
    void testNull() throws ChessException{
        Assertions.assertThrows(ChessException.class, () -> validatePositions(null, null));
    }

    @Test
    void testHorse() throws ChessException{
        String input = "Horse E3";
        validatePositions(input, "F5", "G4", "G2", "F1", "D1", "C2", "C4", "D5");
    }

    @Test
    void testKing() throws ChessException{
        String input = "King D5";
        validatePositions(input, "D6", "E6", "E5", "E4", "D4", "C4", "C5", "C6");
    }

    @Test
    void testQueen() throws ChessException{
        String input = "Queen D5";
        validatePositions(input, "A8", "D8", "G8", "B7", "D7", "F7", "C6", "D6", "E6", "A5", "B5", "C5", "E5", "F5", "G5", "H5", "C4", "D4", "E4", "B3", "D3", "F3", "A2", "D2", "G2", "D1", "H1");
    }

    @Test
    void testRook() throws ChessException{
        String input = "Rook D5";
        validatePositions(input, "D8", "D7", "D6", "A5", "B5", "C5", "E5", "F5", "G5", "H5", "D4", "D3", "D2", "D1");
    }

    @Test
    void testBishop() throws ChessException{
        String input = "Bishop D5";
        validatePositions(input, "A8", "G8", "B7", "F7", "C6", "E6", "C4", "E4", "B3", "F3", "A2", "G2", "H1");
    }


    private void validatePositions(String input, String... labels) throws ChessException {
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
