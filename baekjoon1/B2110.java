package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B2110 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i<n;i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(list);
		
		int left = 1;
		int right = list.get(list.size()-1);
		int MaxDistance = 0;
		
		while(left<=right) {
			int mid = (left+right)/2;
			if(check(list,c,mid)) {
				MaxDistance = mid;
				left = mid+1;
			}
			else {
				right = mid-1;
			}
		}
		
		System.out.print(MaxDistance);
	}

	private static boolean check(List<Integer> list, int c, int mid) {
		int cNum = 1;
		int lastElement = list.get(0);
		
		for(int i = 1; i<list.size();i++) {
			int dif = list.get(i)-lastElement;
			if(dif>=mid) {
				lastElement = list.get(i);
				cNum++;
				if(cNum>=c) {
					return true;
				}
			}
		}
		return false;
	}
}
