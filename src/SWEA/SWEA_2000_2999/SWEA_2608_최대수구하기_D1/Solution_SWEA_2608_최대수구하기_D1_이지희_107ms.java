package SWEA.SWEA_2000_2999.SWEA_2608_최대수구하기_D1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_2608_최대수구하기_D1_이지희_107ms {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int t=1; t<=T; t++) {
            int[] numbers = new int[10];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<10; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(numbers);
            System.out.println("#"+t+" "+numbers[9]);
        }

        br.close();
    }
}