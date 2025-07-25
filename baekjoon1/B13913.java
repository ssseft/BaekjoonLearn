package beakjoon1;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class B13913 {
	static int n;
	static int k;
	static Queue<Integer> q;
	static Queue<Integer> q2;
	static int[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		sc.close();
		q = new LinkedList<>();
		q.add(n);
		visited = new int[100001];
		visited[n] = 1;
		BFS();
		List<Integer> result = new ArrayList<>();
		int v = visited[k];
		System.out.println(v-1);
		result.add(k);
		while(v>1) {
			if(k-1>=0&&visited[k-1] == v-1) {
				result.add(k-1);
				k--;
			}
			else if(k+1<=100000&&visited[k+1] == v-1) {
				result.add(k+1);
				k++;
			}
			else if(k%2==0&&visited[k/2]==v-1) {
				result.add(k/2);
				k/=2;
			}
			v--;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = result.size()-1;i>=0;i--) {
			sb.append(result.get(i)+" ");
		}
		
		System.out.println(sb.toString().trim());
	}
	static void BFS() {
		while(!q.isEmpty()) {
			int c = q.poll();
			int cv = visited[c];
			if(c==k) break;
			if(c+1<100001&&visited[c+1]==0) {
				q.add(c+1);
				visited[c+1] = cv+1;
			}
			if(c-1>=0&&visited[c-1]==0) {
				q.add(c-1);
				visited[c-1] = cv+1;
			}
			if(c*2<=100000&&visited[c*2]==0) {
				q.add(c*2);
				visited[c*2] = cv+1;
			}
		}
	}
}