package swexpert_복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d3_햄버거다이어트 {
	
	static int N,L;
	
	static int max;
	
	static int[] kal;
	static int[] scr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			
			L = Integer.parseInt(st.nextToken());
			
			kal = new int[N];
			scr = new int[N];
			max = Integer.MIN_VALUE;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				scr[i] = Integer.parseInt(st.nextToken());
				kal[i] = Integer.parseInt(st.nextToken());
			}
			
			find(0,0,0);
			
			sb.append("#"+tc+" "+max+"\n");
		}// end test case
		System.out.println(sb);
	}// end main

	private static void find(int idx,int ssum,int ksum) {
		if(idx == N) {
			if(ksum <= L && max < ssum) {
				max = ssum;
				return;
			}else {
				return;
			}
		}
		
		find(idx+1,ssum+scr[idx],ksum+kal[idx]);
		find(idx+1,ssum,ksum);
	}

}
