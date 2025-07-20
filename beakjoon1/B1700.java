package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1700 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 멀티탭 구멍 개수
	    int k = Integer.parseInt(st.nextToken());
	    st = new StringTokenizer(br.readLine());
		int[] arr = new int[k];
		for(int i =0; i<k;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		boolean[] using = new boolean[k+1];
		int input = 0;
		int count = 0;
		for(int i =0 ;i<k;i++) {
			int code = arr[i];
			if(using[code]) {
				continue;
			}
			if(input<n) {
				using[code] = true;
				input++;
			}
			if(!using[code]) {
				ArrayList<Integer> list = new ArrayList<>();
				for(int j = i; j<k;j++) {
					if(!list.contains(arr[j])&&using[arr[j]]) {
						list.add(arr[j]);
					}
				}
				if(list.size()==n) {
					int a = list.get(n-1);
					using[a] = false;
					using[code] = true;
				}
				else {
					for(int v = 0;v<using.length;v++) {
						if(using[v]&&!list.contains(v)) {
							using[v] = false;
							using[code] = true;
							break;
						}
					}
				}
				count++;
			}
		}
		System.out.print(count);
	}
}
