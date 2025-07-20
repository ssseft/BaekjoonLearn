package beakjoon1;
import java.io.*;
import java.util.Arrays;

public class B2036 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int cnt = 0;
		for(int i =0; i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i]<1) {
				cnt++;
			}
		}
		Arrays.sort(arr);
		long result = 0;
		int index = 0;
		while(index+1<cnt) {
			result += (long)arr[index]*arr[index+1];
			index+=2;
		}
		if(cnt%2==1) {
			result+=arr[index];
			index++;
		}
		
		if((n-cnt)%2==1) {
			result+=arr[index];
			index++;
		}
		while(index<n&&arr[index]==1&&index+1<n) {
			result+=(1+arr[index+1]);
			index+=2;
		}
		while(index+1<n) {
			result+= (long)arr[index]*arr[index+1];
			index+=2;
		}
		System.out.println(result);
	}
}
