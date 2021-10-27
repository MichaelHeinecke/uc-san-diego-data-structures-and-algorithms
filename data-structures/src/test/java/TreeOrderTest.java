import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.List;

import org.junit.jupiter.api.Test;


public class TreeOrderTest {
    @Test
    void testInOrderTraversal() {
        int n = 5;
        int[] key = new int[]{4, 2, 5, 1, 3};
        int[] left = new int[]{1, 3, -1, -1, -1};
        int[] right = new int[]{2, 4, -1, -1, -1};

        int[] expectedResult = new int[]{1, 2, 3, 4, 5};

        TreeOrder.TreeOrders treeOrders = new TreeOrder.TreeOrders(n, key, left, right);
        List<Integer> result = treeOrders.inOrder();

        assertArrayEquals(expectedResult, result.stream().mapToInt(i -> i).toArray());
    }

    @Test
    void testPreOrderTraversal() {
        int n = 5;
        int[] key = new int[]{4, 2, 5, 1, 3};
        int[] left = new int[]{1, 3, -1, -1, -1};
        int[] right = new int[]{2, 4, -1, -1, -1};

        int[] expectedResult = new int[]{4, 2, 1, 3, 5};

        TreeOrder.TreeOrders treeOrders = new TreeOrder.TreeOrders(n, key, left, right);
        List<Integer> result = treeOrders.preOrder();

        assertArrayEquals(expectedResult, result.stream().mapToInt(i -> i).toArray());
    }

    @Test
    void testPostOrderTraversal() {
        int n = 5;
        int[] key = new int[]{4, 2, 5, 1, 3};
        int[] left = new int[]{1, 3, -1, -1, -1};
        int[] right = new int[]{2, 4, -1, -1, -1};

        int[] expectedResult = new int[]{1, 3, 2, 5, 4};

        TreeOrder.TreeOrders treeOrders = new TreeOrder.TreeOrders(n, key, left, right);
        List<Integer> result = treeOrders.postOrder();

        assertArrayEquals(expectedResult, result.stream().mapToInt(i -> i).toArray());
    }
}
