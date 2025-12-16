import java.util.*;

public class Main {
	static class Node{
		String w;
		int idx;
		public Node(String w, int idx) {
			super();
			this.w = w;
			this.idx = idx;
		}
	}
	static int cal(String a,String b) {
		int cnt = 0;
		int len = Math.min(a.length(), b.length());
		while(cnt<len&&a.charAt(cnt)==b.charAt(cnt)) {
			cnt++;
		}
		return cnt;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		List<Node> list = new ArrayList<>();
		String[] origin = new String[n];
		for(int i = 0;i<n;i++) {
			origin[i] = sc.nextLine();
			list.add(new Node(origin[i], i));
		}
		
		Collections.sort(list,(a,b)->a.w.compareTo(b.w));
		
		int idx1 = 0;
		int idx2 = 0;
		String w1 = "";
		String w2 = "";
		int max = 0;
		for(int i = 0;i<n-1;i++) {
			for(int j = i+1;j<n;j++) {
				int len = cal(list.get(i).w,list.get(j).w);
				if(len==max) {
					if(Math.min(list.get(i).idx, list.get(j).idx)>idx1) continue;
					if(Math.min(list.get(i).idx, list.get(j).idx)==idx1
							&&
							Math.max(list.get(i).idx, list.get(j).idx)>idx2
							) continue;
					if(list.get(i).idx>list.get(j).idx) {
						idx1 = list.get(j).idx;
						idx2 = list.get(i).idx;
						w1 = list.get(j).w;
						w2 = list.get(i).w;
					}
					else {
						idx1 = list.get(i).idx;
						idx2 = list.get(j).idx;
						w1 = list.get(i).w;
						w2 = list.get(j).w;
					}
				}
				else if(len>max) {
					max = len;
					if(list.get(i).idx>list.get(j).idx) {
						idx1 = list.get(j).idx;
						idx2 = list.get(i).idx;
						w1 = list.get(j).w;
						w2 = list.get(i).w;
					}
					else {
						idx1 = list.get(i).idx;
						idx2 = list.get(j).idx;
						w1 = list.get(i).w;
						w2 = list.get(j).w;
					}
				}
				else break;
			}
		}
		System.out.println(w1);
		System.out.println(w2);
	}
}
