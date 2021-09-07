package ru.job4j.condition;

public class ChessBoard {
    public static int way(int x1, int y1, int x2, int y2) {
        int rsl = 0;
        int x = Math.abs(x2 - x1);
        int y = Math.abs(y2 - y1);
        int max = 7;
        int min = 0;
        if (x == y) {
            if (x1 <= max && x2 <= max && y1 <= max && y2 <= max) {
                if (x1 >= min && x2 >= min && y1 >= min && y2 >= min) {
                    rsl = y;
                }
            }
        }

        return rsl;
    }

    public static void main(String[] args) {
        int x1 = 0;
        int x2 = 7;
        int y1 = 7;
        int y2 = 0;
        int res = ChessBoard.way(x1, y1, x2, y2);
        System.out.println(res);
    }

}
