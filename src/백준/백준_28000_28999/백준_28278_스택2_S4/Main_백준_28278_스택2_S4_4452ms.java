package 백준.백준_28000_28999.백준_28278_스택2_S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main_백준_28278_스택2_S4_4452ms {

    static List<Integer> stack = new LinkedList<>();

    static void push(int x){
        stack.add(x);
    }

    static void pop(){
        if(stack.size() > 0){
            int x = stack.get(stack.size()-1);
            stack.remove(stack.size()-1);
            System.out.println(x);
        }else{
            System.out.println(-1);
        }
    }

    static void size(){
        System.out.println(stack.size());
    }

    static void isEmpty(){
        if(stack.size() == 0){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }

    static void peek(){
        if(stack.size() == 0){
            System.out.println(-1);
        }else{
            System.out.println(stack.get(stack.size()-1));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            switch(input[0]) {
                case "1":
                    push(Integer.parseInt(input[1]));
                    break;
                case "2":
                    pop();
                    break;
                case "3":
                    size();
                    break;
                case "4":
                    isEmpty();
                    break;
                case "5":
                    peek();
                    break;
            }
        }
    }
}
