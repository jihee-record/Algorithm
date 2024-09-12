package 백준.백준_14000_14999.백준_14502_연구소_G4;

import java.io.*;
import java.util.*;

public class Main_백준_14502_연구소_G4_480ms {
	
	static int N, M;
	static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int[][] lab;
	static ArrayList<int[]> initVirus = new ArrayList<>(); //초기 바이러스 위치
	static ArrayList<int[]> initEmpty = new ArrayList<>(); //초기 빈 공간 위치
	static int initVirusCount, initEmptyCount, initwallCount;
	
	static void bruteForce() {
		int maxSafeArea = 0;
		for(int i=0; i<initEmptyCount-2; i++) {
			for(int j=i+1; j<initEmptyCount-1; j++) {
				for(int k=i+2; k<initEmptyCount; k++) {
					int[] wall1 = initEmpty.get(i);
					int[] wall2 = initEmpty.get(j);
					int[] wall3 = initEmpty.get(k);
					
					lab[wall1[0]][wall1[1]] = 1;
					lab[wall2[0]][wall2[1]] = 1;
					lab[wall3[0]][wall3[1]] = 1;
					
					maxSafeArea = Math.max(maxSafeArea, bfs());
					
					lab[wall1[0]][wall1[1]] = 0;
					lab[wall2[0]][wall2[1]] = 0;
					lab[wall3[0]][wall3[1]] = 0;
				}
			}
		}
		System.out.println(maxSafeArea);
	}
	
	static int bfs() {
		int[][] tempLab = new int[N][M];
		for (int i = 0; i < N; i++) {
			tempLab[i] = Arrays.copyOf(lab[i], M);
		}
		
		Queue<int[]> queue = new LinkedList<>();
		queue.addAll(initVirus);
		
		int virusCount = initVirusCount;
		while(!queue.isEmpty()) {
			int[] virus = queue.poll();
			int x = virus[0];
			int y = virus[1];
			
			for(int[] direction: directions) {
				int nx = x + direction[0];
				int ny = y + direction[1];
				
				if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
				if(tempLab[nx][ny] == 0) {
					tempLab[nx][ny] = 2;
					virusCount ++;
					queue.add(new int[] {nx, ny});
				}
			}
		}
		return N*M - virusCount - initwallCount - 3;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lab = new int[N][M];
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int m=0; m<M; m++) {
				lab[n][m] = Integer.parseInt(st.nextToken());
				if(lab[n][m] == 2) {
					initVirus.add(new int[]{n, m});
					continue;				
				}
				
				if(lab[n][m] == 0) {
					initEmpty.add(new int[]{n, m});
				}
			}
		}
		
		initVirusCount = initVirus.size();
		initEmptyCount = initEmpty.size();
		initwallCount = N*M - initVirusCount - initEmptyCount;
		
		bruteForce();
		br.close();
	}
}
