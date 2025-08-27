package 백준.백준_2000_2999.백준_2154_수이어쓰기3_B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_2154_수이어쓰기3_B2_196ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int l = N.length();

        StringBuilder sb = new StringBuilder();
        long n = 0;
        long totalLen = 0; 

        while (true) {
            String cur = Long.toString(++n);
            sb.append(cur);
            totalLen += cur.length();

            if (sb.length() >= l) {
                int idx = sb.indexOf(N);
                if (idx != -1) {
                    long pos = totalLen - sb.length() + idx + 1;
                    System.out.println(pos);
                    break;
                }
                if (sb.length() > l * 2) {
                    sb.delete(0, sb.length() - l * 2);
                }
            }
        }
    }
}
