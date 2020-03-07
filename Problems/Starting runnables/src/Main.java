//class Main {
    public static void startRunnables(Runnable[] runnables) {
        for (Runnable runnable : runnables) {
            Thread t = new Thread(runnable);
            t.start();
        }
    }
//}