package com.gol;

public class Board {

    public final static Double CHANCE_OF_LIFE = 0.5;

    private int[][] array;

    public Board(int rows, int columns) {
        array = new int[rows][columns];
        initialiseBoard();
    }

    public int[][] getArray() {
        return array;
    }

    private void initialiseBoard() {
        for (int[] row : array) {
            iterateThroughColumns(row);
        }
    }

    private void iterateThroughColumns(int[] row) {
        for (int column = 0; column < row.length; column++) {
            deriveIfCellIsDeadOrAlive(row, column);
        }
    }

    private void deriveIfCellIsDeadOrAlive(int[] row, int column) {
        if (generateRandomDouble() < CHANCE_OF_LIFE) {
            row[column] = 1;
        }
    }

    protected double generateRandomDouble() {
        return Math.random();
    }

}
