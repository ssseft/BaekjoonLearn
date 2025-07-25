package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B1508 {
	static int n,m,k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0;i<k;i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		int left = 0;
		int right = n;
		int[] result;
		int[] arr = new int[k];
		while(left<=right) {
			int mid = (left+right)/2;
			result = new int[k];
			if(check(list,mid,result)>=m) {
				arr = result.clone();
				left = mid+1;
			}
			else {
				right = mid-1;
			}
		}
		for(int i =0;i<k;i++) {
			System.out.print(arr[i]);
		}
	}
	static int check(List<Integer> list,int mid,int[] result) {
		int num = 1;
		int lastnum = list.get(0);
		result[0] = 1;
		for(int i = 1;i<k;i++) {
			int c = list.get(i);
			if(c-lastnum>=mid) {
				result[i] = 1;
				lastnum = c;
				num++;
				if(num>=m) return num;
			}
		}
		return num;
	}
}
