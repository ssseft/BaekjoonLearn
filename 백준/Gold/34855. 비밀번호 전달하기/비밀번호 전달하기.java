import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] arr = new int[6];
		for(int i=  0;i<6;i++)
			arr[i] = sc.nextInt()-1;
		
		int[] ans = new int[6];
		List<Integer> list = new ArrayList<>();
		for(int i : arr) list.add(i);
		if(t==1) {
			for(int i = 1;i<=63;i++) {
				boolean ch = true;
				for(int j = 0;j<6;j++) {
					int c = (arr[j]+i)&63;
					if(list.contains(c)) {
						ch = false;
						break;
					}
				}
				if(ch) {
					for(int j= 0;j<6;j++) {
						ans[j] = (arr[j]+i)&63;
					}
					break;
				}
			}
		}
		else {
			for(int i = 1;i<=63;i++) {
				boolean ch = true;
				int[] A = new int[6];
				for(int  j= 0;j<6;j++) 
					A[j] = (arr[j]-i+64)&63;
				
				List<Integer> list2 = new ArrayList<>();
				for(int s : A) list2.add(s);
				
				int min = -1;
				for(int j = 1;j<=63;j++) {
					boolean as = true;
					for(int s : A) {
						int c = (s+j)&63;
						if(list2.contains(c)) {
							as = false;
							break;
						}
					}
					if(as) {
						min = j;
						break;
					}
				}
				if(min==i) {
					for(int j = 0;j<6;j++) 
						ans[j] = A[j];
					break;
				}
			}
		}
		for(int i : ans) System.out.print((i+1)+" ");
	}
}
