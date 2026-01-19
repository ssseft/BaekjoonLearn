import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String x = "";
		while((x=br.readLine())!=null){
			int goal = Integer.parseInt(x)*10000000;
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			for(int i = 0;i<n;i++) 
				arr[i] = Integer.parseInt(br.readLine());
			
			Arrays.sort(arr);
			
			int left = 0;
			int right = n-1;
			boolean ch = false;
			
			while(left<right) {
				int sum = arr[left]+arr[right];
				if(goal==sum) {
					ch = true;
					break;
				}
				if(goal>sum) left++;
				else right--;
			}
			
			if(ch) System.out.println("yes "+arr[left]+" "+arr[right]);
			else System.out.println("danger");
		}
	}
}