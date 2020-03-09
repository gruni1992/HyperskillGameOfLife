import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        LocalDate date = LocalDate.parse(scanner.next());
        int n = scanner.nextInt();
        System.out.println(date.plusDays(n).getDayOfYear() == 1);
    }
}