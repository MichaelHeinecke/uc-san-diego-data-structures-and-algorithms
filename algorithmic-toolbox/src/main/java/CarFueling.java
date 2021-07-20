import java.util.Scanner;

public class CarFueling {
    static final Scanner sc = new Scanner(System.in);

    public static int calculateMinimumNumberOfFuelingStops(int distanceToCover, int range,
                                                           int[] distanceBetweenGasStations) {
        int numberOfRefills = 0;
        int currentRefill = 0;
        int[] distanceBetweenStops = new int[distanceBetweenGasStations.length + 2];
        System.arraycopy(distanceBetweenGasStations, 0, distanceBetweenStops, 1,
                distanceBetweenGasStations.length);
        distanceBetweenStops[distanceBetweenStops.length - 1] = distanceToCover;

        int lastRefill;
        while (currentRefill <= distanceBetweenStops.length - 2) {
            lastRefill = currentRefill;
            while (currentRefill <= distanceBetweenStops.length - 2
                    && distanceBetweenStops[currentRefill + 1] - distanceBetweenStops[lastRefill] <= range) {
                currentRefill++;
            }

            if (currentRefill == lastRefill) {
                return -1;
            } else if (currentRefill <= distanceBetweenStops.length - 2) {
                numberOfRefills++;
            }
        }
        return numberOfRefills;
    }

    public static void main(String[] args) {
        int distanceToCover = sc.nextInt();
        int range = sc.nextInt();
        int numberOfGasStations = sc.nextInt();
        int[] distanceBetweenGasStations = new int[numberOfGasStations];

        for (int i = 0; i < numberOfGasStations; i++) {
            distanceBetweenGasStations[i] = sc.nextInt();
        }

        System.out.println(calculateMinimumNumberOfFuelingStops(distanceToCover, range, distanceBetweenGasStations));
    }
}
