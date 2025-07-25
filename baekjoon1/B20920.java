package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class B20920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<String> list = new ArrayList<>();
		
		String[] arr = new String[n];
		for(int i = 0; i<n;i++) {
			arr[i] = br.readLine();
		}
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for(int i = 0; i<n;i++) {
			if(arr[i].length()>=m) {
				if(map.containsKey(arr[i])) {
					map.put(arr[i], map.get(arr[i])+1);
				}
				else {
					map.put(arr[i], 1);
				}
			}
		}
		List<String> keys = new ArrayList<>(map.keySet());
		Collections.sort(keys, new Comparator<String>() {
		    public int compare(String A, String B) {
		        if (map.get(A).equals(map.get(B))) {
		            if (A.length() == B.length()) {
		                return A.compareTo(B);
		            }
		            return B.length() - A.length();
		        }
		        return map.get(B) - map.get(A);
		    }
		});
		StringBuilder sb = new StringBuilder();
        for (String word : keys) {
            sb.append(word).append("\n");
        }
        System.out.print(sb);
		
	}
}
