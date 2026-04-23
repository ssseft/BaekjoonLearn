import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		long[][] sum = new long[n][2];
		sum[0][0] = a;
		sum[0][1] = -a;
		long max = Long.MIN_VALUE;

		for (int i = 1; i < n; i++) {
			int c = Integer.parseInt(st.nextToken());
			if (i % 2 == 1) {
				sum[i][0] = sum[i - 1][0] - c;
				sum[i][1] = sum[i - 1][1] + c;
			} else {
				sum[i][0] = sum[i - 1][0] + c;
				sum[i][1] = sum[i - 1][1] - c;
			}
		}

		long minOdd = 0L;
		long maxEven = Long.MIN_VALUE;

		for (int r = 0; r < n; r++) {
			long P = sum[r][0];
			long cand1 = P - minOdd;
			if (cand1 > max)
				max = cand1;
			if (maxEven != Long.MIN_VALUE) {
				long cand2 = maxEven - P;
				if (cand2 > max)
					max = cand2;
			}
			if ((r % 2 == 0)) {
				if (P > maxEven)
					maxEven = P;
			} else {
				if (P < minOdd)
					minOdd = P;
			}
		}

		System.out.println(max);
	}
}
