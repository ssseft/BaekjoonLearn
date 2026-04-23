import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		for(int i =0;i <2;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n;j++) {
				if(i==0) arr[j] = Integer.parseInt(st.nextToken());
				else arr[j] -= Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		List<Integer> list = new ArrayList<>();
		boolean up = arr[0]>=0;
		
		for(int i = 0;i<n;i++) {
			if(arr[i]>=0) {
				if(up) {
					list.add(arr[i]);
				}
				else {
					cnt+=cal(list);
					list.clear();
					list.add(arr[i]);
					up = true;
				}
			}
			else {
				if(up) {
					cnt+=cal(list);
					list.clear();
					list.add(-1*arr[i]);
					up = false;
				}
				else {
					list.add(-1*arr[i]);
				}
			}
		}
		cnt+=cal(list);
		
		System.out.print(cnt);
	}
	static int cal(List<Integer> list) {
		int cnt = 0;
		int total = 0;
		int[] arr = new int[list.size()];
		for(int i = 0;i<list.size();i++) {
			total+=list.get(i);
			arr[i] = list.get(i);
		}
		
		while(total>0) {
			for(int i = 0;i<arr.length;i++) {
				if(arr[i]>0) {
					for(int j = i;j<arr.length;j++) {
						if(arr[j]>0) {
							arr[j]--;
							total--;
						}
						else break;
					}
					cnt++;
					break;
				}
			}
		}
		return cnt;
	}
}