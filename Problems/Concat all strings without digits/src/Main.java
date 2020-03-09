import java.util.Scanner;
import java.util.stream.Stream;

class ConcatenateStringsProblem {

    public static String concatenateStringsWithoutDigits(String[] strings) {
        // write your code with StringBuilder here
        StringBuilder result = new StringBuilder();
        for (String str : strings){
            for (char c : str.toCharArray()) {
                if(!Character.isDigit(c)){
                    result.append(c);
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = Stream
                .of(scanner.nextLine().split("\\s+"))
                .toArray(String[]::new);

        String result = concatenateStringsWithoutDigits(strings);

        System.out.println(result);
    }
}