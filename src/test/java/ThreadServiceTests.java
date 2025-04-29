import org.example.service.ThreadService;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThreadServiceTests {
    @Test
    public void TestManyThreadsCallUnSafeCounter() throws InterruptedException {
        int numberOfThreads = 50;

        int expectedCount = 50;

        ThreadService threadService = new ThreadService();
        int actualCount = threadService.manyThreadsCallUnSafeCounter(numberOfThreads);

        assertEquals(expectedCount,actualCount);
    }

    @Test
    public void TestOneThreadCallsSafeCounterManyTimes() throws InterruptedException {
        int times = 1000;

        AtomicInteger expectedCount = new AtomicInteger(1000);

        ThreadService threadService = new ThreadService();
        AtomicInteger actualCount = threadService.oneThreadCallsSafeCounterManyTimes(1000);

        assertEquals(expectedCount.get(),actualCount.get());
    }
}
