package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B1043 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=  new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		boolean[] know = new boolean[n+1];
		st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		for(int i = 0; i<num;i++) {
			int c = Integer.parseInt(st.nextToken());
			know[c] = true;
		}
		
		List<int[]> list = new ArrayList<>();
		for(int i = 0; i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			int[] arr = new int[cnt];
			for(int j = 0; j<cnt;j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			list.add(arr);
		}
		
		while(true) {
			int count = 0;
			int size = list.size();
			for(int i = 0; i<size;i++) {
				if(list.isEmpty()) break;
				int[] c = list.get(i);
				for(int j = 0; j<c.length;j++) {
					if(know[c[j]]) {
						for(int k = 0;k<c.length;k++) {
							know[c[k]] = true;
						}
						count++;
						list.remove(i);
						i--;
						size--;
						break;
					}
				}
				
			}
			
			
			if(count==0) {
				break;
			}
		}
		
		System.out.print(list.size());
	}
}
