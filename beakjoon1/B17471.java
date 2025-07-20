package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17471 {
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		int[] person = new int[n+1];
		
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1;i<=n;i++) {
			person[i] = Integer.parseInt(st.nextToken());
		}
		
		List<List<Integer>> list = new ArrayList<>();
		
		for(int i = 0; i<=n;i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 1; i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for(int j = 0;j<num;j++) {
				int c = Integer.parseInt(st.nextToken());
				list.get(i).add(c);
			}
		}
		
		
		int answer = Integer.MAX_VALUE;
		
		for(int i = 1;i<(1<<n);i++) {
			List<Integer> Agroup = new ArrayList<>();
			List<Integer> Bgroup = new ArrayList<>();
			
			for (int j = 0;j<n;j++) {
		        if ((i&(1<<j))>0)Agroup.add(j+1);
		        else Bgroup.add(j+1);
		    }
			if(Agroup.size()==0||Bgroup.size()==0) continue;
			
			if (isconnect(Agroup, list) && isconnect(Bgroup, list)) {
		        int Asum = Sum(Agroup,person);
		        int Bsum = Sum(Bgroup,person);
		        answer = Math.min(answer, Math.abs(Asum - Bsum));
		    }
		}
		
		if(answer == Integer.MAX_VALUE) System.out.println(-1);
		else {
			System.out.print(answer);
		}
		
	}
	static boolean isconnect(List<Integer> group, List<List<Integer>> list) {
		int cnt = 1;
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[n+1];
		q.add(group.get(0));
		visited[group.get(0)] = true;
		
		while(!q.isEmpty()) {
			int c = q.poll();
			for(int a : list.get(c)) {
				if(group.contains(a)&&!visited[a]) {
					q.add(a);
					visited[a] = true;
					cnt++;
				}
			}
		}
		return cnt==group.size();
	}
	
	static int Sum(List<Integer> group, int[] person) {
		int score = 0;
		for(int i = 0;i<group.size();i++) {
			int c = group.get(i);
			score+=person[c];
		}
		return score;
	}
}
