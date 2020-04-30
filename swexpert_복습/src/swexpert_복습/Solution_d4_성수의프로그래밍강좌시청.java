package swexpert_복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_d4_성수의프로그래밍강좌시청 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] nums = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			
			Arrays.sort(nums);
			
//			for (int i = 0; i < nums.length; i++) {
//				System.out.println(nums[i]);
//			}
			
			double sungsu = 0;
			
			for (int i = N-M; i < N; i++) {
				System.out.println(i);
				sungsu = (sungsu+nums[i])/2;
			}
			
			sb.append("#"+t+" "+sungsu);
		}
		System.out.println(sb);
	}

}
