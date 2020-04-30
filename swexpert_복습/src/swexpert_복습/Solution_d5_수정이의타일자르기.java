package swexpert_복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_d5_수정이의타일자르기 {
	
	static int N,M;
	
	static int[] tiles;
	static PriorityQueue<Rectangle> list;
	
	static int cnt;
	
	static class Rectangle implements Comparable<Rectangle>{
		int max;
		int min;
		
		public Rectangle(int w, int h) {
			super();
			this.max = Math.max(w, h);
			this.min = Math.min(w, h);
		}

		@Override
		public int compareTo(Rectangle o) {
			return o.min - this.min;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			tiles = new int[N];
			list = new PriorityQueue<Rectangle>();
			cnt = 1;
			list.add(new Rectangle(M,M));
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				tiles[i] = 1<<Integer.parseInt(st.nextToken()); 
			}
			
			Arrays.sort(tiles);
			
			for (int i = N-1; i >= 0; i--) {
				cutRectangle(i);
			}
			
			
			System.out.println("#"+t+" "+cnt);
		}

	}

	private static void cutRectangle(int i) {
		Rectangle rtgl = list.poll();
		
		if(rtgl.min >= tiles[i]) {
			list.offer(new Rectangle(rtgl.min-tiles[i],tiles[i]));
			list.offer(new Rectangle(rtgl.min,rtgl.max-tiles[i]));
		}else {
			list.offer(rtgl);
			list.offer(new Rectangle(M-tiles[i],tiles[i]));
			list.offer(new Rectangle(M,M-tiles[i]));
			cnt++;
		}
		
	}

}
