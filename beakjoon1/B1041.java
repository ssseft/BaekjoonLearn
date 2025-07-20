package beakjoon1;
import java.io.*;
import java.util.StringTokenizer;

public class B1041 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[6];
		
		int oneside = Integer.MAX_VALUE;
		int sum = 0;
		int max = -1;
		for(int i = 0; i<6;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum+= arr[i];
			if(max<arr[i]) {
				max = arr[i];
			}
			if(oneside>arr[i]) {
				oneside = arr[i];
			}
		}
		
		int twoside = Integer.MAX_VALUE;
		int threeside = Integer.MAX_VALUE;
		
		for(int i = 0; i<6;i++) {
			for(int j = 0;j<6;j++) {
				if(i+j!=5&&i!=j) {
					if(twoside>arr[i]+arr[j]) {
						twoside = arr[i]+arr[j];
					}
				}
			}
		}
		
		int arr2[] = new int[4];
		arr2[0] = arr[1]+arr[2];
		arr2[1] = arr[1]+arr[3];
		arr2[2] = arr[2]+arr[4];
		arr2[3] = arr[3]+arr[4];
		
		for(int i = 0; i<6;i+=5) {
			for(int j = 0 ;j<4;j++) {
				if(arr[i]+arr2[j]<threeside) {
					threeside = arr[i]+arr2[j];
				}
			}
		}
		if(n==1) {
			System.out.println(sum-max);
		}
		else if(n==2) {
			System.out.println(threeside*4+twoside*4);
		}
		else {
			long result = 0;
			result+=threeside*4;
			result+=twoside*(8*n-12);
			result+=oneside*(5*(long)Math.pow(n-2, 2)+4*(n-2));
			System.out.println(result);
		}
	}
}
