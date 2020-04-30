package swexpert_복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution_d4_최소스패닝트리_프림 {
	
	static class Node implements Comparable<Node>{
		int idx;
		long weight;
		
		public Node(int idx, long weight) {
			super();
			this.idx = idx;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			if(this.weight > o.weight) {
				return 1;
			}else if(this.weight == o.weight) {
				return 0;
			}else {
				return -1;
			}
		}
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			String[] line = br.readLine().split(" ");
			
			int N = Integer.parseInt(line[0]);
			int E = Integer.parseInt(line[1]);
			
			ArrayList<Node>[] list = new ArrayList[N+1];
			
			for (int i = 1; i < N+1; i++) {
				list[i] = new ArrayList<Node>();
			}
			
			for (int i = 0; i < E; i++) {
				line = br.readLine().split(" ");
				int ths = Integer.parseInt(line[0]);
				int tht = Integer.parseInt(line[1]);
				int weight = Integer.parseInt(line[2]);
				
				list[ths].add(new Node(tht,weight));
				list[tht].add(new Node(ths,weight));
			}
			
			boolean[] visited = new boolean[N+1];
			long[] dist = new long[N+1];
			
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[1] = 0;
			
			PriorityQueue<Node> pq = new PriorityQueue<Node>();
			
			pq.add(new Node(1,dist[1]));
			
			while(!pq.isEmpty()) {
				Node ths = pq.poll();
				
				// 방문조건이 중요함.
				visited[ths.idx] = true;
				
				for (Node tht : list[ths.idx]) {
	                if(!visited[tht.idx]) {
						if(dist[tht.idx] > tht.weight) {
							dist[tht.idx] = tht.weight;
							pq.add(new Node(tht.idx,dist[tht.idx]));
						}
	                }
				}
			}
			
			long res = 0;
			
			for (int i = 1; i < dist.length; i++) {
				res += dist[i];
			}
			sb.append("#"+t+" "+res+"\n");
		}
		System.out.println(sb);
		
	}

}
