import java.util.*;

class paper implements Comparable<paper>{
	int x;
	int y;
	@Override
	public int compareTo(paper o) {
		if(o.x==this.x) return this.y-o.y;
		return this.x-o.x;
	}

	public paper(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class  Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<paper> list = new ArrayList<>();
		for(int i = 0;i<n;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int cx = Math.min(x, y);
			int cy = Math.max(x, y);
			list.add(new paper(cx, cy));
		}
		Collections.sort(list);
		int[] cnt = new int[n];
		int max = 1;
		Arrays.fill(cnt, 1);
		for(int i = 0;i<n-1;i++) {
			int cy = list.get(i).y;
			int ccnt = cnt[i];
			for(int j = i+1;j<n;j++) {
				if(list.get(j).y>=cy) {
					cnt[j] = Math.max(ccnt+1, cnt[j]);
					max = Math.max(max, cnt[j]);
				}
			}
		}
		System.out.print(max);
	}
}
