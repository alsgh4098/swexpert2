package swexpert_복습;

import java.util.Scanner;

public class Solution_d3_홀수피라미드 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {

			int N = sc.nextInt();
			
			if(N==1) {
				System.out.println("#"+tc+" "+"1"+" "+"1");
				continue;
			}
			
			
			long a = 1;
			
			long S = 0;
			long F = 0;
			long D = 4;
			
			while(N-1 != 0) {
				N--;
				S = a+2;
				F = S+D;
				a = F;
				D += 4;
			}
			System.out.println("#"+tc+" "+S+" "+F);
		}
	}

}
