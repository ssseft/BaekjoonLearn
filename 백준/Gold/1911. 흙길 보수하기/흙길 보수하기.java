import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		ArrayList<int[]> list = new ArrayList<>();
		for(int i=0; i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list.add(new int[] {s,e-1});
		}
		list.sort(Comparator.comparingInt(a->a[0]));
		
		int result = 0;
		int now = 0;
		
		for(int[] lists : list) {
			int start = lists[0];
			int end = lists[1];
			if(now<start) {
				now = start;
			}
			while(now<=end) {
				now += l;
				result++;
			}
		}
		System.out.print(result);
	}
}