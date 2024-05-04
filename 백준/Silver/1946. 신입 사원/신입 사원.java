import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int [] results = new int[t];

        Score [] scores;

        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            scores = new Score [n];

            for(int j=0; j<n; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int resume = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                scores[j] = new Score(resume,interview);
            }

            Arrays.sort(scores,(o1,o2)->o1.resume-o2.resume);

            int cutline = scores[0].interview;
            int count = 1;
            //서류점수 기준으로 봄
            for(int j=1; j<scores.length; j++){
                if(scores[j].interview < cutline){
                    count++;
                    cutline = scores[j].interview;
                }
            }

            results[i] = count;
        }

        for(int i : results){
            System.out.println(i);
        }
    }
}

class Score{
    public int resume;
    public int interview;

    public Score(int r, int i){
        resume = r;
        interview = i;
    }
}