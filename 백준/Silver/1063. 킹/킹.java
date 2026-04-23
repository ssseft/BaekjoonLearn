import java.io.*;

public class Main {

    public static boolean isInRange(char col, int row) {
        return col>='A'&&col<='H'&&row>=1&&row<=8;
    }

    public static boolean move(String move, char[] king, char[] rock) {
        int dCol = 0, dRow = 0;

        switch (move) {
            case "R":  dCol = 1; break;
            case "L":  dCol = -1; break;
            case "B":  dRow = -1; break;
            case "T":  dRow = 1; break;
            case "RT": dCol = 1; dRow = 1; break;
            case "LT": dCol = -1; dRow = 1; break;
            case "RB": dCol = 1; dRow = -1; break;
            case "LB": dCol = -1; dRow = -1; break;
        }

        char nextKingCol = (char)(king[0] + dCol);
        int nextKingRow = king[1] - '0' + dRow;

        if (!isInRange(nextKingCol, nextKingRow)) return false;

        if (nextKingCol == rock[0] && nextKingRow == rock[1] - '0') {
            char nextRockCol = (char)(rock[0] + dCol);
            int nextRockRow = rock[1] - '0' + dRow;

            if (!isInRange(nextRockCol, nextRockRow)) return false;
            rock[0] = nextRockCol;
            rock[1] = (char)(nextRockRow + '0');
        }
        king[0] = nextKingCol;
        king[1] = (char)(nextKingRow + '0');

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[2]);

        char[] king = new char[2];
        char[] rock = new char[2];

        king[0] = tokens[0].charAt(0);
        king[1] = tokens[0].charAt(1);

        rock[0] = tokens[1].charAt(0);
        rock[1] = tokens[1].charAt(1);

        for (int i = 0; i < N; i++) {
            String move = br.readLine();
            move(move, king, rock);
        }

        System.out.println(king[0] + "" + king[1]);
        System.out.println(rock[0] + "" + rock[1]);
    }
}