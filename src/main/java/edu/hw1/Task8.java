package edu.hw1;

public class Task8 {
    private final static Byte BOARD_SIZE = 8;

    public Boolean areKnightesInSafety(Boolean[][] board) {
        for (byte cellX = 0; cellX < BOARD_SIZE; ++cellX) {
            for (byte cellY = 0; cellY < BOARD_SIZE; ++cellY) {
                if (isHitSomeone(board, cellX, cellY)) {
                    return false;
                }
            }
        }
        return true;
    }

    private final static Byte KNIGHT_FIRST_STEP = 1;
    private final static Byte KNIGHT_SECOND_STEP = 2;

    private Boolean isHitSomeone(Boolean[][] board, Byte cellX, Byte cellY) {
        if (!board[cellX][cellY]) {
            return false;
        }
        Byte[][] beatPlaces = new Byte[][] {
            {(byte) (cellX + KNIGHT_FIRST_STEP), (byte) (cellY + KNIGHT_SECOND_STEP)},
            {(byte) (cellX + KNIGHT_SECOND_STEP), (byte) (cellY + KNIGHT_FIRST_STEP)},
            {(byte) (cellX + KNIGHT_SECOND_STEP), (byte) (cellY - KNIGHT_FIRST_STEP)},
            {(byte) (cellX + KNIGHT_FIRST_STEP), (byte) (cellY - KNIGHT_SECOND_STEP)},
            {(byte) (cellX - KNIGHT_FIRST_STEP), (byte) (cellY - KNIGHT_SECOND_STEP)},
            {(byte) (cellX - KNIGHT_SECOND_STEP), (byte) (cellY - KNIGHT_FIRST_STEP)},
            {(byte) (cellX - KNIGHT_SECOND_STEP), (byte) (cellY + KNIGHT_FIRST_STEP)},
            {(byte) (cellX - KNIGHT_FIRST_STEP), (byte) (cellY + KNIGHT_SECOND_STEP)}
        };
        for (Byte[] place : beatPlaces) {
            if (isPlaceOnBoard(place) && isKnightOnCell(board, place)) {
                return true;
            }
        }
        return false;
    }

    private Boolean isPlaceOnBoard(Byte[] place) {
        Byte placeX = place[0];
        Byte placeY = place[1];
        return (placeX >= 0)
            && (placeX < BOARD_SIZE)
            && (placeY >= 0)
            && (placeY < BOARD_SIZE);
    }

    private Boolean isKnightOnCell(Boolean[][] board, Byte[] cell) {
        Byte cellX = cell[0];
        Byte cellY = cell[1];
        return board[cellX][cellY];
    }
}
