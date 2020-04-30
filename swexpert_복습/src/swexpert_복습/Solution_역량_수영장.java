package swexpert_복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_역량_수영장 {
	
	static int[] schedule;
	static int[] cost;
	static int min;
			
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			schedule = new int[13];
			cost = new int[4];
			min = Integer.MAX_VALUE;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++) {
				schedule[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(1,0);
			
			int d1m3mC = min;
			
			int yearC = cost[3];
			
			sb.append("#"+t+" "+Math.min(d1m3mC,yearC)+"\n");
			
		}// end testcase
		System.out.println(sb);
	}// end main

	private static void dfs(int month,int sum) {
		if(month >= 13) {
			if(min>sum) {
				min = sum;
			}
			return;
		}
		
		// 일일권
		dfs(month+1,sum+cost[0]*schedule[month]);
		// 한달권
		dfs(month+1,sum+cost[1]);
		// 세달권
		dfs(month+3,sum+cost[2]);
		
	}

}
