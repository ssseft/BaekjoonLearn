import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer>[] list = new ArrayList[n+1];
		for(int i = 1;i<=n;i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0;i<n-1;i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			list[e].add(s);
		}
		Queue<Integer> q = new ArrayDeque<>();
		for(int i = 1;i<=n;i++) {
			q.add(i);
			boolean[] visited = new boolean[n+1];
			while(!q.isEmpty()) {
				int c = q.poll();
				visited[c] = true;
				for(int next : list[c]) {
					q.add(next);
				}
			}
			boolean ch = true;
			for(int j =1;j<=n;j++) {
				if(!visited[j]) {
					ch = false;
					break;
				}
			}
			if(ch) {
				System.out.print(i);
				return;
			}
		}
		System.out.print(-1);
	}
}