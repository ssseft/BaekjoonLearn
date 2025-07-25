package beakjoon1;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class B15686 {
	static int n ;
	static int m;
	static int[][] arr;
	static int min;
	static List<Integer> chicken;
	static List<Integer> home;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n+1][n+1];
		chicken = new LinkedList<>();
		home = new LinkedList<Integer>();
		for(int i = 1; i<n+1;i++) {
			for(int j = 1; j<n+1;j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j]==2) {
					chicken.add(n*(i-1)+j-1);
				}
				else if(arr[i][j] ==1) {
					home.add(n*(i-1)+j-1);
				}
			}
		}
		min = Integer.MAX_VALUE;
		List<Integer> list = new LinkedList<>();
		dfs(0,0,list);
		System.out.print(min);
		sc.close();
		
	}
	public static void dfs(int size,int start,List<Integer> list) {
		if(size==m) {
			min = Math.min(min, calculate(list));
			return;
		}
		for(int i = start; i<chicken.size();i++) {
			list.add(chicken.get(i));
			dfs(size+1,i+1,list);
			list.remove(list.size()-1);
		}
		
		
	}
	public static int calculate(List<Integer> list) {
		int totalDistance = 0;
		for (int home_index : home) {
            int minDistance = Integer.MAX_VALUE;
            int home_x = home_index/n;
            int home_y = home_index%n;

            for (int chickenIndex : list) {
                int ch_x = chickenIndex / n;
                int ch_y = chickenIndex % n;
                int distance = Math.abs(home_x - ch_x) + Math.abs(home_y - ch_y);
                minDistance = Math.min(minDistance, distance);
            }
            totalDistance += minDistance;
        }
		return totalDistance;
		
	}
}
