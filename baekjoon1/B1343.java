package beakjoon1;
import java.util.Scanner;

public class B1343 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String pol = sc.nextLine();
		sc.close();
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		for(int i = 0; i<pol.length();i++) {
			if(pol.charAt(i)=='X') {
				cnt++;
			}
			else {
				if(cnt%2==1) {
					System.out.print(-1);
					return;
				}
				else {
					if(i==0||pol.charAt(i-1)=='.') {
						
					}
					else {
						while(cnt!=0) {
							if(cnt>=4) {
								sb.append("AAAA");
								cnt-=4;
							}
							else if(cnt>=2) {
								sb.append("BB");
								cnt-=2;
							}
						}
					}
					sb.append('.');
				}
			}
		}
		if(cnt%2==1) {
			System.out.print(-1);
			return;
		}
		else {
			while(cnt!=0) {
				if(cnt>=4) {
					sb.append("AAAA");
					cnt-=4;
				}
				else if(cnt>=2) {
					sb.append("BB");
					cnt-=2;
				}
			}
		}
		System.out.print(sb.toString());
	}
}
