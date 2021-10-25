import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class JobQueue {
    private int numWorkers;
    private int[] jobs;

    private int[] assignedWorker;
    private long[] startTime;

    private FastScanner in;
    private PrintWriter out;

    JobQueue() {
    }

    JobQueue(int numWorkers, int[] jobs) {
        this.numWorkers = numWorkers;
        this.jobs = jobs;
    }

    public static void main(String[] args) throws IOException {
        new JobQueue().solve();
    }

    public int[] getAssignedWorker() {
        return assignedWorker;
    }

    public long[] getStartTime() {
        return startTime;
    }

    private void readData() throws IOException {
        numWorkers = in.nextInt();
        int numberOfJobs = in.nextInt();
        jobs = new int[numberOfJobs];
        for (int i = 0; i < numberOfJobs; ++i) {
            jobs[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        for (int i = 0; i < jobs.length; ++i) {
            out.println(assignedWorker[i] + " " + startTime[i]);
        }
    }

    void assignJobs() {
        assignedWorker = new int[jobs.length];
        startTime = new long[jobs.length];
        Queue<Worker> workerQueue = new PriorityQueue<>();

        // add workers to priority queue; comparison is based on release time and worker ID
        for (int workerId = 0; workerId < numWorkers; workerId++) {
            workerQueue.add(new Worker(workerId));
        }

        for (int jobId = 0; jobId < jobs.length; jobId++) {
            Worker worker = workerQueue.poll();

            assignedWorker[jobId] = worker.getWorkerId();
            startTime[jobId] = worker.getReleaseTime();

            long jobDuration = jobs[jobId];
            worker.setReleaseTime(worker.getReleaseTime() + jobDuration);

            workerQueue.add(worker);
        }

    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        assignJobs();
        writeResponse();
        out.close();
    }

    static class Worker implements Comparable<Worker> {
        int workerId;
        long releaseTime;

        int getWorkerId () {
            return workerId;
        }

        long getReleaseTime () {
            return releaseTime;
        }

        void setReleaseTime (long releaseTime) {
            this.releaseTime = releaseTime;
        }

        Worker(int workerId) {
            this.workerId = workerId;
            this.releaseTime = 0;
        }

        @Override
        public int compareTo(Worker o) {
            if (this.releaseTime < o.releaseTime) {
                return -1;
            } else if (this.releaseTime > o.releaseTime) {
                return 1;
            } else return Integer.compare(this.workerId, o.workerId);
        }
    }

    static class FastScanner {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
