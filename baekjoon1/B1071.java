package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class B1071 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[1001];
		for(int i = 0; i<n;i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[num]++;
		}
		
		List<Integer> list = new LinkedList<>();
		int index = 0;
		
		//시작지점
		for(int i = 0; i<1001;i++) {
			if(arr[i]!=0) {
				index =  i;
				break;
			}
		}
		
		for(int i = index; i<1001;i++) {
			if(arr[i]!=0) {
				if(arr[i+1]!=0) {
					int idx = 0;
					for(int j = i+2;j<1001;j++) {
						if(arr[j]!=0) {
							idx = j;
							break;
						}
					}
					if(idx!=0) {
						for(int j = 0; j<arr[i];j++) {
							list.add(i);
						}
						list.add(idx);
						arr[i] = 0;
						arr[idx]--;
					}
					else {
						list.add(i+1);
						arr[i+1]--;
						i--;
					}
				}
				else {
					for(int j = 0; j<arr[i];j++) {
						list.add(i);
					}
				}
			}
			
			
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int a : list) {
			sb.append(a+" ");
		}
		
		System.out.print(sb.toString().trim());
		
	}
}