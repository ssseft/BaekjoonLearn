package beakjoon1;
import java.util.Scanner;

public class B17825 {
	static int[][] horsedes;
	static int[][] map;
	static int[] dice;
	static int max = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		dice = new int[10];
		for(int i = 0; i<10;i++) {
			dice[i] = sc.nextInt();
		}
		map = new int[][] {
			{0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40},
			{10,13,16,19,25,30,35,40},
			{20,22,24,25,30,35,40},
			{30,28,27,26,25,30,35,40}
		};
		
		horsedes = new int[4][2];//0은 map 1은 좌표
		
		backtracking(0,0);
		System.out.print(max);
	}
	static void backtracking(int cnt,int score) {
		if(cnt==10) {
			max = Math.max(max, score);
			return;
		}
		
		for(int i = 0;i<4;i++){
			if(horsedes[i][0]==4) continue;
			int temp1 = horsedes[i][0];
			int temp2 = horsedes[i][1];
			
			int s = move(i,dice[cnt]);
			
			boolean ch = false;
			if(horsedes[i][0]!=4) {
				for(int j = 0;j<4;j++) {
					if(i==j||horsedes[j][0]==4) continue;
					
					int pos1 = map[horsedes[i][0]][horsedes[i][1]];
					int pos2 = map[horsedes[j][0]][horsedes[j][1]];
					
					if((horsedes[i][0]==horsedes[j][0])) {
						if(horsedes[i][1]==horsedes[j][1]) {
							ch = true;
							break;
						}
					}
					if(pos1==pos2&&(pos1==25||pos1==30||pos1==35||pos1 == 40)) {
						if(pos1==30) {
							if((horsedes[i][0]==0||horsedes[j][0]==0)) {
								ch = true;
								break;
							}
						}
						else {
							ch = true;
							break;
						}
					}
					
				}
			}
			if(ch) {
				horsedes[i][0] = temp1;
				horsedes[i][1] = temp2;
				continue;
			}
			backtracking(cnt+1,score+s);
			horsedes[i][0] = temp1;
			horsedes[i][1] = temp2;
		}
	}
	static int move(int horse, int dice) {
		
		if(horsedes[horse][1]+dice>=map[horsedes[horse][0]].length) {
			horsedes[horse][0] = 4;//도착했다는 의미
			horsedes[horse][1] = 0;
			return 0;
		}
		else {
			horsedes[horse][1]+=dice;
			
			if(horsedes[horse][0]==0&&horsedes[horse][1]%5==0&&horsedes[horse][1]/5<4) {
				horsedes[horse][0] = horsedes[horse][1]/5;
				horsedes[horse][1] = 0;
			}
			return map[horsedes[horse][0]][horsedes[horse][1]];
		}
	}
}
