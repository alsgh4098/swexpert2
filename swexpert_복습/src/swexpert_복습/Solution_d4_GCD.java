package swexpert_복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_d4_GCD {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		long TC = Long.parseLong(br.readLine());
		
//        GCD(a,0) = a
//        GCD(a,b) = GCD(b, a%b)
		for (int t = 1; t <= TC; t++) {
			int K = Integer.parseInt(br.readLine());
			
			long[] dp = new long[K+2];
			
			dp[0] = 1L;
			dp[1] = 1L;
			
			for (int i = 2; i <= K+1; i++) {
				dp[i] = dp[i-1] + dp[i-2];
			}
			
			sb.append("#"+t+" "+dp[K+1]+" " +dp[K]+"\n");
		}
		
		System.out.println(sb);
	}


}

