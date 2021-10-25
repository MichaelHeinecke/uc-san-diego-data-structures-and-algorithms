import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class JobQueueTest {
    @Test
    public void testAssignJobs_TwoWorkers_SimpleInput() {
        int numberOfWorkers = 2;
        int[] jobs = new int[]{1, 2, 3, 4, 5};

        JobQueue jobQueue = new JobQueue(numberOfWorkers, jobs);
        jobQueue.assignJobs();

        int[] assignedWorkerResult = jobQueue.getAssignedWorker();
        long[] startTimeResult = jobQueue.getStartTime();

        int[] assignedWorkerExpectedResult = new int[]{0, 1, 0, 1, 0};
        long[] startTimeExpectedResult = new long[]{0, 0, 1, 2, 4};

        assertArrayEquals(assignedWorkerExpectedResult, assignedWorkerResult);
        assertArrayEquals(startTimeExpectedResult, startTimeResult);
    }

    @Test
    public void testAssignJobs_FourWorkers_BatchesOfFour() {
        int numberOfWorkers = 4;
        int[] jobs = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        JobQueue jobQueue = new JobQueue(numberOfWorkers, jobs);
        jobQueue.assignJobs();

        int[] assignedWorkerResult = jobQueue.getAssignedWorker();
        long[] startTimeResult = jobQueue.getStartTime();

        int[] assignedWorkerExpectedResult = new int[]{0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3,};
        long[] startTimeExpectedResult = new long[]{0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4};

        assertArrayEquals(assignedWorkerExpectedResult, assignedWorkerResult);
        assertArrayEquals(startTimeExpectedResult, startTimeResult);
    }
}
