import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb;
    static String[] poliomino;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String board = br.readLine();
        //겹침없이 덮어야만 한다
        poliomino = new String[2];
        poliomino[0] = "AAAA";
        poliomino[1] = "BB";

        sb = new StringBuilder();
        int start = 0;
        int end = 0;
        boolean valid = false;

        for (int i = 0; i < board.length(); i++) {
            if (!valid && board.charAt(i) == 'X') {
                valid = true;
                start = i;
            }
            if (valid && (i == board.length() - 1 || board.charAt(i) == '.')) {
                end = (board.charAt(i) == '.') ? i - 1 : i;
                if (!fill(end, start)) {
                    break;
                }
                valid = false;
            }
            if (board.charAt(i) == '.') {
                sb.append('.');
            }
        }
        System.out.println(sb);
    }

    static boolean fill(int end, int start) {
        int length = end - start +1;
        for (int j = 0; j < poliomino.length; j++) {
            int count = length / poliomino[j].length();
            length = length % poliomino[j].length();
            sb.append(poliomino[j].repeat(count));
        }
        if (length != 0) {
            sb = new StringBuilder("-1");
            return false;
        }
        return true;
    }
}