package swexpert_복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_d4_다항식계산2 {
	
	static long[] fctr = new long[1000001];
	
	// p
	static int mod = 1234567891;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		fctr[1] = 1;
		
		for (int j = 2; j <= 1000000; j++) {
			fctr[j] = j * fctr[j-1]%mod;
		}
		
		for (int t = 1; t <= TC; t++) {
			String[] line = br.readLine().split(" ");
			
			int n = Integer.parseInt(line[0]);
			int r = Integer.parseInt(line[1]);
			
			long top = fctr[n] % mod;
			
			// a^-1
			long bttm = fctr[r] % mod * fctr[n-r] % mod;
			
//			long fermat = pow2(bttm,mod-2)%mod;
//			System.out.println(fermat);
//			조합공식으로 한번 돌려봣는데 테케 1개 통과.
//			뭐가 문젠지 모르겠다.
//			
			sb.append("#"+t+" "+((top/bttm)%mod)+"\n");
		}// end testcase
		
		System.out.println(sb);
	}// end main
	
//	static long pow2(long number, int n) {
//		long res = 1;
//		System.out.println(number);
//		while(n != 0) {
//			res *= number%mod;
//			System.out.println(res);
//			n--;
//		}
//		System.out.println(res);
//		return res;
//	}
//	
//	
//	// log(N)복잡도로 거듭제곱구하는 알고리즘
//	static long pow(long number, int n) {
//		// 0승은 1을 리턴
//		if( n == 0) {
//			return 1;
//		}
//		
//		// n이 짝수인경우는 지수 나누기 2
//		// n이 홀수인경우는 지수-1하고 나누기2인데
//		// /2로 동시에 처리된다.
//		long res = pow(number, n/2)%mod;
//		// 계산을 한번으로 줄이기 위해서
//		long temp = res*res%mod;
//		
//		// n이 짝수인경우엔 지수를 나누기 2한것을 두번곱해준다(temp).
//		if(n % 2 == 0) {
//			return temp%mod;
//		// n이 홀수인경우엔 지수에 1을빼고 나누기2한것을 두번곱해주고(temp), 제곱한 그 수 a를 한번 곱해준다.
//		// 예를들어 4^7이면  4^7 = 4*4^3*4*3
//		}else {
//			return temp*number%mod;
//		}
//	}

}

