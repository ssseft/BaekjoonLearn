import java.util.Scanner;

public class Main {
    public static boolean[][] arr;
    public static boolean[] visited;
    public static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new boolean[n+1][n+1];
        visited = new boolean[n+1];
        count = 0;
        
        for(int i = 0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = true;
            arr[b][a] = true;
        }
        
        dfs(1);
        System.out.print(count);
    }
    
    public static void dfs(int node) {
        visited[node] = true;
        
        for(int i = 1; i < arr.length; i++) {
            if(arr[node][i] && !visited[i]) {
                count++;
                dfs(i);
            }
        }
    }
}
