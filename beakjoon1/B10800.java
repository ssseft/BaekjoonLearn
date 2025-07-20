package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B10800 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		List<int[]> list = new ArrayList<>();
		int[] sum = new int[200001];
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int color = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			list.add(new int[] {color,size,i});
		}
		
		//색, 크기 오름차순 정렬
		Collections.sort(list,(a,b)->{
			if(a[1]==b[1]) return a[0]-b[0];
			return a[1]-b[1];
		});
		
		int[] result = new int[n];
		int total = 0;
		int[] sizesum = new int[2001];
        for (int i = 0; i < n; i++) {
            int color = list.get(i)[0];
            int size = list.get(i)[1];
            int index = list.get(i)[2];

            if (i>0&& list.get(i-1)[1]==size) {
                if(list.get(i-1)[0] == color ) {
                	result[index] = result[list.get(i-1)[2]];
                }
                else {
                	result[index] = total- sum[color]-sizesum[size];
                }
            	
            } else {
                result[index] = total-sum[color];
            }

            // 누적합
            total += size;
            sum[color] += size;
            sizesum[size] += size;
        }
		
		for (int i = 0; i < n; i++) {
		    sb.append(result[i]+"\n");
		}
		System.out.println(sb.toString().trim());

	}
}
