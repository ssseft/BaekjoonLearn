import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("Test4.txt"));
		//---------여기에 코드를 작성하세요.---------------//

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int r = sc.nextInt();
		
		int[][] arr = new int[n][m];
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int min = (Math.min(n, m)/2);
		
		for(int j = 0;j<min;j++) {
			int t = r%(((n-(j*2))*2)+((m-(j*2))*2)-4);
			for(int i = 0;i<t;i++) {
				rotation(arr, j);
			}
		}	
		
		
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	static void rotation(int[][] arr,int layer) {
		
		for(int i = layer+1;i<arr[0].length-1-layer;i++) {
			q.add(arr[layer][i]);
		}
		for(int i = layer;i<arr.length-1-layer;i++) {
			q.add(arr[i][arr[0].length-1-layer]);
		}
		for(int i = arr[0].length-1-layer;i>layer;i--) {
			q.add(arr[arr.length-1-layer][i]);
		}
		for(int i = arr.length-1-layer;i>=layer;i--) {
			q.add(arr[i][layer]);
		}
		for(int i = layer;i<arr[0].length-1-layer;i++) {
			arr[layer][i] = q.poll();
		}
		for(int i = layer;i<arr.length-1-layer;i++) {
			arr[i][arr[0].length-1-layer] = q.poll();
		}
		for(int i = arr[0].length-1-layer;i>layer;i--) {
			arr[arr.length-1-layer][i] = q.poll();
		}
		for(int i = arr.length-1-layer;i>layer;i--) {
			arr[i][layer] = q.poll();
		}
	}

}
