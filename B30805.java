package beakjun;
import java.util.*;

public class B30805 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int alen = sc.nextInt();
		int[] a = new int[alen];
		for(int i = 0; i<alen;i++) {
			a[i] = sc.nextInt();
		}
		int blen = sc.nextInt();
		int[] b=  new int[blen];
		for(int i = 0; i<blen;i++) {
			b[i] = sc.nextInt();
		}
		sc.close();
		
		int[][] lcs = new int[alen+1][blen+1];
		for (int i = 1; i <= alen; i++) {
            for (int j = 1; j <= blen; j++) {
                if (a[i-1] == b[j-1]) {
                	lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } 
                else {
                	lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }
		ArrayList<Integer> list = new ArrayList<>();
		int i = alen, j = blen;

        while (i > 0 && j > 0) {
            if (a[i - 1] == b[j - 1]) {
                list.add(a[i - 1]);
                i--;
                j--;
            } else {
                if (lcs[i-1][j] >= lcs[i][j-1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        
	}
}
