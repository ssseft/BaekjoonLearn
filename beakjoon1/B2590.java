package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2590 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[7];
		for(int i = 1;i<7;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 0;
		
		//6
		cnt += arr[6];
		
		//5
		cnt += arr[5];
		if(arr[1]>arr[5]*11) arr[1]-=arr[5]*11;
		else arr[1] = 0;
		
		//4
		cnt+= arr[4];
		int two = arr[4]*5;
		if(arr[2]>=two) {
			arr[2] -= two;
		}else {
			int remain = two - arr[2];
			arr[1] -= Math.min(arr[1], remain*4);
			arr[2] = 0;
		}
		
		//3
		int[] needtwo = {0,5,3,1};
		int[] needone = {0,7,6,5};
		
		while(arr[3]>0) {
			if(arr[3]>=4) {
				arr[3]-= 4;
				cnt++;
			}
			else {
				cnt++;
				
				if(needtwo[arr[3]]<=arr[2]) {
					arr[2] -= needtwo[arr[3]];
				}
				else {
					int twod =needtwo[arr[3]]-arr[2];
					arr[2] = 0;
					arr[1] -= Math.min(arr[1], twod*4);
				}
				arr[1] -= Math.min(arr[1], needone[arr[3]]);
				arr[3] = 0;
			}
		}
		
		//2
		while(arr[2]>0) {
			if(arr[2]>=9) {
				cnt++;
				arr[2]-=9;
			}
			else {
				cnt++;
				arr[1] -= Math.min(arr[1], 36-arr[2]*4);
				arr[2] = 0;
			}
		}
		
		//1
		while(arr[1]>0) {
			cnt++;
			arr[1] -= 36;
		}
		
		System.out.println(cnt);
	}
}
