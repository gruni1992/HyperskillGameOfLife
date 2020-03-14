import java.util.*;
import java.util.concurrent.*;


class FutureUtils {

    public static int howManyIsDone(List<Future> items) {
        // write your code here
        int result = 0;
        for(Future future : items) {
            result += future.isDone() ? 1 : 0;
        }
        return result;
    }

}