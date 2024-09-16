package beakjun;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2785 {
	public static void main(String[] args) throws IOException	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Integer[] arr = new Integer[n];
		for(int i =0; i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, (a, b) -> b - a);
		
		int size  = arr.length-1;
		int result = 0;
		
		while(true) {
			if(size==arr[size]) {
				result = arr[size];
				break;
			}
			else if(size<arr[size]) {
				result = arr[size]+1;
				break;
			}
			else {
				result+=arr[size];
			}
			
			size--;
		}
		System.out.print(result);
		
		
	}
}
