import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;


class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime dateTime = LocalDateTime.parse(scanner.nextLine());
        LocalDateTime start = LocalDateTime.of(dateTime.getYear(), 1, 1, 0, 0);
        System.out.println(start.until(dateTime, ChronoUnit.HOURS));
    }
}