import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashSet<String> set = new HashSet<>();

		ArrayList<String> strList = new ArrayList<String>();

		for (int i = 0; i < n; i++) {
			set.add(br.readLine());
		}

		for (int i = 0; i < m; i++) {
			String str = br.readLine();
			if (set.contains(str)) {
				strList.add(str);
			}

		}

		Collections.sort(strList);

		System.out.println(strList.size());

		for (String s : strList) {
			System.out.println(s);
		}
	}
}