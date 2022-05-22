package task1;

public class Timer {

    public void startTimer() {
        Thread fiveSeconds = new Thread(() -> {
            while (true) {
                try {
                    synchronized (Thread.currentThread()) {
                        Thread.currentThread().wait();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Пройшло 5 секунд");
            }
        });

        Thread timer = new Thread(() -> {
            while (true) {

                for (int i = 1; i < 60; i++) {

                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (fiveSeconds) {
                        if (!(i % 5 == 0)) {
                            System.out.println(i);
                        } else {
                            fiveSeconds.notifyAll();
                        }
                    }
                }
            }
        });

        timer.start();
        fiveSeconds.start();
    }
}


