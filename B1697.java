package beakjun;
import java.util.*;

public class B1697{
	public static int[] visited;
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();
        visited = new int[100001];
        int result = bfs(n,k);
        
        System.out.print(result);
    }
	public static int bfs(int start, int des) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		int a = 0;
		visited[start] = 1;
		while(!q.isEmpty()) {
			
			a = q.remove();
			
			if(a == des	) {
				return visited[a]-1;
			}
			if(a-1>=0&& visited[a-1] == 0) {
				visited[a-1] = visited[a]+1;
				q.add(a-1);
			}
			if(a+1<100001&&visited[a+1] == 0) {
				visited[a+1] = visited[a]+1;
				q.add(a+1);
			}
			if (2*a <= 100000 && visited[2*a] == 0)
			{
				visited[2*a] = visited[a] + 1;
				q.add(2*a);
			}
			
		}
		return -1;
	}
}