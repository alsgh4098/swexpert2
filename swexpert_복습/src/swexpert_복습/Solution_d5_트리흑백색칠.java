package swexpert_복습;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution_d5_트리흑백색칠 {
	
	static final int MOD = 1000000007;

	static int N;
	static long[][] memoi;
	
	static ArrayList<Integer>[] nodes;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int t = 1; t <= TC; t++) {
			N = sc.nextInt();

			memoi = new long[2][N + 1];
			
			nodes = new ArrayList[N+1];
			
			for (int i = 1; i <= N; i++) {
				nodes[i] = new ArrayList<Integer>();
			}

			for (int i = 0; i < N - 1; i++) {
				int ths = sc.nextInt();
				int tht = sc.nextInt();
				
				nodes[ths].add(tht);
				nodes[tht].add(ths);
			}
			
			long res = (dfs(1,0,0) + dfs(1,1,0))%MOD;

			System.out.println("#" + t + " " + res);

		} // end TC

	}// end main

	static int count;

	// 0:검정 1:흰색
	// color는 parent의 색
	static long dfs(int child,int color, int parent) {
		
		if(memoi[color][child] != 0) {
			return memoi[color][child];
		}
		
		long res = 1L;
		
		if(color == 1) {
			for (int i = 0; i < nodes[child].size(); i++) {
				int tht = nodes[child].get(i);
				if(tht != parent) {
					res *= dfs(tht,1,child) + dfs(tht,0,child)%MOD;
				}
			}
		}else {
			for (int i = 0; i < nodes[child].size(); i++) {
				int tht = nodes[child].get(i);
				if(tht != parent) {
					res *= dfs(tht,1,child)%MOD;		
				}
			}
		}
		
		memoi[color][child] += res % MOD;					
		
		return memoi[color][child];
		
	}

}