package main.chessboard;

public class Chessboard {
    private int height;
    private int width;

    public Chessboard(int height, int width) {
        if (height < 2 || width < 2) {
            throw new IllegalArgumentException("Height or width can't be less than 2!");
        } else {
            this.height = height;
            this.width = width;
        }
    }

    public String buildChessboard() {
        StringBuilder chessboard = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i % 2 == 0) chessboard.append("* ");
                else chessboard.append(" *");
            }
            chessboard.append("\n");
        }
        return chessboard.toString();
    }
}
