package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B21758 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] honey = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		honey[0] = Integer.parseInt(st.nextToken());
		
		int maxhoney = 0;
		for(int i = 1; i<n;i++) {
			int c = Integer.parseInt(st.nextToken());
			if(i!=n-1&&c>maxhoney) maxhoney = c;
			honey[i] = c+honey[i-1];
		}
		
		int max = 0;
		//벌통이 두 벌 사이에 존재 할 때
		max = honey[n-2]-honey[0]+maxhoney;
		
		
		//벌통이 두 벌의 오른쪽에 위치할 때 j는 벌의 위치
		for(int j = 1;j<n-1;j++) {
			int bee1 = honey[n-1]-honey[0]-(honey[j]-honey[j-1]);
			int bee2 = honey[n-1]-honey[j];
			max = Math.max(max, bee1+bee2);
		}
		
		//벌통이 두 벌의 왼쪽에 위치할때 i는 벌통의 위치 j는 벌의 위치
		for(int j = 1;j<n-1;j++) {
			int bee1 = honey[n-2] - honey[j]+honey[j-1];
			int bee2 = honey[j-1];
			max = Math.max(max, bee1+bee2);
		}
		System.out.println(max);
	}
}