import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<>();
		list.add(-1);
		for(int i = 0;i<n;i++) {
			int c = Integer.parseInt(st.nextToken());
			if(c>list.get(list.size()-1)) {
				list.add(c);
			}
			else {
				int left = 1;
				int right = list.size()-1;
				while(left<right) {
					int mid = (left+right)>>1;
					if(c<list.get(mid)) {
						right = mid;
					}
					else {
						left = mid+1;
					}
				}
				list.set(left,c);
			}
		}
		System.out.print(n-(list.size()-1));
	}
}