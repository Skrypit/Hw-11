package task2;

import java.util.concurrent.atomic.AtomicBoolean;

public class FizzBuzz extends Thread {
    private int number;
    private AtomicBoolean processed = new AtomicBoolean(true);
    private ProcNumber processor;

    public FizzBuzz(ProcNumber processor) {
        this.processor = processor;
    }

    public void process(int number) {
        this.number = number;
        processed.set(false);
    }

    public boolean isProcessed() {
        return processed.get();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (processed.get()) {
                continue;
            }

            processor.process(number);

            processed.set(true);
        }

    }
}




