package SWEA.SWEA_1000_1999.SWEA_1206_View_D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_SWEA_1206_View_D3_이지희_124ms {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        for(int k=1; k<=10; k++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
             
            int[] heights = new int[N];
            for(int i=0; i<N; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
            }
             
            int result = 0;
            for(int i=2; i<N-2; i++) {
                int sightMin = Math.min(Math.min(heights[i]-heights[i-1], heights[i]-heights[i-2]), Math.min(heights[i]-heights[i+1], heights[i]-heights[i+2]));
                 
                if(sightMin>0) {
                    result += sightMin;
                }
            }
             
            System.out.println("#"+k+" "+result);
        }
        br.close();
    }
}