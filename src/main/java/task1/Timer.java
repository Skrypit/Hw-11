package task1;

public class Timer {

    public static void main(String[] args) throws InterruptedException {

        Thread threadSeconds = new Thread() {
            @Override
            public synchronized void run() {
                while (!isInterrupted()) {
                    for (int i = 1; i < 100; i++) {

                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (!(i % 5 == 0)) {
                            System.out.println(i);
                        }
                    }
                }
            }
        };

        Thread fiveSecMess = new Thread() {
            @Override
            public synchronized void run() {
                while (!isInterrupted()) {
                    try {
                        Thread.sleep(5000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Пройшло 5 секунд");
                }
            }
        };

        threadSeconds.start();
        fiveSecMess.start();

        Thread.sleep(15000L);


        threadSeconds.interrupt();
        fiveSecMess.interrupt();
    }
}



