package swexpert_복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d4_극한의청소작업 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String A = st.nextToken();
			String B = st.nextToken();
			
			boolean a_is_min = false;
			boolean b_is_min = false;
			
			if(A.contains("-")) {
				a_is_min = true;
				A = A.replace("-", "");
			}
			if(B.contains("-")) {
				b_is_min = true;
				B = B.replace("-", "");
			}
			
			
			long a_num = 0;
			for (int i = 0; i < A.length(); i++) {
				int n = A.length()-1-i;
				int num = A.charAt(i)-'0';
				
				if(i == A.length()-1) {
					if(num < 4) {
						a_num += num;
					}else {
						a_num += num-1;
					}
					break;
				}
				
				
				if(num < 4) {
					a_num += (num)*Math.pow(9, n);
				}else {
					a_num += (num-1)*Math.pow(9, n);
				}
			}
			
			long b_num = 0;
			for (int i = 0; i < B.length(); i++) {
				int n = B.length()-1-i;
				int num = B.charAt(i)-'0';
				
				if(i == B.length()-1) {
					if(num < 4) {
						b_num += num;
					}else {
						b_num += num-1;
					}
					break;
				}
				
				
				if(num < 4) {
					b_num += (num)*Math.pow(9, n);
				}else {
					b_num += (num-1)*Math.pow(9, n);
				}
			}
//			System.out.println(b_num);
			
			if(!b_is_min && a_is_min) {
				sb.append("#"+t+" "+(b_num+a_num-1)+"\n");
			}else if(b_is_min && a_is_min){
				sb.append("#"+t+" "+(a_num-b_num)+"\n");
			}else {
				sb.append("#"+t+" "+(b_num-a_num)+"\n");
			}
		}
		System.out.println(sb);
	}

}
