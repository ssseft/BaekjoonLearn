package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B2831 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		List<Integer> mman = new ArrayList<>();
		List<Integer> pman = new ArrayList<>();
		List<Integer> mwoman = new ArrayList<>();
		List<Integer> pwoman = new ArrayList<>();
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<n;i++) {
			int c = Integer.parseInt(st.nextToken());
			if(c>0) {
				mman.add(c);
			}
			else {
				pman.add(c*-1);
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<n;i++) {
			int c = Integer.parseInt(st.nextToken());
			if(c>0) {
				mwoman.add(c);
			}
			else {
				pwoman.add(c*-1);
			}
		}
		Collections.sort(mman);
		Collections.sort(mwoman);
		Collections.sort(pman);
		Collections.sort(pwoman);
		int cnt = 0;
		
		int midx = 0;
		int widx = 0;
		while(midx<pman.size()&&widx<mwoman.size()) {
			if(pman.get(midx)>mwoman.get(widx)) {
				cnt++;
				widx++;
			}
			midx++;
		}
		midx = 0;
		widx = 0;
		while(midx<mman.size()&&widx<pwoman.size()) {
			if(mman.get(midx)<pwoman.get(widx)) {
				cnt++;
				midx++;
			}
			widx++;
		}
		System.out.print(cnt);
	}
}
