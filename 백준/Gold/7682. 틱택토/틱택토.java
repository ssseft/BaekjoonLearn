import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(true) {
			String c = sc.nextLine();
			if(c.equals("end")) break;
			char[] arr = c.toCharArray();
			int Xcnt = 0;
			int Ocnt = 0;
			for(int i = 0;i<9;i++) {
				if(arr[i]=='X') Xcnt++;
				else if(arr[i]=='O') Ocnt++;
			}
			if(!(Xcnt==Ocnt||Xcnt==Ocnt+1)) sb.append("invalid\n");
			else {
				int[][] d = cal(arr);
				int ocnt = 0;
				int xcnt = 0;
				boolean xch = true;
				boolean och = true;
				for(int i =0;i<9;i++) {
					if(d[i][0]>1) xcnt++;
					else if(d[i][1]>1) ocnt++;
					else if(d[i][1]==1) och = false;
					else if(d[i][0]==1) xch = false;
				}
				if((xcnt>1||ocnt>1)||(Xcnt==Ocnt&&!xch&&och)||(Xcnt==Ocnt+1&&xch&&!och)||(Xcnt+Ocnt!=9&&(och&&xch))||(!och&&!xch)) sb.append("invalid\n");
				else sb.append("valid\n");
			}
		}
		System.out.print(sb);
	}
	static int[][] cal(char[] arr) {
		int[][] cnt = new int[9][2];
		if(arr[0]=='X'&&arr[0]==arr[1]&&arr[1]==arr[2]) {cnt[0][0]++; cnt[1][0]++; cnt[2][0]++;}
		if(arr[0]=='O'&&arr[0]==arr[1]&&arr[1]==arr[2]) {cnt[0][1]++; cnt[1][1]++; cnt[2][1]++;}
		if(arr[3]=='X'&&arr[3]==arr[4]&&arr[4]==arr[5]) {cnt[3][0]++; cnt[4][0]++; cnt[5][0]++;}
		if(arr[3]=='O'&&arr[3]==arr[4]&&arr[4]==arr[5]) {cnt[3][1]++; cnt[4][1]++; cnt[5][1]++;}
		if(arr[6]=='X'&&arr[6]==arr[7]&&arr[7]==arr[8]) {cnt[6][0]++; cnt[7][0]++; cnt[8][0]++;}
		if(arr[6]=='O'&&arr[6]==arr[7]&&arr[7]==arr[8]) {cnt[6][1]++; cnt[7][1]++; cnt[8][1]++;}
		if(arr[0]=='X'&&arr[0]==arr[3]&&arr[3]==arr[6]) {cnt[0][0]++; cnt[3][0]++; cnt[6][0]++;}
		if(arr[0]=='O'&&arr[0]==arr[3]&&arr[3]==arr[6]) {cnt[0][1]++; cnt[3][1]++; cnt[6][1]++;}
		if(arr[1]=='X'&&arr[1]==arr[4]&&arr[4]==arr[7]) {cnt[1][0]++; cnt[4][0]++; cnt[7][0]++;}
		if(arr[1]=='O'&&arr[1]==arr[4]&&arr[4]==arr[7]) {cnt[1][1]++; cnt[4][1]++; cnt[7][1]++;}
		if(arr[2]=='X'&&arr[2]==arr[5]&&arr[5]==arr[8]) {cnt[2][0]++; cnt[5][0]++; cnt[8][0]++;}
		if(arr[2]=='O'&&arr[2]==arr[5]&&arr[5]==arr[8]) {cnt[2][1]++; cnt[5][1]++; cnt[8][1]++;}
		if(arr[0]=='X'&&arr[0]==arr[4]&&arr[4]==arr[8]) {cnt[0][0]++; cnt[4][0]++; cnt[8][0]++;}
		if(arr[0]=='O'&&arr[0]==arr[4]&&arr[4]==arr[8]) {cnt[0][1]++; cnt[4][1]++; cnt[8][1]++;}
		if(arr[2]=='X'&&arr[2]==arr[4]&&arr[4]==arr[6]) {cnt[2][0]++; cnt[4][0]++; cnt[6][0]++;}
		if(arr[2]=='O'&&arr[2]==arr[4]&&arr[4]==arr[6]) {cnt[2][1]++; cnt[4][1]++; cnt[6][1]++;}
		return cnt;
	}
}
