package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B2879 {
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
		
		
		int score = 0;
		int max = 0;
		
		for(int i = 0; i<n+1;i++) {
			
			
		}
		System.out.print(score);
	}
	static int cal(List<Integer> list,int min) {
		int result = 0;
		int size = list.size();
		List<Integer> index = new ArrayList<>();
		for(int i = 0; i<size;i++) {
			min = Math.min(min, list.get(i));
		}
		List<Integer> list2 = new ArrayList<>();
		for(int i = 0; i<size;i++) {
			if(min==list.get(i)) {
				result+=cal(list2,min);
				list2 = new ArrayList();
			}
			list2.add(list.get(i));
		}
		
		
		return result;
	}
}
