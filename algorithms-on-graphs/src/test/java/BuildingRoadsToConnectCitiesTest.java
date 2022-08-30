import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuildingRoadsToConnectCitiesTest {

    @Test
    void whenPointsAreProvided_ReturnMinimumCost1() {
        int[] x = new int[] {0, 0, 1, 1};
        int[] y = new int[] {0, 1, 0, 1};

        double expectedResult = 3.000000000;

        assertEquals(expectedResult, BuildingRoadsToConnectCities.calculateMinimumDistance(x, y), Math.pow(10, -6));
    }

    @Test
    void whenPointsAreProvided_ReturnMinimumCost2() {
        int[] x = new int[] {0, 0, 1, 3, 3};
        int[] y = new int[] {0, 2, 1, 0, 2};

        double expectedResult = 7.064495102;

        assertEquals(expectedResult, BuildingRoadsToConnectCities.calculateMinimumDistance(x, y), Math.pow(10, -6));
    }

}
