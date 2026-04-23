import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static int[] count;
    public static int[][] arr;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        count = new int[n];
        
        for (int i = 0; i < n; i++) {
            count[i] = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int des = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            if (cost < arr[start][des]) {
                arr[start][des] = cost;
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken()) - 1;
        int goalCity = Integer.parseInt(st.nextToken()) - 1;

        dijkstra(startCity);
        System.out.print(count[goalCity]);
        
    }

    public static void dijkstra(int start) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        q.add(new int[]{start, 0});
        count[start] = 0;

        while (!q.isEmpty()) {
            int[] data = q.poll();
            int current = data[0];
            int currentDist = data[1];

            if (count[current] < currentDist) {
                continue;
            }

            for (int i = 0; i < n; i++) {
                if (arr[current][i] != Integer.MAX_VALUE) {
                    int nextDist = currentDist + arr[current][i];
                    if (nextDist < count[i]) {
                        count[i] = nextDist;
                        q.add(new int[]{i, nextDist});
                    }
                }
            }
        }
    }
}
