package swexpert_복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList; 
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_d4_PokerGame {
	
	static ArrayList<Character> rank;
	static HashMap<Character,Integer> rankCheck;
	static HashMap<Character,Integer> suitCheck;

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		rank = new ArrayList<Character>();
		rank.add('A');
		rank.add('2');
		rank.add('3');
		rank.add('4');
		rank.add('5');
		rank.add('6');
		rank.add('7');
		rank.add('8');
		rank.add('9');
		rank.add('T');
		rank.add('J');
		rank.add('Q');
		rank.add('K');
		for (int t = 1; t <= TC; t++) {
			String[] cards = new String[5];
			rankCheck = new HashMap<Character,Integer>();
			suitCheck = new HashMap<Character,Integer>();

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 5; i++) {
				cards[i] = st.nextToken();
			}// end input
			
			String res = check(cards);
			
			sb.append("#"+t+" "+res+"\n");
			
		}// end test case
		System.out.println(sb);
	}// end main

	private static String check(String[] cards) {
		
		// 카드 분류.
		for (int i = 0; i < cards.length; i++) {
			if(rankCheck.get(cards[i].charAt(1)) == null) {
				rankCheck.put(cards[i].charAt(1),1);				
			}else {
				rankCheck.replace(cards[i].charAt(1), rankCheck.get(cards[i].charAt(1))+1);
			}
			
			if(suitCheck.get(cards[i].charAt(0)) == null) {
				suitCheck.put(cards[i].charAt(0),1);				
			}else {
				suitCheck.replace(cards[i].charAt(0), suitCheck.get(cards[i].charAt(0))+1);
			}
		}
		
		int suitLen = suitCheck.size();
		int rankLen = rankCheck.size();
		
		// Straight Flush
		if(suitLen == 1) {
			int max = -1;
			int min = 20;
			int sum = 0;
			for (Character chr : rankCheck.keySet()) {
				int idx = rank.indexOf(chr);
				
				if(max <= idx) {
					max = idx;
				}
				
				if(min >= idx) {
					min = idx;
				}
				
				sum += idx;
			}
			if(max - min == 4) {
				return "Straight Flush";
			}
			
			if(sum == 42) {
				return "Straight Flush";
			}
		}
		
		// Four of a Kind
		if(rankLen != 1) {
			int max = 0;
			int min = 20;
			for (Character chr : rankCheck.keySet()) {
				int val = rankCheck.get(chr);
				
				if(max <= val) {
					max = val;
				}
				
				if(min >= val) {
					min = val;
				}
			}
			if(max == 4) {				
				return "Four of a Kind";
			}
//			System.out.println(max);
//			System.out.println(min);
			if(max == 3 && min == 2) { // S5 H5 D7 S7 H7
				return "Full House";
			}
		}
		
		// flush
		if(suitLen == 1) {
			return "Flush";
		}
		
		
		// Straight SA S2 D3 H4 C5
		// 그냥 준 조건 변수이름 때문에
		if(suitLen != 1) {
			int max = -1;
			int min = 20;
			int sum = 0;
			for (Character chr : rankCheck.keySet()) {
				int idx = rank.indexOf(chr);
				if(max <= idx) {
					max = idx;
				}
				
				if(min >= idx) {
					min = idx;
				}
				
				sum += idx;
			}
			
			if(max - min == 4) {
				return "Straight";
			}
			
			if(sum == 42) {
				return "Straight";
			}
		}
		
		// Three of a kind
		if(rankLen != 1) {
			int max = 0;
			for (Character chr : rankCheck.keySet()) {
				int val = rankCheck.get(chr);
				
				if(max <= val) {
					max = val;
				}
			}
			if(max == 3) {				
				return "Three of a kind";
			}
		}
		
		// Two pair
		if(rankLen != 1) {
			int cnt = 0;
			for (Character chr : rankCheck.keySet()) {
				int val = rankCheck.get(chr);
				
				if(val == 2) {
					cnt++;
				}
			}
			if(cnt == 2) {				
				return "Two pair";
			}
		}
		
		// One pair
		if(rankLen == 4) {				
			return "One pair";
		}
		
		return "High card";
	}

}

