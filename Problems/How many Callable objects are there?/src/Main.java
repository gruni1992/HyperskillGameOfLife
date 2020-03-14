import java.util.concurrent.*;


class FutureUtils {

    public static int determineCallableDepth(Callable callable) throws Exception {
        // write your code here
        ExecutorService executor = Executors.newSingleThreadExecutor();
        int result = 1;
        while(true){
            Future<Object> future = executor.submit(callable);
            Object obj = future.get();
            if(obj instanceof  Callable) {
                result++;
                callable = (Callable) obj;
            } else {
                break;
            }
        }
        executor.shutdown();
        return result;
    }

}