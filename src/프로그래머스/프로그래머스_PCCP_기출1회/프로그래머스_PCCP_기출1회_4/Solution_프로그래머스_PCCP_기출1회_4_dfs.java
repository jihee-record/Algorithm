package 프로그래머스.프로그래머스_PCCP_기출1회.프로그래머스_PCCP_기출1회_4;

class Solution_프로그래머스_PCCP_기출1회_4_dfs {
    static int N, M;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static boolean[][] visitedRed, visitedBlue; 
    static int answer;
    
    static void dfs(int[][] maze, int redR, int redC, int blueR, int blueC, int cnt, boolean redFix, boolean blueFix) {
    	if(redFix && blueFix) {
    		answer = Math.min(cnt, answer);
    		return;
    	}
    	
    	if(answer <= cnt) return;
    	
	      for(int i=0; i<4; i++){
		      int nRedR = redR;
		      int nRedC = redC;
		
		      boolean nRedFix = redFix;
		      if(!redFix) {
		          nRedR += dr[i];
		          nRedC += dc[i];
		
		          if(nRedR < 0 || nRedR >= N || nRedC < 0 || nRedC >= M) continue;
		          if(visitedRed[nRedR][nRedC]) continue;
		          if(maze[nRedR][nRedC] == 5) continue;
		          if(maze[nRedR][nRedC] == 3) nRedFix = true;
		      }
		      
		
		      for(int j=0; j<4; j++){
		    	  int nBlueR = blueR;
			      int nBlueC = blueC;
			      
			      boolean nBlueFix = blueFix;
			      if(!blueFix) {
			    	  nBlueR += dr[j];
			    	  nBlueC += dc[j];
		
			          if(nBlueR < 0 || nBlueR >= N || nBlueC < 0 || nBlueC >= M) continue;
			          if(visitedBlue[nBlueR][nBlueC]) continue; // 이미 방문
			          if(maze[nBlueR][nBlueC] == 5) continue; // 벽
			          if(maze[nBlueR][nBlueC] == 4) nBlueFix = true; 
			      }

			      if(nRedR == nBlueR && nRedC == nBlueC) continue; // 같은 곳 이동 불가
			      if(nRedR == blueR && nRedC == blueC && nBlueR == redR && nBlueC == redC) continue; // 교차 불가
		          
		          visitedRed[nRedR][nRedC] = true;
		          visitedBlue[nBlueR][nBlueC] = true;
		          
		          dfs(maze, nRedR, nRedC, nBlueR, nBlueC, cnt + 1, nRedFix, nBlueFix);
		          
		          visitedRed[nRedR][nRedC] = false;
		          visitedBlue[nBlueR][nBlueC] = false;
		      }
	      }
    	
    }
    
    static int solution(int[][] maze) {
        N = maze.length;
        M = maze[0].length;
        
        answer = 100;

        int[] red = new int[2];
        int[] blue = new int[2];

        boolean redOk = false, blueOk = false;
        
        outloop:
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!redOk && maze[i][j] == 1) {
                    red[0] = i;
                    red[1] = j;
                    redOk = true;
                }

                if(!blueOk && maze[i][j] == 2){
                    blue[0] = i;
                    blue[1] = j;
                    blueOk = true;
                }

                if(redOk && blueOk) break outloop;
            }
        }

        visitedRed = new boolean[N][M];
        visitedBlue = new boolean[N][M];
        visitedRed[red[0]][red[1]] = true;
        visitedBlue[blue[0]][blue[1]] = true;
        
        dfs(maze, red[0], red[1], blue[0], blue[1], 0, false, false);

        return answer == 100 ? 0 : answer;
    }
    
    public static void main(String[] args) {
		int[][] maze = {{1, 5}, {2, 5}, {4, 5}, {3, 5}};
		
		System.out.println(solution(maze)); 
	}
}