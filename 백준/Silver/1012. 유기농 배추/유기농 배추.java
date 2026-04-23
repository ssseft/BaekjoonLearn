import java.util.Scanner;

public class Main {
    static int[][] area;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int M = sc.nextInt();
            int N = sc.nextInt();
            int K = sc.nextInt();

            area = new int[M][N];
            visited = new boolean[M][N];
            int earthworm = 0;

            for (int j = 0; j < K; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                area[x][y] = 1;
            }

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (area[k][j] == 1 && !visited[k][j]) {
                        earthworm++;
                        dfs(k, j);
                    }
                }
            }

            System.out.println(earthworm);
        }

        sc.close();
    }

    public static void dfs(int N, int M) {
        int[] dx = { 0, 0, -1, 1 };
        int[] dy = { -1, 1, 0, 0 };

        visited[N][M] = true;

        for (int i = 0; i < 4; i++) {
            int dN = N + dx[i];
            int dM = M + dy[i];

            if ((dN > -1 && dN < area.length) && (dM > -1 && dM < area[0].length) && area[dN][dM] == 1 && !visited[dN][dM]) {
                dfs(dN, dM);
            }
        }
    }
}
