import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.lang.Math;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String [] alps = new String[n];

        Map<Character,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            String s = br.readLine();
            alps[i] = s;
            for(int j=0; j<s.length(); j++){
                char c = s.charAt(j);
                int num = map.getOrDefault(c,0);
                num += Math.pow(10,s.length()-j-1);
                map.put(c,num);
            }
        }

        List<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list,(o1,o2)->o2.getValue()-o1.getValue());//내림차순 정렬

        int sum = 0;
        int number = 9;
        //어느 char에 어느 숫자 매핑할건지
        for(Map.Entry<Character,Integer> entry : list){
            sum += entry.getValue()*number;
            number--;
        }
        System.out.println(sum);
    }
}