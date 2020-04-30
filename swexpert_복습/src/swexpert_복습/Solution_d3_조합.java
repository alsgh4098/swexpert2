package swexpert_복습;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_d3_조합 {
	static int MOD = 1234567891;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			long fac[] = new long[n + 1];
			fac[0] = 1;
			for (int i = 1; i <= n; i++) {
				fac[i] = (fac[i - 1] * i) % MOD;
			}
			long b = (fac[r] * fac[n - r]) % MOD;
			long rb = fermat(b, MOD - 2);

			System.out.println((fac[n] * rb) % MOD);
		}
	}

	private static long fermat(long n, int x) {
		if (x == 0)
			return 1;
		long tmp = fermat(n, x / 2);
		long ret = (tmp * tmp) % MOD;
		if (x % 2 == 0)
			return ret;
		else
			return (ret * n) % MOD;
	}
}