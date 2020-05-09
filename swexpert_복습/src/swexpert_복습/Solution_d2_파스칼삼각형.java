package swexpert_복습;

import java.util.Scanner;

public class Solution_d2_파스칼삼각형 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			int[][] dp = new int[N][];
			
			for (int i = 0; i < N; i++) {
				dp[i] = new int[i+1];
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < dp[i].length; j++) {                                
					if(j== 0 || j==dp[i].length-1) {
						dp[i][j] = 1;
					}else {
						dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
					}
				}
			}
			
//			System.out.println("#"+tc);
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < dp[i].length; j++) {
//					if(j!=dp[i].length-1) {
//						System.out.print(dp[i][j]+" ");
//					}else {
//						System.out.print(dp[i][j]);
//					}
//				}
//				System.out.println();
//			}
		}
		
	}

}
