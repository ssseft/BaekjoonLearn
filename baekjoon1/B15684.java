package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15684 {
	static int x;
	static boolean[][] exist;
	static int H;
	static int y;
	static int cnt;
	static boolean ch;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		exist = new boolean[y+1][x+1]; //0은 제외하고
		
		cnt  = Integer.MAX_VALUE;
		
		for(int i = 0; i<H;i++) {
			st = new StringTokenizer(br.readLine());
			int Y = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			exist[Y][X] = true;
			//왼쪽에서부터 X번~X+1번째줄이 이어짐 , 위에서부터 Y번째줄
		}
		if(check()) {
			System.out.println(0);
			return;
		}
		for (int i=1; i<=3; i++) { //1개~3개까지 계산
            DFS(0,0,i);
            if (cnt != Integer.MAX_VALUE) {
                System.out.println(cnt);
                return;
            }
        }
        System.out.println(-1);
		
		
	}
	public static void DFS(int depth, int count,int max) {
		if (count == max) {
            if (check()) {
                cnt = count; // 사다리수
            }
            return;
        }

        

        for (int i = depth; i <= y; i++) {
            for (int j = 1; j < x; j++) {
                if (!exist[i][j] && !exist[i][j - 1] && !exist[i][j + 1]) {
                    exist[i][j] = true;
                    DFS(i, count+1,max);
                    exist[i][j] = false;
                }
            }
        }
	}
	public static boolean check() {
	    for (int i = 1; i <= x; i++) {
	        int position = i;
	        for (int j = 1; j <= y; j++) {
	            if (position < x && exist[j][position]) {
	                position++;
	            } else if (position > 1 && exist[j][position - 1]) {
	                position--;
	            }
	        }
	        if (position!=i) {
	        	return false;
	        }
	    }
	    return true;
	}
}
