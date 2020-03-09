import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalTime t1 = LocalTime.parse(scanner.nextLine());
        LocalTime t2 = LocalTime.parse(scanner.nextLine());
        int result = Math.abs(t1.toSecondOfDay() - t2.toSecondOfDay());
        System.out.println(result);
    }
}