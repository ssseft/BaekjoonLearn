package beakjoon1;
import java.io.*;

public class B3687 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr =  {6,2,5,5,4,5,6,3,7,6};
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<n;i++) {
			int c = Integer.parseInt(br.readLine());
			StringBuilder min = new StringBuilder();
			StringBuilder max = new StringBuilder();
			int value = c;// 남은 수
			int size = (c-1)/7+1;
			for(int j = 0; j<size-1;j++) {
				if(j==0) {
					for(int k = 1;k<10;k++) {
						if(value-arr[k]>=(size-j-1)*2&&value-arr[k]<=(size-j-1)*7) {
							min.append(k);
							value -= arr[k];
							break;
						}
					}
				}
				else {
					for(int k = 0;k<10;k++) {
						if(value-arr[k]>=(size-j-1)*2&&value-arr[k]<=(size-j-1)*7) {
							min.append(k);
							value -= arr[k];
							break;
						}
					}
				}
			}
			if(size==1) {
				for(int j = 1; j<10;j++) {
					if(value==arr[j]) {
						min.append(j);
						break;
					}
				}
			}
			else {
				for(int j = 0; j<10;j++) {
					if(value==arr[j]) {
						min.append(j);
						break;
					}
				}
			}
			
			
			
			
			
			if(c%2==1) {
				max.append(7);
				for(int j = 0; j<c/2-1;j++) {
					max.append(1);
				}
			}
			else {
				for(int j = 0; j<c/2;j++) {
					max.append(1);
				}
			}
			
			sb.append(min.toString()+" "+max.toString()+"\n");
		}
		System.out.print(sb.toString());
	}
}
