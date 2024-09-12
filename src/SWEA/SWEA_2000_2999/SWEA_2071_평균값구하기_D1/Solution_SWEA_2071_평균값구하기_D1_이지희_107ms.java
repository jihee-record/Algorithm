package SWEA.SWEA_2000_2999.SWEA_2071_평균값구하기_D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_SWEA_2071_평균값구하기_D1_이지희_107ms {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            String[] numbers = br.readLine().split(" ");
            int sum=0;
            for(int i=0; i<10; i++) {
                sum += Integer.parseInt(numbers[i]);
            }
            int result = Math.round((float)sum/10);
            System.out.println("#"+t + " " + result);
        }

        br.close();
    }
}