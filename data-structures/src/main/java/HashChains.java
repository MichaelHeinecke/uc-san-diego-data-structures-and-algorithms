import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class HashChains {

    private FastScanner in;
    private PrintWriter out;
    // store all strings in one list
//    private List<String> elems;

    public static void main(String[] args) throws IOException {
        new HashChains().processQueries();
    }

    private Query readQuery() throws IOException {
        String type = in.next();
        if (!type.equals("check")) {
            String s = in.next();
            return new Query(type, s);
        } else {
            int ind = in.nextInt();
            return new Query(type, ind);
        }
    }

    private void processQuery(Query query, HashTable hashTable) {
        switch (query.type) {
            case "add":
                hashTable.add(query.string);
                break;
            case "del":
                hashTable.del(query.string);
                break;
            case "find":
                hashTable.find(query.string);
                break;
            case "check":
                hashTable.check(query.index);
                // Uncomment the following if you want to play with the program interactively.
                 out.flush();
                break;
            default:
                throw new RuntimeException("Unknown query: " + query.type);
        }
    }

    public void processQueries() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int bucketCount = in.nextInt();
        HashTable hashTable = new HashTable(bucketCount);
        int queryCount = in.nextInt();
        for (int i = 0; i < queryCount; ++i) {
            processQuery(readQuery(), hashTable);
        }
        out.close();
    }

    static class HashTable {
        private final int bucketCount;
        private List<LinkedList<String>> hashList;

        HashTable(int bucketCount) {
            this.bucketCount = bucketCount;
            this.hashList = new ArrayList<>(bucketCount);
            for (int i = 0; i < bucketCount; i++) {
                hashList.add(new LinkedList<>());
            }
        }

        private int hashFunc(String s) {
            long hash = 0;
            int prime = 1000000007;
            int multiplier = 263;
            for (int i = s.length() - 1; i >= 0; --i)
                hash = (hash * multiplier + s.charAt(i)) % prime;
            return (int) hash % bucketCount;
        }

        void find(String element) {
            int keyHash = hashFunc(element);
            List<String> list = hashList.get(keyHash);
            System.out.println(list.contains(element) ? "yes" : "no");
        }

        void add(String element) {
            int elementHash = hashFunc(element);
            LinkedList<String> list = hashList.get(elementHash);
            // only add element if not present yet
            if (!list.contains(element)) {
                list.addFirst(element);
                hashList.set(elementHash, list);
            }
        }

        void del(String element) {
            int elementHash = hashFunc(element);
            LinkedList<String> list = hashList.get(elementHash);
            list.remove(element);
            hashList.set(elementHash, list);
        }

        void check(int index) {
            LinkedList<String> list = hashList.get(index);
            System.out.println(String.join(" ", list));
        }
    }

    static class Query {
        String type;
        String string;
        int index;

        public Query(String type, String string) {
            this.type = type;
            this.string = string;
        }

        public Query(String type, int index) {
            this.type = type;
            this.index = index;
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
