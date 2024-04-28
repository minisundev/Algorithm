import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());//베라의 상하의 개수

        int result = n*(n-1);//상의 기준으로 색이 같은 하의 제외하고 곱해준 경우의 수 : 상의 x 하의-1
        System.out.println(result);

    }
}