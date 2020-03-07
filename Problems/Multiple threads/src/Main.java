public class Main {

    public static void main(String[] args) {

        // create instances and start threads here
        Thread t1 = new WorkerThread();
        Thread t2 = new WorkerThread();
        t1.setName("worker-1");
        t2.setName("worker-2");
        t1.start();
        t2.start();
    }
}

/*
class WorkerThread extends Thread {

    @Override
    public void run() {
        // the method does something
    }
}
*/