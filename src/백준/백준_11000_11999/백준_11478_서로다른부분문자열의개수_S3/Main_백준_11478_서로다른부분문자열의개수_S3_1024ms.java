package 백준.백준_11000_11999.백준_11478_서로다른부분문자열의개수_S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main_백준_11478_서로다른부분문자열의개수_S3_1024ms {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        HashSet<String> hash = new HashSet<>();

        int l = str.length();
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j <= l; j++) {
                hash.add(str.substring(i, j));
            }
        }

        System.out.println(hash.size());
        br.close();
    }
}

