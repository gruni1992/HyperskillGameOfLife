import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        LocalTime t1s = LocalTime.parse(scanner.next());
        LocalTime t1e = LocalTime.parse(scanner.next());
        LocalTime t2s = LocalTime.parse(scanner.next());
        LocalTime t2e = LocalTime.parse(scanner.next());
        System.out.println(intersect(t1s, t1e, t2s, t2e));
    }

    static boolean intersect(LocalTime t1s, LocalTime t1e, LocalTime t2s, LocalTime t2e){
        for (LocalTime time = t1s; time.isBefore(t1e) || time.equals(t1e); time.plusMinutes(1)) {
            if(time.equals(t2s) || time.equals(t2e) ||
                    time.isAfter(t2s) && time.isBefore(t2e)) {
                return true;
            }
            time = time.plusMinutes(1);
        }
        return false;
    }
}