import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0;i<3;i++) {
			int cnt = 0;
			for(int j = 0;j<4;j++) {
				if(sc.nextInt()==0) cnt++;
			}
			if(cnt==0) System.out.println("E");
			if(cnt==1) System.out.println("A");
			if(cnt==2) System.out.println("B");
			if(cnt==3) System.out.println("C");
			if(cnt==4) System.out.println("D");
		}
	}
}
