package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B13164 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<>();
		int sum = 0;
		int value = Integer.parseInt(st.nextToken());
		for(int i = 1; i<n;i++) {
			int c = Integer.parseInt(st.nextToken());
			list.add(c-value);
			sum+=(c-value);
			value = c;
		}
		Collections.sort(list,(a,b)->b-a);
		
		for(int i = 0; i<k-1;i++) {
			sum -= list.get(i);
		}
		System.out.print(sum);
	}
}
