package 백준.백준_11000_11999.백준_11689_GCDnk1_G1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// phi
public class Main_백준_11689_GCDnk1_G1_112ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		
		long cnt = N;
	    long K = N;
	    
	    for (long i=2; i*i <= K; i++) {
	        if (K % i == 0) {
	        	cnt -= cnt / i; 
	            while (K % i == 0) K /= i;
	        }
	    }
	    
	    if (K > 1) {
	    	cnt -= cnt / K;
	    }

	    System.out.println(cnt);
		br.close();
	}

}
