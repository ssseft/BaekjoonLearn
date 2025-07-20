package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B2141 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Long[]> list = new ArrayList<>();
		StringTokenizer st;
		long sum = 0;
		for(int i = 0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			long des = Integer.parseInt(st.nextToken());
			long num = Integer.parseInt(st.nextToken());
			sum+=num;
			list.add(new Long[] {des,num});
		}
		list.sort((a,b)->Long.compare(a[0], b[0]));
		long current = 0;
		for(int i = 0; i<n;i++) {
			current+=list.get(i)[1];
			if(current>=(sum + 1)/2) {
				System.out.print(list.get(i)[0]);
				return;
			}
		}
	}
}
