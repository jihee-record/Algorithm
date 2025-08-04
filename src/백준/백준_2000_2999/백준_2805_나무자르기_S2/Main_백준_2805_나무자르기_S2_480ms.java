package 백준.백준_2000_2999.백준_2805_나무자르기_S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2805_나무자르기_S2_480ms {
  public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  StringTokenizer st = new StringTokenizer(br.readLine());
      
      int N = Integer.parseInt(st.nextToken());  
      int M = Integer.parseInt(st.nextToken());  
      
      st = new StringTokenizer(br.readLine());
      int[] trees = new int[N];
      long max = 0;
      for(int n=0; n<N; n++){
          trees[n] = Integer.parseInt(st.nextToken());
          max = Math.max(max, trees[n]);
      }
      
      long left = 0; 
      long right = max;
      
      long result = 0;
      while(left <= right){
          long mid = (left + right) / 2;
          long total = 0;
          for(int n=0; n<N; n++){
              if(mid < trees[n]) total += (trees[n] - mid);
          }
          
          if(total >= M) {
              result = mid;
              left = mid + 1;
          } else {
              right = mid - 1;
          }
      }
      
      System.out.println(result);
      br.close();

  }
}