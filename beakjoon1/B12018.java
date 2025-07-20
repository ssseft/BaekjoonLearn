package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class B12018 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int point = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		for(int i = 0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int application = Integer.parseInt(st.nextToken());
			int sum = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			List<Integer> list = new LinkedList<>();
			for(int j = 0; j<application;j++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			if(application<sum) {
				arr[i] = 1;
				continue;
			}
			Collections.sort(list,Collections.reverseOrder());
			arr[i] = list.get(sum-1);	
		}
		Arrays.sort(arr);
		for(int i = 0; i<n;i++) {
			System.out.println(arr[i]);
		}
		int result = 0;
		for(int i = 0; i<n;i++) {
			if(point-arr[i]<0) {
				break;
			}
			point-=arr[i];
			result++;
		}
		System.out.print(result);
	}
}