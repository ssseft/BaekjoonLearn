package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B1092 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] crane = new int[n];
		int[] craneidx = new int[n];
		
		for(int i = 0;i<n;i++) {
			crane[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(crane);
		
		int m = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		List<Integer> box = new ArrayList<>();
		for(int i = 0;i<m;i++) {
			box.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(box);
		
		
		for(int i = 0;i<n;i++) {
            int c = crane[i];
            int left = 0;
            int right = m-1;
            int idx=-1;
            while(left<=right) {
                int mid = (left+right)/2;
                if(box.get(mid)<=c) {
                    idx = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            craneidx[i]=idx;
        }
		
		if(craneidx[n-1]!=m-1) {
			System.out.print(-1);
			return;
		}
		
		boolean[] visited = new boolean[m];
		int cnt = 0;
		int movedbox = 0;
		
		while(movedbox<m) {
			for(int i = n-1;i>=0;i--) {
				for(int j = craneidx[i];j>=0;j--) {
					if(!visited[j]&&box.get(j)<=crane[i]) {
						visited[j] = true;
						movedbox++;
						craneidx[i] = j-1;
						break;
					}
				}
			}
			cnt++;
		}
		System.out.print(cnt);
	}
}
