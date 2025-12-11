import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		int jx = 0;
		int jy = 0;
		List<int[]> remove = new ArrayList<>();
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] exist = new boolean[n][m];
		
		for(int i = 0;i<n;i++) {
			String w = sc.nextLine();
			for(int j = 0;j<m;j++) {
				char c = w.charAt(j);
				if(c=='I') {
					jx = i;
					jy = j;
				}
				if(c=='R') {
					q.add(new int[] {i,j});
					exist[i][j] = true;
				}
			}
		}
		char[] op = sc.nextLine().toCharArray();
		int[] dx = {0,1,1,1,0,0,0,-1,-1,-1};
		int[] dy = {0,-1,0,1,-1,0,1,-1,0,1};
		
		
		for(int i = 0;i<op.length;i++) {
			remove.clear();
			
			int d = op[i]-'0';
			jx+=dx[d];
			jy+=dy[d];
			if(exist[jx][jy]) {
				System.out.print("kraj "+(i+1));
				return;
			}
			
			for(int j = 0;j<n;j++) {
				Arrays.fill(exist[j], false);
			}
			
			while(!q.isEmpty()) {
				int[] c = q.poll();
				int cx = c[0];
				int cy = c[1];
				if(cx>jx) cx--;
				else if(cx<jx) cx++;
				
				if(cy>jy) cy--;
				else if(cy<jy) cy++;
				
				
				if(cx==jx&&cy==jy) {
					System.out.print("kraj "+(i+1));
					return;
				}
				if(exist[cx][cy]) {
					remove.add(new int[] {cx,cy});
				}
				else exist[cx][cy] = true;
			}
			for(int[] next : remove) {
				exist[next[0]][next[1]] = false;
			}
			for(int j =0;j<n;j++) {
				for(int k = 0;k<m;k++) {
					if(exist[j][k]&&!remove.contains(new int[] {j,k})) {
						q.add(new int[] {j,k});
					}
				}
			}
		}
		char[][] arr = new char[n][m];
		for(int i = 0;i<n;i++) {
			Arrays.fill(arr[i],'.');
		}
		
		while(!q.isEmpty()) {
			int[] c = q.poll();
			arr[c[0]][c[1]] = 'R';
		}
		
		arr[jx][jy] = 'I';
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
	}
}
