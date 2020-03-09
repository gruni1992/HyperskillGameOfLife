import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());
        double c = Double.parseDouble(scanner.nextLine());

        double p = b/a;
        double q = c/a;

        double x1 = -(p / 2) + Math.sqrt(Math.pow(p / 2, 2) - q);
        double x2 = -(p / 2) - Math.sqrt(Math.pow(p / 2, 2) - q);

        System.out.println(Math.min(x1, x2));
        System.out.println(Math.max(x1, x2));
    }
}