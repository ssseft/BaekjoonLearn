package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class B14891 {
	static List<ArrayList<Integer>> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		list = new LinkedList<>();
		for(int i = 0; i<4;i++) {
			list.add(new ArrayList<>());
			String cogwheel = br.readLine();
			for(int j = 0; j<cogwheel.length();j++) {
				list.get(i).add(Integer.parseInt(String.valueOf(cogwheel.charAt(j))));
			}
		}
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int wheel_num = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken());
			boolean[] visited = new boolean[4];
			visited[wheel_num-1] = true;
			cal(wheel_num-1,direction,visited);
		}
	
	
		int score = 0;
		int index = 1;
		for(int i = 0; i<4;i++) {
			score += index * list.get(i).get(0);
			index*=2;
		}
		System.out.print(score);
	}

	static void cal(int wheel_num, int direction, boolean[] visited) {
		if(wheel_num-1>=0&&!visited[wheel_num-1]&&check(wheel_num-1,wheel_num)) {
			visited[wheel_num-1] = true;
			cal(wheel_num-1,direction*-1,visited);
		}
		
		if(wheel_num+1<4&&!visited[wheel_num+1]&&check(wheel_num,wheel_num+1)) {
			visited[wheel_num+1] = true;
			cal(wheel_num+1,direction*-1,visited);
		}
		move(wheel_num,direction);
	}
	static void move(int wheel_num,int direction) {
		if(direction==1) {
			int last = list.get(wheel_num).remove(list.get(wheel_num).size()-1);
			list.get(wheel_num).add(0,last);
		}
		else {
			int first = list.get(wheel_num).remove(0);
			list.get(wheel_num).add(first);
		}
	}
	static boolean check(int a, int b) {
		if(list.get(a).get(2)!=list.get(b).get(6)) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
