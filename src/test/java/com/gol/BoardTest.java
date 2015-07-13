package com.gol;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class BoardTest {

    @Test
    public void board_containsATwoDimensionalArray() {
        Board board = new Board(0, 0);
        assertNotNull(board.getArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void board_hasAConstructorWhichDerivesArraySize() {
        Board board = new Board(10,10);
        int[][] array = board.getArray();
        int exceptionThrower = array[11][1];
    }

    @Test
    public void board_createsALiveCellIfRandomIsLessThanSpecifiedDoubleValue() {
        class TestBoard extends Board {

            public TestBoard(int rows, int columns) {
                super(rows, columns);
            }

            @Override
            protected double generateRandomDouble() {
                return 0.4;
            }
        }

        TestBoard board = new TestBoard(10, 10);
        int[][] boardArray = board.getArray();
        for (int[] rows : boardArray) {
            for (int column : rows) {
                assertEquals(1, column);
            }
        }
    }

    @Test
    public void board_createsADeadCellIfRandomIsMoreThanSpecifiedDoubleValue() {
        class TestBoard extends Board {

            public TestBoard(int rows, int columns) {
                super(rows, columns);
            }

            @Override
            protected double generateRandomDouble() {
                return 0.5;
            }
        }

        TestBoard board = new TestBoard(10, 10);
        int[][] boardArray = board.getArray();
        for (int[] rows : boardArray) {
            for (int column : rows) {
                assertEquals(0, column);
            }
        }
    }

}
