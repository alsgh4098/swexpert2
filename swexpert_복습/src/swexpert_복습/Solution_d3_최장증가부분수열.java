package swexpert_복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_d3_최장증가부분수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] dp = new int[N];
			
			Arrays.fill(dp, 1);
			
			int max = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < i; j++) {
					if(arr[i]>arr[j] && dp[i] < dp[j] + 1) {
						dp[i] = dp[j] + 1;
					}
				}
				if(max < dp[i]) {
					max = dp[i];
				}
			}
			
			sb.append("#"+t+" "+max+"\n");
		}
		System.out.println(sb);
	}

}
