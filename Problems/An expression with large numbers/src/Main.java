import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");

        BigInteger a = new BigInteger(strings[0]);
        BigInteger b = new BigInteger(strings[1]);
        BigInteger c = new BigInteger(strings[2]);
        BigInteger d = new BigInteger(strings[3]);

        System.out.println(a.negate().multiply(b).add(c).subtract(d));
    }
}