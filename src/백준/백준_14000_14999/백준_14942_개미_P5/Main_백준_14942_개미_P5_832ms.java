package 백준.백준_14000_14999.백준_14942_개미_P5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// for all room (i, j), there exists only one path room i to j
// non-cycle 
public class Main_백준_14942_개미_P5_832ms {
	static int N;
	static Ant[] ant;
	static Map<Integer, ArrayList<Integer>> map;
	static ArrayList<Path>[] path;
	
	static class Path {
		int room, len;
		
		Path(int room, int len){
			this.room = room;
			this.len = len;
		}
	}
	
	static class Ant {
		int power, location;
		
		Ant(int power){
			this.power = power;
			this.location = 0; // 
		}
	}
	
	static void dfs(int idx) {
//		System.out.println("CHECK: " + idx);
		ArrayList<Integer> idxAnts = map.get(idx);
		ant[idx].location = idx; 
		
		for(Path p: path[idx]) { // p->idx:len
//			System.out.println("PATH room-len: " + p.room + "-" + p.len);
			
			if(ant[p.room].location != 0) continue; 
//			System.out.println("DFS");
			dfs(p.room);
			ArrayList<Integer> pAnts = map.get(p.room);
			for(int a : pAnts) {
//				System.out.println(idx + "-"+a + "-power-" + ant[a].power);
				if(ant[a].power >= p.len) {
					ant[a].power -= p.len; // idx로 이동
					idxAnts.add(a);
					ant[a].location = idx;
				} 
				
//				System.out.println(idx + "-"+a + "-location-" + ant[a].location);
			}
//			map.remove(p.room); // 다시 방문하지 않아서 지우지 않아도 됨
		}
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // <= 10^5
		ant = new Ant[N+1]; // <= 100,000
		map = new HashMap<>(); // key : Room No., value : Ant No.s
		path = new ArrayList[N+1]; // 연결된 길
		
		for(int n=1; n<=N; n++) {
			path[n] = new ArrayList<>();
			ant[n] = new Ant(Integer.parseInt(br.readLine()));
			ArrayList<Integer> list = new ArrayList<>();
			list.add(n);
			map.put(n, list);
		}
		
		
		for(int e=1; e<N; e++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			path[a].add(new Path(b, c));
			path[b].add(new Path(a, c));
		}
		
		dfs(1);
		
		for(int n=1; n<=N; n++) sb.append(ant[n].location).append('\n');
		
		System.out.print(sb);
		br.close();
	}

}
