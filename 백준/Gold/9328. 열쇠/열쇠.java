import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			String[] field = new String[h];
			for (int i = 0; i < h; i++) {
				field[i] = br.readLine();
			}

			int bit = 0;
			String key = br.readLine();
			if (!key.equals("0")) {
				for (char c : key.toCharArray()) {
					bit |= (1 << (c - 'a'));
				}
			}

			// 테두리에 있는 문서 미리 먹기
			int cnt = 0;
			StringBuilder sb2;
			for (int i = 0; i < h; i++) {
				if (field[i].charAt(0) == '$') {
					cnt++;
					sb2 = new StringBuilder(field[i]);
					sb2.setCharAt(0, '.');
					field[i] = sb2.toString();
				}
				if (field[i].charAt(w - 1) == '$') {
					cnt++;
					sb2 = new StringBuilder(field[i]);
					sb2.setCharAt(w - 1, '.');
					field[i] = sb2.toString();
				}
			}
			for (int i = 1; i < w - 1; i++) {
				if (field[0].charAt(i) == '$') {
					cnt++;
					sb2 = new StringBuilder(field[0]);
					sb2.setCharAt(i, '.');
					field[0] = sb2.toString();
				}
				if (field[h - 1].charAt(i) == '$') {
					cnt++;
					sb2 = new StringBuilder(field[h - 1]);
					sb2.setCharAt(i, '.');
					field[h - 1] = sb2.toString();
				}
			}

			Queue<int[]> q = new LinkedList<>();
			boolean[][] visited;

			while (true) {
				List<int[]> list = search(field, h, w, bit);
				if (list.isEmpty()) break;

				for (int[] c : list) q.add(c);
				visited = new boolean[h][w];
				int newKey = 0;

				while (!q.isEmpty()) {
					int[] c = q.poll();
					int x = c[0], y = c[1];
					if (visited[x][y]) continue;
					visited[x][y] = true;

					char cur = field[x].charAt(y);
					if (cur == '$') {
						cnt++;
						field[x] = new StringBuilder(field[x]).replace(y, y + 1, ".").toString();
					} else if (cur >= 'a' && cur <= 'z') {
						int k = cur - 'a';
						if ((bit & (1 << k)) == 0) newKey++;
						bit |= (1 << k);
						field[x] = new StringBuilder(field[x]).replace(y, y + 1, ".").toString();
					}

					for (int d = 0; d < 4; d++) {
						int nx = x + dx[d];
						int ny = y + dy[d];
						if (nx >= 0 && ny >= 0 && nx < h && ny < w && !visited[nx][ny]) {
							char next = field[nx].charAt(ny);
							if (next == '.' || next == '$' || (next >= 'a' && next <= 'z') ||
								(next >= 'A' && next <= 'Z' && (bit & (1 << (next - 'A'))) != 0)) {
								q.add(new int[]{nx, ny});
							}
						}
					}
				}

				if (newKey == 0) break; // 더 이상 열쇠 추가 없음
			}

			sb.append(cnt).append("\n");
		}

		System.out.print(sb.toString().trim());
	}

	static List<int[]> search(String[] field, int h, int w, int bit) {
		List<int[]> spot = new ArrayList<>();

		for (int i = 0; i < h; i++) {
			char left = field[i].charAt(0);
			if (canEnter(left, bit)) spot.add(new int[]{i, 0});

			char right = field[i].charAt(w - 1);
			if (canEnter(right, bit)) spot.add(new int[]{i, w - 1});
		}

		for (int i = 1; i < w - 1; i++) {
			char top = field[0].charAt(i);
			if (canEnter(top, bit)) spot.add(new int[]{0, i});

			char bottom = field[h - 1].charAt(i);
			if (canEnter(bottom, bit)) spot.add(new int[]{h - 1, i});
		}

		return spot;
	}

	static boolean canEnter(char ch, int bit) {
		return ch == '.' || ch == '$' || (ch >= 'a' && ch <= 'z') ||
		       (ch >= 'A' && ch <= 'Z' && (bit & (1 << (ch - 'A'))) != 0);
	}
}
