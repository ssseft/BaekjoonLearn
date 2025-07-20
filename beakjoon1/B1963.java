package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1963 {
	static boolean check;
	static Queue<Integer> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		boolean[] Prime = new boolean[10001];
		Arrays.fill(Prime, true);
		Prime[0] = false;
		Prime[1] = false;
		for(int i = 2;i<=100;i++) {
			if(Prime[i]) {
				for(int j = i*i;j<=10000;j+=i) {
					Prime[j] = false;
				}
			}
		}
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0;i<t;i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			check = false;
			
			int result = BFS(A,B,Prime);
			if(result ==-1) {
				sb.append("Impossible\n");
			}
			else {
				sb.append(result+"\n");
			}
			
		}
		System.out.print(sb.toString().trim());
		
	}

	static int BFS(int a,int b,boolean[] Prime) {
		q = new LinkedList<>();
		int cnt = 0;
		boolean[] visited = new boolean[10000];
		visited[a] = true;
		q.add(a);
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0;i<size;i++) {
				int c = q.poll();
				if(c==b) return cnt;
				
				for(int j = 0;j<4;j++) {
					char[] arr = String.valueOf(c).toCharArray();
					for(int k = 48;k<58;k++) {
						int before = arr[j];
						arr[j] = (char)k;
						int Newnum = Integer.parseInt(new String(arr));
						if(Newnum>=1000&&Prime[Newnum]&&!visited[Newnum]) {
							q.add(Newnum);
							visited[Newnum]= true;
						}
						Newnum = before;
					}
				}
			}
			cnt++;
		}
		return -1;
	}
}
