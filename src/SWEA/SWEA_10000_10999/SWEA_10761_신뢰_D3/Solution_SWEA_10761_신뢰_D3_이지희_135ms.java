package SWEA.SWEA_10000_10999.SWEA_10761_신뢰_D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_10761_신뢰_D3_이지희_135ms {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            
            int time = 0; // 수행완료시간
            int time1 = 0; // B수행완료시간
            int time2 = 0; // O수행완료시간
            int location1 = 1; // B위치
            int location2 = 1; // O위치
        
            for(int n=0; n<N; n++) {
                if(st.nextToken().equals("B")) { //B수행
                    int cmd = Integer.parseInt(st.nextToken());//가야할 위치 
                    int canTime = time - time1; //그동안 내가 이동 가능한 거리 
                    int distance = Math.abs(cmd - location1); //이동해야하는 거리 
                    int t = 0; // t 수행에 걸리는 시간 
                    if(canTime >= distance ) { //내 차례 올때까지 미리 이동 가능 
                        
                    }else { // 이동시간 계산 
                        t = distance - canTime; //가야하는거리(시간)
                    }
                    t++; // 수행에 걸리는 시간 1
                    
                    time = time + t;
                    location1 = cmd; // cmd로 이동했다 
                    time1 = time; // B가 완료했을 때 시간 
                }else { //O수행
                    int cmd = Integer.parseInt(st.nextToken());
                    //t
                    int canTime = time - time2; //그동안 내가 이동 가능한 거리 
                    int distance = Math.abs(cmd - location2); //이동해야하는 거
                    int t = 0; // t 수행에 걸리는 시간 
                    if(canTime >= distance ) { //내 차례 올때까지 미리 이동 가능 
                        
                    }else { // 이동시간 계산 
                        t = distance - canTime; //가야하는거리(시간)
                    }
                    t++; // 수행에 걸리는 시간 1
                    
                    time = time + t;
                    location2 = cmd; // cmd로 이동했다 
                    time2 = time; // O가 완료했을 때 시간 
                }
            }
            
            sb.append("#").append(tc).append(" ").append(time).append("\n");
            
            
            
        }// tc
        
        System.out.println(sb.toString());
        br.close();
    }
}