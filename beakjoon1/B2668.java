package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B2668 {
	static int[] arr;
	static int cnt;
	static List<Integer> result;
	static boolean[] use;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		arr= new int[n+1];
		for(int i = 1; i<=n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		use = new boolean[n+1];
		result = new ArrayList<>();
		for(int i = 1;i<=n;i++) {
			List<Integer> list = new ArrayList<>();
			if(!use[i]) {
				if(i==arr[i]) {
					result.add(i);
				}
				else {
					list.add(i);
					DFS(i,arr[i],list);
				}
			}
		}
		Collections.sort(result);
		System.out.println(result.size());
		for(int a : result) {
			System.out.println(a);
		}
	}
	static void DFS(int start,int c, List<Integer> list) {
		if(start == arr[c]) {
			list.add(c);
			for(int a : list) {
				result.add(a);
				use[a] = true;
			}
			return;
		}
		if(list.contains(c)||use[c]) {
			return;
		}
		list.add(c);
		DFS(start,arr[c],list);
	}
}
