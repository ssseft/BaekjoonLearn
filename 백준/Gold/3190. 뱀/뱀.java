import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Move{
		int time;
		char direction;//오른 D 왼 L
		
		Move(int time,char direction){
			this.time = time;
			this.direction = direction;
		}
		
	}
	static int n ;
	static int k;
	static boolean[][] apple;
	static int direction;
	static boolean[][] body;
	static List<Move> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n  = Integer.parseInt(br.readLine());
		k  = Integer.parseInt(br.readLine());
		apple = new boolean[n+1][n+1];
		direction = 3;
		body = new boolean[n+1][n+1];
		StringTokenizer st;
		for(int i = 0 ;i<k;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			apple[x][y] = true;
		}
		
		int L = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		for(int i = 0; i<L;i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			char D = st.nextToken().charAt(0);
			list.add(new Move(t,D));
		}
		int second = 0;
		int current_x = 1;
		int current_y = 1;
		body[1][1] = true;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {1,1});
		int list_index = 0;
		int next_time = list.get(0).time;
		
		while(true) {
			second++;
			
			if (direction == 0) {
                current_x -= 1;
            } else if (direction == 1) {
                current_x += 1;
            } else if (direction == 2) {
                current_y -= 1;
            } else {
                current_y += 1;
            }
			
			if(current_x==0||current_y==0||current_x==n+1||current_y==n+1||body[current_x][current_y]) {
				break;
			}
			
			body[current_x][current_y] = true;
			q.add(new int[]{current_x, current_y});
			
			if(!apple[current_x][current_y]) {
				int[] c = q.poll();
				body[c[0]][c[1]] = false;
			}
			else {
				apple[current_x][current_y] = false;
			}
			
			if(second == next_time) {
				if(list.get(list_index).direction == 'D') {
					if(direction==0) {
						direction = 3;
					}
					else if(direction == 1) {
						direction = 2;
					}
					else if(direction == 2) {
						direction = 0;
					}
					else {
						direction = 1;
					}
				}
				else {
					if(direction==0) {
						direction = 2;
					}
					else if(direction == 1) {
						direction = 3;
					}
					else if(direction == 2) {
						direction = 1;
					}
					else {
						direction = 0;
					}
				}
				list_index++;
				if(list_index<L) {
					next_time = list.get(list_index).time;
				}
			}
		}
		System.out.print(second);
	}
}