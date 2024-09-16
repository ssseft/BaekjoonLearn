package beakjun;
import java.util.Scanner;

public class B4779 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextInt()) {
			int num = sc.nextInt();
			int size = (int)Math.pow(3, num);
			
			boolean[] arr = new boolean[size];
			
			Cantor(arr,0,size);
			
			StringBuilder sb = new StringBuilder();
            for(boolean a : arr) {
                if(a) {
                    sb.append(" ");
                } else {
                    sb.append("-");
                }
            }
            System.out.println(sb.toString());
			
		}
	}
	
	public static void Cantor(boolean[] arr,int start, int end) {
		int seg = (end-start)/3;
		int midStart = start + seg;
        int midEnd = start + 2 * seg;
        for (int i = midStart; i < midEnd; i++) {
            arr[i] = true;
        }
        if (seg < 1) {
            return;
        }
		Cantor(arr, start, midStart);
        Cantor(arr, midEnd, end);
	}
}