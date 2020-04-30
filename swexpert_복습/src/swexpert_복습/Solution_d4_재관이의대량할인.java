package swexpert_복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution_d4_재관이의대량할인{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			long[] arr = new long[N];
			 
			String[] line = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				arr[i] = Long.parseLong(line[i]);
			}
			
			Arrays.sort(arr);
			
			long res = 0;
			int cnt = 0;
			
			for (int i = N-1; i >= 0; i--) {
				long val = arr[i];
				
				if(cnt == 2) {
					cnt = 0;
					continue;
				}else {
					res += val;
				}
				cnt++;
			}
			System.out.println("#"+tc+" "+res);
		}// end testcase
	}// end main

}
