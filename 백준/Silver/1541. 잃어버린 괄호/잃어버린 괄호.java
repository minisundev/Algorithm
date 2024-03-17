import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> sign;
    static ArrayList<Integer> number;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String st = br.readLine();
        sign = new ArrayList<>();
        number= new ArrayList<>();

        if(st.charAt(0)!='-'){
            sign.add(1);
        }

        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < st.length(); i++) {
            char c = st.charAt(i);
            if(c=='-'){
                if(!temp.toString().equals("")){
                    number.add(Integer.parseInt(temp.toString()));
                    temp = new StringBuilder();
                }
                sign.add(-1);
            }else if(c=='+'){
                if(!temp.toString().equals("")){
                    number.add(Integer.parseInt(temp.toString()));
                    temp = new StringBuilder();
                }
                sign.add(1);
            }else{//숫자인 경우
                temp.append(c);
            }
        }
        number.add(Integer.parseInt(temp.toString()));

        int sum = 0;
        int subsum = 0;
        boolean minus = false;

        for (int i = 0; i < number.size(); i++) {
            int s = sign.get(i);
            int n = number.get(i);

            if(s==-1){
                if(minus){
                    sum -= subsum;
                }else{
                    minus = true;
                }
                subsum = n;
            }else{// if(s==1)
                if(minus){
                    subsum += n;
                }else{
                    sum = sum +n;
                }
            }
        }

        if(minus){
            sum -= subsum;
        }

        System.out.println(sum);

    }

}