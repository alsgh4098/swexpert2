package swexpert_복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_d4_자기방으로돌아가기 {
	
	static int N;
	static int[] room;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int TC = Integer.parseInt(st.nextToken());
		
		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			room = new int[401];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int ths = Integer.parseInt(st.nextToken());
				int tht = Integer.parseInt(st.nextToken());
				
				if(ths>tht) {
					int temp = ths;
					ths = tht;
					tht = temp;
				}
				
				if(ths%2==0) {
					room[ths-1]++;
					if(tht%2==1 && tht+1<=N) {
						room[tht+1]++;
					}
				}
				
				for (int j = ths; j <= tht; j++) {
					room[j]++;
				}
			}
			
			Arrays.sort(room);
			sb.append("#"+t+" "+room[400]+"\n");
		}
		System.out.println(sb);
	}

}

