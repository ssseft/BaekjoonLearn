package beakjoon1;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B5014 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = sc.nextInt();
		int current= sc.nextInt();
		int goal = sc.nextInt();
		int up = sc.nextInt();
		int down = sc.nextInt();
		sc.close();
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {current,0});
		boolean[] visited = new boolean[max+1];
		visited[current] = true;
		int result = -1;
		while(!q.isEmpty()) {
			int[] c = q.poll();
			int floor = c[0];
			int cnt = c[1];
			if(floor==goal) {
				result = cnt;
				break;
			}
			if(floor>max) {
				continue;
			}
			if(floor+up<=max&&!visited[floor+up]) {
				q.add(new int[] {floor+up,cnt+1});
				visited[floor+up] = true;
			}
			if(floor-down>=1&&!visited[floor-down]) {
				q.add(new int[] {floor-down,cnt+1});
				visited[floor-down] = true;
			}
		}
		if(result==-1) {
			System.out.print("use the stairs");
		}else {
			System.out.print(result);
		}
	}
}
