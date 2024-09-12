package SWEA.SWEA_21000_21999.SWEA_21131_행렬정렬_D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_SWEA_21131_행렬정렬_D3_이지희_206ms {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
 
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N+1][N+1];
 
            // N * N 배열 생성
            for(int i = 1; i <= N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int j = 1; j <= N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
 
            int count = 0;
            for(int x=N; x>=1; x--){
                if(count%2 == 0){ //정렬을 하지 않은 상태
                    if(arr[x][x-1] < arr[x-1][x]){ //Trans 해줘야해
                        count++;
                    }
                }else { //한번 뒤집어진 상태
                    if(arr[x][x-1] > arr[x-1][x]) {
                        count++;
                    }
                }
            }
 
            sb.append(count).append("\n");
        } // end of testCase
         
        System.out.println(sb.toString());
        br.close();
    } // end of main
} // end of class