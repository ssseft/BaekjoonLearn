package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//정리 하면
//1. 드래곤 커브를 진행할수록 이어지는 선들의 방향이 나열하는 값을 역순한 후 +1한것과같음
//2. 먼저 초기 방향을 list에 넣고 1에서 정리한 내용처럼 역순으로 값을 get하여 +1한 값을 list에 추가 -> 이것을 level만큼 반복
//3. 초기 방향을 cx,cy로 선언하고 방향별로 갱신하면서 도착한 장소를 check[cx][cy]를 true;
//4. 좀 더 고민하면 더 효율적으로 코드를 구성할 수 있을 것 같지만 그냥x,y를 0~99로 x,y x+1,y x,y+1 x+1,y+1이 true일 경우에만 result++을 해 결과도출

public class B15685 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[][] check = new boolean[101][101];
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] dx = {1,0,-1,0};
		int[] dy = {0,-1,0,1};
		for(int i = 0; i<n;i++) {
			List<Integer> list = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken());
			int level = Integer.parseInt(st.nextToken());
			
			list.add(direction);
			check[x][y] = true;
			
			for(int j=0 ;j<level;j++) {
				for(int k = list.size()-1;k>=0;k--) {
					list.add((list.get(k)+1)%4);
				}
			}
			
			int cx = x;
			int cy = y;
			
			for(int j = 0; j<list.size();j++) {
				cx += dx[list.get(j)];
				cy += dy[list.get(j)];
				check[cx][cy] = true;
			}
		}
		int result = 0;
		for(int i = 0; i<100;i++) {
			for(int j = 0; j<100;j++) {
				if(check[i][j]&&check[i+1][j]&&check[i][j+1]&&check[i+1][j+1]){
					result++;
					
				}
			}
		}
		
		System.out.println(result);
	}
}
