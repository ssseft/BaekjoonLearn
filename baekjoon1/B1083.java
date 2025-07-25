package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1083 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st=  new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i = 0;i <n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int swap = Integer.parseInt(br.readLine());
		int index = 0;
		while(swap!=0&&index!=n-1) {
			
			int cnt = 0;
			int max = arr[index];
			int maxIndex = index;
			for(int i = index+1; i<n;i++) {
				if(arr[i]>max) {
					max = arr[i];
					maxIndex = i;
				}
				cnt++;
				if(cnt==swap) {
					break;
				}
			}
			if(maxIndex!=index) {
				int temp = arr[maxIndex];
				for(int i = maxIndex;i>index;i--) {
					arr[i] = arr[i-1];
				}
				arr[index] = temp;
				swap -= (maxIndex-index);
			}
			
			index++;
		}
		
		
		
		StringBuilder sb = new StringBuilder();
		for(int a : arr) {
			sb.append(a+" ");
		}
		System.out.println(sb.toString().trim());
	}
}
