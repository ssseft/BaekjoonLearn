import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		Map<Integer,HashSet<Integer>> map = new HashMap<>();
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(map.containsKey(x)) map.get(x).add(y);
			else {
				HashSet<Integer> set = new HashSet<>();
				set.add(y);
				map.put(x,set);
			}
		}
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {0,0});
		int cnt = 0;
		int[] dx = {-2,-1,0,1,2};
		int[] dy = {-2,-1,0,1,2};
		while(!q.isEmpty()) {
			int size = q.size();
			for(int a = 0;a<size;a++) {
				int[] c = q.poll();
				if(c[1]>=T) {
					System.out.print(cnt);
					return;
				}
				for(int i = 0;i<5;i++) {
					int cx = c[0]+dx[i];
					if(cx>=0) {
						if(map.containsKey(cx)) {
							for(int j = 0;j<5;j++) {
								int cy = c[1]+dy[j];
								if(map.get(cx).contains(cy)) {
									q.add(new int[] {cx,cy});
									map.get(cx).remove(cy);
								}
							}
						}
					}
				}
			}
			cnt++;
			
		}
		System.out.print(-1);
	}
}
