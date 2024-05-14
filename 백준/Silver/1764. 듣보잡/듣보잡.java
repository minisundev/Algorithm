import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int notHear = Integer.parseInt(st.nextToken());
        int notSee = Integer.parseInt(st.nextToken());

        Set<String> noHear = new HashSet<>();
        Set<String> noHearNoSee = new HashSet<>();

        for(int i=0;i<notHear;i++){
            noHear.add(br.readLine());
        }

        for(int i=0;i<notSee;i++){
            String s = br.readLine();
            if(noHear.contains(s)){
                noHearNoSee.add(s);
            }
        }

        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>(noHearNoSee);
        list.sort((o1,o2)->o1.compareTo(o2));

        sb.append(noHearNoSee.size());
        sb.append("\n");

        for(String s : list){//듣보잡의 수와 그 명단을 사전순으로 출력한다.
            sb.append(s);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}