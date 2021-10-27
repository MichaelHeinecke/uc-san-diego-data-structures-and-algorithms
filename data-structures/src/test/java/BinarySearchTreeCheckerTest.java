import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinarySearchTreeCheckerTest {
    @Test
    void testBinaryTree_IsBinarySearchTree1_ReturnsTrue() {
        BinarySearchTreeChecker.BinaryTree.Node[] tree = new BinarySearchTreeChecker.BinaryTree.Node[]{
                new BinarySearchTreeChecker.BinaryTree.Node(2, 1, 2),
                new BinarySearchTreeChecker.BinaryTree.Node(1, -1, -1),
                new BinarySearchTreeChecker.BinaryTree.Node(3, -1, -1)
        };

        BinarySearchTreeChecker.BinaryTree binaryTree = new BinarySearchTreeChecker.BinaryTree(tree);
        assertTrue(binaryTree.isBinarySearchTree());
    }

    @Test
    void testBinaryTree_IsBinarySearchTree2_ReturnsTrue() {
        BinarySearchTreeChecker.BinaryTree.Node[] tree = new BinarySearchTreeChecker.BinaryTree.Node[]{
                new BinarySearchTreeChecker.BinaryTree.Node(1, -1, 1),
                new BinarySearchTreeChecker.BinaryTree.Node(2, -1, 2),
                new BinarySearchTreeChecker.BinaryTree.Node(3, -1, 3),
                new BinarySearchTreeChecker.BinaryTree.Node(4, -1, 4),
                new BinarySearchTreeChecker.BinaryTree.Node(5, -1, -1)
        };

        BinarySearchTreeChecker.BinaryTree binaryTree = new BinarySearchTreeChecker.BinaryTree(tree);
        assertTrue(binaryTree.isBinarySearchTree());
    }

    @Test
    void testBinaryTree_IsBinarySearchTree3_ReturnsFalse() {
        BinarySearchTreeChecker.BinaryTree.Node[] tree = new BinarySearchTreeChecker.BinaryTree.Node[]{
                new BinarySearchTreeChecker.BinaryTree.Node(4, 1, -1),
                new BinarySearchTreeChecker.BinaryTree.Node(2, 2, 3),
                new BinarySearchTreeChecker.BinaryTree.Node(1, -1, -1),
                new BinarySearchTreeChecker.BinaryTree.Node(5, -1, -1),
        };

        BinarySearchTreeChecker.BinaryTree binaryTree = new BinarySearchTreeChecker.BinaryTree(tree);
        assertFalse(binaryTree.isBinarySearchTree());
    }

    @Test
    void testBinaryTree_IsBinarySearchTree4_ReturnsFalse() {
        BinarySearchTreeChecker.BinaryTree.Node[] tree = new BinarySearchTreeChecker.BinaryTree.Node[]{
                new BinarySearchTreeChecker.BinaryTree.Node(1, 1, 2),
                new BinarySearchTreeChecker.BinaryTree.Node(2, -1, -1),
                new BinarySearchTreeChecker.BinaryTree.Node(3, -1, -1),
        };

        BinarySearchTreeChecker.BinaryTree binaryTree = new BinarySearchTreeChecker.BinaryTree(tree);
        assertFalse(binaryTree.isBinarySearchTree());
    }
}
