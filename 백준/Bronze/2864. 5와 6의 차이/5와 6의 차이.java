import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        String minA = a.replace("6","5");
        String maxA = a.replace("5","6");

        String minB = b.replace("6","5");
        String maxB = b.replace("5","6");

        System.out.println((Integer.parseInt(minA)+Integer.parseInt(minB))+" "+(Integer.parseInt(maxA)+Integer.parseInt(maxB)));

    }

}