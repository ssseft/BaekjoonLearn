import java.util.*;

public class Main {
	public static int[] visited;
	public static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();
        
        visited = new int[100001];
        Arrays.fill(visited, Integer.MAX_VALUE);
        count = 0;
        int result = bfs(n,k);
        System.out.println(result);
        System.out.print(count);
    }
	public static int bfs(int start, int des) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = 0;
		int min = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			
			int a = q.remove();
			
			if(a == des	) {
				if(visited[a] == min) {
					count++;
				}
				else if(visited[a]<min) {
					min = visited[a];
					count = 1;
				}
			}
			if(a-1>=0&& visited[a-1] > visited[a]) {
				visited[a-1] = visited[a]+1;
				q.add(a-1);
			}
			if(a+1<100001&&visited[a+1] > visited[a]) {
				visited[a+1] = visited[a]+1;
				q.add(a+1);
			}
			if (2*a < 100001&& visited[2*a] > visited[a])
			{
				visited[2*a] = visited[a] + 1;
				q.add(2*a);
			}
			
		}
		return min;
	}
}
