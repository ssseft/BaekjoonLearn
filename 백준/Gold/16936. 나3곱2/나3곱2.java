import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long[] arr = new long[n];
		int[][] seq = new int[n][2];
		Set<Long> set=  new HashSet<>();
		for(int i = 0;i<n;i++) {
			long c = sc.nextLong();
			arr[i] = c;
			Arrays.fill(seq[i], -1);
			set.add(c);
		}
		Arrays.sort(arr);
		
		for(int i = 0;i<n;i++) {
			long c = arr[i];
			for(int j = 0;j<n;j++) {
				long d = arr[j];
				if((c%2==0&&c/2==d)||c*3==d) {
					seq[i][0] = j;
				}
				if((c%3==0&&c/3==d)||c*2==d) {
					seq[i][1] = j;
				}
			}
		}
		
		int start = -1;
		for(int i = 0;i<n;i++) {
			if(seq[i][0]==-1) {
				start = i;
				break;
			}
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		StringBuilder sb =new StringBuilder();
		sb.append(arr[start]+" ");
		while(!q.isEmpty()) {
			int c = q.poll();
			int next = seq[c][1];
			if(next==-1) break;
			sb.append(arr[next]+" ");
			q.add(next);
		}
		System.out.print(sb);
	}
}
