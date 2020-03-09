import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime result = LocalDateTime.MIN;
        int length = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < length; i++) {
            LocalDateTime dateTime = LocalDateTime.parse(scanner.nextLine());
            if(dateTime.isAfter(result)){
                result = dateTime;
            }
        }
        System.out.println(result);
    }
}