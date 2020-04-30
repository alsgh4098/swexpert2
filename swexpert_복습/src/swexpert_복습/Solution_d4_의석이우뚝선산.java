package swexpert_복습;

import java.io.IOException;
import java.util.Scanner;
public class Solution_d4_의석이우뚝선산 {
	
	static int N;
	
	static int[] mountains;
	
	static int mntn;
	
	static int climb;
	static int slide;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int t = 1; t <= TC; t++) {
			N = sc.nextInt();
			
			mountains = new int[N];
			
			for (int i = 0; i < N; i++) {
				mountains[i] = sc.nextInt();
			}// end input
			
			mntn = 0;
			
			climb = 0;
			slide = 0;
			
			int nstart = 0;
			
			int state = 0;
			
			for (int start = nstart; start < N-1; start++) {
				
				if(mountains[start] < mountains[start+1] && state != 1) {
					climb++;
				}else if(mountains[start] > mountains[start+1]){
					slide++;
					state = 1;
				}else if(state == 1){
					mntn += (climb)*slide;
					climb = 0;
					slide = 0;
					start--;
					state = 0;
				}
			}
			
			mntn += (climb)*slide;
			
			System.out.println("#"+t+" "+mntn);
		}// end testcase
		
		
	}// end main

}

