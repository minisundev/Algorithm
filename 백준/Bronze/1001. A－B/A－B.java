import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String [] array = s.split(" ");
        System.out.println(Integer.parseInt(array[0])-Integer.parseInt(array[1]));
	}
}