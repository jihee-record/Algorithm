package 백준.백준_2000_2999.백준_2468_안전영역_S1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2468_안전영역_S1_184ms {
	
	static int[] x= {-1,1,0,0};
	static int[] y= {0,0,1,-1};
	static int[][] map;
	static int n;
	
	static boolean[][] dfs(int i, int j, int rain, boolean[][] visited) {
		for(int k=0; k<4; k++) {
			int row = i+y[k];
			int col = j+x[k];
			
			if(col>=0 && row>=0 && col<n && row<n && map[row][col]>rain && !visited[row][col]) {
				visited[row][col]=true;
				visited = dfs(row, col, rain, visited);
			}
		}
		
		return visited;
	}
	
	static int visited(int rain) {
		int safe_area=0;
		boolean[][] visited = new boolean[n][n];
		for(int row=0; row<n; row++) {
			for(int col=0; col<n; col++) {
				if(map[row][col]>rain && !visited[row][col]) {
					visited[row][col] = true;
					safe_area++;
					visited=dfs(row, col, rain, visited);
				}
			}
		}
		return safe_area;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		StringTokenizer st;
		//현재 받은 높이
		int h;
		//여태까지 받은 마을 높이 중 가장 높은 높이
		int max_height = 0;
		//모든 강수량에 따른 최대 안전지역의 개수
		int max_safe_area=0;
		
		for(int row=0; row<n; row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0; col<n; col++) {
				h = Integer.parseInt(st.nextToken());
				max_height = Math.max(max_height, h);
				map[row][col] = h;
			}
		}
		
		//rain 강수량
		for(int rain=0; rain<max_height; rain++) {
			//강수량에 따른 안전지역의 개수
			int safe_area = visited(rain);
			max_safe_area = Math.max(max_safe_area, safe_area);
		}
		
		System.out.println(max_safe_area);
		
		br.close();
		
	}
}