import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CodeBracketCheckTest {
    @Test
    void checkIfBracketsAreBalanced_InputPairOfBalancedBrackets_Returns0() {
        assertEquals(0, CodeBracketCheck.checkIfBracketsAreBalanced("[]"));
    }

    @Test
    void checkIfBracketsAreBalanced_InputTwoPairsOfBalancedBrackets_Returns0() {
        assertEquals(0, CodeBracketCheck.checkIfBracketsAreBalanced("[]{}"));
    }

    @Test
    void checkIfBracketsAreBalanced_InputTwoPairsOfNestedBalancedBrackets_Returns0() {
        assertEquals(0, CodeBracketCheck.checkIfBracketsAreBalanced("[{}]"));
    }

    @Test
    void checkIfBracketsAreBalanced_InputTwoEqualPairsOfNestedBalancedBrackets_Returns0() {
        assertEquals(0, CodeBracketCheck.checkIfBracketsAreBalanced("[[]]"));
    }

    @Test
    void checkIfBracketsAreBalanced_InputTwoEqualPairsOfNestedBalancedBracketsAndPairOfBrackets_Returns0() {
        assertEquals(0, CodeBracketCheck.checkIfBracketsAreBalanced("[[]]()"));
    }

    @Test
    void checkIfBracketsAreBalanced_InputSingleBracket_Returns1() {
        assertEquals(1, CodeBracketCheck.checkIfBracketsAreBalanced("["));
    }

    @Test
    void checkIfBracketsAreBalanced_InputSingleNestedBracket_Returns3() {
        assertEquals(3, CodeBracketCheck.checkIfBracketsAreBalanced("([)"));
    }

    @Test
    void checkIfBracketsAreBalanced_InputCodeWithBalancedBrackets_Returns0() {
        assertEquals(0, CodeBracketCheck.checkIfBracketsAreBalanced("foo(bar)"));
    }

    @Test
    void checkIfBracketsAreBalanced_InputCodeWithUnbalancedBrackets_Returns10() {
        assertEquals(10, CodeBracketCheck.checkIfBracketsAreBalanced("foo(bar[i)"));
    }
}
