import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinarySearchTreeCheckerNonDistinctElementsTest {
    @Test
    void testBinaryTree_IsBinarySearchTree1_ReturnsTrue() {
        Map<Integer, int[]> tree = new HashMap<>() {{
            put(0, new int[]{2, 1, 2});
            put(1, new int[]{1, -1, -1});
            put(2, new int[]{3, -1, -1});
        }};

        BinarySearchTreeCheckerNonDistinctElements.BinaryTree binaryTree = new BinarySearchTreeCheckerNonDistinctElements.BinaryTree(tree);
        assertTrue(binaryTree.isBinarySearchTree());
    }

    @Test
    void testBinaryTree_IsBinarySearchTree2_ReturnsTrue() {
        Map<Integer, int[]> tree = new HashMap<>() {{
            put(0, new int[]{1, -1, 1});
            put(1, new int[]{2, -1, 2});
            put(2, new int[]{3, -1, 3});
            put(3, new int[]{4, -1, 4});
            put(4, new int[]{5, -1, -1});
        }};

        BinarySearchTreeCheckerNonDistinctElements.BinaryTree binaryTree = new BinarySearchTreeCheckerNonDistinctElements.BinaryTree(tree);
        assertTrue(binaryTree.isBinarySearchTree());
    }

    @Test
    void testBinaryTree_IsBinarySearchTree3_ReturnsFalse() {
        Map<Integer, int[]> tree = new HashMap<>() {{
            put(0, new int[]{4, 1, -1});
            put(1, new int[]{2, 2, 3});
            put(2, new int[]{1, -1, -1});
            put(3, new int[]{5, -1, -1});
        }};

        BinarySearchTreeCheckerNonDistinctElements.BinaryTree binaryTree = new BinarySearchTreeCheckerNonDistinctElements.BinaryTree(tree);
        assertFalse(binaryTree.isBinarySearchTree());
    }

    @Test
    void testBinaryTree_IsBinarySearchTree4_ReturnsFalse() {
        Map<Integer, int[]> tree = new HashMap<>() {{
            put(0, new int[]{1, 1, 2});
            put(1, new int[]{2, -1, -1});
            put(2, new int[]{3, -1, -1});
        }};

        BinarySearchTreeCheckerNonDistinctElements.BinaryTree binaryTree = new BinarySearchTreeCheckerNonDistinctElements.BinaryTree(tree);
        assertFalse(binaryTree.isBinarySearchTree());
    }

    @Test
    void testBinaryTree_IsBinarySearchTree_NonDistinctElements_ReturnsTrue() {
        Map<Integer, int[]> tree = new HashMap<>() {{
            put(0, new int[]{2, 1, 2});
            put(1, new int[]{1, -1, -1});
            put(2, new int[]{2, -1, -1});
        }};

        BinarySearchTreeCheckerNonDistinctElements.BinaryTree binaryTree = new BinarySearchTreeCheckerNonDistinctElements.BinaryTree(tree);
        assertTrue(binaryTree.isBinarySearchTree());
    }

    @Test
    void testBinaryTree_IsBinarySearchTree_NonDistinctElements2_ReturnsFalse() {
        Map<Integer, int[]> tree = new HashMap<>() {{
            put(0, new int[]{2, 1, 2});
            put(1, new int[]{2, -1, -1});
            put(2, new int[]{3, -1, -1});
        }};

        BinarySearchTreeCheckerNonDistinctElements.BinaryTree binaryTree = new BinarySearchTreeCheckerNonDistinctElements.BinaryTree(tree);
        assertFalse(binaryTree.isBinarySearchTree());
    }

    @Test
    void testBinaryTree_IsBinarySearchTree_NonDistinctElements3_ReturnsTrue() {
        Map<Integer, int[]> tree = new HashMap<>() {{
            put(0, new int[]{1, -1, 1});
            put(1, new int[]{2, -1, 2});
            put(2, new int[]{2, -1, 3});
            put(3, new int[]{2, -1, 4});
            put(4, new int[]{2, -1, -1});
        }};

        BinarySearchTreeCheckerNonDistinctElements.BinaryTree binaryTree = new BinarySearchTreeCheckerNonDistinctElements.BinaryTree(tree);
        assertTrue(binaryTree.isBinarySearchTree());
    }

    @Test
    void testBinaryTree_IsBinarySearchTree_NonDistinctElements3_ReturnsFalse() {
        Map<Integer, int[]> tree = new HashMap<>() {{
            put(0, new int[]{1, -1, 1});
            put(1, new int[]{2, -1, 2});
            put(2, new int[]{2, -1, 3});
            put(3, new int[]{2, 4, 5});
            put(4, new int[]{2, -1, -1});
            put(5, new int[]{2, -1, -1});
        }};

        BinarySearchTreeCheckerNonDistinctElements.BinaryTree binaryTree = new BinarySearchTreeCheckerNonDistinctElements.BinaryTree(tree);
        assertFalse(binaryTree.isBinarySearchTree());
    }

    @Test
    void testBinaryTree_IsBinarySearchTree_NonDistinctElements_IntegerMinMax_ReturnsTrue() {
        Map<Integer, int[]> tree = new HashMap<>() {{
            put(0, new int[]{1, 1, 2});
            put(1, new int[]{Integer.MIN_VALUE, -1, -1});
            put(2, new int[]{Integer.MAX_VALUE, -1, 3});
            put(3, new int[]{Integer.MAX_VALUE, -1, -1});
        }};

        BinarySearchTreeCheckerNonDistinctElements.BinaryTree binaryTree = new BinarySearchTreeCheckerNonDistinctElements.BinaryTree(tree);
        assertTrue(binaryTree.isBinarySearchTree());
    }

    @Test
    void testBinaryTree_IsBinarySearchTree_NonDistinctElements5_RightSubtreeContainsSameValueGrandchild_ReturnsTrue() {
        Map<Integer, int[]> tree = new HashMap<>() {{
            put(0, new int[]{4, -1, 1});
            put(1, new int[]{6, 2, 3});
            put(2, new int[]{4, -1, -1});
            put(3, new int[]{7, -1, -1});
        }};

        BinarySearchTreeCheckerNonDistinctElements.BinaryTree binaryTree = new BinarySearchTreeCheckerNonDistinctElements.BinaryTree(tree);
        assertTrue(binaryTree.isBinarySearchTree());
    }

    @Test
    void testBinaryTree_IsBinarySearchTree_SingleNode_ReturnsTrue() {
        Map<Integer, int[]> tree = new HashMap<>() {{
            put(0, new int[]{Integer.MAX_VALUE, -1, -1});
        }};

        BinarySearchTreeCheckerNonDistinctElements.BinaryTree binaryTree = new BinarySearchTreeCheckerNonDistinctElements.BinaryTree(tree);
        assertTrue(binaryTree.isBinarySearchTree());
    }
}
