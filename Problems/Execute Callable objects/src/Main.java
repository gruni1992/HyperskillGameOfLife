import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


class FutureUtils {

    public static int executeCallableObjects(List<Future<Callable<Integer>>> items) {
        // write your code here
        List<Callable<Integer>> callables = new ArrayList<>();
        for(Future<Callable<Integer>> item : items) {
            try {
                callables.add(0, item.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        ExecutorService executor = Executors.newSingleThreadExecutor();
        int sum = 0;
        for(Callable<Integer> callable: callables) {
            Future<Integer> summand = executor.submit(callable);
            try {
                sum += summand.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
        return sum;
    }

}