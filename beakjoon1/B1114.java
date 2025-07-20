package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class B1114 {
	static int CutPosition;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		//리스트 정렬 및 중복 제거
		List<Integer> list = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<K;i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		list.add(0);
		list.add(L);
		HashSet<Integer> set = new HashSet<>(list);
		list = new ArrayList<>(set);
		Collections.sort(list);
		
		
		int left = 1;
		int right = L;
		int MaxLength = L;
		CutPosition = 0;
		
		while(left<=right) {
			
			int mid = (left+right)/2;
			
			if(cut(list,C,mid)) {
				MaxLength = mid;
				right = mid-1;
			}
			else {
				left = mid+1;
			}
			
		}
		
		System.out.println(MaxLength+" "+CutPosition);
	}

	public static boolean cut(List<Integer> list, int C, int mid) {
		int cut_num = 0;
		int lastCutPosition = list.get(list.size() - 1);;
		List<Integer> positions = new ArrayList<Integer>();
		
		for (int i = list.size()-2; i >= 0; i--) {
	        int currentLength = lastCutPosition - list.get(i);
	        
	        if (currentLength > mid) {
	            cut_num++;
	            lastCutPosition = list.get(i + 1);
	            positions.add(lastCutPosition);
	            
	            if (cut_num> C||lastCutPosition-list.get(i) > mid) {
	                return false;
	            }
	        }
	    }
		
		if (cut_num < C && list.size() > 1) {
	        CutPosition = list.get(1);
	    }
		else {
	        CutPosition = positions.isEmpty() ? list.get(1) : positions.get(positions.size() - 1);
	    }
		
		return true;
	}
}
