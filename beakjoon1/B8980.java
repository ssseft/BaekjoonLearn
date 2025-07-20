package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B8980 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());

		List<int[]> list = new ArrayList<>();
		for(int i = 0; i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cpt = Integer.parseInt(st.nextToken());
			list.add(new int[] {start,end,cpt});
			
		}
		list.sort((a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            } 
            else {
                return Integer.compare(a[0], b[0]);
            }
        });
		int[] size = new int[N+1];
		for(int i = 1;i<N+1;i++) {
			size[i] = C;
		}
		int cnt =0;
		for(int i = 1; i<=m;i++) {
			int[] current = list.get(i-1);
			//start 0 end 1 cpt 2
			int max = 10001;
			for(int j = current[0];j<current[1];j++) {
				max = Math.min(max, size[j]);
			}
			
			if(max>=current[2]) {
				for(int j = current[0];j<current[1];j++) {
					size[j]-=current[2];
				}
				cnt+=current[2];
			}
			else {
				for(int j = current[0];j<current[1];j++) {
					size[j] -=max;
				}
				cnt+=max;
			}
		}
		System.out.println(cnt);
	}
}
